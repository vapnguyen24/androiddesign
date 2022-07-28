package com.example.timepicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {
    Button button;
    String[] animals = {"Horse", "Cow", "Camel", "Sheep", "Goat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setMessage("noi dung dialog").setTitle("tieu de dialog");

//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(AlertDialogActivity.this, "OK", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });

                // hien thi theo dang list
                builder.setTitle("chon mau");

                builder.setItems(animals, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String animal = animals[i];
                        Toast.makeText(AlertDialogActivity.this,"You select: " + animal, Toast.LENGTH_SHORT).show();
                    }
                });

                // show dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}