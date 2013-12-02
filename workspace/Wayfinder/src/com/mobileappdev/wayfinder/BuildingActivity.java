package com.mobileappdev.wayfinder;

import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class BuildingActivity extends Activity {

	boolean DEBUG = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_building);

	    LinearLayout mainLayout = new LinearLayout(this);
	    mainLayout.setOrientation(LinearLayout.VERTICAL);
		
	    Buildings b_s = new Buildings();
		int defaultVal=0;
		Intent intent = getIntent();
		BuildingNameIcon buildingSelected = b_s.getBuilding(
				(int) intent.getIntExtra(MainActivity.BUILDING_NAME_HASH, defaultVal) );
		
		if(DEBUG) Log.d("BuildingActivity", "buildingSelected: "+ buildingSelected);
	    TextView buildingText = new TextView(this);
	    buildingText.setText(buildingSelected.getBuildingName() );
	    
	    LinearLayout buildingNameLay = new LinearLayout(this);
	    buildingNameLay.setBackgroundColor(Color.CYAN);
	    buildingNameLay.setHorizontalGravity(LinearLayout.TEXT_ALIGNMENT_CENTER);
	    buildingNameLay.addView(buildingText);
	    
	    mainLayout.addView(buildingNameLay, new ViewGroup.LayoutParams (
        		ViewGroup.LayoutParams.MATCH_PARENT, 
        		ViewGroup.LayoutParams.WRAP_CONTENT));
	    	    
	    BuildingLayoutGenerator buildingLO = new BuildingLayoutGenerator(13,8,this);
		buildingLO.generateTableLayout();
	    
	    // setBuildingInternalStructure(buildingLO);
		setBuildingInternalStructure(
				buildingLO, buildingSelected.getFloorPlan());
	    
	    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  //.FILL_PARENT,
	            LayoutParams.WRAP_CONTENT);
		mainLayout.addView(buildingLO.getTableLO(), params);

		addContentView(mainLayout, new ViewGroup.LayoutParams (
        		ViewGroup.LayoutParams.WRAP_CONTENT, 
        		ViewGroup.LayoutParams.WRAP_CONTENT));

	}
	
    @Override
    public void onResume() {
    	super.onResume();


    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.building, menu);
		return true;
	}

	
    private void setBuildingInternalStructure(
    		BuildingLayoutGenerator buildingLA_in, 
    		Vector<BuildingNameIcon.OneIconDef> iconList) {
    	int rowCnt = buildingLA_in.getTableLO().getChildCount();
    	int columnCnt = 0;
    	
    	for(BuildingNameIcon.OneIconDef oneIcon : iconList) {
        	if(rowCnt > oneIcon.getRow()) {
        		columnCnt = 
        				((TableRow)(buildingLA_in.getTableLO().getChildAt(oneIcon.getRow()))).getChildCount();
        		if( columnCnt > oneIcon.getColumn()) {
        			TableRow rowChild = (TableRow)buildingLA_in.getTableLO().getChildAt(oneIcon.getRow());
        			ImageView iv = (ImageView)rowChild.getChildAt(oneIcon.getColumn());
        			iv.setImageResource(oneIcon.getDrawable());
        		}
        		else {
        			Log.e("BuildingActivity", "setBuildingInternalStructure: row or column out of bounds.");
        		}
        		
        	}    		
    	}
    }
    
    
    private void setBuildingInternalStructure(BuildingLayoutGenerator buildingLA) {
    	
    	int tableChildCnt = buildingLA.getTableLO().getChildCount();
    	View rowChild ;
    	View cellChild ;
    	int cellCount = 0;
    	for(int i = 0; i < tableChildCnt; i++) {
    		rowChild = buildingLA.getTableLO().getChildAt(i);
    		if(rowChild instanceof TableRow) {
    			cellCount = ((TableRow) rowChild).getChildCount();
    			for(int j = 0; j < cellCount; j++) {
    				cellChild = ((TableRow) rowChild).getChildAt(j);
    				if(cellChild instanceof ImageView) {
    					Log.d("BuildingActivity", "setBuildingInternalStructure, found cell");
    				}
    			}
    			
    		}
    	}
    }

}
