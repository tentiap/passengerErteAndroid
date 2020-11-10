package com.example.pemesanerte;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.adapter.SearchAdapter;
import com.example.pemesanerte.model.search.InputSearch;
import com.example.pemesanerte.model.search.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SelectTripActivity extends AppCompatActivity {
    private RecyclerView rvSelectTrip;
    private ArrayList<Search> list = new ArrayList<>();
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Select Trip");
        getSupportActionBar().setSubtitle(inputSearch.getFrom()+ " | " +inputSearch.getTo()+ " | "
                +inputSearch.getDate()+ " | " +inputSearch.getTotal()+ " Passenger(s)");

        rvSelectTrip = findViewById(R.id.rv_select_trip);
        rvSelectTrip.setHasFixedSize(true);

        list.addAll(getListSearch());
        showRecyclerList();


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

    public ArrayList<Search> getListSearch() {
        String[] dataTrip = getResources().getStringArray(R.array.array_trip);
        String[] dataJam = getResources().getStringArray(R.array.array_jam);
        String[] dataSopir = getResources().getStringArray(R.array.array_sopir);

        ArrayList<Search> listSearch = new ArrayList<>();
        for (int i = 0; i < dataTrip.length; i++) {
            Search search = new Search();
            search.setIdTrip(dataTrip[i]);
            search.setJadwal(dataJam[i]);
            search.setNama(dataSopir[i]);

            listSearch.add(search);
        }

        return listSearch;
    }

    private void showRecyclerList() {
        rvSelectTrip.setLayoutManager(new LinearLayoutManager(this));
        final SearchAdapter searchAdapter = new SearchAdapter(list);
        rvSelectTrip.setAdapter(searchAdapter);

        searchAdapter.setOnItemClickCallback(new SearchAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Search data) {
                Intent selectTripIntent = new Intent(SelectTripActivity.this, CreateOrderActivity.class);
//                selectTripIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
                startActivity(selectTripIntent);
                Toast.makeText(SelectTripActivity.this, "Kamu memilih " + data.getIdTrip(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}