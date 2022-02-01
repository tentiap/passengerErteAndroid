package com.example.pemesanerte.api;

import com.example.pemesanerte.model.availableSeat.AvailableSeat;
import com.example.pemesanerte.model.bookedSeat.BookedSeat;
import com.example.pemesanerte.model.check.Check;
//import com.example.pemesanerte.model.check.CheckOld;
import com.example.pemesanerte.model.detailHistory.DetailHistory;
import com.example.pemesanerte.model.detailPesanan.DetailPesanan;
//import com.example.pemesanerte.model.editDetailPesanan.EditDetailPesananOld;
import com.example.pemesanerte.model.editDetailPesanan.EditDetailPesanan;
import com.example.pemesanerte.model.history.History;
//import com.example.pemesanerte.model.history.HistoryOld;
//import com.example.pemesanerte.model.idPesanan.IdPesananOld;
import com.example.pemesanerte.model.idPesanan.IdPesanan;
import com.example.pemesanerte.model.login.Login;
//import com.example.pemesanerte.model.pemesanOld.PemesanOld;
import com.example.pemesanerte.model.pemesan.PemesanOld;
import com.example.pemesanerte.model.pesanan.Pesanan;
import com.example.pemesanerte.model.register.Register;
import com.example.pemesanerte.model.search.Search;
//import com.example.pemesanerte.model.search.SearchOld;
import com.example.pemesanerte.model.seat.Seat;
//import com.example.pemesanerte.model.seat.SeatOld;
import com.example.pemesanerte.model.updateDetailPesanan.UpdateDetailPesanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("loginPemesan")
    Call<Login> loginResponse(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<Register> registerResponse(
            @Field("id_pemesan") String id_pemesan,
            @Field("nama") String nama,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("kontak") String kontak,
            @Field("alamat") String alamat
    );

    @FormUrlEncoded
    @POST("createDetailPesanan")
    Call<DetailPesanan> detailPesananResponse(
            @Field("jadwal") String jadwal,
            @Field("plat_mobil") String plat_mobil,
            @Field("id_pemesan") String id_pemesan,
            @Field("order_number") int order_number,
            @Field("id_seat") String id_seat,
            @Field("nama_penumpang") String nama_penumpang,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("detail_asal") String detail_asal,
            @Field("detail_tujuan") String detail_tujuan,
            @Field("no_hp") String no_hp
    );

    @FormUrlEncoded
    @POST("createPesanan")
    Call<Pesanan> pesananResponse(
            @Field("jadwal") String jadwal,
            @Field("plat_mobil") String plat_mobil,
            @Field("id_pemesan") String id_pemesan
    );

    @GET("history/{id_pemesan}")
    Call<History> historyResponse(
            @Path("id_pemesan") String id_pemesan
    );

    @GET("detail/{id_pemesan}/{jadwal}/{plat_mobil}")
    Call<DetailHistory> detailResponse(
            @Path("id_pemesan") String id_pemesan,
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil
    );

    @GET("search/{id_kota_asal}/{id_kota_tujuan}/{jadwal}/{jumlah_penumpang}")
    Call<Search> searchResponse(
            @Path("id_kota_asal") String id_kota_asal,
            @Path("id_kota_tujuan") String id_kota_tujuan,
            @Path("jadwal") String jadwal,
            @Path("jumlah_penumpang") String jumlah_penumpang
    );
    
    @GET("check/{jumlah_penumpang}/{jadwal}/{plat_mobil}/{id_pemesan}")
    Call<Check> checkResponse(
            @Path("jumlah_penumpang") String jumlah_penumpang,
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil,
            @Path("id_pemesan") String id_pemesan
    );

    @GET("checkUpdate/{tambah}/{jadwal}/{plat_mobil}/{id_pemesan}")
    Call<Check> checkUpdateResponse(
            @Path("tambah") String tambah,
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil,
            @Path("id_pemesan") String id_pemesan
    );

    @GET("getBookedSeat/{jadwal}/{plat_mobil}")
    Call<BookedSeat> bookedSeatResponse(
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil
    );

    @GET("getIdPesanan/{jadwal}/{plat_mobil}/{id_pemesan}")
    Call<IdPesanan> idPesananResponse(
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil,
            @Path("id_pemesan") String id_pemesan
    );

    @GET("getDetailPesanan/{id_pemesan}/{jadwal}/{plat_mobil}")
    Call<EditDetailPesanan> getDetailPesananResponse(
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil,
            @Path("id_pemesan") String id_pemesan
    );

    @GET("seat/{jadwal}/{plat_mobil}")
    Call<Seat> seatResponse(
//            @Path("id_seat") String id_seat
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil
    );

    @GET("checkAvailableSeat/{jadwal}/{plat_mobil}")
    Call<AvailableSeat> availableSeatResponse(
            @Path("jadwal") String jadwal,
            @Path("plat_mobil") String plat_mobil
    );

    @FormUrlEncoded
    @POST("updateDataPemesan")
    Call<PemesanOld> pemesanResponse(
            @Field("id_pemesan") String id_pemesan,
            @Field("nama") String nama,
            @Field("username") String username,
            @Field("email") String email,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("kontak") String kontak,
            @Field("alamat") String alamat
    );

    @FormUrlEncoded
    @POST("updateDetailPesanan")
    Call<UpdateDetailPesanan> updateDetailPesananResponse(
            @Field("jadwal") String jadwal,
            @Field("plat_mobil") String plat_mobil,
            @Field("id_pemesan") String id_pemesan,
            @Field("order_number") String order_number,
            @Field("id_seat") String id_seat,
            @Field("nama_penumpang") String nama_penumpang,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("detail_asal") String detail_asal,
            @Field("detail_tujuan") String detail_tujuan,
            @Field("no_hp") String no_hp,
            @Field("status") String status
    );
}
