package com.felipemarco.cademeudinheiro.web;

import android.util.Log;

import com.felipemarco.cademeudinheiro.domain.Pessoa;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

/**
 * Created by 7142-felipe on 27/02/2017.
 */

public class WebLogin extends WebConnection {

    private static final String SERVICE = "login";
    private String email;
    private String password;

    public WebLogin(String email, String password) {
        super(SERVICE);
        this.email = email;
        this.password = password;
    }

    @Override
    String getRequestContent() {
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("login", email);
        requestMap.put("password", password);

        JSONObject json = new JSONObject(requestMap);
        String jsonString = json.toString();

        return  jsonString;
    }

    @Override
    void handleResponse(Response response) {
        String responseBody = null;
        try {
            responseBody = response.body().string();
            Pessoa pessoa = new Pessoa();
            JSONObject object = new JSONObject(responseBody);
            pessoa.setEmail(email);
            pessoa.setNome(object.getString("username"));
            pessoa.setToken(object.getString("token"));
            EventBus.getDefault().post(pessoa);
        } catch (IOException e) {
            EventBus.getDefault().post(e);
        } catch (JSONException e) {
            EventBus.getDefault().post(new Exception("A resposta do servidor não é válida"));
        }

    }
}
