package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;

import butterknife.BindView;
import butterknife.ButterKnife;

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


        createNavigationTabs();

        //retrieveArguments();
        //setupFragment();




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










}
