import java.util.regex.Pattern;

public class SachbearbeiterEditierenK {


	public void benutzernamenaendern(String name1, String name2) {
		
		
		if(SachbearbeiterEK.gib(name1) != null) {
		
		
		if(benutzernamenVorgabenpruefen(name2) ) {
		
		if(SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {
			
			SachbearbeiterEK.gib(name1).setBenutzername(name2);
			SachbearbeiterEK.druckAlleNamen();
			SachbearbeiterEditierenAAS.oeffnen();
		}
		else {
			System.out.println("Benutzername nicht vorhanden!");
			return;
			
		}
		}
		else {
			System.out.println("Benutzername entspricht nicht den Vorgaben!!!!");
			System.out.println("Beispiel: Müller_Hans");
			return;
			
		}
	}
	else {
		System.out.println("Benutzername ist Falsch geschrieben/exsistiert nicht!!!!");
		return;
	}

	}
	
	public void paswortAendern(String name1, String passwort) {
		
		
		if(SachbearbeiterEK.gib(name1) != null) {
		
		if(SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {
			SachbearbeiterEK.gib(name1).setPasswort(passwort);
			SachbearbeiterEK.druckeAlleNamenPasswoerter();
			SachbearbeiterEditierenAAS.oeffnen();
		}
		else {
			System.out.println("Passwort nicht vorhanden!");
			SachbearbeiterEditierenAAS.oeffnen();
			
		}
		}
		else {
			System.out.println("Benutzername ist Falsch geschrieben/exsistiert nicht!!!!");
			return;
		}
		
		
		
		
			}
	public boolean benutzernamenVorgabenpruefen(String name) {
		
		String eingabenKontrolle = "^((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)[_]?((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)$";
	
		if(Pattern.matches(eingabenKontrolle, name)) {
			return true;
		}
		else
		{

			return false;
		}
}
	
	public String[] gibAlleSachbearbeiterNamen() {
		// TODO - implement SachbearbeiterEditierenK.gibAlleSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sachbearbeiter
	 */
	public void schriebeSachbearbeiter(int sachbearbeiter) {
		// TODO - implement SachbearbeiterEditierenK.schriebeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public SachbearbeiterEK erzeugeSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void loescheSach() {
		// TODO - implement SachbearbeiterEditierenK.loescheSach
		throw new UnsupportedOperationException();
	}

}