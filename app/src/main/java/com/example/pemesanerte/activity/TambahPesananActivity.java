package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pemesanerte.R;

public class TambahPesananActivity extends AppCompatActivity {

    private static String extra_jumlah;
    public static final String EXTRA_JUMLAH = extra_jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesanan);

        String jumlah = getIntent().getStringExtra(EXTRA_JUMLAH);
    }
}