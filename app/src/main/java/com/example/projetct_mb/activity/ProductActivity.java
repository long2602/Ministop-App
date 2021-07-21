package com.example.projetct_mb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetct_mb.R;
import com.example.projetct_mb.adapter.*;
import com.example.projetct_mb.model.*;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ImageView imgViewProduct,imgViewInfo,imgViewCart,imgViewSearch,imgViewHome;
    RecyclerView recyclerView;
    productAdapter adapter;
    private ArrayList<product> productArrayList;
    productAdapter.RecyclerViewClickListener listener;
    TextView txtscript;
    ImageButton btnBack;
    int IDTYPE;
    String NAMETYPE;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        IDTYPE=getIntent().getIntExtra("IDTYPE",-1);
        NAMETYPE=getIntent().getStringExtra("NAMETYPE");
        AnhXa();
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
    public void AnhXa(){
        txtscript=(TextView)findViewById(R.id.main_txt_script);
        txtscript.setText(NAMETYPE);
        btnBack=(ImageButton)findViewById(R.id.main_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgViewHome=(ImageView)findViewById(R.id.main_img_home);
        imgViewProduct=(ImageView)findViewById(R.id.home_imgView_product);
        imgViewInfo=(ImageView)findViewById(R.id.main_img_info);
        imgViewCart=(ImageView)findViewById(R.id.main_img_cart);
        imgViewSearch=(ImageView)findViewById(R.id.main_img_search);
        listener=new productAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent=new Intent(getApplicationContext(),DetailProductActivity.class);
                intent.putExtra("IDPRODUCT",productArrayList.get(position));
                startActivity(intent);
            }
        };
        productArrayList=new ArrayList<>();
        productArrayList=MainActivity.dBhelper.getTypeProduct(IDTYPE);
        toolbar=(Toolbar)findViewById(R.id.product_toobar);
        recyclerView=(RecyclerView)findViewById(R.id.product_rcv);
        adapter=new productAdapter(getApplicationContext(),productArrayList,listener);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

}