package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActitity extends AppCompatActivity {
    TextView name;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_actitity);
        name = findViewById(R.id.name);
        Bundle b = getIntent().getExtras();
        name.setText(Integer.toString(b.getInt("aNumber")));

        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent().putExtra("Words","From activity 2");
                setResult(RESULT_OK, getIntent());
                finish();
            }
        });

//

    }
    
}