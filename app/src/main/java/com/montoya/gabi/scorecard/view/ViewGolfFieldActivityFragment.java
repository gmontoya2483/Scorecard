package com.montoya.gabi.scorecard.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.montoya.gabi.scorecard.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ViewGolfFieldActivityFragment extends Fragment {

    public ViewGolfFieldActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_golf_field_fragment, container, false);
    }
}
