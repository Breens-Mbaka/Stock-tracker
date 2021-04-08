package com.moringaschool.stocktracker.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.adapters.StocksAdapter;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.models.MyCrypto;
import com.moringaschool.stocktracker.networking.TwelveDataApi;
import com.moringaschool.stocktracker.networking.TwelveDataClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.moringaschool.stocktracker.Constants.FIREBASE_CHILD_COIN;
import static com.moringaschool.stocktracker.Constants.FIREBASE_CHILD_COINS;

public class CryptoStats extends AppCompatActivity implements View.OnClickListener {
    private List<Coin> mCoinList;
    private Context mContext;
    private DatabaseReference mCoin;
    private ValueEventListener mCoinListener;

    @BindView(R.id.backButton)
    ImageView mBackButton;
    @BindView(R.id.favoriteCoins)
    Button mFavoriteCoins;
    @BindView(R.id.cryptoName)
    TextView mName;
    @BindView(R.id.favoriteImageView)
    ImageView mStar;
    @BindView(R.id.price)
    TextView mPrice;
    @BindView(R.id.change)
    TextView mChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mCoin = FirebaseDatabase.getInstance()
                .getReference()
                .child(FIREBASE_CHILD_COIN);

        mCoinListener = mCoin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot coinSnapshot : snapshot.getChildren()) {
                    String coinName = coinSnapshot.getValue().toString();
                    Log.d("CHANGE", "Coin: " + coinName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.crypto_stats);
        ButterKnife.bind(this);

        mBackButton.setOnClickListener(this);
        mStar.setOnClickListener(this);
        mFavoriteCoins.setOnClickListener(this);
        getData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCoin.removeEventListener(mCoinListener);
    }

    @Override
    public void onClick(View v) {
        if (v == mBackButton) {
            Intent intent = new Intent(CryptoStats.this, MainActivity.class);
            startActivity(intent);
        }
        if (v == mFavoriteCoins) {
            Intent intent = new Intent(CryptoStats.this, SavedCoinListActivity.class);
            startActivity(intent);
        }
        if (v == mStar) {
            assert mStar != null;
            mStar.setImageResource(R.drawable.ic_star_yellow);
            Intent intent = getIntent();
            int clickedCoin = Integer.parseInt(intent.getStringExtra("itemPosition"));

            TwelveDataApi twelveDataApi = TwelveDataClient.getClient();
            Call<MyCrypto> call = twelveDataApi.getStocks();

            call.enqueue(new Callback<MyCrypto>() {
                @Override
                public void onResponse(Call<MyCrypto> call, Response<MyCrypto> response) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    assert user != null;
                    String uid = user.getUid();

                    assert response.body() != null;
                    Coin myCoins = response.body().getData().getCoins().get(clickedCoin);
                    DatabaseReference coinRef = FirebaseDatabase
                            .getInstance()
                            .getReference(FIREBASE_CHILD_COINS)
                            .child(uid);

                    DatabaseReference pushRef = coinRef.push();
                    String pushId = pushRef.getKey();
                    myCoins.setPushId(pushId);
                    pushRef.setValue(myCoins);
                    Toast.makeText(CryptoStats.this, "Added to favorites", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<MyCrypto> call, Throwable t) {
                    Log.e("ERROR", "ERROR: " + t);
                }
            });
        }
    }

    public void getData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mName.setText(name);

        String price = intent.getStringExtra("price");
        mPrice.setText("$" + price);

        String change = intent.getStringExtra("change");
        Double intChange = Double.parseDouble(change);
        if (intChange < 0) {
            mChange.setTextColor(Color.parseColor("#FF0000"));
            mChange.setText(Double.toString(intChange) + "%");
        } else {
            mChange.setTextColor(Color.parseColor("#00e676"));
            mChange.setText("+" + change + "%");
        }
    }
}