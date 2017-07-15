package com.sensei.hexane.core.chem.compound;

public class CompoundDescriptor {
	
	private String prefix = null;
	private String suffix = null;
	
	private int complexBondLocation = 0;
	
	public CompoundDescriptor( String prefix, String suffix, int location ) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.complexBondLocation = location;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
	public String getSuffix(){
		return suffix;
	}
	
	public int getComplexBondLocation(){
		return complexBondLocation;
	}
}
