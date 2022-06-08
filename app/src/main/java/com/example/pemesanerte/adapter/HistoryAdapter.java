package com.example.pemesanerte.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pemesanerte.R;
import com.example.pemesanerte.model.history.HistoryData;
//import com.example.pemesanerte.model.history.HistoryDataOld;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private Context ctx;
    private List<HistoryData> listHistory;

    public HistoryAdapter(Context ctx, List<HistoryData> listHistory) {
        this.ctx = ctx;
        this.listHistory = listHistory;
    }


    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_history, parent, false);
        HistoryHolder holder = new HistoryHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryHolder holder, int position) {
        HistoryData historyData = listHistory.get(position);
        holder.tvAsal.setText(historyData.getIdKotaAsal());
        holder.tvTujuan.setText(historyData.getIdKotaTujuan());
        holder.tvJadwal.setText(historyData.getTanggal());
        holder.tvJam.setText(historyData.getJadwal());
        holder.tvPesan.setText(historyData.getTanggalPesan());
        holder.tvPlatMobil.setText(historyData.getPlatMobil());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listHistory.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        TextView tvIdPesanan, tvAsal, tvTujuan, tvJadwal, tvJam, tvPesan, tvPlatMobil;

        public HistoryHolder(@NonNull View view) {
            super(view);

            tvAsal = itemView.findViewById(R.id.tv_item_asal);
            tvTujuan = itemView.findViewById(R.id.tv_item_tujuan);
            tvJadwal = itemView.findViewById(R.id.tv_item_jadwal);
            tvJam = itemView.findViewById(R.id.tv_item_jam);
            tvPesan = itemView.findViewById(R.id.tv_item_tanggal_pesan);
            tvPlatMobil = itemView.findViewById(R.id.tv_plat_mobil);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(HistoryData data);
    }


}
