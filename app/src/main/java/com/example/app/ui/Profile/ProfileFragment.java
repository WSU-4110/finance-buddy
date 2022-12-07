package com.example.app.ui.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.InputManually;
import com.example.app.R;
import com.example.app.Statement;
import com.example.app.UploadStatement;
import com.example.app.User;
import com.example.app.databinding.FragmentProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    private FragmentProfileBinding binding;
    private TextView profileName;
    private TextView profileEmail;
    private TextView profileGoal;
    private TextView profileSpending;
    private Button updateProfile;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private DataSnapshot pName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProfile;
        profileViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();
        reference = FirebaseDatabase.getInstance().getReference("Users");

        profileName = (TextView) root.findViewById(R.id.profileName);
        profileEmail = (TextView) root.findViewById(R.id.profileEmail);


        profileGoal = (TextView) root.findViewById(R.id.profileGoal);
        profileSpending = (TextView) root.findViewById(R.id.profileSpending);

        updateProfile = (Button) root.findViewById(R.id.updateProfileButton);
        updateProfile.setOnClickListener(this);

        reference.child(userID).child("fullName").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    profileName.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });

        reference.child(userID).child("email").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    profileEmail.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.updateProfileButton:
                startActivity(new Intent(getActivity(), InputManually.class));
                break;
        }
    }
}