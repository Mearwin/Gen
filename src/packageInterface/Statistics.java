package packageInterface;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTree;

import packagePrincipale.MainAlpha;
import packagePrincipale.Univers;

public class Statistics extends JPanel {
	
	public static JLabel lTour;
	public static JLabel lLevel;
	public static JLabel lAgeMoyen;
	public static JLabel lPopulationTotal;
	public static JPanel lPopulationParSouche;
	
	public static int ageMoyen;
	public static int populationTotal;
	public static ArrayList<Integer> populationParSouche;
	

	public Statistics() {
		super();
		
		populationParSouche = new ArrayList<Integer>();
		for (int i = 0; i<200; i++) {
			Statistics.populationParSouche.add(1);
		}
		
		lTour = new JLabel();
		lLevel = new JLabel();
		lAgeMoyen = new JLabel();
		lPopulationTotal = new JLabel();
		lPopulationParSouche = new JPanel();
		
		Box main = Box.createVerticalBox();
		
		main.add(lTour);
		main.add(lLevel);
		main.add(lAgeMoyen);
		main.add(lPopulationTotal);
		
		this.add(main);
		this.add(lPopulationParSouche);
		
		Statistics.lAgeMoyen.setText("Age moyen: " + ageMoyen);
		Statistics.lPopulationTotal.setText("Population total:"+ populationTotal);
	}
	
	public static void evaluation() {
		Univers.statistics();
		Statistics.lTour.setText("Tour : " + MainAlpha.tour);
		Statistics.lLevel.setText("Level : " + Univers.level);
		Statistics.lAgeMoyen.setText("Age moyen: " + ageMoyen);
		Statistics.lPopulationTotal.setText("Population total:"+ populationTotal);
		Statistics.lPopulationParSouche.removeAll();
		for (int i = 0; i < 100; i++) {
			if (Statistics.populationParSouche.get(i) != 0) {
				Statistics.lPopulationParSouche.add(new JLabel(i+"->"+Statistics.populationParSouche.get(i)));
			}
		}
	}
	
}
