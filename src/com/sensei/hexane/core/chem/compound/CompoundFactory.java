package com.sensei.hexane.core.chem.compound;

import java.util.ArrayList;
import java.util.List;

import com.sensei.hexane.core.chem.atom.Atom;
import com.sensei.hexane.core.chem.atom.CarbonAtom;
import com.sensei.hexane.core.chem.atom.HydrogenAtom;
import com.sensei.hexane.core.data.PrefixMap;
import com.sensei.hexane.core.data.SuffixMap;

public class CompoundFactory {
	
	public static OrganicCompound generateCompound( CompoundDescriptor desc ) {
		int numCarbonAtoms = PrefixMap.instance().get( desc.getPrefix() ).intValue();
		List<CarbonAtom> carbonAtoms = new ArrayList<>(); 
		
		for( int i=0; i<numCarbonAtoms; i++ ) {
			carbonAtoms.add( new CarbonAtom() );
		}
		
		for( int i=0; i<numCarbonAtoms-1; i++ ) {
			if( i+1 == desc.getComplexBondLocation() ) {
				bondAtoms( carbonAtoms.get( i ), carbonAtoms.get( i+1 ), 
							SuffixMap.instance().get( desc.getSuffix() ) );
			}
			else {
				bondAtoms( carbonAtoms.get( i ), carbonAtoms.get( i+1 ), 1 );
			}
		}
		
		for( int i=0; i<numCarbonAtoms; i++ ) {
			while( !( carbonAtoms.get( i ).isValencySatisfied() ) ) {
				bondAtoms( carbonAtoms.get( i ), new HydrogenAtom(), 1 );
			}
		}

		return new OrganicCompound( carbonAtoms );
	}

	private static void bondAtoms( Atom a1, Atom a2, int valency ) {
		a1.bondAtom( a2, valency );
		a2.bondAtom( a1, valency );
	}
}
