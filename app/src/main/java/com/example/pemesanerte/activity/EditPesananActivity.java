package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
//import com.example.pemesanerte.model.check.CheckDataOld;
import com.example.pemesanerte.model.check.CheckData;
//import com.example.pemesanerte.model.editDetailPesanan.EditDetailPesananOld;
//import com.example.pemesanerte.model.editDetailPesanan.EditDetailPesananDataOld;
import com.example.pemesanerte.model.editDetailPesanan.EditDetailPesanan;
import com.example.pemesanerte.model.editDetailPesanan.EditDetailPesananData;
//import com.example.pemesanerte.model.idPesanan.IdPesananOld;
//import com.example.pemesanerte.model.idPesanan.IdPesananDataOld;
import com.example.pemesanerte.model.idPesanan.IdPesanan;
import com.example.pemesanerte.model.idPesanan.IdPesananData;
import com.example.pemesanerte.model.seat.SeatData;
import com.example.pemesanerte.model.updateDetailPesanan.UpdateDetailPesanan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPesananActivity extends AppCompatActivity {

    public static String EXTRA_CHECK_DATA_EDIT;
    LinearLayout layoutList;
    Button buttonDone;
    ExpandableCardView detailTrip;
    Spinner spinnerSeat;
    String asal, tujuan, jumlahPenumpang, jadwal, idPemesan, platMobil, idPesanan;
    String namaDetail, genderDetail, seatDetail, destinationDetail, departureDetail, phoneDetail, statusDetail, selectedStatus;
    int orderNumber, checkBeforeDone;

    private List<SeatData> listSeat;
    List<BookedSeatData> bookedSeatData;
    List<EditDetailPesananData> detailPesananData;
    List<String> listSpinner = new ArrayList<>();
    List<String> listBookedSeat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pesanan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Edit Data Passenger(s)");

        CheckData checkData = getIntent().getParcelableExtra(EXTRA_CHECK_DATA_EDIT);
        jadwal = checkData.getJadwal();
        idPemesan = checkData.getId_pemesan();
        platMobil = checkData.getPlat_mobil();
        jumlahPenumpang = checkData.getJumlah_penumpang();
        asal = checkData.getAsal();
        tujuan = checkData.getTujuan();

        System.out.println("Check Data: "+checkData.getJadwal());

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

        layoutList = findViewById(R.id.layout_list_edit);
        detailTrip = findViewById(R.id.card_detail_trip_edit);
        detailTrip.expand();

        TextView tvAsal = findViewById(R.id.tv_create_from_edit);
        TextView tvTujuan = findViewById(R.id.tv_create_to_edit);
        TextView tvTanggal = findViewById(R.id.tv_create_tanggal_edit);
        TextView tvJam = findViewById(R.id.tv_create_jam_edit);
        TextView tvJumlah = findViewById(R.id.tv_create_jumlah_edit);

        tvAsal.setText(asal);
        tvTujuan.setText(tujuan);
        tvTanggal.setText(checkData.getTanggal());
        tvJam.setText(checkData.getJam());
        tvJumlah.setText(jumlahPenumpang + " Passenger(s)");

        buttonDone = findViewById(R.id.button_done_edit);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMyOrder = new Intent(EditPesananActivity.this, MyOrderActivity.class);
                startActivity(goToMyOrder);
            }
        });

        addView();
        getData();

    }

    private void getIdPesanan() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<IdPesanan> idPesananCall = apiInterface.idPesananResponse(jadwal, platMobil, idPemesan);
        idPesananCall.enqueue(new Callback<IdPesanan>() {
            @Override
            public void onResponse(Call<IdPesanan> call, Response<IdPesanan> response) {

                List<IdPesananData> data = response.body().getData();

                for (int i = 0; i < data.size(); i++){
                    //harusnya idPesanan
                    idPesanan = data.get(i).getIdPemesan();
                }

            }

            @Override
            public void onFailure(Call<IdPesanan> call, Throwable t) {

            }
        });
    }

    private void getData() {

//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<IdPesanan> idPesananCall = apiInterface.idPesananResponse(jadwal, platMobil, idPemesan);
//        idPesananCall.enqueue(new Callback<IdPesanan>() {
//            @Override
//            public void onResponse(Call<IdPesanan> call, Response<IdPesanan> response) {
//
//                List<IdPesananData> data = response.body().getData();
//
//                for (int i = 0; i < data.size(); i++){
//                    //harusnya idPesanan
//                    idPesanan = data.get(i).getIdPemesan();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<IdPesanan> call, Throwable t) {
//                System.out.println("Gagal get Id");
//            }
//        });

        System.out.println("Id Pemesan: "+idPemesan+ " Jadwal: "+jadwal+ " Plat Mobil: "+platMobil);

        ApiInterface apiInterface1 = ApiClient.getClient().create(ApiInterface.class);
        Call<EditDetailPesanan> detailPesananCall = apiInterface1.getDetailPesananResponse(idPemesan, jadwal, platMobil);
        detailPesananCall.enqueue(new Callback<EditDetailPesanan>() {
            @Override
            public void onResponse(Call<EditDetailPesanan> call, Response<EditDetailPesanan> response) {

                detailPesananData = response.body().getData();
                System.out.println("Halo, ini detail pesanan data" +detailPesananData);


                ApiInterface apiInterface2 = ApiClient.getClient().create(ApiInterface.class);
                Call<BookedSeat> bookedSeatCall = apiInterface2.bookedSeatResponse(jadwal, platMobil);
                bookedSeatCall.enqueue(new Callback<BookedSeat>() {
                    @Override
                    public void onResponse(Call<BookedSeat> call, Response<BookedSeat> response) {
                        bookedSeatData = response.body().getData();
                        System.out.println("BookedSeatData" +bookedSeatData);


                        for (int i = 0; i < bookedSeatData.size(); i++){
                            listBookedSeat.add(bookedSeatData.get(i).getIdSeat());
                        }

                        String[] array = listBookedSeat.toArray(new String[0]);

                        for (int i = 1; i < 8; i++){
                            boolean checkBookedSeat = Arrays.asList(array).contains(String.valueOf(i));

                            if (checkBookedSeat == true) {
                                System.out.println("Skip aja ya, seat "+i+ " udah dibooking");
                            } else {
                                listSpinner.add(String.valueOf(i));
                            }
                        }

                        System.out.println("List spinner: "+listSpinner);

                        for (int i=0; i<layoutList.getChildCount(); i++){
                            View detailPassengerView = layoutList.getChildAt(i);

                            EditText editTextName = (EditText)detailPassengerView.findViewById(R.id.multi_passenger_name_edit);
                            editTextName.setText(detailPesananData.get(i).getNamaPenumpang());

                            Spinner spinnerGender = (Spinner)detailPassengerView.findViewById(R.id.spinner_multi_passenger_gender_edit);
                            spinnerGender.setSelection(getIndexGender(spinnerGender, detailPesananData.get(i).getJenisKelamin()));

                            Spinner spinnerStatus = (Spinner)detailPassengerView.findViewById(R.id.spinner_multi_passenger_status_edit);
                            spinnerStatus.setSelection(getIndexStatus(spinnerStatus, detailPesananData.get(i).getStatus()));

//                            Toast.makeText(EditPesananActivity.this, "Status si "+detailPesananData.get(i).getNamaPenumpang()+ " = "+detailPesananData.get(i).getStatus(), Toast.LENGTH_SHORT).show();

                            Spinner spinnerSeat =(Spinner)detailPassengerView.findViewById(R.id.spinner_multi_passenger_seat_edit);
                            TextView textViewSeatAvailable = (TextView)detailPassengerView.findViewById(R.id.tv_seat_edit);
//                            textViewSeatAvailable.setText("Seat (Available seat: " +listSpinner+ ")");
                            spinnerSeat.setSelection(getIndexSeat(spinnerSeat, detailPesananData.get(i).getIdSeat()));
                            spinnerSeat.setEnabled(false);

                            EditText editTextDeparture = (EditText)detailPassengerView.findViewById(R.id.multi_passenger_from_edit);
                            editTextDeparture.setText(detailPesananData.get(i).getDetailAsal());

                            EditText editTextDestination = (EditText)detailPassengerView.findViewById(R.id.multi_passenger_to_edit);
                            editTextDestination.setText(detailPesananData.get(i).getDetailTujuan());

                            EditText editTextPhone = (EditText)detailPassengerView.findViewById(R.id.multi_passenger_phone_edit);
                            editTextPhone.setText(detailPesananData.get(i).getNoHp());

                            //harusnya idDetailPesanan
                            orderNumber = detailPesananData.get(i).getOrderNumber();

                            CheckBox checkBoxSubmit = (CheckBox)detailPassengerView.findViewById(R.id.checkbox_submit_edit);
                            checkBoxSubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    boolean checked = ((CheckBox) view).isChecked();
                                    if (checked){
                                        namaDetail = editTextName.getText().toString();
                                        genderDetail = spinnerGender.getSelectedItem().toString();
                                        seatDetail = spinnerSeat.getSelectedItem().toString();
                                        departureDetail = editTextDeparture.getText().toString();
                                        destinationDetail = editTextDestination.getText().toString();
                                        phoneDetail = editTextPhone.getText().toString();

                                        selectedStatus = spinnerStatus.getSelectedItem().toString();
                                        switch (selectedStatus){
                                            case "Booking":
                                                statusDetail = String.valueOf(1);
                                                break;
                                            case "Cancelled":
                                                statusDetail = String.valueOf(5);
                                                break;
                                        }

                                        if (namaDetail.trim().equals("")){
                                            editTextName.setError("Nama wajib diisi");
                                            ((CheckBox) view).setChecked(false);
                                        } else if (genderDetail.trim().equals("")){
                                            Toast.makeText(EditPesananActivity.this, "Pilih jenis kelamin terlebih dahulu", Toast.LENGTH_SHORT).show();
                                            ((CheckBox) view).setChecked(false);
                                        } else if (seatDetail.trim().equals("")){
                                            Toast.makeText(EditPesananActivity.this, "Pilih seat terlebih dahulu", Toast.LENGTH_SHORT).show();
                                            ((CheckBox) view).setChecked(false);
                                        } else if (statusDetail.trim().equals("")){
                                            Toast.makeText(EditPesananActivity.this, "Pilih status terlebih dahulu", Toast.LENGTH_SHORT).show();
                                            ((CheckBox) view).setChecked(false);
                                        } else if (departureDetail.trim().equals("")){
                                            editTextDeparture.setError("Asal wajib diisi");
                                            ((CheckBox) view).setChecked(false);
                                        } else if (destinationDetail.trim().equals("")){
                                            editTextDestination.setError("Tujuan wajib diisi");
                                            ((CheckBox) view).setChecked(false);
                                        } else{

                                            view.setEnabled(false);
                                            editTextName.setEnabled(false);
                                            spinnerGender.setEnabled(false);
                                            spinnerStatus.setEnabled(false);
//                                            spinnerSeat.setEnabled(false);
                                            editTextDeparture.setEnabled(false);
                                            editTextDestination.setEnabled(false);
                                            editTextPhone.setEnabled(false);

                                            updateDetailPesanan(jadwal, platMobil, idPemesan, seatDetail, namaDetail, genderDetail, departureDetail, destinationDetail, phoneDetail, statusDetail);

                                        }
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<BookedSeat> call, Throwable t) {
                        System.out.println("Gagal Booked Seat");

                    }
                });

            }

            @Override
            public void onFailure(Call<EditDetailPesanan> call, Throwable t) {
                System.out.println("Gagal Edit Detail Pesanan");
            }
        });
    }

    private int getIndexStatus(Spinner spinnerStatus, String status) {
        for (int i=0; i < spinnerStatus.getCount(); i++){
            if (spinnerStatus.getItemAtPosition(i).toString().equalsIgnoreCase(status)){
                return i;
            }
        }
        return 0;
    }

    private void updateDetailPesanan(String jadwal, String platMobil, String idPemesan, String seatDetail, String namaDetail, String genderDetail, String departureDetail, String destinationDetail, String phoneDetail, String statusDetail) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<UpdateDetailPesanan> updateDetailPesananCall = apiInterface.updateDetailPesananResponse(jadwal, platMobil, idPemesan, seatDetail, namaDetail, genderDetail, departureDetail, destinationDetail, phoneDetail, statusDetail);
        updateDetailPesananCall.enqueue(new Callback<UpdateDetailPesanan>() {
            @Override
            public void onResponse(Call<UpdateDetailPesanan> call, Response<UpdateDetailPesanan> response) {
                String message = response.body().getMessage();
                Toast.makeText(EditPesananActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UpdateDetailPesanan> call, Throwable t) {

            }
        });
    }


    private int getIndexSeat(Spinner spinnerSeat, String idSeat) {
        for (int i=0; i < spinnerSeat.getCount(); i++){
            if (spinnerSeat.getItemAtPosition(i).toString().equalsIgnoreCase(idSeat)){
                return i;
            }
        }
        return 0;
    }

    private int getIndexGender(Spinner spinnerGender, String jenisKelamin) {
        for (int i=0; i < spinnerGender.getCount(); i++){
            if (spinnerGender.getItemAtPosition(i).toString().equalsIgnoreCase(jenisKelamin)){
                return i;
            }
        }
        return 0;
    }

    private void addView() {
        for (int i = 0; i < Integer.valueOf(jumlahPenumpang); i++ ){
            View detailPassenger = getLayoutInflater().inflate(R.layout.detail_passenger_edit, null, false);
            layoutList.addView(detailPassenger);
            System.out.println("Udah sampai addView()");
        }
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