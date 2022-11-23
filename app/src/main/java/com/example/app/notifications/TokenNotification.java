package com.example.app.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.app.MainActivity;
import com.example.app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class TokenNotification extends AppCompatActivity implements View.OnClickListener{
    // set to value
    // create obj etToken from EditText class
    EditText etToken;
    private Button dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.token_push);
        etToken = findViewById(R.id.etToken);

        dashboard = findViewById(R.id.dashButton);
        dashboard.setOnClickListener(this);


        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        System.out.println(token);
                        Toast.makeText(TokenNotification.this, "Your device registration token: " +
                                token, Toast.LENGTH_SHORT).show();

                        etToken.setText(token);
                    }
                });
    }
    @Override
    public void onClick(View view) {
        startActivity(new Intent(TokenNotification.this, MainActivity.class));
    }
}
