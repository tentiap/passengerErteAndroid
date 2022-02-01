package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.pemesanerte.model.detailPesanan.DetailPesanan;
import com.example.pemesanerte.model.idPesanan.IdPesanan;
import com.example.pemesanerte.model.idPesanan.IdPesananData;
import com.example.pemesanerte.model.seat.SeatData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateMultipleActivity extends AppCompatActivity {
    public static final String EXTRA_CHECK_DATA = "extra_check_data";
    LinearLayout layoutList;
    Button buttonDone;
    ExpandableCardView detailTrip;
    String asal, tujuan, jumlahPenumpang, idTrip, idPemesan, idPesanan, jadwal, platMobil;
    String namaDetail, genderDetail, seatDetail, destinationDetail, departureDetail, phoneDetail;
    int checkBeforeDone;

    private List<SeatData> listSeat;
    List<BookedSeatData> bookedSeatData;
    List<String> listSpinner = new ArrayList<>();
    List<String> listBookedSeat = new ArrayList<>();
    List<String> inputSeats = new ArrayList<>();

    CheckBox checkBoxSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_multiple);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Passenger(s)");

        CheckData checkData = getIntent().getParcelableExtra(EXTRA_CHECK_DATA);

        jadwal = checkData.getJadwal();
        idPemesan = checkData.getId_pemesan();
        platMobil = checkData.getPlat_mobil();
        jumlahPenumpang = checkData.getJumlah_penumpang();
        asal = checkData.getAsal();
        tujuan = checkData.getTujuan();

        getIdPesanan();

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
        buttonDone = findViewById(R.id.button_done);
        buttonDone.setVisibility(View.GONE);

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
        checkBeforeDone = 0;

        addView();
        getData();
    }

    private void checkData() {
        if (checkBeforeDone == Integer.valueOf(jumlahPenumpang)){
            buttonDone.setVisibility(View.VISIBLE);
            buttonDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToMyOrder = new Intent(CreateMultipleActivity.this, MyOrderActivity.class);
                    startActivity(goToMyOrder);
                }
            });
        }
    }

    private void getIdPesanan() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<IdPesanan> idPesananCall = apiInterface.idPesananResponse(jadwal, platMobil, idPemesan);
        idPesananCall.enqueue(new Callback<IdPesanan>() {
            @Override
            public void onResponse(Call<IdPesanan> call, Response<IdPesanan> response) {
                List<IdPesananData> data = response.body().getData();

                for (int i = 0; i < data.size(); i++){
                    idPesanan = data.get(i).getIdPesanan();
                }
            }

            @Override
            public void onFailure(Call<IdPesanan> call, Throwable t) {

            }
        });
    }

    private void addView() {

        for (int i = 0; i < Integer.valueOf(jumlahPenumpang); i++ ){
            View detailPassenger = getLayoutInflater().inflate(R.layout.detail_passenger, null, false);
            ExpandableCardView cardDetailPassenger = (ExpandableCardView)detailPassenger.findViewById(R.id.card_detail_passenger);

            layoutList.addView(detailPassenger);

        }

    }

    private void getData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BookedSeat> bookedSeatCall = apiInterface.bookedSeatResponse(jadwal, platMobil);
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

                    for (int i=0; i<layoutList.getChildCount(); i++){
                        View passengerView = layoutList.getChildAt(i);

                        EditText editTextName = (EditText)passengerView.findViewById(R.id.multi_passenger_name);
                        Spinner spinnerGender = (Spinner)passengerView.findViewById(R.id.spinner_multi_passenger_gender);

                        Spinner spinnerSeat = (Spinner)passengerView.findViewById(R.id.spinner_multi_passenger_seat);

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateMultipleActivity.this, android.R.layout.simple_spinner_item, listSpinner);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerSeat.setAdapter(adapter);


                        EditText editTextDeparture = (EditText)passengerView.findViewById(R.id.multi_passenger_from);
                        EditText editTextDestination = (EditText)passengerView.findViewById(R.id.multi_passenger_to);
                        EditText editTextPhone = (EditText)passengerView.findViewById(R.id.multi_passenger_phone);


                        CheckBox checkBoxSubmit = (CheckBox)passengerView.findViewById(R.id.checkbox_submit);
                        checkBoxSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                boolean checked = ((CheckBox) view).isChecked();
                                if (checked){
                                    namaDetail = " ";
                                    genderDetail = " ";
                                    seatDetail = " ";
                                    destinationDetail = " ";
                                    departureDetail = " ";
                                    phoneDetail = " ";

                                    namaDetail = editTextName.getText().toString();
                                    genderDetail = spinnerGender.getSelectedItem().toString();
                                    seatDetail = spinnerSeat.getSelectedItem().toString();
                                    departureDetail = editTextDeparture.getText().toString();
                                    destinationDetail = editTextDestination.getText().toString();
                                    phoneDetail = editTextPhone.getText().toString();

                                    if (namaDetail.trim().equals("")){
                                        editTextName.setError("Nama wajib diisi");
                                        ((CheckBox) view).setChecked(false);
                                    } else if (genderDetail.trim().equals("")){
                                        Toast.makeText(CreateMultipleActivity.this, "Pilih jenis kelamin terlebih dahulu", Toast.LENGTH_SHORT).show();
                                        ((CheckBox) view).setChecked(false);
                                    } else if (seatDetail.trim().equals("")){
                                        Toast.makeText(CreateMultipleActivity.this, "Pilih seat terlebih dahulu", Toast.LENGTH_SHORT).show();
                                        ((CheckBox) view).setChecked(false);
                                    } else if (departureDetail.trim().equals("")){
                                        editTextDeparture.setError("Asal wajib diisi");
                                        ((CheckBox) view).setChecked(false);
                                    } else if (destinationDetail.trim().equals("")){
                                        editTextDestination.setError("Tujuan wajib diisi");
                                        ((CheckBox) view).setChecked(false);
                                    } else{

                                        //Disini cek dia udah dipesan sebelumnya atau ndak
                                        String[] array = inputSeats.toArray(new String[0]);
                                        boolean checkInputSeat = Arrays.asList(array).contains(seatDetail);

                                        if (checkInputSeat == true) {
                                            Toast.makeText(CreateMultipleActivity.this, "Seat "+seatDetail+ " sudah dipesan sebelumnya. Pilih seat lain", Toast.LENGTH_LONG).show();
                                            ((CheckBox) view).setChecked(false);
                                        } else {
                                            inputSeats.add(seatDetail);
                                            Toast.makeText(CreateMultipleActivity.this, "Input seats sekarang "+inputSeats, Toast.LENGTH_SHORT).show();
//                                            saveData(idTrip, idPesanan, seatDetail, namaDetail, genderDetail, departureDetail, destinationDetail, phoneDetail);

                                            view.setEnabled(false);
                                            editTextName.setEnabled(false);
                                            spinnerGender.setEnabled(false);
                                            spinnerSeat.setEnabled(false);
                                            editTextDeparture.setEnabled(false);
                                            editTextDestination.setEnabled(false);
                                            editTextPhone.setEnabled(false);
                                        }

                                    }
                                }
                            }
                        });


                    }


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
//
//    private void saveData(String idTrip, String idPesanan, String seatDetail, String namaDetail, String genderDetail, String departureDetail, String destinationDetail, String phoneDetail) {
//
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<DetailPesanan> detailPesananCall = apiInterface.detailPesananResponse(idTrip, idPesanan, seatDetail, namaDetail, genderDetail, departureDetail, destinationDetail, phoneDetail);
//        detailPesananCall.enqueue(new Callback<DetailPesanan>() {
//            @Override
//            public void onResponse(Call<DetailPesanan> call, Response<DetailPesanan> response) {
//                String message = response.body().getMessage();
//                Toast.makeText(CreateMultipleActivity.this, message, Toast.LENGTH_SHORT).show();
//                checkBeforeDone += 1;
//                checkData();
//
//            }
//
//            @Override
//            public void onFailure(Call<DetailPesanan> call, Throwable t) {
//                Toast.makeText(CreateMultipleActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//    private void showListItem() {
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<BookedSeat> bookedSeatCall = apiInterface.bookedSeatResponse(idTrip);
//        bookedSeatCall.enqueue(new Callback<BookedSeat>() {
//            @Override
//            public void onResponse(Call<BookedSeat> call, Response<BookedSeat> response) {
//                if (response.isSuccessful()){
//                    bookedSeatData = response.body().getData();
//
//                    for (int i = 0; i < bookedSeatData.size(); i++){
//                        listBookedSeat.add(bookedSeatData.get(i).getIdSeat());
//                    }
//
//                    String[] array = listBookedSeat.toArray(new String[0]);
//
//                    for (int i = 1; i < 8; i++){
//                        boolean checkBookedSeat = Arrays.asList(array).contains(String.valueOf(i));
//
//                        if (checkBookedSeat == true) {
//                            System.out.println("Skip aja ya, seat udah dibooking");
//                        } else {
//                            listSpinner.add(String.valueOf(i));
//                        }
//                    }
//
//                }else{
//                    Toast.makeText(CreateMultipleActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BookedSeat> call, Throwable t) {
//                Toast.makeText(CreateMultipleActivity.this, "Cek koneksi internet", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        if (checked){
            String namaDetail, genderDetail, seatDetail, destinationDetail, departureDetail, phoneDetail;

            EditText edNameDetail = (EditText)findViewById(R.id.multi_passenger_name);
            namaDetail = edNameDetail.getText().toString();


            Toast.makeText(this, namaDetail, Toast.LENGTH_SHORT).show();
            namaDetail = " ";
            edNameDetail.setEnabled(false);
            view.setEnabled(false);
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

}


