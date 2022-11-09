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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity{

    //private ActivityMainBinding binding;
    private EditText editspending, editgoal;

    private Button uploadStatement;
    private TextView path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);

        editspending = (EditText) findViewById(R.id.spending);
        editgoal = (EditText) findViewById(R.id.goal);

    }

    ActivityResultLauncher<Intent> sActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        Uri uri = data.getData();
                    }
                }
            }
    );

    public void openFileDialog(View view){
        Intent data = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        data.addCategory(Intent.CATEGORY_OPENABLE);
        data.setType("*/*");
        String[] mimeTypes = {"text/*"};
        data.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        data = Intent.createChooser(data, "Choose a file");
        sActivityResultLauncher.launch(data);
    }


    private void setGoal() {
        Float spending = Float.valueOf(editspending.getText().toString());
        Float goal = Float.valueOf(editspending.getText().toString());

    }

}