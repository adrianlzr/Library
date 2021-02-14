package com.mip.mylibrary.services;

import com.google.gson.Gson;
import com.mip.mylibrary.models.User;
import com.mip.mylibrary.exceptions.SignupException;
import com.squareup.okhttp.*;

import java.io.IOException;

public class SignupService {

    Gson gson;
    OkHttpClient httpClient;

    public SignupService() {

    }

    public void signUp(User user) throws SignupException, IOException {
        String json = gson.toJson(user);
        System.out.println(json);
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/v1/signup/")
                .post(body)
                .build();
        Response response = httpClient.newCall(request).execute();
        if (response.code() != 200 ){
            throw new SignupException("Signup Failed. Please try again");
        }
    }

}
