package com.sensei.hexane.core.data;

import java.util.HashMap;

public class PrefixMap extends HashMap<String, Integer>{
	
	private static final long serialVersionUID = 3265164960001575925L;
	
	private static PrefixMap instance = null;
	
	public static PrefixMap instance() {
		if( instance == null ) {
			instance = new PrefixMap();
		}
		return instance;
	}
	
	private PrefixMap() {
		super();
		loadPrefixes();
	}
	
	private void loadPrefixes() {
		super.put( "meth", 1 );
		super.put( "eth",  2 );
		super.put( "prop", 3 );
		super.put( "but",  4 );
		super.put( "pent", 5 );
		super.put( "hex",  6 );
		super.put( "hept", 7 );
		super.put( "oct",  8 );
		super.put( "non",  9 );
		super.put( "dec",   10 );		
		super.put( "undec", 11 );
		super.put( "dodec", 12 );
		super.put( "tridec", 13 );
		super.put( "tetradec", 14 );
		super.put( "pentadec", 15 );
	}
}
