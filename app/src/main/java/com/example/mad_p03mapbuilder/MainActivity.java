package com.example.mad_p03mapbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fg = getSupportFragmentManager();
        SelectorFragment selectorFragment = (SelectorFragment) fg.findFragmentById(R.id.selector);
        if (selectorFragment == null){
            selectorFragment = new SelectorFragment();
            fg.beginTransaction().add(R.id.selector,selectorFragment).commit();
        }
    }
}