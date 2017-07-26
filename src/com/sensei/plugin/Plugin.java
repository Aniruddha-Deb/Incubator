package com.sensei.plugin;

public interface Plugin {

	public byte[] getIcon();
	
	public String getName();
	
	public String getUpdateDownloadURL();
	
	public String getUpdateIDURL();
	
	public long getUpdateID();
	
	public String process( String input );
}
