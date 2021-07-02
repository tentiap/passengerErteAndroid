package com.example.pemesanerte.activity.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pemesanerte.Cricketer;
import com.example.pemesanerte.R;

import java.util.ArrayList;

public class CricketersActivity extends AppCompatActivity {

    RecyclerView recyclerCricketers;
    ArrayList<Cricketer> cricketersList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketers);

        recyclerCricketers = findViewById(R.id.recycler_cricketers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(CricketersActivity.this, RecyclerView.VERTICAL, false);
        recyclerCricketers.setLayoutManager(layoutManager);

        cricketersList = (ArrayList<Cricketer>) getIntent().getExtras().getSerializable("list");

        recyclerCricketers.setAdapter(new CricketerAdapter(cricketersList));


    }
}