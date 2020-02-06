import java.util.Scanner;

public class FortbildungZuordnenAAS {


	static FortbildungZuordnenK kontrolle = new FortbildungZuordnenK();
	
	public static void oeffnen() {
		
		System.out.println("Welchen Sachbearbeiter wollen Sie zuordnen?");
		System.out.println("Bitte geben Sie den Namen des Sachbearbeiters ein: ");
		SachbearbeiterEK.druckAlleNamen();
		Scanner input99 = new Scanner(System.in);
		String benutzername = input99.nextLine();
		System.out.println("Welche Fortbildung soll der Sachbearbeiter zugewiesen bekommen?");
		Fortbildung.druckeAlleFortbildungen();
		Scanner input199 = new Scanner(System.in);
		String fortbildungname = input199.nextLine();

		kontrolle.sachbearbeiterFortbildungBuchen(benutzername, fortbildungname);
		FortbildungAS.menue();
	
	
	}
	
	
	
}
