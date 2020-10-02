package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtName, edtUsername, edtEmail, edtPassword, edtContact, edtAddress;
    Button btnRegister;
    String Name, Username, Email, Password, Contact, Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edt_name);
        edtUsername = findViewById(R.id.edt_username);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtContact = findViewById(R.id.edt_contact);
        edtAddress = findViewById(R.id.edt_address);

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);



//        btnRegister.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(RegisterActivity.this, "Button Register is clicked", Toast.LENGTH_SHORT).show();
//                Intent backLoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(backLoginIntent);
//            }
//        });
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                Name = edtName.getText().toString();
                Username = edtUsername.getText().toString();
                Email = edtEmail.getText().toString();
                Password = edtPassword.getText().toString();
                Contact = edtContact.getText().toString();
                Address = edtAddress.getText().toString();

                register(Name, Username, Email, Password, Contact, Address);
                break;
        }

    }

    private void register(String name, String username, String email, String password, String contact, String address) {
        Intent intentRegister = new Intent(this, LoginActivity.class );
        startActivity(intentRegister);
    }
}