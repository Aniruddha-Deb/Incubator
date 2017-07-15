package com.sensei.hexane.core.input;

import com.sensei.hexane.core.chem.compound.CompoundDescriptor;

public class InputLexer {
	
	public static CompoundDescriptor generateDescriptor( String iupacName ) {
		String[] parts = iupacName.split( "-" );
		if( parts.length > 1 ) {
			return new CompoundDescriptor( parts[0], parts[2], 
											Integer.parseInt( parts[1] ) ); 
		}
		
		String prefix = iupacName.substring( 0, iupacName.length()-3 );
		String suffix = iupacName.substring( iupacName.length()-3, 
														iupacName.length() );
		return new CompoundDescriptor( prefix, suffix, -1 );
	}

}
