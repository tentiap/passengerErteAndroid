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
import com.example.pemesanerte.model.check.Check;
import com.example.pemesanerte.model.check.CheckData;
//import com.example.pemesanerte.model.check.CheckOld;
//import com.example.pemesanerte.model.check.CheckDataOld;
import com.example.pemesanerte.model.pesanan.Pesanan;
import com.example.pemesanerte.model.search.InputSearch;
import com.example.pemesanerte.model.search.Search;
//import com.example.pemesanerte.model.search.SearchOld;
//import com.example.pemesanerte.model.search.SearchDataOld;
import com.example.pemesanerte.model.search.SearchData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SelectTripActivity extends AppCompatActivity {
    private RecyclerView rvSelectTrip;
    private List<SearchData> listData = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    public static final String EXTRA_INPUT_SEARCH = "extra_input_search";

    String Asal, Tujuan, Tanggal, JumlahPenumpang, Pemesan, Jadwal, kAsal, kTujuan, PlatMobil, Jam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trip);

        rvSelectTrip = findViewById(R.id.rv_select_trip);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh2);
        progressBar = findViewById(R.id.progress_bar2);

        InputSearch inputSearch = getIntent().getParcelableExtra(EXTRA_INPUT_SEARCH);
        Asal = inputSearch.getFrom();
        Tujuan = inputSearch.getTo();
        Tanggal = inputSearch.getDate();
        JumlahPenumpang = inputSearch.getTotal();
        Pemesan = inputSearch.getPemesan();
        Jadwal = inputSearch.getJadwal();
        kAsal = inputSearch.getAsal();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Select Trip");
        getSupportActionBar().setSubtitle(Asal+ " | " +Tujuan+ " | "
                +Tanggal+ " | " +JumlahPenumpang+ " Passenger(s)");

        switch (Asal){
            case "Bukittinggi":
                kAsal = "K1";
                break;
            case "Padang":
                kAsal = "K2";
                break;
            case "Pekanbaru":
                kAsal = "K3";
                break;
        }

        switch (Tujuan){
            case "Bukittinggi":
                kTujuan = "K1";
                break;
            case "Padang":
                kTujuan = "K2";
                break;
            case "Pekanbaru":
                kTujuan = "K3";
                break;
        }

        showTrip(kAsal, kTujuan, Jadwal, JumlahPenumpang);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showTrip(kAsal, kTujuan, Jadwal, JumlahPenumpang);
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

    private void showTrip(String kAsal, String kTujuan, String jadwal, String jumlahPenumpang) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Search> searchCall = apiInterface.searchResponse(kAsal, kTujuan, jadwal, jumlahPenumpang);
        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {

                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvSelectTrip.setLayoutManager(new LinearLayoutManager(SelectTripActivity.this));
                    Toast.makeText(SelectTripActivity.this, "Trip pada tanggal " +Tanggal, Toast.LENGTH_SHORT).show();
                    listData = response.body().getData();

                    final SearchAdapter searchAdapter = new SearchAdapter(SelectTripActivity.this, listData);
                    rvSelectTrip.setAdapter(searchAdapter);
                    searchAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);

                    searchAdapter.setOnItemClickCallback(new SearchAdapter.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(SearchData data) {
                            PlatMobil = data.getPlatMobil();
                            Jam = data.getJadwal();
//                            check(JumlahPenumpang, PlatMobil, Pemesan);
                            check(JumlahPenumpang, jadwal, PlatMobil, Pemesan);
                        }

//                        @Override
//                        public void onItemClicked(Search data) {
//                            IdTrip = data.getIdTrip();
//                            Jam = data.getJadwal();
//                            check(JumlahPenumpang, IdTrip, Pemesan);
//                        }
                    });
                }else{
                    String message = response.body().getMessage();
                    Toast.makeText(SelectTripActivity.this, message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(SelectTripActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void check(String jumlahPenumpang, String jadwal, String platMobil,  String idPemesan){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Check> checkCall = apiInterface.checkResponse(jumlahPenumpang, jadwal, platMobil, idPemesan);
        checkCall.enqueue(new Callback<Check>() {
            @Override
            public void onResponse(Call<Check> call, Response<Check> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    CheckData checkData = new CheckData();
                    checkData.setJadwal(jadwal);
                    checkData.setPlat_mobil(PlatMobil);
                    checkData.setJumlah_penumpang(jumlahPenumpang);
                    checkData.setId_pemesan(idPemesan);
                    checkData.setAsal(Asal);
                    checkData.setTujuan(Tujuan);
                    checkData.setTanggal(Tanggal);
                    checkData.setJam(Jam);

                    ApiInterface apiInterface1 = ApiClient.getClient().create(ApiInterface.class);
                    Call<Pesanan> pesananCall = apiInterface1.pesananResponse(jadwal, platMobil, idPemesan);
                    pesananCall.enqueue(new Callback<Pesanan>() {
                        @Override
                        public void onResponse(Call<Pesanan> call, Response<Pesanan> response) {
                            Intent selectTripIntent = new Intent(SelectTripActivity.this, CreateMultipleActivity.class);
                            selectTripIntent.putExtra(CreateMultipleActivity.EXTRA_CHECK_DATA, checkData);
                            startActivity(selectTripIntent);
                        }

                        @Override
                        public void onFailure(Call<Pesanan> call, Throwable t) {
                            Toast.makeText(SelectTripActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });


                } else {
                    String message = response.body().getMessage();
                    Toast.makeText(SelectTripActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Check> call, Throwable t) {
                Toast.makeText(SelectTripActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}