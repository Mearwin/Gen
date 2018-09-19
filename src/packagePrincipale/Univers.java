package packagePrincipale;

import java.util.ArrayList;
import java.util.List;

import packageInterface.Statistics;

public class Univers {
	
	public static ArrayList<Entity> tableau;
	public static int largeur;
	public static int hauteur;
	public static int level;
	
	public static void  initUnivers() {
		level = 0;
		tableau = new ArrayList<Entity>();
	}
	
	public static void action() {
		ArrayList<Entity> tableauI = new ArrayList<Entity>(tableau);
		for (Entity ent : tableauI) {
			ent.action();
		}
	}
	
	public static void initTrees() {
		int x, y;
		for (int i = 0; i<C.nbTree; i++) {
			x = (int) (Math.random()*largeur);
			y = (int) (Math.random()*hauteur);
			tableau.add(new Tree(x, y));
		}
	}
	
	public static ArrayList<Entity> getEntity(int x, int y) {
		ArrayList<Entity> retour = new ArrayList<Entity>();
		for (Entity ent : tableau) {
			if (ent.x == x && ent.y == y) {
				retour.add(ent);
			}
		}
		return retour;
	}
	
	public static ArrayList<Entity> getEntity(int x, int y, Class<? extends Entity> c) {
		ArrayList<Entity> retour = new ArrayList<Entity>();
		for (Entity ent : tableau) {
			if (ent.x == x && ent.y == y && ent.getClass() == c) {
				retour.add(ent);
			}
		}
		return retour;
	}
	
	public static void rmEntity(Entity ent) {
		tableau.remove(ent);
	}
	
	public static void die(Entity ent) {
		tableau.remove(ent);
		
		Statistics.populationParSouche.set(((Vie) ent).generation, 
				Statistics.populationParSouche.get(((Vie) ent).generation)-1);
		
		
		L.log("////DIE age:"+((Vie) ent).age+" code:"+((Vie) ent).code.size()
				+" faim:"+((Vie) ent).faim+" gene:"+((Vie) ent).generation);
	}
	
	public static void putEntity(Entity ent) {
		tableau.add(ent);
	}

	public static void statistics() {
		int ageMoyen = 0;
		Statistics.populationTotal = 0;
		
		
		ArrayList<Entity> tableauI = new ArrayList<Entity>(tableau);
		for (Entity ent : tableauI) {
			if (ent.getClass() == Vie.class) {
				Vie entv = (Vie) ent;
				Statistics.populationTotal++;
				ageMoyen += entv.age;
			}
		}
		if (Statistics.populationTotal == 0) {
			Statistics.ageMoyen = 0;
		} else {
			Statistics.ageMoyen = ageMoyen / Statistics.populationTotal;
		}
	}
	
	public static void lvlUp() {
		if (level < 5)
			level++;
		//if (Tree.taille > 30) Tree.taille -= 1;
	}
}
