package com.sensei.prefs;

public class PreferenceSetter {
	
	public static void main( String[] args ){
		UserPreferences.instance().putPreference( 
				UserPreferences.PLUGINS_DIR_KEY, "res.plugins" );
	}

}
