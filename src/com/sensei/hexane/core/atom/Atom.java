package com.sensei.hexane.core.atom;

import java.util.HashMap;
import java.util.Map;

public abstract class Atom {
	
	private Map<Atom, Integer> linkedAtoms = null;
	private String name = null;
	private int valency = 0;
	private int numJoinedAtoms = 0;
	
	protected Atom( String name, int valency ) {
		this.linkedAtoms = new HashMap<>();
		this.name = name;
		this.valency = valency;
	}
	
	public String getName(){
		return name;
	}
	
	public void bondAtom( Atom a, int numBonds ) {
		linkedAtoms.put( a, numBonds );
		numJoinedAtoms += numBonds;
	}
	
	public boolean isValencySatisfied() {
		return numJoinedAtoms == valency;
	}
	
	public int numAtomsOf( Class<? extends Atom> c ) {
		int numAtoms = 0;
		for( Atom a : linkedAtoms.keySet() ) {
			if( a.getClass().getName().equals( c.getName() ) ) {
				numAtoms++;
			}
		}
		
		return numAtoms;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
