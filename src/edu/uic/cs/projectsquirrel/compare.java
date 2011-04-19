package edu.uic.cs.projectsquirrel;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class compare extends Activity{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare); 

        //submit button on compare.xml
        Button submit = (Button) findViewById(R.id.submit_button);
      
        //Submit BUTTON
        submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Store the rest of the variables
		     /*   TextView emailid = (TextView) findViewById(R.id.email_editText);
	        RadioGroup comparecount = (RadioGroup) findViewById(R.id.radioGroup1);
	        RadioGroup prevsurvey = (RadioGroup) findViewById(R.id.radioGroup2);
	        TextView othersite = (TextView) findViewById(R.id.othersite_editText);
	        */
				
				
				
				//Submit final data to Log
				try {
					observ.INFO.makeLog();
				} catch (IOException e) {
					 Toast.makeText(getApplicationContext(), "Error Storing Log Data.", Toast.LENGTH_SHORT).show();
				}
				
				Intent i = new Intent(getApplicationContext(), finalscreen.class);
	            startActivityForResult(i,1);
			}
		});
                
        
    }//End onCreate
        

    //Customize Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_alt, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
                        //View "About Us"
                        case R.id.menu_about:
                                Intent i2 = new Intent(getApplicationContext(), finalscreen.class);
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
    
    //ON NEXT ACTIVITY FINISH
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {    	
        // If the request went well (OK)
        if(resultCode == Activity.RESULT_OK) {
     	   	Intent intent = getIntent();
     	   	setResult(RESULT_OK, intent);
        	finish();
        }

        else 
        {
        	
        } 
    }

}//End class compare
