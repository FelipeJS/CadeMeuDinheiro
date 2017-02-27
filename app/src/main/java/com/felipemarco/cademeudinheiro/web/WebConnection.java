package com.felipemarco.cademeudinheiro.web;

import android.app.Service;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 7142-felipe on 27/02/2017.
 */

public abstract class WebConnection {

    private static final String BASE_URL = "http://private-5b2501-gastos.apiary-mock.com/";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String serviceName;

    public WebConnection(String serviceName){
        this.serviceName = serviceName;
    }

    public void call() {
        OkHttpClient client = new OkHttpClient();

        String url = getUrl();

        RequestBody body = RequestBody.create(JSON, getRequestContent());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                EventBus.getDefault().post(new Exception("Verifique sua conexão"));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handleResponse(response);
            }
        });
    }

    public String getUrl(){
        return BASE_URL + serviceName;
    }

    abstract String getRequestContent();

    abstract void handleResponse(Response response);

}
