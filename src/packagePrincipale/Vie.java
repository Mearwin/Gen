package packagePrincipale;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import packageInterface.Statistics;

public class Vie extends Entity {

	public static int ageMax = 400;
	public static int generationMax = 0;
	
	public int generation;
	public Code code;
	public int faim;
	public int age;
	
	public Vie(int x, int y, Code c) {
		super(x, y);
		generation = generationMax++;
		code = c;
		faim = 40;
		age = 0;
	}
	
	public Vie(int x, int y, int gen, int faim, Code code) {
		super(x, y);
		generation = gen;
		this.faim = faim;
		age = 0;
		this.code = code;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.blue);
		g2d.fill(new Rectangle2D.Double(x*8+2, y*8+2, 4, 4));
	}

	public void action() {
		if (age == ageMax || faim == 0) {
			Univers.die(this);
		} else {
			ArrayList<Entity> ents;
			Action action = code.nextAction(this);
			//System.out.println(code.toString() +"->"+ action);
			switch (action) {  
			case DROITE: 
				if (x<Univers.largeur-1) {
					x++;
				} else {
					x=0;
				}
			
				break;
			case GAUCHE:
				if (x>0) {
					x--;
				} else {
					x=Univers.largeur;
				}
				break;
			case BAS:
				if (y>0) {
					y--;
				} else {
					y=Univers.hauteur;
				}
				break;
			case HAUT:
				if (y<Univers.hauteur-1) {
					y++;
				} else {
					y=0;
				}
				break;
			case CUEILLE:
				ents = Univers.getEntity(x, y, Tree.class);
				for (Entity ent : ents) {
					faim += ((Tree) ent).cueillir();
				}
				break;
			case REPROD:
				ents = Univers.getEntity(x, y, Vie.class);
				ents.addAll(Univers.getEntity(x+1, y, Vie.class));
				ents.addAll(Univers.getEntity(x-1, y, Vie.class));
				ents.addAll(Univers.getEntity(x, y+1, Vie.class));
				ents.addAll(Univers.getEntity(x, y-1, Vie.class));
				for (Entity ent : ents) {
					if (!ent.equals(this)) {
						reprod((Vie) ent);
					}
				}
				break;
			default:
				System.err.println("Action invalide");
				break;
			}
			age++;
			faim--;
		}
	}
	
	private void reprod(Vie ent) {
		int r = (int) (Math.random()*100);
		if (faim >= 10 && age > 40 && r <= 50) {
			if (r <= 0.1) {
				Code newCode = this.mutation(ent.code);
				Univers.putEntity(new Vie(x, y, generation, faim-(faim/2), newCode));
			} else {
				Univers.putEntity(new Vie(x, y, generation, faim-(faim/2), code));
			}
			faim *= 0.7;
			Statistics.populationParSouche.set(generation, 
					Statistics.populationParSouche.get(generation)+1);
		}
	}
	
	private Code mutation(Code code2) {
		
		
		return this.code.mutation(code2);
	}
}