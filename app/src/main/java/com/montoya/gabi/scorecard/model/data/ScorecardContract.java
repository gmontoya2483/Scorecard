package com.montoya.gabi.scorecard.model.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;

import static com.montoya.gabi.scorecard.model.GolfField.NOT_SAVED_GOLF_FIELD_ID;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardContract {


    public static enum ScorecardBoolean{
        TRUE(1),FALSE(0);
        private int value;

        private ScorecardBoolean (int value){
            this.value=value;
        }


        public int getValue(){
            return this.value;
        }
    }





    //Content provider fields
    public static final String CONTENT_AUTHORITY = "com.montoya.gabi.scorecard";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    //Content provider Paths
    public static final String PATH_GOLF_FIELD = "golf_field";
    public static final String PATH_GOLF_FIELD_FAVORITE = "golf_field_favorite";
    public static final String PATH_GOLF_FIELD_ACTIVE = "golf_field_active";

    public static final String PATH_GOLF_FIELD_HOLE = "golf_field_hole";
    public static final String PATH_GOLF_FIELD_HOLE_FIELD = "golf_field_hole_field";

    public static final String PATH_SCORECARD = "scorecard";
    public static final String PATH_SCORECARD_GOLF_FIELD = "scorecard_golf_field";
    public static final String PATH_SCORECARD_BEST_GROSS_DIF = "scorecard_best_gross_dif";
    public static final String PATH_SCORECARD_BEST_NET_DIF = "scorecard_best_net_dif";

    public static final String PATH_SCORECARD_HOLE = "scorecard_hole";
    public static final String PATH_SCORECARD_HOLE_FIELD = "scorecard_hole_field";



    public static final class GolfFieldEntry implements BaseColumns{


        // Table name
        public static final String TABLE_NAME = "golf_field";

        // Columns
        public static final String COLUMN_GOLF_FIELD_NAME = "gf_name";
        public static final String COLUMN_GOLF_FIELD_FAVORITE = "gf_favorite";
        public static final String COLUMN_GOLF_FIELD_ACTIVE = "gf_active";



        // Create content uri for the golf fields
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD)
                .build();

        // Create content uri for the favorite golf fields
        public static final Uri CONTENT_URI_FAVORITE = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD_FAVORITE)
                .build();

        // Create content uri for the favorite golf fields
        public static final Uri CONTENT_URI_ACTIVE = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD_ACTIVE)
                .build();


        // create cursor of base type directory for multiples entries (Golf fields)
        public static final String CONTENT_DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD;

        // create cursor of base type item for single entry (single golf field)
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD;

        // create cursor of base type directory for multiples entries (Golf fields)
        public static final String CONTENT_DIR_TYPE_ACTIVE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD_ACTIVE;


        // create cursor of base type directory for multiple entry (favorite golf fields)
        public static final String CONTENT_DIR_TYPE_FAVORITE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD_FAVORITE;


        //for building URIs on insertion
        public static Uri buildGolfFieldByIdUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


        public static Uri buildAllGolfFieldsUri() {
            return CONTENT_URI;
        }

        public static Uri buildAllGolfFieldsActiveUri() {
            return CONTENT_URI_ACTIVE;
        }


        public static Uri buildAllGolfFieldsFavoriteUri() {
            return CONTENT_URI_FAVORITE;
        }


    }



    public static final class GolfFieldHoleEntry implements BaseColumns{


        // Table name
        public static final String TABLE_NAME = "golf_field_hole";

        // Columns
        public static final String COLUMN_GOLF_FIELD_HOLE_GF_ID = "gfH_gf_id";
        public static final String COLUMN_GOLF_FIELD_HOLE_NUMBER = "gfH_number";
        public static final String COLUMN_GOLF_FIELD_HOLE_LENGTH = "gfH_length";
        public static final String COLUMN_GOLF_FIELD_HOLE_PAR = "gfH_par";


        // Create content uri for the golf fields
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD_HOLE)
                .build();

        // Create content uri for the golf fields
        public static final Uri CONTENT_URI_FIELD = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD_HOLE_FIELD)
                .build();


        // create cursor of base type directory for multiples entries (Golf fields holes)
        public static final String CONTENT_DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD_HOLE;

        // create cursor of base type item for single entry (single hole)
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD_HOLE;


        // create cursor of base type directory for multiple entry (holes for an specific field)
        public static final String CONTENT_DIR_TYPE_FIELD = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD_HOLE_FIELD;



        //for building URIs on insertion
        public static Uri buildGolfFieldHoleByIdUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


        public static Uri buildAllGolfFieldHoleUri() {
            return CONTENT_URI;
        }


        public static Uri buildAllGolfFieldsHolesByFieldUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI_FIELD, id);
        }

   }


    public static final class ScorecardEntry implements BaseColumns{

        private static final String LOG_TAG= GolfFieldEntry.class.getSimpleName();


        // Table name
        public static final String TABLE_NAME = "Scorecard";

        // Columns
        public static final String COLUMN_SCORECARD_GF_ID = "scorecard_gf_id";
        public static final String COLUMN_SCORECARD_GF_NAME = "scorecard_gf_name";
        public static final String COLUMN_SCORECARD_GF_TOTAL_LENGTH = "scorecard_gf_total_length";
        public static final String COLUMN_SCORECARD_GF_TOTAL_PAR = "scorecard_gf_total_par";
        public static final String COLUMN_SCORECARD_GF_OUT_LENGTH = "scorecard_gf_out_length";
        public static final String COLUMN_SCORECARD_GF_OUT_PAR = "scorecard_gf_out_par";
        public static final String COLUMN_SCORECARD_GF_IN_LENGTH = "scorecard_gf_in_length";
        public static final String COLUMN_SCORECARD_GF_IN_PAR = "scorecard_gf_in_par";

        public static final String COLUMN_SCORECARD_DATE="scorecard_date";
        public static final String COLUMN_SCORECARD_HANDICAP="scorecard_handicap";

        public static final String COLUMN_SCORECARD_OUT_SCORE="scorecard_out_score";
        public static final String COLUMN_SCORECARD_OUT_DIF="scorecard_out_dif";
        public static final String COLUMN_SCORECARD_IN_SCORE="scorecard_in_score";
        public static final String COLUMN_SCORECARD_IN_DIF="scorecard_in_dif";
        public static final String COLUMN_SCORECARD_GROSS_SCORE="scorecard_gross_score";
        public static final String COLUMN_SCORECARD_GROSS_DIF="scorecard_gross_dif";
        public static final String COLUMN_SCORECARD_NET_SCORE="scorecard_net_score";
        public static final String COLUMN_SCORECARD_NET_DIF="scorecard_net_dif";


        //Alias
        public static final String ALIAS_SCORECARD_BEST_GROSS_DIF="scorecard_best_gross_dif";
        public static final String ALIAS_SCORECARD_BEST_NET_DIF="scorecard_best_net_dif";




        // Create content uri for the scorecard
        private static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_SCORECARD)
                .build();

        // Create content uri for the scorecard
        private static final Uri CONTENT_URI_WITH_GOLF_FIELD_ID = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_SCORECARD_GOLF_FIELD)
                .build();


        // Create content uri for the scorecard_gross
        private static final Uri CONTENT_URI_BEST_GROSS_DIF = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_SCORECARD_BEST_GROSS_DIF)
                .build();

        // Create content uri for the scorecard_net
        private static final Uri CONTENT_URI_BEST_NET_DIF = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_SCORECARD_BEST_NET_DIF)
                .build();

        // create cursor of base type directory for multiples entries (scorecards)
        public static final String CONTENT_DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD;
        // create cursor of base type item for single entry (scorecard)
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD;
        // create cursor of base type directory for multiples entries (scorecards by golf field)
        public static final String CONTENT_DIR_TYPE_GOLF_FIELD = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_GOLF_FIELD;


        // create cursor of base type item (scorecards_best_gross)
        public static final String CONTENT_ITEM_TYPE_BEST_GROSS_DIF = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_BEST_GROSS_DIF;
        public static final String CONTENT_ITEM_TYPE_BEST_GROSS_DIF_GOLF_FIELD = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_BEST_GROSS_DIF;


        // create cursor of base type item (scorecards_best_net)
        public static final String CONTENT_ITEM_TYPE_BEST_NET_DIF = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_BEST_NET_DIF;
        public static final String CONTENT_ITEM_TYPE_BEST_NET_DIF_GOLF_FIELD = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_BEST_NET_DIF;





        //Build the Uris

        public static Uri buildAllScoreCardUri() {
            return CONTENT_URI;
        }

        public static Uri buildScoreCardByIdUri(long ScorecardId) {
            return ContentUris.withAppendedId(CONTENT_URI, ScorecardId);
        }

        public static Uri buildScoreCardByGolfFieldIdUri(long GolfFieldId) {
            return ContentUris.withAppendedId(CONTENT_URI_WITH_GOLF_FIELD_ID, GolfFieldId);
        }


        public static Uri buildScoreCardBestGrossDifUri() {
            return CONTENT_URI_BEST_GROSS_DIF;
        }

        public static Uri buildScoreCardBestGrossDifByGolfFieldIdUri(long GolfFieldId) {
            return ContentUris.withAppendedId(CONTENT_URI_BEST_GROSS_DIF, GolfFieldId);
        }


        public static Uri buildScoreCardBestNetDifUri() {
            return CONTENT_URI_BEST_NET_DIF;
        }


        public static Uri buildScoreCardBestNetDifByGolfFieldIdUri(long GolfFieldId) {
            return ContentUris.withAppendedId(CONTENT_URI_BEST_NET_DIF, GolfFieldId);
        }



    }


    public static final class ScorecardHoleEntry implements BaseColumns{

        // Table name
        public static final String TABLE_NAME = "Scorecard_hole";

        // Columns
        public static final String COLUMN_SCORECARD_HOLE_SC_ID = "scorecard_hole_sc_id";
        public static final String COLUMN_SCORECARD_HOLE_NUMBER = "scorecard_hole_number";
        public static final String COLUMN_SCORECARD_HOLE_LENGTH = "scorecard_hole_length";
        public static final String COLUMN_SCORECARD_HOLE_PAR = "scorecard_hole_par";
        public static final String COLUMN_SCORECARD_HOLE_SCORE = "scorecard_hole_score";
        public static final String COLUMN_SCORECARD_HOLE_DIF = "scorecard_hole_dif";


        // Create content uri for the scorecard holes
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_SCORECARD_HOLE)
                .build();

        // Create content uri for the scorecards holes by golf field
        public static final Uri CONTENT_URI_FIELD = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_SCORECARD_HOLE_FIELD)
                .build();


        // create cursor of base type directory for multiples entries (Golf fields holes)
        public static final String CONTENT_DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_HOLE;

        // create cursor of base type item for single entry (single hole)
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_HOLE;


        // create cursor of base type directory for multiple entry (holes for an specific field)
        public static final String CONTENT_DIR_TYPE_FIELD = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCORECARD_HOLE_FIELD;



        //for building URIs on insertion
        public static Uri buildScorecardHoleByIdUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


        public static Uri buildAllScorecardHoleUri() {
            return CONTENT_URI;
        }


        public static Uri buildAllScorecardHolesByGolfFieldUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI_FIELD, id);
        }







    }






}
