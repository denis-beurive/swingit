package org.swingit.tools;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Window;
import java.lang.reflect.*;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Iterator;

/**
 * This class implements a listener's manager.
 * Using this manager, it is possible to remove all listeners that have already been assigned to a set of components or windows.
 * @author Denis Beurive
 */
public class ListenerManager
{
	private ArrayList<Object> __objects = new ArrayList<Object>();
	
	/**
	 * This method adds a new element to manage.
	 * @param in_object Object to manage. It must be an instance of one of the following classes:
	 *        <ul>
	 *        	<li>Window</li>
	 *        	<li>JComponent</li>
	 *        </ul>
	 * @throws Exception
	 */
	public void add(Object in_object)
	{
		// System.out.println("add() " + in_object.getClass().getName());
		if (! this.__isListening(in_object)) { return; }
		int position = this.__objects.indexOf(in_object);
		if (-1 == position) { this.__objects.add(in_object); }
	}
	
	/**
	 * This method removes all listeners from the list of managed elements.
	 * @throws Exception
	 */
	public void removeAllListeners() throws Exception
	{
		Method _getActionListeners = null;
		Method _getWindowListeners = null;
		
		for (Object o: this.__objects)
		{
			try { _getActionListeners = o.getClass().getMethod("getActionListeners"); } catch (NoSuchMethodException e) { _getActionListeners = null; }
			try { _getWindowListeners = o.getClass().getMethod("getWindowListeners"); } catch (NoSuchMethodException e) { _getWindowListeners = null; }
			if ((null != _getActionListeners) && (null != _getWindowListeners)) { throw new Exception("Internal error!"); }
			
			if (null != _getActionListeners)
			{
				ActionListener listeners[] = (ActionListener[]) _getActionListeners.invoke(o);
				this.__removeActionListeners((JComponent)o, listeners);
				continue;
			}
			
			if (null != _getWindowListeners)
			{
				WindowListener listerners[] = (WindowListener[]) _getWindowListeners.invoke(o);
				this.__removeWindowListeners((Window)o, listerners);
				continue;
			}
		}
	}
	
	/**
	 * Remove a given action listener from a given component.
	 * @param in_component Component from which the listener will be removed.
	 * @param in_actionListeners List of listeners to remove.
	 * @throws Exception
	 */
	private void __removeActionListeners(JComponent in_component, ActionListener in_actionListeners[]) throws Exception
	{
		// System.out.println("removeActionListeners()");
		Method _removeActionListener = in_component.getClass().getMethod("removeActionListener", Class.forName("java.awt.event.ActionListener"));

		for (ActionListener actionListener: in_actionListeners)
		{
			_removeActionListener.invoke(in_component, actionListener);
			// System.out.println("\t+ Remove listener on " + in_component.getClass().getName() + " for listener " + actionListener.getClass().getName());
		}
	}
	
	/**
	 * Remove a given window listener from a given window.
	 * @param in_window Window from which the listener will be removed.
	 * @param in_windowListeners List of listeners to remove.
	 * @throws Exception
	 */
	private void __removeWindowListeners(Window in_window, WindowListener in_windowListeners[]) throws Exception
	{
		// System.out.println("removeWindowListeners()");
		
		for (WindowListener windowListener: in_windowListeners)
		{
			in_window.removeWindowListener(windowListener);
			// System.out.println("\t+ Remove listener on Window " + windowListener.getClass().getName() + " for listener " + windowListener.getClass().getName());
		}
	}
	
	/**
	 * This method tests if a given object can be associated to listeners.
	 * @param in_object Object to test.
	 * @return If the given object can be associated to listeners, then the method returns the value TRUE.
	 *         Otherwize, ir returns the value FALSE.
	 */
	private Boolean __isListening(Object in_object)
	{
		Method _getActionListeners = null;
		Method _getWindowListeners = null;
		try { _getActionListeners = in_object.getClass().getMethod("getActionListeners"); } catch (NoSuchMethodException e) { _getActionListeners = null; }
		try { _getWindowListeners = in_object.getClass().getMethod("getWindowListeners"); } catch (NoSuchMethodException e) { _getWindowListeners = null; }
		if ((null == _getActionListeners) && (null == _getWindowListeners)) { return Boolean.FALSE; }
		return Boolean.TRUE;
	}
	
	
}
