package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonNext;
    EditText name;
    Bundle bl;
    private static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNext = findViewById(R.id.btn_next);
        name = findViewById(R.id.TextPersonName);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleDemo = new Bundle();

                Intent toNext = new Intent(MainActivity.this, NextActitity.class);
                bundleDemo.putString("name", name.getText().toString());
                bundleDemo.putString("demo", "This is a string");
                bundleDemo.putInt("aNumber", 10);
                toNext.putExtras(bundleDemo);
                startActivityForResult(toNext, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String strEditText = data.getStringExtra("Words");
            Toast.makeText(getApplicationContext(), strEditText,Toast.LENGTH_SHORT).show();
        }
    }

}