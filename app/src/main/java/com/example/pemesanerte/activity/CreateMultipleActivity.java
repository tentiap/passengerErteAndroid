package com.example.pemesanerte.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.pemesanerte.R;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.bookedSeat.BookedSeat;
import com.example.pemesanerte.model.bookedSeat.BookedSeatData;
import com.example.pemesanerte.model.check.CheckData;
import com.example.pemesanerte.model.seat.SeatData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateMultipleActivity extends AppCompatActivity {

    LinearLayout layoutList;
    Button buttonAddMultiple;
    ExpandableCardView detailTrip;
    Spinner spinnerMultiGender, spinnerMultiSeat;
    String EXTRA_CHECK_DATA = "extra_check_data";
    String asal, tujuan, jumlahPenumpang, idTrip, idUsersPemesan;

    private List<SeatData> listSeat;
    List<BookedSeatData> bookedSeatData;
    List<String> listSpinner = new ArrayList<>();
    List<String> listBookedSeat = new ArrayList<>();

    CheckBox checkBoxSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_multiple);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Passenger(s)");

        CheckData checkData = getIntent().getParcelableExtra(EXTRA_CHECK_DATA);

        idTrip = checkData.getId_trip();
        idUsersPemesan = checkData.getId_users_pemesan();
        jumlahPenumpang = checkData.getJumlah_penumpang();
        asal = checkData.getAsal();
        tujuan = checkData.getTujuan();

        switch (asal){
            case "Bukittinggi":
                asal = "BKT";
                break;
            case "Padang":
                asal = "PDG";
                break;
            case "Pekanbaru":
                asal = "PKU";
                break;
        }

        switch (tujuan){
            case "Bukittinggi":
                tujuan = "BKT";
                break;
            case "Padang":
                tujuan = "PDG";
                break;
            case "Pekanbaru":
                tujuan = "PKU";
                break;
        }

        layoutList = findViewById(R.id.layout_list);
        detailTrip = findViewById(R.id.card_detail_trip);
        detailTrip.expand();
//        spinnerMultiSeat = findViewById(R.id.spinner_multi_passenger_seat);
        spinnerMultiGender = findViewById(R.id.spinner_multi_passenger_gender);

        TextView tvAsal = findViewById(R.id.tv_create_from);
        TextView tvTujuan = findViewById(R.id.tv_create_to);
        TextView tvTanggal = findViewById(R.id.tv_create_tanggal);
        TextView tvJam = findViewById(R.id.tv_create_jam);
        TextView tvJumlah = findViewById(R.id.tv_create_jumlah);

        tvAsal.setText(asal);
        tvTujuan.setText(tujuan);
        tvTanggal.setText(checkData.getTanggal());
        tvJam.setText(checkData.getJam());
        tvJumlah.setText(jumlahPenumpang + " Passenger(s)");

        buttonAddMultiple = findViewById(R.id.button_add_multiple);
        buttonAddMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



//        detailTrip.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
//            @Override
//            public void onExpandChanged(View v, boolean isExpanded) {
//                Toast.makeText(CreateMultipleActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
//            }
//        });

//        jumlahPenumpang = 3;

        addView();

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.bn_home);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.bn_home:
//                        startActivity(new Intent(CreateMultipleActivity.this, MainActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.bn_my_order:
//                        startActivity(new Intent(CreateMultipleActivity.this, MyOrderActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.bn_account:
//                        startActivity(new Intent(CreateMultipleActivity.this, AccountActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });

    }

//    @Override
//    public void onClick(View view) {
////        addView();
//    }


    private void addView() {

//        View detailPassenger = getLayoutInflater().inflate(R.layout.detail_passenger, null, false);
//        ExpandableCardView cardDetailPassenger = findViewById(R.id.card_detail_passenger);
//        layoutList.addView(detailPassenger);


        for (int i = 0; i < Integer.valueOf(jumlahPenumpang); i++ ){
            View detailPassenger = getLayoutInflater().inflate(R.layout.detail_passenger, null, false);
            ExpandableCardView cardDetailPassenger = findViewById(R.id.card_detail_passenger);

//            checkBoxSubmit.oncli

//            if (checkBoxSubmit.isChecked()){
//                Toast.makeText(CreateMultipleActivity.this, "Checkbox Submit clicked", Toast.LENGTH_SHORT).show();
//            }

//            String jumlah = "Penumpang 1";
//            cardDetailPassenger.setTitle(jumlah);
            layoutList.addView(detailPassenger);
            checkBoxSubmit = findViewById(R.id.checkbox_submit);
            onCheckboxClicked(checkBoxSubmit);
//            showListItem();

        }

        showListItem();

//        cardDetailPassenger.setTitle("Detail Passenger 1");

//        EditText editText = (EditText)cricketerView.findViewById(R.id.edit_cricketer_name);


    }

    private void showListItem() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BookedSeat> bookedSeatCall = apiInterface.bookedSeatResponse(idTrip);
        bookedSeatCall.enqueue(new Callback<BookedSeat>() {
            @Override
            public void onResponse(Call<BookedSeat> call, Response<BookedSeat> response) {
                if (response.isSuccessful()){
                    bookedSeatData = response.body().getData();

                    for (int i = 0; i < bookedSeatData.size(); i++){
                        listBookedSeat.add(bookedSeatData.get(i).getIdSeat());
                    }

                    String[] array = listBookedSeat.toArray(new String[0]);

                    for (int i = 1; i < 8; i++){
                        boolean checkBookedSeat = Arrays.asList(array).contains(String.valueOf(i));

                        if (checkBookedSeat == true) {
                            System.out.println("Skip aja ya, seat udah dibooking");
                        } else {
                            listSpinner.add(String.valueOf(i));
                        }
                    }

                    spinnerMultiSeat = findViewById(R.id.spinner_multi_passenger_seat);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateMultipleActivity.this, android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerMultiSeat.setAdapter(adapter);

                }else{
                    Toast.makeText(CreateMultipleActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookedSeat> call, Throwable t) {
                Toast.makeText(CreateMultipleActivity.this, "Cek koneksi internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        if (checked){
            String namaDetail, genderDetail, seatDetail, destinationDetail, departureDetail, phoneDetail;

//            EditText editText = (EditText)cricketerView.findViewById(R.id.edit_cricketer_name);
            EditText edNameDetail = (EditText)findViewById(R.id.multi_passenger_name);
            namaDetail = edNameDetail.getText().toString();
            Toast.makeText(this, namaDetail, Toast.LENGTH_SHORT).show();
            namaDetail = " ";

//            edNameDetail.setEnabled(false);

//            Toast.makeText(CreateMultipleActivity.this, "Checkbox Submit clicked", Toast.LENGTH_SHORT).show();
//            view.setEnabled(false);
            createDetailPesanan();

        }
    }

    private void createDetailPesanan() {
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

//    private void removeView(View view){
//
//        layoutList.removeView(view);
//
//    }


}


