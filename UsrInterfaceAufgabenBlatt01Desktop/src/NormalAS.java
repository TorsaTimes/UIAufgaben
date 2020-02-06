import java.util.Scanner;

public class NormalAS {

	
	
	public static void menue() {
		
		System.out.println("Willkommen im Sachbearbeiter-Normal-Menue");
		System.out.println("Sie können nun waehlen: ");
		System.out.println("Fuer Sachbearbeiter zu editieren waehlen Sie die -> 1");
		System.out.println("Fuer Fortbildung auswaehlen -> 2");
		System.out.println("Fuer Login waehlen Sie die -> 3");
		Scanner input = new Scanner(System.in);
		int eingabe = input.nextInt();
		if(eingabe == 3) {
			
			LoginAS.oeffnen();
			
		}
		else if(eingabe == 2) {
			
			FortbildungAS.menue();
			
		
			
		}
		else if(eingabe == 1) {
			
			SachbearbeiterSachbearbeiterEditierenAAS.oeffnen();
			
			
		}
	}
	
	
	
	
	public void sachbearbeiterNormalEditieren() {
		// TODO - implement NormalAS.sachbearbeiterNormalEditieren
		throw new UnsupportedOperationException();
	}

	public void Login() {
		// TODO - implement NormalAS.Login
		throw new UnsupportedOperationException();
	}

}