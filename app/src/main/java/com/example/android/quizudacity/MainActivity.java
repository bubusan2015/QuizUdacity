package com.example.android.quizudacity;

import android.graphics.Color;
import android.provider.MediaStore;
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
    private RadioGroup q1,q2,q3,q5,q6,q7;
    private final short numberOfQuestions=7;
    private short score;
    private boolean submited;
    private RadioButton q1_a1,q1_a2,q1_a3,q1_a4;
    private RadioButton q2_a1,q2_a2,q2_a3,q2_a4;
    private CheckBox q4_a1,q4_a2,q4_a3,q4_a4;
    private EditText q3_a1;

    private RadioButton q5_a1,q5_a2,q5_a3,q5_a4;
    private RadioButton q6_a1,q6_a2,q6_a3,q6_a4;
    private RadioButton q7_a1,q7_a2,q7_a3,q7_a4;

    private Button submit,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submited=false;
        // initiate
        intialize();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(Constants.submited,submited);
    }

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
        if(q1_a3.isChecked()) {
           score++;
        }
        for(int i=0;i<q1.getChildCount();i++)
            q1.getChildAt(i).setEnabled(false);
        // question 2
        if(q2_a1.isChecked()) {
            score++;
        }
        for(int i=0;i<q2.getChildCount();i++)
            q2.getChildAt(i).setEnabled(false);
        // question 3
        String temp=this.getResources().getString(R.string.q3_answer).toUpperCase();
        if(q3_a1.getText().toString().toUpperCase().equals(temp))
            score++;
        q3_a1.setEnabled(false);

        // question 4
        if(q4_a1.isChecked() && q4_a2.isChecked()
                && !q4_a3.isChecked() && q4_a4.isChecked())
            score++;
        q4_a1.setEnabled(false);
        q4_a2.setEnabled(false);
        q4_a3.setEnabled(false);
        q4_a4.setEnabled(false);

        // question 5
        if(q5_a1.isChecked()) {
            score++;
        }
        for(int i=0;i<q5.getChildCount();i++)
            q5.getChildAt(i).setEnabled(false);

        // question 6
        if(q6_a1.isChecked()) {
            score++;
        }
        for(int i=0;i<q6.getChildCount();i++)
            q6.getChildAt(i).setEnabled(false);

        // question 7
        if(q7_a3.isChecked()) {
            score++;
        }
        for(int i=0;i<q7.getChildCount();i++)
            q7.getChildAt(i).setEnabled(false);

        // show score toast message
        if (!flag) {
            String message = getResources().getString(R.string.result, score, numberOfQuestions);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        }




    }
    public void reset() {
        submited=false;
        score=0;
        // unckeck and enable all quiz views
        q1.clearCheck();
        for(int i=0;i<q1.getChildCount();i++)
            q1.getChildAt(i).setEnabled(true);

        q2.clearCheck();
        for(int i=0;i<q2.getChildCount();i++)
            q2.getChildAt(i).setEnabled(true);

        q3_a1.setEnabled(true);
        q3_a1.setText("");

        q4_a1.setEnabled(true);
        q4_a2.setEnabled(true);
        q4_a3.setEnabled(true);
        q4_a4.setEnabled(true);

        q4_a1.setChecked(false);
        q4_a2.setChecked(false);
        q4_a3.setChecked(false);
        q4_a4.setChecked(false);

        q5.clearCheck();
        for(int i=0;i<q5.getChildCount();i++)
            q5.getChildAt(i).setEnabled(true);

        q6.clearCheck();
        for(int i=0;i<q6.getChildCount();i++)
            q6.getChildAt(i).setEnabled(true);

        q7.clearCheck();
        for(int i=0;i<q7.getChildCount();i++)
            q7.getChildAt(i).setEnabled(true);


    }
    private void intialize() {
        submit=(Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkScore(false);
            }
        });
        reset=(Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        q1=(RadioGroup) findViewById(R.id.q1);
        q1_a1=(RadioButton) findViewById(R.id.q1_a1);
        q1_a2=(RadioButton) findViewById(R.id.q1_a2);
        q1_a3=(RadioButton) findViewById(R.id.q1_a3);
        q1_a4=(RadioButton) findViewById(R.id.q1_a4);

        q2=(RadioGroup) findViewById(R.id.q2);
        q2_a1=(RadioButton) findViewById(R.id.q2_a1);
        q2_a2=(RadioButton) findViewById(R.id.q2_a2);
        q2_a3=(RadioButton) findViewById(R.id.q2_a3);
        q2_a4=(RadioButton) findViewById(R.id.q2_a4);

        q3_a1=(EditText) findViewById(R.id.q3_a1);

        q4_a1=(CheckBox) findViewById(R.id.q4_a1);
        q4_a2=(CheckBox) findViewById(R.id.q4_a2);
        q4_a3=(CheckBox) findViewById(R.id.q4_a3);
        q4_a4=(CheckBox) findViewById(R.id.q4_a4);

        q5=(RadioGroup) findViewById(R.id.q5);
        q5_a1=(RadioButton) findViewById(R.id.q5_a1);
        q5_a2=(RadioButton) findViewById(R.id.q5_a2);
        q5_a3=(RadioButton) findViewById(R.id.q5_a3);
        q5_a4=(RadioButton) findViewById(R.id.q5_a4);

        q6=(RadioGroup) findViewById(R.id.q6);
        q6_a1=(RadioButton) findViewById(R.id.q6_a1);
        q6_a2=(RadioButton) findViewById(R.id.q6_a2);
        q6_a3=(RadioButton) findViewById(R.id.q6_a3);
        q6_a4=(RadioButton) findViewById(R.id.q6_a4);

        q7=(RadioGroup) findViewById(R.id.q7);
        q7_a1=(RadioButton) findViewById(R.id.q7_a1);
        q7_a2=(RadioButton) findViewById(R.id.q7_a2);
        q7_a3=(RadioButton) findViewById(R.id.q7_a3);
        q7_a4=(RadioButton) findViewById(R.id.q7_a4);
    }

}
