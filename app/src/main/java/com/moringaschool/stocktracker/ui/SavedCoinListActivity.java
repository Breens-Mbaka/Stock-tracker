package com.moringaschool.stocktracker.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.adapters.FireBaseCoinListAdapter;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.utils.OnStartDragListener;
import com.moringaschool.stocktracker.utils.SimpleItemTouchHelperCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.moringaschool.stocktracker.Constants.FIREBASE_CHILD_COINS;
import static com.moringaschool.stocktracker.Constants.FIREBASE_QUERY_INDEX;

public class SavedCoinListActivity extends AppCompatActivity implements OnStartDragListener {
    private DatabaseReference mCoinReference;
    private FireBaseCoinListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;
    
    @BindView(R.id.recyclerView2) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coins);
        ButterKnife.bind(this);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String uid = user.getUid();

        Query query = FirebaseDatabase
                .getInstance()
                .getReference(FIREBASE_CHILD_COINS)
                .child(uid)
                .orderByChild(FIREBASE_QUERY_INDEX);

        FirebaseRecyclerOptions<Coin> options =
        new FirebaseRecyclerOptions.Builder<Coin>()
        .setQuery(query,Coin.class)
        .build();

        mFirebaseAdapter = new FireBaseCoinListAdapter(options, query, this, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
        mRecyclerView.setHasFixedSize(true);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
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

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}