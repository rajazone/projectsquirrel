/* Main/Startup Page
 * -----------------
 * Displays Title & Navigation Buttons
 * 
 */

package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
	    	@Override
			public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), observ.class);
	            startActivity(i);
	    }});
        
      //Set listener for "Squirrel Guide" button on main screen.
        sqGuide.setOnClickListener(new View.OnClickListener(){	
	    	@Override
			public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), sqguide.class);
	            startActivity(i);
	    }});
        
        
    }//end onCreate
     
   
  //Customize Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_main, menu);
    	return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId())
    	{
    		//Start New Obervation
	    	case R.id.menu_new:	
				Intent i = new Intent(getApplicationContext(), observ.class);
	            startActivity(i);
				return true;
			
			//View "About Us"
			case R.id.menu_about:
				Intent i2 = new Intent(getApplicationContext(), about.class);
	            startActivity(i2);
				return true;
			
			//Visit Web Site	
			case R.id.menu_web:
				String url = "http://www.projectsquirrel.org/";
				Intent i3 = new Intent(Intent.ACTION_VIEW);
				i3.setData(Uri.parse(url));
				startActivity(i3);
				return true;
			
			default:
				return super.onOptionsItemSelected(item);
    	}
    }
    
}//end main