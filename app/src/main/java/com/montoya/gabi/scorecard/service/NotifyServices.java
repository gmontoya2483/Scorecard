package com.montoya.gabi.scorecard.service;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.montoya.gabi.scorecard.MainActivity;
import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.Scorecard;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;
import com.montoya.gabi.scorecard.widget.ScorecardWidget;

/**
 * Created by Gabriel on 22/08/2017.
 */

public class NotifyServices extends IntentService{

    public static final String SERVICE_SCORECARD_ID_LABEL="service_scorecard_id";
    Scorecard mScorecard;
    long mScorecard_id;

    public static final int BEST_GROSS_NOTIFICATION_ID=100;
    public static final int BEST_GROSS_BY_GF_NOTIFICATION_ID=110;
    public static final int BEST_NET_NOTIFICATION_ID=200;
    public static final int BEST_NET_BY_GF_NOTIFICATION_ID=210;


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public NotifyServices(String name) {
        super(name);
    }

    public NotifyServices() {
        super(NotifyServices.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        //Get the parameter
        mScorecard_id=intent.getLongExtra(SERVICE_SCORECARD_ID_LABEL, Scorecard.SCORECARD_INVALID_ID);
        if (mScorecard_id!=Scorecard.SCORECARD_INVALID_ID){

            mScorecard=new Scorecard(getApplicationContext(),mScorecard_id);
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
                notifyBestNetGeneral();
            }

            //Verify best gross dif by GolfField
            if (mScorecard.getNetDif()<=bestNetDifByGolfField){
                notifyBestNetByGolfField();
            }


            //Send the broacast notification to the widgets
            sendBroadcastToWidgets();


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

        String title=getString(R.string.not_best_gross_title);
        String contextText= getString(R.string.not_best_gross_context);
        String subText=String.format(getApplicationContext().getString(R.string.not_best_gross_subtext),mScorecard.getGolfFieldName(),
                ScorecardUtils.getFormattedScore(mScorecard.getGrossScore()),
                ScorecardUtils.getFormattedScoreDif(mScorecard.getGrossDif()));

        sendNotification(title,contextText,subText,BEST_GROSS_NOTIFICATION_ID);

    }

    private void notifyBestGrossByGolfField(){

        String title=getString(R.string.not_best_gross_title);
        String contextText= String.format(getApplicationContext().getString(R.string.not_best_gross_by_golf_context),mScorecard.getGolfFieldName());
        String subText=String.format(getApplicationContext().getString(R.string.not_best_gross_by_golf_subtext),
                ScorecardUtils.getFormattedScore(mScorecard.getGrossScore()),
                ScorecardUtils.getFormattedScoreDif(mScorecard.getGrossDif()));

        sendNotification(title,contextText,subText,BEST_GROSS_BY_GF_NOTIFICATION_ID);

    }

    private void notifyBestNetGeneral(){
        String title=getString(R.string.not_best_net_title);
        String contextText= getString(R.string.not_best_net_context);
        String subText=String.format(getApplicationContext().getString(R.string.not_best_net_subtext),mScorecard.getGolfFieldName(),
                ScorecardUtils.getFormattedScore(mScorecard.getNetScore()),
                ScorecardUtils.getFormattedScoreDif(mScorecard.getNetDif()));

        sendNotification(title,contextText,subText,BEST_NET_NOTIFICATION_ID);

    }

    private void notifyBestNetByGolfField(){
        String title=getString(R.string.not_best_net_title);
        String contextText= String.format(getApplicationContext().getString(R.string.not_best_net_by_golf_context),mScorecard.getGolfFieldName());
        String subText=String.format(getApplicationContext().getString(R.string.not_best_net_by_golf_subtext),
                ScorecardUtils.getFormattedScore(mScorecard.getNetScore()),
                ScorecardUtils.getFormattedScoreDif(mScorecard.getNetDif()));

        sendNotification(title,contextText,subText,BEST_NET_BY_GF_NOTIFICATION_ID);

    }


    private void sendNotification(String title, String contextText, String subText, int notificationID){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_action_golf_fields);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_golf_fields));
        builder.setContentTitle(title);
        builder.setContentText(contextText);
        builder.setSubText(subText);

        NotificationManagerCompat notificationManager= NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(notificationID, builder.build());

    }


    private void sendBroadcastToWidgets(){

        Intent dataUpdatedIntent = new Intent(ScorecardWidget.ACTION_DATA_UPDATED);
        getApplicationContext().sendBroadcast(dataUpdatedIntent);
    }

}
