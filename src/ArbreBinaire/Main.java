package ArbreBinaire;

import ArbreBinaire.Morse.CodageMorse;
import ArbreBinaire.Ascii.CodageAscii;
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
		String texteMorse = "";

		// Chargement du fichier à coder TexteClair.txt
		File fichierEntreeMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/ArbreBinaire/Morse/TexteClair.txt");
		// Définition du fichier accueillant le texte en morse
		File fichierSortieMorse = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/ArbreBinaire/Morse/TexteMorse.txt");

		try (Scanner sc = new Scanner(fichierEntreeMorse); BufferedWriter bw = new BufferedWriter(new FileWriter(fichierSortieMorse))) {

			while (sc.hasNext()) {
				String next = sc.nextLine();

				// Code le texte en morse...
				texteMorse = CodageMorse.codage(next);
				// et l'enregistre dans un fichier
				bw.write(texteMorse);

				// Affichage
				System.out.println(CodageMorse.codage(next));
				System.out.println(CodageMorse.decodage(texteMorse));
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		// Test
		CodageMorse.TestCodage();

		// --------------------------------------//
		//			VERSION ASCII (fun)
		// --------------------------------------//
		System.out.println("");


		// Variable temporaire
		String texteAscii = "";

		// Chargement du fichier à coder TexteClair.txt
		File fichierEntreeAscii = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/ArbreBinaire/Ascii/TexteClair.txt");
		// Définition du fichier accueillant le texte en Ascii
		File fichierSortieAscii = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/ArbreBinaire/Ascii/TexteAscii.txt");

		try (Scanner sc = new Scanner(fichierEntreeAscii); BufferedWriter bw = new BufferedWriter(new FileWriter(fichierSortieAscii))) {

			while (sc.hasNext()) {
				String next = sc.nextLine();

				// Code le texte en Ascii...
				texteAscii = CodageAscii.codage(next);
				// et l'enregistre dans un fichier
				bw.write(texteAscii);

				// Affichage
				System.out.println(CodageAscii.codage(next));
				System.out.println(CodageAscii.decodage(texteAscii));
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		
		// Test
		CodageAscii.TestCodage();

	}
}
