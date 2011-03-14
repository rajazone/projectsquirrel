package com.example.test;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;


@SuppressWarnings("unchecked")
public class itemizedOverlays extends ItemizedOverlay {

	public itemizedOverlays(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}

	//overlay points
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	
	@Override
	protected OverlayItem createItem(int i) {
	  return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}

	public void addOverlay(OverlayItem overlay) {
	    mOverlays.add(overlay);
	    populate();
	}
	
}
