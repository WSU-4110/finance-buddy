package com.example.app.ui.dashboard;

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

import com.example.app.Dashboard;
import com.example.app.InputManually;
import com.example.app.R;
import com.example.app.RegisterUser;
import com.example.app.Transactions;
import com.example.app.UploadStatement;
import com.example.app.databinding.FragmentDashboardBinding;
import com.example.app.ui.home.HomeFragment;

import java.text.DecimalFormat;
import java.util.List;

public class DashboardFragment extends Fragment implements View.OnClickListener{

    private FragmentDashboardBinding binding;
    private Button inputManually;
    private Button reccomend;
    private TextView reccomendations;
    private TextView reccomendations2;
    private static List<Transactions> l = null;
    private DecimalFormat df = new DecimalFormat("0.00");

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


        reccomend = (Button) root.findViewById(R.id.rec);
        reccomend.setOnClickListener(this);

        reccomendations = (TextView)  root.findViewById(R.id.rec_text);
        reccomendations2 = (TextView)  root.findViewById(R.id.rec_text2);

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
            case R.id.rec:

                l =  HomeFragment.bA.getAllTransactions();
                double travelCtr = 0,foodCtr = 0,creditCardCtr = 0,shoppingExpensesCtr = 0;
                for(int i = 0; i < l.size(); i++){
                    String type = l.get(i).getType();
                    double charge = l.get(i).getAmount();
                    Log.e("hi",type);
                    if(type.startsWith("[Trav")){
                        travelCtr = travelCtr + charge;
                    }
                    else if(type.startsWith("[Food")){
                        foodCtr = foodCtr + charge;
                    }
                    else if(type.startsWith("[Paym")){
                        creditCardCtr = creditCardCtr + charge;
                    }
                    else{
                        shoppingExpensesCtr = shoppingExpensesCtr + charge;
                    }
                }
                reccomendations.setText("Total Travel expenses: " + df.format(travelCtr)  + "\n" +"Total Food expenses: "+ df.format(foodCtr)  +"\n" +"Total Credit card expenses: " +df.format(creditCardCtr)  + "\n" +"Total shopping expenses: " +df.format(shoppingExpensesCtr));
                reccomendations2.setText("Based on Your monthly spending this month you should spend less on Travel expenses. Good job spending less on shopping.");
                break;
        }
    }
}