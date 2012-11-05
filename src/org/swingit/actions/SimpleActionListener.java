package org.swingit.actions;

import java.awt.event.*;


/**
 * This class implements a very simple action's listener.
 * It prints a message in the standard output.
 * @note Please note that there are two ways to write actions' handlers :
 *       <ul>
 *       	<li>Write a class that implements "ActionListener".</li>
 *       	<li>Write a class that extends "AbstractAction" (which implements "ActionListener").</li>
 *       </ul>
 * @author Denis Beurive
 */
public class SimpleActionListener implements ActionListener
{
	/**
	 * This is the method that performs the required action. 
	 */
	public void actionPerformed(ActionEvent e)
	{ 
		System.out.println("> ok");
	} 
}
