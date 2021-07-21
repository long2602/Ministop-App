package com.example.projetct_mb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
public class EditInfoActivity extends AppCompatActivity {
    EditText editname,editday,editaddress,editphone,editmail,edituser,editpass;
    ImageView img;
    ImageButton btnback;
    Button btnxacnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);
        AnhXa();
        LoadData();
        CapNhat();
    }

    private void CapNhat() {
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer cus=new customer(HomeActivity.MAINCUSTOMER.getIdCus(),editname.getText().toString().trim(),HomeActivity.MAINCUSTOMER.getUserCus().toString().trim(),
                        editpass.getText().toString().trim(),editphone.getText().toString().trim(),editday.getText().toString().trim(),editaddress.getText().toString().trim(),
                        editmail.getText().toString().trim(),HomeActivity.MAINCUSTOMER.getImgCus());
                MainActivity.dBhelper.updateCus(cus);
                HomeActivity.MAINCUSTOMER=cus;
                Toast.makeText(getApplicationContext(),"thành công",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void LoadData() {
        editname.setText(HomeActivity.MAINCUSTOMER.getNameCus().toString().trim());
        editday.setText(HomeActivity.MAINCUSTOMER.getDateCus().toString().trim());
        editphone.setText(HomeActivity.MAINCUSTOMER.getPhoneCus().toString().trim());
        editaddress.setText(HomeActivity.MAINCUSTOMER.getAddressCus().toString().trim());
        editmail.setText(HomeActivity.MAINCUSTOMER.getEmailCus().toString().trim());
        edituser.setText(HomeActivity.MAINCUSTOMER.getUserCus().toString().trim());
        editpass.setText(HomeActivity.MAINCUSTOMER.getPassCus().toString().trim());
    }

    private void AnhXa() {
        editname=(EditText)findViewById(R.id.edit_txt_name);
        editday=(EditText)findViewById(R.id.edit_txt_birthday);
        editaddress=(EditText)findViewById(R.id.edit_txt_address);
        editmail=(EditText)findViewById(R.id.edit_txt_email);
        editphone=(EditText)findViewById(R.id.edit_txt_phone);
        edituser=(EditText)findViewById(R.id.edit_txt_user);
        editpass=(EditText)findViewById(R.id.edit_txt_pass);
        img=(ImageView)findViewById(R.id.edit_img);
        btnback=(ImageButton) findViewById(R.id.main_btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnxacnhan=(Button)findViewById(R.id.edit_btn_xacnhan);
    }
}