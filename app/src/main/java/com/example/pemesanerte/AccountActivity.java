package com.example.pemesanerte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pemesanerte.model.register.Register;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {

    SessionManager sessionManager;
    TextView tvName, tvUsername, tvEmail, tvPhone, tvGender, tvAddress;
//    Button btnLogout;
    Button btnLogin, btnRegister, btnLogout;
    String name, username, email, phone, gender, address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //Soon delete maybe
        sessionManager = new SessionManager(AccountActivity.this);

        tvName = findViewById(R.id.tv_name);
        tvUsername = findViewById(R.id.tv_username);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvGender = findViewById(R.id.tv_gender);
        tvAddress = findViewById(R.id.tv_address);

        name = sessionManager.getUserDetail().get(SessionManager.NAMA);
//        username = sessionManager.getUserDetail().get(SessionManager.);
        email = sessionManager.getUserDetail().get(SessionManager.EMAIL);

        tvName.setText(name);
        tvEmail.setText(email);

        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();

            }
        });

//        Soon delete
        btnLogin = findViewById(R.id.btn_login1);
        btnRegister = findViewById(R.id.btn_register1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(AccountActivity.this, LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(AccountActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_account);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        startActivity(new Intent(AccountActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_my_order:
                        startActivity(new Intent(AccountActivity.this, MyOrderActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_account:
                        return true;
                }
                return false;
            }
        });
    }

    private void moveToLogin() {
        Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();

    }
}