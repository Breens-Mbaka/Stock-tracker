package com.moringaschool.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity2 extends AppCompatActivity {
    @BindView(R.id.textView8) TextView mTextNames;
    @BindView(R.id.textView9) TextView mTextPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

       String companyName = getIntent().getStringExtra("name");
       String stockPrice = getIntent().getStringExtra("stock");

       mTextNames.setText(companyName);
       mTextPrice.setText(stockPrice);
    }
}