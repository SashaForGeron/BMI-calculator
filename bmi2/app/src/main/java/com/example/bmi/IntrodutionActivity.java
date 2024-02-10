package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class IntrodutionActivity extends AppCompatActivity {
    public ImageButton imBMale;
    public ImageButton imBFemale;
    public SeekBar skWeight;
    public SeekBar skHeight;
    public SeekBar skAge;
    public Button btnResult;
    public TextView tvSkAge;
    public TextView tvSkHeight;
    public TextView tvSkWeight;
    int age;
    int height;
    int weight;
    boolean gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introdution);

        skWeight = findViewById(R.id.skWeight);
        skHeight = findViewById(R.id.skHeight);
        skAge = findViewById(R.id.skAge);
        btnResult = findViewById(R.id.bRes);
        imBFemale = findViewById(R.id.bWoman);
        imBMale = findViewById(R.id.bMan);
        tvSkAge = findViewById(R.id.tvAge);
        tvSkHeight = findViewById(R.id.tvHeight);
        tvSkWeight = findViewById(R.id.tvWeight);

        imBMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = true;
            }
        });

        imBFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = false;
            }
        });
        skAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSkAge.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSkHeight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSkWeight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void Result(View v){
        weight = skWeight.getProgress();
        height = skHeight.getProgress();
        age = skAge.getProgress();
        float Weight = (float)weight;
        float Height = (float)height;
        float resultBMI = Weight/((Height/100)*(Height/100));

        Intent intent = new Intent(IntrodutionActivity.this, ResultActivity.class);
        intent.putExtra("res",resultBMI);
        intent.putExtra("age",age);
        intent.putExtra("gender",gender);
        startActivity(intent);
    }
}