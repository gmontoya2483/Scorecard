package com.montoya.gabi.scorecard.model;

/**
 * Created by montoya on 13.04.2017.
 */

public class GolfFieldHole {

    public static int PAR_3=3;
    public static int PAR_4=4;
    public static int PAR_5=5;
    public static int PAR_ERROR=0;



    private long _id;
    private long golfField_id;
    private int holeNumber;
    private int holeLength;
    private ScorecardUtil.Par par;


    public GolfFieldHole(long golfField_id, int holeNumber, int holeLength, ScorecardUtil.Par par) {
        this.golfField_id = golfField_id;
        setHoleNumber(holeNumber);
        this.holeLength = holeLength;
        this.par = par;
    }

    public long get_id() {
        return _id;
    }


    public long getGolfField_id() {
        return golfField_id;
    }

    public void setGolfField_id(long golfField_id) {
        this.golfField_id = golfField_id;
    }

    public int getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(int holeNumber) {

        if (holeNumber>0 && holeNumber<=18)
        {
            this.holeNumber = holeNumber;
        }else{
            this.holeNumber=0;
        }
    }



    public int getHoleLength() {
        return holeLength;
    }

    public void setHoleLength(int holeLength) {
        this.holeLength = holeLength;
    }

    public ScorecardUtil.Par getPar() {
        return par;
    }

    public void setPar(ScorecardUtil.Par par) {
           this.par=par;
    }
}
