package com.nguyenngo.orderservice.config;

import com.google.gson.Gson;

public class GsonConfig {
    private final static Gson gson=new Gson();
    public static Gson getInstance(){
        return gson;
    }
}
