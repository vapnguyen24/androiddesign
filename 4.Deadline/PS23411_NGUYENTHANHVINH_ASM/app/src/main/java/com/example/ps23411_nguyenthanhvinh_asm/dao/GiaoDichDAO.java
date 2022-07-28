package com.example.ps23411_nguyenthanhvinh_asm.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps23411_nguyenthanhvinh_asm.database.DbHelper;
import com.example.ps23411_nguyenthanhvinh_asm.model.GiaoDich;

import java.util.ArrayList;

public class GiaoDichDAO {

    DbHelper helper;

    public GiaoDichDAO(Context c) {
        helper = new DbHelper(c);
    }

    public ArrayList<GiaoDich> getAll() {
        return null;
    }

    public void insert() {
    }

    public void update() {

    }

    public void delete() {

    }
}
