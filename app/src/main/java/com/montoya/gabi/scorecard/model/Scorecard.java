package com.montoya.gabi.scorecard.model;

import android.content.ContentValues;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;

import java.util.Date;

/**
 * Created by montoya on 10.04.2017.
 */

public class Scorecard {

    private long _id;
    private long date;
    private int handicap;

    private long golfField_id;
    private String golfFieldName;
    private int golfFieldTotalLength;
    private int golfFieldTotalPar;
    private int golfFieldOutLength;
    private int golfFieldOutPar;
    private int golfFieldInLength;
    private int golfFieldInPar;

    private int outScore;
    private int outDif;
    private int inScore;
    private int inDif;
    private int grossScore;
    private int grossDif;
    private int netScore;
    private int netDif;


    public Scorecard(long date, int handicap, long golfField_id, String golfFieldName, int golfFieldTotalLength, int golfFieldTotalPar, int golfFieldOutLength, int golfFieldOutPar, int golfFieldInLength, int golfFieldInPar, int outScore, int outDif, int inScore, int inDif, int grossScore, int grossDif, int netScore, int netDif) {
        this.date = date;
        this.handicap = handicap;
        this.golfField_id = golfField_id;
        this.golfFieldName = golfFieldName;
        this.golfFieldTotalLength = golfFieldTotalLength;
        this.golfFieldTotalPar = golfFieldTotalPar;
        this.golfFieldOutLength = golfFieldOutLength;
        this.golfFieldOutPar = golfFieldOutPar;
        this.golfFieldInLength = golfFieldInLength;
        this.golfFieldInPar = golfFieldInPar;
        this.outScore = outScore;
        this.outDif = outDif;
        this.inScore = inScore;
        this.inDif = inDif;
        this.grossScore = grossScore;
        this.grossDif = grossDif;
        this.netScore = netScore;
        this.netDif = netDif;
    }


    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public long getGolfField_id() {
        return golfField_id;
    }

    public void setGolfField_id(long golfField_id) {
        this.golfField_id = golfField_id;
    }

    public String getGolfFieldName() {
        return golfFieldName;
    }

    public void setGolfFieldName(String golfFieldName) {
        this.golfFieldName = golfFieldName;
    }

    public int getGolfFieldTotalLength() {
        return golfFieldTotalLength;
    }

    public void setGolfFieldTotalLength(int golfFieldTotalLength) {
        this.golfFieldTotalLength = golfFieldTotalLength;
    }

    public int getGolfFieldTotalPar() {
        return golfFieldTotalPar;
    }

    public void setGolfFieldTotalPar(int golfFieldTotalPar) {
        this.golfFieldTotalPar = golfFieldTotalPar;
    }

    public int getGolfFieldOutLength() {
        return golfFieldOutLength;
    }

    public void setGolfFieldOutLength(int golfFieldOutLength) {
        this.golfFieldOutLength = golfFieldOutLength;
    }

    public int getGolfFieldOutPar() {
        return golfFieldOutPar;
    }

    public void setGolfFieldOutPar(int golfFieldOutPar) {
        this.golfFieldOutPar = golfFieldOutPar;
    }

    public int getGolfFieldInLength() {
        return golfFieldInLength;
    }

    public void setGolfFieldInLength(int golfFieldInLength) {
        this.golfFieldInLength = golfFieldInLength;
    }

    public int getGolfFieldInPar() {
        return golfFieldInPar;
    }

    public void setGolfFieldInPar(int golfFieldInPar) {
        this.golfFieldInPar = golfFieldInPar;
    }

    public int getOutScore() {
        return outScore;
    }

    public void setOutScore(int outScore) {
        this.outScore = outScore;
    }

    public int getOutDif() {
        return outDif;
    }

    public void setOutDif(int outDif) {
        this.outDif = outDif;
    }

    public int getInScore() {
        return inScore;
    }

    public void setInScore(int inScore) {
        this.inScore = inScore;
    }

    public int getInDif() {
        return inDif;
    }

    public void setInDif(int inDif) {
        this.inDif = inDif;
    }

    public int getGrossScore() {
        return grossScore;
    }

    public void setGrossScore(int grossScore) {
        this.grossScore = grossScore;
    }

    public int getGrossDif() {
        return grossDif;
    }

    public void setGrossDif(int grossDif) {
        this.grossDif = grossDif;
    }

    public int getNetScore() {
        return netScore;
    }

    public void setNetScore(int netScore) {
        this.netScore = netScore;
    }

    public int getNetDif() {
        return netDif;
    }

    public void setNetDif(int netDif) {
        this.netDif = netDif;
    }


    //Get the content values without the _ID
    public ContentValues getGolfFieldValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID,this.golfField_id);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME,this.golfFieldName);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_LENGTH,this.golfFieldTotalLength);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_PAR,this.golfFieldTotalPar);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_LENGTH,this.golfFieldOutLength);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_PAR,this.golfFieldOutPar);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_LENGTH,this.golfFieldInLength);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_PAR,this.golfFieldInPar);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_DATE,this.date);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_HANDICAP,this.handicap);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_SCORE,this.outScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_DIF,this.outDif);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_SCORE,this.inScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_DIF,this.inDif);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_SCORE,this.grossScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF,this.grossDif);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_SCORE,this.netScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF,this.netDif);

        return values;

    }




}
