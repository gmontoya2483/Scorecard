package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.montoya.gabi.scorecard.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class GolfFieldActivityFragment extends Fragment {

    View mRootView;
    TabHost host;
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

        host = (TabHost) mRootView.findViewById(R.id.tabHost_golf_field);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec(TAB_GENERAL_SPEC);
        spec.setContent(R.id.tab_golf_field_general);
        spec.setIndicator(getString(R.string.tab_general));
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec(TAB_OUT_SPEC);
        spec.setContent(R.id.tab_golf_field_out);
        spec.setIndicator(getString(R.string.tab_out));
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec(TAB_IN_SPEC);
        spec.setContent(R.id.tab_golf_field_in);
        spec.setIndicator(getString(R.string.tab_in));
        host.addTab(spec);


        host.setCurrentTab(0);



        return mRootView;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt(SELECTED_TAB_LABEL,host.getCurrentTab());
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
            host.setCurrentTab(savedInstanceState.getInt(SELECTED_TAB_LABEL));
        }else{
            host.setCurrentTab(0);
        }
        super.onViewStateRestored(savedInstanceState);
    }
}
