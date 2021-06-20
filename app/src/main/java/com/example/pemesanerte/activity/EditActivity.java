package com.example.pemesanerte.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.pemesanerte.R;

public class EditActivity extends AppCompatActivity {

    EditText  euName, euUsername, euEmail, euPhone, eu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, listGender);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.menuAutoComplete);
        textView.setAdapter(adapter);
    }

    private static final String[] listGender = new String[] {
            "Male", "Female"
    };
}