package com.sensei.hexane.core.data;

import java.util.HashMap;

public class SuffixMap extends HashMap<String, Integer>{

	private static final long serialVersionUID = 3265164960001575925L;
	
	private static SuffixMap instance = null;
	
	public static SuffixMap instance() {
		if( instance == null ) {
			instance = new SuffixMap();
		}
		return instance;
	}
	
	private SuffixMap() {
		super();
		loadSuffixes();
	}
	
	private void loadSuffixes() {
		super.put( "ane", 1 );
		super.put( "ene", 2 );
		super.put( "yne", 3 );
	}
}
