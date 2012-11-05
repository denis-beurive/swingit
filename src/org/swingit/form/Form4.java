package org.swingit.form;

import javax.swing.*;
import java.awt.event.*;


public class Form4 extends JPanel implements ActionListener
{
	public Form4()
	{
		super();
		this.__build();
	}
	
	private void __build()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel label   = new JLabel("Click to open a dialog."); 
		JButton button = new JButton("Click");
		button.addActionListener(this);
		this.add(label);
		this.add(button);
	}
	
	public void test() throws Exception
	{
		JFrame w = (JFrame) SwingUtilities.getWindowAncestor(this);
		org.swingit.windows.Dialog dialog = new org.swingit.windows.Dialog(w);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{ 
		JButton button = (JButton) e.getSource();
		String action  = e.getActionCommand();
		System.out.println("> " + action);
		JFrame w = (JFrame) SwingUtilities.getWindowAncestor(this);
		try
		{
		    org.swingit.windows.Dialog dialog = new org.swingit.windows.Dialog(w);
		}
		catch (Exception ex)
		{
		    System.out.println("ERROR: " + ex.getMessage());
		}
	}
}
