package com.vico.newstoutiao.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vico.newstoutiao.R;
import com.vico.newstoutiao.contents.UserContents;
import com.vico.newstoutiao.utils.VolleyUtil;



/**
 * Created by ${Vico} on 2017/7/11.
 */

public class RegistActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "RegistActivity";
    private EditText et_account;
    private EditText et_password;
    private EditText et_gender;
    private EditText et_age;
    private Button btn_submit;

    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getRequestQueue().cancelAll(VolleyUtil.VOLLEY_TAG);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
        initEvent();
    }

    private void initEvent() {
        btn_submit.setOnClickListener(this);
    }

    private void initView() {
        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_pwd);
        et_gender = (EditText) findViewById(R.id.et_gender);
        et_age = (EditText) findViewById(R.id.et_age);
        btn_submit = (Button) findViewById(R.id.btn_submit);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:

                String account = et_account.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String gender = et_gender.getText().toString().trim();
                String age = et_age.getText().toString().trim();

                VolleyUtil.getInstance().regist(account,password,age,gender,new VolleyUtil.RegistCallBack(){

                    @Override
                    public void registSuccess(String info) {
                        Log.i(TAG, "registSuccess: "+info);
                        if (info.equals(UserContents.error_user_exit)) {
                            Toast.makeText(RegistActivity.this, getResources().getString(R.string.exit), Toast.LENGTH_SHORT).show();
                        } else if (info.equals(UserContents.ok)) {
                            Toast.makeText(RegistActivity.this, getResources().getString(R.string.regist_success), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void registError(String err) {
                        Toast.makeText(RegistActivity.this, getResources().getString(R.string.regist_fail), Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }

    }
}
