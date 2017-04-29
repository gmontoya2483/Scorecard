package com.montoya.gabi.scorecard.model;

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

    protected int number;
    protected int length;
    protected int par;



    public Hole(HoleNumber number, int length, Par par){
        this.number=number.getValue();
        this.length=length;
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
        this.length = holeLength;
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
                holeNumber=HoleNumber.HOLE_1;
                break;
            case 2:
                holeNumber=HoleNumber.HOLE_2;
                break;
            case 3:
                holeNumber=HoleNumber.HOLE_3;
                break;
            case 4:
                holeNumber=HoleNumber.HOLE_4;
                break;
            case 5:
                holeNumber=HoleNumber.HOLE_5;
                break;
            case 6:
                holeNumber=HoleNumber.HOLE_6;
                break;
            case 7:
                holeNumber=HoleNumber.HOLE_7;
                break;
            case 8:
                holeNumber=HoleNumber.HOLE_8;
                break;
            case 9:
                holeNumber=HoleNumber.HOLE_9;
                break;
            case 10:
                holeNumber=HoleNumber.HOLE_10;
                break;
            case 11:
                holeNumber=HoleNumber.HOLE_11;
                break;
            case 12:
                holeNumber=HoleNumber.HOLE_12;
                break;
            case 13:
                holeNumber=HoleNumber.HOLE_13;
                break;
            case 14:
                holeNumber=HoleNumber.HOLE_14;
                break;
            case 15:
                holeNumber=HoleNumber.HOLE_15;
                break;
            case 16:
                holeNumber=HoleNumber.HOLE_16;
                break;
            case 17:
                holeNumber=HoleNumber.HOLE_17;
                break;
            case 18:
                holeNumber=HoleNumber.HOLE_18;
                break;
            default:
                holeNumber=HoleNumber.HOLE_INVALID;
                break;

        }
        return holeNumber;


    }



}
