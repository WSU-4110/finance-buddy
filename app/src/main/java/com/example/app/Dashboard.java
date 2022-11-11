package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.Spending;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity{


    double spending, goal;

    EditText spendingInput;
    EditText goalInput;

    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);

        spendingInput = (EditText) findViewById(R.id.spendingInput);
        goalInput = (EditText) findViewById(R.id.goalInput);

        TextView displayTotalSpending = (TextView)findViewById(R.id.displayTotalSpending);
        TextView displayCurrentGoal = (TextView)findViewById(R.id.displayCurrentGoal);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spending = Double.valueOf(spendingInput.getText().toString());
                goal = Double.valueOf(goalInput.getText().toString());

                Spending newSpending = Spending.getSpending();

                displayTotalSpending.setText(String.valueOf(newSpending.getTotalSpending()));
                displayCurrentGoal.setText(String.valueOf(goal));



            }
        });
    }





}
