package com.sensei.hexane.core;

import java.util.ArrayList;
import java.util.List;

import com.sensei.hexane.core.atom.Atom;
import com.sensei.hexane.core.atom.CarbonAtom;
import com.sensei.hexane.core.atom.HydrogenAtom;
import com.sensei.hexane.core.data.PrefixMap;

public class OrganicCompound {

	private List<Atom> carbonAtoms = null;
	
	public OrganicCompound( String iupacName ) {
		carbonAtoms = new ArrayList<>();
		parseCompound( iupacName );
	}
	
	private void parseCompound( String iupacName ) {
		String prefix = iupacName.substring( 0, iupacName.length()-3 );
//		String suffix = iupacName.substring( iupacName.length()-3, 
//														iupacName.length() );
		
		int numCarbonAtoms = PrefixMap.instance().get( prefix.toLowerCase() ).intValue();
		
		for( int i=0; i<numCarbonAtoms; i++ ) {
			carbonAtoms.add( new CarbonAtom() );
		}
		
		for( int i=0; i<numCarbonAtoms-1; i++ ) {
			bondAtoms( carbonAtoms.get( i ), carbonAtoms.get( i+1 ), 3 );
		}
		
		for( int i=0; i<numCarbonAtoms; i++ ) {
			while( !( carbonAtoms.get( i ).isValencySatisfied() ) ) {
				bondAtoms( carbonAtoms.get( i ), new HydrogenAtom(), 1 );
			}
		}

		for( int i=0; i<numCarbonAtoms; i++ ) {
			System.out.print( carbonAtoms.get( i ) );
			System.out.print( "H" + (carbonAtoms.get( i ).numAtomsOf( HydrogenAtom.class ) ) );
			if( i != numCarbonAtoms-1 ) {
				System.out.print( "-" );
			}
		}
	}
	
	private void bondAtoms( Atom a1, Atom a2, int valency ) {
		a1.bondAtom( a2, valency );
		a2.bondAtom( a1, valency );
	}
	
	public static void main( String[] args ){
		new OrganicCompound( "ethane" );
	}
}
