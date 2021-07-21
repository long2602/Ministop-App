package com.example.projetct_mb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
import com.example.projetct_mb.adapter.*;

import java.util.ArrayList;

public class
CategoryActivity extends AppCompatActivity {

    RecyclerView listView;
    ImageView imgViewProduct,imgViewInfo,imgViewCart,imgViewSearch;
    private ArrayList<type> typeArrayList;
    categoryAdapter adapter;
    categoryAdapter.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
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


    }
    public void AnhXa(){
        listener=new categoryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
//                Toast.makeText(getApplicationContext(), "Data has been saved successfully!", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),ProductActivity.class);
                intent.putExtra("IDTYPE",typeArrayList.get(position).getId());
                startActivity(intent);
            }
        };
        imgViewProduct=(ImageView)findViewById(R.id.home_imgView_product);
        imgViewInfo=(ImageView)findViewById(R.id.main_img_info);
        imgViewCart=(ImageView)findViewById(R.id.main_img_cart);
        imgViewSearch=(ImageView)findViewById(R.id.main_img_search);
        listView=(RecyclerView)findViewById(R.id.category_listview);
        typeArrayList=new ArrayList<>();
        typeArrayList=MainActivity.dBhelper.getAllType();


        adapter=new categoryAdapter(getApplicationContext(),typeArrayList,listener);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        listView.setLayoutManager(gridLayoutManager);
        listView.setAdapter(adapter);
    }

}