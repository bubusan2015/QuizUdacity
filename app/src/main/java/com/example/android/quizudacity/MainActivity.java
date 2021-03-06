package com.example.android.quizudacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup Question_1_RG, Question_2_RG, Question_3_RG, Question_5_RG, Question_6_RG, Question_7_RG;
    private final short numberOfQuestions=7;
    private short score;
    private boolean submited;
    private RadioButton Quest1_Ans1, Quest1_Ans2, Quest1_Ans3, Quest1_Ans4;
    private RadioButton Quest2_Ans1, Quest2_Ans2, Quest2_Ans3, Quest2_Ans4;
    private CheckBox Quest4_Ans1, Quest4_Ans2, Quest4_Ans3, Quest4_Ans4;
    private EditText Quest3_Ans1;
    private RadioButton Quest5_Ans1, Quest5_Ans2, Quest5_Ans3, Quest5_Ans4;
    private RadioButton Quest6_Ans1, Quest6_Ans2, Quest6_Ans3, Quest6_Ans4;
    private RadioButton Quest7_Ans1, Quest7_Ans2, Quest7_Ans3, Quest7_Ans4;
    private Button SubmitButton, ResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submited=false;
        // initiate
        intialize();
    }

    // save if quiz was submited or not
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(Constants.submited,submited);
    }

    // restore submited or not submited state of the quiz
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        submited=savedInstanceState.getBoolean(Constants.submited);
        if(submited)
        checkScore(submited);
    }

    public void checkScore(boolean flag) {
        score=0;
        submited=true;
        // question 1
        if(Quest1_Ans3.isChecked()) {
           score++;
        }
        for(int i = 0; i< Question_1_RG.getChildCount(); i++)
            Question_1_RG.getChildAt(i).setEnabled(false);
        // question 2
        if(Quest2_Ans1.isChecked()) {
            score++;
        }
        for(int i = 0; i< Question_2_RG.getChildCount(); i++)
            Question_2_RG.getChildAt(i).setEnabled(false);
        // question 3
        String temp=this.getResources().getString(R.string.question_3_answer).toUpperCase();
        if(Quest3_Ans1.getText().toString().toUpperCase().equals(temp))
            score++;
        Quest3_Ans1.setEnabled(false);

        // question 4
        if(Quest4_Ans1.isChecked() && Quest4_Ans2.isChecked()
                && !Quest4_Ans3.isChecked() && Quest4_Ans4.isChecked())
            score++;
        Quest4_Ans1.setEnabled(false);
        Quest4_Ans2.setEnabled(false);
        Quest4_Ans3.setEnabled(false);
        Quest4_Ans4.setEnabled(false);

        // question 5
        if(Quest5_Ans1.isChecked()) {
            score++;
        } else { };
        for(int i = 0; i< Question_5_RG.getChildCount(); i++)
            Question_5_RG.getChildAt(i).setEnabled(false);

        // question 6
        if(Quest6_Ans1.isChecked()) {
            score++;
        }
        for(int i = 0; i< Question_6_RG.getChildCount(); i++)
            Question_6_RG.getChildAt(i).setEnabled(false);

        // question 7
        if(Quest7_Ans3.isChecked()) {
            score++;
        }
        for(int i = 0; i< Question_7_RG.getChildCount(); i++)
            Question_7_RG.getChildAt(i).setEnabled(false);

        // show score toast message
        if (!flag) {
            String message = getResources().getString(R.string.result, score, numberOfQuestions);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    private void resetQuiz() {
        submited=false;
        score=0;
        // unckeck and enable all quiz views
        Question_1_RG.clearCheck();
        for(int i = 0; i< Question_1_RG.getChildCount(); i++)
            Question_1_RG.getChildAt(i).setEnabled(true);

        Question_2_RG.clearCheck();
        for(int i = 0; i< Question_2_RG.getChildCount(); i++)
            Question_2_RG.getChildAt(i).setEnabled(true);

        Quest3_Ans1.setEnabled(true);
        Quest3_Ans1.setText("");

        Quest4_Ans1.setEnabled(true);
        Quest4_Ans2.setEnabled(true);
        Quest4_Ans3.setEnabled(true);
        Quest4_Ans4.setEnabled(true);

        Quest4_Ans1.setChecked(false);
        Quest4_Ans2.setChecked(false);
        Quest4_Ans3.setChecked(false);
        Quest4_Ans4.setChecked(false);

        Question_5_RG.clearCheck();
        for(int i = 0; i< Question_5_RG.getChildCount(); i++)
            Question_5_RG.getChildAt(i).setEnabled(true);

        Question_6_RG.clearCheck();
        for(int i = 0; i< Question_6_RG.getChildCount(); i++)
            Question_6_RG.getChildAt(i).setEnabled(true);

        Question_7_RG.clearCheck();
        for(int i = 0; i< Question_7_RG.getChildCount(); i++)
            Question_7_RG.getChildAt(i).setEnabled(true);
    }

    private void intialize() {
        SubmitButton =(Button) findViewById(R.id.bt_submit);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkScore(false);
            }
        });
        ResetButton =(Button) findViewById(R.id.bt_reset);
        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });
        Question_1_RG =(RadioGroup) findViewById(R.id.rg_question_1);
        Quest1_Ans1 =(RadioButton) findViewById(R.id.rb_question_1_answer_1_matt_damon);
        Quest1_Ans2 =(RadioButton) findViewById(R.id.rb_question_1_answer_2_brad_pitt);
        Quest1_Ans3 =(RadioButton) findViewById(R.id.rb_question_1_answer_3_johnny_depp);
        Quest1_Ans4 =(RadioButton) findViewById(R.id.rb_question_1_answer_4_tom_cruise);

        Question_2_RG =(RadioGroup) findViewById(R.id.rg_question_2);
        Quest2_Ans1 =(RadioButton) findViewById(R.id.rb_question_2_answer_1_michelangelo);
        Quest2_Ans2 =(RadioButton) findViewById(R.id.rb_question_2_answer_2_leonardo);
        Quest2_Ans3 =(RadioButton) findViewById(R.id.rb_question_2_answer_3_titian);
        Quest2_Ans4 =(RadioButton) findViewById(R.id.rb_question_2_answer_4_raphael);

        Quest3_Ans1 =(EditText) findViewById(R.id.et_question_3_answer_1_rome);

        Quest4_Ans1 =(CheckBox) findViewById(R.id.cb_question_4_answer_1_lebanon);
        Quest4_Ans2 =(CheckBox) findViewById(R.id.cb_question_4_answer_2_china);
        Quest4_Ans3 =(CheckBox) findViewById(R.id.cb_question_4_answer_3_ghana);
        Quest4_Ans4 =(CheckBox) findViewById(R.id.cb_question_4_answer_4_india);

        Question_5_RG =(RadioGroup) findViewById(R.id.rg_question_5);
        Quest5_Ans1 =(RadioButton) findViewById(R.id.rb_question_5_answer_1_apple);
        Quest5_Ans2 =(RadioButton) findViewById(R.id.rb_question_5_answer_2_pinneaple);
        Quest5_Ans3 =(RadioButton) findViewById(R.id.rb_question_5_answer_3_orange);
        Quest5_Ans4 =(RadioButton) findViewById(R.id.rb_question_5_answer_4_plum);

        Question_6_RG =(RadioGroup) findViewById(R.id.rg_question_6);
        Quest6_Ans1 =(RadioButton) findViewById(R.id.rb_question_6_answer_1_wall_of_china);
        Quest6_Ans2 =(RadioButton) findViewById(R.id.rb_question_6_answer_2_tokyo);
        Quest6_Ans3 =(RadioButton) findViewById(R.id.rb_question_6_answer_3_pentagon);
        Quest6_Ans4 =(RadioButton) findViewById(R.id.rb_question_6_answer_4_sears);

        Question_7_RG =(RadioGroup) findViewById(R.id.rg_question_7);
        Quest7_Ans1 =(RadioButton) findViewById(R.id.rb_question_7_answer_1_cars);
        Quest7_Ans2 =(RadioButton) findViewById(R.id.rb_question_7_answer_2_drinks);
        Quest7_Ans3 =(RadioButton) findViewById(R.id.rb_question_7_answer_3_computers);
        Quest7_Ans4 =(RadioButton) findViewById(R.id.rb_question_7_answer_4_bikes);
    }
}
