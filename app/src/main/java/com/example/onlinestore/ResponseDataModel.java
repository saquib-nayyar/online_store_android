package com.example.onlinestore;

public class ResponseDataModel {
    private int code;
    private String message;
    private DetailedDataModel data;

    public ResponseDataModel(int code, String msg, DetailedDataModel data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return message;
    }

    public DetailedDataModel getData() {
        return data;
    }
}
