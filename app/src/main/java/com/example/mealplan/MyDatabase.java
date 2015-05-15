package com.example.mealplan;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.HashMap;
import java.util.Random;

public class MyDatabase extends SQLiteAssetHelper  implements MainActivity.Callbacks {
    Boolean done = false;

    String dUser;
    int Calories;
    int Day;

	private static final String DATABASE_NAME = "Schedule4";
	private static final int DATABASE_VERSION = 1;


    public MyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);



	}

    @Override
    public void TransferProfile(String user, String calintake, String workperweek) {
        dUser = user;
        Calories = Integer.parseInt(calintake);
        Day = Integer.parseInt(workperweek);
    }

    public Cursor getUser()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables("Users");
        String sqlTables = "Users";
        String [] sqlProject = {"0 _id", "userName"};
        insertUser(sqlTables, dUser);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);
        c.moveToFirst();
        return c;
    }

    public Cursor getSchedule() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs", "fType"};
        String sqlTables = "Schedule";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getMeal_1_day1() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "fstMeal_1";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);
        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null, null, null, null);
        c.moveToFirst();
        mCursor.close();
        return c;
    }

    public Cursor getMeal_2_day1() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "sndMeal_1";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_3_day1() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "trdMeal_1";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_1_day2() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "fstMeal_2";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_2_day2() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "sndMeal_2";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_3_day2() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "trdMeal_2";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_1_day4() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "fstMeal_4";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_2_day4() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "sndMeal_4";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_3_day4() {


        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "trdMeal_4";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);


        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_1_day5() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "fstMeal_5";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}


        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_2_day5() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "sndMeal_5";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_3_day5() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "trdMeal_5";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_1_day6() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "fstMeal_6";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_2_day6() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "sndMeal_6";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_3_day6() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "trdMeal_6";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_1_day7() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "fstMeal_7";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_2_day7() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "sndMeal_7";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_3_day7() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "trdMeal_7";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_1_day3() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "fstMeal_3";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_2_day3() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "sndMeal_3";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getMeal_3_day3() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "fName", "Calories", "Protein", "Carbs"};
        String sqlTables = "trdMeal_3";
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if(mCursor.getCount() == 0) {
            while(!done) {
                getMeat(sqlTables);
                getFruit(sqlTables);
                getVegetable(sqlTables);
                getDairy(sqlTables);
                getNut(sqlTables);
            }
            done = false;
        }
        else {}

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getAllWorkout() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "wName", "wType", "Equipment", "Description"};
        String sqlTables = "Allworkout";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getWorkout_day1() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlProject = {"0 _id", "wName_1", "wType_1", "Equipment_1"};
        String sqlTables = "WorkoutDay_1";
        int day = 1;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getWorkout_day2() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlProject = {"0 _id", "wName_2", "wType_2", "Equipment_2"};
        String sqlTables = "WorkoutDay_2";
        int day = 2;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if (Day == 3) {
            if (mCursor.getCount() == 0) {
                getChest(sqlTables, day);
                getTricep(sqlTables, day);
                getBack(sqlTables, day);
                getBicep(sqlTables, day);
                getLeg(sqlTables, day);
                getShoulder(sqlTables, day);
                getCardio(sqlTables, day);
            } else {
            }
        }
        else{
            if (mCursor.getCount() == 0) {
                getChest(sqlTables, day);
                getChest(sqlTables, day);
                getBack(sqlTables, day);
                getBack(sqlTables, day);
                getShoulder(sqlTables, day);
                getShoulder(sqlTables, day);
                getCardio(sqlTables, day);
            } else {
            }
        }
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getWorkout_day3() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "wName_3", "wType_3", "Equipment_3"};
        String sqlTables = "WorkoutDay_3";
        int day = 3;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if (Day == 4) {
        }
        else{
            if (mCursor.getCount() == 0) {
                getLeg(sqlTables, day);
                getLeg(sqlTables, day);
                getBicep(sqlTables, day);
                getBicep(sqlTables, day);
                getTricep(sqlTables, day);
                getTricep(sqlTables, day);
                getCardio(sqlTables, day);
            } else {
            }
        }
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getWorkout_day4() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlProject = {"0 _id", "wName_4", "wType_4", "Equipment_4"};
        String sqlTables = "WorkoutDay_4";
        int day = 4;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if (Day == 3) {
            if (mCursor.getCount() == 0) {
                getChest(sqlTables, day);
                getTricep(sqlTables, day);
                getBack(sqlTables, day);
                getBicep(sqlTables, day);
                getLeg(sqlTables, day);
                getCardio(sqlTables, day);
                getShoulder(sqlTables, day);
            } else {}
        }else{}
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getWorkout_day5() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] sqlProject = {"0 _id", "wName_5", "wType_5", "Equipment_5"};
        String sqlTables = "WorkoutDay_5";
        int day = 5;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if (Day == 4) {
        }
        else{
            if (mCursor.getCount() == 0) {
                getChest(sqlTables, day);
                getChest(sqlTables, day);
                getBack(sqlTables, day);
                getBack(sqlTables, day);
                getShoulder(sqlTables, day);
                getShoulder(sqlTables, day);
                getCardio(sqlTables, day);
            } else {
            }
        }
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getWorkout_day6() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlProject = {"0 _id", "wName_6", "wType_6", "Equipment_6"};
        String sqlTables = "WorkoutDay_6";
        int day = 6;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        if (Day == 3) {
            if (mCursor.getCount() == 0) {
                getChest(sqlTables, day);
                getTricep(sqlTables, day);
                getBack(sqlTables, day);
                getBicep(sqlTables, day);
                getLeg(sqlTables, day);
                getCardio(sqlTables, day);
                getShoulder(sqlTables, day);
            } else {
            }
        }
        else{
            if (mCursor.getCount() == 0) {
                getLeg(sqlTables, day);
                getLeg(sqlTables, day);
                getBicep(sqlTables, day);
                getBicep(sqlTables, day);
                getTricep(sqlTables, day);
                getTricep(sqlTables, day);
                getCardio(sqlTables, day);
            } else {
            }
        }
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;

    }

    public Cursor getWorkout_day7() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlProject = {"0 _id", "wName_7", "wType_7", "Equipment_7"};
        String sqlTables = "WorkoutDay_7";
        int day = 7;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + sqlTables, null);

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlProject, null, null,
                null, null, null);

        c.moveToFirst();
        mCursor.close();
        return c;
    }

    public void getMeat(String mTables) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(31 - 21) + 21;
        db.execSQL("INSERT INTO " + mTables + " (fName, Calories, Protein, Carbs) SELECT fName, Calories, Protein, Carbs FROM Schedule WHERE ScheduleID = " + mRand );
        Cursor c = db.rawQuery("SELECT SUM(Calories) FROM " + mTables, null);
        c.moveToFirst();
        String Caltemp = c.getString(0);
        int cal = Integer.parseInt(Caltemp);
        if (cal >= Calories)
        {
            done = true;
        }
        else
        {
            done = false;
        }
        c.close();
    }

    public void getFruit(String mTables) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(11 - 1) + 1;
        db.execSQL("INSERT INTO " + mTables + " (fName, Calories, Protein, Carbs) SELECT fName, Calories, Protein, Carbs FROM Schedule WHERE ScheduleID = " + mRand );
        Cursor c = db.rawQuery("SELECT SUM(Calories) FROM " + mTables, null);
        c.moveToFirst();
        String Caltemp = c.getString(0);
        int cal = Integer.parseInt(Caltemp);
        if (cal >= Calories)
        {
            done = true;
        }
        else
        {
            done = false;
        }
        c.close();
    }

    public void getVegetable(String mTables) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(21 - 11) + 11;
        db.execSQL("INSERT INTO " + mTables + " (fName, Calories, Protein, Carbs) SELECT fName, Calories, Protein, Carbs FROM Schedule WHERE ScheduleID = " + mRand );
        Cursor c = db.rawQuery("SELECT SUM(Calories) FROM " + mTables, null);
        c.moveToFirst();
        String Caltemp = c.getString(0);
        int cal = Integer.parseInt(Caltemp);
        if (cal >= Calories)
        {
            done = true;
        }
        else
        {
            done = false;
        }
        c.close();
    }

    public void getDairy(String mTables) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(41 - 31) + 31;
        db.execSQL("INSERT INTO " + mTables + " (fName, Calories, Protein, Carbs) SELECT fName, Calories, Protein, Carbs FROM Schedule WHERE ScheduleID = " + mRand );
        Cursor c = db.rawQuery("SELECT SUM(Calories) FROM " + mTables, null);
        c.moveToFirst();
        String Caltemp = c.getString(0);
        int cal = Integer.parseInt(Caltemp);
        if (cal >= Calories)
        {
            done = true;
        }
        else
        {
            done = false;
        }
        c.close();
    }

    public void getNut(String mTables) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(51 - 41) + 41;
        db.execSQL("INSERT INTO " + mTables + " (fName, Calories, Protein, Carbs) SELECT fName, Calories, Protein, Carbs FROM Schedule WHERE ScheduleID = " + mRand );
        Cursor c = db.rawQuery("SELECT SUM(Calories) FROM " + mTables, null);
        c.moveToFirst();
        String Caltemp = c.getString(0);
        int cal = Integer.parseInt(Caltemp);
        if (cal >= Calories)
        {
            done = true;
        }
        else
        {
            done = false;
        }
        c.close();
    }

    public void getChest(String mTables, int day) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(6 - 3) + 3;
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE WorkoutID = " + mRand );

    }

    public void getBicep(String mTables, int day) {
        SQLiteDatabase db = getReadableDatabase();
        int mRand = 1;
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE WorkoutID = " + mRand );

    }

    public void getTricep(String mTables, int day) {
        SQLiteDatabase db = getReadableDatabase();
        int mRand = 2;
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE WorkoutID = " + mRand );

    }

    public void getShoulder(String mTables, int day) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(15 - 13) + 13;
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE WorkoutID = " + mRand );

    }

    public void getLeg(String mTables, int day) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(12 - 10) + 10;
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE WorkoutID = " + mRand );

    }

    public void getBack(String mTables, int day) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(18 - 16) + 16;
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE WorkoutID = " + mRand );

    }

    public void getCardio(String mTables, int day) {
        SQLiteDatabase db = getReadableDatabase();
        Random r = new Random();
        int mRand = r.nextInt(21 - 19) + 19;
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE WorkoutID = " + mRand );

    }

    public void insertUser(String mTables, String uName) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO " + mTables + " (userID, userName) VALUES (1, '" + uName + "')" );
    }

    public int isFull(String mTables) {
        int full;
        SQLiteDatabase db = getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + mTables, null);
        if (mCursor.getCount() == 0) {
            full = 0;
        } else {
            full = 1;
        }
        return full;
    }

    public void insertRecord(String mTables, int day, int position) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO " + mTables + " (wName_" + day + ", wType_" + day + ", Equipment_" + day + ") SELECT wName, wType, Equipment FROM Allworkout WHERE _id = " + position );

    }

    public void insertFood(String mTables, int position) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO " + mTables + " (fName, Calories, Protein, Carbs) SELECT fName, Calories, Protein, Carbs FROM Schedule WHERE ScheduleID = " + position );
    }

    public void deleteRecord(String mTables, int position) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("DELETE FROM " + mTables + "  WHERE '0 _id' = " + position );

    }


}
