package com.example.slide1.slide2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.slide1.R;
import com.example.slide1.SanPham;
import com.example.slide1.SanPhamAdapter;

import java.util.ArrayList;

public class SanPhamAdapterRV extends RecyclerView.Adapter<SanPhamViewHolder> {
    ArrayList<SanPham> arrayList;

    OnItemClickListener clickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClick){
        onItemClick = clickListener;
    }
    public SanPhamAdapterRV(ArrayList<SanPham> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sp = arrayList.get(position);
        holder.tvInfo.setText(sp.getTenSP().concat(sp.getMaSP()));
//        holder.btnDel.setOnClickListener(v -> {
//            clickListener.onClickItem(position);
//        });
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
