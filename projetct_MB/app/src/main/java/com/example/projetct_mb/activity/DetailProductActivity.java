package com.example.projetct_mb.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class DetailProductActivity extends AppCompatActivity {
    Button btnMua,btnThem;
    Dialog dialog;
    int idPro=0;
    String namePro="";
    String imgPro="";
    String desPro="";
    double pricePro=0;
    int idType=0;
    TextView txtname,txtprice,txtdes;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailproduct);
        AnhXa();
        GetDuLieu();
        MuaNgay();
        ThemGioHang();
    }
    private void GetDuLieu(){
        product item=(product)getIntent().getSerializableExtra("IDPRODUCT");
        idPro=item.getID();
        namePro=item.getTensanpham();
        desPro=item.getMotasanpham();
        imgPro=item.getHinhanhsanpham();
        pricePro=item.getGiasanpham();
        idType=item.getIDSanpham();
        txtname.setText(namePro);
        txtdes.setText(desPro);
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txtprice.setText(decimalFormat.format(pricePro)+" VNĐ");
        Picasso.get().load(imgPro).placeholder(R.drawable.img_load).error(R.drawable.img_error).into(img);
        img.setScaleType(ImageView.ScaleType.FIT_XY);

    }
    private void ThemGioHang() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennewDialog();
            }
        });
    }

    private void MuaNgay() {
        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(HomeActivity.ArrayCart.size()>0){
                    boolean exist=false;
                    for(int i=0;i<HomeActivity.ArrayCart.size();i++){
                        if (HomeActivity.ArrayCart.get(i).getIdPro()==idPro){
                            HomeActivity.ArrayCart.get(i).setAmount(HomeActivity.ArrayCart.get(i).getAmount()+1);
                            HomeActivity.ArrayCart.get(i).setPrice(pricePro*HomeActivity.ArrayCart.get(i).getAmount());
                            exist=true;
                        }
                    }
                    if(exist==false){
                        int sl=1;
                        double giamoi=sl*pricePro;
                        HomeActivity.ArrayCart.add(new cart(idPro,namePro,pricePro,imgPro,sl,giamoi));
                    }
                }
                else{
                    int sl=1;
                    double giamoi=sl*pricePro;
                    HomeActivity.ArrayCart.add(new cart(idPro,namePro,pricePro,imgPro,sl,giamoi));
                }
                Intent intent =new Intent(getApplicationContext(),CartActivity.class);
                startActivity(intent);
            }
        });
    }
    private void opennewDialog() {
        dialog.setContentView(R.layout.dialog_addcart);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView NameDialog,priceDialog;
        Button btnMua,btnTieptuc;

        ImageView imageView=dialog.findViewById(R.id.dialog_imgView);
        btnMua=dialog.findViewById(R.id.dialog_btn_thanhtoan);
        btnTieptuc=dialog.findViewById(R.id.dialog_btn_tieptuc);
        NameDialog=dialog.findViewById(R.id.dialog_txt_name);
        priceDialog=dialog.findViewById(R.id.dialog_txt_price);

        NameDialog.setText(namePro);
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        priceDialog.setText(decimalFormat.format(pricePro)+" VNĐ");
        Picasso.get().load(imgPro).placeholder(R.drawable.img_load).error(R.drawable.img_error).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.ArrayCart.add(new cart(idPro,namePro,pricePro,imgPro,1,pricePro));
                Intent intent =new Intent(getApplicationContext(),CartActivity.class);
                startActivity(intent);
            }
        });
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.ArrayCart.add(new cart(idPro,namePro,pricePro,imgPro,1,pricePro));
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void AnhXa() {
        txtname=(TextView)findViewById(R.id.detail_txt_name);
        txtdes=(TextView)findViewById(R.id.detail_txt_des);
        txtprice=(TextView)findViewById(R.id.detail_txt_price);
        img=(ImageView)findViewById(R.id.detail_img);
        btnMua=(Button)findViewById(R.id.detail_btn_mua);
        btnThem=(Button)findViewById(R.id.detail_btn_them);
        dialog=new Dialog(this);

    }

}