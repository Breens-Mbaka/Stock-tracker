package com.moringaschool.stocktracker.adapters;

import com.bumptech.glide.module.AppGlideModule;

public class MyGlide extends AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
