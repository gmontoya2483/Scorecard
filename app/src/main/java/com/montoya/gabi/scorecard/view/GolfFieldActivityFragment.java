package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.Hole;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class GolfFieldActivityFragment extends Fragment {

    View mRootView;


    //Bind Views
    @BindView(R.id.tabHost_golf_field)
    TabHost mTabHost;

    @BindView(R.id.nav_gol_field_new)
    BottomNavigationView mBottomNavigationView;

    //Hole 1
    Hole.HoleNumber mHole1Number= Hole.HoleNumber.HOLE_1;

    @BindView(R.id.golf_field_hole_1_par)
    Spinner mHole1ParSpinner;
    Hole.Par mHole1Par;

    @BindView(R.id.golf_field_hole_1_length)
    TextView mHole1Length;

    //Hole 2
    Hole.HoleNumber mHole2Number= Hole.HoleNumber.HOLE_2;

    @BindView(R.id.golf_field_hole_2_par)
    Spinner mHole2ParSpinner;
    Hole.Par mHole2Par;

    @BindView(R.id.golf_field_hole_2_length)
    TextView mHole2Length;

    //Hole 3
    Hole.HoleNumber mHole3Number= Hole.HoleNumber.HOLE_3;

    @BindView(R.id.golf_field_hole_3_par)
    Spinner mHole3ParSpinner;
    Hole.Par mHole3Par;

    @BindView(R.id.golf_field_hole_3_length)
    TextView mHole3Length;

    //Hole 4
    Hole.HoleNumber mHole4Number= Hole.HoleNumber.HOLE_4;

    @BindView(R.id.golf_field_hole_4_par)
    Spinner mHole4ParSpinner;
    Hole.Par mHole4Par;

    @BindView(R.id.golf_field_hole_4_length)
    TextView mHole4Length;

    //Hole 5
    Hole.HoleNumber mHole5Number= Hole.HoleNumber.HOLE_5;

    @BindView(R.id.golf_field_hole_5_par)
    Spinner mHole5ParSpinner;
    Hole.Par mHole5Par;

    @BindView(R.id.golf_field_hole_5_length)
    TextView mHole5Length;

    //Hole 6
    Hole.HoleNumber mHole6Number= Hole.HoleNumber.HOLE_6;

    @BindView(R.id.golf_field_hole_6_par)
    Spinner mHole6ParSpinner;
    Hole.Par mHole6Par;

    @BindView(R.id.golf_field_hole_6_length)
    TextView mHole6Length;

    //Hole 7
    Hole.HoleNumber mHole7Number= Hole.HoleNumber.HOLE_7;

    @BindView(R.id.golf_field_hole_7_par)
    Spinner mHole7ParSpinner;
    Hole.Par mHole7Par;

    @BindView(R.id.golf_field_hole_7_length)
    TextView mHole7Length;

    //Hole 8
    Hole.HoleNumber mHole8Number= Hole.HoleNumber.HOLE_8;

    @BindView(R.id.golf_field_hole_8_par)
    Spinner mHole8ParSpinner;
    Hole.Par mHole8Par;

    @BindView(R.id.golf_field_hole_8_length)
    TextView mHole8Length;

    //Hole 9
    Hole.HoleNumber mHole9Number= Hole.HoleNumber.HOLE_9;

    @BindView(R.id.golf_field_hole_9_par)
    Spinner mHole9ParSpinner;
    Hole.Par mHole9Par;

    @BindView(R.id.golf_field_hole_9_length)
    TextView mHole9Length;


    //Hole 10
    Hole.HoleNumber mHole10Number= Hole.HoleNumber.HOLE_10;

    @BindView(R.id.golf_field_hole_10_par)
    Spinner mHole10ParSpinner;
    Hole.Par mHole10Par;

    @BindView(R.id.golf_field_hole_10_length)
    TextView mHole10Length;

    //Hole 11
    Hole.HoleNumber mHole11Number= Hole.HoleNumber.HOLE_11;

    @BindView(R.id.golf_field_hole_11_par)
    Spinner mHole11ParSpinner;
    Hole.Par mHole11Par;

    @BindView(R.id.golf_field_hole_11_length)
    TextView mHole11Length;

    //Hole 12
    Hole.HoleNumber mHole12Number= Hole.HoleNumber.HOLE_12;

    @BindView(R.id.golf_field_hole_12_par)
    Spinner mHole12ParSpinner;
    Hole.Par mHole12Par;

    @BindView(R.id.golf_field_hole_12_length)
    TextView mHole12Length;

    //Hole 13
    Hole.HoleNumber mHole13Number= Hole.HoleNumber.HOLE_13;

    @BindView(R.id.golf_field_hole_13_par)
    Spinner mHole13ParSpinner;
    Hole.Par mHole13Par;

    @BindView(R.id.golf_field_hole_13_length)
    TextView mHole13Length;

    //Hole 14
    Hole.HoleNumber mHole14Number= Hole.HoleNumber.HOLE_14;

    @BindView(R.id.golf_field_hole_14_par)
    Spinner mHole14ParSpinner;
    Hole.Par mHole14Par;

    @BindView(R.id.golf_field_hole_14_length)
    TextView mHole14Length;

    //Hole 15
    Hole.HoleNumber mHole15Number= Hole.HoleNumber.HOLE_15;

    @BindView(R.id.golf_field_hole_15_par)
    Spinner mHole15ParSpinner;
    Hole.Par mHole15Par;

    @BindView(R.id.golf_field_hole_15_length)
    TextView mHole15Length;


    //Hole 16
    Hole.HoleNumber mHole16Number= Hole.HoleNumber.HOLE_16;

    @BindView(R.id.golf_field_hole_16_par)
    Spinner mHole16ParSpinner;
    Hole.Par mHole16Par;

    @BindView(R.id.golf_field_hole_16_length)
    TextView mHole16Length;


    //Hole 17
    Hole.HoleNumber mHole17Number= Hole.HoleNumber.HOLE_17;

    @BindView(R.id.golf_field_hole_17_par)
    Spinner mHole17ParSpinner;
    Hole.Par mHole17Par;

    @BindView(R.id.golf_field_hole_17_length)
    TextView mHole17Length;


    //Hole 18
    Hole.HoleNumber mHole18Number= Hole.HoleNumber.HOLE_18;

    @BindView(R.id.golf_field_hole_18_par)
    Spinner mHole18ParSpinner;
    Hole.Par mHole18Par;

    @BindView(R.id.golf_field_hole_18_length)
    TextView mHole18Length;



    private final String TAB_GENERAL_SPEC="general_tab";
    private final String TAB_OUT_SPEC="out_tab";
    private final String TAB_IN_SPEC="in_tab";

    private final String SELECTED_TAB_LABEL="selected_tab";

    public GolfFieldActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView= inflater.inflate(R.layout.fragment_golf_field, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        createNavigationTabs();
        createBottomNavigationView();
        setParSpinners();

        return mRootView;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt(SELECTED_TAB_LABEL,mTabHost.getCurrentTab());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }




    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

        if (savedInstanceState!=null && savedInstanceState.containsKey(SELECTED_TAB_LABEL)){
            mTabHost.setCurrentTab(savedInstanceState.getInt(SELECTED_TAB_LABEL));
        }else{
            mTabHost.setCurrentTab(0);
        }
        super.onViewStateRestored(savedInstanceState);
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


    private void createBottomNavigationView(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.item_golf_field_new_save:

                        Toast.makeText(getContext(),"Se apreto save "+mHole2ParSpinner.getSelectedItemId()+" Length "+ mHole1Length.getText() ,Toast.LENGTH_LONG).show();
                        break;

                    default:
                        Toast.makeText(getContext(),"Se fue al default",Toast.LENGTH_LONG).show();
                        break;

                }
                return false;
            }
        });
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


}
