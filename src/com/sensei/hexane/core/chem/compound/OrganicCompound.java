package com.sensei.hexane.core.chem.compound;

import java.util.List;

import com.sensei.hexane.core.chem.atom.CarbonAtom;

public class OrganicCompound {

	private List<CarbonAtom> carbonAtoms = null;
	
	public OrganicCompound( List<CarbonAtom> carbonAtoms ) {
		this.carbonAtoms = carbonAtoms;
	}
	
	@Override
	public String toString() {

		String s = carbonAtoms.get( 0 ).getCompleteName();
		for( int i=1; i<carbonAtoms.size(); i++ ) {
			int numBonds = carbonAtoms.get( i ).getLinkedAtoms().get( carbonAtoms.get( i-1 ) );
			if( numBonds == 1 ) { 
				s += "-" + carbonAtoms.get( i ).getCompleteName();
			}
			else if( numBonds == 2 ) {
				s += "=" + carbonAtoms.get( i ).getCompleteName();
			}
			else {
				s += "Ξ" + carbonAtoms.get( i ).getCompleteName();
			}
		}
		
		return s;
	}	
}
