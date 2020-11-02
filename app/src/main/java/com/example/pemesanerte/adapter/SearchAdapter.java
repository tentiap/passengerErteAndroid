package com.example.pemesanerte.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pemesanerte.R;
import com.example.pemesanerte.model.history.HistoryData;
import com.example.pemesanerte.model.search.Search;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

    private ArrayList<Search> listSearch;
    public SearchAdapter(ArrayList<Search> list) {
        this.listSearch = list;
    }

    private onItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_select_trip, viewGroup, false);
        return new SearchAdapter.SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchHolder holder, int position) {
        Search search = listSearch.get(position);

        holder.tvIdSelectTrip.setText(search.getIdTrip());
        holder.tvSelectJam.setText(search.getJadwal());
        holder.tvSelectSopir.setText(search.getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listSearch.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSearch.size();
    }

    public class SearchHolder extends RecyclerView.ViewHolder {
        TextView tvIdSelectTrip, tvSelectJam, tvSelectSopir;

        public SearchHolder(@NonNull View view) {
            super(view);

            tvIdSelectTrip = itemView.findViewById(R.id.tv_id_select_trip);
            tvSelectJam = itemView.findViewById(R.id.tv_select_jam);
            tvSelectSopir = itemView.findViewById(R.id.tv_select_sopir);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Search data);
    }
}
