package com.example.app;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.api.TokenHandler;
import com.example.app.notifications.TokenNotification;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class DisplayProfile extends AppCompatActivity implements View.OnClickListener{
    //private ActivityMainBinding binding;

    private Button userProfile, otherProfile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        userProfile = (Button) findViewById(R.id.userProfile);
        userProfile.setOnClickListener(this);

        otherProfile = (Button) findViewById(R.id.otherProfile);
        otherProfile.setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.userProfile:
                startActivity(new Intent(this, UserProfile.class));
                break;
            case R.id.otherProfile:
                startActivity(new Intent(this,  MainActivity.class));
                break;
        }
    }
    


}
