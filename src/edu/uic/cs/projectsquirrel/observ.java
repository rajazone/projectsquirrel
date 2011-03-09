/* Observation Activity
 * --------------------
 * Project Squirrel Form.
 * Asks user for data & adds data to log.
 * 
 */

package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Date;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class observ extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observ);
        
        Button dateBox = (Button) findViewById(R.id.date2);
        Button timeBox = (Button) findViewById(R.id.time2); 
        
        Date dte = new Date();
        int hr = dte.getHours();		//current hour
        int min = dte.getMinutes();		//current minute
        String time = hr + ":" + min;	//TODO: Include AM/PM to time
        
        int mon = dte.getMonth(); 		 //current month
        int day = dte.getDate();		 //current day
        int year = dte.getYear() + 1900; //current year 
        String date = mon + "/" + day + "/" + year;
        
        //Set day & Time to screen
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
        
    }//end onCreate
}//end observ