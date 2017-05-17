package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.montoya.gabi.scorecard.R.id.item_view_golf_field_edit;

/**
 * A placeholder fragment containing a simple view.
 */
public class ViewGolfFieldActivityFragment extends Fragment {


    View mRootView;
    GolfField mViewGolfField;

    //bundle information
    public static final String GOLF_FIELD_ID_LABEL="golf_field_id_label";
    private long mGolfField_id;



    private final String TAB_GENERAL_SPEC="general_tab";
    private final String TAB_OUT_SPEC="out_tab";
    private final String TAB_IN_SPEC="in_tab";

    private final String SELECTED_TAB_LABEL="selected_tab";



    //Bind Views
    @BindView(R.id.tabHost_golf_field)
    TabHost mTabHost;

    //Bind general information

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




    //Bind Navigation Tool bars

    @BindView(R.id.nav_gol_field_view)
    BottomNavigationView mBottomNavigationView;








    public ViewGolfFieldActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mRootView= inflater.inflate(R.layout.view_golf_field_fragment, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        retrieveArguments();
        setupFragment();




        return mRootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_TAB_LABEL,mTabHost.getCurrentTab());

        Log.i("RESTORE", "saved: " + outState.getInt(SELECTED_TAB_LABEL));

    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState!=null && savedInstanceState.containsKey(SELECTED_TAB_LABEL)){
            Log.i("RESTORE", "restored: " + savedInstanceState.getInt(SELECTED_TAB_LABEL));
            mTabHost.setCurrentTab(savedInstanceState.getInt(SELECTED_TAB_LABEL));
        }else{
            Log.i("RESTORE", "restored: Nothing");
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


    private void setupFragment(){

        createNavigationTabs();
        createBottomNavigationViewListener();//TODO Different mehtods (new, view, Edit,etc)
        setParSpinners();

        if(mGolfField_id!=GolfField.INVALID_GOLF_FIELD_ID){

            retrieveGolfFieldData();

        }else{
            Toast.makeText(getContext(),R.string.golf_field_err_retrieve_golf_field,Toast.LENGTH_LONG).show();
            getActivity().finish();

        }

    }

    private void createBottomNavigationViewListener(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.item_view_golf_field_delete:
                        //TODO CHANGE TO THE CORRECT FUNCTIONALITY
                        Toast.makeText(getContext(),"Selected: delete",Toast.LENGTH_LONG).show();
                        //getActivity().finish();
                        break;

                    case R.id.item_view_golf_field_favorite:
                        //TODO CHANGE TO THE CORRECT FUNCTIONALITY
                        Toast.makeText(getContext(),"Selected: favorite",Toast.LENGTH_LONG).show();
                        getActivity().finish();
                        break;

                    case item_view_golf_field_edit:
                        //TODO CHANGE TO THE CORRECT FUNCTIONALITY
                        Toast.makeText(getContext(),"Selected: edit",Toast.LENGTH_LONG).show();
                        //getActivity().finish();
                        break;

                    default:
                        break;

                }
                return true;
            }
        });


    }




    private void setParSpinners(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.pars_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /*
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
        */

    }


    private void retrieveGolfFieldData(){

        mViewGolfField=new GolfField(getContext(),mGolfField_id);
        if (mViewGolfField.get_id()!=GolfField.INVALID_GOLF_FIELD_ID){

            //Load the hole information
            mViewGolfField.loadHolesFromDB(getContext());

            //set the golf field title
            getActivity().setTitle(mViewGolfField.getName());

            mGolfFieldResumeCardView.setVisibility(View.VISIBLE);

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


            //TODO ADD THE HOLE INFORMATION
            //TODO SET VIEW MODE (all field disabled)




        }else{
            Toast.makeText(getContext(),R.string.golf_field_err_retrieve_golf_field,Toast.LENGTH_LONG).show();
            getActivity().finish();
        }



    }






















}
