package com.example.projetct_mb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetct_mb.R;
public class Forgot2Activity extends AppCompatActivity {
    EditText editpass,editpass2;
    Button btnXacnhan;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass2);
        AnhXa();
        EventLayMatKhau();
    }

    private void EventLayMatKhau() {
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoiMatKhau();
            }
        });
    }

    private void DoiMatKhau() {
        String name=getIntent().getStringExtra("USERNAME");
        if (checkPass(editpass,editpass2,editpass.getText().toString().trim(),editpass2.getText().toString().trim())){
            MainActivity.dBhelper.updatePass(editpass.getText().toString().trim(),name);
            OpenDialog();
        }
    }

    private void OpenDialog() {
        dialog.setContentView(R.layout.dialog_forgot);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btn=dialog.findViewById(R.id.dialogforgot_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
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
    private void AnhXa() {
        editpass=(EditText)findViewById(R.id.forgot2_edit_name);
        editpass2=(EditText)findViewById(R.id.forgot2_edit_phone);
        btnXacnhan=(Button)findViewById(R.id.forgot2_btn_tieptuc);
        dialog=new Dialog(this);
    }
}