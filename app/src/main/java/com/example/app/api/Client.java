package com.example.app.api;

import android.util.Log;

import com.plaid.client.ApiClient;
import com.plaid.client.request.PlaidApi;

import java.util.HashMap;

public class Client {
    private final String clientId = "633f656d3246d000121548ae";
    private final String secretSandbox = "94438bcdf84b7aad28e91f77f9f353";
    PlaidApi plaidClient = null;

    private static Client financeClient = null;
    private Client(){
        createClient();
    }

    public String getClientId(){
        return clientId;
    }
    private void createClient() throws ExceptionInInitializerError{

        try{
            HashMap<String, String> apiKeys = new HashMap<String, String>();
            apiKeys.put("clientId", clientId);
            apiKeys.put("secret", secretSandbox);
            apiKeys.put("plaidVersion", "2020-09-14");
            ApiClient apiClient = new ApiClient(apiKeys);
            apiClient.setPlaidAdapter(ApiClient.Sandbox);

            plaidClient = apiClient.createService(PlaidApi.class);

        }catch(ExceptionInInitializerError e){
            Log.e("client-error", "Error creating client");
        }

    }
    public static PlaidApi getClient(){
        if(financeClient == null){
            financeClient = new Client();
        }
        return financeClient.plaidClient;
    }
}
