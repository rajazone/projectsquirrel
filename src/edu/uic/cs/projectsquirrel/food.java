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

public class food extends Activity{
	
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food); 
        
        importVars2();
        
        SeekBar sb1 = (SeekBar) findViewById(R.id.food_seekBar1); //Bird Feeder
        SeekBar sb2 = (SeekBar) findViewById(R.id.food_seekBar2); //Humans
        SeekBar sb3 = (SeekBar) findViewById(R.id.food_seekBar3); //Trees
        SeekBar sb4 = (SeekBar) findViewById(R.id.food_seekBar4); //Garbage
        SeekBar sb5 = (SeekBar) findViewById(R.id.food_seekBar5); //Others
        
        sb1.setMax(3);
        sb2.setMax(3);
        sb3.setMax(3);
        sb4.setMax(3);
        sb5.setMax(3);
        
        sb1.setOnSeekBarChangeListener(SeekChange);
        sb2.setOnSeekBarChangeListener(SeekChange);
        sb3.setOnSeekBarChangeListener(SeekChange);
        sb4.setOnSeekBarChangeListener(SeekChange);
        sb5.setOnSeekBarChangeListener(SeekChange);

        
       //button on food.xml
        Button next = (Button) findViewById(R.id.Next_Food);
      //NEXT BUTTON
        next.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		
	            SeekBar seekbar1 = (SeekBar) findViewById(R.id.food_seekBar1); //Bird Feeder
	            SeekBar seekbar2 = (SeekBar) findViewById(R.id.food_seekBar2); //Humans
	            SeekBar seekbar3 = (SeekBar) findViewById(R.id.food_seekBar3); //Trees
	            SeekBar seekbar4 = (SeekBar) findViewById(R.id.food_seekBar4); //Garbage
	            SeekBar seekbar5 = (SeekBar) findViewById(R.id.food_seekBar5); //Others
	            TextView othertxt = (TextView) findViewById(R.id.food_editText1);

	            observ.INFO.FEED_BIRD_FEEDER = getProgressValue(seekbar1.getProgress());
	            observ.INFO.FEED_HANDOUTS = getProgressValue(seekbar2.getProgress());
	            observ.INFO.FEED_TREES = getProgressValue(seekbar3.getProgress());
	            observ.INFO.FEED_GARBAGE = getProgressValue(seekbar4.getProgress());
	            observ.INFO.FEED_OTHER = getProgressValue(seekbar5.getProgress());
	            
	            if(othertxt.getText() != null)
	            {
	            	observ.INFO.FEED_OTHER_DETAILS = othertxt.getText().toString();
	            }
	            

	    		//Move to next screen - compare
	    		Intent i = new Intent(getApplicationContext(), compare2.class);
	            startActivityForResult(i,1);
	    }});
      
        
    }//End onCreate
	
	
	private OnSeekBarChangeListener SeekChange = new OnSeekBarChangeListener(){	 
		
        public void onProgressChanged(SeekBar seekBar, int progress,
                        boolean fromUser) {
        	switch(seekBar.getId())
    		{
        		case (R.id.food_seekBar1):
        			observ.INFO.FEED_BIRD_FEEDER = getProgressValue(progress);
        			break;
        		case (R.id.food_seekBar2):
        			observ.INFO.FEED_HANDOUTS = getProgressValue(progress);
        			break;
        		case (R.id.food_seekBar3):
        			observ.INFO.FEED_TREES = getProgressValue(progress);
        			break;
        		case (R.id.food_seekBar4):
        			observ.INFO.FEED_GARBAGE = getProgressValue(progress);
        			break;
        		case (R.id.food_seekBar5):
        			observ.INFO.FEED_OTHER = getProgressValue(progress);
        			break;
    		
    		}
        	
        	TextView othertxt = (TextView) findViewById(R.id.food_editText1);
        	if(othertxt.getText() != null)
            {
            	observ.INFO.FEED_OTHER_DETAILS = othertxt.getText().toString();
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
    			
    			text = "Never";
    			toast = Toast.makeText(context, text, duration);
    			toast.show();
    			break;
    			
    		case 1:
    			text = "Seldom";
    			toast = Toast.makeText(context, text, duration);
    			toast.show();
    			break;
    		
    		case 2:
    			text = "Often";
    			toast = Toast.makeText(context, text, duration);
    			toast.show();
    			break;
    			
    		case 3:
    			text = "Regularly";
    			toast = Toast.makeText(context, text, duration);
    			toast.show();
    			break;
    		}
        }
    };
    
   public String getProgressValue(int p)
   {
	   if(p == 1) { return "SELDOM"; }
	   if(p == 2) { return "OFTEN"; }
	   if(p == 3) { return "REGULARLY"; }
	   return "NEVER";
   }
   
   private int getIntProgressValue(String p) {
		
	   if(p == "SELDOM") { return 1; }
	   if(p == "OFTEN") { return 2; }
	   if(p == "REGULARLY") { return 3; }
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
    
    
    private void importVars2()
    {
    	SeekBar seekbar1 = (SeekBar) findViewById(R.id.food_seekBar1); //Bird Feeder
        SeekBar seekbar2 = (SeekBar) findViewById(R.id.food_seekBar2); //Humans
        SeekBar seekbar3 = (SeekBar) findViewById(R.id.food_seekBar3); //Trees
        SeekBar seekbar4 = (SeekBar) findViewById(R.id.food_seekBar4); //Garbage
        SeekBar seekbar5 = (SeekBar) findViewById(R.id.food_seekBar5); //Others
        TextView othertxt = (TextView) findViewById(R.id.food_editText1);
        
        //Import Log Variables
        if(observ.INFO.FEED_BIRD_FEEDER != null && observ.INFO.FEED_BIRD_FEEDER.length() > 0)
        {
                seekbar1.setProgress(getIntProgressValue(observ.INFO.FEED_BIRD_FEEDER));
        }
        if(observ.INFO.FEED_HANDOUTS != null && observ.INFO.FEED_HANDOUTS.length() > 0)
        {
                seekbar2.setProgress(getIntProgressValue(observ.INFO.FEED_HANDOUTS));
        }
        if(observ.INFO.FEED_TREES != null && observ.INFO.FEED_TREES.length() > 0)
        {
                seekbar3.setProgress(getIntProgressValue(observ.INFO.FEED_TREES));
        }
        if(observ.INFO.FEED_GARBAGE != null && observ.INFO.FEED_GARBAGE.length() > 0)
        {
                seekbar4.setProgress(getIntProgressValue(observ.INFO.FEED_GARBAGE));
        }
        if(observ.INFO.FEED_OTHER != null && observ.INFO.FEED_OTHER.length() > 0)
        {
                seekbar5.setProgress(getIntProgressValue(observ.INFO.FEED_OTHER));
        }
        if(observ.INFO.FEED_OTHER_DETAILS != null && observ.INFO.FEED_OTHER_DETAILS.length()>0)
        {
        		othertxt.setText(observ.INFO.FEED_OTHER_DETAILS);
        }
    }

	
    
}//End class food
