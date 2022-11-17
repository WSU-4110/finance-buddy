package com.example.app.ui.dashboard;

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

import com.example.app.Dashboard;
import com.example.app.InputManually;
import com.example.app.R;
import com.example.app.RegisterUser;
import com.example.app.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment implements View.OnClickListener{

    private FragmentDashboardBinding binding;
    private Button inputManually;
    private Button uploadStatement;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        inputManually = (Button) root.findViewById(R.id.input_manually);
        inputManually.setOnClickListener(this);

        uploadStatement = (Button) root.findViewById(R.id.uploadStatement);
        uploadStatement.setOnClickListener(this);

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
            case R.id.input_manually:
                startActivity(new Intent(getActivity(), InputManually.class));
                break;
            case R.id.uploadStatement:
                startActivity(new Intent(getActivity(), RegisterUser.class));
                break;
        }
    }
}