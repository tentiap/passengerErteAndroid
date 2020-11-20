//package com.example.pemesanerte.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.pemesanerte.R;
//import com.example.pemesanerte.model.history.HistoryData;
//
//import java.util.ArrayList;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
//    private ArrayList<HistoryData> listHistory;
//    public HistoryAdapter(ArrayList<HistoryData> list) {
//        this.listHistory = list;
//    }
//
//    private OnItemClickCallback onItemClickCallback;
//
//    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback;
//    }
//
//
//    @NonNull
//    @Override
//    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_history, viewGroup, false);
//        return new HistoryHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final HistoryHolder holder, int position) {
//        HistoryData historyData = listHistory.get(position);
//
////        holder.tvIdPesanan.setText(historyData.getIdPesanan());
//        holder.tvAsal.setText(historyData.getIdKotaAsal());
//        holder.tvTujuan.setText(historyData.getIdKotaTujuan());
//        holder.tvJadwal.setText(historyData.getJadwal());
//        holder.tvJam.setText(historyData.getJadwal());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(listHistory.get(holder.getAdapterPosition()));
//            }
//        });
//
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                onItemClickCallback.onItemClicked(listHistory.get(holder.getAdapterPosition()));
////                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listHistory.get(holder.getAdapterPosition()).getIdPesanan(), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return listHistory.size();
//    }
//
//    public class HistoryHolder extends RecyclerView.ViewHolder {
//        TextView tvIdPesanan, tvAsal, tvTujuan, tvJadwal, tvJam;
//
//        public HistoryHolder(@NonNull View view) {
//            super(view);
////            tvIdPesanan = itemView.findViewById(R.id.tv_id_pesanan);
//            tvAsal = itemView.findViewById(R.id.tv_item_asal);
//            tvTujuan = itemView.findViewById(R.id.tv_item_tujuan);
//            tvJadwal = itemView.findViewById(R.id.tv_item_jadwal);
//            tvJam = itemView.findViewById(R.id.tv_item_jam);
//        }
//    }
//
//    public interface OnItemClickCallback {
//        void onItemClicked(HistoryData data);
//    }
//
//
//}
