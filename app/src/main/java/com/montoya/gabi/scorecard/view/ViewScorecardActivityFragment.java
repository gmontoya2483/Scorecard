package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.Scorecard;
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
 * A placeholder fragment containing a simple view.
 */
public class ViewScorecardActivityFragment extends Fragment {


    View mRootView;
    Scorecard mScorecard;

    //bundle information
    public static final String SCORECARD_ID_LABEL="scorecard_id_label";
    private long mScorecard_id;

    private final String TAB_GENERAL_SPEC="general_tab";
    private final String TAB_OUT_SPEC="out_tab";
    private final String TAB_IN_SPEC="in_tab";
    private final String TAB_SCORE_SPEC="score_tab";

    private  final String VIEW_SCORE_CARD_SELECTED_TAB_LABEL="view_scorecard_tab";
    private final int VIEW_SCORE_NOT_SELECTED_TAB_LABEL=0;



    //General
    @BindView(R.id.tabHost_scorecard)
    TabHost mTabHost;
   
    //General tab

    @BindView(R.id.view_scorecard_general_card)
    CardView mViewScorecardGeneralCard;

    @BindView(R.id.view_scorecard_gf_name_text)
    TextView mViewScorecardGFName;

    @BindView(R.id.view_scorecard_date_text)
    TextView mViewScorecardDate;


    @BindView(R.id.view_scorecard_total_length_text)
    TextView mViewScorecardGFTotalLength;

    @BindView(R.id.view_scorecard_total_par_text)
    TextView mViewScorecardGFTotalPar;

    @BindView(R.id.view_scorecard_out_length_text)
    TextView mViewScorecardGFOutLength;

    @BindView(R.id.view_scorecard_out_par_text)
    TextView mViewScorecardGFOutPar;


    @BindView(R.id.view_scorecard_in_length_text)
    TextView mViewScorecardGFInLength;

    @BindView(R.id.view_scorecard_in_par_text)
    TextView mViewScorecardGFInPar;

