package com.mobileappdev.wayfinder;

import java.util.ArrayList;

public class Buildings {
	
    private ArrayList<BuildingNameIcon> buildings;

    public Buildings() {
    	buildings = new ArrayList<BuildingNameIcon>();
    	buildings.add(new BuildingNameIcon("Student Union - Bush", R.drawable.sc_bush_icon) );
    	buildings.add(new BuildingNameIcon("Student Union - Livingston", R.drawable.sc_livingston_icon) );
    	buildings.add(new BuildingNameIcon("Student Union - Douglas", R.drawable.sc_douglas_icon) );
    	buildings.add(new BuildingNameIcon("Allison Road Classroom Building_3878", R.drawable.allison_road_classroom_building_3878) );
    	buildings.add(new BuildingNameIcon("Livingston Student Center_4160", R.drawable.livingston_student_center_4160) );
    	buildings.add(new BuildingNameIcon("Student Activities Center_3123", R.drawable.student_activities_center_3123) );
    	buildings.add(new BuildingNameIcon("University Center at Easton Avenue_3154", R.drawable.university_centerat_easton_avenue_3154) );
    	
    }
    
    
    public ArrayList<BuildingNameIcon> filteredBuildingList(String filter) {
    	ArrayList<BuildingNameIcon> selectedList = new ArrayList<BuildingNameIcon>();
    	
    	for(BuildingNameIcon b : buildings) {
    		if(b.getBuildingName().toLowerCase().contains(filter.toLowerCase()))
    			selectedList.add(b);
    	}
    	
    	return selectedList;
    }
    
	public String getBuildingName(int hashCode_in) {
		String bName="Building Not Found";
		
		for(BuildingNameIcon b : buildings) {
			if(b.getHashCode() == hashCode_in) {
				return b.getBuildingName();
			}
		}
		
		return bName;
	}

	public ArrayList<BuildingNameIcon> getBuildings() {
		return (ArrayList<BuildingNameIcon>)buildings.clone();
	}
}
