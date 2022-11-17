package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UploadStatement extends AppCompatActivity implements View.OnClickListener{

    private Button cancel, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_statement);

        cancel = (Button) findViewById(R.id.cancel2);
        submit = (Button) findViewById(R.id.submit3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel2:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.submit3:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}