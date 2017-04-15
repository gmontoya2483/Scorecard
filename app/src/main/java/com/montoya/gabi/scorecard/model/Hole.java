package com.montoya.gabi.scorecard.model;

/**
 * Created by Gabriel on 15/04/2017.
 */

public abstract class Hole {

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



    protected HoleNumber number;
    protected int length;
    protected Par par;



    public Hole(HoleNumber number, int length, Par par){
        this.number=number;
        this.length=length;
        this.par=par;
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



}
