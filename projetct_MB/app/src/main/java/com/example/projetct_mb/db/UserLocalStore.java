package com.example.projetct_mb.db;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.projetct_mb.model.*;
public class UserLocalStore {
    public static final String DB_NAME="userlogin";
    SharedPreferences userLocalDatabase;
    public UserLocalStore(Context context){
        userLocalDatabase=context.getSharedPreferences(DB_NAME,Context.MODE_PRIVATE);
    }
    public void storeUserData(customer cus){
        SharedPreferences.Editor userLocalDatabaseEditor=userLocalDatabase.edit();
        userLocalDatabaseEditor.putInt("ID",cus.getIdCus());
        userLocalDatabaseEditor.putString("username", cus.getUserCus());
        userLocalDatabaseEditor.putString("password",cus.getPassCus());
        userLocalDatabaseEditor.putString("phone",cus.getPhoneCus());
        userLocalDatabaseEditor.putString("email",cus.getEmailCus());
        userLocalDatabaseEditor.commit();
    }
    public void setUserLoggedIn(boolean logIn){
        SharedPreferences.Editor userLocalDatabaseEditor=userLocalDatabase.edit();
        userLocalDatabaseEditor.putBoolean("loggedIn",logIn);
        userLocalDatabaseEditor.commit();
    }
    public void clearUserData() {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.clear();
        userLocalDatabaseEditor.commit();
    }
    public customer getLoggedInUser(){
        if (userLocalDatabase.getBoolean("loggedIn",false)==false){
            return null;
        }
        int id=userLocalDatabase.getInt("ID",0);
        String username=userLocalDatabase.getString("username","");
        String pass=userLocalDatabase.getString("password","");
        String phone=userLocalDatabase.getString("phone","");
        String mail=userLocalDatabase.getString("email","");
        customer cus=new customer(id,username,pass,phone,mail);
        return cus;
    }
}
