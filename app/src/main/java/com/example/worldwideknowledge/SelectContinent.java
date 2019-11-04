package com.example.worldwideknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;;
import android.view.View;

public class SelectContinent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_continent);
    }

    public void trainingQuiz(View view) {
        // Create an Intent to start the second activity
        Intent trainingQuizIntent = new Intent(this, TrainingQuiz.class);

        String continent = "";
        switch (view.getId()) {
            case R.id.africa: {
                continent = "Africa";
                break;
            }
            case R.id.asia: {
                continent = "Asia";
                break;
            }
            case R.id.europe: {
                continent = "Europe";
                break;
            }
            case R.id.north_america: {
                continent = "North America";
                break;
            }
            case R.id.oceania: {
                continent = "Oceania";
                break;
            }
            case R.id.south_america: {
                continent = "South America";
                break;
            }
            default:
                break;
        }

        trainingQuizIntent.putExtra("Continent", continent);
        startActivity(trainingQuizIntent);
    }

}
