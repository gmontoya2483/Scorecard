package com.montoya.gabi.scorecard.view;

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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.firebase.AdMobListener;
import com.montoya.gabi.scorecard.model.CurrentScorecard;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.Player;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.montoya.gabi.scorecard.MainActivity.SELECTED_MENU_ITEM_LABEL;
import static com.montoya.gabi.scorecard.R.id.item_golf_field_edit_save;
import static com.montoya.gabi.scorecard.R.id.item_view_golf_field_edit;
import static com.montoya.gabi.scorecard.R.id.item_view_golf_field_new_scorecard;

/**
 * A placeholder fragment containing a simple view.
 */
public class ViewGolfFieldActivityFragment extends Fragment {

    public static String CURRENT_MODE_KEY="current_mode";
    public static String CURRENT_MODE_EDIT="mode_edit";
    public static String CURRENT_MODE_VIEW="mode_view";


    View mRootView;
    GolfField mViewGolfField;
    GolfField mEditGolfField;



    //bundle information
    public static final String GOLF_FIELD_ID_LABEL="golf_field_id_label";
    private long mGolfField_id;



    private final String TAB_GENERAL_SPEC="general_tab";
    private final String TAB_OUT_SPEC="out_tab";
    private final String TAB_IN_SPEC="in_tab";

    private final String SELECTED_TAB_LABEL="selected_tab";


    //Add the add for the new scorecard
    private InterstitialAd mInterstitial;
    private boolean mAdError=false;
    private boolean mAdLoaded=false;




    //Bind Views
    @BindView(R.id.tabHost_golf_field)
    TabHost mTabHost;

    //Bind general information

    //Card golf_field_card_name
    @BindView(R.id.golf_field_card_name)
    CardView mGolfFieldNameCardView;

    //Golf Field Name
    @BindView(R.id.golf_field_name)
    EditText mGolfFieldNameEditTextView;

    //Card golf_field_card_resume
    @BindView(R.id.golf_field_card_resume)
    CardView mGolfFieldResumeCardView;

    //Image view golf_field_favorite
    @BindView (R.id.golf_field_favorite)
    ImageView mGolfFieldFavoriteImageView;

    //Text View Total length
    @BindView(R.id.golf_field_total_length)
    TextView mGolfFieldTotalLengthTextView;

    //Text View Total par
    @BindView(R.id.golf_field_total_par)
    TextView mGolfFieldTotalParTextView;

    //Text View out length
    @BindView(R.id.golf_field_out_length)
    TextView mGolfFieldOutLengthTextView;

    //Text View out par
    @BindView(R.id.golf_field_out_par)
    TextView mGolfFieldOutParTextView;

    //Text View in length
    @BindView(R.id.golf_field_in_length)
    TextView mGolfFieldInLengthTextView;

    //Text View in par
    @BindView(R.id.golf_field_in_par)
    TextView mGolfFieldInParTextView;



    //Bind out information
    //Hole 1
    @BindView(R.id.golf_field_hole_1_par)
    Spinner mHole1ParSpinner;

    @BindView(R.id.golf_field_hole_1_length)
    EditText mHole1LengthEditTextView;

    @BindView(R.id.golf_field_hole_1_length_unit)
    TextView mHole1LengthUnit;

    //Hole 2
    @BindView(R.id.golf_field_hole_2_par)
    Spinner mHole2ParSpinner;

    @BindView(R.id.golf_field_hole_2_length)
    EditText mHole2LengthEditTextView;

    @BindView(R.id.golf_field_hole_2_length_unit)
    TextView mHole2LengthUnit;

    //Hole 3
    @BindView(R.id.golf_field_hole_3_par)
    Spinner mHole3ParSpinner;

    @BindView(R.id.golf_field_hole_3_length_unit)
    TextView mHole3LengthUnit;

    @BindView(R.id.golf_field_hole_3_length)
    EditText mHole3LengthEditTextView;

    //Hole 4
    @BindView(R.id.golf_field_hole_4_par)
    Spinner mHole4ParSpinner;

    @BindView(R.id.golf_field_hole_4_length)
    EditText mHole4LengthEditTextView;

    @BindView(R.id.golf_field_hole_4_length_unit)
    TextView mHole4LengthUnit;

    //Hole 5
    @BindView(R.id.golf_field_hole_5_par)
    Spinner mHole5ParSpinner;

    @BindView(R.id.golf_field_hole_5_length)
    EditText mHole5LengthEditTextView;

