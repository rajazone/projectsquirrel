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

public class observ extends Activity {
	
	Bundle BUNDL;	//Used to transfer Log data between activities.
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observ); 
        
        BUNDL = new Bundle();	//used to pass data between activities, later to be stored in Log.
      
        // LOCATION --------------------------------------------------------------------------------
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
                
                //TODO: Need latitude and logitude
                //Save them...
                //BUNDL.putString("LATITUDE", "x");
                //BUNDL.putString("LONGITUDE", "y");
                //BUNDL.putString("ZIP", "XXXXX-XXXX");
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
            
            //TODO: (Robin?) If GPS is disabled & user is about to submit data...
            //- Grab zip code from  (EditText) findViewById(R.id.editText1);
            //- If zip code does not exist, inform user
            //- Else convert zip code into approx. latitude & logitude
            //- Store zip code, lat. & long. as Strings into bundl with key names LATITUDE, LOGITUDE, ZIP -> BUNDL.putString("key", "value");

        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        
        
       // *
       // *
       // *
        
        
        //DATA FROM XML  ---------------------------------------------------------------
        Button dateBox = (Button) findViewById(R.id.date2);	//retrieve date button
        Button timeBox = (Button) findViewById(R.id.time2); //retrieve time button
        Button next = (Button) findViewById(R.id.nextButton);
        Button cancel = (Button) findViewById(R.id.cancelButton);
        Button guide = (Button) findViewById(R.id.guideButton);
        Spinner setting = (Spinner) findViewById(R.id.spinner1);
        
        Button fox_minus = (Button) findViewById(R.id.fox_minus);
        Button fox_plus = (Button) findViewById(R.id.fox_plus);
        Button gray_minus = (Button) findViewById(R.id.gray_minus);
        Button gray_plus = (Button) findViewById(R.id.gray_plus);
        //------------------------------------------------------------------------------
        
        Date dte = new Date();		//Save current date/time into variable dte
        String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(dte);	//String time now holds 00:00 time format
        String date = DateFormat.getDateInstance(DateFormat.SHORT).format(dte); //String date now holds DD/MM/YY format
        
        //Set Day & Time to screen
        dateBox.setText(date);
        timeBox.setText(time);
        
        //--------------------------------------------------------------------------------------------
        //Add Day & Time to BUNDL     ----------------------------------------------------------------
        /*Formats... (As specified by syllabus)
        * Day = [DD]
    	* Month = [MM]
    	* Year = [YYYY]
    	* Hour = [HH]
    	* Minute = [MM]
    	* AMPM = [XM]
    	*/
        int s1 = date.indexOf('/');			//index of first slash (date)
        int s2 = date.indexOf('/', s1+1);	//index of second slash (date)
        int t1 = date.indexOf('/');			//index of first slash (time)
        int t2 = date.indexOf('/', t1+1);	//index of second slash (time)
        int sp = date.indexOf(' ');			//index of space before AM/PM (time)
        
        String day = date.substring(0,s1);
        	if(day.length()==1) { day = "0" + day; } 		//Day must be 2 characters long	
        String month = date.substring(s1+1,s2);
        	if(month.length()==1) { month = "0" + month; } 	//Month must be 2 characters long
        String hour = date.substring(0,t1);
    		if(hour.length()==1) { hour = "0" + hour; } 		//Hour must be 2 characters long	
        String minute = date.substring(t1+1,t2);
        	if(minute.length()==1) { minute = "0" + minute; } 	//Minute must be 2 characters long
        
        BUNDL.putString("Day", day);
        BUNDL.putString("Month", month);
        BUNDL.putString("Year", date.substring(s2+1));
        BUNDL.putString("Hour", hour);
        BUNDL.putString("Minute", minute);
        BUNDL.putString("AMPM", time.substring(sp+1));
        //--------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------
        
        //Allow users to edit date
        dateBox.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		//TODO: Create widget DatePicker in a dialog to be displayed at this point.
        		//BUNDL.Day,Month,Year = this new entry
	    }});
        
        //Allow users to edit time
        timeBox.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		//TODO: Create widget TimePicker in a dialog to be displayed at this point.
        		//BUNDL.Hour,Minute,AMPM = this new entry
	    }});
        
        
        //NEXT BUTTON
        next.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		//Store squirrel variables in BUNDL
		    		EditText fox_text = (EditText) findViewById(R.id.fox_text);
		            EditText gray_text = (EditText) findViewById(R.id.gray_text);
		            BUNDL.putString("NUM_FOX_SQUIRRELS",fox_text.getText().toString());
		            BUNDL.putString("NUM_GRAY_SQUIRRELS",gray_text.getText().toString());
		            
	    		Intent i = new Intent(getApplicationContext(), animals.class);
	    		i.putExtras(BUNDL);	//Sends BUNDL to next activity.
	            startActivity(i);
	    }});
        
        //CANCEL BUTTON  
        cancel.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		showDialog(0);
	    }});  
        
        //SQUIRREL GUIDE BUTTON  
        guide.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), sqguide.class);
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
        
        //Initiate Squirrel Counters	-------------------------------------------------------------
        fox_minus.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		EditText fox_text = (EditText) findViewById(R.id.fox_text);
        		String t = fox_text.getText().toString();
        		if(t == null || t == "" || t == " ") { fox_text.setText("0"); }
        		else {
        			int t2 = Integer.parseInt(t) - 1;
        			fox_text.setText("" + t2);
        		}
	    }});
        fox_plus.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		EditText fox_text = (EditText) findViewById(R.id.fox_text);
        		String t = fox_text.getText().toString();
        		if(t == null || t == "" || t == " ") { fox_text.setText("0"); }
        		else {
        			int t2 = Integer.parseInt(t) + 1;
        			fox_text.setText("" + t2);
        		}
	    }});
        
        gray_minus.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		EditText gray_text = (EditText) findViewById(R.id.gray_text);
        		String t = gray_text.getText().toString();
        		if(t == null || t == "" || t == " ") { gray_text.setText("0"); }
        		else {
        			int t2 = Integer.parseInt(t) - 1;
        			gray_text.setText("" + t2);
        		}
	    }});
        gray_plus.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		EditText gray_text = (EditText) findViewById(R.id.gray_text);
        		String t = gray_text.getText().toString();
        		if(t == null || t == "" || t == " ") { gray_text.setText("0"); }
        		else {
        			int t2 = Integer.parseInt(t) + 1;
        			gray_text.setText("" + t2);
        		}
	    }});
        // End Squirrel Counters -------------------------------------------------------------------
        
    }// End onCreate
    
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
   
    }/* End of UseGps Activity */
//end observ