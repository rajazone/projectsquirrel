package edu.uic.cs.projectsquirrel;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class compare2 extends Activity{
	
	Bundle BUNDL;
	final static int INVALID_EMAIL_ID=1;
	final static int INVALID_RADIOBUTTONS = 2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare2); 
        
        importVars3();
        
        //Submit button on compare2.xml
        Button submit = (Button) findViewById(R.id.submit);
        
        TextView email_id = (TextView)findViewById(R.id.email_edit);
        SeekBar comparecount = (SeekBar)findViewById(R.id.compare_seekBar);
		comparecount.setMinimumWidth(100);
        TextView comments = (TextView) findViewById(R.id.compare_editText1);		   
      
        //Submit BUTTON
        submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				TextView email_id = (TextView)findViewById(R.id.email_edit);
				//SeekBar comparecount = (SeekBar)
		        TextView comments = (TextView) findViewById(R.id.compare_editText1);
		        SeekBar comparecount = (SeekBar)findViewById(R.id.compare_seekBar);
		        RadioGroup group1 = (RadioGroup) findViewById(R.id.radioGroup_previous);
		        RadioGroup group2 = (RadioGroup) findViewById(R.id.radioGroup_other);
		       
		        String validate_email= email_id.getText().toString();
		        if(!(validate_email.matches("[a-z0-9]+@[a-z0-9]+\\.[a-z]+")))
		        {
		        	showDialog(INVALID_EMAIL_ID);

		        }
		        else if(group1.getCheckedRadioButtonId() == -1 || group2.getCheckedRadioButtonId() == -1)
		        {
		        	showDialog(INVALID_RADIOBUTTONS);
		        }
		        
		        else
		        {
		        	TextView email = (TextView) findViewById(R.id.email_edit);	        		
	        		RadioButton newSite = (RadioButton) findViewById (R.id.radio0);
	        		RadioButton pastData = (RadioButton) findViewById (R.id.radio2);
	        		
	        		//STORE RADIO BUTTON VALUES
	        		if(newSite.isChecked())	//User HAS submitted data for this site
	        		{
	        			observ.INFO.THIS_NEW_SITE = "YES";
	        		}
	        		else //User HAS NOT submitted data for this site
	        		{
	        			observ.INFO.THIS_NEW_SITE = "NO";
	        		}
	        		if(pastData.isChecked()) //user HAS submitted past data
	        		{
	        			observ.INFO.USED_DIFFERENT_SITE = "YES";
	        		}
	        		else //user HAS NOT submitted past data
	        		{
	        			observ.INFO.USED_DIFFERENT_SITE = "NO";
	        		}
	        		
	        		//STORE COMMENTS
	        		if(comments.getText() != null)
	                {
	                	observ.INFO.COMMENTS = comments.getText().toString();
	                }
	        		
	        		//STORE EMAIL && SEEKBAR
	        		observ.INFO.EMAIL = email.getText().toString();
	        		observ.INFO.NUM_SQUIRREL_CHANGE = getProgressValue(comparecount.getProgress());
	        		
		        	//SUBMIT ALL DATA TO LOG
					try {
						observ.INFO.makeLog();
					} catch (IOException e) {
						 Toast.makeText(getApplicationContext(), "Error Storing Log Data.", Toast.LENGTH_SHORT).show();
					}
					
					observ.INFO.clearAll();
					
		        	Intent i = new Intent(getApplicationContext(), finalscreen.class);
		            startActivityForResult(i,1);
					
		        }//End else
			}//end onClick
		}); //end Submit button listener
                
        
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
    
    public String getProgressValue(int p)
    {
 	   if(p == 1) { return "SAME"; }
 	   if(p == 2) { return "INCREASED"; }
 	   return "DECREASED";
    }
    
    private int getIntProgressValue(String p) {
 		
 	   if(p.equals("SAME")) 		{ return 1; }
 	   if(p.equals("INCREASED")) 	{ return 2; }
 	   return 0;
 	}

    protected Dialog onCreateDialog(int i) 
	{
		Dialog dialog = null;
    	AlertDialog alert;
    	AlertDialog.Builder builder;
    	switch (i)
    	{
    	case INVALID_EMAIL_ID:
    		builder = new AlertDialog.Builder(this);
			builder.setMessage("Please enter a valid email id")
			       .setCancelable(false)
			       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   dialog.cancel();
			           }
			       });
			 alert = builder.create();
			 return alert;
    	case INVALID_RADIOBUTTONS:
    		builder = new AlertDialog.Builder(this);
			builder.setMessage("Please answer the two obervation site questions on this screen.")
			       .setCancelable(false)
			       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   dialog.cancel();
			           }
			       });
			 alert = builder.create();
			 return alert;
    	
    	}
		return dialog;
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
    
    //On back button pressed, save variables.
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            
        	TextView email = (TextView)findViewById(R.id.email_edit);
            SeekBar comparecount = (SeekBar)findViewById(R.id.compare_seekBar);
            TextView comments = (TextView) findViewById(R.id.compare_editText1);	 
            RadioButton newSite = (RadioButton) findViewById (R.id.radio0);
    		RadioButton pastData = (RadioButton) findViewById (R.id.radio2);
    		
    		if(newSite.isChecked())	//User HAS submitted data for this site
    		{
    			observ.INFO.THIS_NEW_SITE = "YES";
    		}
    		else //User HAS NOT submitted data for this site
    		{
    			observ.INFO.THIS_NEW_SITE = "NO";
    		}
    		if(pastData.isChecked()) //user HAS submitted past data
    		{
    			observ.INFO.USED_DIFFERENT_SITE = "YES";
    		}
    		else //user HAS NOT submitted past data
    		{
    			observ.INFO.USED_DIFFERENT_SITE = "NO";
    		}
            
    		if(email.getText() != null)
    		{	
    			observ.INFO.EMAIL = email.getText().toString();
    		}
    		
    		observ.INFO.NUM_SQUIRREL_CHANGE = getProgressValue(comparecount.getProgress());
    		
    		if(comments.getText() != null)
            {
            	observ.INFO.COMMENTS = comments.getText().toString();
            }
    		
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
    
    private void importVars3()
    {
    	TextView email = (TextView)findViewById(R.id.email_edit);
        SeekBar comparecount = (SeekBar)findViewById(R.id.compare_seekBar);
        TextView comments = (TextView) findViewById(R.id.compare_editText1);
        
        RadioButton newSite = (RadioButton) findViewById (R.id.radio0);
        RadioButton newSite2 = (RadioButton) findViewById (R.id.radio1);
        
		RadioButton pastData = (RadioButton) findViewById (R.id.radio2);
		RadioButton pastData2 = (RadioButton) findViewById (R.id.radio3);
		
		if(observ.INFO.THIS_NEW_SITE.equals("YES"))	//User HAS submitted data for this site
		{
			newSite.setChecked(true);
		}
		else //User HAS NOT submitted data for this site
		{
			newSite2.setChecked(true);
		}
		if(observ.INFO.USED_DIFFERENT_SITE.equals("YES")) //user HAS submitted past data
		{
			pastData.setChecked(true);
		}
		else //user HAS NOT submitted past data
		{
			pastData2.setChecked(true);
		}
        
		if(observ.INFO.EMAIL != null && observ.INFO.EMAIL.length() > 0)
		{	
			email.setText(observ.INFO.EMAIL);
		}
		
		comparecount.setProgress(getIntProgressValue(observ.INFO.NUM_SQUIRREL_CHANGE));
		
		if(observ.INFO.COMMENTS != null && observ.INFO.COMMENTS.length() > 0)
        {
        	comments.setText(observ.INFO.COMMENTS);
        }
    	
    	
    }

}//End class compare
