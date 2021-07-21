
package com.example.projetct_mb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//import com.baoyz.swipemenulistview.SwipeMenu;
//import com.baoyz.swipemenulistview.SwipeMenuCreator;
//import com.baoyz.swipemenulistview.SwipeMenuItem;
//import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
import com.example.projetct_mb.adapter.*;

import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {
    ListView cartListview;
    TextView txtNotice;
    static TextView txtAmount,txtTotal;
    ImageView imgNotice;
    Button btnDathang;
    cartAdapter adapter;
    ImageView imgViewProduct,imgViewInfo,imgViewCart,imgViewSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        AnhXa();
        CheckData();
        Capnhat();
        DatHang();
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
    private void CheckData(){
        if(HomeActivity.ArrayCart.size()<=0){
            adapter.notifyDataSetChanged();
            txtNotice.setVisibility((View.VISIBLE));
            imgNotice.setVisibility((View.VISIBLE));
            cartListview.setVisibility(View.INVISIBLE);
        }
        else{
            txtNotice.setVisibility((View.INVISIBLE));
            imgNotice.setVisibility((View.INVISIBLE));
            cartListview.setVisibility(View.VISIBLE);
        }
    }
    public static void Capnhat() {
        double tongtien=0;
        int soluong=0;
        for(int i=0;i<HomeActivity.ArrayCart.size();i++){
            tongtien+=HomeActivity.ArrayCart.get(i).getTotal();
            soluong+=HomeActivity.ArrayCart.get(i).getAmount();
        }
        HomeActivity.mainAmount=soluong;
        HomeActivity.mainTotal=tongtien;
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txtTotal.setText(decimalFormat.format(tongtien)+" VNĐ");
        txtAmount.setText(String.valueOf(soluong));
    }
    public void DatHang(){
        btnDathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
//    public void SwipeDelete(){
//        SwipeMenuCreator creator = new SwipeMenuCreator() {
//            @Override
//            public void create(SwipeMenu menu) {
//                // create "open" item
//                SwipeMenuItem deleteItem = new SwipeMenuItem(
//                        getApplicationContext());
//                // set item background
//                deleteItem.setBackground(new ColorDrawable(Color.rgb(255, 51,
//                        51)));
//                // set item width
//                deleteItem.setWidth(400);
////                // set item title
////                deleteItem.setTitle("Xóa");
////                // set item title fontsize
////                deleteItem.setTitleSize(18);
////                // set item title font color
////                deleteItem.setTitleColor(Color.WHITE);
//                // set a icon
//                deleteItem.setIcon(R.drawable.icon_delete);
//                // add to menu
//                menu.addMenuItem(deleteItem);
//            }
//        };
//
//// set creator
//        cartListview.setMenuCreator(creator);
//
//        cartListview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
//                switch (index) {
//                    case 0:
//                        // open
//                        HomeActivity.ArrayCart.remove(position);
//                        adapter.notifyDataSetChanged();
//                        Capnhat();
//                        if(HomeActivity.ArrayCart.size()<=0){
//                            txtNotice.setVisibility((View.VISIBLE));
//                            imgNotice.setVisibility((View.VISIBLE));
//                            cartListview.setVisibility(View.INVISIBLE);
//                        }
//                        else{
//                            txtNotice.setVisibility((View.INVISIBLE));
//                            imgNotice.setVisibility((View.INVISIBLE));
//                            cartListview.setVisibility(View.VISIBLE);
//                        }
//                        break;
//                }
//                // false : close the menu; true : not close the menu
//                return false;
//            }
//        });
//    }
    private void AnhXa() {
        imgViewProduct=(ImageView)findViewById(R.id.home_imgView_product);
        imgViewInfo=(ImageView)findViewById(R.id.main_img_info);
        imgViewCart=(ImageView)findViewById(R.id.main_img_cart);
        imgViewSearch=(ImageView)findViewById(R.id.main_img_search);
        cartListview=(ListView) findViewById(R.id.cart_listView);
        txtAmount=(TextView) findViewById(R.id.cart_txtview_soluong);
        txtTotal=(TextView)findViewById(R.id.cart_txt_price);
        txtNotice=(TextView)findViewById(R.id.cart_txt_Chuacosanpham);
        imgNotice=(ImageView)findViewById(R.id.cart_img_chuacosp);
        btnDathang=(Button)findViewById(R.id.cart_btn_Dathang);
        adapter=new cartAdapter(CartActivity.this,HomeActivity.ArrayCart);
        cartListview.setAdapter(adapter);
//        SwipeDelete();
    }
}
