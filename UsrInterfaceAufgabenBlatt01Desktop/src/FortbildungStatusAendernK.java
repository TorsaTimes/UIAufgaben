
public class FortbildungStatusAendernK {

	
	public void sachbearbeiterFortbildungStatusAendern(String benutzername, String fortbildung, String status) {
		
		if(SachbearbeiterEK.gib(benutzername) != null) {
			if(Fortbildung.gibFortbildung(fortbildung) != null) {
				if(status.equals("belegt") || status.equals("bestanden")) {
			
		if(Fortbildung.belegungPruefen1(benutzername, fortbildung) != false ) {
			System.out.println("Der Sachbearbeiter " + SachbearbeiterEK.gib(benutzername).getBenutzername() + " Belegt folgende Fortbildungen");
			//Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
			
			SachbearbeiterEK.gib(benutzername).setMapStatus(benutzername, fortbildung, status);
			
			Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
			//System.out.println(SachbearbeiterEK.gib(benutzername).fortbildungen.get( Fortbildung.gibFortbildung(fortbildung)));
			
			
			
			
			
			
		
			
		}
		else {
			
			System.out.println("Sachbearbeiter belegt diese Fortbildung nicht");
			System.out.println("!!!!!Achtung!!!!! Bitte ordnen Sie den Sachbearbeiter erst dieser Fortbildung zu bevor Sie den Status aendern");
			FortbildungAS.menue();
		
			}
		}
				else {
					System.out.println("Der status ist Falsch geschrieben/exsistiert nicht!!!!!!");
					return;
				}
		}
			else {
				System.out.println("Die Fortbildungsname ist Falsch geschrieben/exsistiert nicht!!!!!!");
				return;
			}
		}
		else {
			System.out.println("Der Benutzername ist Falsch geschrieben/exsistiert nicht!!!!!!");
			return;
		}
	}
		
}
