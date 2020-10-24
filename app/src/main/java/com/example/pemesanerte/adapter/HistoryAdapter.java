package com.example.pemesanerte.adapter;

import com.example.pemesanerte.model.history.HistoryData;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private ArrayList<HistoryData> listHistory;

    public HistoryAdapter(ArrayList<HistoryData> list) {
        this.listHistory = list;
    }
}
