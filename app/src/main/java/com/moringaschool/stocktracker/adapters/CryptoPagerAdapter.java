package com.moringaschool.stocktracker.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.ui.CryptoFragmentStats;

import java.util.List;

public class CryptoPagerAdapter extends FragmentPagerAdapter {
    private List<Coin> mCoins;

    public CryptoPagerAdapter(@NonNull FragmentManager fm, int behavior,List<Coin> coins) {
        super(fm, behavior);
        mCoins = coins;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return CryptoFragmentStats.newInstance(mCoins.get(position));
    }

    @Override
    public int getCount() {
        return mCoins.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mCoins.get(position).getName();
    }
}
