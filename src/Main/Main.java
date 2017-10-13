package Main;

import Fonctions.ConvertTo;
import java.io.File;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class Main {

	public static void main(String[] args) {

		// Chargement du fichier à coder TexteClair.txt
		File fichierEntreeClair = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/TexteOrigine.txt");
		// Définition du fichier accueillant le texte en morse
		File fichierSortieMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/TexteMorse.txt");
		
		ConvertTo.convertToMorse(fichierEntreeClair, fichierSortieMorse);
		
		
		
		// Chargement du fichier à coder TexteClair.txt
		File fichierEntreeMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/TexteMorse.txt");
		// Définition du fichier accueillant le texte en morse
		File fichierSortieClair = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/TexteClair.txt");
		
		ConvertTo.convertToTexte(fichierEntreeMorse, fichierSortieClair);

		
	}
}
