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
import com.example.pemesanerte.adapter.SearchAdapter;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.search.InputSearch;
import com.example.pemesanerte.model.search.Search;
import com.example.pemesanerte.model.search.SearchData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SelectTripActivity extends AppCompatActivity {
    private RecyclerView rvSelectTrip;
    private List<SearchData> list = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    public static final String EXTRA_INPUT_SEARCH = "extra_input_search";

//    TextView tvFrom, tvTo, tvDate, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trip);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("Select Trip");
//        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Select Trip</font>"));

//        tvFrom = findViewById(R.id.tv_select_from);
//        tvTo = findViewById(R.id.tv_select_to);
//        tvDate = findViewById(R.id.tv_select_tanggal);
//        tvTotal = findViewById(R.id.tv_select_jumlah);

        InputSearch inputSearch = getIntent().getParcelableExtra(EXTRA_INPUT_SEARCH);
//        tvFrom.setText(inputSearch.getFrom());
//        tvTo.setText(inputSearch.getTo());
//        tvDate.setText(inputSearch.getDate());
//        tvTotal.setText(inputSearch.getTotal() + " Passenger(s)");

        String Asal = inputSearch.getFrom();
        String Tujuan = inputSearch.getTo();
        String Tanggal = inputSearch.getDate();
        String JumlahPenumpang = inputSearch.getTotal();
        String Pemesan = inputSearch.getPemesan();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Select Trip");
        getSupportActionBar().setSubtitle(Asal+ " | " +Tujuan+ " | "
                +Tanggal+ " | " +JumlahPenumpang+ " Passenger(s)");

        rvSelectTrip = findViewById(R.id.rv_select_trip);
        rvSelectTrip.setHasFixedSize(true);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh2);
        progressBar = findViewById(R.id.progress_bar2);

//        list.addAll(getListSearch());
        showRecyclerList(Asal, Tujuan, Tanggal, JumlahPenumpang);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showRecyclerList(Asal, Tujuan, Tanggal, JumlahPenumpang);
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        startActivity(new Intent(SelectTripActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_my_order:
                        startActivity(new Intent(SelectTripActivity.this, MyOrderActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(SelectTripActivity.this, AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

//    public ArrayList<Search> getListSearch() {
//        String[] dataTrip = getResources().getStringArray(R.array.array_trip);
//        String[] dataJam = getResources().getStringArray(R.array.array_jam);
//        String[] dataSopir = getResources().getStringArray(R.array.array_sopir);
//
//        ArrayList<Search> listSearch = new ArrayList<>();
//        for (int i = 0; i < dataTrip.length; i++) {
//            Search search = new Search();
//            search.setIdTrip(dataTrip[i]);
//            search.setJadwal(dataJam[i]);
//            search.setNama(dataSopir[i]);
//
//            listSearch.add(search);
//        }
//
//        return listSearch;
//    }

    private void showRecyclerList(String asal, String tujuan, String tanggal, String jumlahPenumpang) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Search> searchCall = apiInterface.searchResponse(asal, tujuan, tanggal, jumlahPenumpang);
        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvSelectTrip.setLayoutManager(new LinearLayoutManager(SelectTripActivity.this));
                    String message = response.body().getMessage();
                    Toast.makeText(SelectTripActivity.this, message, Toast.LENGTH_SHORT).show();
                    list = response.body().getData();

                    final SearchAdapter searchAdapter = new SearchAdapter(SelectTripActivity.this, list);
                    rvSelectTrip.setAdapter(searchAdapter);
                    searchAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);

                    searchAdapter.setOnItemClickCallback(new SearchAdapter.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(SearchData data) {
                            Intent selectTripIntent = new Intent(SelectTripActivity.this, CreateOrderActivity.class);
//                            selectTripIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
                            startActivity(selectTripIntent);
                            Toast.makeText(SelectTripActivity.this, "Kamu memilih " + data.getIdTrip(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
//                    String message = response.body().getMessage();
                    Toast.makeText(SelectTripActivity.this, "Kosong", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });
    }


}