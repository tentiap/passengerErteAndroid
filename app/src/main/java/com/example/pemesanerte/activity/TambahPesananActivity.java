package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.R;

public class TambahPesananActivity extends AppCompatActivity {

    public static final String EXTRA_JUMLAH = "extra_jumlah";
    public static final String EXTRA_ASAL = "extra_asal";
    public static final String EXTRA_TUJUAN = "extra_tujuan";
    public static final String EXTRA_TANGGAL = "extra_tanggal";
    public static final String EXTRA_JAM = "extra_jam";
    public static final String EXTRA_ID_PESANAN = "extra_id_pesanan";
    public static final String EXTRA_ID_TRIP = "extra_id_trip";
    public static final String EXTRA_ID_USERS_PEMESAN = "extra_id_users_pemesan";
    String jumlah, asal, tujuan, tanggal, jam, idPesanan, idTrip, idUsersPemesan, tambah;
    Spinner spinnerAdd;
    TextView textViewFrom, textViewTo, textViewBookedSeat, textViewJadwal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesanan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add More Passenger(s)");

        jumlah = getIntent().getStringExtra(EXTRA_JUMLAH);
        asal = getIntent().getStringExtra(EXTRA_ASAL);
        tujuan = getIntent().getStringExtra(EXTRA_TUJUAN);
        tanggal = getIntent().getStringExtra(EXTRA_TANGGAL);
        jam = getIntent().getStringExtra(EXTRA_JAM);
        idPesanan = getIntent().getStringExtra(EXTRA_ID_PESANAN);
        idTrip = getIntent().getStringExtra(EXTRA_ID_TRIP);
        idUsersPemesan = getIntent().getStringExtra(EXTRA_ID_USERS_PEMESAN);

        textViewFrom = findViewById(R.id.text_add_from);
        textViewFrom.setText(asal);

        textViewTo = findViewById(R.id.text_add_to);
        textViewTo.setText(tujuan);

        textViewJadwal = findViewById(R.id.text_add_schedule);
        textViewJadwal.setText(tanggal+" - "+jam);

        textViewBookedSeat = findViewById(R.id.text_add_jumlah_pesanan);
        textViewBookedSeat.setText(jumlah);

//        spinnerAdd = findViewById(R.id.spinner_add_jumlah_tambah);
//        spinnerAdd.getSe

        Toast.makeText(this, jumlah, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();;
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}