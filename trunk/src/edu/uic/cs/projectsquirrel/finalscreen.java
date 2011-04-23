package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class finalscreen extends Activity{

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalscreen); 
        
        Button OK = (Button) findViewById(R.id.final_ok_button);
        
        OK.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent i = getIntent();
				setResult(RESULT_OK, i);
				finish();
			}});
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
    
  //On back button pressed, save variables.
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
        	
        	Intent i = getIntent();
			setResult(RESULT_OK, i);
			finish();
        	return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}//End class food
