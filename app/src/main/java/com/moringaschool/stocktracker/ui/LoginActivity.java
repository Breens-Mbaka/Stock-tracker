package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.stocktracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.textView10) TextView mSignUpTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mSignUpTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSignUpTextView) {
            Intent intent = new Intent(LoginActivity.this, CreateUserAccount.class);
            startActivity(intent);
            finish();
        }
    }
}