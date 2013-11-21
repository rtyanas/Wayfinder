package com.mobileappdev.wayfinder;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BuildingDbData {

	  // Database fields
	  private SQLiteDatabase database;
	  private BuildingDbHelper dbHelper;
	  private String[] allColumns = { 
			  BuildingDbHelper.COLUMN_ID,
			  BuildingDbHelper.COLUMN_HASH_CODE,
			  BuildingDbHelper.COLUMN_BUILDING_NAME,
			  BuildingDbHelper.COLUMN_BUILDING_RESTROOM_ICON };

	  public BuildingDbData(Context context) {
	    dbHelper = new BuildingDbHelper(context);
	  }

	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	    Log.d("BuildingDbData", "database: open? "+ database.isOpen() + database.toString());
	  }

	  public void close() {
	    dbHelper.close();
	  }

	  public BuildingNameIcon createBuilding(int hashCode, String comment, int icon) {
	    ContentValues values = new ContentValues();
	    BuildingNameIcon newBuilding = new BuildingNameIcon();

	    values.put(BuildingDbHelper.COLUMN_HASH_CODE, hashCode);
	    values.put(BuildingDbHelper.COLUMN_BUILDING_NAME, comment);
	    values.put(BuildingDbHelper.COLUMN_BUILDING_RESTROOM_ICON, icon);
	    long insertId = database.insert(BuildingDbHelper.TABLE, null,
	        values);
	    if(insertId != -1) {
		    Cursor cursor = database.query(BuildingDbHelper.TABLE,
		        allColumns, BuildingDbHelper.COLUMN_ID + " = " + insertId, null,
		        null, null, null);
		    cursor.moveToFirst();
		    newBuilding = cursorToBuilding(cursor);
		    cursor.close();
	    }
	    return newBuilding;
	  }

	  public void deleteBuilding(BuildingNameIcon comment) {
	    long id = comment.getHashCode();
	    System.out.println("Building deleted with id: " + id);
	    database.delete(BuildingDbHelper.TABLE, BuildingDbHelper.COLUMN_ID
	        + " = " + id, null);
	  }

	  public List<BuildingNameIcon> getAllBuildings() {
	    List<BuildingNameIcon> comments = new ArrayList<BuildingNameIcon>();

	    Cursor cursor = database.query(BuildingDbHelper.TABLE,
	        allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	    	BuildingNameIcon comment = cursorToBuilding(cursor);
	      comments.add(comment);
	      cursor.moveToNext();
	    }
	    // make sure to close the cursor
	    cursor.close();
	    return comments;
	  }

	  public BuildingNameIcon getBuilding(int hashCode) {
		    BuildingNameIcon building = new BuildingNameIcon();

		    Cursor cursor = database.query(BuildingDbHelper.TABLE,
		        allColumns, null, null, null, null, null);

		    cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
		    	building = cursorToBuilding(cursor);
		    	cursor.moveToNext();
		    }
		    // make sure to close the cursor
		    cursor.close();
		    return building;
		  }

	  private BuildingNameIcon cursorToBuilding(Cursor cursor) {
		  BuildingNameIcon comment = new BuildingNameIcon();
	    comment.setHashCode(cursor.getInt(1));
	    comment.setBuildingName(cursor.getString(2));
	    comment.setDrawable(cursor.getInt(3));
	    return comment;
	  }

}
