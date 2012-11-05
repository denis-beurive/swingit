/**
 * This file illustrates the following points:
 *   - The use of containers.
 *   - The use of layouts.
 *   - The use of "foreign" action's handlers (see class SimpleStdoutAction).
 */

package org.swingit.form;

import org.swingit.actions.*;

import javax.swing.*;

import java.awt.*;

/**
 * This class implements a window that contains four buttons and a label.
 * The important point is that this class subcontracts the actions' management.
 * @author Denis Beurive
 */
public class Form2 extends JPanel
{
	private JLabel  __titre   = new JLabel("Form number 2");
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
	
	public Form2()
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
		JPanel first_line   = new JPanel();
		JPanel second_line  = new JPanel();
		JPanel third_line   = new JPanel();
		JPanel fourth_line  = new JPanel();
		first_line.setLayout   (new FlowLayout());
		second_line.setLayout  (new FlowLayout());
		third_line.setLayout   (new FlowLayout());
		fourth_line.setLayout  (new FlowLayout());
		
		// Add title to the first line.
		first_line.add(this.__titre);
		
		// Add buttons to the first line.
		second_line.add(this.__button1);
		second_line.add(this.__button2);

		// Add buttons to the second line.
		third_line.add(this.__button3);
		third_line.add(this.__button4);
		
		// Add the label to the third line.
		fourth_line.add(this.__label);
		
		// Associate an action to all buttons.
		this.__button1.addActionListener(new SimpleAction("Button 1 clicked"));
		this.__button2.addActionListener(new SimpleAction("button 2 clicked"));
		this.__button3.addActionListener(new SimpleActionListener());
		this.__button4.addActionListener(new SimpleActionListener());
		
		// Add the four lines to the overall panel.
		this.add(first_line);
		this.add(second_line);
		this.add(third_line);
		this.add(fourth_line);
	}
}
