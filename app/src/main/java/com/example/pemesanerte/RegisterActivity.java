package com.example.pemesanerte;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.register.Register;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtName, edtUsername, edtEmail, edtPassword, edtContact, edtAddress;
    Button btnRegister;
    String Nama, Username, Email, Password, Kontak, Alamat, Jenis_Kelamin;
    ApiInterface apiInterface;

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
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_male:
                if(checked){
//                    Jenis_Kelamin = "1";
//                    String Jenis_Kelamin = "1";
                    Jenis_Kelamin = ((RadioButton) view).getText().toString();
//                    Jenis_Kelamin = ((RadioButton) view).getText().toString();
//                    Jenis_Kelamin = getString(R.string.satu);
                    Toast.makeText(this, Jenis_Kelamin, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radio_female:
                if(checked){
                    Jenis_Kelamin = ((RadioButton) view).getText().toString();
                    Toast.makeText(this, Jenis_Kelamin, Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                Nama = edtName.getText().toString();
                Username = edtUsername.getText().toString();
                Email = edtEmail.getText().toString();
                Password = edtPassword.getText().toString();
                Kontak = edtContact.getText().toString();
                Alamat = edtAddress.getText().toString();

                register(Nama, Username, Email, Password, Kontak, Alamat, Jenis_Kelamin);
//                register(Nama, Username, Email, Password, Kontak, Alamat);
                break;
        }
    }

    private void register(String nama, String username, String email, String password, String kontak, String alamat, String jenis_kelamin) {
//    private void register(String nama, String username, String email, String password, String kontak, String alamat) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Register> call = apiInterface.registerResponse(nama, username, email, password, kontak, alamat, jenis_kelamin);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intentRegister = new Intent(RegisterActivity.this, LoginActivity.class );
                    startActivity(intentRegister);
                    finish();

                }else{
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}