package com.example.fetchapitigaraksa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialCardView buttonInputData;
    MaterialCardView buttonListEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInputData = findViewById(R.id.cardInputData);
        buttonInputData.setOnClickListener(this);
        buttonListEmployee = findViewById(R.id.cardListEmployee);
        buttonListEmployee.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardInputData:
                Intent explicit = new Intent(MainActivity.this, InputDataEmployeeActivity.class);
                startActivity(explicit);
                break;
            case R.id.cardListEmployee:
                Intent implicit = new Intent(MainActivity.this, ListEmployeeActivity.class);
                startActivity(implicit);
                break;
            default:
                break;
        }
    }
}