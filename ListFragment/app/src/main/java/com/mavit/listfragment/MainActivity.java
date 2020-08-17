package com.mavit.listfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fr = getSupportFragmentManager();
        Fragment fragment = fr.findFragmentById(R.id.Container);

        if(fragment == null){
            fragment = new MyFragment();
            fr.beginTransaction()
                    .add(R.id.Container, fragment)
                    .commit();
        }
    }
}