package com.moringaschool.stocktracker.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CryptoFragmentStats extends Fragment {
    @BindView(R.id.textView12) TextView mMarketCap;
    @BindView(R.id.textView14) TextView mTier;
    @BindView(R.id.textView16) TextView mRank;
    @BindView(R.id.textView18) TextView mVolume;

    private Coin mCoins;

    public CryptoFragmentStats() {
        // Required empty public constructor
    }


    public static CryptoFragmentStats newInstance(Coin coin) {
        CryptoFragmentStats cryptoFragmentStats = new CryptoFragmentStats();
        Bundle args = new Bundle();
        args.putParcelable("coin", Parcels.wrap(coin));
        cryptoFragmentStats.setArguments(args);
        return cryptoFragmentStats;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert  getArguments() != null;
        mCoins = Parcels.unwrap(getArguments().getParcelable("coin"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crypto_stats, container, false);
        ButterKnife.bind(this,view);

        mMarketCap.setText(mCoins.getMarketCap());
        mTier.setText(mCoins.getListedAt());
        mRank.setText(mCoins.getRank());
        mVolume.setText(mCoins.get24hVolume());

        return view;
    }
}