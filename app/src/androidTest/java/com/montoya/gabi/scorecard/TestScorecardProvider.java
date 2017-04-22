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
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.Scorecard;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardProvider;

/**
 * Created by montoya on 14.04.2017.
 */

public class TestScorecardProvider extends AndroidTestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestUtils.deleteAllGolfFieldHoleRecords(mContext);
        TestUtils.deleteAllGolfFieldrecords(mContext);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        TestUtils.deleteAllGolfFieldHoleRecords(mContext);
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


        GolfField golfField=new GolfField("Fake Golf Field Name", ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        ContentValues contentValues=golfField.getGolfFieldValues();

        insertedGFUri=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),contentValues);

        //Verify that the returned uri is not null
        assertNotNull("The returned URI is null",insertedGFUri);



        if(null!=insertedGFUri){

            golfField.set_id(ContentUris.parseId(insertedGFUri));


            //Verify the GolfFielf_WITH_ID matcher
            assertEquals("Error: Golf field  by ID URI was matched incorrectly.",testMatcher.match(insertedGFUri), ScorecardProvider.GOLF_FIELD_WITH_ID);

            Cursor cursor=mContext.getContentResolver().query(insertedGFUri,null,null,null,null);


            // Verify if the query got records
            assertEquals( "Error: There are more than 1 records in the query", cursor.getCount(),1 );


            TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,cursor);


        }else{
            fail("the returned iserted URI was null");
        }

        TestUtils.deleteAllGolfFieldrecords(mContext);

    }


    public void testQueryAllGolfFields(){

        TestUtils.deleteAllGolfFieldrecords(mContext);

        GolfField golfField_1=new GolfField("Fake1",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
             golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        GolfField golfField_2=new GolfField("Fake2",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.FALSE);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }


        GolfField golfField_3=new GolfField("Fake3",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
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

        GolfField golfField_1=new GolfField("Fake1_Not_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        GolfField golfField_2=new GolfField("Fake2_Favorite",ScorecardContract.ScorecardBoolean.FALSE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }


        GolfField golfField_3=new GolfField("Fake3_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.FALSE);
        Uri golFieldUri_3=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_3.getGolfFieldValues());
        if (golFieldUri_3!=null){
            golfField_3.set_id(ContentUris.parseId(golFieldUri_3));
        }

        GolfField golfField_4=new GolfField("Fake4_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_4=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_4.getGolfFieldValues());
        if (golFieldUri_4!=null){
            golfField_4.set_id(ContentUris.parseId(golFieldUri_4));
        }

        Cursor cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsFavoriteUri(),null,null,null,null);

        // Verify if the query got records
        assertEquals( "Error: The quatity of retrived favorite golf fields records doens't match", 2,cursor.getCount() );

        TestUtils.deleteAllGolfFieldrecords(mContext);

    }



    public void testQueryAllGolfFieldsActive(){

        TestUtils.deleteAllGolfFieldrecords(mContext);

        GolfField golfField_1=new GolfField("Fake1_Not_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        GolfField golfField_2=new GolfField("Fake2_Favorite",ScorecardContract.ScorecardBoolean.FALSE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }


        GolfField golfField_3=new GolfField("Fake3_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.FALSE);
        Uri golFieldUri_3=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_3.getGolfFieldValues());
        if (golFieldUri_3!=null){
            golfField_3.set_id(ContentUris.parseId(golFieldUri_3));
        }


        GolfField golfField_4=new GolfField("Fake4_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_4=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_4.getGolfFieldValues());
        if (golFieldUri_4!=null){
            golfField_4.set_id(ContentUris.parseId(golFieldUri_4));
        }


        Cursor cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsActiveUri(),null,null,null,null);

        // Verify if the query got records
        assertEquals( "Error: The quatity of retrived Active golf fields records doens't match", 3,cursor.getCount() );


        TestUtils.deleteAllGolfFieldrecords(mContext);

    }

    public void testQueryGolfFieldHoleByID(){

        TestUtils.deleteAllGolfFieldHoleRecords(mContext);
        TestUtils.deleteAllGolfFieldrecords(mContext);


        GolfField golfField_1=new GolfField("Fake1_Not_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }

        GolfFieldHole golfFieldHole=new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_3,153, Hole.Par.PAR_3);
        Uri golfFieldHoleUri=mContext.getContentResolver().insert(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldHoleUri(),golfFieldHole.getGolfFieldHoleValues());
        if (golfFieldHoleUri!=null){
            golfFieldHole.set_id(ContentUris.parseId(golfFieldHoleUri));

            Cursor cursor=mContext.getContentResolver().query(golfFieldHoleUri,null,null,null,null);
            TestUtils.VerifyExpectedGolfFieldHoleQueryResult(golfFieldHole,cursor);

            cursor.close();


        }else{
            assertNotNull("Returned URI is NULL",golfFieldHoleUri);
        }

        TestUtils.deleteAllGolfFieldrecords(mContext);
        TestUtils.deleteAllGolfFieldHoleRecords(mContext);

    }

    public void testQueryAllGolfFieldsHolesByGolfField(){

        TestUtils.deleteAllGolfFieldHoleRecords(mContext);
        TestUtils.deleteAllGolfFieldrecords(mContext);


        GolfField golfField_1=new GolfField("Fake1_Not_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        GolfField golfField_2=new GolfField("Fake2_Favorite",ScorecardContract.ScorecardBoolean.FALSE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }



        GolfFieldHole golfFieldHole_1=new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_1,153, Hole.Par.PAR_3);
        Uri golfFieldHoleUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldHoleUri(),golfFieldHole_1.getGolfFieldHoleValues());
        if (golfFieldHoleUri_1!=null){
            golfFieldHole_1.set_id(ContentUris.parseId(golfFieldHoleUri_1));
        }

        GolfFieldHole golfFieldHole_2=new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_2,253, Hole.Par.PAR_4);
        Uri golfFieldHoleUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldHoleUri(),golfFieldHole_2.getGolfFieldHoleValues());
        if (golfFieldHoleUri_2!=null){
            golfFieldHole_2.set_id(ContentUris.parseId(golfFieldHoleUri_2));
        }

        GolfFieldHole golfFieldHole_3=new GolfFieldHole(golfField_2.get_id(), Hole.HoleNumber.HOLE_1,350, Hole.Par.PAR_5);
        Uri golfFieldHoleUri_3=mContext.getContentResolver().insert(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldHoleUri(),golfFieldHole_3.getGolfFieldHoleValues());
        if (golfFieldHoleUri_3!=null){
            golfFieldHole_3.set_id(ContentUris.parseId(golfFieldHoleUri_3));
        }


        Cursor cursor_1=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_1.get_id()),null,null,null,null);
        assertEquals( "Error: The quatity of retrived hole records doens't match", 2,cursor_1.getCount() );



        Cursor cursor_2=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_2.get_id()),null,null,null,null);
        assertEquals( "Error: The quatity of retrived hole records doens't match", 1,cursor_2.getCount() );

        cursor_1.close();
        cursor_2.close();
        TestUtils.deleteAllGolfFieldHoleRecords(mContext);
        TestUtils.deleteAllGolfFieldrecords(mContext);


    }


    public void testBulkInsertGolfFieldHoles(){

        TestUtils.deleteAllRecords(mContext);
        int qtyRecords;

        //Crear un GolfField
        GolfField golfField_1=new GolfField("Fake1_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }

        //Crear Array de GolfFieldHoles
        GolfFieldHole holes []=new GolfFieldHole[] {
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_1,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_2,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_3,153, Hole.Par.PAR_4),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_4,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_5,153, Hole.Par.PAR_5),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_6,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_7,153, Hole.Par.PAR_4),
                new GolfFieldHole(1987L, Hole.HoleNumber.HOLE_7,153, Hole.Par.PAR_4)
        };



        ContentValues holesValues []=GolfFieldHole.getHolesContentValues(holes);
        Uri allGolfFieldHolesUri= ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldHoleUri();


        qtyRecords=mContext.getContentResolver().bulkInsert(allGolfFieldHolesUri,holesValues);
        assertEquals("Error: The quatity of retrived hole records doens't match", 8,qtyRecords);


        Cursor cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_1.get_id()),null,null,null,null);
        assertEquals( "Error: The quatity of retrived hole records doens't match", 7,cursor.getCount() );


        cursor.close();

        TestUtils.deleteAllRecords(mContext);

    }




    public void testDeleteGolfField (){

        TestUtils.deleteAllRecords(mContext);
        int qtyRecords;


        //Crear un GolfField
        GolfField golfField_1=new GolfField("Fake1_Favorite1",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        //Crear un GolfField
        GolfField golfField_2=new GolfField("Fake1_Favorite2",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }


        Cursor cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
      // Verify if the query got records
        assertEquals( "Error: The quatity of retrive records doens't match", 2,cursor.getCount() );



        qtyRecords=mContext.getContentResolver().delete(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField_1.get_id()),null,null);
        assertEquals( "Error: The quatity of deleted records doens't match", 1,qtyRecords );


        cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        // Verify if the query got records
        assertEquals( "Error: The quatity of retrive records doens't match", 1,cursor.getCount() );


        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField_2,cursor);

        cursor.close();

        TestUtils.deleteAllRecords(mContext);

    }




    public void testDeleteGolfFieldHolesByGF(){

        TestUtils.deleteAllRecords(mContext);
        int qtyRecords;
        int qtyOfDeletedRecords;

        //Crear un GolfField
        GolfField golfField_1=new GolfField("Fake1_Favorite",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_1=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_1.getGolfFieldValues());
        if (golFieldUri_1!=null){
            golfField_1.set_id(ContentUris.parseId(golFieldUri_1));
        }


        //Crear un GolfField
        GolfField golfField_2=new GolfField("Fake1_Favorite2",ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        Uri golFieldUri_2=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),golfField_2.getGolfFieldValues());
        if (golFieldUri_2!=null){
            golfField_2.set_id(ContentUris.parseId(golFieldUri_2));
        }



        //Crear Array de GolfFieldHoles
        GolfFieldHole holes []=new GolfFieldHole[] {
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_1,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_2,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_3,153, Hole.Par.PAR_4),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_4,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_5,153, Hole.Par.PAR_5),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_6,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_1.get_id(), Hole.HoleNumber.HOLE_7,153, Hole.Par.PAR_4),
                new GolfFieldHole(golfField_2.get_id(), Hole.HoleNumber.HOLE_1,153, Hole.Par.PAR_4),
                new GolfFieldHole(golfField_2.get_id(), Hole.HoleNumber.HOLE_3,153, Hole.Par.PAR_4),
                new GolfFieldHole(golfField_2.get_id(), Hole.HoleNumber.HOLE_4,153, Hole.Par.PAR_3),
                new GolfFieldHole(golfField_2.get_id(), Hole.HoleNumber.HOLE_5,153, Hole.Par.PAR_5)
        };



        ContentValues holesValues []=GolfFieldHole.getHolesContentValues(holes);
        Uri allGolfFieldHolesUri= ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldHoleUri();


        qtyRecords=mContext.getContentResolver().bulkInsert(allGolfFieldHolesUri,holesValues);
        assertEquals("Error: The quatity of retrived hole records doens't match", 11,qtyRecords);


        Cursor cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_1.get_id()),null,null,null,null);
        assertEquals( "Error: The quatity of retrived hole records for the GF 1 doens't match" , 7,cursor.getCount() );

        cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_2.get_id()),null,null,null,null);
        assertEquals( "Error: The quatity of retrived hole records for the GF 2 doens't match" , 4,cursor.getCount() );



        qtyOfDeletedRecords=mContext.getContentResolver().delete(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_2.get_id()),null,null);
        assertEquals( "Error: The quatity of deleted hole records for the GF 2 doens't match" , 4, qtyOfDeletedRecords );

        cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_2.get_id()),null,null,null,null);
        assertEquals( "Error: The quatity of retrived hole records for the GF 2 doens't match" , 0,cursor.getCount() );

        cursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField_1.get_id()),null,null,null,null);
        assertEquals( "Error: The quatity of retrived hole records for the GF 1 doens't match" , 7,cursor.getCount() );


        cursor.close();

        TestUtils.deleteAllRecords(mContext);

    }




















}
