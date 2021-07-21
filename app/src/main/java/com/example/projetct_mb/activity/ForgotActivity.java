package com.example.projetct_mb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetct_mb.R;

public class ForgotActivity extends AppCompatActivity {
    ImageButton imageButton;
    EditText edituser,editphone;
    Button btntieptuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        AnhXa();
        EventButton();
    }

    private void EventButton() {
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayMatkhau();
            }
        });
    }

    private void LayMatkhau() {
        if (checkUser(edituser.getText().toString().trim(),edituser) && checkPhone(editphone.getText().toString().trim(),editphone)){
            Intent intent=new Intent(getApplicationContext(),Forgot2Activity.class);
            intent.putExtra("USERNAME",edituser.getText().toString().trim());
            startActivity(intent);
        }
    }

    private boolean checkUser(String user, EditText edituser){
        if(MainActivity.dBhelper.checkUsername(user)==true){
            return true;
        }
        else {
            edituser.setError("Tên đăng nhập không tồn tại");
        }
        return false;
    }
    private boolean checkPhone(String phone,EditText editphone){
        if(MainActivity.dBhelper.checkPhone(phone)==true){
            return true;
        }
        else {
            editphone.setError("Số điện thoại không tồn tại");
        }
        return false;
    }
    private void AnhXa() {
        imageButton=(ImageButton)findViewById(R.id.main_btn_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edituser=(EditText)findViewById(R.id.forgot_edit_name);
        editphone=(EditText)findViewById(R.id.forgot_edit_phone);
        btntieptuc=(Button)findViewById(R.id.forgot_btn_tieptuc);
    }
}