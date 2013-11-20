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
        		ViewGroup.LayoutParams.WRAP_CONTENT, 
        		ViewGroup.LayoutParams.WRAP_CONTENT));
	    
	    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
	            LayoutParams.WRAP_CONTENT);
	    TableLayout layoutINNER = new TableLayout(this);
	    layoutINNER.setLayoutParams(params);

	    android.widget.TableRow.LayoutParams trparams = new TableRow.LayoutParams(android.widget.TableRow.LayoutParams.WRAP_CONTENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT);
////
	    TextView tvr02sp = new TextView(this);
	    TextView tvr01sp=new TextView(this);
	    tvr01sp.setLayoutParams(trparams);
	    tvr02sp.setLayoutParams(trparams);
	    tvr01sp.setText("X1");
	    tvr02sp.setText("X2");
	    
	    TableRow tr0 = new TableRow(this);
	    tr0.setLayoutParams(params);
	    tr0.addView(tvr01sp);
	    tr0.addView(tvr02sp);
////
	    TextView tvr002sp = new TextView(this);
	    TextView tvr001sp=new TextView(this);
	    tvr001sp.setLayoutParams(trparams);
	    tvr002sp.setLayoutParams(trparams);
	    tvr001sp.setText("Y1");
	    tvr002sp.setText("Y2");
	    
	    TableRow tr00 = new TableRow(this);
	    tr00.setLayoutParams(params);
	    tr00.addView(tvr001sp);
	    tr00.addView(tvr002sp);
////
	    TextView tvr11 = new TextView(this);
	    TextView tvr12=new TextView(this);
	    tvr11.setLayoutParams(trparams);
	    tvr12.setLayoutParams(trparams);
	    tvr11.setText("Hellor11");
	    tvr12.setText("Hellor12");
	    
	    TableRow tr = new TableRow(this);
	    tr.setLayoutParams(params);
	    tr.addView(tvr11);
	    tr.addView(tvr12);

	    TextView tvr21 = new TextView(this);
	    TextView tvr22=new TextView(this);
	    tvr21.setLayoutParams(trparams);
	    tvr22.setLayoutParams(trparams);
	    tvr21.setText("Hellor21");
	    tvr22.setText("Hellor22");
	    
	    TableRow tr2 = new TableRow(this);
	    tr2.setLayoutParams(params);
	    tr2.addView(tvr21);
	    tr2.addView(tvr22);

	    layoutINNER.addView(tr00);
	    layoutINNER.addView(tr0);
	    layoutINNER.addView(tr);
	    layoutINNER.addView(tr2);
		
	    // setContentView(R.layout.activity_building);
	    
//	    removeView(findViewById(R.id.school_selected_title));
	    
		mainLayout.addView(layoutINNER, params);

		addContentView(mainLayout, new ViewGroup.LayoutParams (
        		ViewGroup.LayoutParams.WRAP_CONTENT, 
        		ViewGroup.LayoutParams.WRAP_CONTENT));

//		addContentView(findViewById(R.id.school_selected_title), params );

//		LinearLayout main = (LinearLayout)findViewById(R.layout.activity_building);
//	    if(main != null) {
//		    main.addView(layoutINNER);	    	
//	    }
//	    else
//	    	Log.e("BuildingActivity", "findViewById(R.layout.activity_building)is null");

		

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
