package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class sqguide extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqguide);
        
        ImageView fSquirrel = (ImageView) findViewById(R.id.foxSquirrel);
        TextView fDesc = (TextView) findViewById(R.id.textView1);
        fSquirrel.setImageResource(R.drawable.fox_squirrel);
        fDesc.setText("Fox Squirrel");
        
        ImageView gSquirrel = (ImageView) findViewById(R.id.graySquirrel);
        TextView gDesc = (TextView) findViewById(R.id.textView2);
        gSquirrel.setImageResource(R.drawable.grey_squirrel);
        gDesc.setText("Grey Squirrel");
        
    }
	
}
