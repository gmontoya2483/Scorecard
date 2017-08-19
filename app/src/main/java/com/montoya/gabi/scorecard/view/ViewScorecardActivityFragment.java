package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.Scorecard;

/**
 * A placeholder fragment containing a simple view.
 */
public class ViewScorecardActivityFragment extends Fragment {


    View mRootView;
    Scorecard mScorecard;

    //bundle information
    public static final String SCORECARD_ID_LABEL="scorecard_id_label";
    private long mScorecard_id;


    public ViewScorecardActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView= inflater.inflate(R.layout.view_scorecard_fragment, container, false);

        retrieveArguments();


        return mRootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }


    private void retrieveArguments(){
        Bundle args;
        args=getArguments();

        if (args!=null){
            mScorecard_id= args.getLong(SCORECARD_ID_LABEL, Scorecard.SCORECARD_INVALID_ID);
        }else{
            mScorecard_id=Scorecard.SCORECARD_INVALID_ID;
        }

    }


}
