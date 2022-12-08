package com.example.app.ui.home;

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

import com.example.app.LoginActivity;
import com.example.app.R;
import com.example.app.api.Client;
import com.example.app.api.TokenHandler;
import com.example.app.databinding.FragmentHomeBinding;
import com.plaid.client.model.AccountBase;
import com.plaid.client.model.AccountsGetRequest;
import com.plaid.client.model.AccountsGetResponse;
import com.plaid.client.model.Transaction;
import com.plaid.client.model.TransactionsGetRequest;
import com.plaid.client.model.TransactionsGetResponse;
import com.plaid.client.request.PlaidApi;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView accounts;
    private TextView balance;
    private TextView titleT;
    private TextView trans;
    private Button checking, savings;
    private PlaidApi client = Client.getClient();
    private Response<AccountsGetResponse> responseAcc = null;
    private Response<TransactionsGetResponse> responseTran = null;
    private boolean c,d= false;
    private boolean check_b = false;
    private boolean save_b = false;


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
        checking = (Button) root.findViewById(R.id.b1);
        savings = (Button) root.findViewById(R.id.b2);
        titleT = (TextView) root.findViewById(R.id.title_Tran);
        trans = (TextView) root.findViewById(R.id.transactions);

        if(LoginActivity.bankSetup){
            getAccountInfo();
        }
        else accounts.setText("No Accounts Setup");

        checking.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!check_b){
                    getCheckings();
                    check_b = true;
                    save_b = false;
                }

            }});
        savings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!save_b) {
                    getSavings();
                    save_b = true;
                    check_b = false;
                }
            }});
        return root;
    }

    private void getSavings() {
        trans.setText("");
        titleT.setText("Savings Transactions:");
    }

    private void getCheckings(){
        trans.setText("");
        titleT.setText("Checkings Transactions:");


        LocalDate startDate = null;
        LocalDate endDate = null;

        //Local date needs higher api version??
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            startDate = LocalDate.parse("2022-01-01");
            endDate = LocalDate.parse("2022-12-31");
        }
        // Pull transactions for a date range
        TransactionsGetRequest request = new TransactionsGetRequest().accessToken(TokenHandler.ACCESS_TOKEN)
                .startDate(startDate)
                .endDate(endDate);
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        responseTran = client.transactionsGet(request).execute();
                        d = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("error message",e.getMessage());}}
            });
            thread.start();
        }catch (ExceptionInInitializerError e){
            Log.e("tag response", e.getCause().toString());
        }

        while(!d){};

        //This is Plaid's Transaction class not ours
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.addAll(responseTran.body().getTransactions());

        String a = "";
        for(int i = 0; i < transactions.size(); i++){
            a = a.concat(transactions.get(i).getName() + "\n");
        }
        trans.setText(a);
    }

    public void getAccountInfo(){
        AccountsGetRequest request = new AccountsGetRequest().accessToken(TokenHandler.ACCESS_TOKEN);
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        responseAcc = client.accountsGet(request).execute();
                        c = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("error message",e.getMessage());}}
            });
            thread.start();
        }catch (ExceptionInInitializerError e){
            Log.e("tag response", e.getCause().toString());
        }

        while(!c){};
        List<AccountBase> accountsList = responseAcc.body().getAccounts();
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