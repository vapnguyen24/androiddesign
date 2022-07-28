package com.example.ps23411_nguyenthanhvinh_asm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final int dbVersion = 1;


    public DbHelper(@Nullable Context context) {
        super(context, "ASM_MOB201", null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PHANLOAI(" +
                "maloai integer primary key autoincrement," +
                "tenloai text," +
                "trangthai text" +
                ")";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES (null, 'Lương', 'Thu')";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES (null, 'Khác', 'Thu')";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES (null, 'Du lịch', 'Chi')";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES (null, 'Sinh hoạt', 'Chi')";
        db.execSQL(sql);

        sql = "CREATE TABLE GIAODICH(" +
                "magd integer primary key autoincrement," +
                "tieude text," +
                "tien float," +
                "ngay date," +
                "mota text," +
                "maloai integer references PHANLOAI(maloai)" +
                ")";
        db.execSQL(sql);
        sql = "INSERT INTO GIAODICH VALUES(null, 'Lương tháng 5', 10000, '2022-05-01', 'thưởng thêm tiền tăng ca',1)";
        db.execSQL(sql);
        sql = "INSERT INTO GIAODICH VALUES(null, 'Tiền thuê nhà', 800, '2022-05-01', 'nộp trễ 5 ngày',4)";
        db.execSQL(sql);
        sql = "INSERT INTO GIAODICH VALUES(null, 'Tiền điện', 400, '2022-08-22', 'vượt mức chi tiêu',4)";
        db.execSQL(sql);
        sql = "INSERT INTO GIAODICH VALUES(null, 'Lương tháng 6', 10000, '2022-07-11', 'trừ lương vì không đủ kpi',1)";
        db.execSQL(sql);
        sql = "INSERT INTO GIAODICH VALUES(null, 'Đi Sapa', 20000, '2022-03-01', 'mua quà lưu ',3)";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql1 = "DROP TABLE IF EXISTS PHANLOAI";
        String sql2 = "DROP TABLE IF EXISTS GIAODICH";
        db.execSQL(sql1);
        db.execSQL(sql2);
        onCreate(db);
    }
}
