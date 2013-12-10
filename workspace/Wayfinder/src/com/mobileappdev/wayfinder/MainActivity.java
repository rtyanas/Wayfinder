package com.mobileappdev.wayfinder;

import java.util.List;
import java.util.Vector;

import com.mobileappdev.wayfinder.BuildingNameIcon;
import com.mobileappdev.wayfinder.BuildingActivity;
import com.mobileappdev.wayfinder.BuildingActivity.TableCellType;
import com.mobileappdev.wayfinder.BuildingNameIcon.OneIconDef;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String SEARCH_DATA= "SearchData";
	public static BuildingNameIcon buildingSelection = null, buildingSelection_old;
	private Button buildingSelButton;
	public static String BUILDING_NAME_HASH = "BUILDING_NAME";
	Button buttonSchoolV;
	static Buildings b_s;
	TextView buildingText;
	MainActivity mainThis;
	BuildingLayoutGenerator buildingLO;
	enum PathAction {Draw, Erase};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buildingSelection = new BuildingNameIcon("", R.drawable.bld_default);
        buildingSelection_old = buildingSelection;

	    LinearLayout mainLayout = new LinearLayout(this);
	    mainLayout.setOrientation(LinearLayout.VERTICAL);

	    /**** Database test code ****/
//        BuildingDbData bDB = new BuildingDbData(this);
//        bDB.open();
//	    Buildings b_s = new Buildings();
//	    for(BuildingNameIcon bni : b_s.getBuildings()) {
//	        bDB.createBuilding(bni.getHashCode(), bni.getBuildingName(), bni.getDrawable());	    	
//	    }
//
//	    List<BuildingNameIcon> allDb = bDB.getAllBuildings();
//	    for(BuildingNameIcon b : allDb) {
//	    	Log.d("MainActivity", "DB Values: "+ b.getBuildingName() +
//	    			","+ b.drawable +","+ b.hashCode());
//	    }
	    /****************/
	    
        mainThis = this;
        // gets the activity's default ActionBar
        ActionBar actionBar = getActionBar();
        actionBar.show();
        
        buttonSchoolV = new Button(this);
		if( buttonSchoolV == null) { 
			Log.e("MainActivity", "Button is null");
		}
		else {
			buttonSchoolV.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	            	
	        		Intent intent = new Intent(mainThis, BuildingActivity.class); // new Intent(this, BuildingActivity.class);
	        		int buildingSel = buildingSelection != null ? buildingSelection.getBuildingName().hashCode() : 0;
	        		intent.putExtra(BUILDING_NAME_HASH, buildingSel);
	        		startActivity(intent);
	            }
	        });
		}
		
	    b_s = new Buildings();

		BuildingNameIcon buildingSelected = b_s.getBuilding("Student Union - Bush".hashCode() );
		
	    buildingText = new TextView(this);
	    buildingText.setText(buildingSelected.getBuildingName() );
	    
	    LinearLayout buildingNameLay = new LinearLayout(this);
	    buildingNameLay.setBackgroundColor(Color.CYAN);
	    buildingNameLay.setHorizontalGravity(LinearLayout.TEXT_ALIGNMENT_CENTER);
	    buildingNameLay.addView(buildingText);
	    
	    mainLayout.addView(buildingNameLay, new ViewGroup.LayoutParams (
        		ViewGroup.LayoutParams.MATCH_PARENT, 
        		ViewGroup.LayoutParams.WRAP_CONTENT));
	    	    
	    buildingLO = new BuildingLayoutGenerator(8,5,1,this);
		buildingLO.generateTableLayout();
		
		setBuildingsOnCampus(buildingLO);
		
        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.BLUE);
     
	    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  //.FILL_PARENT,
	            LayoutParams.WRAP_CONTENT);
		mainLayout.addView(buildingLO.getTableLO(), params);

		addContentView(mainLayout, new ViewGroup.LayoutParams (
        		ViewGroup.LayoutParams.WRAP_CONTENT, 
        		ViewGroup.LayoutParams.WRAP_CONTENT));

        // set the app icon as an action to go home
        // we are home so we don't need it
        // actionBar.setDisplayHomeAsUpEnabled(true);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    
    
    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        getMenuInflater().inflate( R.menu.search_menu, menu );
        getMenuInflater().inflate( R.menu.main, menu );

        // Add SearchWidget.
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem( R.id.options_menu_main_search ).getActionView();

        searchView.setSearchableInfo( searchManager.getSearchableInfo( getComponentName() ) );

        // Do not iconify the widget;expand it by default
        searchView.setIconifiedByDefault(true);

        return super.onCreateOptionsMenu( menu );
    }

    
    @Override 
    public boolean onSearchRequested() {     
		Log.d("MainActivity", "onSearchRequested");
    	Bundle appData = new Bundle();
    	appData.putString(MainActivity.SEARCH_DATA, "This string passed into search");
    	startSearch("initial Query", true, appData, false);
    	return true;
    }
    
    
    @Override 
    public void onActivityResult(int requestCode, int resultCode, Intent data) {     
    	super.onActivityResult(requestCode, resultCode, data); 

    	if(resultCode == RESULT_OK) {
    		Log.d("MainActivity", "Result OK"+ RESULT_OK +", "+ data.getStringExtra("THEKEY"));
    	}
    	else {
    		Log.d("MainActivity", "Result NOT OK " +", "+ data.getStringExtra("THEKEY"));
    	}
    }

    @Override
    public void onResume() {
    	super.onResume();
    	Log.d("MainActivity", "buildingSelection: "+ 
    	(buildingSelection != null ? buildingSelection.getBuildingName() : "") );
    	
    	if(this.getWindow() != null) {

    		if(buildingSelButton != null ) {    			
    			((Button) buildingSelButton).setBackgroundResource(buildingSelection.getDrawable());
    			buildingText.setText(buildingSelection.getBuildingName());
    			if( buildingSelection_old != buildingSelection) {
    				addPath(buildingLO, PathAction.Draw);
    			}
    	        buildingSelection_old = buildingSelection;
    		}
    		else {
        		Log.d("MainActivity", "getWindow().getDecorView() or findViewById(R.id.imageButton1) is null");    			
    		}
    	}
    	else
    		Log.d("MainActivity", "getWindow() is null");
        // ((ImageView) rootView.findViewById(R.id.weather_predominant_icon)).setImageResource(weatherIcon);
    }
    
    
    @Override
  	public boolean onOptionsItemSelected(MenuItem item){
    	// same as using a normal menu
    	switch(item.getItemId()) {
    	case R.id.resetPath:
    		addPath(buildingLO, PathAction.Erase);
    		makeToast("Reset Path");
    		break;
    	case R.id.item_save:
    		makeToast("Saving...");
    		break;
    	}
    	
  		return true;
  	}
    
    public void makeToast(String message) {
    	// with jam obviously
    	Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
        

    private void setBuildingsOnCampus(BuildingLayoutGenerator buildingLA_in) {
		BuildingNameIcon buildingSelected;

    	setAbuildingDetails(buildingLA_in,4,3,"Student Union - Livingston");

    	setAbuildingDetails(buildingLA_in,2,1,"Student Activities Center_3123");

    	setAbuildingDetails(buildingLA_in,6,3,"Allison Road Classroom Building_3878");

    	setAbuildingDetails(buildingLA_in,1,3,buttonSchoolV);

    }
    
    
    private void setAbuildingDetails(BuildingLayoutGenerator buildingLA_in,
    		int row_in, int column_in, Button buildingIcon) {
    
    	int rowCnt = buildingLA_in.getTableLO().getChildCount();
    	int columnCnt = 0;

    	if(rowCnt > row_in) {
    		columnCnt = 
    				((TableRow)(buildingLA_in.getTableLO().getChildAt(row_in))).getChildCount();
    		if( columnCnt > column_in) {
    			TableRow rowChild = (TableRow)buildingLA_in.getTableLO().getChildAt(row_in);
    			buildingSelButton = (Button)rowChild.getChildAt(column_in);
    			buildingSelButton.setOnClickListener(new View.OnClickListener() {
    	            @Override
    	            public void onClick(View view) {
    	            	
    	        		Intent intent = new Intent(mainThis, BuildingActivity.class); // new Intent(this, BuildingActivity.class);
    	        		int buildingSel = buildingSelection != null ? buildingSelection.getBuildingName().hashCode() : 0;
    	        		intent.putExtra(BUILDING_NAME_HASH, buildingSel);
    	        		startActivity(intent);
    	            }
    	        });
    		}
    		else {
    			Log.e("MainActivity", "setAbuildingDetails: column out of bounds.");
    		}
    	}    		
		else {
			Log.e("MainActivity", "setAbuildingDetails: row out of bounds.");
		}

    }

    public class ButtonClickListener implements OnClickListener {
    	String building;
    	public ButtonClickListener(String building_in)  {
    		building = building_in;
    	}
    	
    	@Override
    	public void onClick(View v) {
    		Intent intent = new Intent(mainThis, BuildingActivity.class); // new Intent(this, BuildingActivity.class);
    		// int buildingSel = buildingSelected_in != null ? buildingSelected_in.getBuildingName().hashCode() : 0;
    		intent.putExtra(BUILDING_NAME_HASH, building.toString().hashCode() );
    		startActivity(intent);
    		
    	}
    }

    
    private void setAbuildingDetails(BuildingLayoutGenerator buildingLA_in,
    		int row_in, int column_in, String buildingName) {
    
    	int rowCnt = buildingLA_in.getTableLO().getChildCount();
    	int columnCnt = 0;

    	if(rowCnt > row_in) {
    		columnCnt = 
    				((TableRow)(buildingLA_in.getTableLO().getChildAt(row_in))).getChildCount();
    		if( columnCnt > column_in) {
    			TableRow rowChild = (TableRow)buildingLA_in.getTableLO().getChildAt(row_in);
    			Button b = (Button)rowChild.getChildAt(column_in);
    			b.setBackgroundResource(b_s.getBuilding(buildingName.hashCode()).getDrawable());
    			b.setOnClickListener(new ButtonClickListener(buildingName));
    		}
    		else {
    			Log.e("MainActivity", "setAbuildingDetails: column out of bounds.");
    		}
    	}    		
		else {
			Log.e("MainActivity", "setAbuildingDetails: row out of bounds.");
		}

    }

    
    private void addPath(BuildingLayoutGenerator buildingLA_in, 
    		             PathAction pathAction) {
    	Vector<OneIconDef> path = new Vector<OneIconDef>();
    	BuildingNameIcon bni = new BuildingNameIcon();
    	int roadPath, roadPathEnd, roadPathStart;
    	
    	if(pathAction == PathAction.Draw) {
    		roadPath = R.drawable.road_with_path;
    		roadPathEnd = R.drawable.road_with_path_start;
    		roadPathStart = R.drawable.road_with_path_end_right;
    	}
    	else {
    		roadPath = R.drawable.road_section;
    		roadPathEnd = R.drawable.road_section;
    		roadPathStart = R.drawable.road_section;
    	}
    	
    	OneIconDef oneIcon = bni.new OneIconDef(1, 2, roadPathStart);
    	path.add(oneIcon);
    	oneIcon = bni.new OneIconDef(2, 2, roadPath);
    	path.add(oneIcon);
    	oneIcon = bni.new OneIconDef(3, 2, roadPath);
    	path.add(oneIcon);
    	oneIcon = bni.new OneIconDef(4, 2, roadPath);
    	path.add(oneIcon);
    	oneIcon = bni.new OneIconDef(5, 2, roadPathEnd);
    	path.add(oneIcon);
		
		BuildingActivity.setBuildingInternalStructure(buildingLA_in, path, TableCellType.buttonType);
    }

}
