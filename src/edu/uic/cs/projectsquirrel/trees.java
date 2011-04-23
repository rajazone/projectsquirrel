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
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class trees extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trees);
        
        //Checking for past values
        importVars1();
        
        //Import SeekBars from trees.xml
        SeekBar seekbar1 = (SeekBar) findViewById(R.id.trees_seekBar1);
        SeekBar seekbar2 = (SeekBar) findViewById(R.id.trees_seekBar2);
        SeekBar seekbar3 = (SeekBar) findViewById(R.id.trees_seekBar3);
        SeekBar seekbar4 = (SeekBar) findViewById(R.id.trees_seekBar4);
        SeekBar seekbar5 = (SeekBar) findViewById(R.id.trees_seekBar5);
        
        seekbar1.setMax(2);
        seekbar2.setMax(2);
        seekbar3.setMax(2);
        seekbar4.setMax(2);
        seekbar5.setMax(2);
        
        //Hook SeekBars to Custom Listener (Makes a Toast telling user of their selection)
        seekbar1.setOnSeekBarChangeListener(SeekChange);
        seekbar2.setOnSeekBarChangeListener(SeekChange);
        seekbar3.setOnSeekBarChangeListener(SeekChange);
        seekbar4.setOnSeekBarChangeListener(SeekChange);
        seekbar5.setOnSeekBarChangeListener(SeekChange);

        //Import Next Button & Tree_Guide Button
        Button next = (Button) findViewById(R.id.Next_Trees);
        //Button guide = (Button) findViewById(R.id.Tree_Guide_Button);
        
        // Making text view clickable
        Button NBDesc = (Button) findViewById(R.id.trees_btn1);
        Button SBDesc = (Button) findViewById(R.id.trees_btn2);
        Button FBDesc = (Button) findViewById(R.id.trees_btn3);
        Button TSDesc = (Button) findViewById(R.id.trees_btn4);
        Button CFDesc = (Button) findViewById(R.id.trees_btn5);
        
        NBDesc.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent j = new Intent(getApplicationContext(), NBGuide.class);
				startActivity(j);
			}
		});
        
        SBDesc.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				Intent j = new Intent(getApplicationContext(), SBGuide.class);
			  startActivity(j);	
			}
		});
        
 
	 FBDesc.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			Intent j = new Intent(getApplicationContext(), FBGuide.class);
			startActivity(j);
		}
	});
 
	 TSDesc.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent j = new Intent(getApplicationContext(), TSGuide.class);
				startActivity(j);
			}
		});
 
	 CFDesc.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent j = new Intent(getApplicationContext(), CFGuide.class);
				startActivity(j);
			}
		});
 
        
      //NEXT BUTTON
        next.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		
	    		//Store variables in oberv.INFO
	    		/*SITE_DOGS = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_CATS = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_COYOTES = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_HAWKS = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_GRAIN = [X, where X is one of YES,UNSURE,NO]""
	    		*/
	            SeekBar seekbar1 = (SeekBar) findViewById(R.id.trees_seekBar1); //Nut_Trees
	            SeekBar seekbar2 = (SeekBar) findViewById(R.id.trees_seekBar2); //Seed_Trees
	            SeekBar seekbar3 = (SeekBar) findViewById(R.id.trees_seekBar3); //Fruit_Trees
	            SeekBar seekbar4 = (SeekBar) findViewById(R.id.trees_seekBar4); //Tiny_Trees
	            SeekBar seekbar5 = (SeekBar) findViewById(R.id.trees_seekBar5); //Con_Trees
	            
	            //Store Log Variables
	            observ.INFO.NUT_TREES = getProgressValue(seekbar1.getProgress());
	            observ.INFO.SEED_TREES = getProgressValue(seekbar2.getProgress());
	            observ.INFO.FRUIT_TREES = getProgressValue(seekbar3.getProgress());
	            observ.INFO.TINY_TREES = getProgressValue(seekbar4.getProgress());
	            observ.INFO.CON_TREES = getProgressValue(seekbar5.getProgress());
	    		
	    		//Move to Food screen
	    		Intent i = new Intent(getApplicationContext(), food.class);
	            startActivityForResult(i,1);
	    }});
        
       //TREE GUIDE BUTTON  ... Don't need since we have individual guides, yes?
        /*guide.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), treeguide.class);
	    		startActivity(i);
	    }});*/ 
        
	} //end of onCreate

        private OnSeekBarChangeListener SeekChange = new OnSeekBarChangeListener(){	 
		 
	        public void onProgressChanged(SeekBar seekBar, int progress,
	                        boolean fromUser) {
	        	
	        	switch(seekBar.getId())
        		{
	        		case (R.id.trees_seekBar1):
	        			observ.INFO.NUT_TREES = getProgressValue(progress);
	        			break;
	        		case (R.id.trees_seekBar2):
	        			observ.INFO.SEED_TREES = getProgressValue(progress);
	        			break;
	        		case (R.id.trees_seekBar3):
	        			observ.INFO.FRUIT_TREES = getProgressValue(progress);
	        			break;
	        		case (R.id.trees_seekBar4):
	        			observ.INFO.TINY_TREES = getProgressValue(progress);
	        			break;
	        		case (R.id.trees_seekBar5):
	        			observ.INFO.CON_TREES = getProgressValue(progress);
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
        			
        			text = "Yes";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        			
        		case 1:
        			text = "Unsure";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        		
        		case 2:
        			text = "No";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        			
        		
        		}
	        }
        };
        
       //Convert Number 0-2 into String = Yes/Unsure/No
       public String getProgressValue(int p)
       {
    	   	if(p == 0) 		{ return "NO"; }
    	   	if(p == 1) 		{ return "UNSURE"; }
    	   	if(p == 2) 		{ return "YES"; }
    	   	return "NONE";
       }
       
       private int getIntProgressValue(String p) {
   		
   		 	if(p == "NO")  		{ return 0; }
   		 	if(p == "UNSURE") 	{ return 1; }
   		 	if(p == "YES") 		{ return 2; }
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
       
       
       private void importVars1()
       {
           SeekBar seekbar1 = (SeekBar) findViewById(R.id.trees_seekBar1); //Nut_trees
           SeekBar seekbar2 = (SeekBar) findViewById(R.id.trees_seekBar2); //Seed_Trees
           SeekBar seekbar3 = (SeekBar) findViewById(R.id.trees_seekBar3); //Fruit_Trees
           SeekBar seekbar4 = (SeekBar) findViewById(R.id.trees_seekBar4); //Tiny_Trees
           SeekBar seekbar5 = (SeekBar) findViewById(R.id.trees_seekBar5); //Con_Trees
           
           //Import Log Variables
           if(observ.INFO.NUT_TREES != null && observ.INFO.NUT_TREES.length() > 0)
           {
                   seekbar1.setProgress(getIntProgressValue(observ.INFO.NUT_TREES));
           }
           if(observ.INFO.SEED_TREES != null && observ.INFO.SEED_TREES.length() > 0)
           {
                   seekbar2.setProgress(getIntProgressValue(observ.INFO.SEED_TREES));
           }
           if(observ.INFO.FRUIT_TREES != null && observ.INFO.FRUIT_TREES.length() > 0)
           {
                   seekbar3.setProgress(getIntProgressValue(observ.INFO.FRUIT_TREES));
           }
           if(observ.INFO.TINY_TREES != null && observ.INFO.TINY_TREES.length() > 0)
           {
                   seekbar4.setProgress(getIntProgressValue(observ.INFO.TINY_TREES));
           }
           if(observ.INFO.CON_TREES != null && observ.INFO.CON_TREES.length() > 0)
           {
                   seekbar5.setProgress(getIntProgressValue(observ.INFO.CON_TREES));
           }
       }

	
        
} //end of class trees


