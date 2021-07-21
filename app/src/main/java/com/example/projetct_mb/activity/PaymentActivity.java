package com.example.projetct_mb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetct_mb.R;
import com.example.projetct_mb.adapter.*;
import com.example.projetct_mb.model.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PaymentActivity extends AppCompatActivity {
    RecyclerView list;
    paymentAdapter adapter;
    Button btnThanhToan,btnedit;
    TextView txttongcong,txtname,txtphone,txtaddress;
    Dialog dialog;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        AnhXa();
        DiaChi();
        ThanhToan();
    }

    private void ThanhToan() {
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            int idbill=0;
            @Override
            public void onClick(View v) {
                String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                bill item=new bill(HomeActivity.MAINCUSTOMER.getIdCus(),timeStamp,HomeActivity.mainAmount,HomeActivity.mainTotal);
                MainActivity.dBhelper.addBill(item);
                idbill=MainActivity.dBhelper.getBill();
                for(int i=0;i<HomeActivity.ArrayCart.size();i++){
                    cart temp=HomeActivity.ArrayCart.get(i);
                    billdetail x=new billdetail(temp.getIdPro(),idbill,temp.getAmount(),temp.getTotal());
                    MainActivity.dBhelper.addBillDetail(x);
                }
                OpenDialog();
            }
        });
    }

    private void DiaChi() {
        txtname.setText(HomeActivity.MAINCUSTOMER.getNameCus());
        txtphone.setText(HomeActivity.MAINCUSTOMER.getPhoneCus());
        txtaddress.setText(HomeActivity.MAINCUSTOMER.getAddressCus());
    }
    private void OpenDialog() {
        dialog.setContentView(R.layout.dialog_success);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btn=dialog.findViewById(R.id.dialogsuccess_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.ArrayCart=null;
                HomeActivity.mainAmount=0;
                HomeActivity.mainTotal=0;
                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
    private void AnhXa() {
        txttongcong=(TextView)findViewById(R.id.payment_txt_tongcong);
        txtname=(TextView)findViewById(R.id.payment_txt_name);
        txtphone=(TextView)findViewById(R.id.payment_txt_phone);
        txtaddress=(TextView)findViewById(R.id.payment_txt_address);
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txttongcong.setText(decimalFormat.format(HomeActivity.mainTotal)+" VNĐ");
        img=(ImageView)findViewById(R.id.payment_img);
        if(HomeActivity.MAINCUSTOMER.getImgCus()!=null){
            byte[] hinhanh=HomeActivity.MAINCUSTOMER.getImgCus();
            Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
            img.setImageBitmap(bitmap);
        }
        list=(RecyclerView)findViewById(R.id.payment_listview);
        adapter=new paymentAdapter(PaymentActivity.this,HomeActivity.ArrayCart);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        btnThanhToan=(Button)findViewById(R.id.payment_btn_thanhtoan);
        btnedit=(Button)findViewById(R.id.payment_btn_edit);
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EditInfoActivity.class);
                startActivity(intent);
            }
        });
        dialog=new Dialog(this);
    }
}