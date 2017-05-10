package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GolfFieldsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class GolfFieldsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    public static final String TYPE_LABEL="golf_fields_type";
    public static final String TYPE_ALL_GOLF_FIELDS="all_golf_fields";
    public static final String TYPE_FAVORITE_GOLF_FIELDS="favorite_golf_fields";


    private static final int ALL_GOLF_FIELDS_LOADER = 0;
    private static final int FAVORITE_GOLF_FIELDS_LOADER = 1;

    private View mRootView;
    private GolfFieldsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mType;



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

        Bundle args=new Bundle();
        args.putString(GolfFieldActivityFragment.ACTION_LABEL,GolfFieldActivityFragment.ACTION_NEW);

        Intent newGolfFieldIntent=new Intent(getContext(),GolfFieldActivity.class);
        newGolfFieldIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        newGolfFieldIntent.putExtras(args);

        startActivity(newGolfFieldIntent);

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
        mAdapter = new GolfFieldsAdapter(getContext());
        mRecyclerViewGolfFields.setAdapter(mAdapter);


        //Get the arguments
        mType= getArguments() != null ? getArguments().getString(TYPE_LABEL) : TYPE_ALL_GOLF_FIELDS;


        if (mType.equals(TYPE_FAVORITE_GOLF_FIELDS)){
            getActivity().getSupportLoaderManager().initLoader(FAVORITE_GOLF_FIELDS_LOADER, null, this);
            mFabNewGolfField.setVisibility(View.GONE);
        }else{
            getActivity().getSupportLoaderManager().initLoader(ALL_GOLF_FIELDS_LOADER, null, this);
        }

        return mRootView;
    }




    @Override
    public void onStart() {
        super.onStart();
        //Init the cursor loader

        if (mType.equals(TYPE_FAVORITE_GOLF_FIELDS)){
            getActivity().getSupportLoaderManager().restartLoader(FAVORITE_GOLF_FIELDS_LOADER, null, this);
        }else{
            getActivity().getSupportLoaderManager().restartLoader(ALL_GOLF_FIELDS_LOADER, null, this);
        }

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
      * *
     */

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        CursorLoader loader;

        if (mType.equals(TYPE_FAVORITE_GOLF_FIELDS)){
            loader=new CursorLoader(getActivity(), ScorecardContract.GolfFieldEntry.buildAllGolfFieldsFavoriteUri(),null,null,null,null);

        }else{
            loader=new CursorLoader(getActivity(), ScorecardContract.GolfFieldEntry.buildAllGolfFieldsActiveUri(),null,null,null,null);

        }

        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if (data.getCount() > 0) {
            mError.setVisibility(View.GONE);
            mRecyclerViewGolfFields.setVisibility(View.VISIBLE);
        }else{
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
