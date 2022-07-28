package com.example.ps23411_nguyenthanhvinh_asm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.ps23411_nguyenthanhvinh_asm.dao.PhanLoaiDAO;
import com.example.ps23411_nguyenthanhvinh_asm.fragment.ChiFragment;
import com.example.ps23411_nguyenthanhvinh_asm.fragment.GioiThieuFragment;
import com.example.ps23411_nguyenthanhvinh_asm.fragment.ThongKeFragment;
import com.example.ps23411_nguyenthanhvinh_asm.fragment.ThuFragment;
import com.example.ps23411_nguyenthanhvinh_asm.model.PhanLoai;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

//import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int FRAGMENT_KHOANTHU = 0;
    private static final int FRAGMENT_KHOANCHI = 1;
    private static final int FRAGMENT_THONGKE = 2;
    private static final int FRAGMENT_GIOITHIEU = 3;


    // mo len se ra fragment home
    private int mCurrentFragment = FRAGMENT_KHOANTHU;
    NavigationView navigationView;


    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    PhanLoaiDAO phanLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phanLoaiDAO = new PhanLoaiDAO(MainActivity.this);
        ArrayList<PhanLoai> ls = phanLoaiDAO.getAll();
        for (PhanLoai pl:
             ls) {
            System.out.println(pl.getTenLoai());
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout,
                toolbar,
                R.string.nav_drawer_open,
                R.string.nav_drawer_close);

        //        bat su kien
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // mo activity dau se hien fragment khoan thu
        replaceFragment(new ThuFragment());
        // set checked cho drawer
        navigationView.getMenu().findItem(R.id.nav_khoanthu).setChecked(true);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_khoanthu:
                if (mCurrentFragment != FRAGMENT_KHOANTHU) {
                    replaceFragment(new ThuFragment());
                    mCurrentFragment = FRAGMENT_KHOANTHU;
                }
                break;
            case R.id.nav_khoanchi:
                if (mCurrentFragment != FRAGMENT_KHOANCHI) {
                    replaceFragment(new ChiFragment());
                    mCurrentFragment = FRAGMENT_KHOANCHI;
                }
                break;
            case R.id.nav_chart:
                if (mCurrentFragment != FRAGMENT_THONGKE) {
                    replaceFragment(new ThongKeFragment());
                    mCurrentFragment = FRAGMENT_THONGKE;
                }
                break;
            case R.id.nav_introduction:
                if (mCurrentFragment != FRAGMENT_GIOITHIEU) {
                    replaceFragment(new GioiThieuFragment());
                    mCurrentFragment = FRAGMENT_GIOITHIEU;
                }
                break;
        }
        // sau khi chon xong, dong drawer lai
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}