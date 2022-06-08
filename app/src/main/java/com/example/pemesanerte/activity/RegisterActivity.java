package com.example.pemesanerte.activity;

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

import com.example.pemesanerte.R;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.register.Register;
import com.example.pemesanerte.model.register.RegisterOld;

public class RegisterActivity extends AppCompatActivity {

    EditText edtIdPemesan, edtName, edtUsername, edtEmail, edtPassword, edtContact, edtAddress;
    Button btnRegister;
    String Id_pemesan, Nama, Username, Email, Password, Kontak, Alamat, Jenis_Kelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtIdPemesan = findViewById(R.id.edt_id_pemesan);
        edtName = findViewById(R.id.edt_name);
        edtUsername = findViewById(R.id.edt_username);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtContact = findViewById(R.id.edt_contact);
        edtAddress = findViewById(R.id.edt_address);



        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Id_pemesan = edtIdPemesan.getText().toString();
                Nama = edtName.getText().toString();
                Username = edtUsername.getText().toString();
                Email = edtEmail.getText().toString();
                Password = edtPassword.getText().toString();
                Kontak = edtContact.getText().toString();
                Alamat = edtAddress.getText().toString();

                if (Nama.trim().equals("")){
                    edtName.setError("Nama wajib diisi");
                } else if (Id_pemesan.trim().equals("")){
                    edtIdPemesan.setError("ID Pemesan wajib diisi");
                } else if (Username.trim().equals("")){
                    edtUsername.setError("Username wajib diisi");
                } else if (Email.trim().equals("")){
                    edtEmail.setError("Email wajib diisi");
                } else if (Password.trim().equals("")){
                    edtPassword.setError("Password wajib diisi");
                } else if (Kontak.trim().equals("")){
                    edtContact.setError("Nomor Handphone wajib diisi");
                } else if (Alamat.trim().equals("")){
                    edtAddress.setError("Alamat wajib diisi");
                } else{
                    register();
                }
            }
        });
    }

        public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_male:
                if(checked){
                    Jenis_Kelamin = ((RadioButton) view).getText().toString();
                }
                break;
            case R.id.radio_female:
                if(checked){
                    Jenis_Kelamin = ((RadioButton) view).getText().toString();
                }
        }
    }

    private void register(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Register> call = apiInterface.registerResponse(Id_pemesan, Nama, Username, Email, Password, Jenis_Kelamin, Kontak, Alamat);
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