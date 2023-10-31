package com.example.slide1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SanPhamAdapter sanPhamAdapter;
    ListView lvListSP;
    ArrayList<SanPham> phamArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper =
                new DBHelper(MainActivity.this);
        findViewById(R.id.btnSave).setOnClickListener(view -> {
            SanPham sp1 = new SanPham("ip12Pro1" + new Random().nextInt(), "Iphone1", 5000);
            SanPhamDAO sanPhamDAO = new SanPhamDAO(MainActivity.this,
                    dbHelper);
            sanPhamDAO.insertSP(sp1);
            phamArrayList.add(sp1);
            sanPhamAdapter.notifyDataSetChanged(); // listview ko khac phuc duoc !!!!
        });

        lvListSP = findViewById(R.id.lvListSP);
        SanPhamDAO sanPhamDAO = new SanPhamDAO(MainActivity.this,
                dbHelper);
        phamArrayList = sanPhamDAO.getAll();
        sanPhamAdapter = new SanPhamAdapter(phamArrayList);
        lvListSP.setAdapter(sanPhamAdapter);
    }
}