package com.sensei.plugin;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader {
	
	private static List<Plugin> plugins = null;
	// TODO use the Java preferences API to store this globally
	private static final String PLUGINS_LOCATION = 
							"res.plugins".replace( '.', File.separatorChar );
	private static final String ENTRY_POINT = "EntryPoint";
	
	public static List<Plugin> getPlugins() {
		if( plugins == null ) {
			try {
				loadPlugins();
			} catch( Exception e ) {
				e.printStackTrace();
			}
		}
		return plugins;
	}
	
	public static void loadPlugins() throws Exception {
		
		plugins = new ArrayList<>();
		System.gc();
		
		File dir = new File( PLUGINS_LOCATION );
		
		for( File f : dir.listFiles() ) {
			
			JarFile jarFile = new JarFile( f );
			Enumeration<JarEntry> entries = jarFile.entries();
			
			URL[] urls = { getJarUrl( f.getName() ) };
			URLClassLoader cl = URLClassLoader.newInstance(urls);
			
			while( entries.hasMoreElements() ) {
				
				JarEntry je = entries.nextElement();
				// -6 because of .class extension
				String className = je.getName().substring( 0, je.getName().length()-6 );
			    className = className.replace( File.separatorChar, '.' );
			    
			    if( className.endsWith( ENTRY_POINT ) ) {
			    	jarFile.close();
			    	Class<?> c = cl.loadClass( className );
			    	Constructor<?> constructor = c.getConstructor();
			    	Plugin p = (Plugin)constructor.newInstance();
			    	plugins.add( p );
			    	break;
			    }
			}
			jarFile.close();
		}				
	}
	
	private static URL getJarUrl( String jarName ) {
		try {
			return new URL( 
				"jar:file:" + PLUGINS_LOCATION + File.separatorChar + jarName + 
				"!" + File.separatorChar );
		}
		catch( MalformedURLException e ) {
			System.out.println( "Bad URL" );
			return null;
		}
	}
}
