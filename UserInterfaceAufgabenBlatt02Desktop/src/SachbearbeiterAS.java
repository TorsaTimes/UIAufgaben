import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class SachbearbeiterAS {

	
	//------------------------------------Attribute der Klasse SachbearbeiterAS-----------------------------------------------------------------------------------
	public static JMenuBar sachbearbeiterMenuBar = new JMenuBar();
	public static JToolBar sachbearbeiterToolBar = new JToolBar();
	public static JFrame frame = new JFrame();
	
	JButton btnEditieren = new JButton("Editieren");
	JButton btnFortbildungZuordnen = new JButton("Fortbildung zuordnen");
	JButton btnFortbildungszuordnungLschen = new JButton("Fortbildungszuordnung loeschen");
	JButton  btnZurueck = new JButton("Zurueck");
	
	EditierenListener editierenButtonListener = new EditierenListener();
	FortbildungL�schenListener fortbildungL�schenButtonListener = new FortbildungL�schenListener();
	FortbildungZordnenListener fortbildungZuordnenButtonListener = new FortbildungZordnenListener();
	Zur�ckListener zur�ckButtonListener = new Zur�ckListener();
	
	public static SachbearbeiterAS instance;
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	public static SachbearbeiterAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAS();
		}
		return instance;
	}
	
	public SachbearbeiterAS(){
		
		JMenu menuSachbearbeiterSachbearbeiterAS = new JMenu("Sachbearbeiter");
		sachbearbeiterMenuBar.add(menuSachbearbeiterSachbearbeiterAS);
		
		JMenu menuZurckSachbearbeiterAS = new JMenu("Zurueck");
		sachbearbeiterMenuBar.add(menuZurckSachbearbeiterAS);
		
		btnEditieren.addActionListener(editierenButtonListener);
		btnEditieren.setMnemonic(KeyEvent.VK_E);
		sachbearbeiterToolBar.add(btnEditieren);
		
		btnFortbildungZuordnen.addActionListener(fortbildungZuordnenButtonListener);
		btnFortbildungZuordnen.setMnemonic(KeyEvent.VK_U);
		sachbearbeiterToolBar.add(btnFortbildungZuordnen);
		
		btnFortbildungszuordnungLschen.addActionListener(fortbildungL�schenButtonListener);
		btnFortbildungszuordnungLschen.setMnemonic(KeyEvent.VK_O);
		sachbearbeiterToolBar.add(btnFortbildungszuordnungLschen);
		
		btnZurueck.addActionListener(zur�ckButtonListener);
		btnZurueck.setMnemonic(KeyEvent.VK_Z);
		sachbearbeiterToolBar.add(btnZurueck);
		
		JMenuItem menuItemEditieren = new JMenuItem("Editieren", KeyEvent.VK_D);
		menuItemEditieren.setMnemonic(KeyEvent.VK_D);
		KeyStroke editierenKeyStroke = KeyStroke.getKeyStroke("alt shift D");
		menuItemEditieren.setAccelerator(editierenKeyStroke);		
		menuItemEditieren.addActionListener(editierenButtonListener);
		
		JMenuItem menuItemFortbildungzuordnen = new JMenuItem("Fortbildung zuordnen", KeyEvent.VK_U);
		menuItemFortbildungzuordnen.setMnemonic(KeyEvent.VK_U);
		KeyStroke fortbildungZordnenKeyStroke = KeyStroke.getKeyStroke("alt shift U");
		menuItemFortbildungzuordnen.setAccelerator(fortbildungZordnenKeyStroke);
		menuItemFortbildungzuordnen.addActionListener(fortbildungZuordnenButtonListener);
		
		JMenuItem menuItemfortbildungszuordnungloeschen = new JMenuItem("fortbildungszuordnung loeschen", KeyEvent.VK_O);
		menuItemfortbildungszuordnungloeschen.setMnemonic(KeyEvent.VK_O);
		KeyStroke fortbildungL�schenKeyStroke = KeyStroke.getKeyStroke("alt shift O");
		menuItemfortbildungszuordnungloeschen.setAccelerator(fortbildungL�schenKeyStroke);
		menuItemfortbildungszuordnungloeschen.addActionListener(fortbildungL�schenButtonListener);
		
		JMenuItem menuItemZur�ck = new JMenuItem("Zur�ck", KeyEvent.VK_Z);
		menuItemZur�ck.setMnemonic(KeyEvent.VK_Z);
		KeyStroke zur�ckKeyStroke = KeyStroke.getKeyStroke("alt shift Z");
		
		menuItemZur�ck.setAccelerator(zur�ckKeyStroke);
		menuItemZur�ck.addActionListener(zur�ckButtonListener);
		menuSachbearbeiterSachbearbeiterAS.add(menuItemEditieren);
		menuSachbearbeiterSachbearbeiterAS.add(menuItemFortbildungzuordnen);
		menuSachbearbeiterSachbearbeiterAS.add(menuItemfortbildungszuordnungloeschen);
		
		menuZurckSachbearbeiterAS.add(menuItemZur�ck);
		
	}
	
	public void start(JFrame hs) {

		frame = hs;
		frame.getContentPane().removeAll();//.removeAll()
		frame.getJMenuBar().removeAll();
		frame.validate();
		frame.repaint();
		frame.setTitle("Sachbearbeiter Verwaltung - Sachbearbeiter");
		sachbearbeiterMenuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(sachbearbeiterMenuBar);
		frame.getContentPane().add(sachbearbeiterToolBar, BorderLayout.NORTH);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setMinimumSize(new Dimension(700,700));
		frame.validate();
		frame.repaint();
//		frame.getContentPane().setVisible(true);
//		frame.setVisible(true);
		
	}
	
	//---------------------------------ToolBar entgrauen Methoden-------------------------------------------------------------------------------------------
		public void buttonEnabelFalse() {
			btnEditieren.setEnabled(false);
			btnFortbildungszuordnungLschen.setEnabled(false);
			btnFortbildungZuordnen.setEnabled(false);
			btnZurueck.setEnabled(false);
		}
		public void entgrauen() {
			btnEditieren.setEnabled(true);	
			btnFortbildungszuordnungLschen.setEnabled(true);
			btnFortbildungZuordnen.setEnabled(true);
			btnZurueck.setEnabled(true);
		}
		//---------------------------------------------------------------------------------------------------------------------------------------------------------
	
	class EditierenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterSachbearbeiterEditierenAAS sachbearbeiterEditierenAAS = new SachbearbeiterSachbearbeiterEditierenAAS();
			JPanel panel = sachbearbeiterEditierenAAS.sachbearbeiterSachbearbeiternEditieren();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Editieren wurde ausgew�hlt");
			//#########################################################################################
		}
	}
	class FortbildungZordnenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			FortbildungZuordnenAAS fortbildungZuordnen = new FortbildungZuordnenAAS();
			JPanel panel = fortbildungZuordnen.adminSachbearbeiternFortbildungZuordnen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgew�hlt");
			//#########################################################################################
		}
	}
	class FortbildungL�schenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			FortbildungLoeschenAAS fortbildungl�schen = new FortbildungLoeschenAAS();
			JPanel panel = fortbildungl�schen.adminSachbearbeiternFortbildungL�schen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgew�hlt");
			//#########################################################################################
		}
	}
	class Zur�ckListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
//			frame.getJMenuBar().removeAll();
			frame.validate();
			frame.repaint();
			LehrveranstaltungsverwaltungHS anmelden = new LehrveranstaltungsverwaltungHS();
			anmelden.oeffnen();
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter Verwaltung-Administrator - Zur�ck wurde ausgew�hlt");
			//#########################################################################################
		}	
	}
	
}
