package Main;

import ArbreBinaire.Morse.CodageMorseIteratif;
import Fonctions.ConvertTo;
import Fonctions.ModeSelector;
import Fonctions.Timer;
import java.io.File;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// --------------------------------------//
		//		CHOIX DU MODE POUR L'ALGORITHME
		//	   DE L'ARBRE BINAIRE - ICI RECURSIF
		// --------------------------------------//
		ModeSelector.Mode.setMode(ModeSelector.Mode.RECURSIF);

		// --------------------------------------//
		//	EXEMPLE DE CHARGEMENT DE FICHIER TEXTE
		//				CLAIR -> MORSE
		// --------------------------------------//
		// Chargement du fichier à coder TexteClair.txt
		File fichierEntreeClair = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/Extrait_Les_Miserables.txt");
		// Définition du fichier accueillant le texte en morse
		File fichierSortieMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/TexteMorse.txt");

		Timer.start();

		ConvertTo.fileToMorse(fichierEntreeClair, fichierSortieMorse);
		
		System.out.println("Mode récursif : clair -> morse");
		Timer.stopAndDisplay();

		// --------------------------------------//
		//	EXEMPLE DE CHARGEMENT DE FICHIER TEXTE
		//				MORSE -> CLAIR
		// --------------------------------------//
		// Chargement du fichier à decoder TexteMorse.txt
		File fichierEntreeMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/TexteMorse.txt");
		// Définition du fichier accueillant le texte décodé
		File fichierSortieClair = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/TexteClair.txt");

		Timer.start();

		ConvertTo.fileToText(fichierEntreeMorse, fichierSortieClair);
		
		System.out.println("Mode récursif : morse -> clair");
		Timer.stopAndDisplay();

		// --------------------------------------//
		//		CHOIX DU MODE POUR L'ALGORITHME
		//	   DE L'ARBRE BINAIRE - ICI ITERATIF
		// --------------------------------------//
		ModeSelector.Mode.setMode(ModeSelector.Mode.ITERATIF);

		// --------------------------------------//
		//	EXEMPLE DE CHARGEMENT DE FICHIER TEXTE
		//				CLAIR -> MORSE
		// --------------------------------------//
		Timer.start();

		ConvertTo.fileToMorse(fichierEntreeClair, fichierSortieMorse);
		
		System.out.println("Mode itératif : clair -> morse");
		Timer.stopAndDisplay();

		// --------------------------------------//
		//	EXEMPLE DE CHARGEMENT DE FICHIER TEXTE
		//				MORSE -> CLAIR
		// --------------------------------------//
		Timer.start();

		ConvertTo.fileToText(fichierEntreeMorse, fichierSortieClair);
		
		System.out.println("Mode itératif : morse -> clair");
		Timer.stopAndDisplay();

		// --------------------------------------//
		//		  EXEMPLE DE CONVERSION DE
		//			CHAINE DE CARACTERE
		// --------------------------------------//
		System.out.println(ConvertTo.textToMorse("Voulez-vous portez à ce vieux juge blond qui fume un whisky ? Je vous remercie."));
		System.out.println(ConvertTo.morseToText("...- --- ..- .-.. . --.. -....- ...- --- ..- ...  .--. --- .-. "
				+ "- . --..  .--.-  -.-. .  ...- .. . ..- -..-  .--- ..- --. .  -... .-.. --- -. -..  --.- ..- "
				+ "..  ..-. ..- -- .  ..- -.  .-- .... .. ... -.- -.--  ..--..  .--- .  ...- --- ..- ...  .-. . "
				+ "-- . .-. -.-. .. . .-.-.-"));
		
		

	}
}
