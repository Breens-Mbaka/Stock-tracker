package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.stocktracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CryptoStats extends AppCompatActivity {
    @BindView(R.id.textView8)
    TextView mTextNames;
    @BindView(R.id.textView9)
    TextView mTextPrice;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.editTextTextPersonName)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crypto_stats);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {
        if(getIntent().hasExtra("uuid")) {
            Log.d("CryptoStats", "getData: found intent extras");

            String coinID = getIntent().getStringExtra("uuid");
        }
    }

    private void setData()
}