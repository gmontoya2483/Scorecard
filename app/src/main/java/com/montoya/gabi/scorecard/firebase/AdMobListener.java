package com.montoya.gabi.scorecard.firebase;

import android.content.Context;

import com.google.android.gms.ads.AdListener;

/**
 * Created by montoya on 06.06.2017.
 */

public class AdMobListener extends AdListener {

    private Context mContext;

    public AdMobListener (Context context){
        this.mContext=context;

    }


    public AdMobListener() {
        super();
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();
    }

    @Override
    public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
    }

    @Override
    public void onAdLeftApplication() {
        super.onAdLeftApplication();
    }

    @Override
    public void onAdOpened() {
        super.onAdOpened();
    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
    }
}
