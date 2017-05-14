package com.example.michael.smarthealth;

/**
 * Created by Michael on 5/14/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "smarthealth.db";
    //tables used
    public static final String TABLE_DM= "Decision_Matrix_Table";
    public static final String TABLE_G = "Gamification_Table";

    //column names
    public static final String KEY_ID = "id";

    //gamification specific columns
    public static final String LEVEL = "level";
    public static final String CURRENTEXP = "currentexp";
    public static final String MAXEXP = "maxexp";

    //decision matrix specific columns
    public static final String USERID = "user"; //INT
    public static final String TOTALSR = "totalSR"; //DOUBLE
    public static final String NUMTIMES = "numTimes"; // INT
    public static final String AVGSR = "avgSR"; //DOUBLE
    public static final String WEEKSR = "weekSR"; //DOUBLE
    public static final String WEEKNUMSUCCESS = "weekNumSuccess"; //INT
    public static final String SCORES = "scores"; //DOUBLE
    public static final String SUM = "sum"; //DOUBLE
    public static final String WEIGHTS = "weights"; //DOUBLE
    public static final String CURRENTSR = "currentSR"; //DOUBLE
    public static final String PREVIOUSREPS = "previousReps"; //INT
    public static final String CURRENTREPS = "currentReps"; //INT

    //Table Creation statements (sqlite statements to be executed with java functions)
    public static final String Create_Table_DM= "CREATE TABLE " + TABLE_DM + "(" + KEY_ID + "INTEGER PRIMARY KEY,"
            + LEVEL + " INTEGER," + CURRENTEXP + " INTEGER," + MAXEXP + " INTEGER" + ")";

    public static final String Create_Table_G = "CREATE TABLE " + TABLE_G + "(" + KEY_ID + "INTEGER PRIMARY KEY,"
            + USERID + " INTEGER," + TOTALSR + " DOUBLE," + NUMTIMES + " INTEGER," + AVGSR + " DOUBLE,"
            + WEEKSR + " DOUBLE,"  + WEEKNUMSUCCESS + " INTEGER,"  + SCORES + " DOUBLE," + SUM + " DOUBLE,"
            + WEIGHTS + " DOUBLE,"  + CURRENTSR + " DOUBLE,"  + PREVIOUSREPS + " INTEGER,"  + CURRENTREPS + " INTEGER," + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating required tables
        db.execSQL(Create_Table_DM);
        db.execSQL(Create_Table_G);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //on upgrade, drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_G );

        //Create database tables
        onCreate(db);
    }

    /*
    public boolean insertData(String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    } */
}
