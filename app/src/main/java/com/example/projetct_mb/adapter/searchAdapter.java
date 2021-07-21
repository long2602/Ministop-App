package com.example.projetct_mb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.product;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class searchAdapter extends RecyclerView.Adapter<searchAdapter.productViewHolder>implements Filterable {
    Context context;
    List<product> productArrayList;
    List<product> productArrayListOld;
    private searchAdapter.RecyclerViewClickListener clickListener;

    public searchAdapter(Context context, List<product> productArrayList, List<product> productArrayListOld, RecyclerViewClickListener clickListener) {
        this.context = context;
        this.productArrayList = productArrayList;
        this.productArrayListOld = productArrayListOld;
        this.clickListener = clickListener;
    }

    public searchAdapter(Context context, List<product> productArrayList, searchAdapter.RecyclerViewClickListener clickListener) {
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key=constraint.toString();
                if(key.isEmpty()){
                    productArrayList=productArrayListOld;
                }else {
                    ArrayList<product> list=new ArrayList<>();
                    for (product product:productArrayListOld){
                        if(product.getTensanpham().toLowerCase().contains(key.toLowerCase())){
                            list.add(product);
                        }
                    }
                    productArrayList=list;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=productArrayList;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                productArrayList=(ArrayList<product>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface RecyclerViewClickListener{
        void selectProduct(product pd);
    }
    public class productViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView price;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.itemProduct_img);
            name=itemView.findViewById(R.id.itemProduct_name);
            price=itemView.findViewById(R.id.itemProduct_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.selectProduct(productArrayList.get(getAdapterPosition()));
                }
            });
        }
    }
}
