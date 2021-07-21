package com.example.projetct_mb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;
import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
import com.example.projetct_mb.adapter.*;
import com.example.projetct_mb.db.*;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    RecyclerView rcvProduct;
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ImageView imgViewProduct,imgViewInfo,imgViewCart,imgViewSearch;
    public static ArrayList<cart> ArrayCart;
    public static double mainTotal=0;
    public static int mainAmount=0;
    UserLocalStore userLocalStore;
    static customer MAINCUSTOMER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AnhXa();
        ActionViewFlip();

//        load sản phẩm
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        rcvProduct.setLayoutManager(gridLayoutManager);
        locationAdapter adapter=new locationAdapter(getListLocation());
        rcvProduct.setAdapter(adapter);

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
    private void AnhXa() {
        viewFlipper=(ViewFlipper)findViewById(R.id.home_viewflip);
        rcvProduct=(RecyclerView)findViewById(R.id.home_rcvproduct);
        appBarLayout=(AppBarLayout)findViewById(R.id.home_appbar);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.home_collapsing);
        toolbar=(Toolbar)findViewById(R.id.home_toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.home_drawlayout);
        imgViewProduct=(ImageView)findViewById(R.id.home_imgView_product);
        imgViewInfo=(ImageView)findViewById(R.id.main_img_info);
        imgViewCart=(ImageView)findViewById(R.id.main_img_cart);
        imgViewSearch=(ImageView)findViewById(R.id.main_img_search);
        ArrayCart=new ArrayList<>();
    }
    private void LoadProduct(){

    }

    private List<location> getListLocation() {
        List<location> list=new ArrayList<>();
        list.add(new location("948/43/1, Lê đức Thọ, F15, Gò Vấp, TP.HCM"));
        list.add(new location("948/43/1, Lê đức Thọ, F15, Gò Vấp, TP.HCM"));
        list.add(new location("948/43/1, Lê đức Thọ, F15, Gò Vấp, TP.HCM"));
        list.add(new location("948/43/1, Lê đức Thọ, F15, Gò Vấp, TP.HCM"));
        return list;
    }

    private void ActionViewFlip(){
        MAINCUSTOMER=(customer) getIntent().getSerializableExtra("LOGIN");
        ArrayList<String> mangquangcao=new ArrayList<>();
        mangquangcao.add("https://www.ministop.vn/img/campaign/5e0eff8412b9d_fd2d7b509323d75f1e4d7f089f6e8f47.jpg");
        mangquangcao.add("https://www.ministop.vn/img/campaign/60bf48649c43c_14c4b421d34389eeec9a6c7f0bf3498f.jpg");
        mangquangcao.add("https://www.ministop.vn/img/campaign/601a24b6444b8_52a8f99647e193e2250711fc5ee8ca13.jpg");
        mangquangcao.add("https://www.ministop.vn/img/campaign/60b6fdff962a8_68479b24b0604d8aac03ac574313a271.jpg");
        mangquangcao.add("https://www.ministop.vn/img/campaign/60b9e6a74c48f_b98b95fe4db31aac5173ef7cc2615c6e.jpg");
        mangquangcao.add("https://www.ministop.vn/img/campaign/slide/6080f42cb115a_3816436d83c617e50b21596a174642fd.jpg");

        for (int i=0;i<mangquangcao.size();i++){
            ImageView imageView=new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation animation_slip_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slip_out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slip_in);
        viewFlipper.setOutAnimation(animation_slip_out);
    }
}
