package com.example.app;
import com.plaid.client.model.CountryCode;
import com.plaid.client.model.Products;

import com.plaid.client.model.LinkTokenCreateRequest;
import com.plaid.client.model.LinkTokenCreateRequestAuth;
import com.plaid.client.model.LinkTokenCreateRequestUser;
import com.plaid.client.model.LinkTokenCreateResponse;
import retrofit2.Response;
import com.plaid.client.request.PlaidApi;

import java.io.IOException;
import java.util.Arrays;

public class GenerateToken {
    private PlaidApi client;
    String clientUserId = "633f656d3246d000121548ae";



    private PlaidApi getClient(){
        return client;
    }
    public String generate() throws IOException {
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

        Response<LinkTokenCreateResponse> response = getClient()
                .linkTokenCreate(request)
                .execute();

        String linkToken = response.body().getLinkToken();
        return linkToken;
    }


}
