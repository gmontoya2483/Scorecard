package com.montoya.gabi.scorecard.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.montoya.gabi.scorecard.model.Scorecard;

/**
 * Created by Gabriel on 22/08/2017.
 */

public class BestScoresServices  extends IntentService{

    public static final String SERVICE_SCORECARD_ID_LABEL="service_scorecard_id";
    Scorecard mScorecard;


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BestScoresServices(String name) {
        super(name);
    }

    public BestScoresServices() {
        super(BestScoresServices.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        //Get the parameter
        long scorecard_id=intent.getLongExtra(SERVICE_SCORECARD_ID_LABEL, Scorecard.SCORECARD_INVALID_ID);
        if (scorecard_id!=Scorecard.SCORECARD_INVALID_ID){

            mScorecard=new Scorecard(getApplicationContext(),scorecard_id);
            int bestGrossDif=Scorecard.getBestGrossScoreDif(getApplicationContext());
            int bestGrossDifByGolfField=Scorecard.getBestGrossScoreDif(getApplicationContext(),mScorecard.getGolfField_id());
            int bestNetDif=Scorecard.getBestNetScoreDif(getApplicationContext());
            int bestNetDifByGolfField=Scorecard.getBestNetScoreDif(getApplicationContext(),mScorecard.getGolfField_id());

            //Verify best gross dif General
            if (mScorecard.getGrossDif()<=bestGrossDif){
                notifyBestGrossGeneral();
            }

            //Verify best gross dif by GolfField
            if (mScorecard.getGrossDif()<=bestGrossDifByGolfField){
                notifyBestGrossByGolfField();
            }

            //Verify best Net dif General
            if (mScorecard.getNetDif()<=bestNetDif){
                notifyBestGrossGeneral();
            }

            //Verify best gross dif by GolfField
            if (mScorecard.getNetDif()<=bestNetDifByGolfField){
                notifyBestNetByGolfField();
            }

        }

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void notifyBestGrossGeneral(){
        //TODO send the notification
        Log.e("SERVICE", "Best Gross");

    }

    private void notifyBestGrossByGolfField(){
        //TODO send the notification
        Log.e("SERVICE", "Best Gross by golf field");

    }

    private void notifyBestNetGeneral(){
        //TODO send the notification
        Log.e("SERVICE", "Best Net");

    }

    private void notifyBestNetByGolfField(){
        //TODO send the notification
        Log.e("SERVICE", "Best net by Golf Field");

    }

}
