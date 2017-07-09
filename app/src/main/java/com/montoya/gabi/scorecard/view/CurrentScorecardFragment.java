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
    //Hole 2
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


            default:
                break;
        }

     }






}
