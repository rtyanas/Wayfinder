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
	
	TableLayout tableLO;
	
	BuildingActivity thisBuildAct;
	
	public BuildingLayoutGenerator(int rows_in, int columns_in, 
			BuildingActivity thisBuildAct_in ) {
		rows = rows_in;
		columns = columns_in;
		
		thisBuildAct = thisBuildAct_in;
	}
	
	public TableLayout generateTableLayout() {
		tableLO = new TableLayout(thisBuildAct);
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
			    iv.setImageResource(R.drawable.square_filler_sm);
			    // tv.setText(row+"/"+col +", ");
			    
			    tr.addView(iv);
			}
			tableLO.addView(tr);
		}
		
		return tableLO;
	}

	public TableLayout getTableLO() {
		return tableLO;
	}

	public void setTableLO(TableLayout tableLO) {
		this.tableLO = tableLO;
	}
	
	
	
}
