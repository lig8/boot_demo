package com.tutorial.bootdemo;

import lombok.Data;

@Data
public class Response <T>{
    private T data;
    private boolean success;
    private String message;

    public static <K> Response <K> newSucess(K data) {
        Response<K> response = new Response<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static Response<Void> newFail(String message) {
        Response<Void> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}
