package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.CurrentScorecard;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CurrentScorecardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CurrentScorecardFragment extends Fragment {


    View mRootView;
    CurrentScorecard mCurrentScorecard;


    private final String TAB_GENERAL_SPEC="general_tab";
    private final String TAB_OUT_SPEC="out_tab";
    private final String TAB_IN_SPEC="in_tab";
    private final String TAB_SCORE_SPEC="score_tab";

    private final String SELECTED_TAB_LABEL="selected_tab";



    @BindView(R.id.tabHost_current_scorecard)
    TabHost mTabHost;

    @BindView(R.id.current_scorecard_gf_name_text)
    TextView mCurrentScorecardGFName;

    @BindView(R.id.current_scorecard_date_text)
    TextView mCurrentScorecardDate;


    @BindView(R.id.current_scorecard_total_length_text)
    TextView mCurrentScorecardGFTotalLength;

    @BindView(R.id.current_scorecard_total_par_text)
    TextView mCurrentScorecardGFTotalPar;

    @BindView(R.id.current_scorecard_out_length_text)
    TextView mCurrentScorecardGFOutLength;

    @BindView(R.id.current_scorecard_out_par_text)
    TextView mCurrentScorecardGFOutPar;


    @BindView(R.id.current_scorecard_in_length_text)
    TextView mCurrentScorecardGFInLength;

    @BindView(R.id.current_scorecard_in_par_text)
    TextView mCurrentScorecardGFInPar;


    private OnFragmentInteractionListener mListener;

    public CurrentScorecardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView= inflater.inflate(R.layout.current_scorecard_fragment, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        createNavigationTabs();

        setupFragment();



        return mRootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private void createNavigationTabs(){

        mTabHost.setup();

        //Tab 1
        TabHost.TabSpec spec = mTabHost.newTabSpec(TAB_GENERAL_SPEC);
        spec.setContent(R.id.tab_current_scorecard_general);
        spec.setIndicator(getString(R.string.tab_general));
        mTabHost.addTab(spec);

        //Tab 2
        spec = mTabHost.newTabSpec(TAB_OUT_SPEC);
        spec.setContent(R.id.tab_current_scorecard_out);
        spec.setIndicator(getString(R.string.tab_out));
        mTabHost.addTab(spec);

        //Tab 3
        spec = mTabHost.newTabSpec(TAB_IN_SPEC);
        spec.setContent(R.id.tab_current_scorecard_in);
        spec.setIndicator(getString(R.string.tab_in));
        mTabHost.addTab(spec);

        //Tab 4
        spec = mTabHost.newTabSpec(TAB_IN_SPEC);
        spec.setContent(R.id.tab_current_scorecard_score);
        spec.setIndicator(getString(R.string.tab_score));
        mTabHost.addTab(spec);




        mTabHost.setCurrentTab(0);

    }



    private void setupFragment(){

        mCurrentScorecard=new CurrentScorecard(getContext());

        //General Screen
        mCurrentScorecardGFName.setText(mCurrentScorecard.getGolfFieldName());
        mCurrentScorecardGFTotalLength.setText(ScorecardUtils.getFormattedLength(getContext(),mCurrentScorecard.getGolfFieldTotalLength()));
        mCurrentScorecardGFOutLength.setText(ScorecardUtils.getFormattedLength(getContext(),mCurrentScorecard.getGolfFieldOutLength()));
        mCurrentScorecardGFInLength.setText(ScorecardUtils.getFormattedLength(getContext(),mCurrentScorecard.getGolfFieldInLength()));

    }


}
