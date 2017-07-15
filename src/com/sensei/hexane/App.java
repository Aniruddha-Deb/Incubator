package com.sensei.hexane;

import java.util.Scanner;

import com.sensei.hexane.core.chem.compound.CompoundDescriptor;
import com.sensei.hexane.core.chem.compound.CompoundFactory;
import com.sensei.hexane.core.chem.compound.OrganicCompound;
import com.sensei.hexane.core.input.InputLexer;

public class App {

	public static void main( String[] args ) {

		Scanner sc = new Scanner( System.in );
		while( true ) {
			String input = sc.nextLine().toLowerCase();
			CompoundDescriptor desc = InputLexer.generateDescriptor( input );
			OrganicCompound oc = CompoundFactory.generateCompound( desc );
			
			System.out.println( oc.toString() );
		}
	}
}
