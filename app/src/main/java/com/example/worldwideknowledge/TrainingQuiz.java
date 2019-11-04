package com.example.worldwideknowledge;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TrainingQuiz extends AppCompatActivity {
    private static List<Country> countries;
    private static String continent;
    private static int rightPosAnswer;
    private static int buttonPressed;
    private static int counter;
    private static int numberQuestions;
    private ArrayList<Button> buttons = new ArrayList<Button>();

    static {
        continent = "";
        rightPosAnswer = 0;
        buttonPressed = 0;
        counter = 0;
        numberQuestions = 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_quiz);

        counter = 0;
        continent = getIntent().getStringExtra("Continent");
        countries = Globe.getRandomCountries(5, continent);
        numberQuestions = countries.size();

        buttons.add((Button) (findViewById(R.id.option1)));
        buttons.add((Button) (findViewById(R.id.option2)));
        buttons.add((Button) (findViewById(R.id.option3)));
        buttons.add((Button) (findViewById(R.id.option4)));

        generateQuiz();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void generateQuiz() {
        if (countries.isEmpty()) {
            finishQuiz();
            counter = 0;
            return;
        }

        Country country = countries.get(countries.size() - 1);
        List<Country> options = Globe.getRandomCountries(4, continent);

        for (int i = 0; i < 4; ++i) {
            if (country.equals(options.get(i))) {
                options.remove(i);
                break;
            }
        }

        if (options.size() == 4) {
            options.set(options.size() - 1, country);
        } else {
            options.add(country);
        }

        Collections.shuffle(options);

        for (int i = 0 ; i < 4; ++i) {
            if (options.get(i).equals(country)) {
                rightPosAnswer = i;
                break;
            }
        }

        setText(country);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setButtons(options);
        }
    }

    private void finishQuiz() {
        String result = ((Integer)counter).toString() + " / " + ((Integer)numberQuestions).toString();

        Intent showResult = new Intent(this, ShowResult.class);
        showResult.putExtra("result", result);

        startActivity(showResult);
    }

    private void setText(Country country) {
        TextView textView = (TextView) (findViewById(R.id.countryName));
        textView.setText("The capital of " + country.getName() + " is:");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    private void setButtons(List<Country> countries) {
        for (int i = 0; i < 4; ++i) {
            buttons.get(i).setText((countries.get(i).getCapital()));
            buttons.get(i).setBackgroundColor(Color.BLUE);
            buttons.get(i).setClickable(true);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void resetActivity() {
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                countries.remove(countries.size() - 1);
                generateQuiz();
            }
        }, 3500);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void chooseOption(View view) {
        disableButtons();

        switch (view.getId()) {
            case R.id.option1: {
                buttonPressed = 0;
                break;
            }
            case R.id.option2: {
                buttonPressed = 1;
                break;
            }
            case R.id.option3: {
                buttonPressed = 2;
                break;
            }
            case R.id.option4: {
                buttonPressed = 3;
                break;
            }
        }

        buttons.get(rightPosAnswer).setBackgroundColor(Color.GREEN);

        if (rightPosAnswer == buttonPressed) {
            ++counter;
        } else {
            buttons.get(buttonPressed).setBackgroundColor(Color.RED);
        }

        resetActivity();
    }

    private void disableButtons() {
        for (int i = 0; i < 4; ++i) {
            buttons.get(i).setClickable(false);
        }
    }
}
