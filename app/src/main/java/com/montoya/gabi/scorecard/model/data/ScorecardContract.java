package com.montoya.gabi.scorecard.model.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardContract {

    //Boolean Constants
    public static final int TRUE_VALUE=1;
    public static final int FALSE_VALUE=0;


    //Content provider fields
    public static final String CONTENT_AUTHORITY = "com.montoya.gabi.scorecard";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    //Content provider Paths
    public static final String PATH_GOLF_FIELD = "golf_field";
    public static final String PATH_GOLF_FIELD_FAVORITE = "golf_field_favorite";

    public static final String PATH_GOLF_FIELD_HOLE = "golf_field_hole";
    public static final String PATH_GOLF_FIELD_HOLE_FIELD = "golf_field_hole-field";

    public static final String PATH_SCORECARD = "scorecard";
    public static final String PATH_SCORECARD_HOLE = "scorecard_hole";



    public static final class GolfFieldEntry implements BaseColumns{


        // Table name
        public static final String TABLE_NAME = "golf_field";

        // Columns
        public static final String COLUMN_GOLF_FIELD_NAME = "gf_name";
        public static final String COLUMN_GOLF_FIELD_FAVORITE = "gf_favorite";


        // Create content uri for the golf fields
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD)
                .build();

        // Create content uri for the favorite golf fields
        public static final Uri CONTENT_URI_FAVORITE = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD_FAVORITE)
                .build();

        // create cursor of base type directory for multiples entries (Golf fields)
        public static final String CONTENT_DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD;

        // create cursor of base type item for single entry (single golf field)
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD;


        // create cursor of base type directory for multiple entry (favorite golf fields)
        public static final String CONTENT_DIR_TYPE_FAVORITE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD_FAVORITE;


        //for building URIs on insertion
        public static Uri buildGolfFieldByIdUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


        public static Uri buildAllGolfFieldsUri() {
            return CONTENT_URI;
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

    }


    public static final class ScorecardHoleEntry implements BaseColumns{

    }






}
