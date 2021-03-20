package com.moringaschool.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity2 extends AppCompatActivity {
    @BindView(R.id.textView7) TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String text = intent.getStringExtra("selectedFromList");
        mText.setText(text);
    }
}