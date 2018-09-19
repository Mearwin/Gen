package packagePrincipale;

import packageInterface.InterfacePrincipale;
import packageInterface.Statistics;

public class MainAlpha {

	public static int tour;
	public static void main(String[] args) throws InterruptedException {
		L.log(CodeCensor.numbreOfScenario());
		Univers.hauteur = 70;
		Univers.largeur = 70;
		Univers.initUnivers();
		Univers.initTrees();
		int x, y, i;
		for (i = 0; i<100; i++) {
			//x = (int) (Math.random()*Univers.largeur);
			//y = (int) (Math.random()*Univers.hauteur);
			Code code = Code.codeFactorie();
			code.init(10);
			Vie ent = new Vie(0, 0, code);
			Univers.putEntity(ent);
			
			
			code = Code.codeFactorie();
			code.init(10);
			ent = new Vie(35, 35, code);
			Univers.putEntity(ent);
		}
		
		InterfacePrincipale itf = new InterfacePrincipale();
		for (tour = 0; tour < 3000; tour++) {
			Univers.action();
			InterfacePrincipale.runivers.repaint();
			Thread.sleep(50);
			/*if (i%10 == 0) {
				for (i = 0; i<50; i++) {
					Univers.putEntity(new Vie(0, 0, new Code(10)));
				}
			}*/
			if ((tour % 100) == 0) {
				Univers.lvlUp();
			}
			if ((tour % 20) == 0) {
				Statistics.evaluation();
			}
		}

	}
	
	
}
