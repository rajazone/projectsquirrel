package com.example.test;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ZoomControls;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


public class map extends MapActivity {

	// Zoom Controls
	LinearLayout linearLayout;
	MapView mapView;
	ZoomControls mZoom;
	// End Zoom Controls
	
	//Map Overlays
	List<Overlay> mapOverlays;
	Drawable drawable;
	itemizedOverlays itemizedOverlay;
	// End map Overlays
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    Bundle b = this.getIntent().getExtras();
	    
	    //init zoom controls
	    linearLayout = (LinearLayout) findViewById(R.id.zoomview);
	    mapView = (MapView) findViewById(R.id.mapview);
	    mZoom = (ZoomControls) mapView.getZoomControls();
	    
	    // Add zoom controls to map
	    linearLayout.addView(mZoom);
	    
	    
	    // Overlay setup
	    mapOverlays = mapView.getOverlays();
	    drawable = this.getResources().getDrawable(R.drawable.androidmarker); // Use android marker
	    itemizedOverlay = new itemizedOverlays(drawable);
	    
	    // Set geo point and mark an overlay item to be at that point
	    GeoPoint point = new GeoPoint((int)(b.getDouble("point1")),(int)(b.getDouble("point2")));
	    OverlayItem overlayitem = new OverlayItem(point, "", "");
	    itemizedOverlay.addOverlay(overlayitem);
	    mapOverlays.add(itemizedOverlay);
	    
	}
	
	
	
}