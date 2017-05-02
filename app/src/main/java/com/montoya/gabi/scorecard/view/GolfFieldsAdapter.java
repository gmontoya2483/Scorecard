package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;

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
        //TODO VER SI NO ES MEJOR DEVOLVER EL Objeto

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

            holder.mGolfFieldIn.setText(String.valueOf(golfField.getIn_length()));
            holder.mGolfFieldOut.setText(String.valueOf(golfField.getOut_length()));
            holder.mGolfFieldTotal.setText(String.valueOf(golfField.getTotal_length()));
            holder.mGolfFieldPar.setText(String.valueOf(golfField.getTotal_par()));
            if (golfField.getFavorite()== ScorecardContract.ScorecardBoolean.TRUE){
                holder.mGolfFieldFavorite.setImageResource(R.drawable.ic_action_favorite_color);
            }else{
                holder.mGolfFieldFavorite.setImageResource(R.drawable.ic_action_favorite);
            }

            //TODO: format the length and convert from m to yards

        }else {

            String error="-"; //TODO add a string resourse

            holder.mGolfFieldIn.setText(error);
            holder.mGolfFieldOut.setText(error);
            holder.mGolfFieldTotal.setText(error);
            holder.mGolfFieldPar.setText(error);
            holder.mGolfFieldFavorite.setImageResource(R.drawable.ic_action_favorite);
        }


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




        public GolfFieldViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
