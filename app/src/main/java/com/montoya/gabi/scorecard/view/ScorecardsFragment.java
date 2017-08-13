package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScorecardsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ScorecardsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private OnFragmentInteractionListener mListener;
    private ScorecardsAdapter mAdapter;
    private static final int SCORECARD_LOADER = 2;
    private View mRootView;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.recycler_view_scorecards)
    RecyclerView mRecyclerViewScorecards;

    @BindView(R.id.error_no_scorecards)
    TextView mError;



    public ScorecardsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView=inflater.inflate(R.layout.fragment_scorecards, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewScorecards.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new ScorecardsAdapter(getContext());
        mRecyclerViewScorecards.setAdapter(mAdapter);

        getActivity().getSupportLoaderManager().initLoader(SCORECARD_LOADER, null, this);

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


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }





    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader loader=new CursorLoader(getActivity(), ScorecardContract.ScorecardEntry.buildAllScoreCardUri(),null,null,null,null);
        return loader;

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data.getCount() > 0) {
            mError.setVisibility(View.GONE);
            mRecyclerViewScorecards.setVisibility(View.VISIBLE);
        }else{
            mError.setVisibility(View.VISIBLE);
            mRecyclerViewScorecards.setVisibility(View.GONE);

        }
        mAdapter.setCursor(data);


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdapter.setCursor(null);

    }



}
