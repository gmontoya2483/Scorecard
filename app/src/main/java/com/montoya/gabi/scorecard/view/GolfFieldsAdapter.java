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
import android.widget.ImageView;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gabriel on 26/04/2017.
 */

public class GolfFieldsAdapter extends RecyclerView.Adapter<GolfFieldsAdapter.GolfFieldViewHolder> {


    Cursor mCursor;
    Context mContext;



    GolfFieldsAdapter(Context context){
        mContext=context;


    }

    public void setCursor(Cursor cursor) {
        this.mCursor = cursor;
        notifyDataSetChanged();
    }

    long getGolfField_idAtPosition(int position){


        mCursor.moveToPosition(position);
        return mCursor.getLong(mCursor.getColumnIndex(ScorecardContract.GolfFieldEntry._ID));
    }




    @Override
    public GolfFieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item= LayoutInflater.from(mContext).inflate(R.layout.golf_fields_item,parent,false);
        return new GolfFieldViewHolder(item);

    }

    @Override
    public void onBindViewHolder(GolfFieldViewHolder holder, int position) {

        mCursor.moveToPosition(position);


        int indexGFId=mCursor.getColumnIndex(ScorecardContract.GolfFieldEntry._ID);
        int indexName=mCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        int indexFavorite=mCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);
        int indexActive=mCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE);

        long _id=mCursor.getLong(indexGFId);
        String name=mCursor.getString(indexName);
        ScorecardContract.ScorecardBoolean favorite=(mCursor.getInt(indexFavorite)==1)? ScorecardContract.ScorecardBoolean.TRUE: ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean active=(mCursor.getInt(indexActive)==1)? ScorecardContract.ScorecardBoolean.TRUE: ScorecardContract.ScorecardBoolean.FALSE;



        GolfField golfField=new GolfField(_id,name,favorite,active);
        holder.mGolfFieldName.setText(golfField.getName());

        if (golfField.loadHolesFromDB(mContext)){

            holder.mGolfFieldIn.setText(ScorecardUtils.getFormattedLength(mContext,golfField.getIn_length()));
            holder.mGolfFieldOut.setText(ScorecardUtils.getFormattedLength(mContext,golfField.getOut_length()));
            holder.mGolfFieldTotal.setText(ScorecardUtils.getFormattedLength(mContext,golfField.getTotal_length()));
            holder.mGolfFieldPar.setText(String.valueOf(golfField.getTotal_par()));
            if (golfField.getFavorite()== ScorecardContract.ScorecardBoolean.TRUE){
                holder.mGolfFieldFavorite.setImageResource(R.drawable.ic_action_favorite_color);
            }else{

                holder.mGolfFieldFavorite.setVisibility(View.GONE);
            }

            holder.mGolfFieldCard.setContentDescription(buildContentDescription(golfField));


        }else {

            String error="-";

            holder.mGolfFieldIn.setText(error);
            holder.mGolfFieldOut.setText(error);
            holder.mGolfFieldTotal.setText(error);
            holder.mGolfFieldPar.setText(error);
            holder.mGolfFieldFavorite.setImageResource(R.drawable.ic_action_favorite);

        }


    }


    private String buildContentDescription(GolfField golfField){

        String description=String.format(mContext.getString(R.string.a11y_golf_field_description),
                golfField.getName(),
                ScorecardUtils.getFormattedLength(mContext,golfField.getOut_length()),
                ScorecardUtils.getFormattedLength(mContext,golfField.getIn_length()),
                ScorecardUtils.getFormattedLength(mContext,golfField.getTotal_length()),
                golfField.getTotal_par()
                );


        if (golfField.getFavorite()== ScorecardContract.ScorecardBoolean.TRUE){
            description= description+ mContext.getString(R.string.a11y_golf_field_description_favorite);
        }

        return description;
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


        @BindView(R.id.txt_golf_field_name)
        TextView mGolfFieldName;

        @BindView(R.id.txt_golf_field_out)
        TextView mGolfFieldOut;

        @BindView(R.id.txt_golf_field_in)
        TextView mGolfFieldIn;

        @BindView(R.id.txt_golf_field_total)
        TextView mGolfFieldTotal;

        @BindView(R.id.txt_golf_field_par)
        TextView mGolfFieldPar;

        @BindView(R.id.img_golf_field_favorite)
        ImageView mGolfFieldFavorite;

        @BindView(R.id.card_golf_field)
        CardView mGolfFieldCard;




        public GolfFieldViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {


                    mCursor.moveToPosition(getAdapterPosition());
                    long id=mCursor.getLong(mCursor.getColumnIndex(ScorecardContract.GolfFieldEntry._ID));

                    Bundle args=new Bundle();
                    args.putLong(ViewGolfFieldActivityFragment.GOLF_FIELD_ID_LABEL,id);

                    Intent viewGolfFieldIntent=new Intent(mContext,ViewGolfFieldActivity.class);
                    viewGolfFieldIntent.putExtras(args);
                    ScorecardUtils.AddStringToSharedPreferences(mContext,ViewGolfFieldActivityFragment.CURRENT_MODE_KEY,ViewGolfFieldActivityFragment.CURRENT_MODE_VIEW);

                    mContext.startActivity(viewGolfFieldIntent);




                }
            });


        }
    }


}
