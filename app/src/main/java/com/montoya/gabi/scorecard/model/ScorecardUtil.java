package com.montoya.gabi.scorecard.model;

/**
 * Created by montoya on 13.04.2017.
 */

public class ScorecardUtil {


    public enum Par{
        PAR_3(3),PAR_4(4),PAR_5(5),PAR_ERROR(0);
        private int value;

        private Par (int value){
            this.value=value;
        }
    }


    public static int PAR_3=3;
    public static int PAR_4=4;
    public static int PAR_5=5;
    public static int PAR_ERROR=0;









}
