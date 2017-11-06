package com.sensei.dendron;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlaveOne {
	
	public static void main( String[] args ) throws Exception {
		Socket s = null;
		while( true ) {
			try {
				s = new Socket( "localhost", 4040 );
			} catch( ConnectException ex ) {
				Thread.sleep( 10000 );
			}
			
			if( s != null && s.isConnected() ) {
				break;
			}
		}
		
		JobManager jb = new JobManager( s, System.out );
		jb.output( 121 );
		System.out.println( "Output some stuff" );
		Thread.sleep( 100 );
		System.out.println( "Closing down" );
		s.close();
	}
	
}

class JobManager {
	
	InputStream is = null;
	OutputStream os = null;
	PrintStream ps = null;
	Socket s = null;
	ArrayDeque<Integer> outputQueue = null;
	
	public JobManager( Socket s, PrintStream ps ) throws IOException {
		this.s = s;
		this.ps = ps;
		this.is = s.getInputStream();
		this.os = s.getOutputStream();
		System.out.println( "Hellll" );
		outputQueue = new ArrayDeque<>();
		startIOThreads();
		
	}
	
	public void output( int b ) {
		outputQueue.push( b );
	}
	
	private void onInputReceived( int i ) {
		ps.println( i );
		output( i );
	}
	
	private void startIOThreads() throws IOException {
		System.out.println( "Hello" );
		new Thread( () -> {
			try {
				System.out.println( "LOLO" );
				System.out.flush();
				while( s.isConnected() ) {
					int b;
					if( (b=is.read()) != -1 ) {
						onInputReceived( b );
					}
				}
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		} );
		
		new Thread( () -> { 
			try {
				while( s.isConnected() ) {
					if( !outputQueue.isEmpty() ) {
						os.write( outputQueue.pop() );
						os.flush();
					}
				}
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		} );
	}
}
