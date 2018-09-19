package packagePrincipale;

import java.util.ArrayList;
import java.util.Random;

public class CodeCensor extends Code {
	
	private int nbCases = 5;
	private int nbStates = 4;

	
	public CodeCensor() {
		super();
	}
	
	public CodeCensor(Code c) {
		super(c);
	}
	
	public void init(int taille) {
		Random ran = new Random();
		int r;
		for (int i = 0; i < numbreOfScenario(); i++) {
			r = ran.nextInt(6);
			switch (r) {
			case 0:
				this.add(Action.DROITE);
				break;
			case 1:
				this.add(Action.GAUCHE);
				break;
			case 2:
				this.add(Action.BAS);
				break;
			case 3:
				this.add(Action.HAUT);
				break;
			case 4:
				this.add(Action.CUEILLE);
				break;
			case 5:
				this.add(Action.REPROD);
				break;
			default:
				break;
			}
		}
	}
	
	@Override
	protected void inserer(Code c2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void remplacer(Code c2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void retirer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Code mutation(Code code2) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Action nextAction(Vie vie) {
		return this.get(evalState(vie));
	}
	/**
	 * cases : 13
	 *   #
	 * 	###
	 * #####
	 *  ###
	 *   #
	 *  cases : 5
	 *   #
	 *  ###
	 *   #
	 * @return
	 */
	
	
	public static int numbreOfScenario() {
		int retour;
		int states = 2*3;
		int cases = 5;
		retour = (int) Math.pow(states, cases);
		return retour;
	}
	
	public int evalState(Vie vie) {
	int retour = 0;
	int state;
		for (int i = 0; i < nbCases; i++) {
			state = evaleCase(i, vie);
			retour += state*Math.pow(nbStates, i);
		}	
	return retour;
	}
	/**
	 *  0
	 * 123
	 *  4
	 * @param i
	 * @param vie
	 * @return
	 */
	private int evaleCase(int i, Vie vie) {
		Integer retour = null;
		Integer x = null;
		Integer y = null;
		if (i == 0) {
			x = vie.x;
			y = vie.y+1;
		} else if (i == 1) {
			x = vie.x-1;
			y = vie.y;
		} else if (i == 2) {
			x = vie.x;
			y = vie.y;
		} else if (i == 3) {
			x = vie.x+1;
			y = vie.y;
		} else if (i == 4) {
			x = vie.x;
			y = vie.y-1;
		} else {
			System.err.print(this + "wrong nbCases");
		}
		boolean autreVie = false;
		//0: no tree - 1: empty tree - 2: full tree
		int tree = 0;
		ArrayList<Entity> ents = Univers.getEntity(x, y, Vie.class);
		for (Entity ent : ents) {
			if (!ent.equals(vie)) {
				autreVie = true;
			}
		}
		ents = Univers.getEntity(x, y, Tree.class);
		if (ents.size() != 0) {
			tree = 1;
		}
		for (Entity ent : ents) {
			if (!((Tree) ent).isEmpty()) {
				tree = 2;
			}
		}
		
		if (autreVie) {
			if (tree == 0) {
				retour = 0;
			} else if (tree == 1) {
				retour = 1;
			} else if (tree == 2) {
				retour = 2;
			}
		} else {
			if (tree == 0) {
				retour = 3;
			} else if (tree == 1) {
				retour = 4;
			} else if (tree == 2) {
				retour = 5;
			}
		}
		
		return retour;
	}
	
}
