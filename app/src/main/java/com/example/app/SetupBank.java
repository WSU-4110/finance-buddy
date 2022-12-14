package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.api.TokenHandler;
import com.example.app.notifications.TokenNotification;

public class SetupBank extends AppCompatActivity implements View.OnClickListener {

    private Button later;
    private Button setup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_setup);
        later = findViewById(R.id.cancel);
        later.setOnClickListener(this);

        setup = findViewById(R.id.bankStart);
        setup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == later)
            startActivity(new Intent(SetupBank.this, TokenNotification.class));
        else
            startActivity(new Intent(SetupBank.this , TokenHandler.class));

    }
}
