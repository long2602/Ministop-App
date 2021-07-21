package com.example.projetct_mb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetct_mb.R;
import com.example.projetct_mb.model.*;

import java.util.List;

public class locationAdapter extends RecyclerView.Adapter<locationAdapter.locationViewHolder>{
    List<location> locationsList;

    public locationAdapter(List<location> productList) {
        this.locationsList = productList;
    }

    @NonNull
    @Override
    public locationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location,parent,false);
        return new locationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull locationViewHolder holder, int position) {
        holder.address.setText("948/43/1, Lê đức Thọ, F15, Gò Vấp, TP.HCM");
    }

    @Override
    public int getItemCount() {
        if(locationsList!=null)
            return locationsList.size();
        return 0;
    }

    public class locationViewHolder extends RecyclerView.ViewHolder{
        private TextView address;
        public locationViewHolder(@NonNull View itemView) {
            super(itemView);
            address=itemView.findViewById(R.id.itemlocation_address);

        }
    }


}
