package com.sensei.cliparser;

import java.util.Scanner;

public class CommandLineParser {

	public static void main( String[] args ){
		Scanner sc = new Scanner( System.in );
		args = sc.nextLine().split( " " );

		parse( args );
	}
	
	public static void parse( String[] args ) {
		Command c = new Command( args[1] );
		for( String s : args ) {
			System.out.print( s + "," );
		}
		System.out.println();
		
		String[] params = { "-t", "-d", "-i" };
		String[] comparators = { "-lt", "-le", "-gt", "-ge", "-eq", "-ne" }; 
		
		for( int i=0; i<args.length; i++ ) {
			String token = args[i];
			System.out.println( "Token = " + token );
			if( token.equals( "-t" ) ){
				i++;
				TextParameter name = new TextParameter( false, false, null );
				while( i < args.length && !contains(args[i], params) ) {
					if( args[i].equals( "-r" ) ) {
						name.regexp = true;
					}
					else if( args[i].equals( "-l" ) ) {
						name.like = true;
					}
					else {
						name.value = args[i];
					}
					i++;
				}
				i--;
				c.text = name;
			}
			else if( token.equals( "-i" ) ) {
				i++;
				NumericParameter id = new NumericParameter( null, null );
				while( i < args.length && !contains(args[i], params) ) {
					if( contains( args[i], comparators ) ) {
						id.comparator = args[i];
					}
					else {
						id.value = args[i];
					}
					i++;
				}
				i--;
				c.id = id;
			}
			else if( token.equals( "-d" ) ) {
				i++;
				NumericParameter id = new NumericParameter( null, null );
				while( i < args.length && !contains(args[i], params) ) {
					if( contains( args[i], comparators ) ) {
						id.comparator = args[i];
					}
					else {
						id.value = args[i];
					}
					i++;
				}
				i--;
				c.date = id;
			}
		}
		System.out.println( c );
	}
	
	public static boolean contains( String val1, String[] val2 ) {
		for( String s : val2 ) {
			if( s.equals( val1 ) ) {
				return true;
			}
		}
		return false;
	}
}
