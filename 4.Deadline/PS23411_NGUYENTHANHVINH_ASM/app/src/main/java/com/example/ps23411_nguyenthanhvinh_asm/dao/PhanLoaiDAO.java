package com.example.ps23411_nguyenthanhvinh_asm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps23411_nguyenthanhvinh_asm.database.DbHelper;
import com.example.ps23411_nguyenthanhvinh_asm.model.PhanLoai;

import java.util.ArrayList;

public class PhanLoaiDAO {
    DbHelper helper;

    public PhanLoaiDAO(Context c) {
        helper = new DbHelper(c);
    }

    public ArrayList<PhanLoai> getAll() {
        ArrayList<PhanLoai> ls = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM PHANLOAI";
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            int ma = c.getInt(0);
            String ten = c.getString(1);
            String trangthai = c.getString(2);

            PhanLoai pl = new PhanLoai(ma, ten, trangthai);
            ls.add(pl);
            c.moveToNext();
        }
        return ls;

    }

    public boolean insert(PhanLoai pl) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenloai", pl.getTenLoai());
        values.put("trangthai", pl.getTrangThai());
        long row = db.insert("PHANLOAI", null, values);
        return row > 0;
    }

    public boolean update(PhanLoai pl) {
        String sql = "UPDATE PHANLOAI SET tenloai = ?, trangthai = ? WHERE maloai = ?";
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenloai", pl.getTenLoai());
        values.put("trangthai", pl.getTrangThai());
        long row = db.update("PHANLOAI",
                values,
                "WHERE maloai = ?",
                new String[]{pl.getMaLoai() + ""});
        return row > 0;
    }

    public boolean delete(int maLoai) {
        SQLiteDatabase db = helper.getWritableDatabase();
        long row = db.delete("PHANLOAI",
                "WHERE maloai = ?",
                new String[] {maLoai + ""});
        return row > 0;
    }
}
