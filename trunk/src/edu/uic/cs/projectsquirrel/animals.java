package edu.uic.cs.projectsquirrel;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class animals extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals);

        //Import SeekBars from animals.xml
        SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar seekbar2 = (SeekBar) findViewById(R.id.seekBar2);
        SeekBar seekbar3 = (SeekBar) findViewById(R.id.seekBar3);
        SeekBar seekbar4 = (SeekBar) findViewById(R.id.seekBar4);
        SeekBar seekbar5 = (SeekBar) findViewById(R.id.seekBar5);
        
        //Hook SeekBars to Custom Listener (Makes a Toast telling user of their selection)
        seekbar1.setOnSeekBarChangeListener(SeekChange);
        seekbar2.setOnSeekBarChangeListener(SeekChange);
        seekbar3.setOnSeekBarChangeListener(SeekChange);
        seekbar4.setOnSeekBarChangeListener(SeekChange);
        seekbar5.setOnSeekBarChangeListener(SeekChange);
        
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
        			
        			text = "None";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        			
        		case 1:
        			text = "1-2 (per day)";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        		
        		case 2:
        			text = "3-4 (per day)";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        			
        		case 3:
        			text = "5+ (per day)";
        			toast = Toast.makeText(context, text, duration);
        			toast.show();
        			break;
        		}
	        }
        };
        
} //end of class animals


