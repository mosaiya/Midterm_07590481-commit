package com.example.midterm07590481;

public class Auth {
    private static final String EMAIL="aaa"; //**
    private static final String PASSWORD="111"; //**
    private static final String EMAIL2="bbb"; //**
    private static final String PASSWORD2="222"; //**

    private String mEmail;
    private  String mPassword;
    public Auth(String email,String password){
        this.mEmail=email;
        this.mPassword=password;
    }
    public int   check() {
        if (mEmail.equals(EMAIL) && mPassword.equals(PASSWORD))
        {
                return 1;
        }
        else if (mEmail.equals(EMAIL2) && mPassword.equals(PASSWORD2)){
            return  2;
        }
        else {
         return 0 ;
        }
}
    }