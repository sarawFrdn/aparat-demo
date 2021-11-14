package com.androidlearn.aparat.models;

public interface IResponseListener<T> {

    public  void onSuccess(T responseMessage);

    public void onFailure(String errorResponseMessage);
}
