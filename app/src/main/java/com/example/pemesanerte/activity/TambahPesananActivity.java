package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.R;
import com.example.pemesanerte.activity.example.CreateOrderActivity;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.bookedSeat.BookedSeat;
import com.example.pemesanerte.model.bookedSeat.BookedSeatData;
import com.example.pemesanerte.model.check.Check;
import com.example.pemesanerte.model.check.CheckData;
import com.example.pemesanerte.model.pesanan.Pesanan;
import com.example.pemesanerte.model.seat.SeatData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    Button buttonCari;

    private List<SeatData> listSeat;
    List<BookedSeatData> bookedSeatData;
    List<String> listSpinner = new ArrayList<>();
    List<String> listBookedSeat = new ArrayList<>();


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

        spinnerAdd = findViewById(R.id.spinner_add_jumlah_tambah);
        buttonCari = findViewById(R.id.btn_add_cari);


        getData();



    }

    private void getData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BookedSeat> bookedSeatCall = apiInterface.bookedSeatResponse(idTrip);
        bookedSeatCall.enqueue(new Callback<BookedSeat>() {
            @Override
            public void onResponse(Call<BookedSeat> call, Response<BookedSeat> response) {
                if (response.isSuccessful()){
                    bookedSeatData = response.body().getData();
                    int available = 7 - bookedSeatData.size();

                    for (int i = 1; i <= available; i++){
                        listSpinner.add(String.valueOf(i));
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(TambahPesananActivity.this, android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerAdd.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                    buttonCari.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tambah = spinnerAdd.getSelectedItem().toString();
                            check(tambah, idTrip, idUsersPemesan);
                        }
                    });



                }
            }

            @Override
            public void onFailure(Call<BookedSeat> call, Throwable t) {

            }
        });
    }

    private void check(String tambah, String idTrip, String idUsersPemesan){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Check> checkCall = apiInterface.checkUpdateResponse(tambah, idTrip, idUsersPemesan);
        checkCall.enqueue(new Callback<Check>() {
            @Override
            public void onResponse(Call<Check> call, Response<Check> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    CheckData checkData = new CheckData();
                    checkData.setId_trip(idTrip);
                    checkData.setJumlah_penumpang(tambah);
                    checkData.setId_users_pemesan(idUsersPemesan);
                    checkData.setAsal(asal);
                    checkData.setTujuan(tujuan);
                    checkData.setTanggal(tanggal);
                    checkData.setJam(jam);

                    ApiInterface apiInterface1 = ApiClient.getClient().create(ApiInterface.class);
                    Call<Pesanan> pesananCall = apiInterface1.pesananResponse(idTrip, idUsersPemesan);
                    pesananCall.enqueue(new Callback<Pesanan>() {
                        @Override
                        public void onResponse(Call<Pesanan> call, Response<Pesanan> response) {
                            Intent selectTripIntent = new Intent(TambahPesananActivity.this, CreateMultipleActivity.class);
                            selectTripIntent.putExtra(CreateOrderActivity.EXTRA_CHECK_DATA, checkData);
                            startActivity(selectTripIntent);
                        }

                        @Override
                        public void onFailure(Call<Pesanan> call, Throwable t) {
                            Toast.makeText(TambahPesananActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });


                } else {
                    String message = response.body().getMessage();
                    Toast.makeText(TambahPesananActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Check> call, Throwable t) {
                Toast.makeText(TambahPesananActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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