package com.example.projetct_mb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetct_mb.R;
import com.example.projetct_mb.adapter.*;
import com.example.projetct_mb.model.*;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class paymentAdapter extends RecyclerView.Adapter<paymentAdapter.shirtViewHolder>{
    Context context;
    ArrayList<cart> cartArrayList;

    public paymentAdapter(Context context, ArrayList<cart> cartArrayList) {
        this.context = context;
        this.cartArrayList = cartArrayList;
    }

    @NonNull
    @Override
    public shirtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment,parent,false);
        return new shirtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull shirtViewHolder holder, int position) {
        cart product=cartArrayList.get(position);
        String gia=String.valueOf(product.getPrice());
        String sl=String.valueOf(product.getAmount());
        holder.name.setText(product.getNamePro());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.gia.setText(decimalFormat.format(product.getPrice())+" VNĐ");
        holder.amount.setText(sl);
        Picasso.get().load(product.getImg()).placeholder(R.drawable.img_load).error(R.drawable.img_error).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return cartArrayList.size();
    }

    public class shirtViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name, amount;
        private TextView gia;
        public shirtViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.itempayment_imgView);
            name=itemView.findViewById(R.id.itempayment_txt_name);
            gia=itemView.findViewById(R.id.itempayment_txt_price);
            amount=itemView.findViewById(R.id.itempayment_amount);
        }
    }
}
