package com.example.pemesanerte.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pemesanerte.R;
import com.example.pemesanerte.SessionManager;
import com.example.pemesanerte.adapter.HistoryAdapter;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.history.History;
import com.example.pemesanerte.model.history.HistoryData;
//import com.example.pemesanerte.model.history.HistoryOld;
//import com.example.pemesanerte.model.history.HistoryDataOld;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity {
    private RecyclerView rvHistory;
    private List<HistoryData> listData = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    SessionManager sessionManager;
    String idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        rvHistory = findViewById(R.id.rv_history);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        progressBar = findViewById(R.id.progress_bar);

        sessionManager = new SessionManager(MyOrderActivity.this);
        idUser = sessionManager.getUserDetail().get(SessionManager.ID_PEMESAN);

        showRecyclerList(idUser);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showRecyclerList(idUser);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_my_order);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        startActivity(new Intent(MyOrderActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_my_order:
                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(MyOrderActivity.this, AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void showRecyclerList(String idUser) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<History> historyCall = apiInterface.historyResponse(idUser);
        historyCall.enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvHistory.setLayoutManager(new LinearLayoutManager(MyOrderActivity.this));
                    String message = response.body().getMessage();
//                    Toast.makeText(MyOrderActivity.this, message, Toast.LENGTH_SHORT).show();
                    listData = response.body().getData();

                    final HistoryAdapter historyAdapter = new HistoryAdapter(MyOrderActivity.this, listData);
                    rvHistory.setAdapter(historyAdapter);
                    historyAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);

                    historyAdapter.setOnItemClickCallback(new HistoryAdapter.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(HistoryData data) {
                            Intent detailHistoryIntent = new Intent(MyOrderActivity.this, DetailOrderActivity.class);
                            detailHistoryIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
                            startActivity(detailHistoryIntent);
                        }

//                        @Override
//                        public void onItemClicked(HistoryData data) {
//                            Intent detailHistoryIntent = new Intent(MyOrderActivity.this, DetailOrderActivity.class);
//                            detailHistoryIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
//                            startActivity(detailHistoryIntent);
//                        }
                    });

                }else{
                    String message = response.body().getMessage();
                    Toast.makeText(MyOrderActivity.this, message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<History> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MyOrderActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}