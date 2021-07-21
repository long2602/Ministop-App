package com.example.projetct_mb.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;

public class RegisterActivity extends AppCompatActivity {
    EditText editname,edituser,editpass,editpass2,editphone;
    ImageView img;
    Button btnDangky;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AnhXa();
        DangKy();
    }

    private void DangKy() {
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XulyDangKy();
            }
        });
    }

    private void XulyDangKy() {
        Boolean kt1,kt2,kt3,kt4,kt5;
        kt1=checkEditText(edituser);
        kt2=checkEditText(editpass);
        kt3=checkEditText(editpass2);
        kt4=checkEditText(editname);
        kt5=checkEditText(editphone);
        if(kt1 && kt2 && kt3 && kt4 && kt5 && checkPass(editpass,editpass2,editpass.getText().toString().trim(),editpass2.getText().toString().trim()) && checkUser(edituser.getText().toString().trim(),edituser)){
            MainActivity.dBhelper.addCustomer(new customer(editname.getText().toString().trim(),edituser.getText().toString().trim(),
                    editpass.getText().toString().trim(),editphone.getText().toString().trim(),null,null,null,null));
            Toast.makeText(getApplicationContext(),"Đăng ký thành công !!!",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private boolean checkEditText(EditText editText){
        if (editText.getText().toString().trim().length()>0)
            return true;
        else {
            editText.setError("Vui lòng nhập thông tin");
        }
        return false;
    }
    private boolean  checkPass(EditText pass1,EditText pass2, String pw1,String pw2){
        if(pw1.equals(pw2) &&pw1!=" "){
            return true;
        }else {
            pass1.setError("Mật khẩu không trùng khớp");
            pass2.setError("Mật khẩu không trùng khớp");
        }
        return false;
    }
    private boolean checkUser(String user,EditText edituser){
        if(MainActivity.dBhelper.checkUsername(user)==false){
            return true;
        }
        else {
            edituser.setError("Tên đăng nhập đã tồn tại");
        }
        return false;
    }
    private void AnhXa() {
        editname=(EditText)findViewById(R.id.register_txt_name);
        edituser=(EditText)findViewById(R.id.register_txt_user);
        editpass=(EditText)findViewById(R.id.register_txt_pass);
        editpass2=(EditText)findViewById(R.id.register_txt_pass2);
        editphone=(EditText)findViewById(R.id.register_txt_phone);
        btnDangky=(Button)findViewById(R.id.register_btn_dangki);
        img=(ImageView)findViewById(R.id.register_img);
        imageButton=(ImageButton)findViewById(R.id.main_btn_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}