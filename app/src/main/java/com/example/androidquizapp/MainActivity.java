package com.example.androidquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private TextView questionTextView;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.question_1, false),
            new Question(R.string.question_2, true),
            new Question(R.string.question_3, false),
            new Question(R.string.question_4, false),
            new Question(R.string.question_5, false),
            new Question(R.string.question_6, true),
            new Question(R.string.question_7, true),
            new Question(R.string.question_8, false),
            new Question(R.string.answer_text, false)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.false_button); //locate the element to target
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);

        questionTextView = findViewById(R.id.answer_text_view);

        falseButton.setOnClickListener(this); //register buttons to listen to click events
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.false_button:
                Toast.makeText(MainActivity.this, "False",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.true_button:
                Toast.makeText(MainActivity.this, "True",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.next_button:
                //go to next question
                currentQuestionIndex = (currentQuestionIndex +1) % questionBank.length; //avoid out of bounds exception
                questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
                Log.d("CURRENT", "onClick: " + currentQuestionIndex);
                break;
        }
    }
}