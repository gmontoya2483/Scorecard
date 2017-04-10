package com.montoya.gabi.scorecard.model.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardContract {

    //Content provider fields
    public static final String CONTENT_AUTHORITY = "com.montoya.gabi.scorecard";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_GOLF_FIELD = "golf_field";
    public static final String PATH_GOLF_FIELD_HOLE = "golf_field_hole";
    public static final String PATH_SCORECARD = "scorecard";
    public static final String PATH_SCORECARD_HOLE = "scorecard_hole";



    public static final class GolfFieldEntry implements BaseColumns{


        // Table name
        public static final String TABLE_NAME = "golf_field";

        // Columns

        //TODO add the columns
        /*
        public static final String COULUMN_MOVIE_TITLE = "mov_title";
        public static final String COULUMN_MOVIE_IMAGE_THUMBNAIL = "mov_imageThumbnail";
        public static final String COULUMN_MOVIE_SYSNOPSIS = "mov_mov_sysnopsis";
        public static final String COULUMN_MOVIE_USER_RATING = "mov_userRating";
        public static final String COULUMN_MOVIE_RELEASE_DATE = "mov_releaseDate";
        */



        // Create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GOLF_FIELD)
                .build();

        // create cursor of base type directory for multiples entries
        public static final String CONTENT_DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD;

        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOLF_FIELD;


        //for building URIs on insertion
        public static Uri buildGolfFieldUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


        public static Uri buildAllGolfFieldsUri() {
            return CONTENT_URI;
        }


    }



    public static final class GolfFieldHoleEntry implements BaseColumns{

    }


    public static final class ScorecardEntry implements BaseColumns{

    }


    public static final class ScorecardHoleEntry implements BaseColumns{

    }






}
