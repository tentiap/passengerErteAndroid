package com.example.pemesanerte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.model.search.InputSearch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;
    TextView tvWelcome, tvJadwal;
    Spinner spinnerAsal, spinnerTujuan, spinnerJumlahPenumpang;
    DatePickerDialog pickerDialog;
    String Asal, Tujuan, Tanggal, JumlahPenumpang;
    Button btnCari;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        return true;
                    case R.id.bn_my_order:
                        startActivity(new Intent(MainActivity.this, MyOrderActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(MainActivity.this, AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        tvJadwal = findViewById(R.id.tv_jadwal);
        tvWelcome = findViewById(R.id.tv_welcome);
        btnCari = findViewById(R.id.btn_cari);
        spinnerAsal = findViewById(R.id.spinner_asal);
        spinnerTujuan = findViewById(R.id.spinner_tujuan);
        spinnerJumlahPenumpang = findViewById(R.id.spiner_jumlah_penumpang);

        tvWelcome.setText("Welcome, " + sessionManager.getUserDetail().get(SessionManager.NAMA) + "!");

        tvJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                selectDate();
                final Calendar calendar = Calendar.getInstance();
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                pickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int years, int months, int dayS) {
                        tvJadwal.setText(years + "-" + (months + 1) + "-" + dayS );
//                        Tanggal = years + "-" + (months + 1) + "-" + dayS;
                        Tanggal = dayS+ " " +months+ " " +years;
                    }
                }, year, month, day);
                pickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                pickerDialog.show();
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Asal = spinnerAsal.getSelectedItem().toString();
                Tujuan = spinnerTujuan.getSelectedItem().toString();
                JumlahPenumpang = spinnerJumlahPenumpang.getSelectedItem().toString();

//                Toast.makeText(MainActivity.this, "Asal : " +Asal+ ", Tujuan : "  +Tujuan+ ", Tanggal : " +Tanggal+ ", Penumpang : " +JumlahPenumpang, Toast.LENGTH_SHORT).show();
                InputSearch inputSearch = new InputSearch();
                inputSearch.setFrom(Asal);
                inputSearch.setTo(Tujuan);
                inputSearch.setDate(Tanggal);

                inputSearch.setTotal(JumlahPenumpang);

                Intent cariIntent = new Intent(MainActivity.this, SelectTripActivity.class );
                cariIntent.putExtra(SelectTripActivity.EXTRA_INPUT_SEARCH, inputSearch);
                startActivity(cariIntent);
            }
        });

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();

    }

//    private void selectDate() {
//        final Calendar calendar = Calendar.getInstance();
//        final int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int month = calendar.get(Calendar.MONTH);
//        int year = calendar.get(Calendar.YEAR);
//
//        pickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int years, int months, int dayS) {
//                tvJadwal.setText(years + "-" + (months + 1) + "-" + dayS );
//                Tanggal = years + "-" + (months + 1) + "-" + dayS;
//            }
//        }, year, month, day);
//        pickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//        pickerDialog.show();
//    }
}