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
import com.google.firebase.database.ServerValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class InputManually extends AppCompatActivity implements View.OnClickListener {

    //private ActivityMainBinding binding;
    private EditText dateEdit, groceriesEdit, restaurantsEdit, transportationEdit, entertainmentEdit, clothingEdit, utilitiesEdit, housingEdit, subscriptionsEdit, otherEdit;
    private Button cancel, submit;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_manually);

        dateEdit = (EditText) findViewById(R.id.date);
        groceriesEdit = (EditText) findViewById(R.id.groceries);
        restaurantsEdit = (EditText) findViewById(R.id.restaurants);
        transportationEdit = (EditText) findViewById(R.id.transportation);
        entertainmentEdit = (EditText) findViewById(R.id.entertainment);
        clothingEdit = (EditText) findViewById(R.id.clothing);
        utilitiesEdit = (EditText) findViewById(R.id.utilities);
        housingEdit = (EditText) findViewById(R.id.housing);
        subscriptionsEdit = (EditText) findViewById(R.id.subscriptions);
        otherEdit = (EditText) findViewById(R.id.other);

        cancel = (Button) findViewById(R.id.cancel);
        submit = (Button) findViewById(R.id.submit);

    }


    private void Submit() {
        String d = dateEdit.getText().toString();
        String groceries = groceriesEdit.getText().toString();
        String restaurants = restaurantsEdit.getText().toString();
        String transportation = transportationEdit.getText().toString();
        String entertainment = entertainmentEdit.getText().toString();
        String clothing = clothingEdit.getText().toString();
        String utilities = utilitiesEdit.getText().toString();
        String housing = housingEdit.getText().toString();
        String subscriptions = subscriptionsEdit.getText().toString();
        String other = otherEdit.getText().toString();

        if(d.isEmpty()){
            dateEdit.setError("Enter a Date");
            dateEdit.requestFocus();
            return;
        }
        if(groceries.isEmpty()){
            groceriesEdit.setError("Enter an Amount");
            groceriesEdit.requestFocus();
            return;
        }
        if(restaurants.isEmpty()){
            restaurantsEdit.setError("Enter an Amount");
            restaurantsEdit.requestFocus();
            return;
        }
        if(transportation.isEmpty()){
            transportationEdit.setError("Enter an Amount");
            transportationEdit.requestFocus();
            return;
        }
        if(entertainment.isEmpty()){
            entertainmentEdit.setError("Enter an Amount");
            entertainmentEdit.requestFocus();
            return;
        }
        if(clothing.isEmpty()){
            clothingEdit.setError("Enter an Amount");
            clothingEdit.requestFocus();
            return;
        }
        if(utilities.isEmpty()){
            utilitiesEdit.setError("Enter an Amount");
            utilitiesEdit.requestFocus();
            return;
        }
        if(housing.isEmpty()){
            housingEdit.setError("Enter an Amount");
            housingEdit.requestFocus();
            return;
        }
        if(subscriptions.isEmpty()){
            subscriptionsEdit.setError("Enter an Amount");
            subscriptionsEdit.requestFocus();
            return;
        }
        if(other.isEmpty()){
            otherEdit.setError("Enter an Amount");
            otherEdit.requestFocus();
            return;
        }

        Double g = Double.valueOf(groceries);
        Double r = Double.valueOf(restaurants);
        Double t = Double.valueOf(transportation);
        Double e = Double.valueOf(entertainment);
        Double c = Double.valueOf(clothing);
        Double u = Double.valueOf(utilities);
        Double h = Double.valueOf(housing);
        Double s = Double.valueOf(subscriptions);
        Double o = Double.valueOf(other);

        Statement statement = new Statement(g,r,t,e,c,u,h,s,o,d);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userID = user.getUid();
        //String s1 = mDatabase.child(userID).child("statements").push().getKey();
        //mDatabase.child(userID).child("statements").child(s1).setValue(statement);
        mDatabase.child(userID).child("totalStatements").setValue(ServerValue.increment(statement.total()));

        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.submit:
                Submit();
                break;
        }
    }
}
