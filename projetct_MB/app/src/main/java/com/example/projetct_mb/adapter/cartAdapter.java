package com.example.projetct_mb.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import com.example.projetct_mb.R;
import com.example.projetct_mb.activity.CartActivity;
import com.example.projetct_mb.activity.CategoryActivity;
import com.example.projetct_mb.activity.HomeActivity;
import com.example.projetct_mb.model.*;
import com.example.projetct_mb.adapter.*;
import com.squareup.picasso.Picasso;

public class cartAdapter extends BaseAdapter {
    Context context;
    ArrayList<cart> cartArrayList;

    public cartAdapter(Context context, ArrayList<cart> cartArrayList) {
        this.context = context;
        this.cartArrayList = cartArrayList;
    }

    @Override
    public int getCount() {
        return cartArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView txtName, txtPrice,txtAmount;
        public ImageButton btnAdd,btnRemove;
        public ImageView img;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.item_cart,null);
            viewHolder.txtName=view.findViewById(R.id.itemcart_txt_name);
            viewHolder.txtAmount=view.findViewById(R.id.itemcart_txt_amount);
            viewHolder.txtPrice=view.findViewById(R.id.itemcart_txt_price);
            viewHolder.btnAdd=view.findViewById(R.id.itemcart_btn_add);
            viewHolder.btnRemove=view.findViewById(R.id.itemcart_btn_remove);
            viewHolder.img=view.findViewById(R.id.itemcart_imgView);
            view.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder) view.getTag();
        }
        cart giohang=(cart)getItem(i);
        viewHolder.txtName.setText(giohang.getNamePro());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtPrice.setText(decimalFormat.format(giohang.getPrice())+" VNĐ");
        Picasso.get().load(giohang.getImg()).placeholder(R.drawable.img_load).error(R.drawable.img_error).into(viewHolder.img);
        viewHolder.img.setScaleType(ImageView.ScaleType.FIT_XY);
        viewHolder.txtAmount.setText(String.valueOf(giohang.getAmount()));
        final ViewHolder finalViewHolder=viewHolder;
        viewHolder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slm=Integer.parseInt(finalViewHolder.txtAmount.getText().toString())+1;
                finalViewHolder.txtAmount.setText(String.valueOf(slm));
                int slht= HomeActivity.ArrayCart.get(i).getAmount();
                double giaht=HomeActivity.ArrayCart.get(i).getTotal();
                HomeActivity.ArrayCart.get(i).setAmount(slm);
                double giamoinhat=(giaht*slm)/slht;
                HomeActivity.ArrayCart.get(i).setTotal(giamoinhat);
                CartActivity.Capnhat();
            }
        });

        viewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slm=Integer.parseInt(finalViewHolder.txtAmount.getText().toString())-1;
                finalViewHolder.txtAmount.setText(String.valueOf(slm));
                int slht=HomeActivity.ArrayCart.get(i).getAmount();
                double giaht=HomeActivity.ArrayCart.get(i).getTotal();
                HomeActivity.ArrayCart.get(i).setAmount(slm);
                double giamoinhat=(giaht*slm)/slht;
                HomeActivity.ArrayCart.get(i).setTotal(giamoinhat);
                CartActivity.Capnhat();
                if(slm<=0){
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("Xóa sản phẩm");
                    builder.setMessage("Bạn có chắc muốn xóa sản phẩm này không?");
                    builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position) {
                            HomeActivity.ArrayCart.remove(i);
                            notifyDataSetChanged();
                            CartActivity.Capnhat();
                        }
                    });
                    builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position) {
                            int slm=1;
                            int slht=1;
                            double giaht=HomeActivity.ArrayCart.get(i).getPrice();
                            HomeActivity.ArrayCart.get(i).setAmount(slm);
                            double giamoinhat=(giaht*slm)/slht;
                            HomeActivity.ArrayCart.get(i).setTotal(giamoinhat);
                            notifyDataSetChanged();
                            CartActivity.Capnhat();
                        }
                    });
                    AlertDialog alert=builder.create();
                    alert.show();
                }
            }
        });
        return view;
    }
}
