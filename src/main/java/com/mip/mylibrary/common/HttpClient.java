package com.mip.mylibrary.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mip.mylibrary.models.HttpErrorResponse;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.lang.reflect.Type;

public class HttpClient {

    Gson gson;
    OkHttpClient httpClient;

    public HttpClient() {
        this.gson = new GsonBuilder().serializeNulls().create();
        this.httpClient = new OkHttpClient();
    }

    /**
     * Used to make a HTTP POST to the specified URL,
     * which, in return, will return a model instance.
     * */
    public <T> T postModel(T modelInstance, String url) throws IOException {

        String json = gson.toJson(modelInstance);
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = httpClient.newCall(request).execute();
        if (response.code() != 200 ){
            String errorResponse = response.body().string();
            HttpErrorResponse error = gson.fromJson(errorResponse, HttpErrorResponse.class);
            throw new IOException(error.getMessage());
        }
        String responseJSON = response.body().string();
        return gson.fromJson(responseJSON, (Type) modelInstance.getClass());
    }
}
