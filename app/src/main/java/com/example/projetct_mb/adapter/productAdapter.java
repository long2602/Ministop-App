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
import com.example.projetct_mb.model.*;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;


public class productAdapter extends RecyclerView.Adapter<productAdapter.productViewHolder>{
    Context context;
    List<product> productArrayList;
    private productAdapter.RecyclerViewClickListener clickListener;

    public productAdapter(Context context, List<product> productArrayList, productAdapter.RecyclerViewClickListener clickListener) {
        this.context = context;
        this.productArrayList = productArrayList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new productViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {
        product pd=productArrayList.get(position);
        holder.name.setText(pd.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.price.setText(decimalFormat.format(pd.getGiasanpham())+" VNĐ");
        Picasso.get().load(pd.getHinhanhsanpham()).placeholder(R.drawable.img_load).error(R.drawable.img_error).into(holder.img);
        holder.img.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        if(productArrayList!=null)
            return productArrayList.size();
        return 0;
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
    public class productViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView img;
        public TextView name;
        public TextView price;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.itemProduct_img);
            name=itemView.findViewById(R.id.itemProduct_name);
            price=itemView.findViewById(R.id.itemProduct_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v,getAdapterPosition());
        }
    }
}
