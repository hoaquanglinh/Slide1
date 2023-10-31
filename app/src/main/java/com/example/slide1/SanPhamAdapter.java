package com.example.slide1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    private ArrayList<SanPham> sanPhams;

    public SanPhamAdapter(ArrayList<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    @Override
    public int getCount() {
        return sanPhams.size(); // tong so item co trong array ma
        // ma minh muon hien thi === size cua array
    }

    @Override
    public SanPham getItem(int i) {
        return sanPhams.get(i); // tra ve model o vi tri i
    }

    SanPhamHolder sanPhamHolder = null;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item, viewGroup, false);
            sanPhamHolder = new SanPhamHolder();
            sanPhamHolder.tvMaSP = view.findViewById(R.id.tvmasp);
            Log.e("ABC", "POSITION " + i);
            view.setTag(sanPhamHolder);
        } else {
            sanPhamHolder = (SanPhamHolder) view.getTag();
        }
        sanPhamHolder.sp = getItem(i);
        sanPhamHolder.tvMaSP.setText(sanPhamHolder.sp.getMaSP() +
                sanPhamHolder.sp.getTenSP() +
                (sanPhamHolder.sp.getGiaSP()) );
        //sanPhamHolder.tvGiaSP.setTextColor(sanPhamHolder.sp.color);
        return view;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class SanPhamHolder {
        TextView tvMaSP, tvTenSP, tvGiaSP;
        SanPham sp;
    }

}
