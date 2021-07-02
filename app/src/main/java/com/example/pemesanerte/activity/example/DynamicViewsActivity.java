package com.example.pemesanerte.activity.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pemesanerte.Cricketer;
import com.example.pemesanerte.R;

import java.util.ArrayList;
import java.util.List;

public class DynamicViewsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutList;
    Button buttonAdd, buttonSubmitList;

    List<String> teamList = new ArrayList<>();
    ArrayList<Cricketer> cricketerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_views);

        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add_multiple);
        buttonSubmitList = findViewById(R.id.button_submit_list);

        buttonAdd.setOnClickListener(this);
        buttonSubmitList.setOnClickListener(this);

        teamList.add("Team");
        teamList.add("Team 2");
        teamList.add("Team 3");
        teamList.add("Team 4");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add_multiple:
                addView();
                break;
            case R.id.button_submit_list:

                if (checkIfValidAndRead()){
                    Intent intent = new Intent(DynamicViewsActivity.this, CricketersActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", cricketerList);
                    intent.putExtras(bundle);
                    startActivity(intent);


                }

        }
    }

    private boolean checkIfValidAndRead() {
        cricketerList.clear();
        boolean result = true;

        for (int i=0; i < layoutList.getChildCount(); i++){
            View cricketerView = layoutList.getChildAt(i);

            EditText editTextName = (EditText)cricketerView.findViewById(R.id.edit_cricketer_name);
            AppCompatSpinner spinnerTeam = (AppCompatSpinner)cricketerView.findViewById(R.id.spinner_team);

            Cricketer cricketer = new Cricketer();
            if(!editTextName.getText().toString().equals("")){
                cricketer.setCricketerName(editTextName.getText().toString());
            }else{
                result = false;
            }

            if (spinnerTeam.getSelectedItemPosition()!=0){
                cricketer.setTeamName(teamList.get(spinnerTeam.getSelectedItemPosition()));
            }else{
                result = false;
                break;
            }

            cricketerList.add(cricketer);
        }

        if (cricketerList.size()==0){
            result = false;
            Toast.makeText(DynamicViewsActivity.this, "Add Cricketers First!", Toast.LENGTH_SHORT).show();
        }else if (!result){
            Toast.makeText(DynamicViewsActivity.this, "Enter All Details Correctly!", Toast.LENGTH_SHORT).show();
        }


        return  result;
    }

    private void addView() {

        final View cricketerView = getLayoutInflater().inflate(R.layout.row_add_cricketer, null, false);

        EditText editText = (EditText)cricketerView.findViewById(R.id.edit_cricketer_name);
        AppCompatSpinner spinnerTeam = (AppCompatSpinner)cricketerView.findViewById(R.id.spinner_team);
        ImageView imageClose = (ImageView)cricketerView.findViewById(R.id.image_remove);

        ArrayAdapter arrayAdapter = new ArrayAdapter(DynamicViewsActivity.this, android.R.layout.simple_spinner_item,  teamList);
        spinnerTeam.setAdapter(arrayAdapter);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(cricketerView);
            }
        });

        layoutList.addView(cricketerView);
    }

    private void removeView(View view){

        layoutList.removeView(view);

    }
}