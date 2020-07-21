package com.kanyideveloper.viewmodeldemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";

    private MutableLiveData<String> randomNumber = null;


    public MutableLiveData<String> getRandomNumber(){
        Log.i(TAG, "getRandomNumber: returned a random number");

        if(randomNumber ==null){
            randomNumber = new MutableLiveData<>();
            createNumber();
        }

        //Log.d(TAG, "getRandomNumber: "+randomNumber);
        return randomNumber;
    }


    public void createNumber(){
        Random random = new Random();

        Log.i(TAG, "createNumber: a new number was created");
        randomNumber.setValue("Number: "+ (random.nextInt(10-1)-1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ViewModel is destroyed");
    }
}
