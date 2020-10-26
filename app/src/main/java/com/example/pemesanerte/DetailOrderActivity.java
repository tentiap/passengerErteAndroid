package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pemesanerte.model.history.HistoryData;

public class DetailOrderActivity extends AppCompatActivity {
    public static final String EXTRA_HISTORY_DATA = "extra_history_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        TextView tvPrcllble = findViewById(R.id.tv_prcllble);
        HistoryData historyData = getIntent().getParcelableExtra(EXTRA_HISTORY_DATA);
        String text = "Asal : " + historyData.getIdKotaAsal() + ",\nTujuan : " + historyData.getIdKotaTujuan() + ",\nJadwal : " + historyData.getJadwal();
        tvPrcllble.setText(text);

    }
}