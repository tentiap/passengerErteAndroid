package com.example.pemesanerte.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pemesanerte.R;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.check.CheckData;
import com.example.pemesanerte.model.search.SearchData;
import com.example.pemesanerte.model.seat.Seat;
import com.example.pemesanerte.model.seat.SeatData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class CreateOrderActivity extends AppCompatActivity {
    public static final String EXTRA_CHECK_DATA = "extra_check_data";
    String JumlahPenumpang, IdTrip, IdUsersPemesan;
    ImageButton arrow1, arrow;
    LinearLayout hiddenView1, hiddenView;
    TextView tvLoop;
    CardView cardView1, cardView;
    private List<SeatData> listSeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        CheckData checkData = getIntent().getParcelableExtra(EXTRA_CHECK_DATA);

        IdTrip = checkData.getId_trip();
//        IdUsersPemesan = checkData.getId_users_pemesan();
//        JumlahPenumpang = checkData.getJumlah_penumpang();

        TextView tvAsal = findViewById(R.id.tv_create_from);
        TextView tvTujuan = findViewById(R.id.tv_create_to);
        TextView tvTanggal = findViewById(R.id.tv_create_tanggal);
        TextView tvJam = findViewById(R.id.tv_create_jam);
        TextView tvJumlah = findViewById(R.id.tv_create_jumlah);

        tvAsal.setText(checkData.getAsal());
        tvTujuan.setText(checkData.getTujuan());
        tvTanggal.setText(checkData.getTanggal());
        tvJam.setText(checkData.getJam());
        tvJumlah.setText(checkData.getJumlah_penumpang() + " Passenger(s)");

        Toast.makeText(this, "Silakan isi data penumpang", Toast.LENGTH_SHORT).show();

        tvLoop = findViewById(R.id.tv_loop);

        int in = Integer.valueOf(checkData.getJumlah_penumpang().toString());
        for (int i = 0; i < in; i++ ){
//            loop.setText("Seat yang sudah diisi : ");
//            loop.append("i = " + i);
//            TextView heading = findViewById(R.id.heading);
//            heading.setText(heading.getText().toString() + i + 1);
            tvLoop.setText(tvLoop.getText().toString() + i + ", ");
//            loop.append("\n");
        }


        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.arrow_button);
        hiddenView = findViewById(R.id.hidden_view);

        cardView1 = findViewById(R.id.base_cardview1);
        arrow1 = findViewById(R.id.arrow_button1);
        hiddenView1 = findViewById(R.id.hidden_view1);


        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (hiddenView1.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView1,
                            new AutoTransition());
                    hiddenView1.setVisibility(View.GONE);
                    arrow1.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView1,
                            new AutoTransition());
                    hiddenView1.setVisibility(View.VISIBLE);
                    arrow1.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (hiddenView.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });

//        seat(IdTrip);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        startActivity(new Intent(CreateOrderActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_my_order:
                        startActivity(new Intent(CreateOrderActivity.this, MyOrderActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(CreateOrderActivity.this, AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Passenger(s)");
    }

//    private void seat(String idTrip) {
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<Seat> seatCall = apiInterface.seatResponse(idTrip);
//        seatCall.enqueue(new Callback<Seat>() {
//            @Override
//            public void onResponse(Call<Seat> call, Response<Seat> response) {
////                SeatData seatData = listSeat.get(pos)
//            }
//
//            @Override
//            public void onFailure(Call<Seat> call, Throwable t) {
//
//            }
//        });
//
//    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}