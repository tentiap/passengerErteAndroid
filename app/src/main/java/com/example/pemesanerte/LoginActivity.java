package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button btnLogin = findViewById(R.id.btn_login);
        final TextView tvRegister = findViewById(R.id.tv_register);

        tvRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Toast.makeText(this, "Text View Register is clicked", Toast.LENGTH_SHORT).show();
                Toast.makeText(LoginActivity.this, "Text View Register is clicked", Toast.LENGTH_SHORT).show();
//                Intent intent_register = new Intent(this, RegisterActivity.class);
//                startService(intent_register);
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Toast.makeText(this, "Button Login is clicked ", Toast.LENGTH_SHORT).show();
                Toast.makeText(LoginActivity.this, "Button Login is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }




}