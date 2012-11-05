package org.swingit.windows;

import javax.swing.*;
import org.swingit.config.DEBUG;
import org.swingit.tools.*;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;

/**
 * This class implements a dialogue's window.
 * @author Denis Beurive
 */
public class Dialog extends JDialog implements ActionListener
{
	ListenerManager __handlerManager = new ListenerManager();
	
	
	public Dialog(Frame in_parent) throws Exception
	{
		super(in_parent, "This is a Dialog box", true);
		
		// The following line only controls the windows' close button (under Windows: the upper right cross).
		// DO_NOTHING_ON_CLOSE
		// DISPOSE_ON_CLOSE
		// HIDE_ON_CLOSE
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Set the listener that catches all windows' events.
		this.addWindowListener(new Listener(this.__handlerManager));
		
		// Apply a layout.
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		// Add a combox box.
		ComboItem[] list = { new ComboItem(JFrame.DO_NOTHING_ON_CLOSE, "DO_NOTHING_ON_CLOSE"), new ComboItem(JFrame.DISPOSE_ON_CLOSE, "DISPOSE_ON_CLOSE"), new ComboItem(JFrame.HIDE_ON_CLOSE, "HIDE_ON_CLOSE") };
		JComboBox combo = new JComboBox(list);
		combo.addActionListener(this);
		this.add(combo);
		
		// Add the button.
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(this);
		this.add(closeButton);
		
		// Size the frame.
		// You can set the size of the window explicitly.
		// Or you can call pack().
		// But do not call setSize() and pack() simultaneously.
		this.pack();

		// Set the window visible.
		this.setVisible(true);
		
		// Set the list of components to manage.
		this.__handlerManager.add(this);
		this.__handlerManager.add(combo);
		this.__handlerManager.add(closeButton);
	}
	
	public void closeMe()
	{
		this.dispose();
	}
	
	/**
	 * Method executed whenever an event occurs.
	 * @param e Event.
	 */
	public void actionPerformed(ActionEvent e)
	{ 
		// See: http://stackoverflow.com/questions/1343542/programmatically-close-a-jdialog
		// Closing a window (with dispose()) and hiding it (with setVisible(false)) are different operations, and produce different events -- and closing it from the operating system is yet another different operation that produces yet a different event.
		// All three will produce windowDeactivated to tell you the window's lost focus, but dispose() will then produce windowClosed, while closing from the OS will first produce windowClosing. If you want to handle both of these the same way, you can set the window to be disposed when closed:
		// window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// n general, setVisible(false) implies that you might want to use the window again, so it doesn't post any window events (apart from windowDeactivated).
		
		Object source = e.getSource();
		
		if (source instanceof JButton)
		{
			// This is the button used to close the dialog window.
			this.dispose();
		}
		
		if (source instanceof JComboBox)
		{
			// This is the combo box used to change the close configuration.
			JComboBox combo = (JComboBox) source;
			ComboItem item = (ComboItem) combo.getSelectedItem();
			DEBUG.out("Set close mode to " + item);
			this.setDefaultCloseOperation(item.get());
		}
	}
	
	/**
	 * This class is used to catch the dialog's events.
	 */
	class Listener implements java.awt.event.WindowListener
	{
		private ListenerManager __handlerManager = null;
		
		public Listener(ListenerManager in_manager)
		{
			this.__handlerManager = in_manager;
		}
		
		public void windowActivated(WindowEvent e)
		{
			DEBUG.out("[Window activated]");
		}
		
		public void windowClosed(WindowEvent e) 
		{
			// When you "dispose" a window, the object associated to the window's object still exists.
			// Therefore, this object still responds to events.
			// This behaviour is not what you expect.
			// That's why we remove all attached listeners to the window...
			
			DEBUG.out("[Window closed => Removing all listeners]");
			
			try { this.__handlerManager.removeAllListeners(); }
			catch (Exception ex) { System.out.println(">>>>> " + ex.getMessage()); }
		}
		
		public void windowClosing(WindowEvent e)
		{
			JDialog w = (JDialog) e.getSource();
			DEBUG.out("[Window is closing]");
			// If you want to close the window, you should dispose (or hide it) it.
		}
		
		public void windowDeactivated(WindowEvent e)
		{
			DEBUG.out("[Window deactivated");
		}
		
		public void windowDeiconified(WindowEvent e)
		{
			DEBUG.out("[Window deiconified]");
		}
		
		public void windowIconified(WindowEvent e)
		{
			DEBUG.out("[Window iconified]");
		}
		
		public void windowOpened(WindowEvent e)
		{
			DEBUG.out("[Window opened]");
			JDialog w = (JDialog) e.getSource();
			w.dispose();
		}
	}
	
	/**
	 * This class represents a combo box item.
	 */
	class ComboItem
	{
		private int    __object = 0;
		private String __name   = null;
		
		public ComboItem(int in_object, String in_name)
		{
			this.__object = in_object;
			this.__name   = in_name;
		}
		
		public String toString() { return this.__name; }
		
		public int get() { return this.__object; }
	}
	
	/**
	 * This method is used for debugs.
	 */
	protected void finalize() throws Throwable {
	    try
	    {
	    	    System.out.println("!!! Destroying Dialog's object !!!");
	    }
	    finally
	    {
	        System.out.println("!!! Destroying Dialog's object !!!");
	        super.finalize();
	    }
	}
	
}
