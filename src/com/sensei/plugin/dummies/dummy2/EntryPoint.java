package com.sensei.plugin.dummies.dummy2;

import com.sensei.plugin.Plugin;

public class EntryPoint implements Plugin {

	@Override
	public byte[] getIcon(){
		return new byte[]{ 1 };
	}

	@Override
	public String getName(){
		return "DummyPlugin 2";
	}

	@Override
	public String getUpdateDownloadURL(){
		return "https://incubator.com/plugin/dummies/dummy2/update/download";
	}

	@Override
	public String getUpdateIDURL() {
		return "https://incubator.com/plugin/dummies/dummy2/update/id";
	}

	@Override
	public long getUpdateID(){
		return 1100;
	}

	@Override
	public String process( String input ){
		return "JSON reply from DummyPlugin 2";
	}

}
