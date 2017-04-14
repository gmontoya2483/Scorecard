package com.montoya.gabi.scorecard.model;

import android.content.ContentValues;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;

/**
 * Created by montoya on 13.04.2017.
 */

public class GolfFieldHole {



    public static enum Par{
        PAR_3(3),PAR_4(4),PAR_5(5),PAR_NOT_DEFINED(0);
        private int value;

        private Par (int value){
            this.value=value;
        }


        public int getValue(){
            return this.value;
        }
    }

    public static enum HoleNumber{
        HOLE_1(1),
        HOLE_2(2),
        HOLE_3(3),
        HOLE_4(4),
        HOLE_5(5),
        HOLE_6(6),
        HOLE_7(7),
        HOLE_8(8),
        HOLE_9(9),
        HOLE_10(10),
        HOLE_11(11),
        HOLE_12(12),
        HOLE_13(13),
        HOLE_14(14),
        HOLE_15(15),
        HOLE_16(16),
        HOLE_17(17),
        HOLE_18(18),
        HOLE_NOT_DEFINED(0);
        private int value;

        private HoleNumber (int value){
            this.value=value;
        }

        public int getValue(){
            return this.value;
        }
    }


    private long _id;
    private long golfField_id;
    private HoleNumber number;
    private int length;
    private Par par;


    public GolfFieldHole(long golfField_id, HoleNumber holeNumber, int holeLength, Par par) {
        this.golfField_id = golfField_id;
        this.number=holeNumber;
        this.length = holeLength;
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

    public HoleNumber getNumber() {
        return number;
    }

    public void setNumber(HoleNumber holeNumber) {
            this.number = holeNumber;
    }



    public int getLength() {
        return length;
    }

    public void setLength(int holeLength) {
        this.length = holeLength;
    }

    public Par getPar() {
        return par;
    }

    public void setPar(Par par) {
           this.par=par;
    }




    //Get the content values without the _ID
    public ContentValues getGolfFieldHoleValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID,golfField_id);
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_NUMBER,number.getValue());
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH,length);
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR,par.getValue());


        return values;

    }






}
