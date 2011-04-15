package edu.uic.cs.projectsquirrel;

import java.io.IOException;

import android.util.Log;


public class Variables {
	
	private static final String TAG = "Project_2_Group_5";
	
	public String Day = ""; //"[DD]"
	public String Month = ""; //"[MM]"
	public String Year = ""; //"[YYYY]"
	public String Hour = ""; //"[HH]"
	public String Minute = ""; //"[MM]"
	public String AMPM = ""; //"[XM]"
	public String ZIP = ""; //"[XXXXX-XXXX]"
	public String LATITUDE = ""; //"[example: 41.86962474217837]"
	public String LONGITUDE = ""; //"[example: -87.6494836807251]"
	public String EMAIL = ""; //"[XXX@XX.XXX]"
	public String NUM_GRAY_SQUIRRELS = ""; //"[X]"
	public String NUM_FOX_SQUIRRELS = ""; //"[X]"
	public String SETTING = ""; //"[X, where X is one of: SINGLE_FAM, MULT_FAM, HIGHRISE, PARK, NATURE, GARDEN, COMMER, SCHOOL, LOT, CEMETERY, FARM]"
	public String NUT_TREES = ""; //"[X, where X is one of: YES, NO, UNSURE]"
	public String SEED_TREES = ""; //"[X, where X is one of: YES, NO, UNSURE]"
	public String FRUIT_TREES = ""; //"[X, where X is one of: YES, NO, UNSURE]"
	public String TINY_TREES = ""; //"[X, where X is one of: YES, NO, UNSURE]"
	public String CON_TREES = ""; //"[X, where X is one of: YES, NO, UNSURE]"
	public String OTHER_TREES = ""; //"[X, where X is a string]"
	public String FEED_BIRD_FEEDER = ""; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_HANDOUTS = ""; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_GARBAGE = ""; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_TREES = ""; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_OTHER = ""; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_OTHER_DETAILS = ""; //"[X, where X is a string]"
	public String NUM_SQUIRREL_CHANGE = ""; //"[X, where X is one of SAME, INCREASED, DECREASED]"
	public String SITE_DOGS = ""; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_CATS = ""; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_COYOTES = ""; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_HAWKS = ""; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_GRAIN = ""; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String THIS_NEW_SITE = ""; //"[X, where X is one of YES, NO]"
	public String USED_DIFFERENT_SITE = ""; //"[X, where X is one of YES, NO]"
	public String COMMENTS = ""; //"[X, where X is a string]"
	
	public void clearAll()
	{
		
		
	}
	
	public void makeLog() throws IOException //Submits the user data to the Log file.
	{
		String msg =	
				"Day, " + Day + "\n" +
				"Month, " + Month + "\n" +
				"Year, " + Year + "\n" +
				"Hour, " + Hour + "\n" +
				"Minute, " + Minute + "\n" +
				"AMPM, " + AMPM + "\n" +
				"ZIP, " + ZIP + "\n" +
				"LATITUDE, " + LATITUDE + "\n" +
				"LONGITUDE, " + LONGITUDE + "\n" +
				"EMAIL, " + EMAIL  + "\n" +
				"NUM_GRAY_SQUIRRELS, " + NUM_GRAY_SQUIRRELS + "\n" +
				"NUM_FOX_SQUIRRELS, " + NUM_FOX_SQUIRRELS + "\n" +
				"SETTING, " + SETTING + "\n" +
				"NUT_TREES, " + NUT_TREES + "\n" +
				"SEED_TREES, " + SEED_TREES + "\n" +
				"FRUIT_TREES, " + FRUIT_TREES + "\n" +
				"TINY_TREES, " + TINY_TREES + "\n" +
				"CON_TREES, " + CON_TREES + "\n" +
				"OTHER_TREES, " + OTHER_TREES + "\n" +
				"FEED_BIRD_FEEDER, " + FEED_BIRD_FEEDER + "\n" +
				"FEED_HANDOUTS, " + FEED_HANDOUTS + "\n" +
				"FEED_GARBAGE, " + FEED_GARBAGE + "\n" +
				"FEED_OTHER, " + FEED_OTHER + "\n" +
				"FEED_OTHER_DETAILS, " + FEED_OTHER_DETAILS + "\n" +
				"NUM_SQUIREEL_CHANGE, " + NUM_SQUIRREL_CHANGE + "\n" +
				"SITE_DOGS, " + SITE_DOGS + "\n" +
				"SITE_CATS, " + SITE_CATS + "\n" +
				"SITE_COYOTES, " + SITE_COYOTES + "\n" +
				"SITE_HAWKS, " + SITE_HAWKS + "\n" +
				"SITE_GRAIN, " + SITE_GRAIN + "\n" +
				"THIS_NEW_SITE, " + THIS_NEW_SITE + "\n" +
				"USED_DIFERENT_SITE, " + USED_DIFFERENT_SITE + "\n" +
				"COMMENTS, " + COMMENTS;
		
		Log.i(TAG, msg);
	}
	
}
