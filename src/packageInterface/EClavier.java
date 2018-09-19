package packageInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import packagePrincipale.Univers;

public class EClavier implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyChar() == 's') {
			Statistics.evaluation();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
