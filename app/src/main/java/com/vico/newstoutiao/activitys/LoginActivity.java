package com.vico.newstoutiao.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.vico.newstoutiao.R;
import com.vico.newstoutiao.utils.VolleyUtil;

/**
 * Created by ${Vico} on 2017/7/11.
 */

public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private CheckBox isRemember;
    private Button mRegist;


    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getRequestQueue().cancelAll(VolleyUtil.VOLLEY_TAG);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    private void initEvent() {
        mLogin.setOnClickListener(this);
        mRegist.setOnClickListener(this);
    }

    private void initView() {
        mAccount = (EditText) findViewById(R.id.et_account);
        mPassword = (EditText) findViewById(R.id.et_pwd);
        mLogin = (Button) findViewById(R.id.btn_login);
        isRemember = (CheckBox) findViewById(R.id.remember_pwd);
        mRegist = (Button) findViewById(R.id.btn_regist);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String account = mAccount.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
                    Toast.makeText(this, getResources().getString(R.string.notEmpty), Toast.LENGTH_SHORT).show();
                } else {
                    VolleyUtil.getInstance().login(account,password,new VolleyUtil.LoginCallback(){

                        @Override
                        public void login_success(String info) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void loginFail(String err) {
                            Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_error), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                break;
            case R.id.btn_regist:
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}