package com.sensei.prefs;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class UserPreferences {
	
	public static final String APP_INSTALL_DIR_KEY = "APP_INSTALL_DIR";
	public static final String PLUGINS_DIR_KEY = "PLUGINS_DIR";
	
	private Map<String, String> loadedPrefs = null;
	
	private static Preferences userPrefs = null;
	
	private static UserPreferences instance = null;
	
	public static UserPreferences instance() {
		if( instance == null ) {
			instance = new UserPreferences();
		}
		return instance;
	}
	
	public String getPreference( String key ) {
		return loadedPrefs.get( key );
	}
	
	void putPreference( String key, String preference ) {
		userPrefs.put( key, preference );
	}
	
	public void loadPreferences() {
		userPrefs = Preferences.userRoot().node( this.getClass().getName() );
		loadedPrefs = new HashMap<>();
		
		loadedPrefs.put( APP_INSTALL_DIR_KEY, 
						userPrefs.get( APP_INSTALL_DIR_KEY, null ) );
		loadedPrefs.put( PLUGINS_DIR_KEY, 
						userPrefs.get( PLUGINS_DIR_KEY, null ) );
	}

	public UserPreferences() {
		loadPreferences();
	}
}
