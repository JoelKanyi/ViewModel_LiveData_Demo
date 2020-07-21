package com.kanyideveloper.viewmodeldemo;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";

    private String randomNumber = null;


    public String getRandomNumber(){
        Log.i(TAG, "getRandomNumber: invoked");

        if(randomNumber ==null){
            createNumber();
        }

        Log.d(TAG, "getRandomNumber: "+randomNumber);
        return randomNumber;
    }


    public void createNumber(){
        Random random = new Random();

        Log.i(TAG, "createNumber: invoked");
        randomNumber = "Number: "+ (random.nextInt(10-1)-1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ViewModel is destroyed");
    }
}
