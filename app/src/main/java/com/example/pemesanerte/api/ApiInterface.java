package com.example.pemesanerte.api;

import com.example.pemesanerte.model.history.History;
import com.example.pemesanerte.model.login.Login;
import com.example.pemesanerte.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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

    @GET("history/{id_users_pemesan}")
    Call<History> historyResponse(

    );


}
