package com.sensei.cliparser;

public class NumericParameter extends Parameter {

	String comparator = null;
	
	public NumericParameter( String comparator, String value ) {
		super( value );
		this.comparator = comparator;
	}
	
	@Override
	public String toString(){
		return value + " : " + comparator ;
	}
}
