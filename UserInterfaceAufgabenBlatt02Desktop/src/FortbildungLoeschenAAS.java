import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FortbildungLoeschenAAS {
	
	//------------------------------Attribute der Klasse--------------------------------------------------------------------------
	
	private OkLauscherFortbildungL�schen okFortbildungL�schen = new OkLauscherFortbildungL�schen();
	private BeendenLauscherFortbildungL�schen beendenFortbildungL�schen = new BeendenLauscherFortbildungL�schen();
	
	private JPanel fortbildungL�schenPanel = new JPanel();//panel was zur�ckgegeben wird
	private JPanel fortbildungPanell�schen;//Panel was im lauscher genutzt wird
	
	private JComboBox comboBoxFortbildungLoeschen;
	
	private static FortbildungLoeschenK kontrolle = new FortbildungLoeschenK();
	SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();
	FortbildungAuswaehlenAAS comboFortbildung = new FortbildungAuswaehlenAAS();

	//------------------------------------------------------------------------------------------------------------------------------
	//---------------------------AactionListener klasse des OK Button im Fortbildung L�schen Panel------------------------------------------------------
		private class OkLauscherFortbildungL�schen implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				
				
				JComboBox sachbearbeiterCombo1 = combo.oeffnen();
				String sachbearbeiter = sachbearbeiterCombo1.getSelectedItem().toString();
				JComboBox fortbildungCombo = comboFortbildung.oeffnen();
				String fortbildung1 = fortbildungCombo.getSelectedItem().toString();
				
				String[] optionen = { "Ja", "Nein" }; 
	            int n = JOptionPane.showOptionDialog( null, "Wollen Sie die Fortbildung " + fortbildung1 + " des Sachbearbeiter"+ sachbearbeiter + "  wirklich L�schen?", "Ja oder Nein", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionen,optionen[0] );       

	                if ( n == JOptionPane.YES_OPTION ) {  
	                  
	                	JComboBox sachbearbeiterCombo = combo.oeffnen();
	    				String name = sachbearbeiterCombo.getSelectedItem().toString();
	    				String fortbildung = comboBoxFortbildungLoeschen.getSelectedItem().toString();
	    				String erg = "";
	    				
	    				
	    				for(int i = 0;i<fortbildung.length();i++) {
	    					if(fortbildung.charAt(i) == '>') {
	    						break;
	    					}
	    					erg = erg + fortbildung.charAt(i);
	    				}
	    				
	    				if(kontrolle.fortbildungLoeschen(name, erg) == 2) {
	    					
	    					JOptionPane.showMessageDialog(null,
	    	                        "Sachbearbeiter: " + name + " Die Fortbildung: " + fortbildung + " wurde gel�scht ",
	    	                        "Sachbearbeiter Fortbildung L�schen",					      
	    	                        JOptionPane.INFORMATION_MESSAGE);
	    					SachbearbeiterAS.getInstance().entgrauen();
	    					AdministratorAS.getInstance().entgrauen();
	    					fortbildungPanell�schen.setVisible(false);
	    				}
	    				else {
	    					
	    				}
	                	
	                	
	                }
	                else if ( n == JOptionPane.NO_OPTION ) {
	                        
	                	
	                    }
//				JComboBox sachbearbeiterCombo = combo.oeffnen();
//				String name = sachbearbeiterCombo.getSelectedItem().toString();
//				String fortbildung = comboBoxFortbildungLoeschen.getSelectedItem().toString();
//				String erg = "";
//				
//				
//				for(int i = 0;i<fortbildung.length();i++) {
//					if(fortbildung.charAt(i) == '>') {
//						break;
//					}
//					erg = erg + fortbildung.charAt(i);
//				}
//				
//				if(kontrolle.fortbildungLoeschen(name, erg) == 2) {
//					
//					JOptionPane.showMessageDialog(null,
//	                        "Sachbearbeiter: " + name + " Die Fortbildung: " + fortbildung + " wurde gel�scht ",
//	                        "Sachbearbeiter Fortbildung L�schen",					      
//	                        JOptionPane.INFORMATION_MESSAGE);
//					SachbearbeiterAS.getInstance().entgrauen();
//					AdministratorAS.getInstance().entgrauen();
//					fortbildungPanell�schen.setVisible(false);
//				}
//				else {
//					JOptionPane.showMessageDialog(null,
//					"Bitte �berpr�fen sie Ihre Eingabe",
//                    "Warnung",					      
//                    JOptionPane.ERROR_MESSAGE);
//				}
				//############################Kontroll Ausgabe###################################################################
				System.out.println("Die Fortbildung wurde gel�scht");
				//###############################################################################################################
				
			}
		}
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//----------ActionListener Klasse fuer Beenden button im Fortbildung Zuordnen Panel---------------------------------------------------------------
		private class BeendenLauscherFortbildungL�schen implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				SachbearbeiterAS.getInstance().entgrauen();
				AdministratorAS.getInstance().entgrauen();
				fortbildungPanell�schen.setVisible(false);
			}
			}
		//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	public FortbildungLoeschenAAS() {
	
	fortbildungL�schenPanel.setLayout(null);
	fortbildungL�schenPanel.setSize(600, 250);
	
	JLabel lblFortbildungZuordnen = new JLabel("Fortbildung loeschen");
	lblFortbildungZuordnen.setBounds(23, 33, 129, 14);
	fortbildungL�schenPanel.add(lblFortbildungZuordnen);
	
	JLabel lblAusgewhlterSachbearbeiter = new JLabel("Ausgewaehlter Sachbearbeiter");
	lblAusgewhlterSachbearbeiter.setBounds(23, 90, 190, 14);
	fortbildungL�schenPanel.add(lblAusgewhlterSachbearbeiter);
	
	JLabel lblAusgewhlteFortbildung = new JLabel("Ausgewaehlte Fortbildung");
	lblAusgewhlteFortbildung.setBounds(222, 90, 200, 14);
	fortbildungL�schenPanel.add(lblAusgewhlteFortbildung);
	
