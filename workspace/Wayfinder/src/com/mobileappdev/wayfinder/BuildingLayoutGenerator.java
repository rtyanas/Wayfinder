package com.mobileappdev.wayfinder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class BuildingLayoutGenerator {
	
	private int rows;
	private int columns;
	private int cellType;
	
	TableLayout tableLO;
	
	Context thisBuildAct;
	
	public BuildingLayoutGenerator(int rows_in, int columns_in, int cellType_in,
			Context thisBuildAct_in ) {
		rows = rows_in;
		columns = columns_in;
		cellType = cellType_in;
		
		thisBuildAct = thisBuildAct_in;
	}
	
	public TableLayout generateTableLayout() {
		tableLO = new TableLayout(thisBuildAct);
	    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
	            LayoutParams.WRAP_CONTENT);
	    TableRow.LayoutParams trparams = 
	    		new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 
	    				                  TableRow.LayoutParams.WRAP_CONTENT);

	    View iv = null;
	    TableRow tr = null;
		for(int row=1; row <= rows; row++) {
		    tr = new TableRow(thisBuildAct);
		    tr.setLayoutParams(params);

			for(int col=1; col <= columns; col++) {
				if(cellType == 0) {
				    iv = new ImageView(thisBuildAct);
				    iv.setLayoutParams(trparams);
				    ((ImageView)iv).setImageResource(R.drawable.square_filler_sm);					
				}
				else if(cellType == 1) {
				    iv = new Button(thisBuildAct);
				    iv.setLayoutParams(trparams);
					if(col != 2 && col != 4) // put road when not building row.
						((Button)iv).setBackgroundResource(R.drawable.road_section);
					else // set green  between buildings
						((Button)iv).setBackgroundColor( -16711936); // green
				}
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
