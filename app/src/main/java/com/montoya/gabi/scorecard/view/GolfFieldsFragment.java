package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GolfFieldsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class GolfFieldsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int GOLF_FIELDS_LOADER = 0;
    private View mRootView;
    private GolfFieldAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    //Bind Views
    @BindView(R.id.fab_new_golf_field)
    FloatingActionButton mFabNewGolfField;

    @BindView(R.id.recycler_view_golf_fields)
    RecyclerView mRecyclerViewGolfFields;



    @BindView(R.id.error_golf_fields)
    TextView mError;


    //Bind Events
    @OnClick(R.id.fab_new_golf_field)
    public void click(View view){
        Snackbar.make(view, "Replace with your own action - BUTTER KNIFE", Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }




    private OnFragmentInteractionListener mListener;

    public GolfFieldsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView= inflater.inflate(R.layout.fragment_golf_fields, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        //Recycler View Settings
        mRecyclerViewGolfFields.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewGolfFields.setLayoutManager(mLayoutManager);


        //mEmptyView=getActivity().findViewById(R.id.error_golf_fields);

        // specify an adapter (see also next example)
        mAdapter = new GolfFieldAdapter(getContext());
        mRecyclerViewGolfFields.setAdapter(mAdapter);


        getActivity().getSupportLoaderManager().initLoader(GOLF_FIELDS_LOADER, null, this);


        return mRootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    /**
     * Cursor Loaders Methods.
     *
     *
     *
     *
     *
     * *
     */

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.e("On create loader", "antes de creater el curosor loader");

        return new CursorLoader(getActivity(), ScorecardContract.GolfFieldEntry.buildAllGolfFieldsActiveUri(),null,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        Log.e ("Curosr has",""+data.getCount());

        if (data.getCount() > 0) {
            mError.setVisibility(View.GONE);
            mRecyclerViewGolfFields.setVisibility(View.VISIBLE);
        }else{
            Log.e ("Curosr has 0","Entro al else");
            mError.setVisibility(View.VISIBLE);
            mRecyclerViewGolfFields.setVisibility(View.GONE);

        }
        mAdapter.setCursor(data);




    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdapter.setCursor(null);

    }



}
