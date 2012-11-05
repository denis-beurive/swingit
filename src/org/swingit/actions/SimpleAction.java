/**
 * This file illustrates the manufacturing of special action's handler.
 */

package org.swingit.actions;

import javax.swing.*;
import java.awt.event.*;

/**
 * This class implements a very simple action's handler.
 * It prints a message in the standard output.
 * @note Please note that there are two ways to write actions' handlers :
 *       <ul>
 *       	<li>Write a class that implements "ActionListener".</li>
 *       	<li>Write a class that extends "AbstractAction" (which implements "ActionListener").</li>
 *       </ul>
 * @author Denis Beurive
 */
public class SimpleAction extends AbstractAction
{
	private String __message = null;
	
	/**
	 * Create the action's handler.
	 * @param in_message Message to print.
	 */
	public SimpleAction(String in_message)
	{
		super();
		this.__message = in_message;
	}
	
	/**
	 * This is the method that performs the required action. 
	 */
	public void actionPerformed(ActionEvent e)
	{ 
		System.out.println("> " + this.__message);
	} 
}
