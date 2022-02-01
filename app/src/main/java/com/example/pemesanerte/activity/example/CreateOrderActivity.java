//package com.example.pemesanerte.activity.example;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//import androidx.transition.AutoTransition;
//import androidx.transition.TransitionManager;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//import com.example.pemesanerte.R;
//import com.example.pemesanerte.activity.AccountActivity;
//import com.example.pemesanerte.activity.MainActivity;
//import com.example.pemesanerte.activity.MyOrderActivity;
//import com.example.pemesanerte.api.ApiClient;
//import com.example.pemesanerte.api.ApiInterface;
//import com.example.pemesanerte.model.bookedSeat.BookedSeat;
//import com.example.pemesanerte.model.bookedSeat.BookedSeatData;
////import com.example.pemesanerte.model.check.CheckDataOld;
//import com.example.pemesanerte.model.check.CheckData;
//import com.example.pemesanerte.model.seat.SeatData;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class CreateOrderActivity extends AppCompatActivity {
//    public static final String EXTRA_CHECK_DATA = "extra_check_data";
//    String JumlahPenumpang, IdTrip, IdPemesan, Jadwal, PlatMobil;
//    ImageButton arrow1, arrow;
//    LinearLayout hiddenView1, hiddenView;
////    TextView tvLoop;
//    CardView cardView1, cardView;
//    Button btnBook;
//    Spinner spinnerSeat;
//    private List<SeatData> listSeat;
//
//    List<BookedSeatData> bookedSeatData;
//    List<String> listSpinner = new ArrayList<String>();
////    String[] listBookedSeat;
//    List<String> listBookedSeat = new ArrayList<>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_create_order);
//
//        CheckData checkData = getIntent().getParcelableExtra(EXTRA_CHECK_DATA);
//
//        Jadwal = checkData.getJadwal();
//        IdPemesan = checkData.getId_pemesan();
//        PlatMobil = checkData.getPlat_mobil();
//        JumlahPenumpang = checkData.getJumlah_penumpang();
//
//        TextView tvAsal = findViewById(R.id.tv_create_from);
//        TextView tvTujuan = findViewById(R.id.tv_create_to);
//        TextView tvTanggal = findViewById(R.id.tv_create_tanggal);
//        TextView tvJam = findViewById(R.id.tv_create_jam);
//        TextView tvJumlah = findViewById(R.id.tv_create_jumlah);
//        spinnerSeat = findViewById(R.id.spinner_seat_available);
//
//
//        tvAsal.setText(checkData.getAsal());
//        tvTujuan.setText(checkData.getTujuan());
//        tvTanggal.setText(checkData.getTanggal());
//        tvJam.setText(checkData.getJam());
//        tvJumlah.setText(checkData.getJumlah_penumpang() + " Passenger(s)");
//
//        Toast.makeText(this, "Silakan isi data penumpang", Toast.LENGTH_SHORT).show();
//
////        tvLoop = findViewById(R.id.tv_loop);
//
////        int in = Integer.valueOf(checkData.getJumlah_penumpang().toString());
////        for (int i = 0; i < in; i++ ){
//////            loop.setText("Seat yang sudah diisi : ");
//////            loop.append("i = " + i);
//////            TextView heading = findViewById(R.id.heading);
//////            heading.setText(heading.getText().toString() + i + 1);
//////            tvLoop.setText(tvLoop.getText().toString() + i + ", ");
//////            loop.append("\n");
////        }
//
//
//        cardView = findViewById(R.id.base_cardview);
//        arrow = findViewById(R.id.arrow_button);
//        hiddenView = findViewById(R.id.hidden_view);
//
//        cardView1 = findViewById(R.id.base_cardview1);
//        arrow1 = findViewById(R.id.arrow_button1);
//        hiddenView1 = findViewById(R.id.hidden_view1);
//
//        showListItem();
//
//        arrow1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // If the CardView is already expanded, set its visibility
//                //  to gone and change the expand less icon to expand more.
//                if (hiddenView1.getVisibility() == View.VISIBLE) {
//
//                    // The transition of the hiddenView is carried out
//                    //  by the TransitionManager class.
//                    // Here we use an object of the AutoTransition
//                    // Class to create a default transition.
//                    TransitionManager.beginDelayedTransition(cardView1,
//                            new AutoTransition());
//                    hiddenView1.setVisibility(View.GONE);
//                    arrow1.setImageResource(R.drawable.ic_baseline_expand_more_24);
//
//                }
//
//                // If the CardView is not expanded, set its visibility
//                // to visible and change the expand more icon to expand less.
//                else {
//
//                    TransitionManager.beginDelayedTransition(cardView1,
//                            new AutoTransition());
//                    hiddenView1.setVisibility(View.VISIBLE);
//                    arrow1.setImageResource(R.drawable.ic_baseline_expand_less_24);
//                }
//            }
//        });
//
//        arrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // If the CardView is already expanded, set its visibility
//                //  to gone and change the expand less icon to expand more.
//                if (hiddenView.getVisibility() == View.VISIBLE) {
//
//                    // The transition of the hiddenView is carried out
//                    //  by the TransitionManager class.
//                    // Here we use an object of the AutoTransition
//                    // Class to create a default transition.
//                    TransitionManager.beginDelayedTransition(cardView,
//                            new AutoTransition());
//                    hiddenView.setVisibility(View.GONE);
//                    arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
//                }
//
//                // If the CardView is not expanded, set its visibility
//                // to visible and change the expand more icon to expand less.
//                else {
//
//                    TransitionManager.beginDelayedTransition(cardView,
//                            new AutoTransition());
//                    hiddenView.setVisibility(View.VISIBLE);
//                    arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
//
//                }
//            }
//        });
//
//
//
////       showAvailableSeat();
//
//
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.bn_home);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.bn_home:
//                        startActivity(new Intent(CreateOrderActivity.this, MainActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.bn_my_order:
//                        startActivity(new Intent(CreateOrderActivity.this, MyOrderActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.bn_account:
//                        startActivity(new Intent(CreateOrderActivity.this, AccountActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("Add Passenger(s)");
//    }
//
//    private void showListItem() {
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<BookedSeat> bookedSeatCall = apiInterface.bookedSeatResponse(Jadwal, PlatMobil);
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
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateOrderActivity.this, android.R.layout.simple_spinner_item, listSpinner);
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinnerSeat.setAdapter(adapter);
//
//                }else{
//                    Toast.makeText(CreateOrderActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BookedSeat> call, Throwable t) {
//                Toast.makeText(CreateOrderActivity.this, "Cek koneksi internet", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
////    private void showListItemKacau() {
////        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
////        Call<BookedSeat> bookedSeatCall = apiInterface.bookedSeatResponse(IdTrip);
////        bookedSeatCall.enqueue(new Callback<BookedSeat>() {
////            @Override
////            public void onResponse(Call<BookedSeat> call, Response<BookedSeat> response) {
////                if (response.isSuccessful()){
////                    List<BookedSeatData> bookedSeatData = response.body().getData();
//////                                List<String> listSpinner = new ArrayList<String>();
//////                                List<String> listBookedSeat = new ArrayList<>();
//////
////                    for (int i = 0; i < bookedSeatData.size(); i++){
////                        listBookedSeat.add(bookedSeatData.get(i).getIdSeat());
////                    }
////
//////                   String[] arr = new String[listBookedSeat.size()];
//////                    arr = (String[]) listBookedSeat.toArray();
////
//////                    Integer arr[] = { 1, 3 };
////
////                    String[] array = listBookedSeat.toArray(new String[0]);
//////                    System.out.println(array);
//////                    for (String s : array) {
//////                        System.out.println(s);
//////                    }
////
//////                    System.out.println(listBookedSeat.getClass().getSimpleName());
//////                    System.out.println(listBookedSeat);
//////                    System.out.println(arr[0]);
////
////
////                    for (int i = 1; i < 8; i++){
////
//////                        Integer arr[] = {1, 2, 3, 4, 5, 6};
////                        boolean checkBookedSeat = Arrays.asList(array).contains(String.valueOf(i));
////
//////
////                        if (checkBookedSeat == true) {
////                            System.out.println("Skip aja ya, seat udah dibooking");
////                        } else {
////                            listSpinner.add(String.valueOf(i));
////                        }
////
//////                                    listSpinner.add(bookedSeatDataList.get(i).getIdSeat());
////                    }
////
//////                    for (int i = 1; i <= 7; i++ ){
//////                        for (int j = 0; j < bookedSeatData.size(); j++){
//////                            listBookedSeat.add(bookedSeatData.get(j).getIdSeat());
//////                        }
//////
//////                        boolean checkBookedSeat = listBookedSeat.contains(i);
//////                        if (checkBookedSeat == true) {
//////                            System.out.println("Skip aja ya, seat udah dibooking");
//////                        } else {
//////                            listSpinner.add(String.valueOf(i));
//////                        }
//////                    }
//////
////                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateOrderActivity.this, android.R.layout.simple_spinner_item, listSpinner);
////                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////                    spinnerSeat.setAdapter(adapter);
////
////                }
////
//////                                System.out.println(Arrays.toString(bookedSeatData.toArray()));
////
//////                    System.out.println(listBookedSeat);
////
//////                                for (int i = 1; i < 8; i++){
//////
//////                                    boolean checkBookedSeat = listBookedSeat.contains(i);
////////
//////                                    if (checkBookedSeat == true) {
//////                                            System.out.println("Skip aja ya, seat udah dibooking");
//////                                    } else {
//////                                            listSpinner.add(String.valueOf(i));
//////                                    }
//////
////////                                    listSpinner.add(bookedSeatDataList.get(i).getIdSeat());
//////                                }
//////
//////                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateOrderActivity.this, android.R.layout.simple_spinner_item, listSpinner);
//////                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//////                                spinnerSeat.setAdapter(adapter);
////                else{
////                    Toast.makeText(CreateOrderActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
////                }
////
////            }
////
////            @Override
////            public void onFailure(Call<BookedSeat> call, Throwable t) {
////                Toast.makeText(CreateOrderActivity.this, "Cek koneksi internet", Toast.LENGTH_SHORT).show();
////
////            }
////        });
////    }
//
////    private void showAvailableSeat() {
////        for (int i = 0; i < 7; i++){
////
////            boolean checkBookedSeat = listBookedSeat.contains(i+1);
////
////            if (checkBookedSeat == true) {
////                System.out.println("Skip aja ya, seat udah dibooking");
//////                listSpinner.add(String.valueOf(i));
////
////            } else {
////                listSpinner.add(String.valueOf(i));
//////                System.out.println("Skip aja ya, seat udah dibooking");
////
////            }
////
////        }
////
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateOrderActivity.this, android.R.layout.simple_spinner_item, listSpinner);
////        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////        spinnerSeat.setAdapter(adapter);
////    }
//
////    private void seat(String idTrip) {
////        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
////        Call<Seat> seatCall = apiInterface.seatResponse(idTrip);
////        seatCall.enqueue(new Callback<Seat>() {
////            @Override
////            public void onResponse(Call<Seat> call, Response<Seat> response) {
//////                SeatData seatData = listSeat.get(pos)
////            }
////
////            @Override
////            public void onFailure(Call<Seat> call, Throwable t) {
////
////            }
////        });
////
////    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
//}