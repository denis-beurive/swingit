package org.swingit.runtime;


import javax.swing.*;

import org.swingit.windows.*;
import org.swingit.config.DEBUG;
import org.swingit.tools.*;


/**
 * This class implements the main entry point.
 * @author Denis Beurive
 */
public class Run
{
	/**
	 * This method implements the main entry point.
	 * @param args Command line arguments.
	 * @author Denis Beurive
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater
		(
			new Runnable()
			{
				public void run()
				{
					DEBUG.debugOutput        = Boolean.FALSE;
					DEBUG.debugDispose = Boolean.TRUE;
					
				    try
				    {
				        Main main = new Main();
				        main.setVisible(true);
				        
				        if (DEBUG.debugDispose)
				        for (int i=0; i<1000000; i++) { main.testJDialogDestruction(); }
				        
				    }
				    catch (Exception e)
				    {
				        System.out.println("ERROR: " + e.getMessage());
				    }
				    
				}
			}
		);

		
		
	}
}
