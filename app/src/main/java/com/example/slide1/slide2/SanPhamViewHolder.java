package com.example.slide1.slide2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.slide1.R;

public class SanPhamViewHolder extends RecyclerView.ViewHolder {
    public final Button btnDel; 
    public final TextView tvInfo;
    public SanPhamViewHolder(@NonNull View itemView) {
        super(itemView);
        btnDel = itemView.findViewById(R.id.btnDel);
        tvInfo = itemView.findViewById(R.id.tvmasp);
    }

}
