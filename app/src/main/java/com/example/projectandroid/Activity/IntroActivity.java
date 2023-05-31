package com.example.projectandroid.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectandroid.R;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout starBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        starBtn = findViewById(R.id.starBtn);
        starBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(IntroActivity.this, MainActivity.class);
               startActivity(intent);
            }
        });
    }
}