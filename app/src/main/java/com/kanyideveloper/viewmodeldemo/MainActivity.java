package com.kanyideveloper.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        tvNum = findViewById(R.id.tv_num);
        Button btn = findViewById(R.id.newNum);

        //MainActivityNumberGenerator mainActivityNumberGenerator = new MainActivityNumberGenerator();

        final MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        LiveData<String> myRandomNum = model.getRandomNumber();

        myRandomNum.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvNum.setText(s);
                Log.d(TAG, "onChanged: Data updated on the UI");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createNumber();
            }
        });


        Log.d(TAG, "onCreate: Random number set");
    }
}