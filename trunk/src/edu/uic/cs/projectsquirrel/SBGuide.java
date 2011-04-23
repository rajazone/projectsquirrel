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

public class SBGuide extends Activity {

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treeguide);
        
        TextView cat = (TextView) findViewById(R.id.treeCategory);
        cat.setText("Seed-bearing Trees");
        
        ImageView Tree1Image = (ImageView) findViewById(R.id.Tree1Image);
       //ImageView Nut1Image = (ImageView) findViewById(R.id.Nut1Image);
     Tree1Image.setImageResource(R.drawable.elmtree);
    // Nut1Image.setImageResource(R.drawable.walnutfruit);
     
     
        TextView Tree1Desc = (TextView) findViewById(R.id.Tree1Desc);
       // TextView Nut1Desc = (TextView) findViewById(R.id.Nut1Desc);
       
        Tree1Desc.setText("Elm Tree\n");
      // Nut1Desc.setText("Walnut Seed");
        
        ImageView Tree2Image = (ImageView) findViewById(R.id.Tree2Image);
       // ImageView Nut2Image = (ImageView) findViewById(R.id.Nut2Image);
     Tree2Image.setImageResource(R.drawable.maple);
     // Nut2Image.setImageResource(R.drawable.oakfruit);
        TextView Tree2Desc = (TextView) findViewById(R.id.Tree2Desc);
       // TextView Nut2Desc = (TextView) findViewById(R.id.Nut2Desc);
       
       Tree2Desc.setText("Maple Tree\n");
      // Nut2Desc.setText("Oak");
        
        ImageView Tree3Image = (ImageView) findViewById(R.id.Tree3Image);
        //ImageView Nut3Image = (ImageView) findViewById(R.id.Nut3Image);
     Tree3Image.setImageResource(R.drawable.locusttree);
   //  Nut3Image.setImageResource(R.drawable.hickoryfruit);
        TextView Tree3Desc = (TextView) findViewById(R.id.Tree3Desc);
       // TextView Nut3Desc = (TextView) findViewById(R.id.Nut3Desc);
       
       Tree3Desc.setText("Locust Tree\n");
      //  Nut3Desc.setText("Hickory fruit");
       Tree1Desc.setTextSize(24);
       Tree2Desc.setTextSize(24);
       Tree3Desc.setTextSize(24);
        
       
        
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
