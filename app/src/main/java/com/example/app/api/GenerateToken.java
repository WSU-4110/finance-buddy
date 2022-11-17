package com.example.app.api;
import android.util.Log;

import com.plaid.client.ApiClient;
import com.plaid.client.model.CountryCode;
import com.plaid.client.model.LinkTokenCreateRequest;
import com.plaid.client.model.LinkTokenCreateRequestUser;

import retrofit2.Response;

import com.plaid.client.model.LinkTokenCreateResponse;
import com.plaid.client.model.Products;
import com.plaid.client.request.PlaidApi;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class GenerateToken {
    private Response<LinkTokenCreateResponse> response = null;
    private boolean b = false;
    private final String clientId = "633f656d3246d000121548ae";
    private final String secretSandbox = "94438bcdf84b7aad28e91f77f9f353";

    public PlaidApi createClient() throws ExceptionInInitializerError{
        PlaidApi plaidClient = null;
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
        return plaidClient;
    }

    public String generate() throws IOException, ExceptionInInitializerError {

        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
                .clientUserId(clientId)
                .legalName("legal name")
                .phoneNumber("4155558888")
                .emailAddress("email@address.com");

        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
                .user(user)
                .clientName("Plaid Test App")
                .products(Arrays.asList(Products.AUTH))
                .countryCodes(Arrays.asList(CountryCode.US))
                .language("en")
                .androidPackageName("com.example.app");
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        response = createClient().linkTokenCreate(request).execute();
                        b = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

        }catch (ExceptionInInitializerError e){
            Log.e("tag response", e.getCause().toString());
        }

        while(!b){};
        return response.body().getLinkToken();
    }
}

