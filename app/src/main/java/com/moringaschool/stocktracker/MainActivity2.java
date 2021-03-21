package com.moringaschool.stocktracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity2 extends AppCompatActivity {
    @BindView(R.id.textView8) TextView mTextNames;
    @BindView(R.id.textView9) TextView mTextPrice;
    @BindView(R.id.button) Button mButton;
    @BindView(R.id.button2) Button mButton2;
    @BindView(R.id.editTextTextPersonName) EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

       String companyName = getIntent().getStringExtra("name");
       String stockPrice = getIntent().getStringExtra("stock");

       mTextNames.setText(companyName);
       mTextPrice.setText(stockPrice);
       getSupportActionBar().setTitle(companyName);

       mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity2.this,"Added to portfolio!",Toast.LENGTH_LONG).show();
           }
       });
       mButton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String portfolioName = mEditText.getEditableText().toString();
               Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
               intent.putExtra("portfolioName",portfolioName);
               mEditText.setText(null);
               startActivity(intent);
           }
       });
    }
}