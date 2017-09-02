package com.montoya.gabi.scorecard.widget;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Binder;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.Scorecard;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.CalendarUtils;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;
import com.montoya.gabi.scorecard.view.ViewScorecardActivityFragment;

/**
 * Created by Gabriel on 02/09/2017.
 */

public class ScorecardWidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {


    Cursor mCursor;
    Context mContext=null;
    Intent mIntent;

    public ScorecardWidgetDataProvider(Context mContext, Intent mIntent) {
        this.mContext = mContext;
        this.mIntent = mIntent;
    }

    @Override
    public void onCreate() {
        initData();

    }

    @Override
    public void onDataSetChanged() {
        initData();

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    @Override
    public RemoteViews getViewAt(int position) {

        if (position == AdapterView.INVALID_POSITION || mCursor == null || !mCursor.moveToPosition(position)) {
            return null;
        }

        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.scorecard_widget_item);


        int index_Id=mCursor.getColumnIndex(ScorecardContract.ScorecardEntry._ID);
        int index_date=mCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_DATE);
        int index_Name=mCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME);
        int index_NetDif=mCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF);
        int index_Gross=mCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_SCORE);
        int index_Handicap=mCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_HANDICAP);
        int index_Net=mCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_SCORE);

        long _id=mCursor.getLong(index_Id);
        String date= CalendarUtils.getFormattedDate(mCursor.getLong(index_date),mContext.getString(R.string.date_format));
        String name=mCursor.getString(index_Name);
        String netDif= ScorecardUtils.getFormattedScoreDif(mCursor.getInt(index_NetDif));
        String grossScore=ScorecardUtils.getFormattedScore(mCursor.getInt(index_Gross));
        String handicap=ScorecardUtils.getFormattedHandicap(mCursor.getInt(index_Handicap));
        String netScore=ScorecardUtils.getFormattedScore(mCursor.getInt(index_Net));

        views.setTextViewText(R.id.txt_date,date);
        views.setTextViewText(R.id.txt_golf_field_name,name);
        views.setTextViewText(R.id.txt_score_dif,netDif);
        views.setTextViewText(R.id.txt_score_gross,grossScore);
        views.setTextViewText(R.id.txt_handicap,handicap);
        views.setTextViewText(R.id.txt_score_net,netScore);


        final Intent fillInIntent = new Intent();
        fillInIntent.putExtra(ViewScorecardActivityFragment.SCORECARD_ID_LABEL, _id);
        views.setOnClickFillInIntent(R.id.widget_list_item, fillInIntent);

        return views;


    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        long id=Scorecard.SCORECARD_INVALID_ID;
        if (mCursor.moveToPosition(position)) {
            id= mCursor.getLong(mCursor.getColumnIndex(ScorecardContract.ScorecardEntry._ID));
        }
        return id;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    private void initData(){

        if (mCursor != null) {
            mCursor.close();
        }

        // This method is called by the app hosting the widget (e.g., the launcher)
        // However, our ContentProvider is not exported so it doesn't have access to the
        // data. Therefore we need to clear (and finally restore) the calling identity so
        // that calls use our process and permission
        final long identityToken = Binder.clearCallingIdentity();

        mCursor= Scorecard.getAllScorecards(mContext);

        Binder.restoreCallingIdentity(identityToken);


    }

}
