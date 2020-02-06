import java.util.Scanner;

public class FortbildungLoeschenAAS {

	
	private static FortbildungLoeschenK kontrolle = new FortbildungLoeschenK();
	
	
	public static void oeffnen() {
		
		System.out.println("Von welchem Sachbearbeiter wird die Fortbildung geloescht?");
		System.out.println("Bitte geben Sie den Sachbearbeiter ein: ");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		SachbearbeiterEK.druckAlleNamen();
		System.out.println("Welche Fortbildung soll geloescht werden?");
		System.out.println("Bitte geben Sie die Fortbildung ein:");
		String fortbildung = input.nextLine();
		Fortbildung.druckeAlleFortbildungen();
		
		
		
		
		kontrolle.fortbildungLoeschen(name, fortbildung);
	}
	
	
	
}
