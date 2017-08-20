package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.content.Intent;
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

import com.montoya.gabi.scorecard.MainActivity;
import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.CurrentScorecard;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.Scorecard;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.CalendarUtils;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_1;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_10;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_11;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_12;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_13;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_14;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_15;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_16;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_17;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_18;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_2;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_3;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_4;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_5;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_6;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_7;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_8;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_9;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CurrentScorecardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CurrentScorecardFragment extends Fragment {


    View mRootView;
    CurrentScorecard mCurrentScorecard;
    private MainActivity.CurrentScorecardInterface mCurrentScorecardInterface;
    Scorecard mScorecard;


    private final String TAB_GENERAL_SPEC="general_tab";
    private final String TAB_OUT_SPEC="out_tab";
    private final String TAB_IN_SPEC="in_tab";
    private final String TAB_SCORE_SPEC="score_tab";

    private  final String CURRENT_SCORE_CARD_SELECTED_TAB_LABEL="current_scorecard_tab";
    private final int CURRENT_SCORE_NOT_SELECTED_TAB_LABEL=0;

    //General
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

    //OUT
    //Hole 1
    @BindView (R.id.current_scorecard_hole_1_card)
    CardView mCurrentScorecardHole_1_Card;
    @BindView (R.id.current_scorecard_hole_1_lenght_text)
    TextView mCurrentScorecardHole_1_Length;
    @BindView (R.id.current_scorecard_hole_1_par_text)
    TextView mCurrentScorecardHole_1_par;
    @BindView (R.id.current_scorecard_hole_1_score_text)
    TextView mCurrentScorecardHole_1_score;
    @BindView (R.id.current_scorecard_hole_1_dif_text)
    TextView mCurrentScorecardHole_1_dif;
    //Hole 2
    @BindView (R.id.current_scorecard_hole_2_card)
    CardView mCurrentScorecardHole_2_Card;
    @BindView (R.id.current_scorecard_hole_2_lenght_text)
    TextView mCurrentScorecardHole_2_Length;
    @BindView (R.id.current_scorecard_hole_2_par_text)
    TextView mCurrentScorecardHole_2_par;
    @BindView (R.id.current_scorecard_hole_2_score_text)
    TextView mCurrentScorecardHole_2_score;
    @BindView (R.id.current_scorecard_hole_2_dif_text)
    TextView mCurrentScorecardHole_2_dif;
    //Hole 3
    @BindView (R.id.current_scorecard_hole_3_card)
    CardView mCurrentScorecardHole_3_Card;
    @BindView (R.id.current_scorecard_hole_3_lenght_text)
    TextView mCurrentScorecardHole_3_Length;
    @BindView (R.id.current_scorecard_hole_3_par_text)
    TextView mCurrentScorecardHole_3_par;
    @BindView (R.id.current_scorecard_hole_3_score_text)
    TextView mCurrentScorecardHole_3_score;
    @BindView (R.id.current_scorecard_hole_3_dif_text)
    TextView mCurrentScorecardHole_3_dif;
    //Hole 4
    @BindView (R.id.current_scorecard_hole_4_card)
    CardView mCurrentScorecardHole_4_Card;
    @BindView (R.id.current_scorecard_hole_4_lenght_text)
    TextView mCurrentScorecardHole_4_Length;
    @BindView (R.id.current_scorecard_hole_4_par_text)
    TextView mCurrentScorecardHole_4_par;
    @BindView (R.id.current_scorecard_hole_4_score_text)
    TextView mCurrentScorecardHole_4_score;
    @BindView (R.id.current_scorecard_hole_4_dif_text)
    TextView mCurrentScorecardHole_4_dif;
    //Hole 5
    @BindView (R.id.current_scorecard_hole_5_card)
    CardView mCurrentScorecardHole_5_Card;
    @BindView (R.id.current_scorecard_hole_5_lenght_text)
    TextView mCurrentScorecardHole_5_Length;
    @BindView (R.id.current_scorecard_hole_5_par_text)
    TextView mCurrentScorecardHole_5_par;
    @BindView (R.id.current_scorecard_hole_5_score_text)
    TextView mCurrentScorecardHole_5_score;
    @BindView (R.id.current_scorecard_hole_5_dif_text)
    TextView mCurrentScorecardHole_5_dif;
    //Hole 6
    @BindView (R.id.current_scorecard_hole_6_card)
    CardView mCurrentScorecardHole_6_Card;
    @BindView (R.id.current_scorecard_hole_6_lenght_text)
    TextView mCurrentScorecardHole_6_Length;
    @BindView (R.id.current_scorecard_hole_6_par_text)
    TextView mCurrentScorecardHole_6_par;
    @BindView (R.id.current_scorecard_hole_6_score_text)
    TextView mCurrentScorecardHole_6_score;
    @BindView (R.id.current_scorecard_hole_6_dif_text)
    TextView mCurrentScorecardHole_6_dif;
    //Hole 7
    @BindView (R.id.current_scorecard_hole_7_card)
    CardView mCurrentScorecardHole_7_Card;
    @BindView (R.id.current_scorecard_hole_7_lenght_text)
    TextView mCurrentScorecardHole_7_Length;
    @BindView (R.id.current_scorecard_hole_7_par_text)
    TextView mCurrentScorecardHole_7_par;
    @BindView (R.id.current_scorecard_hole_7_score_text)
    TextView mCurrentScorecardHole_7_score;
    @BindView (R.id.current_scorecard_hole_7_dif_text)
    TextView mCurrentScorecardHole_7_dif;
    //Hole 8
    @BindView (R.id.current_scorecard_hole_8_card)
    CardView mCurrentScorecardHole_8_Card;
    @BindView (R.id.current_scorecard_hole_8_lenght_text)
    TextView mCurrentScorecardHole_8_Length;
    @BindView (R.id.current_scorecard_hole_8_par_text)
    TextView mCurrentScorecardHole_8_par;
    @BindView (R.id.current_scorecard_hole_8_score_text)
    TextView mCurrentScorecardHole_8_score;
    @BindView (R.id.current_scorecard_hole_8_dif_text)
    TextView mCurrentScorecardHole_8_dif;
    //Hole 9
    @BindView (R.id.current_scorecard_hole_9_card)
    CardView mCurrentScorecardHole_9_Card;
    @BindView (R.id.current_scorecard_hole_9_lenght_text)
    TextView mCurrentScorecardHole_9_Length;
    @BindView (R.id.current_scorecard_hole_9_par_text)
    TextView mCurrentScorecardHole_9_par;
    @BindView (R.id.current_scorecard_hole_9_score_text)
    TextView mCurrentScorecardHole_9_score;
    @BindView (R.id.current_scorecard_hole_9_dif_text)
    TextView mCurrentScorecardHole_9_dif;

    //IN
    //Hole 10
    @BindView (R.id.current_scorecard_hole_10_card)
    CardView mCurrentScorecardHole_10_Card;
    @BindView (R.id.current_scorecard_hole_10_lenght_text)
    TextView mCurrentScorecardHole_10_Length;
    @BindView (R.id.current_scorecard_hole_10_par_text)
    TextView mCurrentScorecardHole_10_par;
    @BindView (R.id.current_scorecard_hole_10_score_text)
    TextView mCurrentScorecardHole_10_score;
    @BindView (R.id.current_scorecard_hole_10_dif_text)
    TextView mCurrentScorecardHole_10_dif;

    //Hole 11
    @BindView (R.id.current_scorecard_hole_11_card)
    CardView mCurrentScorecardHole_11_Card;
    @BindView (R.id.current_scorecard_hole_11_lenght_text)
    TextView mCurrentScorecardHole_11_Length;
    @BindView (R.id.current_scorecard_hole_11_par_text)
    TextView mCurrentScorecardHole_11_par;
    @BindView (R.id.current_scorecard_hole_11_score_text)
    TextView mCurrentScorecardHole_11_score;
    @BindView (R.id.current_scorecard_hole_11_dif_text)
    TextView mCurrentScorecardHole_11_dif;

    //Hole 12
    @BindView (R.id.current_scorecard_hole_12_card)
    CardView mCurrentScorecardHole_12_Card;
    @BindView (R.id.current_scorecard_hole_12_lenght_text)
    TextView mCurrentScorecardHole_12_Length;
    @BindView (R.id.current_scorecard_hole_12_par_text)
    TextView mCurrentScorecardHole_12_par;
    @BindView (R.id.current_scorecard_hole_12_score_text)
    TextView mCurrentScorecardHole_12_score;
    @BindView (R.id.current_scorecard_hole_12_dif_text)
    TextView mCurrentScorecardHole_12_dif;

    //Hole 13
    @BindView (R.id.current_scorecard_hole_13_card)
    CardView mCurrentScorecardHole_13_Card;
    @BindView (R.id.current_scorecard_hole_13_lenght_text)
    TextView mCurrentScorecardHole_13_Length;
    @BindView (R.id.current_scorecard_hole_13_par_text)
    TextView mCurrentScorecardHole_13_par;
    @BindView (R.id.current_scorecard_hole_13_score_text)
    TextView mCurrentScorecardHole_13_score;
    @BindView (R.id.current_scorecard_hole_13_dif_text)
    TextView mCurrentScorecardHole_13_dif;

    //Hole 14
    @BindView (R.id.current_scorecard_hole_14_card)
    CardView mCurrentScorecardHole_14_Card;
    @BindView (R.id.current_scorecard_hole_14_lenght_text)
    TextView mCurrentScorecardHole_14_Length;
    @BindView (R.id.current_scorecard_hole_14_par_text)
    TextView mCurrentScorecardHole_14_par;
    @BindView (R.id.current_scorecard_hole_14_score_text)
    TextView mCurrentScorecardHole_14_score;
    @BindView (R.id.current_scorecard_hole_14_dif_text)
    TextView mCurrentScorecardHole_14_dif;

    //Hole 15
    @BindView (R.id.current_scorecard_hole_15_card)
    CardView mCurrentScorecardHole_15_Card;
    @BindView (R.id.current_scorecard_hole_15_lenght_text)
    TextView mCurrentScorecardHole_15_Length;
    @BindView (R.id.current_scorecard_hole_15_par_text)
    TextView mCurrentScorecardHole_15_par;
    @BindView (R.id.current_scorecard_hole_15_score_text)
    TextView mCurrentScorecardHole_15_score;
    @BindView (R.id.current_scorecard_hole_15_dif_text)
    TextView mCurrentScorecardHole_15_dif;

    //Hole 16
    @BindView (R.id.current_scorecard_hole_16_card)
    CardView mCurrentScorecardHole_16_Card;
    @BindView (R.id.current_scorecard_hole_16_lenght_text)
    TextView mCurrentScorecardHole_16_Length;
    @BindView (R.id.current_scorecard_hole_16_par_text)
    TextView mCurrentScorecardHole_16_par;
    @BindView (R.id.current_scorecard_hole_16_score_text)
    TextView mCurrentScorecardHole_16_score;
    @BindView (R.id.current_scorecard_hole_16_dif_text)
    TextView mCurrentScorecardHole_16_dif;

    //Hole 17
    @BindView (R.id.current_scorecard_hole_17_card)
    CardView mCurrentScorecardHole_17_Card;
    @BindView (R.id.current_scorecard_hole_17_lenght_text)
    TextView mCurrentScorecardHole_17_Length;
    @BindView (R.id.current_scorecard_hole_17_par_text)
    TextView mCurrentScorecardHole_17_par;
    @BindView (R.id.current_scorecard_hole_17_score_text)
    TextView mCurrentScorecardHole_17_score;
    @BindView (R.id.current_scorecard_hole_17_dif_text)
    TextView mCurrentScorecardHole_17_dif;

    //Hole 18
    @BindView (R.id.current_scorecard_hole_18_card)
    CardView mCurrentScorecardHole_18_Card;
    @BindView (R.id.current_scorecard_hole_18_lenght_text)
    TextView mCurrentScorecardHole_18_Length;
    @BindView (R.id.current_scorecard_hole_18_par_text)
    TextView mCurrentScorecardHole_18_par;
    @BindView (R.id.current_scorecard_hole_18_score_text)
    TextView mCurrentScorecardHole_18_score;
    @BindView (R.id.current_scorecard_hole_18_dif_text)
    TextView mCurrentScorecardHole_18_dif;


    //Score
    @BindView (R.id.current_scorecard_score_card)
    CardView mCurrentScorecardScore_Card;

    @BindView (R.id.current_scorecard_out_score_text)
    TextView mCurrentScorecardOutScore;
    @BindView (R.id.current_scorecard_out_dif_text)
    TextView mCurrentScorecardOutDif;

    @BindView (R.id.current_scorecard_in_score_text)
    TextView mCurrentScorecardInScore;
    @BindView (R.id.current_scorecard_in_dif_text)
    TextView mCurrentScorecardInDif;

    @BindView (R.id.current_scorecard_gross_score_text)
    TextView mCurrentScorecardGrossScore;
    @BindView (R.id.current_scorecard_gross_dif_text)
    TextView mCurrentScorecardGrossDif;

    @BindView (R.id.current_scorecard_handicap_text)
    TextView mCurrentScorecardHandicap;

    @BindView (R.id.current_scorecard_net_score_text)
    TextView mCurrentScorecardNetScore;
    @BindView (R.id.current_scorecard_net_dif_text)
    TextView mCurrentScorecardNetDif;



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
                        removeCurrentScorecard();
                        break;

                    case R.id.item_current_scorecard_confirm:
                        if (mCurrentScorecard.confirmCurrentScorecard()){

                            Toast.makeText(getContext(),"Confirm",Toast.LENGTH_LONG).show(); //TODO REMOVE THIS LINE when the save functionallity is finished
                            removeCurrentScorecard();

                        }else {
                            Toast.makeText(getContext(), R.string.current_scorecard_error_save,Toast.LENGTH_LONG).show();

                        }

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
        spec = mTabHost.newTabSpec(TAB_SCORE_SPEC);
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

        String totalPar=ScorecardUtils.getFormattedPar(getContext(),mCurrentScorecard.getGolfFieldTotalPar());
        String outPar=ScorecardUtils.getFormattedPar(getContext(),mCurrentScorecard.getGolfFieldOutPar());
        String inPar=ScorecardUtils.getFormattedPar(getContext(),mCurrentScorecard.getGolfFieldInPar());
        mCurrentScorecardGFTotalPar.setText(totalPar);
        mCurrentScorecardGFOutPar.setText(outPar);
        mCurrentScorecardGFInPar.setText(inPar);

        String date=CalendarUtils.getFormattedDate(mCurrentScorecard.getDate(),getString(R.string.date_format));
        mCurrentScorecardDate.setText(date);

        mCurrentScorecardGeneralCard.setContentDescription(buildGeneralTabContentDescription(golfFieldName,date,totalLength,outLength,inLength,totalPar,outPar,inPar));

        //Out Tab
        setHole(HOLE_1);
        setHole(HOLE_2);
        setHole(HOLE_3);
        setHole(HOLE_4);
        setHole(HOLE_5);
        setHole(HOLE_6);
        setHole(HOLE_7);
        setHole(HOLE_8);
        setHole(HOLE_9);

        //In Tab
        setHole(HOLE_10);
        setHole(HOLE_11);
        setHole(HOLE_12);
        setHole(HOLE_13);
        setHole(HOLE_14);
        setHole(HOLE_15);
        setHole(HOLE_16);
        setHole(HOLE_17);
        setHole(HOLE_18);

        //Score
        String outScore=ScorecardUtils.getFormattedScore(mCurrentScorecard.getOutScore());
        String outDif=ScorecardUtils.getFormattedScoreDif(mCurrentScorecard.getOutDif());
        String inScore=ScorecardUtils.getFormattedScore(mCurrentScorecard.getInScore());
        String inDif=ScorecardUtils.getFormattedScoreDif(mCurrentScorecard.getInDif());
        String grossScore=ScorecardUtils.getFormattedScore(mCurrentScorecard.getGrossScore());
        String grossDif=ScorecardUtils.getFormattedScoreDif(mCurrentScorecard.getGrossDif());
        String handicap=ScorecardUtils.getFormattedHandicap(mCurrentScorecard.getCurrentHandicap());
        String netScore=ScorecardUtils.getFormattedScore(mCurrentScorecard.getNetScore());
        String netDif=ScorecardUtils.getFormattedScoreDif(mCurrentScorecard.getNetDif());

        mCurrentScorecardOutScore.setText(outScore);
        mCurrentScorecardOutDif.setText(outDif);
        mCurrentScorecardInScore.setText(inScore);
        mCurrentScorecardInDif.setText(inDif);
        mCurrentScorecardGrossScore.setText(grossScore);
        mCurrentScorecardGrossDif.setText(grossDif);
        mCurrentScorecardHandicap.setText(handicap);
        mCurrentScorecardNetScore.setText(netScore);
        mCurrentScorecardNetDif.setText(netDif);

        mCurrentScorecardScore_Card.setContentDescription(buildScoreCardContentDescription(
                outScore,
                outDif,
                inScore,
                inDif,
                grossScore,
                grossDif,
                handicap,
                netScore,
                netDif));


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


    private String buildHoleCardContentDescription(String hole, String length, String par, String score, String dif){

        Context context=getContext();

        String description=String.format(context.getString(R.string.current_scorecard_a11y_hole_card),
                hole,
                length,
                par,
                score,
                dif);

        return description;
    }


    private String buildScoreCardContentDescription(String outScore, String outDif, String inScore, String inDif, String grossScore, String grossDif, String handicap, String netScore, String netDif){
        Context context=getContext();
        String description=String.format(context.getString(R.string.current_scorecard_a11y_score_card),
                outScore,
                outDif,
                inScore,
                inDif,
                grossScore,
                grossDif,
                handicap,
                netScore,
                netDif);

        return description;

    }




    private void setScore (Hole.HoleNumber holeNumber){

        Intent setScoreIntent=new Intent(getContext(),CurrentScorecardSetScoreActivity.class);
        setScoreIntent.putExtra(CurrentScorecardSetScoreActivity.HOLE_NUMBER_PARAMETER_KEY,holeNumber.getValue());
        startActivity(setScoreIntent);

    }



    private void setHole(final Hole.HoleNumber hole){

        String holeNumber=ScorecardUtils.getFormattedHoleNumber(getContext(), hole);
        String holeLength= ScorecardUtils.getFormattedLength(getContext(),mCurrentScorecard.getHoleLength(hole));
        String holePar= ScorecardUtils.getFormattedPar(getContext(),mCurrentScorecard.getHolePar(hole).getValue());
        String holeScore= ScorecardUtils.getFormattedScore(mCurrentScorecard.getHoleScore(hole));
        String holeScore_dif= ScorecardUtils.getFormattedScoreDif(mCurrentScorecard.getHoleScoreDif(hole));

        switch (hole){
            case HOLE_1:
                mCurrentScorecardHole_1_Length.setText(holeLength);
                mCurrentScorecardHole_1_par.setText(holePar);
                mCurrentScorecardHole_1_score.setText(holeScore);
                mCurrentScorecardHole_1_dif.setText(holeScore_dif);

                mCurrentScorecardHole_1_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_1_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_2:
                mCurrentScorecardHole_2_Length.setText(holeLength);
                mCurrentScorecardHole_2_par.setText(holePar);
                mCurrentScorecardHole_2_score.setText(holeScore);
                mCurrentScorecardHole_2_dif.setText(holeScore_dif);

                mCurrentScorecardHole_2_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_2_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
              break;

            case HOLE_3:
                mCurrentScorecardHole_3_Length.setText(holeLength);
                mCurrentScorecardHole_3_par.setText(holePar);
                mCurrentScorecardHole_3_score.setText(holeScore);
                mCurrentScorecardHole_3_dif.setText(holeScore_dif);

                mCurrentScorecardHole_3_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_3_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;
            case HOLE_4:
                mCurrentScorecardHole_4_Length.setText(holeLength);
                mCurrentScorecardHole_4_par.setText(holePar);
                mCurrentScorecardHole_4_score.setText(holeScore);
                mCurrentScorecardHole_4_dif.setText(holeScore_dif);

                mCurrentScorecardHole_4_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_4_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_5:
                mCurrentScorecardHole_5_Length.setText(holeLength);
                mCurrentScorecardHole_5_par.setText(holePar);
                mCurrentScorecardHole_5_score.setText(holeScore);
                mCurrentScorecardHole_5_dif.setText(holeScore_dif);

                mCurrentScorecardHole_5_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_5_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_6:
                mCurrentScorecardHole_6_Length.setText(holeLength);
                mCurrentScorecardHole_6_par.setText(holePar);
                mCurrentScorecardHole_6_score.setText(holeScore);
                mCurrentScorecardHole_6_dif.setText(holeScore_dif);

                mCurrentScorecardHole_6_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_6_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_7:
                mCurrentScorecardHole_7_Length.setText(holeLength);
                mCurrentScorecardHole_7_par.setText(holePar);
                mCurrentScorecardHole_7_score.setText(holeScore);
                mCurrentScorecardHole_7_dif.setText(holeScore_dif);

                mCurrentScorecardHole_7_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_7_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_8:
                mCurrentScorecardHole_8_Length.setText(holeLength);
                mCurrentScorecardHole_8_par.setText(holePar);
                mCurrentScorecardHole_8_score.setText(holeScore);
                mCurrentScorecardHole_8_dif.setText(holeScore_dif);

                mCurrentScorecardHole_8_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_8_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_9:
                mCurrentScorecardHole_9_Length.setText(holeLength);
                mCurrentScorecardHole_9_par.setText(holePar);
                mCurrentScorecardHole_9_score.setText(holeScore);
                mCurrentScorecardHole_9_dif.setText(holeScore_dif);

                mCurrentScorecardHole_9_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_9_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_10:
                mCurrentScorecardHole_10_Length.setText(holeLength);
                mCurrentScorecardHole_10_par.setText(holePar);
                mCurrentScorecardHole_10_score.setText(holeScore);
                mCurrentScorecardHole_10_dif.setText(holeScore_dif);

                mCurrentScorecardHole_10_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_10_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;
            case HOLE_11:
                mCurrentScorecardHole_11_Length.setText(holeLength);
                mCurrentScorecardHole_11_par.setText(holePar);
                mCurrentScorecardHole_11_score.setText(holeScore);
                mCurrentScorecardHole_11_dif.setText(holeScore_dif);

                mCurrentScorecardHole_11_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_11_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_12:
                mCurrentScorecardHole_12_Length.setText(holeLength);
                mCurrentScorecardHole_12_par.setText(holePar);
                mCurrentScorecardHole_12_score.setText(holeScore);
                mCurrentScorecardHole_12_dif.setText(holeScore_dif);

                mCurrentScorecardHole_12_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_12_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_13:
                mCurrentScorecardHole_13_Length.setText(holeLength);
                mCurrentScorecardHole_13_par.setText(holePar);
                mCurrentScorecardHole_13_score.setText(holeScore);
                mCurrentScorecardHole_13_dif.setText(holeScore_dif);

                mCurrentScorecardHole_13_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_13_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_14:
                mCurrentScorecardHole_14_Length.setText(holeLength);
                mCurrentScorecardHole_14_par.setText(holePar);
                mCurrentScorecardHole_14_score.setText(holeScore);
                mCurrentScorecardHole_14_dif.setText(holeScore_dif);

                mCurrentScorecardHole_14_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_14_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_15:
                mCurrentScorecardHole_15_Length.setText(holeLength);
                mCurrentScorecardHole_15_par.setText(holePar);
                mCurrentScorecardHole_15_score.setText(holeScore);
                mCurrentScorecardHole_15_dif.setText(holeScore_dif);

                mCurrentScorecardHole_15_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_15_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_16:
                mCurrentScorecardHole_16_Length.setText(holeLength);
                mCurrentScorecardHole_16_par.setText(holePar);
                mCurrentScorecardHole_16_score.setText(holeScore);
                mCurrentScorecardHole_16_dif.setText(holeScore_dif);

                mCurrentScorecardHole_16_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_16_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_17:
                mCurrentScorecardHole_17_Length.setText(holeLength);
                mCurrentScorecardHole_17_par.setText(holePar);
                mCurrentScorecardHole_17_score.setText(holeScore);
                mCurrentScorecardHole_17_dif.setText(holeScore_dif);

                mCurrentScorecardHole_17_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_17_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;

            case HOLE_18:
                mCurrentScorecardHole_18_Length.setText(holeLength);
                mCurrentScorecardHole_18_par.setText(holePar);
                mCurrentScorecardHole_18_score.setText(holeScore);
                mCurrentScorecardHole_18_dif.setText(holeScore_dif);

                mCurrentScorecardHole_18_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                mCurrentScorecardHole_18_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScore(hole);
                    }
                });
                break;


            default:
                break;
        }

     }



     private void removeCurrentScorecard(){

         mCurrentScorecard.deleteCurrentScorecard();
         ScorecardUtils.RemoveKeyFromSharedPreferences(getContext(),CURRENT_SCORE_CARD_SELECTED_TAB_LABEL);
         mCurrentScorecardInterface.setDefaultMenuItem();

     }



     //Interface to return a value to the main activity
    public void setCurrentScorecardInterface(MainActivity.CurrentScorecardInterface mInterface) {
        this.mCurrentScorecardInterface = mInterface;
    }
}
