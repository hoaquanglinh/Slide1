package com.example.slide1.slide2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.example.slide1.DBHelper;
import com.example.slide1.R;
import com.example.slide1.SanPham;
import com.example.slide1.SanPhamAdapter;
import com.example.slide1.SanPhamDAO;

import java.util.ArrayList;
import java.util.Random;

public class Slide2 extends AppCompatActivity {
    ArrayList<SanPham> sanPhams;
    RecyclerView rvList;
    SanPhamAdapterRV sanPhamAdapterRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide2);

        rvList = findViewById(R.id.rvList);

        SanPhamDAO spDAO = new SanPhamDAO(this,
                new DBHelper(this));
        sanPhams = spDAO.getAll();

        sanPhamAdapterRV = new SanPhamAdapterRV(sanPhams);
        rvList.setAdapter(sanPhamAdapterRV);

        findViewById(R.id.btnadd).setOnClickListener(v ->{
            SanPham sanPham =
                    new SanPham(new Random().nextInt()+"",
                            "ABC",12344);
            sanPhams.add(sanPham);
            sanPhamAdapterRV.notifyItemInserted(sanPhams.size());
            rvList.smoothScrollToPosition(sanPhams.size());
        });

        LinearLayoutManager ln = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        /*GridLayoutManager ln = new GridLayoutManager(this,4);*/
        /*GridLayoutManager ln = new GridLayoutManager(this,
                4, GridLayoutManager.HORIZONTAL, false);*/
        rvList.setLayoutManager(ln);

        sanPhamAdapterRV.setOnItemClickListener(position -> {
            // cu phap lambda
            spDAO.deleteSP(sanPhams.get(position));
            sanPhams.remove(position);
            sanPhamAdapterRV.notifyItemRemoved(position);
            sanPhamAdapterRV.notifyItemRangeChanged(position,
                    sanPhams.size());
        });
    }
}