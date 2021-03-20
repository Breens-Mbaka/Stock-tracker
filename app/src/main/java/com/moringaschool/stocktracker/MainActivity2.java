package com.moringaschool.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity2 extends AppCompatActivity {
    @BindView(R.id.textView7) TextView mTextSymbol;
    @BindView(R.id.textView8) TextView mTextNames;
    @BindView(R.id.textView9) TextView mTextPrice;
    @BindView(R.id.textView10) TextView mTextTrend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

       String text = getIntent().getStringExtra("symbol");
       mTextSymbol.setText(text);
    }
}