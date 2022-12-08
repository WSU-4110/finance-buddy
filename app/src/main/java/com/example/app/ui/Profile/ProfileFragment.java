package com.example.app.ui.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.UserProfile;
import com.example.app.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    private FragmentProfileBinding binding;
    private Button userProfile, otherProfile;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProfile;
        profileViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        userProfile = (Button) root.findViewById(R.id.userProfile);
        userProfile.setOnClickListener(this);

        otherProfile = (Button) root.findViewById(R.id.otherProfile);
        otherProfile.setOnClickListener(this);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.userProfile:
                startActivity(new Intent(getActivity(), UserProfile.class));
                break;
            case R.id.otherProfile:
                startActivity(new Intent(getActivity(),  MainActivity.class));
                break;
        }
    }
}