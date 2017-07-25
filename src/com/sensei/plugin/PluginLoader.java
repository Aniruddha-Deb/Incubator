package com.sensei.plugin;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader extends ClassLoader {
	
	public PluginLoader( ClassLoader parent ) {
		super( parent );
	}

	@Override
	public Class<?> loadClass( String name ) throws ClassNotFoundException{
		return super.loadClass( name );
	}
	
	
	private Class<?> loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(
                name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        Class<?> c = defineClass(name, buff, 0, buff.length);
        resolveClass(c);
        return c;
    }	
}
