package com.mobileappdev.wayfinder;

import java.util.Vector;

public class BuildingNameIcon {
	String buildingName;
	int drawable;
	int hashCode;
	Vector<OneIconDef> floorPlan = new Vector<OneIconDef> ();
	
	public BuildingNameIcon () {
		buildingName = "";
		drawable = 0;		
		floorPlan = new Vector<OneIconDef>();
	}
	
	public BuildingNameIcon (String buildN_in, int draw_in) {
    	buildingName = buildN_in;
    	drawable = draw_in;
    	hashCode = buildingName.hashCode();
	}
	
	public Vector<OneIconDef> getFloorPlan() {
		return floorPlan;
	}

	public void setFloorPlan(Vector<OneIconDef> floorPlan_in) {
		floorPlan = floorPlan_in;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getDrawable() {
		return drawable;
	}

	public void setDrawable(int drawable) {
		this.drawable = drawable;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	
	
	class OneIconDef {
		int row, column;
		int drawable;
		
		OneIconDef(int row_in, int column_in, int drawable_in) {
			row = row_in;
			column = column_in;
			drawable = drawable_in;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

		public int getDrawable() {
			return drawable;
		}

		public void setDrawable(int drawable) {
			this.drawable = drawable;
		}
		
		
	}

}
