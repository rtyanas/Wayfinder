package com.mobileappdev.wayfinder;

import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class BuildingLayoutGenerator {
	
	private int rows;
	private int columns;
	
	BuildingActivity thisBuildAct;
	
	public BuildingLayoutGenerator(int rows_in, int columns_in, 
			BuildingActivity thisBuildAct_in ) {
		rows = rows_in;
		columns = columns_in;
		
		thisBuildAct = thisBuildAct_in;
	}
	
	public TableLayout generateTableLayout() {
		TableLayout tableRet = new TableLayout(thisBuildAct);
	    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
	            LayoutParams.WRAP_CONTENT);
	    TableRow.LayoutParams trparams = 
	    		new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 
	    				                  TableRow.LayoutParams.WRAP_CONTENT);

	    ImageView iv = null;
	    TableRow tr = null;
		for(int row=1; row <= rows; row++) {
		    tr = new TableRow(thisBuildAct);
		    tr.setLayoutParams(params);

			for(int col=1; col <= columns; col++) {
			    iv = new ImageView(thisBuildAct);
			    iv.setLayoutParams(trparams);
			    iv.setImageResource(R.drawable.allison_road_classroom_building_3878_sm);
			    // tv.setText(row+"/"+col +", ");
			    
			    tr.addView(iv);
			}
			tableRet.addView(tr);
		}
		
		return tableRet;
	}
	
}
