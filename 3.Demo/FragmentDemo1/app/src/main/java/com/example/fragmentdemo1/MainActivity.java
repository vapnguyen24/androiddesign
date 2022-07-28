package com.example.fragmentdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyFragment myFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnRemove = findViewById(R.id.btnRemove);
        Button btnReplace = findViewById(R.id.btnReplace);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                myFragment = new MyFragment(0);
                fragmentTransaction.add(R.id.fragment_container, myFragment, null);
                fragmentTransaction.commit();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myFragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(myFragment);
                    fragmentTransaction.commit();
                    Toast.makeText(MainActivity.this, "hellu", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("Loi: ",  "Fragment is null");
                }
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyFragment newFragment = new MyFragment(1);
                fragmentTransaction.replace(R.id.fragment_container, newFragment, null);
                fragmentTransaction.commit();
            }
        });
    }
}