package org.swingit.config;

public class DEBUG
{
	public static Boolean debugOutput  = Boolean.FALSE;
	public static Boolean debugDispose = Boolean.TRUE;
	
	public static void out(String in_string)
	{
		if (DEBUG.debugOutput) { System.out.println(in_string); }
	}
}
