package com.kanyideveloper.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        TextView tvNum = findViewById(R.id.tv_num);

        MainActivityNumberGenerator mainActivityNumberGenerator = new MainActivityNumberGenerator();

        String myRandomNum = mainActivityNumberGenerator.getRandomNumber();
        tvNum.setText(myRandomNum);

        Log.d(TAG, "onCreate: Random number generated");
    }
}