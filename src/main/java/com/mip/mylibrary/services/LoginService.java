package com.mip.mylibrary.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mip.mylibrary.common.HttpClient;
import com.mip.mylibrary.models.User;
import com.mip.mylibrary.exceptions.LoginException;

import java.io.IOException;

public class LoginService {

    Gson gson;
    HttpClient httpClient;

    private final String url = "http://localhost:8080/api/v1/login";

    public LoginService() {
        this.gson = new GsonBuilder().serializeNulls().create();
        this.httpClient = new HttpClient();
    }

    public User login(User user) throws LoginException {
//        String json = gson.toJson(user);
//        System.out.println(json);
//        RequestBody body = RequestBody.create(
//                MediaType.parse("application/json"), json);
//        Request request = new Request.Builder()
//                .url("http://localhost:8080/api/v1/login")
//                .post(body)
//                .build();
//        Response response = httpClient.newCall(request).execute();
//        if (response.code() != 200 ){
//            throw new LoginException("Login Failed. Please try again");
//        }
//        String responseJSON = response.body().string();
//        return gson.fromJson(responseJSON, User.class);
        try {
            return (User) httpClient.postModel(user, url);
        } catch (IOException e) {
            throw new LoginException(e.toString());
        }
    }
}
