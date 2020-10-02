package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtEmail, edtPassword;
    Button btnLogin;
    String Email, Password;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        tvRegister = findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(this);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Email = edtEmail.getText().toString();
                Password = edtPassword.getText().toString();
                login(Email, Password);
                break;
            case R.id.tv_register:
                Intent intentRegister = new Intent(this, RegisterActivity.class);
                startActivity(intentRegister);
        }

    }

    private void login(String email, String password) {
        Intent intentLogin = new Intent(this, MainActivity.class);
        startActivity(intentLogin);
    }
}