package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class compare2 extends Activity{
	
	Bundle BUNDL;
	final static int INVALID_EMAIL_ID=1;
	
	
        /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare2); 
        
      //submit button on compare2.xml
        Button submit = (Button) findViewById(R.id.submit);
        TextView email_id = (TextView)findViewById(R.id.email_edit);
        		SeekBar comparecount = (SeekBar)findViewById(R.id.compare_seekBar);
		comparecount.setMinimumWidth(100);
		RadioGroup previoussubmit = (RadioGroup) findViewById(R.id.radioGroup_previous);
        RadioGroup othersite = (RadioGroup) findViewById(R.id.radioGroup_other);
       TextView comments = (TextView) findViewById(R.id.compare_editText1);		   
      
        //Submit BUTTON
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView email_id = (TextView)findViewById(R.id.email_edit);
				//SeekBar comparecount = (SeekBar)
				RadioGroup previoussubmit = (RadioGroup) findViewById(R.id.radioGroup_previous);
		        RadioGroup othersite = (RadioGroup) findViewById(R.id.radioGroup_other);
		       TextView comments = (TextView) findViewById(R.id.compare_editText1);		
		       
		       String validate_email= email_id.getText().toString();
		        if(!(validate_email.matches("[a-z0-9]+@[a-z0-9]+\\.[a-z]+")))
		        {
		        	showDialog(INVALID_EMAIL_ID);

		        }

		        /*   TextView emailid = (TextView) findViewById(R.id.email_editText);
	        RadioGroup comparecount = (RadioGroup) findViewById(R.id.radioGroup1);
	        RadioGroup prevsurvey = (RadioGroup) findViewById(R.id.radioGroup2);
	        TextView othersite = (TextView) findViewById(R.id.othersite_editText);


				BNDL.putString("Email", emailid.toString() );
				BNDL.putString("Compare_Count", comparecount.toString());
				BNDL.putString("Previous_Survey", prevsurvey.toString());
				BNDL.putString("Other_Site", othersite.toString());*/
		        else
		        {
		        	Intent i = new Intent(getApplicationContext(), finalscreen.class);
		    		//i.putExtras(BUNDL);	//Sends BNDL to final screen
		            startActivity(i);
					
		        }
				
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
    		
    	
    	}
		return dialog;
	}

}//End class compare
