package com.example.app.api;

import android.util.Log;

import com.example.app.R;
import com.plaid.client.ApiClient;
import com.plaid.client.model.CountryCode;
import com.plaid.client.model.ItemPublicTokenExchangeRequest;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
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
    PlaidApi p = Client.getClient();

    public String generate() throws IOException, ExceptionInInitializerError {

        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
                .clientUserId("633f656d3246d000121548ae")
                .legalName("legal name")
                .phoneNumber("4155558888")
                .emailAddress("email@address.com");

        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
                .user(user)
                .clientName("Finance Buddy")
                .products(Arrays.asList(Products.AUTH))
                .countryCodes(Arrays.asList(CountryCode.US))
                .language("en")
                .androidPackageName("com.example.app");
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        response = p.linkTokenCreate(request).execute();
                        b = true;
                    } catch (Exception e) {
                        e.printStackTrace();}}
            });
            thread.start();
        }catch (ExceptionInInitializerError e){
            Log.e("tag response", e.getCause().toString());
        }

        while(!b){};
        String public_token = response.body().getLinkToken();
        return public_token;
    }

}

