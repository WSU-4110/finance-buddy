package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class UserProfile extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    private Button logout, goBack, update;

    private double spending, goal;

    private EditText fullNameEditText, emailEditText, ageEditText;

    String fullName, age, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        logout = (Button) findViewById(R.id.signOut);
        goBack = (Button) findViewById(R.id.goBack);
        update = (Button) findViewById(R.id.updateProfile);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfile.this, LoginActivity.class));
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNameChanged() || isEmailChanged() || isAgeChanged()) {
                    Toast.makeText(UserProfile.this, "Data has been updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(UserProfile.this, "Data is the same", Toast.LENGTH_LONG).show();
                }
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, MainActivity.class));
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingTextView = (TextView) findViewById(R.id.greeting);
        fullNameEditText = (EditText) findViewById(R.id.fullName);
        emailEditText = (EditText) findViewById(R.id.emailAddress);
        ageEditText = (EditText) findViewById(R.id.age);
        final TextView goalTextView = (TextView) findViewById(R.id.goal);
        final TextView spendingTextView = (TextView) findViewById(R.id.spending);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null){
                    fullName = userProfile.fullName;
                    email = userProfile.email;
                    age = userProfile.age;

                    greetingTextView.setText("Welcome, " + fullName + "!");
                    fullNameEditText.setText(fullName);
                    emailEditText.setText(email);
                    ageEditText.setText(age);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfile.this, "Something went wrong!", Toast.LENGTH_LONG).show();
            }
        });
    }


    private boolean isAgeChanged() {
        if (!age.equals(ageEditText.getText().toString())) {
            reference.child(userID).child("age").setValue(ageEditText.getText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!email.equals(emailEditText.getText().toString())) {
            reference.child(userID).child("email").setValue(emailEditText.getText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean isNameChanged() {
        if (!fullName.equals(fullNameEditText.getText().toString())) {
            reference.child(userID).child("fullName").setValue(fullNameEditText.getText().toString());
            return true;
        } else {
            return false;
        }
    }
}