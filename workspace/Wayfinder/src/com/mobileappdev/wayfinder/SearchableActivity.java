package com.mobileappdev.wayfinder;

import java.util.ArrayList;

import com.mobileappdev.wayfinder.Buildings.BuildingNameIcon;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SearchableActivity extends ListActivity {

	Buildings buildingL;
	ArrayList<BuildingNameIcon> filteredL;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        Bundle appData = getIntent().getBundleExtra(SearchManager.APP_DATA);
        
        Log.d("SearchableActivity", "onCreate - appData"+ 
                   (appData != null ? appData.get(MainActivity.SEARCH_DATA) : "") );
        buildingL = new Buildings();
        filteredL = new ArrayList<BuildingNameIcon>(); 
        filteredL.add(buildingL.new BuildingNameIcon("Computer Science", 1));
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
    	setIntent(intent); 
        Log.d("SearchableActivity", "onNewIntent");
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            filteredL = buildingL.filteredBuildingList(query);
            if(filteredL.size() <= 1) {
            	filteredL.add(buildingL.new BuildingNameIcon("Computer Science", 1));
            }
            Log.d("SearchableActivity", "query: "+ query);
            setListAdapter(new MyAdapter());
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    	Log.d("SearchableActivity", "Building: "+ filteredL.get(position).getBuildingName());

//    	Intent appData = new Intent(); 
//    	appData.putExtra("THEKEY", filteredL.get(position));
//    	setResult(RESULT_OK, appData);
    	
    	MainActivity.buildingSelection = filteredL.get(position);
    	
    	finish();
//    	ViewGroup rootView = (ViewGroup) inflater
//                .inflate(R.layout.display_weather_layout, container, false);
//
//        ((ImageView) rootView.findViewById(R.id.weather_predominant_icon)).setImageResource(weatherIcon);        

    }
  
    
    /**
     * A simple array adapter that creates a list of buildings.
     */
    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return filteredL.size();
        }

        @Override
        public BuildingNameIcon getItem(int position) {
            return filteredL.get(position);
        }

        @Override
        public long getItemId(int position) {
            return filteredL.get(position).hashCode();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, container, false);
            }
            
            ((TextView) convertView.findViewById(android.R.id.text1))
                    .setText(getItem(position).getBuildingName());
            return convertView;
        }
    }

    
}