    //OUT
    //Hole 1
    @BindView (R.id.view_scorecard_hole_1_card)
    CardView mViewScorecardHole_1_Card;
    @BindView (R.id.view_scorecard_hole_1_lenght_text)
    TextView mViewScorecardHole_1_Length;
    @BindView (R.id.view_scorecard_hole_1_par_text)
    TextView mViewScorecardHole_1_par;
    @BindView (R.id.view_scorecard_hole_1_score_text)
    TextView mViewScorecardHole_1_score;
    @BindView (R.id.view_scorecard_hole_1_dif_text)
    TextView mViewScorecardHole_1_dif;
    //Hole 2
    @BindView (R.id.view_scorecard_hole_2_card)
    CardView mViewScorecardHole_2_Card;
    @BindView (R.id.view_scorecard_hole_2_lenght_text)
    TextView mViewScorecardHole_2_Length;
    @BindView (R.id.view_scorecard_hole_2_par_text)
    TextView mViewScorecardHole_2_par;
    @BindView (R.id.view_scorecard_hole_2_score_text)
    TextView mViewScorecardHole_2_score;
    @BindView (R.id.view_scorecard_hole_2_dif_text)
    TextView mViewScorecardHole_2_dif;
    //Hole 3
    @BindView (R.id.view_scorecard_hole_3_card)
    CardView mViewScorecardHole_3_Card;
    @BindView (R.id.view_scorecard_hole_3_lenght_text)
    TextView mViewScorecardHole_3_Length;
    @BindView (R.id.view_scorecard_hole_3_par_text)
    TextView mViewScorecardHole_3_par;
    @BindView (R.id.view_scorecard_hole_3_score_text)
    TextView mViewScorecardHole_3_score;
    @BindView (R.id.view_scorecard_hole_3_dif_text)
    TextView mViewScorecardHole_3_dif;
    //Hole 4
    @BindView (R.id.view_scorecard_hole_4_card)
    CardView mViewScorecardHole_4_Card;
    @BindView (R.id.view_scorecard_hole_4_lenght_text)
    TextView mViewScorecardHole_4_Length;
    @BindView (R.id.view_scorecard_hole_4_par_text)
    TextView mViewScorecardHole_4_par;
    @BindView (R.id.view_scorecard_hole_4_score_text)
    TextView mViewScorecardHole_4_score;
    @BindView (R.id.view_scorecard_hole_4_dif_text)
    TextView mViewScorecardHole_4_dif;
    //Hole 5
    @BindView (R.id.view_scorecard_hole_5_card)
    CardView mViewScorecardHole_5_Card;
    @BindView (R.id.view_scorecard_hole_5_lenght_text)
    TextView mViewScorecardHole_5_Length;
    @BindView (R.id.view_scorecard_hole_5_par_text)
    TextView mViewScorecardHole_5_par;
    @BindView (R.id.view_scorecard_hole_5_score_text)
    TextView mViewScorecardHole_5_score;
    @BindView (R.id.view_scorecard_hole_5_dif_text)
    TextView mViewScorecardHole_5_dif;
    //Hole 6
    @BindView (R.id.view_scorecard_hole_6_card)
    CardView mViewScorecardHole_6_Card;
    @BindView (R.id.view_scorecard_hole_6_lenght_text)
    TextView mViewScorecardHole_6_Length;
    @BindView (R.id.view_scorecard_hole_6_par_text)
    TextView mViewScorecardHole_6_par;
    @BindView (R.id.view_scorecard_hole_6_score_text)
    TextView mViewScorecardHole_6_score;
    @BindView (R.id.view_scorecard_hole_6_dif_text)
    TextView mViewScorecardHole_6_dif;
    //Hole 7
    @BindView (R.id.view_scorecard_hole_7_card)
    CardView mViewScorecardHole_7_Card;
    @BindView (R.id.view_scorecard_hole_7_lenght_text)
    TextView mViewScorecardHole_7_Length;
    @BindView (R.id.view_scorecard_hole_7_par_text)
    TextView mViewScorecardHole_7_par;
    @BindView (R.id.view_scorecard_hole_7_score_text)
    TextView mViewScorecardHole_7_score;
    @BindView (R.id.view_scorecard_hole_7_dif_text)
    TextView mViewScorecardHole_7_dif;
    //Hole 8
    @BindView (R.id.view_scorecard_hole_8_card)
    CardView mViewScorecardHole_8_Card;
    @BindView (R.id.view_scorecard_hole_8_lenght_text)
    TextView mViewScorecardHole_8_Length;
    @BindView (R.id.view_scorecard_hole_8_par_text)
    TextView mViewScorecardHole_8_par;
    @BindView (R.id.view_scorecard_hole_8_score_text)
    TextView mViewScorecardHole_8_score;
    @BindView (R.id.view_scorecard_hole_8_dif_text)
    TextView mViewScorecardHole_8_dif;
    //Hole 9
    @BindView (R.id.view_scorecard_hole_9_card)
    CardView mViewScorecardHole_9_Card;
    @BindView (R.id.view_scorecard_hole_9_lenght_text)
    TextView mViewScorecardHole_9_Length;
    @BindView (R.id.view_scorecard_hole_9_par_text)
    TextView mViewScorecardHole_9_par;
    @BindView (R.id.view_scorecard_hole_9_score_text)
    TextView mViewScorecardHole_9_score;
    @BindView (R.id.view_scorecard_hole_9_dif_text)
    TextView mViewScorecardHole_9_dif;

    //IN
    //Hole 10
    @BindView (R.id.view_scorecard_hole_10_card)
    CardView mViewScorecardHole_10_Card;
    @BindView (R.id.view_scorecard_hole_10_lenght_text)
    TextView mViewScorecardHole_10_Length;
    @BindView (R.id.view_scorecard_hole_10_par_text)
    TextView mViewScorecardHole_10_par;
    @BindView (R.id.view_scorecard_hole_10_score_text)
    TextView mViewScorecardHole_10_score;
    @BindView (R.id.view_scorecard_hole_10_dif_text)
    TextView mViewScorecardHole_10_dif;

    //Hole 11
    @BindView (R.id.view_scorecard_hole_11_card)
    CardView mViewScorecardHole_11_Card;
    @BindView (R.id.view_scorecard_hole_11_lenght_text)
    TextView mViewScorecardHole_11_Length;
    @BindView (R.id.view_scorecard_hole_11_par_text)
    TextView mViewScorecardHole_11_par;
    @BindView (R.id.view_scorecard_hole_11_score_text)
    TextView mViewScorecardHole_11_score;
    @BindView (R.id.view_scorecard_hole_11_dif_text)
    TextView mViewScorecardHole_11_dif;

