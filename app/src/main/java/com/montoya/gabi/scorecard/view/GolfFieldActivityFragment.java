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
import android.widget.EditText;
import android.widget.ImageView;
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
public class GolfFieldActivityFragment extends Fragment {

    View mRootView;
    GolfField mViewGolfField;

    //bundle information
    public static final String GOLF_FIELD_ID_LABEL="golf_field_id_label";
    public static final String ACTION_LABEL="action_label";
    public static final String ACTION_NEW="new";
    public static final String ACTION_VIEW="view";
    private String mAction;
    private long mGolfField_id;



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

    //Hole 1
    @BindView(R.id.golf_field_hole_1_par)
    Spinner mHole1ParSpinner;

    @BindView(R.id.golf_field_hole_1_length)
    EditText mHole1LengthEditTextView;

    //Hole 2
    @BindView(R.id.golf_field_hole_2_par)
    Spinner mHole2ParSpinner;

    @BindView(R.id.golf_field_hole_2_length)
    EditText mHole2LengthEditTextView;

    //Hole 3
    @BindView(R.id.golf_field_hole_3_par)
    Spinner mHole3ParSpinner;

    @BindView(R.id.golf_field_hole_3_length)
    EditText mHole3LengthEditTextView;

    //Hole 4
    @BindView(R.id.golf_field_hole_4_par)
    Spinner mHole4ParSpinner;

    @BindView(R.id.golf_field_hole_4_length)
    EditText mHole4LengthEditTextView;

    //Hole 5
    @BindView(R.id.golf_field_hole_5_par)
    Spinner mHole5ParSpinner;

    @BindView(R.id.golf_field_hole_5_length)
    EditText mHole5LengthEditTextView;

    //Hole 6
    @BindView(R.id.golf_field_hole_6_par)
    Spinner mHole6ParSpinner;

    @BindView(R.id.golf_field_hole_6_length)
    EditText mHole6LengthEditTextView;

    //Hole 7
    @BindView(R.id.golf_field_hole_7_par)
    Spinner mHole7ParSpinner;

    @BindView(R.id.golf_field_hole_7_length)
    EditText mHole7LengthEditTextView;

    //Hole 8
    @BindView(R.id.golf_field_hole_8_par)
    Spinner mHole8ParSpinner;

    @BindView(R.id.golf_field_hole_8_length)
    EditText mHole8LengthEditTextView;

    //Hole 9
    @BindView(R.id.golf_field_hole_9_par)
    Spinner mHole9ParSpinner;

    @BindView(R.id.golf_field_hole_9_length)
    EditText mHole9LengthEditTextView;

    //Hole 10
    @BindView(R.id.golf_field_hole_10_par)
    Spinner mHole10ParSpinner;

    @BindView(R.id.golf_field_hole_10_length)
    EditText mHole10LengthEditTextView;

    //Hole 11
    @BindView(R.id.golf_field_hole_11_par)
    Spinner mHole11ParSpinner;

    @BindView(R.id.golf_field_hole_11_length)
    EditText mHole11LengthEditTextView;

    //Hole 12
    @BindView(R.id.golf_field_hole_12_par)
    Spinner mHole12ParSpinner;

    @BindView(R.id.golf_field_hole_12_length)
    EditText mHole12LengthEditTextView;

    //Hole 13
    @BindView(R.id.golf_field_hole_13_par)
    Spinner mHole13ParSpinner;

    @BindView(R.id.golf_field_hole_13_length)
    EditText mHole13LengthEditTextView;

    //Hole 14
    @BindView(R.id.golf_field_hole_14_par)
    Spinner mHole14ParSpinner;

    @BindView(R.id.golf_field_hole_14_length)
    EditText mHole14LengthEditTextView;

    //Hole 15
    @BindView(R.id.golf_field_hole_15_par)
    Spinner mHole15ParSpinner;

    @BindView(R.id.golf_field_hole_15_length)
    EditText mHole15LengthEditTextView;

