package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.CalendarUtils;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gabriel on 08/08/2017.
 */

public class ScorecardsAdapter extends RecyclerView.Adapter<ScorecardsAdapter.ScorecardViewHolder>{

    Cursor mCursor;
    Context mContext;

    ScorecardsAdapter(Context context){
        mContext=context;
    }


    public void setCursor(Cursor cursor) {
        this.mCursor = cursor;
        notifyDataSetChanged();
    }


    long getScorecard_idAtPosition(int position){
        mCursor.moveToPosition(position);
        return mCursor.getLong(mCursor.getColumnIndex(ScorecardContract.ScorecardEntry._ID));
    }



    @Override
    public ScorecardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(mContext).inflate(R.layout.scorecards_item,parent,false);
        return new ScorecardsAdapter.ScorecardViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ScorecardViewHolder holder, int position) {


        mCursor.moveToPosition(position);

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
        String netDif=ScorecardUtils.getFormattedScoreDif(mCursor.getInt(index_NetDif));
        String grossScore=ScorecardUtils.getFormattedScore(mCursor.getInt(index_Gross));
        String handicap=ScorecardUtils.getFormattedHandicap(mCursor.getInt(index_Handicap));
        String netScore=ScorecardUtils.getFormattedScore(mCursor.getInt(index_Net));

        holder.mScorecardDate.setText(date);
        holder.mScorecardGolfFieldName.setText(name);
        holder.mScorecardScoreDif.setText(netDif);
        holder.mScorecardScoreGross.setText(grossScore);
        holder.mScorecardHandicap.setText(handicap);
        holder.mScorecardScoreNET.setText(netScore);

        holder.mScorecardCard.setContentDescription(buildContentDescription(name,date,grossScore,handicap,netScore,netDif));

    }


    private String buildContentDescription(String golfField, String date, String gross, String handicap, String net, String netDif){

        String description=String.format(mContext.getString(R.string.scorecard_item_a11y_card),
                golfField,
                date,
                gross,
                handicap,
                net,
                netDif);



        return description;
    }

    @Override
    public int getItemCount() {
        int count= 0;
        if (mCursor != null) {
            count = mCursor.getCount();
        }
        return count;


    }




    class ScorecardViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.card_scorecard)
        CardView mScorecardCard;

        @BindView(R.id.txt_date)
        TextView mScorecardDate;

        @BindView(R.id.txt_golf_field_name)
        TextView mScorecardGolfFieldName;

        @BindView(R.id.txt_score_dif)
        TextView mScorecardScoreDif;

        @BindView(R.id.txt_score_gross)
        TextView mScorecardScoreGross;

        @BindView(R.id.txt_label_gross)
        TextView mScorecardLabelGross;

        @BindView(R.id.txt_handicap)
        TextView mScorecardHandicap;

        @BindView(R.id.txt_label_handicap)
        TextView mScorecardLabelHandicap;

        @BindView(R.id.txt_score_net)
        TextView mScorecardScoreNET;

        @BindView(R.id.txt_label_net)
        TextView mScorecardLabelNet;


        public ScorecardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {


                    mCursor.moveToPosition(getAdapterPosition());
                    long id=mCursor.getLong(mCursor.getColumnIndex(ScorecardContract.ScorecardEntry._ID));

                    Bundle args=new Bundle();
                    args.putLong(ViewScorecardActivityFragment.SCORECARD_ID_LABEL,id);

                    Intent viewScorecardIntent=new Intent(mContext,ViewScorecardActivity.class);
                    viewScorecardIntent.putExtras(args);

                    mContext.startActivity(viewScorecardIntent);

                }
            });

        }
    }

}
