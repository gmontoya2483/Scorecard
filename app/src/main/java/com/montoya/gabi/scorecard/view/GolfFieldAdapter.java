package com.montoya.gabi.scorecard.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gabriel on 26/04/2017.
 */

public class GolfFieldAdapter extends RecyclerView.Adapter<GolfFieldAdapter.GolfFieldViewHolder> {


    @Override
    public GolfFieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(GolfFieldViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class GolfFieldViewHolder extends RecyclerView.ViewHolder{

        public GolfFieldViewHolder(View itemView) {
            super(itemView);
        }
    }


}
