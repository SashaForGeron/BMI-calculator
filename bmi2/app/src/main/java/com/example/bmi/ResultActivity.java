package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView tvRes;
    public TextView tvYourAge;
    public TextView tvYourGender;
    public TextView tvYourHealth;
    public TextView tvYourIdWeight;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        progressBar = findViewById(R.id.progressBar);
        tvRes = findViewById(R.id.progressBarText);
        tvYourAge = findViewById(R.id.tvAge);
        tvYourGender = findViewById(R.id.tvGender);
        tvYourHealth = findViewById(R.id.tvHealth);
        tvYourIdWeight = findViewById(R.id.tvIdWeight);

        Intent intent = getIntent();
        float resBMI = intent.getFloatExtra("res",0);
        int age = intent.getIntExtra("age",0);
        boolean gender = intent.getBooleanExtra("gender",false);

        int resultBMI = (int)resBMI;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i < resultBMI){
                    tvRes.setText("" + i);
                    progressBar.setProgress(i);
                    i++;
                    handler.postDelayed(this,50);
                }else{
                    handler.removeCallbacks(this);
                }
            }
        },200);

        tvYourAge.setText("Возраст: " + age);
        if(gender == false){
            tvYourGender.setText("Пол: Женский");
        }
        else{
            tvYourGender.setText("Пол: Мужской");
        }
        if(age>=19 && age<=24 && gender == true)tvYourIdWeight.setText("Норма 19-24");
        if(age>=25 && age<=34 && gender == true)tvYourIdWeight.setText("Норма 20-25");
        if(age>=35 && age<=44 && gender == true)tvYourIdWeight.setText("Норма 21-26");
        if(age>=45 && age<=54 && gender == true)tvYourIdWeight.setText("Норма 22-27");
        if(age>=55 && age<=64 && gender == true)tvYourIdWeight.setText("Норма 25-28");
        if(age>=65 && gender == true)tvYourIdWeight.setText("Норма 24-29");

        if(age>=19 && age<=24 && gender == false)tvYourIdWeight.setText("Норма 19-23");
        if(age>=25 && age<=34 && gender == false)tvYourIdWeight.setText("Норма 19-25");
        if(age>=35 && age<=44 && gender == false)tvYourIdWeight.setText("Норма 20-26");
        if(age>=45 && age<=54 && gender == false)tvYourIdWeight.setText("Норма 21-26");
        if(age>=55 && age<=64 && gender == false)tvYourIdWeight.setText("Норма 20-26");
        if(age>=65 && gender == false)tvYourIdWeight.setText("Норма 20-26");

        if(resBMI <= 16)tvYourHealth.setText("Состояние: Выраженный дефицит массы тела");
        if(resBMI >16 && resBMI<18)tvYourHealth.setText("Состояние: Дефицит массы тела");
        if(resBMI > 18 && resBMI<25)tvYourHealth.setText("Состояние: норма");
        if(resBMI >25 && resBMI<30)tvYourHealth.setText("Состояние: Предожирение");
        if(resBMI > 30 && resBMI<35 )tvYourHealth.setText("Состояние: Ожирение первой степени");
        if(resBMI > 35 && resBMI<40 )tvYourHealth.setText("Состояние: Ожирение Второй степени");
        if(resBMI > 40)tvYourHealth.setText("Состояние: Ожирение Третьей степени");

    }
}