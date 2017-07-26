package com.sensei.plugin.dummies.dummy1;

import com.sensei.plugin.Plugin;

public class EntryPoint implements Plugin {

	@Override
	public byte[] getIcon(){
		return new byte[]{ 1 };
	}

	@Override
	public String getName(){
		return "DummyPlugin 1";
	}

	@Override
	public String getUpdateDownloadURL(){
		return "https://incubator.com/plugin/dummies/dummy1/update/download";
	}

	@Override
	public String getUpdateIDURL() {
		return "https://incubator.com/plugin/dummies/dummy1/update/id";
	}

	@Override
	public long getUpdateID(){
		return 1101;
	}

	@Override
	public String process( String input ){
		return "JSON reply from DummyPlugin 1";
	}

}