    //Hole 12
    @BindView (R.id.view_scorecard_hole_12_card)
    CardView mViewScorecardHole_12_Card;
    @BindView (R.id.view_scorecard_hole_12_lenght_text)
    TextView mViewScorecardHole_12_Length;
    @BindView (R.id.view_scorecard_hole_12_par_text)
    TextView mViewScorecardHole_12_par;
    @BindView (R.id.view_scorecard_hole_12_score_text)
    TextView mViewScorecardHole_12_score;
    @BindView (R.id.view_scorecard_hole_12_dif_text)
    TextView mViewScorecardHole_12_dif;

    //Hole 13
    @BindView (R.id.view_scorecard_hole_13_card)
    CardView mViewScorecardHole_13_Card;
    @BindView (R.id.view_scorecard_hole_13_lenght_text)
    TextView mViewScorecardHole_13_Length;
    @BindView (R.id.view_scorecard_hole_13_par_text)
    TextView mViewScorecardHole_13_par;
    @BindView (R.id.view_scorecard_hole_13_score_text)
    TextView mViewScorecardHole_13_score;
    @BindView (R.id.view_scorecard_hole_13_dif_text)
    TextView mViewScorecardHole_13_dif;

    //Hole 14
    @BindView (R.id.view_scorecard_hole_14_card)
    CardView mViewScorecardHole_14_Card;
    @BindView (R.id.view_scorecard_hole_14_lenght_text)
    TextView mViewScorecardHole_14_Length;
    @BindView (R.id.view_scorecard_hole_14_par_text)
    TextView mViewScorecardHole_14_par;
    @BindView (R.id.view_scorecard_hole_14_score_text)
    TextView mViewScorecardHole_14_score;
    @BindView (R.id.view_scorecard_hole_14_dif_text)
    TextView mViewScorecardHole_14_dif;

    //Hole 15
    @BindView (R.id.view_scorecard_hole_15_card)
    CardView mViewScorecardHole_15_Card;
    @BindView (R.id.view_scorecard_hole_15_lenght_text)
    TextView mViewScorecardHole_15_Length;
    @BindView (R.id.view_scorecard_hole_15_par_text)
    TextView mViewScorecardHole_15_par;
    @BindView (R.id.view_scorecard_hole_15_score_text)
    TextView mViewScorecardHole_15_score;
    @BindView (R.id.view_scorecard_hole_15_dif_text)
    TextView mViewScorecardHole_15_dif;

    //Hole 16
    @BindView (R.id.view_scorecard_hole_16_card)
    CardView mViewScorecardHole_16_Card;
    @BindView (R.id.view_scorecard_hole_16_lenght_text)
    TextView mViewScorecardHole_16_Length;
    @BindView (R.id.view_scorecard_hole_16_par_text)
    TextView mViewScorecardHole_16_par;
    @BindView (R.id.view_scorecard_hole_16_score_text)
    TextView mViewScorecardHole_16_score;
    @BindView (R.id.view_scorecard_hole_16_dif_text)
    TextView mViewScorecardHole_16_dif;

    //Hole 17
    @BindView (R.id.view_scorecard_hole_17_card)
    CardView mViewScorecardHole_17_Card;
    @BindView (R.id.view_scorecard_hole_17_lenght_text)
    TextView mViewScorecardHole_17_Length;
    @BindView (R.id.view_scorecard_hole_17_par_text)
    TextView mViewScorecardHole_17_par;
    @BindView (R.id.view_scorecard_hole_17_score_text)
    TextView mViewScorecardHole_17_score;
    @BindView (R.id.view_scorecard_hole_17_dif_text)
    TextView mViewScorecardHole_17_dif;

