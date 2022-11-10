package com.example.app;
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

    public PlaidApi createClient() throws ExceptionInInitializerError{
        PlaidApi plaidClient = null;
        try{


            HashMap<String, String> apiKeys = new HashMap<String, String>();
            apiKeys.put("clientId", "plaidClientId");
            apiKeys.put("secret", "plaidSecret");
            apiKeys.put("plaidVersion", "2020-09-14");
            ApiClient apiClient = new ApiClient(apiKeys);
            apiClient.setPlaidAdapter(ApiClient.Sandbox);

            plaidClient = apiClient.createService(PlaidApi.class);
            Log.e("client", "client returned");

        }catch(ExceptionInInitializerError e){
            Log.e("cleinterror", "errorrrrr");
        }
        return plaidClient;
    }

    String clientUserId = "633f656d3246d000121548ae";
    public String generate() throws IOException, ExceptionInInitializerError {
        String linkToken = null;
        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
                .clientUserId(clientUserId)
                .legalName("legal name")
                .phoneNumber("4155558888")
                .emailAddress("email@address.com");

        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
                .user(user)
                .clientName("Plaid Test App")
                .products(Arrays.asList(Products.AUTH))
                .countryCodes(Arrays.asList(CountryCode.US))
                .language("en")
                .webhook("https://example.com/webhook")
                .linkCustomizationName("default")
                .androidPackageName("com.example.app");
        try{

            Log.e("tagg", "Try catch block");


            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try  {
                        //Your code goes here
                        Response<LinkTokenCreateResponse> response = createClient().linkTokenCreate(request).execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();



        }catch (ExceptionInInitializerError e){
            Log.e("tag response", e.getCause().toString());
        }



        return linkToken;
    }



}

