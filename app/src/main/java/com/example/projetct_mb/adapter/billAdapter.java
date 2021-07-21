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
import com.example.projetct_mb.model.bill;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class billAdapter extends RecyclerView.Adapter<billAdapter.typeViewHolder> {
    Context context;
    private List<bill> types;

    public billAdapter(Context context, List<bill> types) {
        this.context = context;
        this.types = types;
    }

    @NonNull
    @Override
    public typeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill,parent,false);
        return new typeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull typeViewHolder holder, int position) {
        bill Type=types.get(position);
        holder.txtma.setText("Mã đơn hàng: "+String.valueOf(Type.getIdBill()));
        holder.txtday.setText(Type.getDayBill());
        holder.txtsl.setText("Số lượng: "+String.valueOf(Type.getAmountBill()));
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.txttien.setText(decimalFormat.format(Type.getTotal())+" VNĐ");
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
    public class typeViewHolder extends RecyclerView.ViewHolder{
        private TextView txtma,txtday,txtsl,txttien;
        public typeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtma=itemView.findViewById(R.id.itembill_ma);
            txtday=itemView.findViewById(R.id.itembill_ngay);
            txtsl=itemView.findViewById(R.id.itembill_soluong);
            txttien=itemView.findViewById(R.id.itembill_tien);
        }
    }
}
