package com.montoya.gabi.scorecard;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardProvider;

/**
 * Created by montoya on 14.04.2017.
 */

public class TestScorecardProvider extends AndroidTestCase{



    /*
         This test checks to make sure that the content provider is registered correctly.
         Students: Uncomment this test to make sure you've correctly registered the WeatherProvider.
      */
    public void testProviderRegistry() {
        PackageManager pm = mContext.getPackageManager();

        // We define the component name based on the package name from the context and the
        // WeatherProvider class.
        ComponentName componentName = new ComponentName(mContext.getPackageName(), ScorecardProvider.class.getName());
        try {
            // Fetch the provider info using the component name from the PackageManager
            // This throws an exception if the provider isn't registered.
            ProviderInfo providerInfo = pm.getProviderInfo(componentName, 0);

            // Make sure that the registered authority matches the authority from the Contract.
            assertEquals("Error: ScorecardProvider registered with authority: " + providerInfo.authority +
                            " instead of authority: " + ScorecardContract.CONTENT_AUTHORITY,
                    providerInfo.authority, ScorecardContract.CONTENT_AUTHORITY);
        } catch (PackageManager.NameNotFoundException e) {
            // I guess the provider isn't registered correctly.
            assertTrue("Error: ScorecardProvider not registered at " + mContext.getPackageName(),
                    false);
        }
    }








}
