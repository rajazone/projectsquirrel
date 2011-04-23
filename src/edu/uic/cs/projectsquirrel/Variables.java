package edu.uic.cs.projectsquirrel;

import java.io.IOException;

import android.util.Log;


public class Variables {
	
	private static final String TAG = "Project_2_Group_5";
	
	//All of the following vaiables must be stored in Log upon submission.
	//Some have deault values (Mostly based on default positions of SeekBars)
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
	public String NUM_GRAY_SQUIRRELS = "0"; //"[X]"
	public String NUM_FOX_SQUIRRELS = "0"; //"[X]"
	public String SETTING = ""; //"[X, where X is one of: SINGLE_FAM, MULT_FAM, HIGHRISE, PARK, NATURE, GARDEN, COMMER, SCHOOL, LOT, CEMETERY, FARM]"
	public String NUT_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
	public String SEED_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
	public String FRUIT_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
	public String TINY_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
	public String CON_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
	public String OTHER_TREES = ""; //"[X, where X is a string]"
	public String FEED_BIRD_FEEDER = " NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_HANDOUTS = " NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_GARBAGE = " NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_TREES = " NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_OTHER = " NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
	public String FEED_OTHER_DETAILS = ""; //"[X, where X is a string]"
	public String NUM_SQUIRREL_CHANGE = "SAME"; //"[X, where X is one of SAME, INCREASED, DECREASED]"
	public String SITE_DOGS = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_CATS = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_COYOTES = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_HAWKS = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String SITE_GRAIN = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
	public String THIS_NEW_SITE = ""; //"[X, where X is one of YES, NO]"
	public String USED_DIFFERENT_SITE = ""; //"[X, where X is one of YES, NO]"
	public String COMMENTS = ""; //"[X, where X is a string]"
	
	public void clearAll() //Reset all variables to default values.
	{
		Day = ""; //"[DD]"
		Month = ""; //"[MM]"
		Year = ""; //"[YYYY]"
		Hour = ""; //"[HH]"
		Minute = ""; //"[MM]"
		AMPM = ""; //"[XM]"
		ZIP = ""; //"[XXXXX-XXXX]"
		LATITUDE = ""; //"[example: 41.86962474217837]"
		LONGITUDE = ""; //"[example: -87.6494836807251]"
		EMAIL = ""; //"[XXX@XX.XXX]"
		NUM_GRAY_SQUIRRELS = "0"; //"[X]"
		NUM_FOX_SQUIRRELS = "0"; //"[X]"
		SETTING = ""; //"[X, where X is one of: SINGLE_FAM, MULT_FAM, HIGHRISE, PARK, NATURE, GARDEN, COMMER, SCHOOL, LOT, CEMETERY, FARM]"
		NUT_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
		SEED_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
		FRUIT_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
		TINY_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
		CON_TREES = "UNSURE"; //"[X, where X is one of: YES, NO, UNSURE]"
		OTHER_TREES = ""; //"[X, where X is a string]"
		FEED_BIRD_FEEDER = "NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
		FEED_HANDOUTS = "NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
		FEED_GARBAGE = "NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
		FEED_TREES = "NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
		FEED_OTHER = "NEVER"; //"[X, where X is one of NEVER, SELDOM, OFTEN, REGULARLY]"
		FEED_OTHER_DETAILS = ""; //"[X, where X is a string]"
		NUM_SQUIRREL_CHANGE = "SAME"; //"[X, where X is one of SAME, INCREASED, DECREASED]"
		SITE_DOGS = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
		SITE_CATS = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
		SITE_COYOTES = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
		SITE_HAWKS = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
		SITE_GRAIN = "NONE"; //"[X, where X is one of NONE, LOW, MEDIUM, HIGH]"
		THIS_NEW_SITE = ""; //"[X, where X is one of YES, NO]"
		USED_DIFFERENT_SITE = ""; //"[X, where X is one of YES, NO]"
		COMMENTS = ""; //"[X, where X is a string]"
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
