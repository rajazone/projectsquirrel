/* Observation Activity
 * --------------------
 * Project Squirrel Form.
 * Asks user for data & adds data to log.
 * 
 */

package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.*;
import android.os.Bundle;
import android.graphics.Shader;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.io.IOException;
import java.lang.String;

import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class observ extends Activity {
	
	Variables LOG;	//Will hold all data to be submitted.
	Bundle BUNDL;	//Used to transfer LOG between activities.
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observ); 
        
        LOG = new Variables();	//will hold all data to be submitted
        BUNDL = new Bundle();	//used to pass data between activities
        
      
        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        
        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location loc){
            //updateWithNewLocation(loc);
            Geocoder gcd = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = null;
			try {
				addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if (addresses.size() > 0){
                String Text = addresses.get(0).getLocality();
                EditText txt = (EditText) findViewById(R.id.editText1);
                txt.setText(Text + ", " + addresses.get(0).getAdminArea());
            }
            }

			//@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			//@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			//@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
            
            };

        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        
        
       // *
       // *
       // *
        
        
        //DATA FROM XML  ---------------------------------------------------------------
        Button dateBox = (Button) findViewById(R.id.date2);	//retrieve date button
        Button timeBox = (Button) findViewById(R.id.time2); //retrieve time button
        Button next = (Button) findViewById(R.id.nextButton);
        Spinner setting = (Spinner) findViewById(R.id.spinner1);
        //Button locBox  = (Button) findViewById(R.id.loc2);	//retrieve location button
        //------------------------------------------------------------------------------
        
        Date dte = new Date();		//Save current date/time into variable dte
        String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(dte);	//String time now holds 00:00 time format
        String date = DateFormat.getDateInstance(DateFormat.SHORT).format(dte); //String date now holds DD/MM/YY format
        
        //Set Day & Time to screen
        dateBox.setText(date);
        timeBox.setText(time);
        
        //Allow users to edit date
        dateBox.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		//TODO: Create widget DatePicker in a dialog to be displayed at this point.
	    }});
        
        //Allow users to edit time
        timeBox.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		//TODO: Create widget TimePicker in a dialog to be displayed at this point.
	    }});
        
        next.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), animals.class);
	            startActivity(i);
	    }});
        //Allow users to edit location
        //locBox.setOnClickListener(new View.OnClickListener(){	
        	//public void onClick(View v){
        		//TODO: Create way to edit location. (EditText for entering zip code?)
	    //}});
        
        //Create Divider Under Date/Time/Location
        BitmapDrawable divider = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.div));
        divider.setTileModeX(Shader.TileMode.REPEAT);
        ImageView divView = (ImageView) findViewById(R.id.div1);
        divView.setBackgroundDrawable(divider);
        //-----------------------------------------
        
        //Initiate Setting Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.setting_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setting.setAdapter(adapter);
        setting.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> parent,
                    View view, int pos, long id) {

                }
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
        });
        
    }//end onCreate
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
        	showDialog(0);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    
    protected Dialog onCreateDialog(int i) 
	{
    	Dialog dialog = null;
		switch(i) {
		case 0:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure you wish to exit? Data will be lost.")
			       .setCancelable(false)
			       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                observ.this.finish();
			           }
			       })
			       .setNegativeButton("No", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       });
			AlertDialog alert = builder.create();
			return alert;
		}
		
		return dialog;
	}
    
    
 /*   public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {

        }

        public void onNothingSelected(AdapterView<?> parent) {
          // Do nothing.
        }
    }*/
    
   
    }/* End of UseGps Activity */
//end observ