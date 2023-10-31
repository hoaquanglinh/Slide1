package com.example.slide1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class SanPhamDAO {
    Context context;
    DBHelper dbHelper;

    public SanPhamDAO(Context context, DBHelper dbHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
    }

    public void insertSP(SanPham sp) {
        SQLiteDatabase sql = dbHelper.getReadableDatabase();
        ContentValues pair = new ContentValues();
        pair.put("maSP", sp.getMaSP());
        pair.put("tenSP", sp.getTenSP());
        pair.put("giaSP", sp.getGiaSP());
        // giá trị cột phải Y XỲ như khi khai báo ban đầu
        long kq = sql.insert("SP", null, pair);
        if (kq > 0)
            Toast.makeText(context, "OK-> Thanh Cong!!",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "KO-> Thanh Cong!!",
                Toast.LENGTH_SHORT).show();
    }

    public void updateSP(SanPham sp) {
        SQLiteDatabase sql = dbHelper.getReadableDatabase();
        ContentValues pair = new ContentValues();
        pair.put("tenSP", sp.getTenSP());
        pair.put("giaSP", sp.getGiaSP());
        // giá trị cột phải Y XỲ như khi khai báo ban đầu
        long kq = sql.update("SP", pair, "maSP = ?", new String[]{sp.getMaSP()});
        if (kq > 0)
            Toast.makeText(context, "OK-> Thanh Cong!!",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "KO-> Thanh Cong!!",
                Toast.LENGTH_SHORT).show();
    }

    public void deleteSP(SanPham sp) {
        SQLiteDatabase sql = dbHelper.getReadableDatabase();
        long kq = sql.delete("SP", "maSP = ?", new String[]{sp.getMaSP()});
        if (kq > 0)
            Toast.makeText(context, "OK-> Thanh Cong!!",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "KO-> Thanh Cong!!",
                Toast.LENGTH_SHORT).show();
    }

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        String getAll = "SELECT * FROM SP";
        Cursor cursor = dbHelper.getWritableDatabase().rawQuery(getAll, null);
        // tham số thứ 2 dùng để định nghĩa danh sách cột mình muốn truy vấn
        // lấy tất cả thì để là null
        // Cursor : class dùng để chứa kết quả truy vấn từ DB
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String maSP = cursor.getString(0);
                String tenSP = cursor.getString(1);
                float giaSP = cursor.getFloat(2);
                SanPham sp = new SanPham(maSP, tenSP, giaSP);
                list.add(sp);
                cursor.moveToNext(); // doc xong thi di chuyen toi vi tri tiep theo
            }
            cursor.close();
        } else {
            Toast.makeText(context, "KO CO GI !!!!",
                    Toast.LENGTH_SHORT).show();
        }

        return list;
    }
}
