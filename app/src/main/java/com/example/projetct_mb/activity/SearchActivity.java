package com.example.projetct_mb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
import com.example.projetct_mb.adapter.*;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements searchAdapter.RecyclerViewClickListener{
    ImageView imgViewProduct,imgViewInfo,imgViewCart,imgViewSearch,imgViewHome;
    Toolbar toolbar;
    androidx.appcompat.widget.SearchView searchView;
    RecyclerView recyclerView;
    searchAdapter adapter;
    private ArrayList<product> productArrayList;
    private ArrayList<product> productArrayList2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView=(SearchView) menu.findItem(R.id.menusearch).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    private void AnhXa() {
        toolbar=(Toolbar)findViewById(R.id.search_toobar);
        setSupportActionBar(toolbar);

//        listener=new searchAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View v, int position) {
//                Intent intent=new Intent(getApplicationContext(),DetailProductActivity.class);
//                intent.putExtra("IDPRODUCT",productArrayList.get(position));
//                startActivity(intent);
//            }
//        };
        productArrayList=new ArrayList<>();
        productArrayList2=new ArrayList<>();
        productArrayList=MainActivity.dBhelper.getAllProduct();
        productArrayList2=productArrayList;
        recyclerView=(RecyclerView)findViewById(R.id.search_listview);
        adapter=new searchAdapter(getApplicationContext(),productArrayList,productArrayList2,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        imgViewProduct=(ImageView)findViewById(R.id.home_imgView_product);
        imgViewInfo=(ImageView)findViewById(R.id.main_img_info);
        imgViewCart=(ImageView)findViewById(R.id.main_img_cart);
        imgViewSearch=(ImageView)findViewById(R.id.main_img_search);
        imgViewHome=(ImageView)findViewById(R.id.main_img_home);
    }

    @Override
    public void selectProduct(product pd) {
        Intent intent=new Intent(getApplicationContext(),DetailProductActivity.class);
                intent.putExtra("IDPRODUCT",pd);
                startActivity(intent);
    }
}