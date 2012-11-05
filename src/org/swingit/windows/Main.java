package org.swingit.windows;

import javax.swing.*;
import java.awt.*;
import org.swingit.form.*;

/**
 * Create the application's frame. 
 * @note A "frame" has a "container".
 *       The "layout manager" is set to a "container".
 *       "JPanel" is a "container".
 * @author Denis Beurive
 *
 * @see http://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
 *      http://docs.oracle.com/javase/tutorial/uiswing/components/toplevel.html
 * 
 * Class hierarchy: Container <- Window <- Frame <- JFrame
 *                  Container <- Window <- Dialog -> JDialog
 * 
 * A JFrame _IS_ a container.
 * A JDialog _IS_ a container.
 * 
 * From the documentation:
 * As a rule, a standalone application with a Swing-based GUI has at least one containment hierarchy with a JFrame as its root.
 * For example, if an application has one main window and two dialogs, then the application has three containment hierarchies, and thus three top-level containers.
 * One containment hierarchy has a JFrame as its root, and each of the other two has a JDialog object as its root.
 */

public class Main extends JFrame 
{
	private Form4 __dialog = new Form4();
	
	/**
	 * Create the application's container.
	 */
	public Main()
	{
		// Note: This frame is the base frame for the application. It does not have any parent's frame.
		super();
		__build();
	}
	
	private void __build()
	{
		// Set the size and define the behaviour.
		setTitle("Première fenêtre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Set the layout for the container. 
		// We set a layout with one column over several lines.
		// Warning: A layout applies on a container.
		//          The method getContentPane() returns the container.
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		// Add the first cell.
		this.add(new Form1());
		
		// Add the second cell.
		this.add(new Form2());
		
		// Add the combo box on the third cell.
		this.add(new Form3());
		
		// Add the button that opens a dialog box.
		this.add(this.__dialog);
		
		// Size the frame.
		// You can set the size of the window explicitly.
		// Or you can call pack().
		// But do not call setSize() and pack() simultaneously.
		Boolean fixed = Boolean.TRUE;
		if (fixed) { setSize(300, 600); } else { this.pack(); }
	}
	
	/**
	 * This method is used to test the destruction of allocated "JDialog" windows.
	 * @throws Exception
	 */
	public void testJDialogDestruction() throws Exception
	{
		this.__dialog.test();
	}
	
}
