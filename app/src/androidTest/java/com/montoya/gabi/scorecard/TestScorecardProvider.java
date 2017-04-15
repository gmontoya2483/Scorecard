package com.montoya.gabi.scorecard;

import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardProvider;

/**
 * Created by montoya on 14.04.2017.
 */

public class TestScorecardProvider extends AndroidTestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
       TestUtils.deleteAllGolfFieldrecords(mContext);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        TestUtils.deleteAllGolfFieldrecords(mContext);
    }



    /*
         This test checks to make sure that the content provider is registered correctly.
         Students: Uncomment this test to make sure you've correctly registered the WeatherProvider.
      */
    public void testProviderRegistry() {
        PackageManager pm = mContext.getPackageManager();

        // We define the component name based on the package name from the context and the
        // WeatherProvider class.
        ComponentName componentName = new ComponentName(mContext.getPackageName(), ScorecardProvider.class.getName());
        try {
            // Fetch the provider info using the component name from the PackageManager
            // This throws an exception if the provider isn't registered.
            ProviderInfo providerInfo = pm.getProviderInfo(componentName, 0);

            // Make sure that the registered authority matches the authority from the Contract.
            assertEquals("Error: ScorecardProvider registered with authority: " + providerInfo.authority +
                            " instead of authority: " + ScorecardContract.CONTENT_AUTHORITY,
                    providerInfo.authority, ScorecardContract.CONTENT_AUTHORITY);
        } catch (PackageManager.NameNotFoundException e) {
            // I guess the provider isn't registered correctly.
            assertTrue("Error: ScorecardProvider not registered at " + mContext.getPackageName(),
                    false);
        }
    }




    public void testInsertGolfField (){

        Uri insertedGFUri=null;
        UriMatcher testMatcher= ScorecardProvider.buildUriMatcher();


        GolfField golfField=new GolfField("Fake Golf Field Name",ScorecardContract.TRUE_VALUE);
        ContentValues contentValues=golfField.getGolfFieldValues();

        insertedGFUri=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),contentValues);

        //Verify that the returned uri is not null
        assertNotNull("The returned URI is null",insertedGFUri);

        if(null!=insertedGFUri){


            //Verify the GolfFielf_WITH_ID matcher
            assertEquals("Error: Golf field  by ID URI was matched incorrectly.",testMatcher.match(insertedGFUri), ScorecardProvider.GOLF_FIELD_WITH_ID);

            Cursor cursor=mContext.getContentResolver().query(insertedGFUri,null,null,null,null);


            // Verify if the query got records
            assertEquals( "Error: There are more than 1 records in the query", 1,cursor.getCount() );


            TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,cursor);


        }else{
            fail("the returned iserted URI was null");
        }

        TestUtils.deleteAllGolfFieldrecords(mContext);

    }


    public void testQueryAllGolfFields(){

        TestUtils.deleteAllGolfFieldrecords(mContext);

        GolfField golfField_1=new GolfField("Fake1",0);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
             golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        GolfField golfField_2=new GolfField("Fake2",1);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }


        GolfField golfField_3=new GolfField("Fake3",1);
        Uri golFieldUri_3=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_3.getGolfFieldValues());
        if (golFieldUri_3!=null){
            golfField_3.set_id(ContentUris.parseId(golFieldUri_3));
        }


        Cursor cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);

        // Verify if the query got records
        assertEquals( "Error: The quatity of retrive records doens't match", 3,cursor.getCount() );


        TestUtils.deleteAllGolfFieldrecords(mContext);

    }


    public void testQueryAllGolfFieldsFavorites(){

        TestUtils.deleteAllGolfFieldrecords(mContext);

        GolfField golfField_1=new GolfField("Fake1_Not_Favorite",0);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        GolfField golfField_2=new GolfField("Fake2_Favorite",1);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }


        GolfField golfField_3=new GolfField("Fake3_Favorite",1);
        Uri golFieldUri_3=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_3.getGolfFieldValues());
        if (golFieldUri_3!=null){
            golfField_3.set_id(ContentUris.parseId(golFieldUri_3));
        }


        Cursor cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsFavoriteUri(),null,null,null,null);

        // Verify if the query got records
        assertEquals( "Error: The quatity of retrived favorite golf fields records doens't match", 2,cursor.getCount() );


        TestUtils.deleteAllGolfFieldrecords(mContext);

    }










}
