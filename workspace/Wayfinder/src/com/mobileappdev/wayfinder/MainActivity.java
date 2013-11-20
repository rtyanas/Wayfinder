package com.mobileappdev.wayfinder;

import com.mobileappdev.wayfinder.Buildings.BuildingNameIcon;
import com.mobileappdev.wayfinder.BuildingActivity;

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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String SEARCH_DATA= "SearchData";
	public static BuildingNameIcon buildingSelection = null;
	public static String BUILDING_NAME_HASH = "BUILDING_NAME";
	MainActivity mainThis;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainThis = this;
        // gets the activity's default ActionBar
        ActionBar actionBar = getActionBar();
        actionBar.show();
        
        View buttonSchoolV = findViewById(R.id.school_icon);
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

		Button cancelBut = new Button(this);
		cancelBut.setText("Cancel");
		cancelBut.setBackgroundColor(Color.YELLOW);
        
        cancelBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
		
        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.BLUE);
     
        myLayout.addView(cancelBut);
        addContentView (myLayout, new ViewGroup.LayoutParams (
        		ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

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

    	
    	
//    	  switch(requestCode) { 
//    	    case (STATIC_INTEGER_VALUE) : { 
//    	      if (resultCode == Activity.RESULT_OK) { 
//    	      String newText = data.getStringExtra(PUBLIC_STATIC_STRING_IDENTIFIER);
//    	      // TODO Update your TextView.
//    	      } 
//    	      break; 
//    	    } 
//    	  } 
    }

    @Override
    public void onResume() {
    	super.onResume();
    	Log.d("MainActivity", "buildingSelection: "+ 
    	(buildingSelection != null ? buildingSelection.getBuildingName() : "") );
    	
    	int buildingIcon = R.drawable.arc_building;

    	if(this.getCurrentFocus() != null) {
    		View v = getWindow().getDecorView();
    		if(v != null && v.findViewById(R.id.school_icon) != null) {    			
    			((ImageView) v.findViewById(R.id.school_icon)).setImageResource(buildingSelection.getDrawable());
    			((TextView) v.findViewById(R.id.school_selected_title)).setText(buildingSelection.getBuildingName());
    		}
    		else {
        		Log.d("MainActivity", "getWindow().getDecorView() or findViewById(R.id.imageButton1) is null");    			
    		}
    	}
    	else
    		Log.d("MainActivity", "getCurrentFocus() is null");
        // ((ImageView) rootView.findViewById(R.id.weather_predominant_icon)).setImageResource(weatherIcon);
    }
    
    
    @Override
  	public boolean onOptionsItemSelected(MenuItem item){
    	// same as using a normal menu
    	switch(item.getItemId()) {
    	case R.id.item_refresh:
    		makeToast("Refreshing...");
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
        
    


}
