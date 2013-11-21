package com.mobileappdev.wayfinder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BuildingDbHelper  extends SQLiteOpenHelper {

	  public static final String TABLE = "buildings";
	  public static final String COLUMN_ID = "_id";
	  public static final String COLUMN_HASH_CODE = "building_name_hash_code_index";
	  public static final String COLUMN_BUILDING_NAME = "building_name";
	  public static final String COLUMN_BUILDING_RESTROOM_ICON = "building_restroom_icon";

	  private static final String DATABASE_NAME = "wayfinder.db";
	  private static final int DATABASE_VERSION = 2;

	  // Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE + "(" + COLUMN_ID + " integer primary key autoincrement, " + 
			              COLUMN_BUILDING_NAME + " text not null, " +
			              COLUMN_HASH_CODE + " int, " +
			              COLUMN_BUILDING_RESTROOM_ICON + " int " +
	      ");";

	  public BuildingDbHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE);
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(BuildingDbHelper.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	    onCreate(db);
	  }

	} 
