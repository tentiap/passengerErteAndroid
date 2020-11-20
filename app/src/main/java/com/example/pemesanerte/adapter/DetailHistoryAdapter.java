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
//public class DetailHistoryAdapter extends RecyclerView.Adapter<DetailHistoryAdapter.DetailHistoryHolder> {
//
//    private ArrayList<HistoryData> listDetailHistory;
//    public DetailHistoryAdapter(ArrayList<HistoryData> list) {
//        this.listDetailHistory = list;
//    }
//
//
//    @NonNull
//    @Override
//    public DetailHistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail_order, viewGroup, false);
//        return new DetailHistoryHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final DetailHistoryHolder detailHolder, int position) {
//        HistoryData detailHistoryData = listDetailHistory.get(position);
//
//        detailHolder.tvPassengerName.setText(detailHistoryData.getNamaPenumpang());
//        detailHolder.tvPassengerGender.setText(detailHistoryData.getJenisKelamin());
//        detailHolder.tvPassengerAsal.setText(detailHistoryData.getDetailAsal());
//        detailHolder.tvPassengerTujuan.setText(detailHistoryData.getDetailTujuan());
//        detailHolder.tvPassengerKontak.setText(detailHistoryData.getNoHp());
////        detailHolder.tvPassengerBiaya.setText(detailHistoryData.getBiayaTambahan());
//        detailHolder.tvPassengerSeat.setText(detailHistoryData.getIdSeat());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return listDetailHistory.size();
//    }
//
//    public class DetailHistoryHolder extends RecyclerView.ViewHolder {
//        TextView tvPassengerName, tvPassengerGender, tvPassengerAsal, tvPassengerTujuan, tvPassengerKontak, tvPassengerBiaya, tvPassengerSeat;
//        public DetailHistoryHolder(@NonNull View view) {
//            super(view);
//            tvPassengerName = itemView.findViewById(R.id.tv_passenger_name);
//            tvPassengerGender = itemView.findViewById(R.id.tv_passenger_gender);
//            tvPassengerAsal = itemView.findViewById(R.id.tv_passenger_asal);
//            tvPassengerTujuan = itemView.findViewById(R.id.tv_passenger_tujuan);
//            tvPassengerKontak = itemView.findViewById(R.id.tv_passenger_kontak);
//            tvPassengerBiaya = itemView.findViewById(R.id.tv_passenger_biaya);
//            tvPassengerSeat = itemView.findViewById(R.id.tv_passenger_seat);
//        }
//    }
//}
