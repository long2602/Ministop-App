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
    public static double mainTotal;
    public static int mainAmount;
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
        MAINCUSTOMER=MainActivity.IDUSER;
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
        if(ArrayCart!=null)
        {

        }else{
            ArrayCart=new ArrayList<>();
            mainTotal=0;
            mainAmount=0;
        }
    }
    private void LoadProduct(){

    }

    private List<location> getListLocation() {
        List<location> list=new ArrayList<>();
        list.add(new location("P5-00.13 Cityland Park Hills, 18 Đ. Phan Văn Trị, Phường 10, Gò Vấp, Thành phố Hồ Chí Minh"));
        list.add(new location("15 Đường Nguyễn Du, Phường 7, Gò Vấp, Thành phố Hồ Chí Minh"));
        list.add(new location("165 Đ. Bạch Đằng, Phường 2, Tân Bình, Thành phố Hồ Chí Minh"));
        list.add(new location("58B Hồng Hà, Phường 2, Tân Bình, Thành phố Hồ Chí Minh"));
        list.add(new location("4 Vạn Kiếp, Phường 3, Bình Thạnh, Thành phố Hồ Chí Minh"));
        list.add(new location("B22 Đ. Bạch Đằng, Phường 2, Tân Bình, Thành phố Hồ Chí Minh"));

        return list;
    }

    private void ActionViewFlip(){
        ArrayList<String> mangquangcao=new ArrayList<>();
        mangquangcao.add("https://scontent.fhan2-4.fna.fbcdn.net/v/t1.6435-9/192141472_3796513933804745_7788556119847333653_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=730e14&_nc_ohc=LeYYVifsNm4AX_xItKN&tn=oQDg5FaTTIL_fVjk&_nc_ht=scontent.fhan2-4.fna&oh=a591fb6c7df0253967c869e63dc0263d&oe=60C7F428");
        mangquangcao.add("https://scontent.fhan2-2.fna.fbcdn.net/v/t1.6435-9/187485097_3732052913584181_5563254998178496242_n.jpg?_nc_cat=102&ccb=1-3&_nc_sid=730e14&_nc_ohc=nSQBdlAJikoAX-oePhM&_nc_ht=scontent.fhan2-2.fna&oh=a9f98d650ef7462a5281470aac04ddf9&oe=60C758DB");
        mangquangcao.add("https://scontent.fhan2-4.fna.fbcdn.net/v/t1.6435-9/186510183_3725581867564619_8660376808009068056_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=730e14&_nc_ohc=m1Cjy14uJ-wAX8EJNxd&_nc_ht=scontent.fhan2-4.fna&oh=f7a123d22a5b3c98a98ac10d36b2e26b&oe=60C73AC2");
        mangquangcao.add("https://scontent.fhan2-2.fna.fbcdn.net/v/t1.6435-9/183353903_3704466003009539_9105729186277859587_n.jpg?_nc_cat=110&ccb=1-3&_nc_sid=730e14&_nc_ohc=iEbDdjxPvkkAX_bvX5O&_nc_ht=scontent.fhan2-2.fna&oh=473af40ace2917a88e149b01a6a14a4d&oe=60C7B8B2");
        mangquangcao.add("https://scontent.fhan2-2.fna.fbcdn.net/v/t1.6435-9/178484375_3673786349410838_1928326638761035506_n.jpg?_nc_cat=106&ccb=1-3&_nc_sid=730e14&_nc_ohc=SvlW4_KDXTAAX-OjxXQ&_nc_ht=scontent.fhan2-2.fna&oh=835f1a14b546e2d3c4737c0d25da16d7&oe=60C8756A");
        mangquangcao.add("https://scontent.fhan2-2.fna.fbcdn.net/v/t1.6435-9/162409432_3572358562886951_3947280868966132959_n.jpg?_nc_cat=106&ccb=1-3&_nc_sid=730e14&_nc_ohc=cyIR7Q0c1F8AX9vvdyO&_nc_ht=scontent.fhan2-2.fna&oh=2edc088d9582cdbd9e9ef76a80fce0a7&oe=60C8F114");

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
