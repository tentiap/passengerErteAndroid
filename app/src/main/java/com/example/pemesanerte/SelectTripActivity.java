package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pemesanerte.adapter.SearchAdapter;
import com.example.pemesanerte.model.search.Search;

import java.util.ArrayList;

public class SelectTripActivity extends AppCompatActivity {
    private RecyclerView rvSelectTrip;
    private ArrayList<Search> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trip);

        rvSelectTrip = findViewById(R.id.rv_select_trip);
        rvSelectTrip.setHasFixedSize(true);

        list.addAll(getListSearch());
        showRecyclerList();
    }

    public ArrayList<Search> getListSearch() {
        String[] dataTrip = getResources().getStringArray(R.array.array_trip);
        String[] dataJam = getResources().getStringArray(R.array.array_jam);
        String[] dataSopir = getResources().getStringArray(R.array.array_sopir);

        ArrayList<Search> listSearch = new ArrayList<>();
        for (int i = 0; i < dataTrip.length; i++) {
            Search search = new Search();
            search.setIdTrip(dataTrip[i]);
            search.setJadwal(dataJam[i]);
            search.setIdUsersSopir(dataSopir[i]);

            listSearch.add(search);
        }

        return listSearch;
    }

    private void showRecyclerList() {
        rvSelectTrip.setLayoutManager(new LinearLayoutManager(this));
        final SearchAdapter searchAdapter = new SearchAdapter(list);
        rvSelectTrip.setAdapter(searchAdapter);

        searchAdapter.setOnItemClickCallback(new SearchAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Search data) {
                Intent selectTripIntent = new Intent(SelectTripActivity.this, CreateOrderActivity.class);
//                selectTripIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
                startActivity(selectTripIntent);
                Toast.makeText(SelectTripActivity.this, "Kamu memilih " + data.getIdTrip(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}