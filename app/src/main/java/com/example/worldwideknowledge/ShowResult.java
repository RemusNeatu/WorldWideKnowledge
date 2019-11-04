package com.example.worldwideknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        String result = "You've scored " + getIntent().getStringExtra("result");

        TextView textView = (TextView) findViewById(R.id.result);
        textView.setText(result);

        Button button = (Button) findViewById(R.id.go_back_button);
        button.setBackgroundColor(Color.BLUE);
    }

    public void goToMainActivity(View view) {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }
}
