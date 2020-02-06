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
		private OkLauscherL�schen okErzeugen = new OkLauscherL�schen();
		private BeendenLauscherL�schen beendenErzeugen = new BeendenLauscherL�schen();
		
		private JButton buttonAbbruchL�schen = new JButton();
		private JButton buttonOkL�schen = new JButton();
		
		private JPanel adminL�schenPanel = new JPanel();//panel was zur�ckgegeben wird
		private JPanel adminPanel;//Panel was im lauscher genutzt wird

		private JRadioButton radioButtonSachbearbeiter;
		private JRadioButton radioButtonAdministrator;
		//--------------------------------------------------------------------------------------------
		private static SachbearbeiterAdminLoeschenAAS instance;
		SachbearbeiterAdminLoeschenK kontrolle = new SachbearbeiterAdminLoeschenK();
		SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();
		//---------------------------OK-Lauscher-----------------------------------------------------------------
	
	private class OkLauscherL�schen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
			String benutzerMessagePanel = getComboBox().getSelectedItem().toString();
			String[] optionen = { "Ja", "Nein" }; 
            int n = JOptionPane.showOptionDialog( null, "Wollen Sie den Sachbearbeiter " + benutzerMessagePanel + " wirklich L�schen?", "Ja oder Nein", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionen,optionen[0] );       

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
	private class BeendenLauscherL�schen implements ActionListener{
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
	
	public JPanel adminSachbearbeiternL�schen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = sachbearbeiterL�schen(true);
		JButton buttonAbbruchL�schen = new JButton("Abbruch");
		buttonAbbruchL�schen.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchL�schen.addActionListener(beendenErzeugen);
		buttonAbbruchL�schen.setBounds(10, 260, 89, 23);
		erg.add(buttonAbbruchL�schen);
		
		JButton buttonOkL�schen = new JButton("L�schen");
		buttonOkL�schen.setMnemonic(KeyEvent.VK_L);
		buttonOkL�schen.addActionListener(okErzeugen);
		buttonOkL�schen.setBounds(137, 260, 89, 23);
		erg.add(buttonOkL�schen);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}
	public JPanel sachbearbeiterL�schen(boolean editierbar) {
		return adminL�schenPanel;
	}
	
	
	public SachbearbeiterAdminLoeschenAAS() {
		adminL�schenPanel.setLayout(null);
		adminL�schenPanel.setSize(600, 250);
		
		JLabel lblSachbearbeiterLschen = new JLabel("Sachbearbeiter Loeschen");
		lblSachbearbeiterLschen.setBounds(26, 40, 165, 14);
		adminL�schenPanel.add(lblSachbearbeiterLschen);
		
		JLabel lblSachbearbeiterAuswhlen = new JLabel("Sachbearbeiter auswaehlen");
		lblSachbearbeiterAuswhlen.setBounds(26, 127, 182, 14);
		adminL�schenPanel.add(lblSachbearbeiterAuswhlen);
		
		JComboBox comboBox = combo.oeffnen();
		comboBox.setBounds(218, 124, 159, 20);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBox.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
			}
		});
		adminL�schenPanel.add(comboBox);

	}
	
	public JComboBox getComboBox() {
		return combo.oeffnen();
	}
	

}
