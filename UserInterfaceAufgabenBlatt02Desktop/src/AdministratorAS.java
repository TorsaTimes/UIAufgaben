import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class AdministratorAS {
	
		//------------------------Attribute------------------------------------------------------	
		public static JMenuBar adminMenuBar = new JMenuBar();
		private static JToolBar adminToolBar = new JToolBar();
		public static AdministratorAS instance;
		public static JFrame frame = new JFrame();
		public SachbearbeiterAdminErzeugenAAS adminErzeugenAAS = new SachbearbeiterAdminErzeugenAAS();
		//-----------------------------------Button----------------------------------------------------
		JButton btnEditieren = new JButton("Editieren");
		JButton btnErstellen = new JButton("Erstellen");
		JButton btnLschen = new JButton("Loeschen");
		JButton btnFortbildungZuordnen = new JButton("Fortbildung zuordnen");
		JButton btnFortbildungszuordnungLschen = new JButton("Fortbildungszuordnung loeschen");
		JButton  btnZurueck = new JButton("Zurueck");
		
		//-----------------------------Listener Objekte-------------------------------------------------------------------------
		ErstellenListener erstellenButtonListener = new ErstellenListener();
		EditierenListener editierenButtonListener = new EditierenListener();
		LöschenListener löschenButtonListener = new LöschenListener();
		FortbildungLöschenListener fortbildungLöschenButtonListener = new FortbildungLöschenListener();
		FortbildungZordnenListener fortbildungZuordnenButtonListener = new FortbildungZordnenListener();
		ZurückListener zurückButtonListener = new ZurückListener();
		//----------------------------------------------------------------------------
		
		//-------------------Eine Instanc der Klasse AdministratorAS Erzeugen---------
		public static AdministratorAS getInstance() {
			if(instance == null) {
				instance = new AdministratorAS();
			}
			return instance;
		}
		//----------------------------------------------------------------------------
	
		//-------------------------------------------------AdminAS-Frame erzeugen----------------------------------------------------------------
		public AdministratorAS() {
		
		//-------------JMenu-Sachbearbeiter und Zurueck-------------------------------------------------------------------
		JMenu menuSachbearbeiterAdministratorAS = new JMenu("Sachbearbeiter");
		adminMenuBar.add(menuSachbearbeiterAdministratorAS);
		
		JMenu menuZurckAdministratorAS = new JMenu("Zurueck");
		adminMenuBar.add(menuZurckAdministratorAS);
		//-------------------------------------------------------------------------------------------------------------------
		
		//-----------------------------------JButtons--------------------------------------------------------------------------
		
		//--------------------------------------------Erstellen--------------------------------------------------------
		btnErstellen.addActionListener(erstellenButtonListener);
		btnErstellen.setMnemonic(KeyEvent.VK_E);
		adminToolBar.add(btnErstellen);
		//--------------------------------------------Editieren--------------------------------------------------------
		btnEditieren.addActionListener(editierenButtonListener);
		btnEditieren.setMnemonic(KeyEvent.VK_D);
		adminToolBar.add(btnEditieren);
		//--------------------------------------------Löschen--------------------------------------------------------
		btnLschen.addActionListener(löschenButtonListener);
		btnLschen.setMnemonic(KeyEvent.VK_L);
		adminToolBar.add(btnLschen);
		//--------------------------------------------Zuordnen--------------------------------------------------------
		btnFortbildungZuordnen.addActionListener(fortbildungZuordnenButtonListener);
		btnFortbildungZuordnen.setMnemonic(KeyEvent.VK_U);
		adminToolBar.add(btnFortbildungZuordnen);
		//----------------------------------------------Fortbildung Löschen-----------------------------------------------------
		btnFortbildungszuordnungLschen.addActionListener(fortbildungLöschenButtonListener);
		btnFortbildungszuordnungLschen.setMnemonic(KeyEvent.VK_O);
		adminToolBar.add(btnFortbildungszuordnungLschen);
		//-----------------------------------------------------------------------------------------------------------------
		//------------------------------------------Zurück Button-----------------------------------------------------------------------------------------------
		btnZurueck.addActionListener(zurückButtonListener);
		btnZurueck.setMnemonic(KeyEvent.VK_Z);
		adminToolBar.add(btnZurueck);
		//--------------------------------------------------------------------------------------------------------------------------
		
		//----------------------MenuItems-------------------------------------------------------------------------------------------
		JMenuItem menuItemErstellen = new JMenuItem("Erstellen",KeyEvent.VK_E);
		menuItemErstellen.setMnemonic(KeyEvent.VK_E);
		KeyStroke erstellenKeyStroke = KeyStroke.getKeyStroke("alt shift E");
		menuItemErstellen.setAccelerator(erstellenKeyStroke);
		menuItemErstellen.addActionListener(erstellenButtonListener);
		
		JMenuItem menuItemEditieren = new JMenuItem("Editieren", KeyEvent.VK_D);
		menuItemEditieren.setMnemonic(KeyEvent.VK_D);
		KeyStroke editierenKeyStroke = KeyStroke.getKeyStroke("alt shift D");
		menuItemEditieren.setAccelerator(editierenKeyStroke);		
		menuItemEditieren.addActionListener(editierenButtonListener);
		
		JMenuItem menuItemLoeschen = new JMenuItem("Loeschen", KeyEvent.VK_L);
		menuItemLoeschen.setMnemonic(KeyEvent.VK_L);
		KeyStroke löschenKeyStroke = KeyStroke.getKeyStroke("alt shift L");
		menuItemLoeschen.setAccelerator(löschenKeyStroke);
		menuItemLoeschen.addActionListener(löschenButtonListener);
		
		JMenuItem menuItemFortbildungzuordnen = new JMenuItem("Fortbildung zuordnen", KeyEvent.VK_U);
		menuItemFortbildungzuordnen.setMnemonic(KeyEvent.VK_U);
		KeyStroke fortbildungZordnenKeyStroke = KeyStroke.getKeyStroke("alt shift U");
		menuItemFortbildungzuordnen.setAccelerator(fortbildungZordnenKeyStroke);
		menuItemFortbildungzuordnen.addActionListener(fortbildungZuordnenButtonListener);
		
		JMenuItem menuItemfortbildungszuordnungloeschen = new JMenuItem("fortbildungszuordnung loeschen", KeyEvent.VK_O);
		menuItemfortbildungszuordnungloeschen.setMnemonic(KeyEvent.VK_O);
		KeyStroke fortbildungLöschenKeyStroke = KeyStroke.getKeyStroke("alt shift O");
		menuItemfortbildungszuordnungloeschen.setAccelerator(fortbildungLöschenKeyStroke);
		menuItemfortbildungszuordnungloeschen.addActionListener(fortbildungLöschenButtonListener);
		
		JMenuItem menuItemZurück = new JMenuItem("Zurück", KeyEvent.VK_Z);
		menuItemZurück.setMnemonic(KeyEvent.VK_Z);
		KeyStroke zurückKeyStroke = KeyStroke.getKeyStroke("alt shift Z");
		menuItemZurück.setAccelerator(zurückKeyStroke);
		menuItemZurück.addActionListener(zurückButtonListener);
		
		menuSachbearbeiterAdministratorAS.add(menuItemErstellen);
		menuSachbearbeiterAdministratorAS.add(menuItemEditieren);
		menuSachbearbeiterAdministratorAS.add(menuItemLoeschen);
		menuSachbearbeiterAdministratorAS.add(menuItemFortbildungzuordnen);
		menuSachbearbeiterAdministratorAS.add(menuItemfortbildungszuordnungloeschen);
		
		menuZurckAdministratorAS.add(menuItemZurück);
		//--------------------------------------------------------------------------------------------------------------------------
	}
	//-------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------Die MenuBar und Toolbar in den Frame einsetzten------------------------------------------------
	public void start(JFrame hs) {

		frame = hs;
		frame.getContentPane().removeAll();//.removeAll()
		//frame.getJMenuBar().removeAll();
		frame.validate();
		frame.repaint();
		frame.setTitle("Sachbearbeiter Verwaltung - Administrator");
		adminMenuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(adminMenuBar);
		frame.getContentPane().add(adminToolBar, BorderLayout.NORTH);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setMinimumSize(new Dimension(700,700));
		frame.validate();
		frame.repaint();
//		frame.getContentPane().setVisible(true);
//		frame.setVisible(true);
		
	}
	
	//---------------------------------ToolBar entgrauen Methoden-------------------------------------------------------------------------------------------
	public void buttonEnabelFalse() {
		btnErstellen.setEnabled(false);
		btnEditieren.setEnabled(false);
		btnLschen.setEnabled(false);
		btnFortbildungszuordnungLschen.setEnabled(false);
		btnFortbildungZuordnen.setEnabled(false);
		btnZurueck.setEnabled(false);
	}
	public void entgrauen() {
		btnErstellen.setEnabled(true);
		btnEditieren.setEnabled(true);
		btnLschen.setEnabled(true);
		btnFortbildungszuordnungLschen.setEnabled(true);
		btnFortbildungZuordnen.setEnabled(true);
		btnZurueck.setEnabled(true);
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public JMenuBar getMenubar() {
		return adminMenuBar;
	}
	//---------------------------------------------------------------------------------------------
	//-------------------------Getter fuer Button----------------------------------------------------
	public JButton getbtnErstellen() {
		return btnErstellen;
	}
	public JButton getbtnEditieren() {
		return btnEditieren;
	}
	public JButton getbtnLoeschen() {
		return btnLschen;
	}
	public JButton getbtnFortbildungZuordnen() {
		return btnFortbildungZuordnen;
	}
	public JButton getbtnFortbildugZuordnenLoeschen() {
		return btnFortbildungszuordnungLschen;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------ActionListener der Button von der ToolBar AdminAS------------------------------------------------------------------------------
	class EditierenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterAdminEditierenAAS adminEditierenAAS = new SachbearbeiterAdminEditierenAAS();
			JPanel panel = adminEditierenAAS.adminSachbearbeiternEditieren();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Editieren wurde ausgewählt");
			//#########################################################################################
		}
	}
	class ErstellenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterAdminErzeugenAAS adminErzeugenAAS = new SachbearbeiterAdminErzeugenAAS();
			JPanel panel = adminErzeugenAAS.adminSachbearbeiternErzeugen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Erstellen wurde ausgewählt");
			//#########################################################################################
		}
	}
	class LöschenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterAdminLoeschenAAS adminLöschenAAS = new SachbearbeiterAdminLoeschenAAS();
			JPanel panel = adminLöschenAAS.adminSachbearbeiternLöschen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Löschen wurde ausgewählt");
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
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgewählt");
			//#########################################################################################
		}
	}
	class FortbildungLöschenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			FortbildungLoeschenAAS fortbildunglöschen = new FortbildungLoeschenAAS();
			JPanel panel = fortbildunglöschen.adminSachbearbeiternFortbildungLöschen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgewählt");
			//#########################################################################################
		}
	}
	class ZurückListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
//			frame.getJMenuBar().removeAll();
			frame.validate();
			frame.repaint();
			LehrveranstaltungsverwaltungHS anmelden = new LehrveranstaltungsverwaltungHS();
			anmelden.oeffnen();
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter Verwaltung-Administrator - Zurück wurde ausgewählt");
			//#########################################################################################
		}	
	}


	public void sachbearbeiterAdminEditieren() {
		// TODO - implement AdminAS.sachbearbeiterAdminEditieren
		throw new UnsupportedOperationException();
	}

	public void Login() {
		// TODO - implement AdminAS.Login
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminErzeugen() {
		// TODO - implement AdminAS.sachbearbeiterAdminErzeugen
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminLoeschen() {
		// TODO - implement AdminAS.sachbearbeiterAdminLoeschen
		throw new UnsupportedOperationException();
	}

}