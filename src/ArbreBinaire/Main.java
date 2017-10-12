package ArbreBinaire;

import ArbreBinaire.Morse.CodageMorse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class Main {

	public static void main(String[] args) {

		// --------------------------------------//
		//				VERSION MORSE
		// --------------------------------------//
		
		// Variable temporaire
		CodageMorse nouveauCodage = new CodageMorse();
		String texteMorse = "";

		// Chargement du fichier à coder TexteClair.txt
		File fichierEntreeMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/ArbreBinaire/Morse/TexteClair.txt");
		// Définition du fichier accueillant le texte en morse
		File fichierSortieMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/ArbreBinaire/Morse/TexteMorse.txt");

		try (Scanner sc = new Scanner(fichierEntreeMorse); BufferedWriter bw = new BufferedWriter(new FileWriter(fichierSortieMorse))) {

			while (sc.hasNext()) {
				String next = sc.nextLine();

				// Code le texte en morse...
				texteMorse = nouveauCodage.codage(next);
				// et l'enregistre dans un fichier
				bw.write(texteMorse);

				// Affichage
				System.out.println(nouveauCodage.codage(next));
				System.out.println(nouveauCodage.decodage(texteMorse));
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		// Test
		nouveauCodage.TestCodage();

	}
}
	
