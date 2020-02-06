import java.util.Scanner;

public class FortbildungStatusAendernAAS {

	
	private static FortbildungStatusAendernK kontrolle = new FortbildungStatusAendernK();
	
	
	public static void oeffnen() {
		
		System.out.println("Fuer welchen Benutzer möchten Sie den Fortbildungs Status aendern?");
		System.out.println("Bitte geben Sie den Benutzer ein: ");
		SachbearbeiterEK.druckAlleNamen();
		Scanner input = new Scanner(System.in);
		String benutzername = input.nextLine();
		System.out.println("Fuer welche Fortbildung soll die aenderung vorgenommen werden?");
		Fortbildung.druckeAlleFortbildungen();
		System.out.println("Bitte geben sie die Fortbildung ein: ");
		String fortbildung = input.nextLine();
		System.out.println("Welchen Status erhaelt " + "" + fortbildung + " fuer den Sachbearbeiter" + " " + benutzername );
		System.out.println("Bitte geben sie den Status: [belegt] oder [bestanden] ein");
		String status = input.nextLine();
		
		kontrolle.sachbearbeiterFortbildungStatusAendern(benutzername, fortbildung, status);
		FortbildungAS.menue();
		
	}
	
	
	
	
}
