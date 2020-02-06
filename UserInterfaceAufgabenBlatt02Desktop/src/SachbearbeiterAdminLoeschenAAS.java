import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class SachbearbeiterAdminLoeschenAAS{

	
	//------------------------------------Attribute der Klasse---------------------------------------
		private OkLauscherLöschen okErzeugen = new OkLauscherLöschen();
		private BeendenLauscherLöschen beendenErzeugen = new BeendenLauscherLöschen();
		
		private JButton buttonAbbruchLöschen = new JButton();
		private JButton buttonOkLöschen = new JButton();
		
		private JPanel adminLöschenPanel = new JPanel();//panel was zurückgegeben wird
		private JPanel adminPanel;//Panel was im lauscher genutzt wird

		private JRadioButton radioButtonSachbearbeiter;
		private JRadioButton radioButtonAdministrator;
		//--------------------------------------------------------------------------------------------
		private static SachbearbeiterAdminLoeschenAAS instance;
		SachbearbeiterAdminLoeschenK kontrolle = new SachbearbeiterAdminLoeschenK();
		SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();
		//---------------------------OK-Lauscher-----------------------------------------------------------------
	
	private class OkLauscherLöschen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
			String benutzerMessagePanel = getComboBox().getSelectedItem().toString();
			String[] optionen = { "Ja", "Nein" }; 
            int n = JOptionPane.showOptionDialog( null, "Wollen Sie den Sachbearbeiter " + benutzerMessagePanel + " wirklich Löschen?", "Ja oder Nein", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionen,optionen[0] );       

                if ( n == JOptionPane.YES_OPTION ) {  
                  
                	String benutzer = getComboBox().getSelectedItem().toString();
        			kontrolle.loeschen(benutzer);
        			AdministratorAS.getInstance().entgrauen();
        			adminPanel.setVisible(false);
                	
                	
                }
                else if ( n == JOptionPane.NO_OPTION ) {
                        
                	
                    }
			
			//############################Kontroll Ausgabe###################################################################
			System.out.println("Der Benutzer: " + benutzerMessagePanel + " wurde geloescht");
			//###############################################################################################################
		}
	}
	//----------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Editieren Panel------------------
	private class BeendenLauscherLöschen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdministratorAS.getInstance().entgrauen();
			adminPanel.setVisible(false);
		}
		}
	//-------------------------------------------------------------------------------------------------
	//--------------------------------Instanc der Klasse-------------------------------------------------
	public SachbearbeiterAdminLoeschenAAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAdminLoeschenAAS();
		}
		return instance;
	}
	
	public JPanel adminSachbearbeiternLöschen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = sachbearbeiterLöschen(true);
		JButton buttonAbbruchLöschen = new JButton("Abbruch");
		buttonAbbruchLöschen.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchLöschen.addActionListener(beendenErzeugen);
		buttonAbbruchLöschen.setBounds(10, 260, 89, 23);
		erg.add(buttonAbbruchLöschen);
		
		JButton buttonOkLöschen = new JButton("Löschen");
		buttonOkLöschen.setMnemonic(KeyEvent.VK_L);
		buttonOkLöschen.addActionListener(okErzeugen);
		buttonOkLöschen.setBounds(137, 260, 89, 23);
		erg.add(buttonOkLöschen);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}
	public JPanel sachbearbeiterLöschen(boolean editierbar) {
		return adminLöschenPanel;
	}
	
	
	public SachbearbeiterAdminLoeschenAAS() {
		adminLöschenPanel.setLayout(null);
		adminLöschenPanel.setSize(600, 250);
		
		JLabel lblSachbearbeiterLschen = new JLabel("Sachbearbeiter Loeschen");
		lblSachbearbeiterLschen.setBounds(26, 40, 165, 14);
		adminLöschenPanel.add(lblSachbearbeiterLschen);
		
		JLabel lblSachbearbeiterAuswhlen = new JLabel("Sachbearbeiter auswaehlen");
		lblSachbearbeiterAuswhlen.setBounds(26, 127, 182, 14);
		adminLöschenPanel.add(lblSachbearbeiterAuswhlen);
		
		JComboBox comboBox = combo.oeffnen();
		comboBox.setBounds(218, 124, 159, 20);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBox.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
			}
		});
		adminLöschenPanel.add(comboBox);

	}
	
	public JComboBox getComboBox() {
		return combo.oeffnen();
	}
	

}