    //Hole 16
    @BindView(R.id.golf_field_hole_16_par)
    Spinner mHole16ParSpinner;

    @BindView(R.id.golf_field_hole_16_length)
    EditText mHole16LengthEditTextView;

    //Hole 17
    @BindView(R.id.golf_field_hole_17_par)
    Spinner mHole17ParSpinner;

    @BindView(R.id.golf_field_hole_17_length)
    EditText mHole17LengthEditTextView;

    //Hole 18
    @BindView(R.id.golf_field_hole_18_par)
    Spinner mHole18ParSpinner;

    @BindView(R.id.golf_field_hole_18_length)
    EditText mHole18LengthEditTextView;


    /* View golf fields exclusives fields
    *
    *
    * */

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

        retrieveArguments();
        setupFragment();


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
            Log.i("RESTORE", "Entro al else while restoring");
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




    private GolfField retrieveEnteredInformation(){


        String golfFieldName=retrieveGolfFieldName();
        ScorecardContract.ScorecardBoolean golfFieldFavorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean golfFieldActive=ScorecardContract.ScorecardBoolean.TRUE;


        GolfField golfField=new GolfField(golfFieldName,golfFieldFavorite,golfFieldActive);


        //Add hole 1
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_1,
                convertLengthTextViewToInt(mHole1LengthEditTextView),
                convertIndexToPar((int)mHole1ParSpinner.getSelectedItemId())));

        //Add hole 2
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_2,
                convertLengthTextViewToInt(mHole2LengthEditTextView),
                convertIndexToPar((int)mHole2ParSpinner.getSelectedItemId())));

        //Add hole 3
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_3,
                convertLengthTextViewToInt(mHole3LengthEditTextView),
                convertIndexToPar((int)mHole3ParSpinner.getSelectedItemId())));

        //Add hole 4
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_4,
                convertLengthTextViewToInt(mHole4LengthEditTextView),
                convertIndexToPar((int)mHole4ParSpinner.getSelectedItemId())));

        //Add hole 5
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_5,
                convertLengthTextViewToInt(mHole5LengthEditTextView),
                convertIndexToPar((int)mHole5ParSpinner.getSelectedItemId())));

        //Add hole 6
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_6,
                convertLengthTextViewToInt(mHole6LengthEditTextView),
                convertIndexToPar((int)mHole6ParSpinner.getSelectedItemId())));

        //Add hole 7
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_7,
                convertLengthTextViewToInt(mHole7LengthEditTextView),
                convertIndexToPar((int)mHole7ParSpinner.getSelectedItemId())));

        //Add hole 8
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_8,
                convertLengthTextViewToInt(mHole8LengthEditTextView),
                convertIndexToPar((int)mHole8ParSpinner.getSelectedItemId())));

        //Add hole 9
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_9,
                convertLengthTextViewToInt(mHole9LengthEditTextView),
                convertIndexToPar((int)mHole9ParSpinner.getSelectedItemId())));


        //Add hole 10
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_10,
                convertLengthTextViewToInt(mHole10LengthEditTextView),
                convertIndexToPar((int)mHole10ParSpinner.getSelectedItemId())));

        //Add hole 11
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_11,
                convertLengthTextViewToInt(mHole11LengthEditTextView),
                convertIndexToPar((int)mHole11ParSpinner.getSelectedItemId())));

        //Add hole 12
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_12,
                convertLengthTextViewToInt(mHole12LengthEditTextView),
                convertIndexToPar((int)mHole12ParSpinner.getSelectedItemId())));

        //Add hole 13
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_13,
                convertLengthTextViewToInt(mHole13LengthEditTextView),
                convertIndexToPar((int)mHole13ParSpinner.getSelectedItemId())));

        //Add hole 14
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_14,
                convertLengthTextViewToInt(mHole14LengthEditTextView),
                convertIndexToPar((int)mHole14ParSpinner.getSelectedItemId())));

        //Add hole 15
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_15,
                convertLengthTextViewToInt(mHole15LengthEditTextView),
                convertIndexToPar((int)mHole15ParSpinner.getSelectedItemId())));

        //Add hole 16
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_16,
                convertLengthTextViewToInt(mHole16LengthEditTextView),
                convertIndexToPar((int)mHole16ParSpinner.getSelectedItemId())));

        //Add hole 17
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_17,
                convertLengthTextViewToInt(mHole17LengthEditTextView),
                convertIndexToPar((int)mHole17ParSpinner.getSelectedItemId())));

        //Add hole 18
        golfField.AddHole(new GolfFieldHole(GolfField.NOT_SAVED_GOLF_FIELD_ID,
                Hole.HoleNumber.HOLE_18,
                convertLengthTextViewToInt(mHole18LengthEditTextView),
                convertIndexToPar((int)mHole18ParSpinner.getSelectedItemId())));

        return golfField;

    }



    private Hole.Par convertIndexToPar(int index){
        Hole.Par par;

        switch (index){
            case 0:
                par= Hole.Par.PAR_NOT_DEFINED;
                break;
            case 1:
                par= Hole.Par.PAR_3;
                break;
            case 2:
                par= Hole.Par.PAR_4;
                break;
            case 3:
                par= Hole.Par.PAR_5;
                break;
            default:
                par= Hole.Par.PAR_INVALID;
                break;
        }

        return par;
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




    private int convertLengthTextViewToInt(EditText lengthTextView){
        int length;

        if (lengthTextView.length()==0){
            length=Hole.NOT_DEFINED_HOLE_LENGTH;
        }else {
            length=Integer.parseInt(lengthTextView.getText().toString().trim());
        }
       return length;
    }


    private void retrieveArguments(){

        Bundle args;
        args=getArguments();

        if (args!=null){

            mAction=args.containsKey(ACTION_LABEL)?args.getString(ACTION_LABEL):ACTION_NEW;

            if (mAction.equals(ACTION_VIEW)){
                if (args.containsKey(GOLF_FIELD_ID_LABEL)){
                    mGolfField_id= args.getLong(GOLF_FIELD_ID_LABEL);

                }else{
                    mAction=ACTION_NEW;
                    mGolfField_id=GolfField.NOT_SAVED_GOLF_FIELD_ID;

                }

            }else{
                mGolfField_id=GolfField.NOT_SAVED_GOLF_FIELD_ID;
            }


        }else{

            mAction=ACTION_NEW;
            mGolfField_id=GolfField.NOT_SAVED_GOLF_FIELD_ID;

        }


    }



    private void setupFragment(){

        createNavigationTabs();
        createBottomNavigationViewListener();//TODO Different mehtods (new, view, Edit,etc)
        setParSpinners();

        switch (mAction){
            case ACTION_NEW:
                setupNewGolfField();
                break;

            case ACTION_VIEW:
                setupViewGolfField();
                break;

            default:
                setupNewGolfField();
                break;

        }


    }


    private void setupNewGolfField(){

        Log.e("NEW","Entro el new golf field");

        getActivity().setTitle(R.string.golf_field_title_new);

        //Enable the name field and disable the resume card
        mGolfFieldNameCardView.setVisibility(View.VISIBLE);
        mGolfFieldResumeCardView.setVisibility(View.GONE);



        mGolfFieldNameEditTextView.setEnabled(true);




    }


    private void setupViewGolfField(){

        mViewGolfField=new GolfField(getContext(),mGolfField_id);
        if (mViewGolfField.get_id()!=GolfField.INVALID_GOLF_FIELD_ID){

            //Load the hole information
            mViewGolfField.loadHolesFromDB(getContext());

            //set the golf field title
            getActivity().setTitle(mViewGolfField.getName());

            //Enable the resume cardView and disable the nane one
            mGolfFieldNameCardView.setVisibility(View.GONE);
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

            //set the save button as invisible
            //mBottomNavigationView.getMenu().getItem(R.id.item_golf_field_new_save).setVisible(false);


        }else{
            setupNewGolfField();
        }


    }



}