//	JComboBox comboBoxFortbildung = new JComboBox();
//	comboBoxFortbildung.setBounds(222, 115, 148, 20);
//	fortbildungL�schenPanel.add(comboBoxFortbildung);
	
	
	
	JComboBox ComboBoxSachbearbeiter = combo.oeffnen();
	ComboBoxSachbearbeiter.setBounds(23, 115, 148, 20);
	ComboBoxSachbearbeiter.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = ComboBoxSachbearbeiter.getSelectedItem().toString();
			SachbearbeiterEK sachbearbeiter = SachbearbeiterEK.gib(name);
			
			JComboBox comboBoxFortbildungLoeschen = new JComboBox (sachbearbeiter.gibStringArrayfuertextArea(name));
			comboBoxFortbildungLoeschen.setBounds(222, 115, 148, 20);
			fortbildungL�schenPanel.add(comboBoxFortbildungLoeschen);
			
		}
	});
	fortbildungL�schenPanel.add(ComboBoxSachbearbeiter);

	}
	
	public JPanel adminSachbearbeiternFortbildungL�schen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		erg.setSize(600, 250);
		erg = adminSachbearbeiterFortbildungL�schen(true);
		
		JButton buttonAbbruchFortbildungL�schen = new JButton("Abbruch");
		buttonAbbruchFortbildungL�schen.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchFortbildungL�schen.addActionListener(beendenFortbildungL�schen);
		buttonAbbruchFortbildungL�schen.setBounds(23, 290, 89, 23);
		erg.add(buttonAbbruchFortbildungL�schen);

		JButton buttonOkFortbildungL�schen = new JButton("L�schen");
		buttonOkFortbildungL�schen.setMnemonic(KeyEvent.VK_L);
		buttonOkFortbildungL�schen.addActionListener(okFortbildungL�schen);
		buttonOkFortbildungL�schen.setBounds(149, 290, 89, 23);
		erg.add(buttonOkFortbildungL�schen);
		erg.repaint();
		erg.setVisible(true);
		fortbildungPanell�schen = erg;
		return erg;
	}
	
	public JPanel adminSachbearbeiterFortbildungL�schen(boolean editierbar) {
		return fortbildungL�schenPanel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void oeffnen() {
//		
//		System.out.println("Von welchem Sachbearbeiter wird die Fortbildung geloescht?");
//		System.out.println("Bitte geben Sie den Sachbearbeiter ein: ");
//		Scanner input = new Scanner(System.in);
//		String name = input.nextLine();
//		SachbearbeiterEK.druckAlleNamen();
//		System.out.println("Welche Fortbildung soll geloescht werden?");
//		System.out.println("Bitte geben Sie die Fortbildung ein:");
//		String fortbildung = input.nextLine();
//		Fortbildung.druckeAlleFortbildungen();
//		
//		
//		
//		
//		kontrolle.fortbildungLoeschen(name, fortbildung);
//	}
	
	
	
}
