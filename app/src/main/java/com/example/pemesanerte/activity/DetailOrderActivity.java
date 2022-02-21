package com.example.pemesanerte.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.R;
import com.example.pemesanerte.adapter.DetailHistoryAdapter;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.availableSeat.AvailableSeat;
import com.example.pemesanerte.model.check.CheckData;
//import com.example.pemesanerte.model.detailHistory.DetailHistoryOld;
//import com.example.pemesanerte.model.detailHistory.DetailHistoryDataOld;
import com.example.pemesanerte.model.detailHistory.DetailHistory;
import com.example.pemesanerte.model.detailHistory.DetailHistoryData;
import com.example.pemesanerte.model.history.HistoryData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;


public class DetailOrderActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    public static final String EXTRA_HISTORY_DATA = "extra_history_data";
    private RecyclerView rvDetailHistory;
    private List<DetailHistoryData> list = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    String jadwal, platMobil, idPemesan, availableSeat;
    Integer jumlahPenumpang;

    FloatingActionButton fb1, floatingButtonEdit, floatingButtonAddPassenger;
    TextView tvEdit, tvAddMore;

    Boolean isAllFabsVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        HistoryData historyData = getIntent().getParcelableExtra(EXTRA_HISTORY_DATA);
//        idPesanan = historyData.getIdPesanan();
//        idTrip = historyData.getIdTrip();
        jadwal = historyData.getJadwalOriginal();
        idPemesan = historyData.getIdPemesan();
        platMobil = historyData.getPlatMobil();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detail Order ");
        getSupportActionBar().setSubtitle(historyData.getIdKotaAsal()+ " | " +historyData.getIdKotaTujuan()+ " | "
                +historyData.getTanggal()+ " | " +historyData.getJadwal());

        rvDetailHistory = findViewById(R.id.rv_detail_history);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh1);
        progressBar = findViewById(R.id.progress_bar1);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showRecyclerDetail(idPemesan, jadwal, platMobil);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        showRecyclerDetail(idPemesan, jadwal, platMobil);

        fb1 = findViewById(R.id.floating_button);
        floatingButtonEdit = findViewById(R.id.fb_edit);
        floatingButtonAddPassenger = findViewById(R.id.fb_add_passenger);

        tvEdit = findViewById(R.id.edit_data_text);
        tvAddMore = findViewById(R.id.add_more_passenger_text);

        floatingButtonEdit.setVisibility(View.GONE);
        floatingButtonAddPassenger.setVisibility(View.GONE);
        tvEdit.setVisibility(View.GONE);
        tvAddMore.setVisibility(View.GONE);

        isAllFabsVisible = false;



        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date dateTime = Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDateTime = sdf.format(dateTime);
////                Date currentDateTime = sdf.parse("2022-02-10 10:00:00");
////                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
////                LocalDateTime date1 = LocalDateTime.parse(dateTime);
//                Toast.makeText(DetailOrderActivity.this, "CurrentTime: "+currentDateTime, Toast.LENGTH_SHORT).show();

                if (currentDateTime.compareTo(jadwal) < 0) {
                    System.out.println("Selisihnya: "+currentDateTime.compareTo(jadwal));
                    if (!isAllFabsVisible){
                        floatingButtonEdit.show();
                        floatingButtonAddPassenger.show();
                        tvEdit.setVisibility(View.VISIBLE);
                        tvAddMore.setVisibility(View.VISIBLE);

                        isAllFabsVisible = true;
                    }else{
                        floatingButtonEdit.hide();
                        floatingButtonAddPassenger.hide();
                        tvEdit.setVisibility(View.GONE);
                        tvAddMore.setVisibility(View.GONE);

                        isAllFabsVisible = false;
                    }
                } else {
                    System.out.println("Selisihnya: "+currentDateTime.compareTo(jadwal));
                    Toast.makeText(DetailOrderActivity.this, "Trip sudah lewat, tidak bisa edit data", Toast.LENGTH_SHORT).show();
                }

            }
        });

        floatingButtonEdit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent editPesanan = new Intent(DetailOrderActivity.this, EditPesananActivity.class);
                        CheckData checkData = new CheckData();
//                        checkDataOld.setId_trip(idTrip);
//                        checkData.setId_pemesan();
                        checkData.setJumlah_penumpang(String.valueOf(jumlahPenumpang));
//                        checkDataOld.setId_users_pemesan(historyData.getIdUsersPemesan());
                        checkData.setAsal(historyData.getIdKotaAsal());
                        checkData.setTujuan(historyData.getIdKotaTujuan());
                        checkData.setTanggal(historyData.getTanggal());
                        checkData.setJam(historyData.getJadwal());
                        checkData.setJadwal(historyData.getJadwalOriginal());
                        checkData.setId_pemesan(historyData.getIdPemesan());
                        checkData.setPlat_mobil(historyData.getPlatMobil());

                        editPesanan.putExtra(EditPesananActivity.EXTRA_CHECK_DATA_EDIT, checkData);
                        startActivity(editPesanan);
                    }
                });

        floatingButtonAddPassenger.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        builder = new AlertDialog.Builder(DetailOrderActivity.this);
                        builder.setTitle("Add More Passenger(s)");

                        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                        Call<AvailableSeat> availableSeatCall = apiInterface.availableSeatResponse(jadwal, platMobil);
                        availableSeatCall.enqueue(new Callback<AvailableSeat>() {
                            @Override
                            public void onResponse(Call<AvailableSeat> call, Response<AvailableSeat> response) {
                                if (response.body().isStatus()){
                                    builder.setMessage(response.body().getMessage());
                                    builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent goToTambahPesananIntent = new Intent(DetailOrderActivity.this, TambahPesananActivity.class);
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_JUMLAH, String.valueOf(jumlahPenumpang));
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_ASAL, historyData.getIdKotaAsal());
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_TUJUAN, historyData.getIdKotaTujuan());
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_TANGGAL, historyData.getTanggal());
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_JAM, historyData.getJadwal());
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_JADWAL, historyData.getJadwalOriginal());
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_PLAT, historyData.getPlatMobil());
//                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_ID_PESANAN, jadwal);
//                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_ID_TRIP, platMobil);
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_ID_PEMESAN, historyData.getIdPemesan());
                                            startActivity(goToTambahPesananIntent);
                                        }
                                    });

                                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    });

                                    builder.show();

                                }else{
                                    builder.setMessage(response.body().getMessage());
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    });

                                    builder.show();
                                }
                            }

                            @Override
                            public void onFailure(Call<AvailableSeat> call, Throwable t) {

                            }
                        });
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

    private void showRecyclerDetail(String idPemesan, String jadwal, String platMobil) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<DetailHistory> detailHistoryCall = apiInterface.detailResponse(idPemesan, jadwal, platMobil);
        detailHistoryCall.enqueue(new Callback<DetailHistory>() {
            @Override
            public void onResponse(Call<DetailHistory> call, Response<DetailHistory> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvDetailHistory.setLayoutManager(new LinearLayoutManager(DetailOrderActivity.this));
                    String message = response.body().getMessage();
                    list = response.body().getData();
                    jumlahPenumpang = list.size();

                    final DetailHistoryAdapter detailHistoryAdapter = new DetailHistoryAdapter(DetailOrderActivity.this, list);
                    rvDetailHistory.setAdapter(detailHistoryAdapter);
                    detailHistoryAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);
                }else {
                    String message = response.body().getMessage();
                    Toast.makeText(DetailOrderActivity.this, message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<DetailHistory> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(DetailOrderActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
