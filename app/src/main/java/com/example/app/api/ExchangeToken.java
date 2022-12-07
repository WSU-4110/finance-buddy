package com.example.app.api;

import android.util.Log;

import com.plaid.client.model.ItemPublicTokenExchangeRequest;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import com.plaid.client.request.PlaidApi;

import java.io.IOException;

import retrofit2.Response;

public class ExchangeToken {
    private Response<ItemPublicTokenExchangeResponse> response_exchange = null;
    private boolean c = false;

    PlaidApi p = Client.getClient();

    public ExchangeToken(){}
    public String tokenExchange(String token){

        ItemPublicTokenExchangeRequest request_exchange = new ItemPublicTokenExchangeRequest()
                .publicToken(token);
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        response_exchange = p
                                .itemPublicTokenExchange(request_exchange)
                                .execute();
                        c = true;
                    } catch (Exception e) {
                        e.printStackTrace();}}
            });
            thread.start();
        }catch (ExceptionInInitializerError e){
            Log.e("tag response", e.getCause().toString());
        }

        while(!c){};
        String accessToken = response_exchange.body().getAccessToken();
        Log.e("access",accessToken);
        return accessToken;
    }
}
