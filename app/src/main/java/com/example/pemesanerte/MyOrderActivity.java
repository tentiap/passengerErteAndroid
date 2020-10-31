package com.example.pemesanerte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pemesanerte.adapter.HistoryAdapter;
import com.example.pemesanerte.model.history.HistoryData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static java.lang.System.in;

public class MyOrderActivity extends AppCompatActivity {
    private RecyclerView rvHistory;
    private ArrayList<HistoryData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        rvHistory = findViewById(R.id.rv_history);
        rvHistory.setHasFixedSize(true);

        list.addAll(getListHistory());
        showRecyclerList();

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

    public ArrayList<HistoryData> getListHistory() {
//        String[] dataIdPesanan = getResources().getStringArray(R.array.id_pesanan);
        String[] dataAsal = getResources().getStringArray(R.array.kota_asal);
        String[] dataTujuan = getResources().getStringArray(R.array.kota_tujuan);
        String[] dataJadwal = getResources().getStringArray(R.array.jadwal_trip);
        String[] dataJam = getResources().getStringArray(R.array.jadwal_trip);

        ArrayList<HistoryData> listHistory = new ArrayList<>();
        for (int i = 0; i < dataAsal.length; i++) {
            HistoryData historyData = new HistoryData();
//            historyData.setIdPesanan(dataIdPesanan[i]);
            historyData.setIdKotaAsal(dataAsal[i]);
            historyData.setIdKotaTujuan(dataTujuan[i]);
            historyData.setJadwal(dataJadwal[i]);
            historyData.setJadwal(dataJam[i]);

            listHistory.add(historyData);
        }

        return listHistory;
    }

    private void showRecyclerList() {
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        final HistoryAdapter historyAdapter = new HistoryAdapter(list);
        rvHistory.setAdapter(historyAdapter);

        historyAdapter.setOnItemClickCallback(new HistoryAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(HistoryData data) {
                Intent detailHistoryIntent = new Intent(MyOrderActivity.this, DetailOrderActivity.class);
                detailHistoryIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
                startActivity(detailHistoryIntent);
                Toast.makeText(MyOrderActivity.this, "Kamu memilih " + data.getJadwal(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}