    //Hole 18
    @BindView (R.id.view_scorecard_hole_18_card)
    CardView mViewScorecardHole_18_Card;
    @BindView (R.id.view_scorecard_hole_18_lenght_text)
    TextView mViewScorecardHole_18_Length;
    @BindView (R.id.view_scorecard_hole_18_par_text)
    TextView mViewScorecardHole_18_par;
    @BindView (R.id.view_scorecard_hole_18_score_text)
    TextView mViewScorecardHole_18_score;
    @BindView (R.id.view_scorecard_hole_18_dif_text)
    TextView mViewScorecardHole_18_dif;


    //Score
    @BindView (R.id.view_scorecard_score_card)
    CardView mViewScorecardScore_Card;

    @BindView (R.id.view_scorecard_out_score_text)
    TextView mViewScorecardOutScore;
    @BindView (R.id.view_scorecard_out_dif_text)
    TextView mViewScorecardOutDif;

    @BindView (R.id.view_scorecard_in_score_text)
    TextView mViewScorecardInScore;
    @BindView (R.id.view_scorecard_in_dif_text)
    TextView mViewScorecardInDif;

    @BindView (R.id.view_scorecard_gross_score_text)
    TextView mViewScorecardGrossScore;
    @BindView (R.id.view_scorecard_gross_dif_text)
    TextView mViewScorecardGrossDif;

    @BindView (R.id.view_scorecard_handicap_text)
    TextView mViewScorecardHandicap;

    @BindView (R.id.view_scorecard_net_score_text)
    TextView mViewScorecardNetScore;
    @BindView (R.id.view_scorecard_net_dif_text)
    TextView mViewScorecardNetDif;
    
    
    
    
    


