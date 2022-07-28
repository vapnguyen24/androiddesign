package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    DatePicker datePicker;
    Button btnTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        timePicker = findViewById(R.id.timepicker);
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
//                Toast.makeText(MainActivity.this, i + ":" + i1, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        datePicker = findViewById(R.id.datepicker);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//                @Override
//                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//                    Toast.makeText(MainActivity.this, i + "-" + i1 + "-" + i2, Toast.LENGTH_SHORT).show();
//                }
//            });
//        }

//        time picker dialog
        btnTime = findViewById(R.id.btn);
        Calendar lich = Calendar.getInstance();
//        TimePickerDialog tpDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int i, int i1) {
//                btnTime.setText(i+":"+i1);
//            }
//        }, lich.get(Calendar.HOUR), lich.get(Calendar.MINUTE), false);
//        tpDialog.show();
//        date picker dialog

        DatePickerDialog dpDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                btnTime.setText(i+"/"+i1+"/"+i2);
            }
        }, lich.get(Calendar.YEAR), lich.get(Calendar.MONTH), lich.get(Calendar.DAY_OF_MONTH));
        dpDialog.show();

        ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "cho chut", "cu tu tu");
//        progressDialog.dismiss();
    }
}