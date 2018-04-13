package com.sensei.plugin;

import java.util.List;

public class PluginLoaderTest {
	
	public static void main( String[] args ) throws Exception{
		
		List<Plugin> plugins = PluginLoader.getPlugins();
		for( Plugin p : plugins ) {
			System.out.println( "Loaded a Plugin" );
			System.out.println( "Plugin name: " + p.getName() );
			System.out.println( "Plugin update download URL: " + p.getUpdateDownloadURL() );
			System.out.println( "Plugin update ID URL: " + p.getUpdateIDURL() );
			System.out.println( "Plugin update ID: " + p.getUpdateID() );
			System.out.println( "Plugin icon: " + p.getIcon().toString() );
			System.out.println();
		}
	}	
}
