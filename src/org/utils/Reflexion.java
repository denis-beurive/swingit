package org.utils;

import java.lang.reflect.Method;

public class Reflexion
{
	public static Boolean compareParametersLists(Class[] in_parameters1, Class[] in_parameters2)
	{
		if (in_parameters1.length != in_parameters2.length) { return Boolean.FALSE; }
		for (int i=0; i<in_parameters1.length; i++)
		{
			if (in_parameters1[i].getName() == in_parameters2[i].getName()) { return Boolean.TRUE; }
		}
		return Boolean.FALSE;
	}
	
	public static Method getMethodByName(Class in_class, String in_name, Class[] in_parameters)
	{
		Method methods[] = in_class.getMethods();
		for (Method m: methods)
		{
			if (m.getName() == in_name)
			{
				System.out.println("Found the method " + m.getName());
				Class params[] = m.getParameterTypes();
				if (Reflexion.compareParametersLists(params, in_parameters)) { return m; }
			}
		}
		return null;
	}

}
