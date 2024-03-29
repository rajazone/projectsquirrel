/* Observation Activity
 * --------------------
 * Project Squirrel Form.
 * Asks user for data & adds data to log.
 * 
 */

package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.graphics.Shader;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.io.IOException;
import java.lang.String;

import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class observ extends Activity {
	
	private int mYear;
    private int mMonth;
    private int mDay;
    private String Day;
    private String Month;
    private String Year;
    
    private int mHour;
    private int mMinute;
    private String Hour;
    private String Minute;
    private String ampm;

    static final int CHECK_EXIT_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 2;
    static final int NO_ZIP_DIALOG_ID = 3;
    static final int INVALID_ZIP_ID = 4;
    static final int DATE_DIALOG_ID = 1;
    
    public static Variables INFO = new Variables();	//Used to store all Log data.
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observ);
        
        final LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        
        //DATA FROM XML  ---------------------------------------------------------------
        Button dateBox = (Button) findViewById(R.id.date2);	//retrieve date button
        Button timeBox = (Button) findViewById(R.id.time2); //retrieve time button
        Button next = (Button) findViewById(R.id.nextButton);
        Button cancel = (Button) findViewById(R.id.cancelButton);
        Button guide = (Button) findViewById(R.id.guideButton);
        Button useGPS = (Button) findViewById(R.id.useGPS);
        
        
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
        
        
        INFO.Day = day;
        INFO.Month = month;
        INFO.Year = date.substring(s2+1);
        INFO.Hour = hour;
        INFO.Minute = minute;
        INFO.AMPM = time.substring(sp+1);
        
        //--------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------
        
        //Allow users to edit date
        dateBox.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		//TODO: Create widget DatePicker in a dialog to be displayed at this point.
        		//BUNDL.Day,Month,Year = this new entry
        		showDialog(DATE_DIALOG_ID);
        		
	    }});
     // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        updateDisplay();
        

        //Allow users to edit time
        timeBox.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		//TODO: Create widget TimePicker in a dialog to be displayed at this point.
        		//BUNDL.Hour,Minute,AMPM = this new entry
        		showDialog(TIME_DIALOG_ID);
	    }});
        
        
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        
        updateDisplay();
        
        //NEXT BUTTON
        next.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    			//Store squirrel variables in Log Variables (INFO)
		    		EditText fox_text = (EditText) findViewById(R.id.fox_text);
		            EditText gray_text = (EditText) findViewById(R.id.gray_text);
		            
		            if(fox_text.getText().length() < 1)
		            {
		            	fox_text.setText("0");
		            }
		            if(gray_text.getText().length() < 1)
		            {
		            	gray_text.setText("0");
		            }
		            
		            INFO.NUM_FOX_SQUIRRELS = fox_text.getText().toString();
		            INFO.NUM_GRAY_SQUIRRELS = gray_text.getText().toString();
		            
		            //Store Setting
		            String[] setting = getResources().getStringArray(R.array.setting_array);	//Load setting array
		            Spinner spin = (Spinner) findViewById(R.id.spinner1);						//Load Spinner
		            int s = spin.getSelectedItemPosition();										//Load current selection on spinner
		            INFO.SETTING = setting[s];													//Store setting[position] (= String)
		            
		            EditText txt = (EditText) findViewById(R.id.editText1);
		            String str = txt.getText().toString();
		 
		           if((str.length()<5) || (str.length()>5 && str.length()<9)|| (str.length()>9)) // To avoid invalid zip code
		            {
		            	showDialog(INVALID_ZIP_ID);
		            }
		            else
		            {
		            	INFO.ZIP = txt.getText().toString();
		            	Intent i = new Intent(getApplicationContext(), animals.class);
		            	startActivityForResult(i,1);
		            }
	    }});
        
        useGPS.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// LOCATION --------------------------------------------------------------------------------
		        // Acquire a reference to the system Location Manager
		        

				//
		        //
		        //
		        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
		            buildAlertMessageNoGps();
		        }
		        else
		        {

					//
		        //
		        //
		        // Define a listener that responds to location updates
		        	NetworkInfo info = ((ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE)).
		            getActiveNetworkInfo();

		            if (info == null || !info.isConnected()) {
		            	buildAlertMessageNoData();
		            }
		            else
		            {
		        
		            	/*Context context = getApplicationContext();
		            	CharSequence text = info.getSubtypeName();
		            	int duration = Toast.LENGTH_SHORT;

		            	Toast toast = Toast.makeText(context, text, duration);
		            	toast.show();*/
		        
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
		               //String Text = addresses.get(0).getLocality();
		                EditText txt = (EditText) findViewById(R.id.editText1);
		                txt.setText(addresses.get(0).getPostalCode()); 

		                //Store variables in INFO
		                INFO.LATITUDE = String.valueOf(loc.getLatitude());
		                INFO.LONGITUDE = String.valueOf(loc.getLongitude());
		                
		                String zip = String.valueOf(addresses.get(0).getPostalCode());
		                INFO.ZIP = zip;
		                txt.setText(zip);	//Show location in text box
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
		            
		            //TODO: (Robin) If GPS is disabled & user is about to submit data...
		            //- Grab zip code from  (EditText) findViewById(R.id.editText1);
		            // CHECK
		            //- If zip code does not exist, inform user
		            //	CHECK
		            //- Else convert zip code into approx. latitude & logitude
		            //- Store zip code, lat. & long. as Strings into bundl with key names LATITUDE, LOGITUDE, ZIP -> BUNDL.putString("key", "value");
		            // CHECK

		        // Register the listener with the Location Manager to receive location updates
		        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		        }
		        
		       // *
		       // *
		       // *
		        
				
			}
			
		}}
        );
        
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
        			if(t2 < 0) { t2 = 0; } //Prevents negative numbers.
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
        			if(t2 < 0) { t2 = 0; } //Prevents negative numbers.
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
   
    

    
    private void updateDisplay() {
		// TODO Auto-generated method stub
    	
    	//Update the Date when changed
    	Button dateBox = (Button) findViewById(R.id.date2);	//retrieve date button
    	Button timeBox = (Button) findViewById(R.id.time2); //retrieve time button
                
                        // Month is 0 based so add 1
    					if(mMonth > 8)
    						Month = String.valueOf((mMonth + 1));
    					else
    						Month = "0"+String.valueOf((mMonth + 1));
    					
                        if(String.valueOf(mDay).length()==1)
                        	Day = ("0"+String.valueOf(mDay)+"/");
                        else
                        Day = String.valueOf(mDay);
                        Year = String.valueOf(mYear).substring(2);
                        

                        dateBox.setText(Month+"/"+Day+"/"+Year);
                        
                        //Update Log Variables
                        INFO.Day = Day;
                        INFO.Month = Month;
                        INFO.Year = Year;
                        
        //Update the Time when it is changed
                        if(mHour<12)
                        {
                        	if(mHour<10)
                        	{
                        	Hour = "0"+String.valueOf(mHour);
                        	}
                        	else
                        	{
                        		Hour = String.valueOf(mHour);
                        	}
                        	if((mHour)==0)
                        	{
                        		Hour = "12";
                        	}
                        		ampm = "AM";
                        }
                        else
                        {
                        	Hour = String.valueOf(mHour-12);
                        	if(Hour.length()==1)
                        	{
                        		Hour = "0"+Hour;
                        	}
                        	if((mHour-12)==0)
                        	{
                        		Hour = "12";
                        	}
                        	ampm = "PM";
                        }
                        if(mMinute<10)
                        {
                        	Minute = "0"+String.valueOf(mMinute);
                        }
                        else
                        {
                        	Minute = String.valueOf(mMinute);
                        }
                        timeBox.setText(Hour+":"+Minute+ " " + ampm);
                        
                        //Update Log Variables
                        INFO.Hour = Hour;
                        INFO.Minute = Minute;
                        INFO.AMPM = ampm;
	}
 // the callback received when the user "sets" the time in the dialog
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
        new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                updateDisplay();
            }
        };
 // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };



	@Override
	protected Dialog onCreateDialog(int i) 
	{
    	Dialog dialog = null;
    	AlertDialog alert;
    	AlertDialog.Builder builder;
		switch(i) {
		case 0:
			builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure you wish to exit? Data will be lost.")
			       .setCancelable(false)
			       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	    observ.INFO.clearAll();
			                observ.this.finish();
			           }
			       })
			       .setNegativeButton("No", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       });
			alert = builder.create();
			return alert;
		case DATE_DIALOG_ID:
	        return new DatePickerDialog(this,
	                    mDateSetListener,
	                    mYear, mMonth, mDay);
		case TIME_DIALOG_ID:
	        return new TimePickerDialog(this,
	                mTimeSetListener, mHour, mMinute, false);
		
		/*case NO_ZIP_DIALOG_ID:
		    builder = new AlertDialog.Builder(this);
			builder.setMessage("You need to enter a zip code.")
			       .setCancelable(false)
			       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   dialog.cancel();
			           }
			       });
			 alert = builder.create();
			 return alert;*/
		
		case INVALID_ZIP_ID:
		    builder = new AlertDialog.Builder(this);
			builder.setMessage("Please enter a valid zip code. Zip code should be 5 digits long.")
			       .setCancelable(false)
			       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   dialog.cancel();
			           }
			       });
			 alert = builder.create();
			 return alert;
	    
		}
		
		return dialog;
	}
    private void buildAlertMessageNoGps() {
    	 //final LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                       //launchGPSOptions(); 
                	   Intent myIntent = new Intent( Settings.ACTION_SECURITY_SETTINGS );
                	    startActivity(myIntent);
                	  
                	    
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                   }
               });
        final AlertDialog alert = builder.create();
        alert.show();
        
    }
    
    private void buildAlertMessageNoData() {
   	 //final LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
       final AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setMessage("You need your data connection to use GPS. Would you like to activate that now?")
              .setCancelable(false)
              .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                      //launchGPSOptions(); 
               	  Intent myIntent = new Intent( Settings.ACTION_SETTINGS );
               	  startActivity(myIntent);
               	  
               	    
                  }
              })
              .setNegativeButton("No", new DialogInterface.OnClickListener() {
                  public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                       dialog.cancel();
                  }
              });
       final AlertDialog alert = builder.create();
       alert.show();
       
   }
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            showDialog(0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    //Customize Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_alt, menu);
    	return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId())
    	{
			//View "About Us"
			case R.id.menu_about2:
				Intent i2 = new Intent(getApplicationContext(), about.class);
	            startActivity(i2);
				return true;
			
			//Visit Web Site	
			case R.id.menu_web2:
				String url = "http://www.projectsquirrel.org/";
				Intent i3 = new Intent(Intent.ACTION_VIEW);
				i3.setData(Uri.parse(url));
				startActivity(i3);
				return true;
			
			default:
				return super.onOptionsItemSelected(item);
    	}
    }
   
    
    //ON NEXT ACTIVITY FINISH
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // If the request went well (OK)
        if(resultCode == Activity.RESULT_OK) {
        	Intent intent = getIntent();
     	   	setResult(RESULT_OK, intent);
        	finish();
        }
    }
    
    
    }/* End of UseGps Activity */
//end observ