package packagePrincipale;

import java.util.ArrayList;

public abstract class Code extends ArrayList<Action> {
	
	public static Code codeFactorie() {
		Code retour = null;
		if (C.codeType.equals("CodeListeInstruction")) {
			retour = new CodeListeInstruction();
		} else if (C.codeType.equals("CodeCensor")) {
			retour = new CodeCensor();
		} else {
			L.log("erreur codeType inconnue");
		}
		return retour;
	}
	
	public abstract void init(int taille);
	
	public Code(Code c) {
		super(c);
	}
	
	public Code() {
		super();
	}
	
	protected abstract void inserer(Code c2);
	protected abstract void remplacer(Code c2);
	protected abstract void retirer();
	public abstract Code mutation(Code code2);
	public abstract Action nextAction(Vie vie);
	
	protected Code subCode() {
		int r1 = (int) (Math.random()*this.size());
		int r2 = Math.min( 
				(int) ((this.size()-r1)*(Math.exp(- 0.1 * Math.random()*(this.size()-r1)))),
				(int) (this.size()-r1));
		r2 += r1;
		CodeListeInstruction newCode = new CodeListeInstruction();
		for (int i = r1; i <= r2; i++) {
			newCode.add(this.get(i));
		}
		return newCode;
	}

}
