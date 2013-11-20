package com.mobileappdev.wayfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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

		//		findViewById(R.layout.activity_building).setOnClickListener(new View.OnClickListener() {
//			
//            @Override
//            public void onClick(View view) {
//				Log.d("BuildingActivity", "In - onClick");
//			}
//		});
		
		Buildings b_s = new Buildings();

		int defaultVal=0;
		Intent intent = getIntent();
		String buildingSelected = b_s.getBuildingName(
				(int) intent.getIntExtra(MainActivity.BUILDING_NAME_HASH, defaultVal) );
		
		if(DEBUG) Log.d("BuildingActivity", "buildingSelected: "+ buildingSelected);
	    TextView buildingText = new TextView(this);
	    buildingText.setText(buildingSelected );
	    
	    LinearLayout buildingNameLay = new LinearLayout(this);
	    buildingNameLay.setBackgroundColor(Color.CYAN);
	    buildingNameLay.addView(buildingText);
	    
	    LinearLayout mainLayout = new LinearLayout(this);
	    mainLayout.setOrientation(LinearLayout.VERTICAL);
	    mainLayout.addView(buildingNameLay, new ViewGroup.LayoutParams (
        		ViewGroup.LayoutParams.MATCH_PARENT, 
        		ViewGroup.LayoutParams.WRAP_CONTENT));
	    
	    
	    BuildingLayoutGenerator buildingLa = new BuildingLayoutGenerator(15,9,this);
	    
	    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  //.FILL_PARENT,
	            LayoutParams.WRAP_CONTENT);
		mainLayout.addView(buildingLa.generateTableLayout(), params);

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

}
