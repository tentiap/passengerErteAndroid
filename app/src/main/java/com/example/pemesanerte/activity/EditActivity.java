package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemesanerte.R;
import com.example.pemesanerte.SessionManager;
import com.example.pemesanerte.api.ApiClient;
import com.example.pemesanerte.api.ApiInterface;
import com.example.pemesanerte.model.pemesan.Pemesan;
//import com.example.pemesanerte.model.pemesanOld.PemesanOld;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    EditText  euName, euUsername, euEmail, euPhone, euAddress;
    TextView tvCancel;
    Button btnUpdate;
    String xIdPemesan, xUsername, xEmail, xName, xPhone, xGender, xAddress;
    String yIdPemesan, yUsername, yEmail, yName, yPhone, yGender, yAddress;
    Spinner spinnerGender;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        sessionManager = new SessionManager(EditActivity.this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Edit Profile");
        
        btnUpdate = findViewById(R.id.btn_eu);
        btnUpdate.setOnClickListener(this);

        Intent terima = getIntent();
        xIdPemesan = terima.getStringExtra("xidPemesan");
        xUsername = terima.getStringExtra("xUsername");
        xEmail = terima.getStringExtra("xEmail");
        xName = terima.getStringExtra("xName");
        xPhone = terima.getStringExtra("xPhone");
        xGender = terima.getStringExtra("xGender");
        xAddress = terima.getStringExtra("xAddress");

        euName = findViewById(R.id.eu_name);
        euUsername = findViewById(R.id.eu_username);
        euEmail = findViewById(R.id.eu_email);
        euPhone = findViewById(R.id.eu_phone);
        euAddress = findViewById(R.id.eu_address);

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i=0; i<2; i++){
            if (i == 0){
                arrayList.add("Laki-laki");
            }else {
                arrayList.add("Perempuan");
            }
        }

        spinnerGender = findViewById(R.id.eu_gender);
        spinnerGender.setAdapter(new ArrayAdapter<>(EditActivity.this, android.R.layout.simple_spinner_dropdown_item,arrayList));
        spinnerGender.setSelection(getIndex(spinnerGender, xGender));

        euName.setText(xName);
        euUsername.setText(xUsername);
        euEmail.setText(xEmail);
        euPhone.setText(xPhone);
        euAddress.setText(xAddress);
    }

    private int getIndex(Spinner spinnerGender, String xGender) {
        for (int i=0; i < spinnerGender.getCount(); i++){
            if (spinnerGender.getItemAtPosition(i).toString().equalsIgnoreCase(xGender)){
                return i;
            }
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_eu:
                yName = euName.getText().toString();
                yUsername = euUsername.getText().toString();
                yEmail = euEmail.getText().toString();
                yGender = spinnerGender.getSelectedItem().toString();
                yPhone = euPhone.getText().toString();
                yAddress = euAddress.getText().toString();

                update();
        }

    }

    private void update() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Pemesan> call = apiInterface.pemesanResponse(xIdPemesan, yName, yUsername, yEmail, yGender, yPhone, yAddress);
        call.enqueue(new Callback<Pemesan>() {
            @Override
            public void onResponse(Call<Pemesan> call, Response<Pemesan> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(EditActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    moveToLogin();
                }else{
                    Toast.makeText(EditActivity.this, "Nomor HP udah ada", Toast.LENGTH_SHORT).show();
                }

                finish();
            }

            @Override
            public void onFailure(Call<Pemesan> call, Throwable t) {
                Toast.makeText(EditActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void moveToLogin() {
        Intent intent = new Intent(EditActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}