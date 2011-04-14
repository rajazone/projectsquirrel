package edu.uic.cs.projectsquirrel;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class trees extends Activity {
	
	Bundle BUNDL;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trees);

        //Import Bundle from previous activity
        BUNDL = getIntent().getExtras();
        
        //Import SeekBars from trees.xml
        SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar seekbar2 = (SeekBar) findViewById(R.id.seekBar2);
        SeekBar seekbar3 = (SeekBar) findViewById(R.id.seekBar3);
        SeekBar seekbar4 = (SeekBar) findViewById(R.id.seekBar4);
        SeekBar seekbar5 = (SeekBar) findViewById(R.id.seekBar5);
        
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
        Button guide = (Button) findViewById(R.id.Tree_Guide_Button);
        
      //NEXT BUTTON
        next.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		//Store variables in BUNDL
	    		/*SITE_DOGS = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_CATS = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_COYOTES = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_HAWKS = [X, where X is one of YES,UNSURE,NO]"
	    		* SITE_GRAIN = [X, where X is one of YES,UNSURE,NO]""
	    		*/
	            SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekBar1); //Nut_Trees
	            SeekBar seekbar2 = (SeekBar) findViewById(R.id.seekBar2); //Seed_Trees
	            SeekBar seekbar3 = (SeekBar) findViewById(R.id.seekBar3); //Fruit_Trees
	            SeekBar seekbar4 = (SeekBar) findViewById(R.id.seekBar4); //Tiny_Trees
	            SeekBar seekbar5 = (SeekBar) findViewById(R.id.seekBar5); //Con_Trees
	            
	            BUNDL.putString("NUT_TREES", getProgressValue(seekbar1.getProgress()));
	            BUNDL.putString("SEED_TREES", getProgressValue(seekbar2.getProgress()));
	            BUNDL.putString("FRUIT_TREES", getProgressValue(seekbar3.getProgress()));
	            BUNDL.putString("TINY_TREES", getProgressValue(seekbar4.getProgress()));
	            BUNDL.putString("CON_TREES", getProgressValue(seekbar5.getProgress()));
	    		
	    		//Move to next screen
	    		Intent i = new Intent(getApplicationContext(), food.class);
	    		i.putExtras(BUNDL);	//Sends BUNDL to next activity.
	            startActivity(i);
	    }});
        
        //Dynamically set width of guide button.
        int w = guide.getWidth();
        if(w < 100) { guide.setWidth(100); }
        
       //TREE GUIDE BUTTON  
        guide.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), treeguide.class);
	    		startActivity(i);
	    }});
        
	} //end of onCreate

        private OnSeekBarChangeListener SeekChange = new OnSeekBarChangeListener(){	 
		 
	        public void onProgressChanged(SeekBar seekBar, int progress,
	                        boolean fromUser) {
	        		
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
    	   if(p == 0) { return "YES"; }
    	   if(p == 1) { return "UNSURE"; }
    	   if(p == 2) { return "NO"; }
    	   return "NONE";
       }
        
} //end of class trees


