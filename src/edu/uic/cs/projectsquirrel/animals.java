package edu.uic.cs.projectsquirrel;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class animals extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals);
        
        //Check For Past Data
        importVars();
        
        
        //Import SeekBars from animals.xml
        SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar seekbar2 = (SeekBar) findViewById(R.id.seekBar2);
        SeekBar seekbar3 = (SeekBar) findViewById(R.id.seekBar3);
        SeekBar seekbar4 = (SeekBar) findViewById(R.id.seekBar4);
        SeekBar seekbar5 = (SeekBar) findViewById(R.id.seekBar5);

        seekbar1.setMax(3);
        seekbar2.setMax(3);
        seekbar3.setMax(3);
        seekbar4.setMax(3);
        seekbar5.setMax(3);
        
        
        //Hook SeekBars to Custom Listener (Makes a Toast telling user of their selection)
        seekbar1.setOnSeekBarChangeListener(SeekChange);
        seekbar2.setOnSeekBarChangeListener(SeekChange);
        seekbar3.setOnSeekBarChangeListener(SeekChange);
        seekbar4.setOnSeekBarChangeListener(SeekChange);
        seekbar5.setOnSeekBarChangeListener(SeekChange);

        //Import Next Button
        Button next = (Button) findViewById(R.id.Next_Animals);
        
        //NEXT BUTTON
        next.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		//Store variables in BUNDL
	    		/*SITE_DOGS = [X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	    		* SITE_CATS = [X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	    		* SITE_COYOTES = [X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	    		* SITE_HAWKS = [X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	    		* SITE_GRAIN = [X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	    		*/
	            SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekBar1); //Dogs
	            SeekBar seekbar2 = (SeekBar) findViewById(R.id.seekBar2); //Cats
	            SeekBar seekbar3 = (SeekBar) findViewById(R.id.seekBar3); //Coyotes
	            SeekBar seekbar4 = (SeekBar) findViewById(R.id.seekBar4); //Hawks
	            SeekBar seekbar5 = (SeekBar) findViewById(R.id.seekBar5); //Grain
	            
	            //Store Log Variables
	            observ.INFO.SITE_DOGS = getProgressValue(seekbar1.getProgress());
	            observ.INFO.SITE_CATS = getProgressValue(seekbar2.getProgress());
	            observ.INFO.SITE_COYOTES = getProgressValue(seekbar3.getProgress());
	            observ.INFO.SITE_HAWKS = getProgressValue(seekbar4.getProgress());  
	            observ.INFO.SITE_GRAIN = getProgressValue(seekbar5.getProgress());
	            
	            //Move to Trees screen
	            Intent i = new Intent(getApplicationContext(), trees.class);
            	startActivityForResult(i,1);
	    }});
        
        
	} //end of onCreate

        private OnSeekBarChangeListener SeekChange = new OnSeekBarChangeListener(){	 
		 
	        public void onProgressChanged(SeekBar seekBar, int progress,
	                        boolean fromUser) {
	        	
	        	switch(seekBar.getId())
        		{
	        		case (R.id.seekBar1):
	        			observ.INFO.SITE_DOGS = getProgressValue(progress);
	        			break;
	        		case (R.id.seekBar2):
	        			observ.INFO.SITE_CATS = getProgressValue(progress);
	        			break;
	        		case (R.id.seekBar3):
	        			observ.INFO.SITE_COYOTES = getProgressValue(progress);
	        			break;
	        		case (R.id.seekBar4):
	        			observ.INFO.SITE_HAWKS = getProgressValue(progress);
	        			break;
	        		case (R.id.seekBar5):
	        			observ.INFO.SITE_GRAIN = getProgressValue(progress);
	        			break;
        		
        		}
	        	
	        }
	
	        public void onStartTrackingTouch(SeekBar seekBar) {
	
	        }
	
	        public void onStopTrackingTouch(SeekBar seekBar) {
	        	
        		Context context = getApplicationContext();
        		int duration = Toast.LENGTH_SHORT;
        		CharSequence text;
        		Toast toast;
        		
        		switch (seekBar.getProgress()) {
        		case 0:
        			
        			text = "None";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        			
        		case 1:
        			if(seekBar.getId() == R.id.seekBar3 || seekBar.getId() == R.id.seekBar4 || seekBar.getId() == R.id.seekBar5)
        			{
        				text = "you see them if you're lucky";
        			}
        			else
        			{
        				text = "1-2 (per day)";
        			}
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        		
        		case 2:
        			if(seekBar.getId() == R.id.seekBar3 || seekBar.getId() == R.id.seekBar4 || seekBar.getId() == R.id.seekBar5)
        			{
        				text = "you see them if you're looking for them";
        			}
        			else
        			{
        				text = "3-4 (per day)";
        			}
        			
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        			
        		case 3:
        			if(seekBar.getId() == R.id.seekBar3 || seekBar.getId() == R.id.seekBar4 || seekBar.getId() == R.id.seekBar5)
        			{
        				text = "you see them regularly";
        			}
        			else
        			{
        				text = "5+ (per day)";
        			}
        			
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        		}
	        }
        };
        
       //Convert Number 0-3 into String = NONE/LOW/MEDIUM/HIGH
       public String getProgressValue(int p)
       {
    	   if(p == 1) { return "LOW"; }
    	   if(p == 2) { return "MEDIUM"; }
    	   if(p == 3) { return "HIGH"; }
    	   return "NONE";
       }
       
     //String = NONE/LOW/MEDIUM/HIGH to number 0-3
       public int getIntProgressValue(String p)
       {
    	   if(p == "LOW") 		{ return 1; }
    	   if(p == "MEDIUM") { return 2; }
    	   if(p == "HIGH") { return 3; }
    	   return 0;
       }
       
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

           else 
           {
           	
           } 
       }
       
       private void importVars()
       {
    	   SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekBar1); //Dogs
           SeekBar seekbar2 = (SeekBar) findViewById(R.id.seekBar2); //Cats
           SeekBar seekbar3 = (SeekBar) findViewById(R.id.seekBar3); //Coyotes
           SeekBar seekbar4 = (SeekBar) findViewById(R.id.seekBar4); //Hawks
           SeekBar seekbar5 = (SeekBar) findViewById(R.id.seekBar5); //Grain
           
           //Import Log Variables
           //If variable length = 0, then the variable was never set to anything.
           //Else, data was previously stored and needs to be retrieved.
           //This method calls getIntProgressValue() [SEE LINE ~142]
           //		Which converts the String [NONE/LOW/MEDIUM/HIGH] to 0,1,2 or 3.
           if(observ.INFO.SITE_DOGS.length() > 0)
           {
        	   //Set seekBar corresponding to variable SITE_DOGS to the correct value.
        	   seekbar1.setProgress(getIntProgressValue(observ.INFO.SITE_DOGS));
           }
           if(observ.INFO.SITE_CATS.length() > 0)
           {
        	   seekbar2.setProgress(getIntProgressValue(observ.INFO.SITE_CATS));
           }
           if(observ.INFO.SITE_COYOTES.length() > 0)
           {
        	   seekbar3.setProgress(getIntProgressValue(observ.INFO.SITE_COYOTES));
           }
           if(observ.INFO.SITE_HAWKS.length() > 0)
           {
        	   seekbar4.setProgress(getIntProgressValue(observ.INFO.SITE_HAWKS));
           }
           if(observ.INFO.SITE_GRAIN.length() > 0)
           {
        	   seekbar5.setProgress(getIntProgressValue(observ.INFO.SITE_GRAIN));
           }
       }
        
} //end of class animals


