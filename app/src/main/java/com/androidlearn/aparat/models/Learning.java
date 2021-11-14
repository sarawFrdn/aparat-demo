package com.androidlearn.aparat.models;

public class Learning {


    private static Learning instance = null ;

    private Learning(){

    }

    public static Learning getInstance(){
        if(instance==null)
        {
            instance = new Learning();
        }

        return instance;

    }

}
