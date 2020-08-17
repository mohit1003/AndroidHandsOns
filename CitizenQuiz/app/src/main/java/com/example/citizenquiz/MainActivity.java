package com.example.citizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button trueButton, falseButton;
    TextView question;
    int questionCounter = 0;
//    private Question[] questionBank = new Question[]{
//            new Question(R.string.question_amendments, false), //correct: 27
//            new Question(R.string.question_constitution, true),
//            new Question(R.string.question_declaration, true),
//            new Question(R.string.question_independence_rights, true),
//            new Question(R.string.question_religion, true),
//            new Question(R.string.question_government, false),
//            new Question(R.string.question_government_feds, false),
//            new Question(R.string.question_government_senators, true),
//            //and add more!
//    };


    @SuppressLint("WrongViewCast")
//    @Override
    protected void onCreate(Bundle savedInstanceState, View v) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout ll = (LinearLayout) v;


        trueButton = findViewById(R.id.btn_true);
        falseButton = findViewById(R.id.btn_false);
        question = findViewById(R.id.question);

        trueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

//
//        switch (v.getId()){
//            case R.id.btn_false:
//                Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
//                questionCounter++;
//
//                break;
//            case R.id.btn_true:
//                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
//                break;
//
//
//
//        }

    }
}