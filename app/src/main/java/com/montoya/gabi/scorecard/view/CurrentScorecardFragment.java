package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.CurrentScorecard;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.CalendarUtils;
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

    private  final String CURRENT_SCORE_CARD_SELECTED_TAB_LABEL="current_scorecard_tab";
    private final int CURRENT_SCORE_NOT_SELECTED_TAB_LABEL=0;

    @BindView(R.id.current_scorecard_bottom_nav)
    BottomNavigationView mBottomNavigation;

    @BindView(R.id.tabHost_current_scorecard)
    TabHost mTabHost;

    @BindView(R.id.current_scorecard_general_card)
    CardView mCurrentScorecardGeneralCard;

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

        createBottomNavigation();

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

        void onFragmentInteraction(Uri uri);
    }


    private void createBottomNavigation(){

        mBottomNavigation.getMenu().clear();
        mBottomNavigation.inflateMenu(R.menu.bottom_menu_current_scorecard);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.item_current_scorecard_delete:

                        Toast.makeText(getContext(),"Delete",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.item_current_scorecard_confirm:
                        Toast.makeText(getContext(),"Confirm",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;

                }
                return true;
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ScorecardUtils.AddIntToSharedPreferences(getContext(),CURRENT_SCORE_CARD_SELECTED_TAB_LABEL,mTabHost.getCurrentTab());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

        super.onViewStateRestored(savedInstanceState);
        mTabHost.setCurrentTab(ScorecardUtils.RetrieveIntFromSharedPreferences(getContext(),CURRENT_SCORE_CARD_SELECTED_TAB_LABEL,CURRENT_SCORE_NOT_SELECTED_TAB_LABEL));
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




        mTabHost.setCurrentTab(CURRENT_SCORE_NOT_SELECTED_TAB_LABEL);

    }



    private void setupFragment(){

        mCurrentScorecard=new CurrentScorecard(getContext());

        //General Screen
        String golfFieldName=mCurrentScorecard.getGolfFieldName();
        String totalLength=ScorecardUtils.getFormattedLength(getContext(),mCurrentScorecard.getGolfFieldTotalLength());
        String outLength=ScorecardUtils.getFormattedLength(getContext(),mCurrentScorecard.getGolfFieldOutLength());
        String inLength=ScorecardUtils.getFormattedLength(getContext(),mCurrentScorecard.getGolfFieldInLength());

        mCurrentScorecardGFName.setText(golfFieldName);
        mCurrentScorecardGFTotalLength.setText(totalLength);
        mCurrentScorecardGFOutLength.setText(outLength);
        mCurrentScorecardGFInLength.setText(inLength);

        //set the total par
        String totalPar=ScorecardUtils.getFormattedPar(getContext(),mCurrentScorecard.getGolfFieldTotalPar());
        String outPar=ScorecardUtils.getFormattedPar(getContext(),mCurrentScorecard.getGolfFieldOutPar());
        String inPar=ScorecardUtils.getFormattedPar(getContext(),mCurrentScorecard.getGolfFieldInPar());

        mCurrentScorecardGFTotalPar.setText(totalPar);
        mCurrentScorecardGFOutPar.setText(outPar);
        mCurrentScorecardGFInPar.setText(inPar);


        String date=CalendarUtils.getFormattedDate(mCurrentScorecard.getDate(),getString(R.string.date_format));
        mCurrentScorecardDate.setText(date);



        mCurrentScorecardGeneralCard.setContentDescription(buildGeneralTabContentDescription(golfFieldName,date,totalLength,outLength,inLength,totalPar,outPar,inPar));


    }



    private String buildGeneralTabContentDescription(String name, String date, String totalLength, String outLength, String inLength, String totalPar, String outPar, String inPar){

        Context context=getContext();

        String description=String.format(context.getString(R.string.current_scorecard_a11y_general_card),
                name,
                date,
                totalLength,
                totalPar,
                outLength,
                outPar,
                inLength,
                inPar);

        return description;
    }





}
