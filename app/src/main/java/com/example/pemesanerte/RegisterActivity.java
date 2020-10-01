package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Button Register is clicked", Toast.LENGTH_SHORT).show();
                Intent backLoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(backLoginIntent);
            }
        });
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_male:
                if(checked){
                    Toast.makeText(this, "Kamu Laki-laki ", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radio_female:
                if(checked){
                    Toast.makeText(this, "Kamu Perempuan ", Toast.LENGTH_SHORT).show();
                }
        }
    }
}