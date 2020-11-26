package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.R;
import com.example.pemesanerte.adapter.DetailHistoryAdapter;
import com.example.pemesanerte.adapter.HistoryAdapter;
import com.example.pemesanerte.model.history.HistoryData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DetailOrderActivity extends AppCompatActivity {
    public static final String EXTRA_ID_PESANAN = "extra_id_pesanan";
    private RecyclerView rvDetailHistory;
    private ArrayList<HistoryData> list = new ArrayList<>();

    FloatingActionButton fb1, fb2, fb3;
    TextView tvEdit, tvAddMore;

    Boolean isAllFabsVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detail Order");

        rvDetailHistory = findViewById(R.id.rv_detail_history);
        rvDetailHistory.setHasFixedSize(true);

        TextView tvFrom = findViewById(R.id.tv_from);
        TextView tvTo = findViewById(R.id.tv_to);
        TextView tvJadwal = findViewById(R.id.tv_date);
//        TextView tvPrcllble = findViewById(R.id.tv_prcllble);
//        HistoryData historyData = getIntent().getParcelableExtra(EXTRA_HISTORY_DATA);
//        tvFrom.setText("From: " + historyData.getIdKotaAsal());
//        tvTo.setText("To: " + historyData.getIdKotaTujuan());
//        tvJadwal.setText(historyData.getJadwal());
        String selectedIdPesanan = getIntent().getStringExtra(EXTRA_ID_PESANAN);
        Toast.makeText(DetailOrderActivity.this, "ID Pesanan : " +selectedIdPesanan, Toast.LENGTH_SHORT).show();
//        String text = "Asal : " + historyData.getIdKotaAsal() + ",\nTujuan : " + historyData.getIdKotaTujuan() + ",\nJadwal : " + historyData.getJadwal();
//        tvPrcllble.setText(text);

//        list.addAll(getDetailHistory());
//        showRecyclerDetail();

        fb1 = findViewById(R.id.floating_button);
        fb2 = findViewById(R.id.fb_edit);
        fb3 = findViewById(R.id.fb_add_passenger);

        tvEdit = findViewById(R.id.edit_data_text);
        tvAddMore = findViewById(R.id.add_more_passenger_text);

        fb2.setVisibility(View.GONE);
        fb3.setVisibility(View.GONE);
        tvEdit.setVisibility(View.GONE);
        tvAddMore.setVisibility(View.GONE);

        isAllFabsVisible = false;

        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isAllFabsVisible){
                    fb2.show();
                    fb3.show();
                    tvEdit.setVisibility(View.VISIBLE);
                    tvAddMore.setVisibility(View.VISIBLE);

                    isAllFabsVisible = true;
                }else{
                    fb2.hide();
                    fb3.hide();
                    tvEdit.setVisibility(View.GONE);
                    tvAddMore.setVisibility(View.GONE);

                    isAllFabsVisible = false;
                }
            }
        });

        fb2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DetailOrderActivity.this, "Edit Data Passenger(s)", Toast.LENGTH_SHORT).show();
                    }
                });

        fb3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DetailOrderActivity.this, "Add More Passenger(s)", Toast.LENGTH_SHORT).show();
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

    private void showRecyclerDetail() {
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
