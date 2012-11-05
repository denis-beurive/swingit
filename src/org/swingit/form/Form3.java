package org.swingit.form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form3 extends JPanel implements ActionListener
{
	private JLabel  __titre = new JLabel("Form number 3");
	private JLabel  __label = new JLabel(" ");
	
	// Note:
	// The height of the label field "__label" is known only if a text is written within the field.
	// If the height of the label is unknown, then the window does not consider it during startup.
	// Therefore, the height of the window will not be big enough (the label will be invisible).
    // That's the reason why we put a space in the label.
	
	public Form3()
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

		// Create the combo box.
		String[] list = { "item1", "item2", "item3" };
		JComboBox combo = new JComboBox(list);
		combo.setSelectedIndex(0);
		combo.addActionListener(this);
		
		// Add the title, the combo box and the label.
		this.add(this.__titre);
		this.add(combo);
		this.add(this.__label);
	}
	
	/**
	 * Method executed whenever an event occurs.
	 * @param e Event.
	 */
	public void actionPerformed(ActionEvent e)
	{ 
		// Get the reference to the interactive component that thrown the event.
		// In this example, we know that it is the "combo box".
		JComboBox combo = (JComboBox) e.getSource();
		String item = (String) combo.getSelectedItem();
		this.__label.setText(item);
	}
}
