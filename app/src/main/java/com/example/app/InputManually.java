package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.ui.dashboard.DashboardFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class InputManually extends AppCompatActivity implements View.OnClickListener {

    //private ActivityMainBinding binding;
    private EditText date, groceries, restaurants, transportation, entertainment, clothing, utilities, housing, subscriptions, other;
    private Button cancel, submit;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_manually);

        date = (EditText) findViewById(R.id.date);
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
        String d = date.getText().toString();

        Statement statement = new Statement(g,r,t,e,c,u,h,s,o,d);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userID = user.getUid();
        String s1 = mDatabase.child(userID).child("statements").push().getKey();
        mDatabase.child(userID).child("statements").child(s1).setValue(statement);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                startActivity(new Intent(this, Dashboard.class));
                break;
            case R.id.submit:
                Submit();
                startActivity(new Intent(this, Dashboard.class));
                break;
        }
    }
}
