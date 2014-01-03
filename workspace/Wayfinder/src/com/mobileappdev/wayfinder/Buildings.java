package com.mobileappdev.wayfinder;

import java.util.ArrayList;
import java.util.Vector;

import com.mobileappdev.wayfinder.BuildingNameIcon.OneIconDef;

public class Buildings {
	
    private ArrayList<BuildingNameIcon> buildings;

    public Buildings() {
    	String liv = "Cell DNA Repository";
    	String sac = "Student Activities Center_3123";
    	String uce = "University Center at Easton Avenue_3154";
    	String sub = "Rutgers Univ Bush Campus Center";
    	String sul = "Student Union - Livingston";
    	String sud = "Physics Lecture Hall";
    	String arc = "Allison Road Classroom Building_3878";
    	String cpe = "Center for Packaging Engineering";
    	

    	buildings = new ArrayList<BuildingNameIcon>();
    	buildings.add(new BuildingNameIcon(sub, R.drawable.bld_bush_studentcenter, R.drawable.floorplan1) );
    	buildings.add(new BuildingNameIcon(sul, R.drawable.bld_livingston_studentcenter, R.drawable.floorplan2) );
    	buildings.add(new BuildingNameIcon(sud, R.drawable.bld_douglas_studentcenter, R.drawable.floorplan3) );
    	buildings.add(new BuildingNameIcon(arc, R.drawable.bld_allison_rd_classroom, R.drawable.floorplan4) );
    	buildings.add(new BuildingNameIcon(liv, R.drawable.livingston_student_center_4160, R.drawable.floorplan2) );
    	buildings.add(new BuildingNameIcon(sac, R.drawable.bld_student_activitycenter, R.drawable.floorplan4) );
    	buildings.add(new BuildingNameIcon(uce, R.drawable.university_centerat_easton_avenue_3154, R.drawable.floorplan3) );
    	buildings.add(new BuildingNameIcon(cpe, R.drawable.university_centerat_easton_avenue_3154, R.drawable.floorplan1) );
    	
    	Vector<OneIconDef> floorPlan = new Vector<OneIconDef>();
    	BuildingNameIcon bni = new BuildingNameIcon();
    	OneIconDef oneIcon = bni.new OneIconDef(0, 4, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new  OneIconDef(2, 4, R.drawable.elevator);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new  OneIconDef(2, 6, R.drawable.dining);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new  OneIconDef(3, 7, R.drawable.wifi_sm);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(3, 4, R.drawable.handicap);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new  OneIconDef(3, 5, R.drawable.restroom);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new  OneIconDef(5, 0, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	this.getBuilding(liv.hashCode()).setFloorPlan(floorPlan);
    	
    	floorPlan = new Vector<OneIconDef>();
    	oneIcon = bni.new OneIconDef(4, 5, R.drawable.restroom);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(4, 6, R.drawable.handicap);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(3, 6, R.drawable.stairs);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(0, 6, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(4, 0, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	this.getBuilding(sac.hashCode()).setFloorPlan(floorPlan);
    	
    	floorPlan = new Vector<OneIconDef>();
    	oneIcon = bni.new OneIconDef(4, 5, R.drawable.restroom);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(4, 6, R.drawable.handicap);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(3, 6, R.drawable.stairs);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(0, 6, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(4, 0, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	this.getBuilding(sub.hashCode()).setFloorPlan(floorPlan);
    	
    	floorPlan = new Vector<OneIconDef>();
    	oneIcon = bni.new OneIconDef(4, 6, R.drawable.restroom);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(4, 7, R.drawable.handicap);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(6, 7, R.drawable.stairs);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(0, 5, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(2, 0, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	this.getBuilding(uce.hashCode()).setFloorPlan(floorPlan);

    	floorPlan = new Vector<OneIconDef>();
    	oneIcon = bni.new OneIconDef(2, 6, R.drawable.restroom);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(2, 7, R.drawable.handicap);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(0, 7, R.drawable.stairs);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(0, 5, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(3, 0, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	this.getBuilding(sul.hashCode()).setFloorPlan(floorPlan);

    	floorPlan = new Vector<OneIconDef>();
    	oneIcon = bni.new OneIconDef(6, 3, R.drawable.restroom);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(6, 4, R.drawable.handicap);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(1, 7, R.drawable.stairs);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(0, 2, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(5, 0, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	this.getBuilding(arc.hashCode()).setFloorPlan(floorPlan);

    	floorPlan = new Vector<OneIconDef>();
    	oneIcon = bni.new OneIconDef(6, 3, R.drawable.restroom);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(6, 4, R.drawable.handicap);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(1, 7, R.drawable.stairs);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(0, 2, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	oneIcon = bni.new OneIconDef(5, 0, R.drawable.exit);
    	floorPlan.add(oneIcon);
    	this.getBuilding(cpe.hashCode()).setFloorPlan(floorPlan);

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

	public BuildingNameIcon getBuilding(int hashCode_in) {
		BuildingNameIcon bRet = new BuildingNameIcon("Builing Not Found", 0);
		
		for(BuildingNameIcon b : buildings) {
			if(b.getHashCode() == hashCode_in) {
				return b;
			}
		}
		
		return bRet;
	}

	public String getBuildingFloorplan(int hashCode_in) {
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
