package com.example.slide1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    public DBHelper(Context context){
        super(context,"sanpham.db",null,1);
        this.context = context;
    }
    String tableSP = "CREATE TABLE SP (maSP text primary key,tenSP text(50),giaSP double)";
    // bang KH
    // bang ThongKe .... n Bảng
    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL(tableSP); // chạy dòng lệnh ở biến dòng thứ 12
        // trong bài có bao nhiêu bảng thì mình gọi bấy nhiêu câu lệnh exec tại đây
        // và hàm onCreate chỉ gọi vào 1 lần DUY NHẤT khi chạy app lần đầu tiên
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }






    // chi su dung 1 file nay trong du an Android
    // tạo nhiều bảng trong TH cần lưu nhiều theo yêu cầu dự án
    // Bài toán
    // Khởi tạo CSDL để lưu Sản Phẩm gồm có các thuộc tính : maSP, tenSP, giaSP
    // Bước 1 : Khai báo thuộc tính cho class SanPham.java
    // Bước 2: Kế thừa SqliteOpenHelp cho class DBHelper
    // Bước 3:
    // Bước 4 :
    // Bước 5 :
}
