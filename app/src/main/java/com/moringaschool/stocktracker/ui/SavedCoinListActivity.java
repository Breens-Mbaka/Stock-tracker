package com.moringaschool.stocktracker.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.adapters.FirebaseCoinViewHolder;
import com.moringaschool.stocktracker.models.Coin;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.moringaschool.stocktracker.Constants.FIREBASE_CHILD_COINS;

public class SavedCoinListActivity extends AppCompatActivity {
    private DatabaseReference mCoinReference;
    private FirebaseRecyclerAdapter<Coin, FirebaseCoinViewHolder> mFirebaseAdapter;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mCoinReference = FirebaseDatabase.getInstance().getReference(FIREBASE_CHILD_COINS);
        setUpFirebaseAdapter();
        hideProgressBar();
        showListOfCoins();
    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Coin> options =
        new FirebaseRecyclerOptions.Builder<Coin>()
        .setQuery(mCoinReference,Coin.class)
        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Coin, FirebaseCoinViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseCoinViewHolder firebaseCoinViewHolder, int position, @NonNull Coin coin) {
                firebaseCoinViewHolder.bindCoins(coin);
            }

            @NonNull
            @Override
            public FirebaseCoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_item,parent,false);
                return new FirebaseCoinViewHolder(view);
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showListOfCoins() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}