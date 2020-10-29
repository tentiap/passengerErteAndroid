package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.adapter.DetailHistoryAdapter;
import com.example.pemesanerte.adapter.HistoryAdapter;
import com.example.pemesanerte.model.history.HistoryData;

import java.util.ArrayList;

public class DetailOrderActivity extends AppCompatActivity {
    public static final String EXTRA_HISTORY_DATA = "extra_history_data";
    private RecyclerView rvDetailHistory;
    private ArrayList<HistoryData> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        rvDetailHistory = findViewById(R.id.rv_detail_history);
        rvDetailHistory.setHasFixedSize(true);

        TextView tvFrom = findViewById(R.id.tv_from);
        TextView tvTo = findViewById(R.id.tv_to);
        TextView tvJadwal = findViewById(R.id.tv_date);
//        TextView tvPrcllble = findViewById(R.id.tv_prcllble);
        HistoryData historyData = getIntent().getParcelableExtra(EXTRA_HISTORY_DATA);
        tvFrom.setText("From: " + historyData.getIdKotaAsal());
        tvTo.setText("To: " + historyData.getIdKotaTujuan());
        tvJadwal.setText(historyData.getJadwal());
//        String text = "Asal : " + historyData.getIdKotaAsal() + ",\nTujuan : " + historyData.getIdKotaTujuan() + ",\nJadwal : " + historyData.getJadwal();
//        tvPrcllble.setText(text);

        list.addAll(getDetailHistory());
        showRecyclerDetail();
    }

    public ArrayList<HistoryData> getDetailHistory() {
        String[] dataPassengerName = getResources().getStringArray(R.array.array_name);
        String[] dataPassengerGender = getResources().getStringArray(R.array.array_gender);
        String[] dataPassengerAsal = getResources().getStringArray(R.array.array_asal);
        String[] dataPassengerTujuan = getResources().getStringArray(R.array.array_tujuan);
        String[] dataPassengerKontak = getResources().getStringArray(R.array.array_phone);
        String[] dataPassengerBiaya = getResources().getStringArray(R.array.array_cost);
        String[] dataPassengerSeat = getResources().getStringArray(R.array.array_seat);

        ArrayList<HistoryData> listHistory = new ArrayList<>();
        for (int i = 0; i < dataPassengerName.length; i++) {
            HistoryData historyData = new HistoryData();

            historyData.setNamaPenumpang(dataPassengerName[i]);
            historyData.setJenisKelamin(dataPassengerGender[i]);
            historyData.setDetailAsal(dataPassengerAsal[i]);
            historyData.setDetailTujuan(dataPassengerTujuan[i]);
            historyData.setNoHp(dataPassengerKontak[i]);
            historyData.setBiayaTambahan(dataPassengerBiaya[i]);
            historyData.setIdSeat(dataPassengerSeat[i]);

            listHistory.add(historyData);
        }

        return listHistory;
    }

    private void showRecyclerDetail() {
        rvDetailHistory.setLayoutManager(new LinearLayoutManager(this));
        final DetailHistoryAdapter detailHistoryAdapter = new DetailHistoryAdapter(list);
        rvDetailHistory.setAdapter(detailHistoryAdapter);

//        historyAdapter.setOnItemClickCallback(new HistoryAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(HistoryData data) {
//                Intent detailHistoryIntent = new Intent(MyOrderActivity.this, DetailOrderActivity.class);
//                detailHistoryIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
//                startActivity(detailHistoryIntent);
//                Toast.makeText(MyOrderActivity.this, "Kamu memilih " + data.getJadwal(), Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}