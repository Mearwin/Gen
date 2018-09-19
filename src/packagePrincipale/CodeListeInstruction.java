package packagePrincipale;

import java.util.ArrayList;

public class CodeListeInstruction extends Code {
	
	public CodeListeInstruction(CodeListeInstruction c) {
		super(c);
	}
	
	public CodeListeInstruction() {
		super();
	}
	
	public void init(int taille) {
		this.clear();
		int r;
		System.out.print("Code:");
		for (int i = 0; i<taille; i++) {
			r = (int) (Math.random()*6);
			System.out.print(r);
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
		System.out.println("-\n");
	}
	
	public Action nextAction(Vie vie) {
		return this.get(vie.age%(this.size()));
	}
	
	
	public void inserer(Code c2) {
		ArrayList<Action> debut;
		ArrayList<Action> fin;
		int idxDebut = (int) Math.random()*size();
		if (idxDebut <= this.size()) {
			debut = new ArrayList<Action>(this.subList(0, idxDebut));
			fin = new ArrayList<Action>(this.subList(idxDebut, this.size()));
		} else {
			debut = new ArrayList<Action>(this);
		fin = new ArrayList<Action>();
		}
		this.clear();
		this.addAll(debut);
		this.addAll(c2);
		this.addAll(fin);
	}
	
	public void remplacer(Code c2) {
		ArrayList<Action> debut = null;
		ArrayList<Action> fin = null;
		int idxDebut = (int) Math.random()*size();
		if (idxDebut <= size()) {
			debut = new ArrayList<Action>(this.subList(0, idxDebut));
		} else {
			debut = new ArrayList<Action>(this);
		}
		if ((size() - idxDebut - c2.size()) >= 0) {
			fin = new ArrayList<Action>(this.subList(idxDebut+c2.size(), size()));
		}
		
		this.clear();
		this.addAll(debut);
		this.addAll(c2);
		if (fin != null) {
			this.addAll(fin);
		}
	}
	
	public void retirer() {
		int r1 = (int) (Math.random()*this.size());
		//int r2 = (int) (Math.random()*(this.size()-r1));
		int r2 = Math.min( 
				(int) ((this.size()-r1) + (Math.exp(- Math.random()*(this.size()-r1))) -1),
				(int) (this.size()-r1));
		r2 += r1;
		this.removeRange(r1, r2);
	}
	
	public Code mutation(Code code2) {
		int r1 = (int) (Math.random()*3);
		CodeListeInstruction newCode = new CodeListeInstruction(this);
		
		if (r1 == 1) {
			newCode.remplacer(code2.subCode());
		} else if (r1 == 2 ){
			newCode.inserer(code2.subCode());
		} else {
			newCode.retirer();
		}
		return newCode;
	}
	
	
	public String toString() {
		String retour = "";
		for (Action a : this) {
			retour += "-"+a;
		}
		return retour;
	}
}
