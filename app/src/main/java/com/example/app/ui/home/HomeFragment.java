package com.example.app.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.LoginActivity;
import com.example.app.R;
import com.example.app.RegisterUser;
import com.example.app.User;
import com.example.app.api.Client;
import com.example.app.api.TokenHandler;
import com.example.app.databinding.FragmentHomeBinding;
import com.plaid.client.model.AccountBase;
import com.plaid.client.model.AccountsGetRequest;
import com.plaid.client.model.AccountsGetResponse;
import com.plaid.client.request.PlaidApi;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView accounts;
    private TextView balance;
    private PlaidApi p = Client.getClient();
    private Response<AccountsGetResponse> response = null;
    private boolean c = false;
    private String accounts_ui;
    private String balance_ui;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        accounts = (TextView) root.findViewById(R.id.accounts_text);
        balance = (TextView) root.findViewById(R.id.accounts_balance);

        if(LoginActivity.bankSetup){
            getAccountInfo();
        }
        else accounts.setText("No Accounts Setup");
        return root;
    }
    public void getAccountInfo(){
        AccountsGetRequest request = new AccountsGetRequest().accessToken(TokenHandler.ACCESS_TOKEN);

        String s = request.toString();
        Log.e("REQUESt for acc", s);
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        response = p.accountsGet(request).execute();
                        c = true;
                    } catch (Exception e) {
                        //String fii = response.errorBody().toString();
                        e.printStackTrace();
                        Log.e("error message",e.getMessage());}}
            });
            thread.start();
        }catch (ExceptionInInitializerError e){
            Log.e("tag response", e.getCause().toString());
        }

        while(!c){};
        List<AccountBase> accountsList = response.body().getAccounts();
        String a = "";
        String b = "";

        DecimalFormat df = new DecimalFormat("0.00");


        for(int i = 0; i < accountsList.size(); i++){
            a = a.concat(accountsList.get(i).getName() + "\n");
            b = b.concat("$" + df.format(accountsList.get(i).getBalances().getCurrent())  + "\n");
        }
        accounts.setText(a);
        balance.setText(b);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}