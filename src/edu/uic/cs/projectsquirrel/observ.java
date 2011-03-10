/* Observation Activity
 * --------------------
 * Project Squirrel Form.
 * Asks user for data & adds data to log.
 * 
 */

package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.graphics.Shader;

import java.util.Date;
import java.text.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class observ extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observ);
        
        //DATA FROM XML  ---------------------------------------------------------------
        Button dateBox = (Button) findViewById(R.id.date2);	//retrieve date button
        Button timeBox = (Button) findViewById(R.id.time2); //retrieve time button
        Button locBox  = (Button) findViewById(R.id.loc2);	//retrieve location button
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
        
        //Allow users to edit location
        locBox.setOnClickListener(new View.OnClickListener(){	
        	public void onClick(View v){
        		//TODO: Create way to edit location. (EditText for entering zip code?)
	    }});
        
        //Create Divider Under Date/Time/Location
        BitmapDrawable divider = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.div));
        divider.setTileModeX(Shader.TileMode.REPEAT);
        ImageView divView = (ImageView) findViewById(R.id.div1);
        divView.setBackgroundDrawable(divider);
        //-----------------------------------------
        
    }//end onCreate
}//end observ