package com.example.mad_p03mapbuilder;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommonData extends ViewModel {
    public MutableLiveData<Integer> value;

    public  CommonData() {
        Log.i("Common", "Common data was intialized");
        value = new MutableLiveData<Integer>();
        value.setValue(null);
    }

    public Integer getValue(){
        return value.getValue();
    }

    public void setValue(Integer val){
        this.value.setValue(val);
    }
}
