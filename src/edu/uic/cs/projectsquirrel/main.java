/* Main/Startup Page
 * -----------------
 * Displays Title & Navigation Buttons
 * 
 */

package edu.uic.cs.projectsquirrel;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button newObs = (Button) findViewById(R.id.button1);
        Button sqGuide = (Button) findViewById(R.id.button2);
        
        //Set listener for "New Observation" button on main screen.
        newObs.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), observ.class);
	            startActivity(i);
	    }});
        
        
    }//end onCreate
}//end main