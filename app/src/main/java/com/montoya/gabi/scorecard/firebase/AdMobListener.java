package com.montoya.gabi.scorecard.firebase;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.montoya.gabi.scorecard.R;

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
        String err_description;
        switch (i){
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                err_description=String.format(mContext.getString(R.string.ad_error_load),"ERROR_CODE_INTERNAL_ERROR");
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                err_description=String.format(mContext.getString(R.string.ad_error_load),"ERROR_CODE_INVALID_REQUEST");
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                err_description=String.format(mContext.getString(R.string.ad_error_load),"ERROR_CODE_NETWORK_ERROR");
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                err_description=String.format(mContext.getString(R.string.ad_error_load),"ERROR_CODE_NO_FILL");
                break;
            default:
                err_description=String.format(mContext.getString(R.string.ad_error_load),String.valueOf(i));
                break;
        }

        Toast.makeText(mContext,err_description,Toast.LENGTH_LONG).show();

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