    public ViewScorecardActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView= inflater.inflate(R.layout.view_scorecard_fragment, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        retrieveArguments();

        createNavigationTabs();

        setupFragment();


        return mRootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ScorecardUtils.AddIntToSharedPreferences(getContext(),VIEW_SCORE_CARD_SELECTED_TAB_LABEL,mTabHost.getCurrentTab());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mTabHost.setCurrentTab(ScorecardUtils.RetrieveIntFromSharedPreferences(getContext(),VIEW_SCORE_CARD_SELECTED_TAB_LABEL,VIEW_SCORE_NOT_SELECTED_TAB_LABEL));
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


    private void createNavigationTabs(){

        mTabHost.setup();

        //Tab 1
        TabHost.TabSpec spec = mTabHost.newTabSpec(TAB_GENERAL_SPEC);
        spec.setContent(R.id.tab_view_scorecard_general);
        spec.setIndicator(getString(R.string.tab_general));
        mTabHost.addTab(spec);

        //Tab 2
        spec = mTabHost.newTabSpec(TAB_OUT_SPEC);
        spec.setContent(R.id.tab_view_scorecard_out);
        spec.setIndicator(getString(R.string.tab_out));
        mTabHost.addTab(spec);

        //Tab 3
        spec = mTabHost.newTabSpec(TAB_IN_SPEC);
        spec.setContent(R.id.tab_view_scorecard_in);
        spec.setIndicator(getString(R.string.tab_in));
        mTabHost.addTab(spec);

        //Tab 4
        spec = mTabHost.newTabSpec(TAB_SCORE_SPEC);
        spec.setContent(R.id.tab_view_scorecard_score);
        spec.setIndicator(getString(R.string.tab_score));
        mTabHost.addTab(spec);

        mTabHost.setCurrentTab(VIEW_SCORE_NOT_SELECTED_TAB_LABEL);

    }
    
    
    
    private void setupFragment(){
        
        mScorecard=new Scorecard(getContext(),mScorecard_id);

        //General Tab
        String golfFieldName=mScorecard.getGolfFieldName();
        String totalLength= ScorecardUtils.getFormattedLength(getContext(),mScorecard.getGolfFieldTotalLength());
        String outLength=ScorecardUtils.getFormattedLength(getContext(),mScorecard.getGolfFieldOutLength());
        String inLength=ScorecardUtils.getFormattedLength(getContext(),mScorecard.getGolfFieldInLength());
        String totalPar=ScorecardUtils.getFormattedPar(getContext(),mScorecard.getGolfFieldTotalPar());
        String outPar=ScorecardUtils.getFormattedPar(getContext(),mScorecard.getGolfFieldOutPar());
        String inPar=ScorecardUtils.getFormattedPar(getContext(),mScorecard.getGolfFieldInPar());
        String date=CalendarUtils.getFormattedDate(mScorecard.getDate(),getString(R.string.date_format));

        mViewScorecardGFName.setText(golfFieldName);
        mViewScorecardGFTotalLength.setText(totalLength);
        mViewScorecardGFOutLength.setText(outLength);
        mViewScorecardGFInLength.setText(inLength);
        mViewScorecardGFOutPar.setText(outPar);
        mViewScorecardGFInPar.setText(inPar);
        mViewScorecardDate.setText(date);

        mViewScorecardGeneralCard.setContentDescription(buildGeneralTabContentDescription(golfFieldName,date,totalLength,outLength,inLength,totalPar,outPar,inPar));


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


        //Score Tab
        String outScore=ScorecardUtils.getFormattedScore(mScorecard.getOutScore());
        String outDif=ScorecardUtils.getFormattedScoreDif(mScorecard.getOutDif());
        String inScore=ScorecardUtils.getFormattedScore(mScorecard.getInScore());
        String inDif=ScorecardUtils.getFormattedScoreDif(mScorecard.getInDif());
        String grossScore=ScorecardUtils.getFormattedScore(mScorecard.getGrossScore());
        String grossDif=ScorecardUtils.getFormattedScoreDif(mScorecard.getGrossDif());
        String handicap=ScorecardUtils.getFormattedHandicap(mScorecard.getHandicap());
        String netScore=ScorecardUtils.getFormattedScore(mScorecard.getNetScore());
        String netDif=ScorecardUtils.getFormattedScoreDif(mScorecard.getNetDif());

        mViewScorecardOutScore.setText(outScore);
        mViewScorecardOutDif.setText(outDif);
        mViewScorecardInScore.setText(inScore);
        mViewScorecardInDif.setText(inDif);
        mViewScorecardGrossScore.setText(grossScore);
        mViewScorecardGrossDif.setText(grossDif);
        mViewScorecardHandicap.setText(handicap);
        mViewScorecardNetScore.setText(netScore);
        mViewScorecardNetDif.setText(netDif);

        mViewScorecardScore_Card.setContentDescription(buildScoreCardContentDescription(
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


    private void setHole(final Hole.HoleNumber hole){

        String holeNumber=ScorecardUtils.getFormattedHoleNumber(getContext(), hole);
        String holeLength= ScorecardUtils.getFormattedLength(getContext(),mScorecard.getHole(hole).getLength());
        String holePar= ScorecardUtils.getFormattedPar(getContext(),mScorecard.getHole(hole).getPar().getValue());
        String holeScore= ScorecardUtils.getFormattedScore(mScorecard.getHole(hole).getScore());
        String holeScore_dif= ScorecardUtils.getFormattedScoreDif(mScorecard.getHole(hole).getDif());

        switch (hole){
            case HOLE_1:
                mViewScorecardHole_1_Length.setText(holeLength);
                mViewScorecardHole_1_par.setText(holePar);
                mViewScorecardHole_1_score.setText(holeScore);
                mViewScorecardHole_1_dif.setText(holeScore_dif);

                mViewScorecardHole_1_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_2:
                mViewScorecardHole_2_Length.setText(holeLength);
                mViewScorecardHole_2_par.setText(holePar);
                mViewScorecardHole_2_score.setText(holeScore);
                mViewScorecardHole_2_dif.setText(holeScore_dif);

                mViewScorecardHole_2_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_3:
                mViewScorecardHole_3_Length.setText(holeLength);
                mViewScorecardHole_3_par.setText(holePar);
                mViewScorecardHole_3_score.setText(holeScore);
                mViewScorecardHole_3_dif.setText(holeScore_dif);

                mViewScorecardHole_3_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_4:
                mViewScorecardHole_4_Length.setText(holeLength);
                mViewScorecardHole_4_par.setText(holePar);
                mViewScorecardHole_4_score.setText(holeScore);
                mViewScorecardHole_4_dif.setText(holeScore_dif);

                mViewScorecardHole_4_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_5:
                mViewScorecardHole_5_Length.setText(holeLength);
                mViewScorecardHole_5_par.setText(holePar);
                mViewScorecardHole_5_score.setText(holeScore);
                mViewScorecardHole_5_dif.setText(holeScore_dif);

                mViewScorecardHole_5_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_6:
                mViewScorecardHole_6_Length.setText(holeLength);
                mViewScorecardHole_6_par.setText(holePar);
                mViewScorecardHole_6_score.setText(holeScore);
                mViewScorecardHole_6_dif.setText(holeScore_dif);

                mViewScorecardHole_6_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_7:
                mViewScorecardHole_7_Length.setText(holeLength);
                mViewScorecardHole_7_par.setText(holePar);
                mViewScorecardHole_7_score.setText(holeScore);
                mViewScorecardHole_7_dif.setText(holeScore_dif);

                mViewScorecardHole_7_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_8:
                mViewScorecardHole_8_Length.setText(holeLength);
                mViewScorecardHole_8_par.setText(holePar);
                mViewScorecardHole_8_score.setText(holeScore);
                mViewScorecardHole_8_dif.setText(holeScore_dif);

                mViewScorecardHole_8_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_9:
                mViewScorecardHole_9_Length.setText(holeLength);
                mViewScorecardHole_9_par.setText(holePar);
                mViewScorecardHole_9_score.setText(holeScore);
                mViewScorecardHole_9_dif.setText(holeScore_dif);

                mViewScorecardHole_9_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_10:
                mViewScorecardHole_10_Length.setText(holeLength);
                mViewScorecardHole_10_par.setText(holePar);
                mViewScorecardHole_10_score.setText(holeScore);
                mViewScorecardHole_10_dif.setText(holeScore_dif);

                mViewScorecardHole_10_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_11:
                mViewScorecardHole_11_Length.setText(holeLength);
                mViewScorecardHole_11_par.setText(holePar);
                mViewScorecardHole_11_score.setText(holeScore);
                mViewScorecardHole_11_dif.setText(holeScore_dif);

                mViewScorecardHole_11_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_12:
                mViewScorecardHole_12_Length.setText(holeLength);
                mViewScorecardHole_12_par.setText(holePar);
                mViewScorecardHole_12_score.setText(holeScore);
                mViewScorecardHole_12_dif.setText(holeScore_dif);

                mViewScorecardHole_12_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_13:
                mViewScorecardHole_13_Length.setText(holeLength);
                mViewScorecardHole_13_par.setText(holePar);
                mViewScorecardHole_13_score.setText(holeScore);
                mViewScorecardHole_13_dif.setText(holeScore_dif);

                mViewScorecardHole_13_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_14:
                mViewScorecardHole_14_Length.setText(holeLength);
                mViewScorecardHole_14_par.setText(holePar);
                mViewScorecardHole_14_score.setText(holeScore);
                mViewScorecardHole_14_dif.setText(holeScore_dif);

                mViewScorecardHole_14_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_15:
                mViewScorecardHole_15_Length.setText(holeLength);
                mViewScorecardHole_15_par.setText(holePar);
                mViewScorecardHole_15_score.setText(holeScore);
                mViewScorecardHole_15_dif.setText(holeScore_dif);

                mViewScorecardHole_15_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_16:
                mViewScorecardHole_16_Length.setText(holeLength);
                mViewScorecardHole_16_par.setText(holePar);
                mViewScorecardHole_16_score.setText(holeScore);
                mViewScorecardHole_16_dif.setText(holeScore_dif);

                mViewScorecardHole_16_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_17:
                mViewScorecardHole_17_Length.setText(holeLength);
                mViewScorecardHole_17_par.setText(holePar);
                mViewScorecardHole_17_score.setText(holeScore);
                mViewScorecardHole_17_dif.setText(holeScore_dif);

                mViewScorecardHole_17_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;

            case HOLE_18:
                mViewScorecardHole_18_Length.setText(holeLength);
                mViewScorecardHole_18_par.setText(holePar);
                mViewScorecardHole_18_score.setText(holeScore);
                mViewScorecardHole_18_dif.setText(holeScore_dif);

                mViewScorecardHole_18_Card.setContentDescription(buildHoleCardContentDescription(
                        holeNumber,
                        holeLength,
                        holePar,
                        holeScore,
                        holeScore_dif));

                break;


            default:
                break;
        }

    }
    


}
