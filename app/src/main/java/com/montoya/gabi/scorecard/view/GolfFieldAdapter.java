package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gabriel on 26/04/2017.
 */

public class GolfFieldAdapter extends RecyclerView.Adapter<GolfFieldAdapter.GolfFieldViewHolder> {


    Cursor mCursor;
    Context mContext;


    GolfFieldAdapter (Context context){
        mContext=context;

    }

    void setCursor(Cursor cursor) {
        this.mCursor = cursor;
        notifyDataSetChanged();
    }


    @Override
    public GolfFieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(GolfFieldViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mCursor != null) {
            count = mCursor.getCount();
        }
        return count;
    }

    class GolfFieldViewHolder extends RecyclerView.ViewHolder{

        public GolfFieldViewHolder(View itemView) {
            super(itemView);
        }
    }


}
