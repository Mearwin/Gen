package packageInterface;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.plaf.SplitPaneUI;

import packagePrincipale.Univers;

public class InterfacePrincipale extends JFrame {

	public static RUnivers runivers;
	public static Statistics stats;
	public static JSplitPane splitP;
	
	public InterfacePrincipale() {
		runivers = new RUnivers();
		stats = new Statistics();
		splitP = new JSplitPane();
		splitP.setLeftComponent(runivers);
		splitP.setRightComponent(stats);
		
		
		this.add(splitP);
		this.addKeyListener(new EClavier());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}