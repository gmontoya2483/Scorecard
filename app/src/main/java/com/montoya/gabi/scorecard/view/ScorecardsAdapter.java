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

        //TODO hacer el Bind y desde aca!!!

        mCursor.moveToPosition(position);

    }

    @Override
    public int getItemCount() {
        return 0;
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

                    //TODO HACER EL LISTENER

                    /*
                    mCursor.moveToPosition(getAdapterPosition());
                    long id=mCursor.getLong(mCursor.getColumnIndex(ScorecardContract.GolfFieldEntry._ID));

                    Bundle args=new Bundle();
                    args.putLong(ViewGolfFieldActivityFragment.GOLF_FIELD_ID_LABEL,id);

                    Intent viewGolfFieldIntent=new Intent(mContext,ViewGolfFieldActivity.class);
                    viewGolfFieldIntent.putExtras(args);
                    ScorecardUtils.AddStringToSharedPreferences(mContext,ViewGolfFieldActivityFragment.CURRENT_MODE_KEY,ViewGolfFieldActivityFragment.CURRENT_MODE_VIEW);

                    mContext.startActivity(viewGolfFieldIntent);

                    */

                }
            });

        }
    }

}
