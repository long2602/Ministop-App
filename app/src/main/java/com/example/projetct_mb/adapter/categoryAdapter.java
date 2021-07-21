package com.example.projetct_mb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;

import java.util.List;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.typeViewHolder> {
    Context context;
    private List<type> types;
    private RecyclerViewClickListener  clickListener;

    public categoryAdapter(Context context, List<type> types, RecyclerViewClickListener clickListener) {
        this.context = context;
        this.types = types;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public typeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type,parent,false);
        return new typeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull typeViewHolder holder, int position) {
        type Type=types.get(position);
        holder.txtname.setText(Type.getName());
        Picasso.get().load(Type.getImg()).placeholder(R.drawable.img_load).error(R.drawable.img_error).into(holder.img);
        holder.img.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
    public class typeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtname;
        private ImageView img;
        public typeViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.itemcategory_imgView);
            txtname=itemView.findViewById(R.id.itemcategory_txtView_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v,getAdapterPosition());
        }
    }
}
