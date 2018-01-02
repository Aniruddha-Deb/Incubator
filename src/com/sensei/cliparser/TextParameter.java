package com.sensei.cliparser;

public class TextParameter extends Parameter {

	boolean regexp = false;
	boolean like = false;
	String value = null;
	
	public TextParameter( boolean regexp, boolean like, String value ) {
		super( value );
		this.like = like;
		this.regexp = regexp;
	}

	@Override
	public String toString(){
		return value + " : " + regexp + ", " + like;
	}
}
