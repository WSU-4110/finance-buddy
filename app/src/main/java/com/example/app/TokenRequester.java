package com.example.app;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;

public class TokenRequester {
    public @NonNull Single<String> getToken(){

        return Single.just("link-sandbox-24d897f5-6799-4f19-b293-e754bb4ee139");
    }
}
