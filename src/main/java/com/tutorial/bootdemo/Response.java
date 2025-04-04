package com.tutorial.bootdemo;

import lombok.Data;

@Data
public class Response<T> {
    private T data;
    private String message;
    private boolean success;
    public static <K> Response<K> success(K data) {
        Response<K> response = new Response<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static Response<Void> fail(String message){
        Response<Void> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}
