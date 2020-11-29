package com.example.pemesanerte.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pemesanerte.R;
import com.example.pemesanerte.model.search.SearchData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {
    private Context ctx;
    private List<SearchData> listSearch;

    public SearchAdapter(Context ctx, List<SearchData> listSearch) {
        this.ctx = ctx;
        this.listSearch = listSearch;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_select_trip, viewGroup, false);
//        return new SearchAdapter.SearchHolder(view);
        SearchAdapter.SearchHolder holder = new SearchAdapter.SearchHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchHolder holder, int position) {
        SearchData searchData = listSearch.get(position);

        holder.tvIdSelectTrip.setText(searchData.getIdTrip());
        holder.tvSelectJam.setText(searchData.getJadwal());
//        holder.tvSelectSopir.setText(searchData.getNama());

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
        TextView tvIdSelectTrip, tvSelectJam;

        public SearchHolder(@NonNull View view) {
            super(view);

            tvIdSelectTrip = itemView.findViewById(R.id.tv_id_select_trip);
            tvSelectJam = itemView.findViewById(R.id.tv_select_jam);
//            tvSelectSopir = itemView.findViewById(R.id.tv_select_sopir);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(SearchData data);
    }
}
