package packageInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import packagePrincipale.Entity;
import packagePrincipale.Univers;

public class RUnivers extends JPanel {

	public static int h = 8;
	
	public RUnivers() {
		super();
		this.setPreferredSize(new Dimension(Univers.largeur*h,Univers.hauteur*h));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		//Trace les entity
		ArrayList<Entity> tableauI = new ArrayList<Entity>(Univers.tableau); 
		for (Entity ent : tableauI)  {
			ent.draw(g2d);
		}
	}
}