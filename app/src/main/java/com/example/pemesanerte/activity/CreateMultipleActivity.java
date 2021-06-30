package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.pemesanerte.R;

import java.util.ArrayList;
import java.util.List;

public class CreateMultipleActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutList;
    Button buttonAdd;
    ExpandableCardView detailTrip;
    int jumlahPenumpang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_multiple);

        layoutList = findViewById(R.id.layout_list);
        detailTrip = findViewById(R.id.card_detail_trip);
        detailTrip.expand();

        detailTrip.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(CreateMultipleActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        jumlahPenumpang = 3;

        addView();


        buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
//        addView();
    }


    private void addView() {

//        View detailPassenger = getLayoutInflater().inflate(R.layout.detail_passenger, null, false);
//        ExpandableCardView cardDetailPassenger = findViewById(R.id.card_detail_passenger);
//        layoutList.addView(detailPassenger);


        for (int i = 0; i < jumlahPenumpang; i++ ){
            View detailPassenger = getLayoutInflater().inflate(R.layout.detail_passenger, null, false);
            ExpandableCardView cardDetailPassenger = findViewById(R.id.card_detail_passenger);
//            String jumlah = "Penumpang 1";
//            cardDetailPassenger.setTitle(jumlah);
            layoutList.addView(detailPassenger);
        }




//        cardDetailPassenger.setTitle("Detail Passenger 1");

//        EditText editText = (EditText)cricketerView.findViewById(R.id.edit_cricketer_name);


    }

//    private void removeView(View view){
//
//        layoutList.removeView(view);
//
//    }


}


