package com.montoya.gabi.scorecard.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.montoya.gabi.scorecard.MainActivity;
import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.firebase.AdMobListener;
import com.montoya.gabi.scorecard.model.Player;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PlayerFragment extends Fragment {

    Player mPlayer;
    View mRootView;
    private MainActivity.PlayerInterface mPlayerInterface;

    @BindView(R.id.player_handicap_Edit_text)
    EditText mPlayerHandicapTextView;


    @BindView(R.id.player_save_button)
    Button mPlayerSaveButton;


    @BindView(R.id.adView)
    AdView mAdView;


    //Bind Events
    @OnClick(R.id.player_save_button)
    public void click(View view){
        int entered_handicap=Player.INVALID_HANDICAP;

        if (mPlayerHandicapTextView.length()>0){
            entered_handicap=Integer.parseInt(mPlayerHandicapTextView.getText().toString().trim());

            if(mPlayer.SetHandicap(getContext(),entered_handicap)!=Player.INVALID_HANDICAP){

                Toast.makeText(getContext(),String.format(getString(R.string.player_save_confirmation),entered_handicap),Toast.LENGTH_LONG).show();
                mPlayerInterface.setDefaultMenuItem();
         }else{
                Toast.makeText(getContext(),R.string.player_err_saving_handicap,Toast.LENGTH_LONG).show();
            }

        }else{

            Toast.makeText(getContext(),R.string.player_err_saving_handicap,Toast.LENGTH_LONG).show();
        }


        mPlayerHandicapTextView.setSelection(mPlayerHandicapTextView.length(),mPlayerHandicapTextView.length()); //Move the cursor to the last position

    }



    private OnFragmentInteractionListener mListener;

    public PlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView= inflater.inflate(R.layout.fragment_player, container, false);

        //Bind the View
        ButterKnife.bind(this,mRootView);

        mPlayer=new Player();
        setupCurrentHandicap();


        showAdBanner();

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


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

        super.onViewStateRestored(savedInstanceState);


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

    private void setupCurrentHandicap(){
        int current_handicap=mPlayer.getHandicap(getContext());

        if (current_handicap==Player.INVALID_HANDICAP){

            mPlayerHandicapTextView.setText(null);
            mPlayerHandicapTextView.setContentDescription(getString(R.string.a11y_current_handicap_empty));


        }else{
            mPlayerHandicapTextView.setText(String.valueOf(current_handicap));
            mPlayerHandicapTextView.setContentDescription(String.format(getString(R.string.a11y_current_handicap),current_handicap));

        }

        mPlayerHandicapTextView.setSelection(mPlayerHandicapTextView.length(),mPlayerHandicapTextView.length()); //Move the cursor to the last position

    }



    private void showAdBanner(){

        mAdView.setAdListener(new AdMobListener(getContext()));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }


    //Interface to return a value to the main activity
    public void setPlayerInterface(MainActivity.PlayerInterface mInterface) {
        this.mPlayerInterface = mInterface;
    }





}
