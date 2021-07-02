//package com.example.pemesanerte.activity;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import com.example.pemesanerte.R;
//import com.example.pemesanerte.SessionManager;
//import com.example.pemesanerte.adapter.HistoryAdapter;
//import com.example.pemesanerte.api.ApiClient;
//import com.example.pemesanerte.api.ApiInterface;
//import com.example.pemesanerte.model.kacauhistory.kacauHistory;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//import java.util.ArrayList;
//
//public class KacauMyOrderActivity extends AppCompatActivity {
//    private RecyclerView rvHistory;
//    private ArrayList<kacauHistory> listData = new ArrayList<>();
//    private RecyclerView.Adapter historyAdapter;
//    private RecyclerView.LayoutManager layoutManager;
//    SessionManager sessionManager;
//    ApiInterface apiInterface;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_order);
//
//        rvHistory = findViewById(R.id.rv_history);
//        layoutManager = new LinearLayoutManager(KacauMyOrderActivity.this, LinearLayoutManager.VERTICAL, false);
//
//
//        sessionManager = new SessionManager(KacauMyOrderActivity.this);
//        String id_users = sessionManager.getUserDetail().get(SessionManager.ID_USERS);
//
////        Toast.makeText(MyOrderActivity.this, "ID Users " +id_users, Toast.LENGTH_SHORT).show();
//
//
////        rvHistory.setHasFixedSize(true);
//
////        list.addAll(getListHistory());
//        showRecyclerList(id_users);
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.bn_my_order);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Overrides
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.bn_home:
//                        startActivity(new Intent(KacauMyOrderActivity.this, MainActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.bn_my_order:
//                        return true;
//                    case R.id.bn_account:
//                        startActivity(new Intent(KacauMyOrderActivity.this, AccountActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
//    }
//
////    public ArrayList<HistoryData> getListHistory() {
//////        String[] dataIdPesanan = getResources().getStringArray(R.array.id_pesanan);
////        String[] dataAsal = getResources().getStringArray(R.array.kota_asal);
////        String[] dataTujuan = getResources().getStringArray(R.array.kota_tujuan);
////        String[] dataJadwal = getResources().getStringArray(R.array.jadwal_trip);
////        String[] dataJam = getResources().getStringArray(R.array.jadwal_trip);
////
////        ArrayList<HistoryData> listHistory = new ArrayList<>();
////        for (int i = 0; i < dataAsal.length; i++) {
////            HistoryData historyData = new HistoryData();
//////            historyData.setIdPesanan(dataIdPesanan[i]);
////            historyData.setIdKotaAsal(dataAsal[i]);
////            historyData.setIdKotaTujuan(dataTujuan[i]);
////            historyData.setJadwal(dataJadwal[i]);
////            historyData.setJadwal(dataJam[i]);
////
////            listHistory.add(historyData);
////        }
////
////        return listHistory;
////    }
//
//    private void showRecyclerList(String id_users) {
//        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<kacauHistory> historyCall = apiInterface.historyResponse(id_users);
//        historyCall.enqueue(new Callback<kacauHistory>() {
//            @Override
//            public void onResponse(Call<kacauHistory> call, Response<kacauHistory> response) {
////                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
//                    String pesan = response.body().getMessage();
//                    Toast.makeText(KacauMyOrderActivity.this, "Pesan " +pesan, Toast.LENGTH_SHORT).show();
//
//                    listData = response.body().getData();
//                    historyAdapter = new HistoryAdapter(KacauMyOrderActivity.this, listData);
//                    rvHistory.setAdapter(historyAdapter);
//                    historyAdapter.notifyDataSetChanged();
//
////                    rvHistory.setLayoutManager(new LinearLayoutManager(MyOrderActivity.this));
////                    final HistoryAdapter historyAdapter = new HistoryAdapter(MyOrderActivity.this, listData);
////                    rvHistory.setAdapter(historyAdapter);
////
////                    historyAdapter.setOnItemClickCallback(new HistoryAdapter.OnItemClickCallback() {
////                        @Override
////                        public void onItemClicked(HistoryData data) {
////                            Intent detailHistoryIntent = new Intent(MyOrderActivity.this, DetailOrderActivity.class);
////                            detailHistoryIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
////                            startActivity(detailHistoryIntent);
////                            Toast.makeText(MyOrderActivity.this, "Kamu memilih " + data.getJadwal(), Toast.LENGTH_SHORT).show();
////                        }
////                    });
//
//
////                }
//            }
//
//            @Override
//            public void onFailure(Call<kacauHistory> call, Throwable t) {
//                Toast.makeText(KacauMyOrderActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//
//
//    }
//
//}
