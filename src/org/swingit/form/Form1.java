/**
 * This file illustrates the following points:
 *   - The use of containers.
 *   - The use of layouts.
 *   - The use of "embedded" action's handlers.
 */

package org.swingit.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class implements a window that contains four buttons and a label.
 * @note The important point is that actions are handled by the class itself.
 *       Please note that an action listener is nothing more than a class that implements a method "void actionPerformed(ActionEvent e)".
 * @author Denis Beurive
 */
public class Form1 extends JPanel implements ActionListener
{
	private JLabel  __titre   = new JLabel("Form number 1");
	private JButton __button1 = new JButton("test1");
	private JButton __button2 = new JButton("test2");
	private JButton __button3 = new JButton("test3");
	private JButton __button4 = new JButton("test4");
	private JLabel  __label   = new JLabel(" ");
	
	// Note:
	// The height of the label field "__label" is known only if a text is written within the field.
	// If the height of the label is unknown, then the window does not consider it during startup.
	// Therefore, the height of the window will not be big enough (the label will be invisible).
    // That's the reason why we put a space in the label.
	
	public Form1()
	{
		super();
		this.__build();
	}
	
	/**
	 * Build the form.
	 */
	private void __build()
	{
		// Apply a global layout for this container.
		// http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		// http://docs.oracle.com/javase/tutorial/uiswing/layout/using.html
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Add some containers with a horizontal alignment.
		JPanel first_line  = new JPanel();
		JPanel second_line = new JPanel();
		JPanel third_line  = new JPanel();
		JPanel fourth_line = new JPanel();
		first_line.setLayout  (new FlowLayout());
		second_line.setLayout (new FlowLayout());
		third_line.setLayout  (new FlowLayout());
		fourth_line.setLayout (new FlowLayout());
		
		// Add title to the first line.
		first_line.add(this.__titre);
		
		// Add buttons to the second line.
		second_line.add(this.__button1);
		second_line.add(this.__button2);

		// Add buttons to the third line.
		third_line.add(this.__button3);
		third_line.add(this.__button4);
		
		// Add the label to the fourth line.
		fourth_line.add(this.__label);
		
		// Associate an action to all buttons.
		this.__button1.addActionListener(this);
		this.__button2.addActionListener(this);
		this.__button3.addActionListener(this);
		this.__button4.addActionListener(this);
		
		// Add the four lines to the overall panel.
		this.add(first_line);
		this.add(second_line);
		this.add(third_line);
		this.add(fourth_line);
	}
	
	/**
	 * Method executed whenever an event occurs.
	 * @param e Event.
	 */
	public void actionPerformed(ActionEvent e)
	{ 
		Object source = e.getSource();
		
		if (this.__button1 == source)
		{
			this.__label.setText("Button 1 clicked");
		}

		if (this.__button2 == source)
		{
			this.__label.setText("Button 2 clicked");
		}

		if (this.__button3 == source)
		{
			this.__label.setText("Button 3 clicked");
		}

		if (this.__button4 == source)
		{
			this.__label.setText("Button 4 clicked");
		}
	}
}
