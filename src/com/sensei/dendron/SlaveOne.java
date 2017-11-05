package com.sensei.dendron;

import java.net.Socket;

public class SlaveOne {
	
	public static void main( String[] args ) throws Exception {
		Socket s = null;
		while( true ) {
			s = new Socket( "localhost", 4040 );
			if( !s.isConnected() ) {
				Thread.sleep( 10000 );
			}
			else {
				System.out.println( "Hit" );
				break;
			}
		}
		s.close();
	}
}
