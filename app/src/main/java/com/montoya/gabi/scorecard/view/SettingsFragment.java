package com.montoya.gabi.scorecard.view;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.montoya.gabi.scorecard.view.SettingsFragment.OnFragmentInteractionListener} factory method to
 * create an instance of this fragment.
 */



public class SettingsFragment extends Fragment {


    private View mRootView;
    private String mCurrentUnitLength;

    @BindView(R.id.setting_unit_length_spinner)
    Spinner mUnitLengthSpinner;




    private OnFragmentInteractionListener mListener;

    public SettingsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView =inflater.inflate(R.layout.fragment_settings, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        //Set the adapter values
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.unit_length_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mUnitLengthSpinner.setAdapter(adapter);

        //set the current UnitOfLength
        this.setCurrentUnitOfLength();


        mUnitLengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (!mCurrentUnitLength.equals(ScorecardUtils.convertIndexToUnitLength(position))){

                    ScorecardUtils.setCurrentLengthUnit(getContext(),ScorecardUtils.convertIndexToUnitLength(position));

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





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
        if (context instanceof SettingsFragment.OnFragmentInteractionListener) {
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


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

        super.onViewStateRestored(savedInstanceState);
        setCurrentUnitOfLength();


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



    private void setCurrentUnitOfLength(){

        mCurrentUnitLength=ScorecardUtils.getCurrentLengthUnit(getContext());
        mUnitLengthSpinner.setSelection(ScorecardUtils.convertUnitLengthToIndex(mCurrentUnitLength));

    }

}
