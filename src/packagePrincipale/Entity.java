package packagePrincipale;

import java.awt.Graphics2D;

public abstract class Entity {
	
	public int x;
	public int y;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void action();
	public abstract void draw(Graphics2D g2d);

}
