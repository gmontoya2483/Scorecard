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
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class NewGolFieldActivityFragment extends Fragment {


    View mRootView;

    private final String TAB_GENERAL_SPEC="general_tab";
    private final String TAB_OUT_SPEC="out_tab";
    private final String TAB_IN_SPEC="in_tab";

    private final String SELECTED_TAB_LABEL="selected_tab";


    //Bind Views
    @BindView(R.id.tabHost_golf_field)
    TabHost mTabHost;

    @BindView(R.id.nav_gol_field_new)
    BottomNavigationView mBottomNavigationView;


    //Card golf_field_card_name
    @BindView(R.id.golf_field_card_name)
    CardView mGolfFieldNameCardView;

    //Golf Field Name
    @BindView(R.id.golf_field_name)
    EditText mGolfFieldNameEditTextView;

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


    public NewGolFieldActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView= inflater.inflate(R.layout.new_golf_field_fragment, container, false);


        //Bind the View
        ButterKnife.bind(this,mRootView);

        getActivity().setTitle(R.string.golf_field_title_new);

        createNavigationTabs();
        createBottomNavigationViewListener();
        setParSpinners();
        setLengthUnits();


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


    private void createBottomNavigationViewListener(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.item_golf_field_new_save:

                        GolfField golfField=retrieveEnteredInformation();
                        if (golfField.InsertGolfField(getContext())){

                            getActivity().finish();

                        }else{

                            Toast.makeText(getContext(),R.string.golf_field_err_save,Toast.LENGTH_LONG).show();

                        }

                        break;

                    default:
                        break;

                }
                return false;
            }
        });
    }


    private GolfField retrieveEnteredInformation(){


        String golfFieldName=retrieveGolfFieldName();
        ScorecardContract.ScorecardBoolean golfFieldFavorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean golfFieldActive=ScorecardContract.ScorecardBoolean.TRUE;


        GolfField golfField=new GolfField(golfFieldName,golfFieldFavorite,golfFieldActive);


        //Add hole 1
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_1,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole1LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole1ParSpinner.getSelectedItemId())));

        //Add hole 2
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_2,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole2LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole2ParSpinner.getSelectedItemId())));

        //Add hole 3
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_3,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole3LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole3ParSpinner.getSelectedItemId())));

        //Add hole 4
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_4,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole4LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole4ParSpinner.getSelectedItemId())));

        //Add hole 5
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_5,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole5LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole5ParSpinner.getSelectedItemId())));

        //Add hole 6
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_6,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole6LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole6ParSpinner.getSelectedItemId())));

        //Add hole 7
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_7,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole7LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole7ParSpinner.getSelectedItemId())));

        //Add hole 8
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_8,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole8LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole8ParSpinner.getSelectedItemId())));

        //Add hole 9
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_9,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole9LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole9ParSpinner.getSelectedItemId())));


        //Add hole 10
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_10,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole10LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole10ParSpinner.getSelectedItemId())));

        //Add hole 11
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_11,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole11LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole11ParSpinner.getSelectedItemId())));

        //Add hole 12
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_12,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole12LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole12ParSpinner.getSelectedItemId())));

        //Add hole 13
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_13,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole13LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole13ParSpinner.getSelectedItemId())));

        //Add hole 14
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_14,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole14LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole14ParSpinner.getSelectedItemId())));

        //Add hole 15
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_15,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole15LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole15ParSpinner.getSelectedItemId())));

        //Add hole 16
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_16,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole16LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole16ParSpinner.getSelectedItemId())));

        //Add hole 17
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_17,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole17LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole17ParSpinner.getSelectedItemId())));

        //Add hole 18
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_18,
                ScorecardUtils.getLengthInMeters(getContext(),ScorecardUtils.convertLengthTextViewToInt(mHole18LengthEditTextView)),
                ScorecardUtils.convertIndexToPar((int)mHole18ParSpinner.getSelectedItemId())));

        return golfField;

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





}
