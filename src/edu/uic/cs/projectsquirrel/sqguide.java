package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class sqguide extends Activity {

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqguide);
        
        //ImageView fSquirrel = (ImageView) findViewById(R.id.foxSquirrel);
        TextView fDesc = (TextView) findViewById(R.id.textView1);
        ///fSquirrel.setImageResource(R.drawable.fox_squirrel);
        //fDesc.setText("Fox Squirrel\n");
        
        //ImageView gSquirrel = (ImageView) findViewById(R.id.graySquirrel);
        TextView gDesc = (TextView) findViewById(R.id.textView2);
        //gSquirrel.setImageResource(R.drawable.grey_squirrel);
        gDesc.setTextSize(24);
        fDesc.setTextSize(24);
    }
    
    //Customize Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_alt, menu);
    	return true;
    }
    
    @Override
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
	
}
