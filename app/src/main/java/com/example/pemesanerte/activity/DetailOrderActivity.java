package com.example.pemesanerte.activity;

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
import com.example.pemesanerte.model.detailHistory.DetailHistory;
import com.example.pemesanerte.model.detailHistory.DetailHistoryData;
import com.example.pemesanerte.model.history.HistoryData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DetailOrderActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    public static final String EXTRA_HISTORY_DATA = "extra_history_data";
    private RecyclerView rvDetailHistory;
    private List<DetailHistoryData> list = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    String idPesanan, idTrip, availableSeat;
    Integer jumlahPenumpang;

    FloatingActionButton fb1, floatingButtonEdit, floatingButtonAddPassenger;
    TextView tvEdit, tvAddMore;

    Boolean isAllFabsVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        HistoryData historyData = getIntent().getParcelableExtra(EXTRA_HISTORY_DATA);
        idPesanan = historyData.getIdPesanan();
        idTrip = historyData.getIdTrip();
//        Toast.makeText(DetailOrderActivity.this, "ID Pesanan : " +idPesanan, Toast.LENGTH_SHORT).show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detail Order " + idPesanan);
        getSupportActionBar().setSubtitle(historyData.getIdKotaAsal()+ " | " +historyData.getIdKotaTujuan()+ " | "
                +historyData.getTanggal()+ " | " +historyData.getJadwal());

        rvDetailHistory = findViewById(R.id.rv_detail_history);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh1);
        progressBar = findViewById(R.id.progress_bar1);
//        rvDetailHistory.setHasFixedSize(true);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showRecyclerDetail(idPesanan);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

//        TextView tvIdPesanan = findViewById(R.id.tv_id_order);
//        TextView tvIdTrip = findViewById(R.id.tv_id_trip);
//        TextView tvFrom = findViewById(R.id.tv_from);
//        TextView tvTo = findViewById(R.id.tv_to);
//        TextView tvJadwal = findViewById(R.id.tv_date);
//        TextView tvWaktu = findViewById(R.id.tv_time);
//        TextView tvPrcllble = findViewById(R.id.tv_prcllble);
//        HistoryData historyData = getIntent().getParcelableExtra(EXTRA_HISTORY_DATA);
//
//        idPesanan = getIntent().getStringExtra(EXTRA_ID_PESANAN);


//        tvIdPesanan.setText("Id Order: " +idPesanan);
//        tvIdTrip.setText("Id Trip: " +historyData.getIdTrip());
//        tvFrom.setText(historyData.getIdKotaAsal());
//        tvTo.setText(historyData.getIdKotaTujuan());
//        tvJadwal.setText(historyData.getTanggal());
//        tvWaktu.setText(historyData.getJadwal());


//        String text = "Asal : " + historyData.getIdKotaAsal() + ",\nTujuan : " + historyData.getIdKotaTujuan() + ",\nJadwal : " + historyData.getJadwal();
//        tvPrcllble.setText(text);

//        list.addAll(getDetailHistory());
        showRecyclerDetail(idPesanan);




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
            }
        });

        floatingButtonEdit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(DetailOrderActivity.this, "Edit Data Passenger(s)", Toast.LENGTH_SHORT).show();
                        Intent editPesanan = new Intent(DetailOrderActivity.this, EditPesananActivity.class);
//                        editPesanan.putExtra("id_pesanan", idPesanan);
//                        editPesanan.putExtra("id_trip", idTrip);
                        CheckData checkData = new CheckData();
                        checkData.setId_trip(idTrip);
                        checkData.setJumlah_penumpang(String.valueOf(jumlahPenumpang));
                        checkData.setId_users_pemesan(historyData.getIdUsersPemesan());
                        checkData.setAsal(historyData.getIdKotaAsal());
                        checkData.setTujuan(historyData.getIdKotaTujuan());
                        checkData.setTanggal(historyData.getTanggal());
                        checkData.setJam(historyData.getJadwal());

                        editPesanan.putExtra(EditPesananActivity.EXTRA_CHECK_DATA_EDIT, checkData);
                        startActivity(editPesanan);
