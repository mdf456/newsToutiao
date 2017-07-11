package com.vico.newstoutiao.utils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.vico.newstoutiao.activitys.MyApplication;
import com.vico.newstoutiao.contents.UserContents;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${Vico} on 2017/7/10.
 */

public class VolleyUtil {
    private static final String TAG = "VolleyUtils";
    public static final String VOLLEY_TAG = "volleyTag";

    private static  VolleyUtil instance;

    public static VolleyUtil getInstance(){
        if (instance == null) {
            instance = new VolleyUtil();
        }
        return  instance;
    }


    public void login(final String name, final String password, final LoginCallback loginCallback) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, UserContents.loginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals(UserContents.ok)) {
                    loginCallback.login_success(UserContents.ok);
                } else {
                    loginCallback.loginFail(UserContents.error);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                loginCallback.loginFail(UserContents.error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("name", name);
                map.put("password", password);

                return map;
            }
        };
        stringRequest.setTag(VOLLEY_TAG);
        MyApplication.getRequestQueue().add(stringRequest);
    }
    public interface  LoginCallback{
        void login_success(String info);
        void loginFail(String err);
    }

    public interface RegistCallBack {
        void registSuccess(String info);
        void registError(String err);
    }


    public void regist(final String name, final String password, final String age, final String gender, final RegistCallBack registCallBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UserContents.registUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,"...response:" + response);
                registCallBack.registSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,"...error:" + error);
                registCallBack.registError(error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("name", name);
                map.put("password", password);
                map.put("age", age);
                map.put("gender", gender);
                return map;
            }
        };
        stringRequest.setTag(VOLLEY_TAG);
        MyApplication.getRequestQueue().add(stringRequest);
    }
}
