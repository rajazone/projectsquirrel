package  com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class input extends Activity{
     
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
     // Apply our subactivity.xml-Layout
        setContentView(R.layout.textinput);
       
        // Find the button defined in the subactivity.xml
        Button cmd_return = (Button)findViewById(R.id.subactivity_cmd_map);
        /* Add an OnClickListener to it, that will
         * read out the text in the EditBox set it
         * as return-data and close this activity */
        cmd_return.setOnClickListener(new OnClickListener(){
               // @Override
               public void onClick(View view) {
            	   EditText textbox = (EditText)findViewById(
                           R.id.subactivity_edit_returnvalue);
            	   int point1, point2;
            	   point1=point2=0;
            	   try { // parse user entry
                       point1=Integer.parseInt(textbox.getText().toString().split("\\,|\\s|\\,\\s")[0]);
                       point2=Integer.parseInt(textbox.getText().toString().split("\\,|\\s|\\,\\s")[1]);
                   } catch (Exception ex) { // invalid entry
                	   Toast.makeText(input.this, textbox.getText().toString() + " is an invalid entry!",
                		          Toast.LENGTH_SHORT).show();
                	   return;
                   }
                  Bundle b = new Bundle(); // create a bundle to pass to map activity
     		      b.putDouble("point1",point1); // bundle the geo points for the map activity and convert to 1e6
     		      b.putDouble("point2",point2);
     		      Intent myIntent = new Intent(view.getContext(), map.class); // create the intent to launch the map
     		      myIntent.putExtras(b); // attach bundle to map activity
     	          startActivityForResult(myIntent, 0); // start map activity
            	   //map things!
               }
        });      
    }
}