//                        Toast.makeText(DetailOrderActivity.this, "Jumlah member "+jumlahPenumpang, Toast.LENGTH_SHORT).show();


                    }
                });

        floatingButtonAddPassenger.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        builder = new AlertDialog.Builder(DetailOrderActivity.this);
                        builder.setTitle("Add More Passenger(s)");

                        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                        Call<AvailableSeat> availableSeatCall = apiInterface.availableSeatResponse(idTrip);
                        availableSeatCall.enqueue(new Callback<AvailableSeat>() {
                            @Override
                            public void onResponse(Call<AvailableSeat> call, Response<AvailableSeat> response) {
                                if (response.body().isStatus()){
                                    builder.setMessage(response.body().getMessage());
                                    builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(DetailOrderActivity.this, "Lanjut ke Create Pesanan", Toast.LENGTH_SHORT).show();
                                            Intent goToTambahPesananIntent = new Intent(DetailOrderActivity.this, TambahPesananActivity.class);
                                            goToTambahPesananIntent.putExtra(TambahPesananActivity.EXTRA_JUMLAH, jumlahPenumpang);
                                            startActivity(goToTambahPesananIntent);
                                        }
                                    });

                                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(DetailOrderActivity.this, "Yahhhh cekewa dedek", Toast.LENGTH_SHORT).show();
                                            dialogInterface.dismiss();
                                        }
                                    });

                                    builder.show();

                                }else{
                                    builder.setMessage(response.body().getMessage());
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(DetailOrderActivity.this, "Hokeee", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                    builder.show();
                                }
                            }

                            @Override
                            public void onFailure(Call<AvailableSeat> call, Throwable t) {

                            }
                        });


//                        builder.setMessage("Disini nanti info tentang seat yang tersedia");
//                        builder.setPositiveButton("Ni positive button", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(DetailOrderActivity.this, "Positive Button diklik", Toast.LENGTH_SHORT).show();
//                                dialogInterface.dismiss();
//                            }
//                        });
//
//                        builder.setNegativeButton("Ni Negative Button", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(DetailOrderActivity.this, "Negative Button diklik", Toast.LENGTH_SHORT).show();
//                                dialogInterface.dismiss();
//                            }
//                        });
//
//                        builder.show();
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

//    public ArrayList<HistoryData> getDetailHistory() {
//        String[] dataPassengerName = getResources().getStringArray(R.array.array_name);
//        String[] dataPassengerGender = getResources().getStringArray(R.array.array_gender);
//        String[] dataPassengerAsal = getResources().getStringArray(R.array.array_asal);
//        String[] dataPassengerTujuan = getResources().getStringArray(R.array.array_tujuan);
//        String[] dataPassengerKontak = getResources().getStringArray(R.array.array_phone);
//        String[] dataPassengerBiaya = getResources().getStringArray(R.array.array_cost);
//        String[] dataPassengerSeat = getResources().getStringArray(R.array.array_seat);
//
//        ArrayList<HistoryData> listHistory = new ArrayList<>();
//        for (int i = 0; i < dataPassengerName.length; i++) {
//            HistoryData historyData = new HistoryData();
//
//            historyData.setNamaPenumpang(dataPassengerName[i]);
//            historyData.setJenisKelamin(dataPassengerGender[i]);
//            historyData.setDetailAsal(dataPassengerAsal[i]);
//            historyData.setDetailTujuan(dataPassengerTujuan[i]);
//            historyData.setNoHp(dataPassengerKontak[i]);
//            historyData.setBiayaTambahan(dataPassengerBiaya[i]);
//            historyData.setIdSeat(dataPassengerSeat[i]);
//
//            listHistory.add(historyData);
//        }
//
//        return listHistory;
//    }

    private void showRecyclerDetail(String idPesanan) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<DetailHistory> detailHistoryCall = apiInterface.detailResponse(idPesanan);
        detailHistoryCall.enqueue(new Callback<DetailHistory>() {
            @Override
            public void onResponse(Call<DetailHistory> call, Response<DetailHistory> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvDetailHistory.setLayoutManager(new LinearLayoutManager(DetailOrderActivity.this));
                    String message = response.body().getMessage();
//                    Toast.makeText(DetailOrderActivity.this, message, Toast.LENGTH_SHORT).show();
                    list = response.body().getData();
//                    Toast.makeText(DetailOrderActivity.this, "Jumlah member "+list.size(), Toast.LENGTH_SHORT).show();
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
//        rvDetailHistory.setLayoutManager(new LinearLayoutManager(this));
//        final DetailHistoryAdapter detailHistoryAdapter = new DetailHistoryAdapter(list);
//        rvDetailHistory.setAdapter(detailHistoryAdapter);

//        detailHistoryAdapter.setOnItemClickCallback(new HistoryAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(HistoryData data) {
//                Intent detailHistoryIntent = new Intent(DetailOrderActivity.this, DetailOrderActivity.class);
////                detailHistoryIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
//                startActivity(detailHistoryIntent);
//                Toast.makeText(DetailOrderActivity.this, "Kamu memilih " + data.getJadwal(), Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}
