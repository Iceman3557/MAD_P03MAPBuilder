package com.example.mad_p03mapbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StructureData structureData = (StructureData)

        FragmentManager frag = getSupportFragmentManager();
        SelectorFragment selectorFragment = (SelectorFragment) frag.findFragmentById(R.id.selector);
        if (selectorFragment == null){
            selectorFragment = new SelectorFragment(data);
            frag.beginTransaction().add(R.id.selector,selectorFragment).commit();
        }
    }
}