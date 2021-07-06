package com.example.pemesanerte.api;

//import com.example.pemesanerte.model.history.History;
import com.example.pemesanerte.model.availableSeat.AvailableSeat;
import com.example.pemesanerte.model.bookedSeat.BookedSeat;
import com.example.pemesanerte.model.check.Check;
import com.example.pemesanerte.model.detailHistory.DetailHistory;
import com.example.pemesanerte.model.detailPesanan.DetailPesanan;
import com.example.pemesanerte.model.editDetailPesanan.EditDetailPesanan;
import com.example.pemesanerte.model.history.History;
import com.example.pemesanerte.model.idPesanan.IdPesanan;
import com.example.pemesanerte.model.login.Login;
import com.example.pemesanerte.model.pemesan.Pemesan;
import com.example.pemesanerte.model.pesanan.Pesanan;
import com.example.pemesanerte.model.register.Register;
import com.example.pemesanerte.model.search.Search;
import com.example.pemesanerte.model.seat.Seat;
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
            @Field("id_trip") String id_trip,
            @Field("id_pesanan") String id_pesanan,
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
            @Field("id_trip") String id_trip,
            @Field("id_users_pemesan") String id_users_pemesan
    );

//    @FormUrlEncoded
//    @POST("history")
//    Call<kacauHistory> historyResponse(
//            @Field("id_users_pemesan") String id_users_pemesan
////            @Field("id_kota_asal") String id_kota_asal,
////            @Field("id_kota_tujuan") String id_kota_tujuan,
////            @Field("jadwal") String jadwal
//    );

    @GET("history/{id_users_pemesan}")
    Call<History> historyResponse(
            @Path("id_users_pemesan") String id_users_pemesan
    );

    @GET("detail/{id_pesanan}")
    Call<DetailHistory> detailResponse(
            @Path("id_pesanan") String id_pesanan
    );

    @GET("search/{id_kota_asal}/{id_kota_tujuan}/{jadwal}/{jumlah_penumpang}")
    Call<Search> searchResponse(
            @Path("id_kota_asal") String id_kota_asal,
            @Path("id_kota_tujuan") String id_kota_tujuan,
            @Path("jadwal") String jadwal,
            @Path("jumlah_penumpang") String jumlah_penumpang
    );

    @GET("check/{jumlah_penumpang}/{id_trip}/{id_users_pemesan}")
    Call<Check> checkResponse(
            @Path("jumlah_penumpang") String jumlah_penumpang,
            @Path("id_trip") String id_trip,
            @Path("id_users_pemesan") String id_users_pemesan
    );

    @GET("checkUpdate/{tambah}/{id_trip}/{id_users_pemesan}")
    Call<Check> checkUpdateResponse(
            @Path("tambah") String tambah,
            @Path("id_trip") String id_trip,
            @Path("id_users_pemesan") String id_users_pemesan
    );

    @GET("getBookedSeat/{id_trip}")
    Call<BookedSeat> bookedSeatResponse(
            @Path("id_trip") String id_trip
    );

    @GET("getIdPesanan/{id_trip}/{id_users_pemesan}")
    Call<IdPesanan> idPesananResponse(
            @Path("id_trip") String id_trip,
            @Path("id_users_pemesan") String id_users_pemesan
    );

    @GET("getDetailPesanan/{id_pesanan}/{id_trip}")
    Call<EditDetailPesanan> getDetailPesananResponse(
            @Path("id_pesanan") String id_pesanan,
            @Path("id_trip") String id_trip
    );

    @GET("seat/{id_trip}")
    Call<Seat> seatResponse(
            @Path("id_seat") String id_seat
    );

    @GET("checkAvailableSeat/{id_trip}")
    Call<AvailableSeat> availableSeatResponse(
            @Path("id_trip") String id_trip
    );

    @FormUrlEncoded
    @POST("updateDataPemesan")
    Call<Pemesan> pemesanResponse(
            @Field("id_users") String id_users,
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
            @Field("id_detail_pesanan") int id_detail_pesanan,
            @Field("id_seat") String id_seat,
            @Field("nama_penumpang") String nama_penumpang,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("detail_asal") String detail_asal,
            @Field("detail_tujuan") String detail_tujuan,
            @Field("no_hp") String no_hp
    );


}
