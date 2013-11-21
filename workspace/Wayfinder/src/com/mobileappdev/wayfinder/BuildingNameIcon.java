package com.mobileappdev.wayfinder;

public class BuildingNameIcon {
	String buildingName;
	int drawable;
	int hashCode;
	
	public BuildingNameIcon () {
		buildingName = "";
		drawable = 0;		
	}
	
	public BuildingNameIcon (String buildN_in, int draw_in) {
    	buildingName = buildN_in;
    	drawable = draw_in;
    	hashCode = buildingName.hashCode();
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
	
	
	
}
