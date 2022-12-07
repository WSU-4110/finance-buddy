package com.example.app;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    //private ActivityMainBinding binding;
    private Button inputManually;
    private Button uploadStatement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);
        inputManually = (Button) findViewById(R.id.input_manually);
        inputManually.setOnClickListener(this);

        uploadStatement = (Button) findViewById(R.id.setGoals);
        uploadStatement.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.input_manually:
                startActivity(new Intent(this, InputManually.class));
                break;
            case R.id.setGoals:
                startActivity(new Intent(this, RegisterUser.class));
                break;
        }
    }
}