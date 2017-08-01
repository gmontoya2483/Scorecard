package com.montoya.gabi.scorecard.model;

import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_1;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_12;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_13;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_16;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_17;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_18;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_2;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_3;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_4;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_5;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_6;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_7;
import static com.montoya.gabi.scorecard.model.Hole.HoleNumber.HOLE_9;

/**
 * Created by Gabriel on 15/04/2017.
 */

public abstract class Hole {

    public Hole() {

    }

    public static enum Par{
        PAR_3(3),PAR_4(4),PAR_5(5),PAR_NOT_DEFINED(0),PAR_INVALID(-1);
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
        HOLE_NOT_DEFINED(0),
        HOLE_INVALID (-1);
        private int value;

        private HoleNumber (int value){
            this.value=value;
        }

        public int getValue(){
            return this.value;
        }
    }

    public static Long INVALID_HOLE_ID=-1L;
    public static Long NOT_SAVED_HOLE_ID=0L; //Default id when the hole hasn't been saved into the Database
    public static int MAX_HOLE_LENGTH=650;
    public static int MIN_HOLE_LENGTH=10;
    public static int INVALID_HOLE_LENGTH=-1;
    public static int NOT_DEFINED_HOLE_LENGTH=0;
    public static int INVALID_HOLE_ARRAY_INDEX=-1;




    protected int number;
    protected int length;
    protected int par;



    public Hole(HoleNumber number, int length, Par par){
        this.number=number.getValue();
        setLength(length);
        this.par=par.getValue();
    }


    public HoleNumber getNumber() {
        return convertIntToHoleNumber(this.number);
    }

    public void setNumber(HoleNumber holeNumber) {
        this.number = holeNumber.getValue();
    }



    public int getLength() {
        return length;
    }

    public void setLength(int holeLength) {

        if (holeLength==NOT_DEFINED_HOLE_LENGTH) {
            this.length=NOT_DEFINED_HOLE_LENGTH;
        }else if (holeLength<MIN_HOLE_LENGTH){
            this.length=INVALID_HOLE_LENGTH;
        }else if(holeLength>MAX_HOLE_LENGTH){
            this.length=INVALID_HOLE_LENGTH;
        }else{
            this.length = holeLength;
        }


    }

    public Par getPar() {
        return convertIntToPar(this.par);
    }

    public void setPar(Par par) {
        this.par=par.getValue();
    }


    public static Par convertIntToPar (int number){

        Par par;
        switch (number){
            case 0:
                par=Par.PAR_NOT_DEFINED;
                break;
            case 3:
                par=Par.PAR_3;
                break;
            case 4:
                par=Par.PAR_4;
                break;
            case 5:
                par=Par.PAR_5;
                break;

            default:
                par=Par.PAR_INVALID;
                break;
        }

        return par;

    }



    public static HoleNumber convertIntToHoleNumber(int number){

        HoleNumber holeNumber;
        switch (number){
            case 0:
                holeNumber=HoleNumber.HOLE_NOT_DEFINED;
                break;
            case 1:
                holeNumber= HOLE_1;
                break;
            case 2:
                holeNumber= HOLE_2;
                break;
            case 3:
                holeNumber= HOLE_3;
                break;
            case 4:
                holeNumber= HOLE_4;
                break;
            case 5:
                holeNumber= HOLE_5;
                break;
            case 6:
                holeNumber= HOLE_6;
                break;
            case 7:
                holeNumber= HOLE_7;
                break;
            case 8:
                holeNumber=HoleNumber.HOLE_8;
                break;
            case 9:
                holeNumber= HOLE_9;
                break;
            case 10:
                holeNumber=HoleNumber.HOLE_10;
                break;
            case 11:
                holeNumber=HoleNumber.HOLE_11;
                break;
            case 12:
                holeNumber= HOLE_12;
                break;
            case 13:
                holeNumber= HOLE_13;
                break;
            case 14:
                holeNumber=HoleNumber.HOLE_14;
                break;
            case 15:
                holeNumber=HoleNumber.HOLE_15;
                break;
            case 16:
                holeNumber= HOLE_16;
                break;
            case 17:
                holeNumber= HOLE_17;
                break;
            case 18:
                holeNumber= HOLE_18;
                break;
            default:
                holeNumber=HoleNumber.HOLE_INVALID;
                break;

        }
        return holeNumber;


    }


    public static int convertHoleNumberToArrayIndex(HoleNumber holeNumber){

        int index;

        switch (holeNumber){
            case HOLE_1:
                index=0;
                break;
            case HOLE_2:
                index=1;
                break;
            case HOLE_3:
                index=2;
                break;
            case HOLE_4:
                index=3;
                break;
            case HOLE_5:
                index=4;
                break;
            case HOLE_6:
                index=5;
                break;
            case HOLE_7:
                index=6;
                break;
            case HOLE_8:
                index=7;
                break;
            case HOLE_9:
                index=8;
                break;
            case HOLE_10:
                index=9;
                break;
            case HOLE_11:
                index=10;
                break;
            case HOLE_12:
                index=11;
                break;
            case HOLE_13:
                index=12;
                break;
            case HOLE_14:
                index=13;
                break;
            case HOLE_15:
                index=14;
                break;
            case HOLE_16:
                index=15;
                break;
            case HOLE_17:
                index=16;
                break;
            case HOLE_18:
                index=17;
                break;
            default:
                index=INVALID_HOLE_ARRAY_INDEX;
                break;
        }


        return index;
    }



}
