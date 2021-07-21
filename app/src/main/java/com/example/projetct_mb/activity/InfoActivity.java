package com.example.projetct_mb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
import com.example.projetct_mb.adapter.*;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ArrayList<info> list;
    infoAdapter adapter;
    TextView txtname,txtphone;
    ImageView imgAva,imgNext;
    ListView listView;
    ImageView imgViewProduct,imgViewInfo,imgViewCart,imgViewSearch,imgViewHome;
    Button btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        AnhXa();
        MenuInfo();
        imgViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productlayout=new Intent(getApplicationContext(),CategoryActivity.class);
                startActivity(productlayout);
            }
        });
        imgViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productlayout=new Intent(getApplicationContext(),CartActivity.class);
                startActivity(productlayout);
            }
        });
        imgViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productlayout=new Intent(getApplicationContext(),InfoActivity.class);
                startActivity(productlayout);

            }
        });
        imgViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productlayout=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(productlayout);

            }
        });
        imgViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productlayout=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(productlayout);
            }
        });

    }

    private void MenuInfo() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent=new Intent(getApplicationContext(),BillActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(getApplicationContext(),PolicyActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private void AnhXa() {
        imgViewHome=(ImageView)findViewById(R.id.main_img_home);
        imgViewProduct=(ImageView)findViewById(R.id.home_imgView_product);
        imgViewInfo=(ImageView)findViewById(R.id.main_img_info);
        imgViewCart=(ImageView)findViewById(R.id.main_img_cart);
        imgViewSearch=(ImageView)findViewById(R.id.main_img_search);
        btnlogout=(Button)findViewById(R.id.info_btn_logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(InfoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        txtname=(TextView)findViewById(R.id.info_txt_name);
        txtname.setText(HomeActivity.MAINCUSTOMER.getNameCus().toString().trim());
        txtphone=(TextView)findViewById(R.id.info_txt_phone);
        txtphone.setText(HomeActivity.MAINCUSTOMER.getPhoneCus().toString().trim());
        imgAva=(ImageView)findViewById(R.id.info_imgView_avata);
        if(HomeActivity.MAINCUSTOMER.getImgCus()!=null){
            byte[] hinhanh=HomeActivity.MAINCUSTOMER.getImgCus();
            Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
            imgAva.setImageBitmap(bitmap);
        }
        imgNext=(ImageView)findViewById(R.id.info_imgView_next);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EditInfoActivity.class);
                startActivity(intent);
            }
        });
        list=new ArrayList<>();
        list.add(new info("Đơn hàng của tôi","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6XR3wo41EWoCydtpNf8d4iHAP_7tm5Wtpog&usqp=CAU"));
        list.add(new info("Chính sách đổi trả","https://i.pinimg.com/474x/53/fa/bf/53fabf5ac9ed557319a2a0fa5ae535d8.jpg"));
        listView=(ListView)findViewById(R.id.info_listview);
        adapter=new infoAdapter(list,getApplicationContext());
        listView.setAdapter(adapter);
    }
}