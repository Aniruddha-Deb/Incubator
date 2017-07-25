package com.sensei.plugin;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoaderTest {
	
	public static void main( String[] args ) throws Exception{
		Class<?> c = loadPlugin( "Class2" );
		Object o = c.newInstance();
		Method method1 = c.getMethod( "method2", new Class<?>[]{ new String().getClass() } );
		String returnVal = (String)method1.invoke( o, "hello" );
		System.out.println( returnVal );
	}
	
	public static Class<?> loadPlugin( String pluginName ) throws Exception {
		File dir = new File( "res/plugins" );
		for( File f : dir.listFiles() ) {
			JarFile jarFile = new JarFile( f );
			Enumeration<JarEntry> entries = jarFile.entries();
			
			URL[] urls = { new URL("jar:file:" + "res/plugins/" + f.getName() + "!/") };
			URLClassLoader cl = URLClassLoader.newInstance(urls);
			
			while( entries.hasMoreElements() ) {
				JarEntry je = entries.nextElement();
				String className = je.getName().substring( 0, je.getName().length()-6 );
			    className = className.replace('/', '.');
			    if( className.endsWith( pluginName ) ) {
			    	jarFile.close();
			    	return cl.loadClass( className );
			    }
			}
			jarFile.close();
		}		
		return null;
	}

}
