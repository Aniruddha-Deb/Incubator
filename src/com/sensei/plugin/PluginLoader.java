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

import com.sensei.prefs.UserPreferences;

public class PluginLoader {
	
	private static List<Plugin> plugins = null;
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
		
		String pluginLocation = UserPreferences.instance().getPreference( 
				UserPreferences.PLUGINS_DIR_KEY ).replace( '.', File.separatorChar );
		File dir = new File( pluginLocation );
		
		for( File f : dir.listFiles() ) {
			
			JarFile jarFile = new JarFile( f );
			Enumeration<JarEntry> entries = jarFile.entries();
			
			URL[] urls = { getJarUrl( f.getName() ) };
			URLClassLoader cl = URLClassLoader.newInstance(urls);
			
			// TODO read the manifest to find the location of the entry point 
			// instead of looking through all the entries in the JAR.

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
			String pluginLocation = UserPreferences.instance().getPreference( 
					UserPreferences.PLUGINS_DIR_KEY ).replace( '.', File.separatorChar );
			return new URL( 
				"jar:file:" + pluginLocation + File.separatorChar + jarName + 
				"!" + File.separatorChar );
		}
		catch( MalformedURLException e ) {
			System.out.println( "Bad URL" );
			return null;
		}
	}
}
