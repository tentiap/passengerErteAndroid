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
import com.example.pemesanerte.model.search.InputSearch;
import com.example.pemesanerte.model.search.Search;
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

    String Asal, Tujuan, Tanggal, JumlahPenumpang, Pemesan, Jadwal, kAsal, kTujuan, IdTrip, Jam;

//    TextView tvFrom, tvTo, tvDate, tvTotal;

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
        kTujuan = inputSearch.getTujuan();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Select Trip");
        getSupportActionBar().setSubtitle(Asal+ " | " +Tujuan+ " | "
                +Tanggal+ " | " +JumlahPenumpang+ " Passenger(s)");


//        if(Asal == "Bukittinggi"){
//            kAsal = "K1";}
////        }else if(Asal == "Padang"){
////            kAsal = "K2";
////        }else {
////            kAsal = "K3";
////        }

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

//        Toast.makeText(SelectTripActivity.this, kAsal +"-"+ kTujuan +"-" +Jadwal + "-" +JumlahPenumpang,
//                Toast.LENGTH_LONG).show();

        showTrip(kAsal, kTujuan, Jadwal, JumlahPenumpang);
//
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showTrip(kAsal, kTujuan, Jadwal, JumlahPenumpang);
//                Toast.makeText(SelectTripActivity.this, kAsal +"-"+ kTujuan , Toast.LENGTH_SHORT).show();
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

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("Select Trip");
//        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Select Trip</font>"));

//        tvFrom = findViewById(R.id.tv_select_from);
//        tvTo = findViewById(R.id.tv_select_to);
//        tvDate = findViewById(R.id.tv_select_tanggal);
//        tvTotal = findViewById(R.id.tv_select_jumlah);


//        tvFrom.setText(inputSearch.getFrom());
//        tvTo.setText(inputSearch.getTo());
//        tvDate.setText(inputSearch.getDate());
//        tvTotal.setText(inputSearch.getTotal() + " Passenger(s)");

//        rvSelectTrip.setHasFixedSize(true);

//        list.addAll(getListSearch());

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

    private void showTrip(String kAsal, String kTujuan, String jadwal, String jumlahPenumpang) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Search> searchCall = apiInterface.searchResponse(kAsal, kTujuan, jadwal, jumlahPenumpang);
        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {

//                Toast.makeText(SelectTripActivity.this, kAsal+kTujuan+jadwal+jumlahPenumpang, Toast.LENGTH_SHORT).show();
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvSelectTrip.setLayoutManager(new LinearLayoutManager(SelectTripActivity.this));
//                    String message = response.body().getMessage();
                    Toast.makeText(SelectTripActivity.this, "Trip pada tanggal " +Tanggal, Toast.LENGTH_SHORT).show();
                    listData = response.body().getData();

                    final SearchAdapter searchAdapter = new SearchAdapter(SelectTripActivity.this, listData);
                    rvSelectTrip.setAdapter(searchAdapter);
                    searchAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);

                    searchAdapter.setOnItemClickCallback(new SearchAdapter.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(SearchData data) {
                            IdTrip = data.getIdTrip();
                            Jam = data.getJadwal();
                            check(JumlahPenumpang, IdTrip, Pemesan);
                        }
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

    private void check(String jumlahPenumpang, String idTrip, String idUsersPemesan){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Check> checkCall = apiInterface.checkResponse(jumlahPenumpang, idTrip, idUsersPemesan);
        checkCall.enqueue(new Callback<Check>() {
            @Override
            public void onResponse(Call<Check> call, Response<Check> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    CheckData checkData = new CheckData();
                    checkData.setId_trip(idTrip);
                    checkData.setJumlah_penumpang(jumlahPenumpang);
                    checkData.setId_users_pemesan(idUsersPemesan);
                    checkData.setAsal(Asal);
                    checkData.setTujuan(Tujuan);
                    checkData.setTanggal(Tanggal);
                    checkData.setJam(Jam);

                    Toast.makeText(SelectTripActivity.this, "Kamu memilih " + idTrip, Toast.LENGTH_SHORT).show();
                    Intent selectTripIntent = new Intent(SelectTripActivity.this, CreateOrderActivity.class);
                    selectTripIntent.putExtra(CreateOrderActivity.EXTRA_CHECK_DATA, checkData);
                    startActivity(selectTripIntent);

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