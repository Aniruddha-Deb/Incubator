package com.sensei.hexane.core.chem.atom;

public class CarbonAtom extends Atom {

	private static final String name = "C";
	private static final int valency = 4;
	
	public CarbonAtom() {
		super( name, valency );
	}
	
	public String getCompleteName() {
		String name = "C";
		for( Atom a : getLinkedAtoms().keySet() ) {
			if( !( a instanceof CarbonAtom ) ) {
				name += a.getName();
			}
		}
		
		return name;
	}
}
