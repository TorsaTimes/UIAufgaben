import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SachbearbeiterSachbearbeiterEditierenAAS {

	private OkLauscherEditieren okeditieren = new OkLauscherEditieren();
	private BeendenLauscherEditieren beendeneditieren = new BeendenLauscherEditieren();
	private static SachbearbeiterSachbearbeiterEditierenAAS instance;
	private JButton buttonAbbruchEditieren = new JButton();
	private JButton buttonOkEditieren = new JButton();
	private JPanel sachbearbeiterPanel;
	
	SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();
	SachbearbeiterEditierenAAS sachbearbeiterEdit;
	
	

	// ------------------------------------Instanz der KLasse
	// erzeugen-------------------------------------------------------------
	public SachbearbeiterSachbearbeiterEditierenAAS getInstance() {
		if (instance == null) {
			instance = new SachbearbeiterSachbearbeiterEditierenAAS();
		}
		return instance;
	}

	// -----------------------------------------------------------------------------------------------------
	// -------------------------Ok-lauscher---------------------------------------------------------
	private class OkLauscherEditieren implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String benutzer = sachbearbeiterEdit.getComboBox().getSelectedItem().toString();
			String geandertName = sachbearbeiterEdit.getTextFieldBenutzer();
			String geandertPasswort = sachbearbeiterEdit.getPasswortFieldpasswort();
			String berechtigung = SachbearbeiterEK.gib(benutzer).gibBerechetigung();
					
				if (kontrolle.editieren(geandertName, geandertPasswort, berechtigung, benutzer) == 2) {

					JOptionPane.showMessageDialog(null, "Benutzer :" + benutzer + " wurde editiert",
							"Sachebarbeiter Editieren", JOptionPane.INFORMATION_MESSAGE);

					AdministratorAS.getInstance().entgrauen();
					SachbearbeiterAS.getInstance().entgrauen();
					sachbearbeiterPanel.setVisible(false);
				} else {
					// Passiert nicht Benutzer bleibt im Menü Sachbearbeiter Editieren
				}


			// #########################Kontroll Ausgaben in der
			// Konsole##########################################
			System.out.println("Ausgewaehlter Benutzer " + benutzer);
			System.out.println("Geanderter Name des Benutzers " + geandertName);
			System.out.println("Geandertes Passwort des Benutzers " + geandertPasswort);
			// System.out.println(SachbearbeiterEK.gib(benutzer).gibBerechetigung());
			SachbearbeiterEK.druckAlleNamen();
			// ###########################################################################################
		}
	}

	// ----------ActionListener Klasse fuer Beenden button im Editieren
	// Panel------------------
	private class BeendenLauscherEditieren implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			SachbearbeiterAS.getInstance().entgrauen();
			sachbearbeiterPanel.setVisible(false);
		}
	}
	// -------------------------------------------------------------------------------------------------
	public JPanel sachbearbeiterSachbearbeiternEditieren() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		sachbearbeiterEdit = new SachbearbeiterEditierenAAS();
		erg = sachbearbeiterEdit.sachbearbeiterEditieren(true);
		JButton buttonAbbruchEditieren = new JButton("Abbruch");
		buttonAbbruchEditieren.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchEditieren.addActionListener(beendeneditieren);
		buttonAbbruchEditieren.setBounds(10, 410, 89, 23);
		erg.add(buttonAbbruchEditieren);
		
		
		JButton buttonOkEditieren = new JButton("Ok");
		buttonOkEditieren.setMnemonic(KeyEvent.VK_O);
		buttonOkEditieren.addActionListener(okeditieren);
		buttonOkEditieren.setBounds(137, 410, 89, 23);
		erg.add(buttonOkEditieren);
		erg.remove(sachbearbeiterEdit.getRadioButtonAdministrator());
		erg.remove(sachbearbeiterEdit.getRadioButtonSachbearbeier());
		erg.validate();
		erg.repaint();
		sachbearbeiterPanel = erg;
		return erg;
	}	
}