    @BindView(R.id.golf_field_hole_5_length_unit)
    TextView mHole5LengthUnit;

    //Hole 6
    @BindView(R.id.golf_field_hole_6_par)
    Spinner mHole6ParSpinner;

    @BindView(R.id.golf_field_hole_6_length)
    EditText mHole6LengthEditTextView;

    @BindView(R.id.golf_field_hole_6_length_unit)
    TextView mHole6LengthUnit;

    //Hole 7
    @BindView(R.id.golf_field_hole_7_par)
    Spinner mHole7ParSpinner;

    @BindView(R.id.golf_field_hole_7_length)
    EditText mHole7LengthEditTextView;

    @BindView(R.id.golf_field_hole_7_length_unit)
    TextView mHole7LengthUnit;

    //Hole 8
    @BindView(R.id.golf_field_hole_8_par)
    Spinner mHole8ParSpinner;

    @BindView(R.id.golf_field_hole_8_length)
    EditText mHole8LengthEditTextView;

    @BindView(R.id.golf_field_hole_8_length_unit)
    TextView mHole8LengthUnit;

    //Hole 9
    @BindView(R.id.golf_field_hole_9_par)
    Spinner mHole9ParSpinner;

    @BindView(R.id.golf_field_hole_9_length)
    EditText mHole9LengthEditTextView;

    @BindView(R.id.golf_field_hole_9_length_unit)
    TextView mHole9LengthUnit;


    //Bind in Information
    //Hole 10
    @BindView(R.id.golf_field_hole_10_par)
    Spinner mHole10ParSpinner;

    @BindView(R.id.golf_field_hole_10_length)
    EditText mHole10LengthEditTextView;

    @BindView(R.id.golf_field_hole_10_length_unit)
    TextView mHole10LengthUnit;

    //Hole 11
    @BindView(R.id.golf_field_hole_11_par)
    Spinner mHole11ParSpinner;

    @BindView(R.id.golf_field_hole_11_length)
    EditText mHole11LengthEditTextView;

    @BindView(R.id.golf_field_hole_11_length_unit)
    TextView mHole11LengthUnit;


    //Hole 12
    @BindView(R.id.golf_field_hole_12_par)
    Spinner mHole12ParSpinner;

    @BindView(R.id.golf_field_hole_12_length)
    EditText mHole12LengthEditTextView;

    @BindView(R.id.golf_field_hole_12_length_unit)
    TextView mHole12LengthUnit;


    //Hole 13
    @BindView(R.id.golf_field_hole_13_par)
    Spinner mHole13ParSpinner;

    @BindView(R.id.golf_field_hole_13_length)
    EditText mHole13LengthEditTextView;

    @BindView(R.id.golf_field_hole_13_length_unit)
    TextView mHole13LengthUnit;


    //Hole 14
    @BindView(R.id.golf_field_hole_14_par)
    Spinner mHole14ParSpinner;

    @BindView(R.id.golf_field_hole_14_length)
    EditText mHole14LengthEditTextView;

    @BindView(R.id.golf_field_hole_14_length_unit)
    TextView mHole14LengthUnit;


    //Hole 15
    @BindView(R.id.golf_field_hole_15_par)
    Spinner mHole15ParSpinner;

    @BindView(R.id.golf_field_hole_15_length)
    EditText mHole15LengthEditTextView;

    @BindView(R.id.golf_field_hole_15_length_unit)
    TextView mHole15LengthUnit;


    //Hole 16
    @BindView(R.id.golf_field_hole_16_par)
    Spinner mHole16ParSpinner;

    @BindView(R.id.golf_field_hole_16_length)
    EditText mHole16LengthEditTextView;

    @BindView(R.id.golf_field_hole_16_length_unit)
    TextView mHole16LengthUnit;


    //Hole 17
    @BindView(R.id.golf_field_hole_17_par)
    Spinner mHole17ParSpinner;

    @BindView(R.id.golf_field_hole_17_length)
    EditText mHole17LengthEditTextView;

    @BindView(R.id.golf_field_hole_17_length_unit)
    TextView mHole17LengthUnit;


    //Hole 18
    @BindView(R.id.golf_field_hole_18_par)
    Spinner mHole18ParSpinner;

    @BindView(R.id.golf_field_hole_18_length)
    EditText mHole18LengthEditTextView;

    @BindView(R.id.golf_field_hole_18_length_unit)
    TextView mHole18LengthUnit;



