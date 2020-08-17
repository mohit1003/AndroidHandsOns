package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    Button make;
    Button showTag;
    EditText money;
    int moneyCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        make = findViewById(R.id.makeButton);
        showTag = findViewById(R.id.ShowTag);

        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                money = findViewById(R.id.amount);
                moneyCounter += 1000;
                money.setText(String.valueOf(numberFormat.format(moneyCounter)));

                switch (moneyCounter){
                    case 10000:
                        money.setTextColor(Color.GREEN);
                        break;
                    case 20000:
                        money.setTextColor(Color.YELLOW);
                        break;
                    case 30000:
                        money.setTextColor(Color.RED);
                        break;
                }

            }
        });

        
    }

    public void showTag(View v) {
        Toast.makeText(getApplicationContext(), R.string.app_name, Toast.LENGTH_LONG).show();
    }
}

