package com.kanyideveloper.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

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

        //MainActivityNumberGenerator mainActivityNumberGenerator = new MainActivityNumberGenerator();

        MainActivityNumberGenerator myNum = new ViewModelProvider(this).get(MainActivityNumberGenerator.class);

        String myRandomNum = myNum.getRandomNumber();
        tvNum.setText(myRandomNum);

        Log.d(TAG, "onCreate: Random number generated");
    }
}