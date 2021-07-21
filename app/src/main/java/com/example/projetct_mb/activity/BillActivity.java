package com.example.projetct_mb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
import com.example.projetct_mb.adapter.*;

import java.util.ArrayList;

public class BillActivity extends AppCompatActivity {
    ArrayList<bill> arrayList;
    billAdapter adapter;
    RecyclerView recyclerView;
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        AnhXa();
    }

    private void AnhXa() {
        btnBack=(ImageButton)findViewById(R.id.main_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        arrayList=new ArrayList<>();
        arrayList=MainActivity.dBhelper.getBillCus(HomeActivity.MAINCUSTOMER.getIdCus());
        adapter=new billAdapter(getApplicationContext(),arrayList);
        recyclerView=(RecyclerView)findViewById(R.id.bill_listview);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}