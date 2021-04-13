package com.moringaschool.stocktracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.utils.ItemTouchHelperAdapter;
import com.moringaschool.stocktracker.utils.OnStartDragListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FireBaseCoinListAdapter extends FirebaseRecyclerAdapter<Coin, FirebaseCoinViewHolder> implements ItemTouchHelperAdapter {
   private DatabaseReference mRef;
   private OnStartDragListener mOnStartDragListener;
   private Context mContext;

   private ChildEventListener mChildEventListener;
   private ArrayList<Coin> mCoins = new ArrayList<>();


    public FireBaseCoinListAdapter(@NonNull FirebaseRecyclerOptions<Coin> options,
                                   Query ref,
                                   OnStartDragListener dragListener,
                                   Context context) {
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = dragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                mCoins.add(snapshot.getValue(Coin.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setIndexInFireBase() {
        for(Coin coin: mCoins) {
            int index = mCoins.indexOf(coin);
            DatabaseReference ref = getRef(index);
            coin.setIndex(Integer.toString(index));
            ref.setValue(coin);
        }
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseCoinViewHolder firebaseCoinViewHolder, int position, @NonNull Coin coin) {
        firebaseCoinViewHolder.bindCoins(coin);

        firebaseCoinViewHolder.mReorderImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(firebaseCoinViewHolder);
                }
                return false;
            }
        });
    }

    @NonNull
    @Override
    public FirebaseCoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_list_item, parent, false);
        return new FirebaseCoinViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mCoins,fromPosition,toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFireBase();
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        mCoins.remove(position);
        getRef(position).removeValue();
    }

    @Override
    public void stopListening() {
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }
}
