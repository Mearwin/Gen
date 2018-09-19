package packagePrincipale;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Tree extends Entity {

	private static int periode = 40;
	public static int taille = 60;
	private int positionCycle;
	
	public Tree(int x, int y) {
		super(x, y);
		positionCycle = periode;
	}
	
	public boolean isEmpty() {
		return positionCycle < periode;
	}
	
	public int cueillir() {
		int retour;
		if (positionCycle >= periode) {
			retour = taille;
			positionCycle = 0;
		} else {
			retour = 0;
		}
		return retour;
	}
	
	public void action() {
		positionCycle++;
	}

	@Override
	public void draw(Graphics2D g2d) {
		if (positionCycle >= periode) {
			g2d.setColor(Color.green);
		} else {
			g2d.setColor(Color.red);
		}
		g2d.draw(new Rectangle2D.Double(x*8, y*8, 8, 8));
	}
}
