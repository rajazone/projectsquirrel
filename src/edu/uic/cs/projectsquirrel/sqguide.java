package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class sqguide extends Activity {

	private static final int CAMERA_PIC_REQUEST = 1337;
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqguide);

        ImageView usrPic = (ImageView) findViewById(R.id.userPic);
        usrPic.setVisibility(View.INVISIBLE);
        
        Button takePic = (Button) findViewById(R.id.userPhotoButton);
        
        
        takePic.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	    		startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
	    }});
        
        //ImageView fSquirrel = (ImageView) findViewById(R.id.foxSquirrel);
        //TextView fDesc = (TextView) findViewById(R.id.textView1);
        ///fSquirrel.setImageResource(R.drawable.fox_squirrel);
        //fDesc.setText("Fox Squirrel\n");
        
        //ImageView gSquirrel = (ImageView) findViewById(R.id.graySquirrel);
        //TextView gDesc = (TextView) findViewById(R.id.textView2);
        //gSquirrel.setImageResource(R.drawable.grey_squirrel);
        //gDesc.setTextSize(24);
        //fDesc.setTextSize(24);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if(resultCode == RESULT_OK) {
        	if (requestCode == CAMERA_PIC_REQUEST) {  
        		Bitmap thumbnail = (Bitmap) data.getExtras().get("data");  
        		ImageView usrPic = (ImageView) findViewById(R.id.userPic);
        		usrPic.setImageBitmap(thumbnail);
        		usrPic.setVisibility(View.VISIBLE);}
        }
        else if(resultCode == RESULT_CANCELED) {
        	return;
        }
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
