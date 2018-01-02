package com.sensei.cliparser;

public class Command {
	
	String cmd = null;
	TextParameter text = null;
	NumericParameter id = null;
	NumericParameter date = null;
	
	public Command( String cmd ) {
		this.cmd = cmd;
	}

	@Override
	public String toString() {
		String textStr = (text == null) ? "null" : text.toString();
		String idStr = (id == null) ? "null" : id.toString();
		String dateStr = (date == null) ? "null" : date.toString();
		return cmd + "\n"
			 + textStr + "\n"
			 + idStr + "\n"
			 + dateStr + "\n";
	}
}
