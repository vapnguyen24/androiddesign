package com.example.ps23411_quanlychithu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ps23411_quanlychithu.fragment.FavoriteFragment;
import com.example.ps23411_quanlychithu.fragment.HistoryFragment;
import com.example.ps23411_quanlychithu.fragment.HomeFragment;
import com.example.ps23411_quanlychithu.fragment.PasswordFragment;
import com.example.ps23411_quanlychithu.fragment.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_FAVORITE = 1;
    private static final int FRAGMENT_HISTORY = 2;
    private static final int FRAGMENT_PROFILE = 3;
    private static final int FRAGMENT_PASSWORD = 4;


    // mo len se ra fragment home
    private int mCurrentFragment = FRAGMENT_HOME;

    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
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

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // mo len ra home fragment
        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                if (mCurrentFragment != FRAGMENT_HOME){
                    replaceFragment(new HomeFragment());
                    mCurrentFragment =FRAGMENT_HOME;
                }
                break;
            case R.id.nav_favorite:
                if (mCurrentFragment != FRAGMENT_FAVORITE){
                    replaceFragment(new FavoriteFragment());
                    mCurrentFragment =FRAGMENT_FAVORITE;
                }
                break;
            case R.id.nav_history:
                if (mCurrentFragment != FRAGMENT_HISTORY){
                    replaceFragment(new HistoryFragment());
                    mCurrentFragment =FRAGMENT_HISTORY;
                }
                break;
            case R.id.nav_profile:
                if (mCurrentFragment != FRAGMENT_PROFILE){
                    replaceFragment(new ProfileFragment());
                    mCurrentFragment =FRAGMENT_PROFILE;
                }
                break;
            case R.id.nav_password:
                if (mCurrentFragment != FRAGMENT_PASSWORD){
                    replaceFragment(new PasswordFragment());
                    mCurrentFragment =FRAGMENT_PASSWORD;
                }
                break;
        }

        // close drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}