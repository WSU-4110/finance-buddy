package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.ui.dashboard.DashboardFragment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class InputManually extends AppCompatActivity implements View.OnClickListener {

    //private ActivityMainBinding binding;
    private EditText groceries, restaurants, transportation, entertainment, clothing, utilities, housing, subscriptions, other;
    private Button cancel, submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_manually);

        groceries = (EditText) findViewById(R.id.groceries);
        restaurants = (EditText) findViewById(R.id.restaurants);
        transportation = (EditText) findViewById(R.id.transportation);
        entertainment = (EditText) findViewById(R.id.entertainment);
        clothing = (EditText) findViewById(R.id.clothing);
        utilities = (EditText) findViewById(R.id.utilities);
        housing = (EditText) findViewById(R.id.housing);
        subscriptions = (EditText) findViewById(R.id.subscriptions);
        other = (EditText) findViewById(R.id.other);

        cancel = (Button) findViewById(R.id.cancel);
        submit = (Button) findViewById(R.id.submit);

    }


    private void Submit() {
        Double g = Double.valueOf(groceries.getText().toString());
        Double r = Double.valueOf(restaurants.getText().toString());
        Double t = Double.valueOf(transportation.getText().toString());
        Double e = Double.valueOf(entertainment.getText().toString());
        Double c = Double.valueOf(clothing.getText().toString());
        Double u = Double.valueOf(utilities.getText().toString());
        Double h = Double.valueOf(housing.getText().toString());
        Double s = Double.valueOf(subscriptions.getText().toString());
        Double o = Double.valueOf(other.getText().toString());

        LocalDate dateObj = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateObj = LocalDate.now();
        }
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }
        String date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date = dateObj.format(formatter);
        }

        Statement statement = new Statement(g,r,t,e,c,u,h,s,o, date);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.submit:
                Submit();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
