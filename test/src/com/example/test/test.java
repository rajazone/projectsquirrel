package com.example.test;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class test extends ListActivity {
	
	static final String[] Locations = new String[] {
	    "SEL", "Burnham Hall", "SEO", "Custom GeoPoint 1e6 ,1e6"
	  };
	static final double[] GeoPoints = new double[] {
		41.870756, 41.870980, 41.870882, -87.648647, -87.649361, -87.650066
		};
	// Geo points for locations stored in this order:
	// X co-ordinate entry matches Locations index
	// Y co-ordinate entry matches Locations.size + Locations index
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, Locations));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);
	// build dialog box to display when user clicks the flag
	  lv.setOnItemClickListener(new OnItemClickListener() {
	   
		  // anonymous inner class
		  public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	      // When clicked, show a toast with the TextView text
	      Toast.makeText(test.this, ((TextView) view).getText(),
	          Toast.LENGTH_SHORT).show();
	      AlertDialog.Builder builder = new AlertDialog.Builder(test.this);
	      //builder.setMessage("You selected " + ((TextView) view).getText())
	     
	      builder.setMessage("You selected " + ((TextView) view).getText())
	      .setCancelable(false)
	      .setTitle("Alert!")
	      .setPositiveButton("Done", new DialogInterface.OnClickListener() {
	          public void onClick(DialogInterface dialog, int id) {
	          dialog.dismiss();
	          }
	      });
	      AlertDialog alert = builder.create();
	      //alert.show(); // not liking having an alert show up, android doesn't wait for dismisal... how to fix?
	      // id is the Location index we need that corresponds to find corresponding geo points
	      
	      if (id==3) // if custom geo point
	      { // set intent to entry form
		      Intent myIntent = new Intent(view.getContext(), input.class); // create the intent to launch the input
	          startActivityForResult(myIntent, 0); // start input activity
	      }
	      else
	      { // otherwise map it!
	    	  Bundle b = new Bundle(); // create a bundle to pass to map activity
		      b.putDouble("point1", GeoPoints[(int)(id)]*1000000); // bundle the geo points for the map activity and convert to 1e6
		      b.putDouble("point2", GeoPoints[(int)id+(Locations.length-1)]*1000000);
		      Intent myIntent = new Intent(view.getContext(), map.class); // create the intent to launch the map
		      myIntent.putExtras(b); // attach bundle to map activity
	          startActivityForResult(myIntent, 0); // start map activity
	      
	      }
	      



	    }
	  });
	}
}
	
