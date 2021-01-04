package com.example.pemesanerte;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.pemesanerte.model.login.LoginData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USERS = "id_users";
    public static final String EMAIL = "email";
    public static final String NAMA = "nama";
    public static final String USERNAME = "username";
    public static final String KONTAK = "kontak";
    public static final String JENIS_KELAMIN = "jenis_kelamin";
    public static final String ALAMAT = "alamat";


    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_USERS, user.getIdUsers());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(NAMA, user.getNama());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(KONTAK, user.getKontak());
        editor.putString(JENIS_KELAMIN, user.getJenisKelamin());
        editor.putString(ALAMAT, user.getAlamat());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID_USERS, sharedPreferences.getString(ID_USERS, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(KONTAK, sharedPreferences.getString(KONTAK, null));
        user.put(JENIS_KELAMIN, sharedPreferences.getString(JENIS_KELAMIN, null));
        user.put(ALAMAT, sharedPreferences.getString(ALAMAT, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
