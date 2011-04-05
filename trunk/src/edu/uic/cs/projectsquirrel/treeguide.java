package edu.uic.cs.projectsquirrel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class treeguide extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treeguide);
        
        ImageView NBImage = (ImageView) findViewById(R.id.NutBearingImage);
        TextView NBDesc = (TextView) findViewById(R.id.NutBearingDesc);
       // NBImage.setImageResource(R.drawable.fox_squirrel);
        NBDesc.setText("Nut Bearing trees");
        
        ImageView SBImage = (ImageView) findViewById(R.id.SeedBearingImage);
        TextView SBDesc = (TextView) findViewById(R.id.SeedBearingDesc);
       // SBImage.setImageResource(R.drawable.grey_squirrel);
        SBDesc.setText("Seed Bearing trees");
        
        ImageView FBImage = (ImageView) findViewById(R.id.FruitBearingImage);
        TextView FBDesc = (TextView) findViewById(R.id.FruitBearingDesc);
        //FBImage.setImageResource(R.drawable.grey_squirrel);
        FBDesc.setText("Fruit Bearing trees");
        
        ImageView TSImage = (ImageView) findViewById(R.id.TinySeededImage);
        TextView TSDesc = (TextView) findViewById(R.id.TinySeededDesc);
        //TSImage.setImageResource(R.drawable.grey_squirrel);
        TSDesc.setText("Tiny Seeded trees");
        
        ImageView CTImage = (ImageView) findViewById(R.id.ConiferousImage);
        TextView CTDesc = (TextView) findViewById(R.id.ConiferousDesc);
        //CTImage.setImageResource(R.drawable.grey_squirrel);
        CTDesc.setText("Coniferous Trees");
        
    }
	
}
