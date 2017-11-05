package com.sensei.dendron;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Master {
	
	public static void main( String[] args ) throws Exception {
		ServerSocket ss = new ServerSocket( 4040 );
		List<Socket> connectedSlaves = new ArrayList<>();
		
		while( true ) {
			Socket s = ss.accept();
			System.out.println( s.toString() + "connected" );
			connectedSlaves.add( s );
		}		
	}

	private static void handleSocket( Socket s ) {
	}
}