    //Bind Bottom Navigation Tool bars

    @BindView(R.id.nav_gol_field_view)
    BottomNavigationView mBottomNavigationView;



    public ViewGolfFieldActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView= inflater.inflate(R.layout.view_golf_field_fragment, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        retrieveArguments();
        setupFragment();
        setupAd();




        return mRootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_TAB_LABEL,mTabHost.getCurrentTab());
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState!=null && savedInstanceState.containsKey(SELECTED_TAB_LABEL)){
            mTabHost.setCurrentTab(savedInstanceState.getInt(SELECTED_TAB_LABEL));
        }else{
            mTabHost.setCurrentTab(0);
        }

    }


    private void createNavigationTabs(){

        mTabHost.setup();

        //Tab 1
        TabHost.TabSpec spec = mTabHost.newTabSpec(TAB_GENERAL_SPEC);
        spec.setContent(R.id.tab_golf_field_general);
        spec.setIndicator(getString(R.string.tab_general));
        mTabHost.addTab(spec);

        //Tab 2
        spec = mTabHost.newTabSpec(TAB_OUT_SPEC);
        spec.setContent(R.id.tab_golf_field_out);
        spec.setIndicator(getString(R.string.tab_out));
        mTabHost.addTab(spec);

        //Tab 3
        spec = mTabHost.newTabSpec(TAB_IN_SPEC);
        spec.setContent(R.id.tab_golf_field_in);
        spec.setIndicator(getString(R.string.tab_in));
        mTabHost.addTab(spec);


        mTabHost.setCurrentTab(0);

    }



    private void retrieveArguments(){
        Bundle args;
        args=getArguments();

        if (args!=null){
            mGolfField_id= args.getLong(GOLF_FIELD_ID_LABEL, GolfField.INVALID_GOLF_FIELD_ID);
        }else{
            mGolfField_id=GolfField.INVALID_GOLF_FIELD_ID;
        }

    }


    private void setupAd(){

        mAdError=false;
        mAdLoaded=false;
        mInterstitial=new InterstitialAd(getContext());
        mInterstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id_new_scorecard));

        mInterstitial.setAdListener(new AdMobListener(getContext()){

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                mAdError=true;

            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mAdLoaded=true;
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                GenerateNewScorecard();
            }
        });

        AdRequest adRequest=new AdRequest.Builder().build();
        mInterstitial.loadAd(adRequest);


    }


    private void setupFragment(){

        createNavigationTabs();
        createBottomNavigationViewListener();
        setParSpinners();
        setLengthUnits();


        if(mGolfField_id!=GolfField.INVALID_GOLF_FIELD_ID){

            retrieveGolfFieldData();

            if (ScorecardUtils.RetrieveStringFromSharedPreferences(getContext(),CURRENT_MODE_KEY,CURRENT_MODE_VIEW).equals(CURRENT_MODE_EDIT)){

                setEditMode();
            }else{
                setViewMode();
            }


        }else{
            Toast.makeText(getContext(),R.string.golf_field_err_retrieve_golf_field,Toast.LENGTH_LONG).show();
            getActivity().finish();

        }

    }



    private void setViewMode(){

        //set the resume card as visible and set as gone the name one
        mGolfFieldResumeCardView.setVisibility(View.VISIBLE);
        mGolfFieldNameCardView.setVisibility(View.GONE);

        //Inflate the bottom_menu_view
        mBottomNavigationView.getMenu().clear();
        mBottomNavigationView.inflateMenu(R.menu.bottom_menu_view_golf_field);

        //set the golf field title
        getActivity().setTitle(mViewGolfField.getName());

        //set the fields as enabled=false
        setFieldsEnabled(false);



    }


    private void setEditMode(){


        //set the resume card as visible and set as gone the name one
        mGolfFieldResumeCardView.setVisibility(View.GONE);
        mGolfFieldNameCardView.setVisibility(View.VISIBLE);

        //Inflate the bottom_menu_edit
        mBottomNavigationView.getMenu().clear();
        mBottomNavigationView.inflateMenu(R.menu.bottom_menu_edit_golf_field);


        //set the golf field title
        getActivity().setTitle(getContext().getString(R.string.golf_field_title_edit));

        //set the fields as enabled=true
        setFieldsEnabled(true);





    }


    private void setLengthUnits(){

        mHole1LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole2LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole3LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole4LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole5LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole6LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole7LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole8LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole9LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));

        mHole10LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole11LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole12LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole13LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole14LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole15LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole16LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole17LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));
        mHole18LengthUnit.setText(ScorecardUtils.getFormattedCurrentLengthUnit(getContext()));

    }




    private void setFieldsEnabled(boolean enable){

        //Length
        mHole1LengthEditTextView.setEnabled(enable);
        mHole2LengthEditTextView.setEnabled(enable);
        mHole3LengthEditTextView.setEnabled(enable);
        mHole4LengthEditTextView.setEnabled(enable);
        mHole5LengthEditTextView.setEnabled(enable);
        mHole6LengthEditTextView.setEnabled(enable);
        mHole7LengthEditTextView.setEnabled(enable);
        mHole8LengthEditTextView.setEnabled(enable);
        mHole9LengthEditTextView.setEnabled(enable);

        mHole10LengthEditTextView.setEnabled(enable);
        mHole11LengthEditTextView.setEnabled(enable);
        mHole12LengthEditTextView.setEnabled(enable);
        mHole13LengthEditTextView.setEnabled(enable);
        mHole14LengthEditTextView.setEnabled(enable);
        mHole15LengthEditTextView.setEnabled(enable);
        mHole16LengthEditTextView.setEnabled(enable);
        mHole17LengthEditTextView.setEnabled(enable);
        mHole18LengthEditTextView.setEnabled(enable);

        //Par
        mHole1ParSpinner.setEnabled(enable);
        mHole2ParSpinner.setEnabled(enable);
        mHole3ParSpinner.setEnabled(enable);
        mHole4ParSpinner.setEnabled(enable);
        mHole5ParSpinner.setEnabled(enable);
        mHole6ParSpinner.setEnabled(enable);
        mHole7ParSpinner.setEnabled(enable);
        mHole8ParSpinner.setEnabled(enable);
        mHole9ParSpinner.setEnabled(enable);

        mHole10ParSpinner.setEnabled(enable);
        mHole11ParSpinner.setEnabled(enable);
        mHole12ParSpinner.setEnabled(enable);
        mHole13ParSpinner.setEnabled(enable);
        mHole14ParSpinner.setEnabled(enable);
        mHole15ParSpinner.setEnabled(enable);
        mHole16ParSpinner.setEnabled(enable);
        mHole17ParSpinner.setEnabled(enable);
        mHole18ParSpinner.setEnabled(enable);

    }





    private void createBottomNavigationViewListener(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case item_view_golf_field_new_scorecard:

                        if (mAdLoaded){
                            mInterstitial.show();
                        }else{
                            GenerateNewScorecard();
                         }

                        break;

                    case R.id.item_view_golf_field_delete:
                        //TODO CHANGE TO THE CORRECT FUNCTIONALITY
                        Toast.makeText(getContext(),"Selected: delete",Toast.LENGTH_LONG).show();
                        //getActivity().finish();
                        break;

                    case R.id.item_view_golf_field_favorite:

                        if (mViewGolfField.changeFavoriteStatus(getContext())){
                            getActivity().finish();
                        }else{
                            Toast.makeText(getContext(),R.string.golf_field_err_save,Toast.LENGTH_LONG).show();
                        }
                        break;

                    case item_view_golf_field_edit:
                        ScorecardUtils.AddStringToSharedPreferences(getContext(),CURRENT_MODE_KEY,CURRENT_MODE_EDIT);
                        setEditMode();
                        break;

                    case item_golf_field_edit_save:
                        if (updateGolfField()){
                            getActivity().finish();
                        }else{
                            Toast.makeText(getContext(),R.string.golf_field_err_save,Toast.LENGTH_LONG).show();
                        }
                        break;

                    default:
                        break;

                }
                return true;
            }
        });


    }








    private Boolean updateGolfField(){

        Boolean update_OK=true;
        mEditGolfField=retrieveEnteredInformation();


        if (mEditGolfField.verifyGolfField() && mEditGolfField.verifyHoles()){

            //Update Golf field information
            if (!GolfField.areEqual(mViewGolfField,mEditGolfField)){
                if (!mEditGolfField.updateGolfFieldGeneralInformation(getContext())){
                    update_OK=false;
                }
            }

            //Update the Golf Field Holes
            if (update_OK){

                for (int i=0; i<18;i++){

                    if (!GolfFieldHole.areEqual(mViewGolfField.getHole(i),mEditGolfField.getHole(i))){
                        if (!mEditGolfField.getHole(i).updateGolfFieldHoleInformation(getContext())){
                            update_OK=false;
                        }
                    }

                }
            }


        }else{

            update_OK=false;

        }

        return update_OK;

    }




    private void setParSpinners(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.pars_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mHole1ParSpinner.setAdapter(adapter);
        mHole2ParSpinner.setAdapter(adapter);
        mHole3ParSpinner.setAdapter(adapter);
        mHole4ParSpinner.setAdapter(adapter);
        mHole5ParSpinner.setAdapter(adapter);
        mHole6ParSpinner.setAdapter(adapter);
        mHole7ParSpinner.setAdapter(adapter);
        mHole8ParSpinner.setAdapter(adapter);
        mHole9ParSpinner.setAdapter(adapter);


        mHole10ParSpinner.setAdapter(adapter);
        mHole11ParSpinner.setAdapter(adapter);
        mHole12ParSpinner.setAdapter(adapter);
        mHole13ParSpinner.setAdapter(adapter);
        mHole14ParSpinner.setAdapter(adapter);
        mHole15ParSpinner.setAdapter(adapter);
        mHole16ParSpinner.setAdapter(adapter);
        mHole17ParSpinner.setAdapter(adapter);
        mHole18ParSpinner.setAdapter(adapter);


    }

    private String buildResumeCardContentDescription(GolfField golfField){

        String description=String.format(getContext().getString(R.string.a11y_golf_field_description),
                golfField.getName(),
                ScorecardUtils.getFormattedLength(getContext(),golfField.getOut_length()),
                ScorecardUtils.getFormattedLength(getContext(),golfField.getIn_length()),
                ScorecardUtils.getFormattedLength(getContext(),golfField.getTotal_length()),
                golfField.getTotal_par()
        );


        if (golfField.getFavorite()== ScorecardContract.ScorecardBoolean.TRUE){
            description= description+ getContext().getString(R.string.a11y_golf_field_description_favorite);
        }

        return description;
    }



    private void retrieveGolfFieldData(){

        mViewGolfField=new GolfField(getContext(),mGolfField_id);
        if (mViewGolfField.get_id()!=GolfField.INVALID_GOLF_FIELD_ID){

            //Load the hole information
            mViewGolfField.loadHolesFromDB(getContext());


            //Set the favorite
            if (mViewGolfField.getFavorite()== ScorecardContract.ScorecardBoolean.TRUE){
                mGolfFieldFavoriteImageView.setVisibility(View.VISIBLE);
            }else{
                mGolfFieldFavoriteImageView.setVisibility(View.GONE);
            }

            //set the total length
            mGolfFieldTotalLengthTextView.setText(ScorecardUtils.getFormattedLength(getContext(),mViewGolfField.getTotal_length()));

            //set the total par
            mGolfFieldTotalParTextView.setText(ScorecardUtils.getFormattedPar(getContext(),mViewGolfField.getTotal_par()));

            //set the out length
            mGolfFieldOutLengthTextView.setText(ScorecardUtils.getFormattedLength(getContext(),mViewGolfField.getOut_length()));

            //set the total par
            mGolfFieldOutParTextView.setText(ScorecardUtils.getFormattedPar(getContext(),mViewGolfField.getOut_par()));

            //set the in length
            mGolfFieldInLengthTextView.setText(ScorecardUtils.getFormattedLength(getContext(),mViewGolfField.getIn_length()));

            //set the total par
            mGolfFieldInParTextView.setText(ScorecardUtils.getFormattedPar(getContext(),mViewGolfField.getIn_par()));

            //set the name
            mGolfFieldNameEditTextView.setText(mViewGolfField.getName());


            //Set the a11y information for the Resume Tab
            mGolfFieldResumeCardView.setContentDescription(buildResumeCardContentDescription(mViewGolfField));


            //Set the length of the OUT holes (1-9)
            mHole1LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_1)));
            mHole2LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_2)));
            mHole3LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_3)));
            mHole4LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_4)));
            mHole5LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_5)));
            mHole6LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_6)));
            mHole7LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_7)));
            mHole8LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_8)));
            mHole9LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_9)));

            //Set the length of the IN holes (10-18)
            mHole10LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_10)));
            mHole11LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_11)));
            mHole12LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_12)));
            mHole13LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_13)));
            mHole14LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_14)));
            mHole15LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_15)));
            mHole16LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_16)));
            mHole17LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_17)));
            mHole18LengthEditTextView.setText(ScorecardUtils.getConvertedHoleLengthString(getContext(),mViewGolfField.getHole(Hole.HoleNumber.HOLE_18)));


            //Set the Par of the OUT holes
            mHole1ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_1)));
            mHole2ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_2)));
            mHole3ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_3)));
            mHole4ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_4)));
            mHole5ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_5)));
            mHole6ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_6)));
            mHole7ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_7)));
            mHole8ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_8)));
            mHole9ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_9)));

            //Set the PAR of the in Holes
            mHole10ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_10)));
            mHole11ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_11)));
            mHole12ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_12)));
            mHole13ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_13)));
            mHole14ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_14)));
            mHole15ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_15)));
            mHole16ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_16)));
            mHole17ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_17)));
            mHole18ParSpinner.setSelection(ScorecardUtils.convertParToIndex(mViewGolfField.getHole(Hole.HoleNumber.HOLE_18)));




        }else{
            Toast.makeText(getContext(),R.string.golf_field_err_retrieve_golf_field,Toast.LENGTH_LONG).show();
            getActivity().finish();
        }



    }



    private String retrieveGolfFieldName(){

        String name;
        if (mGolfFieldNameEditTextView.length()==0){
            name=null;
        }else if(mGolfFieldNameEditTextView.getText().toString().trim().equals("")){
            name=null;
        }else{
            name= mGolfFieldNameEditTextView.getText().toString().trim();

        }

        mGolfFieldNameEditTextView.setText(name);//To trim the entered value
        mGolfFieldNameEditTextView.setSelection(mGolfFieldNameEditTextView.length(),mGolfFieldNameEditTextView.length());
        return name;
    }



    private GolfField retrieveEnteredInformation(){


        String golfFieldName=retrieveGolfFieldName();
        ScorecardContract.ScorecardBoolean golfFieldFavorite= mViewGolfField.getFavorite();
        ScorecardContract.ScorecardBoolean golfFieldActive=mViewGolfField.getActive();


        GolfField golfField=new GolfField(mViewGolfField.get_id(),golfFieldName,golfFieldFavorite,golfFieldActive);


        //Add hole 1
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_1).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_1,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole1LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole1ParSpinner.getSelectedItemId())));

        //Add hole 2
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_2).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_2,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole2LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole2ParSpinner.getSelectedItemId())));

        //Add hole 3
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_3).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_3,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole3LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole3ParSpinner.getSelectedItemId())));

        //Add hole 4
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_4).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_4,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole4LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole4ParSpinner.getSelectedItemId())));

        //Add hole 5
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_5).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_5,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole5LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole5ParSpinner.getSelectedItemId())));

        //Add hole 6
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_6).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_6,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole6LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole6ParSpinner.getSelectedItemId())));

        //Add hole 7
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_7).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_7,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole7LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole7ParSpinner.getSelectedItemId())));

        //Add hole 8
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_8).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_8,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole8LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole8ParSpinner.getSelectedItemId())));

        //Add hole 9
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_9).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_9,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole9LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole9ParSpinner.getSelectedItemId())));


        //Add hole 10
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_10).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_10,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole10LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole10ParSpinner.getSelectedItemId())));

        //Add hole 11
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_11).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_11,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole11LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole11ParSpinner.getSelectedItemId())));

        //Add hole 12
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_12).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_12,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole12LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole12ParSpinner.getSelectedItemId())));

        //Add hole 13
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_13).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_13,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole13LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole13ParSpinner.getSelectedItemId())));

        //Add hole 14
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_14).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_14,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole14LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole14ParSpinner.getSelectedItemId())));

        //Add hole 15
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_15).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_15,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole15LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole15ParSpinner.getSelectedItemId())));

        //Add hole 16
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_16).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_16,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole16LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole16ParSpinner.getSelectedItemId())));

        //Add hole 17
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_17).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_17,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole17LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole17ParSpinner.getSelectedItemId())));

        //Add hole 18
        golfField.AddHole(new GolfFieldHole(
                mViewGolfField.getHole(Hole.HoleNumber.HOLE_18).get_id(),
                mViewGolfField.get_id(),
                Hole.HoleNumber.HOLE_18,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole18LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole18ParSpinner.getSelectedItemId())));

        return golfField;

    }



    private void GenerateNewScorecard(){

        ScorecardUtils.AddIntToSharedPreferences(getContext(),SELECTED_MENU_ITEM_LABEL,R.id.nav_current_scorecards);


        CurrentScorecard currentScorecard=new CurrentScorecard(getContext());

        //send resume part
        currentScorecard.setGolfFieldName(mViewGolfField.getName());
        currentScorecard.setGolfFieldOutLength(mViewGolfField.getOut_length());
        currentScorecard.setGolfFieldInLength(mViewGolfField.getIn_length());
        currentScorecard.setGolfFieldOutPar(mViewGolfField.getOut_par());
        currentScorecard.setGolfFieldInPar(mViewGolfField.getIn_par());
        currentScorecard.setDate(System.currentTimeMillis());


        //send score part
        currentScorecard.setCurrentHandicap(new Player().getHandicap(getContext()));


        //send out part
        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_1,mViewGolfField.getHole(Hole.HoleNumber.HOLE_1).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_1,mViewGolfField.getHole(Hole.HoleNumber.HOLE_1).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_1,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_2,mViewGolfField.getHole(Hole.HoleNumber.HOLE_2).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_2,mViewGolfField.getHole(Hole.HoleNumber.HOLE_2).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_2,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_3,mViewGolfField.getHole(Hole.HoleNumber.HOLE_3).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_3,mViewGolfField.getHole(Hole.HoleNumber.HOLE_3).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_3,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_4,mViewGolfField.getHole(Hole.HoleNumber.HOLE_4).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_4,mViewGolfField.getHole(Hole.HoleNumber.HOLE_4).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_4,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_5,mViewGolfField.getHole(Hole.HoleNumber.HOLE_5).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_5,mViewGolfField.getHole(Hole.HoleNumber.HOLE_5).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_5,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_6,mViewGolfField.getHole(Hole.HoleNumber.HOLE_6).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_6,mViewGolfField.getHole(Hole.HoleNumber.HOLE_6).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_6,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_7,mViewGolfField.getHole(Hole.HoleNumber.HOLE_7).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_7,mViewGolfField.getHole(Hole.HoleNumber.HOLE_7).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_7,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_8,mViewGolfField.getHole(Hole.HoleNumber.HOLE_8).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_8,mViewGolfField.getHole(Hole.HoleNumber.HOLE_8).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_8,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_9,mViewGolfField.getHole(Hole.HoleNumber.HOLE_9).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_9,mViewGolfField.getHole(Hole.HoleNumber.HOLE_9).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_9,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        //send in part
        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_10,mViewGolfField.getHole(Hole.HoleNumber.HOLE_10).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_10,mViewGolfField.getHole(Hole.HoleNumber.HOLE_10).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_10,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_11,mViewGolfField.getHole(Hole.HoleNumber.HOLE_11).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_11,mViewGolfField.getHole(Hole.HoleNumber.HOLE_11).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_11,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_12,mViewGolfField.getHole(Hole.HoleNumber.HOLE_12).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_12,mViewGolfField.getHole(Hole.HoleNumber.HOLE_12).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_12,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_13,mViewGolfField.getHole(Hole.HoleNumber.HOLE_13).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_13,mViewGolfField.getHole(Hole.HoleNumber.HOLE_13).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_13,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_14,mViewGolfField.getHole(Hole.HoleNumber.HOLE_14).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_14,mViewGolfField.getHole(Hole.HoleNumber.HOLE_14).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_14,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_15,mViewGolfField.getHole(Hole.HoleNumber.HOLE_15).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_15,mViewGolfField.getHole(Hole.HoleNumber.HOLE_15).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_15,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_16,mViewGolfField.getHole(Hole.HoleNumber.HOLE_16).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_16,mViewGolfField.getHole(Hole.HoleNumber.HOLE_16).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_16,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_17,mViewGolfField.getHole(Hole.HoleNumber.HOLE_17).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_17,mViewGolfField.getHole(Hole.HoleNumber.HOLE_17).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_17,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);

        currentScorecard.setHoleLength(Hole.HoleNumber.HOLE_18,mViewGolfField.getHole(Hole.HoleNumber.HOLE_18).getLength());
        currentScorecard.setHolePar(Hole.HoleNumber.HOLE_18,mViewGolfField.getHole(Hole.HoleNumber.HOLE_18).getPar());
        currentScorecard.setHoleScore(Hole.HoleNumber.HOLE_18,CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE);







        currentScorecard.setExistCurrentScorecard();




        getActivity().finish();
    }


}
