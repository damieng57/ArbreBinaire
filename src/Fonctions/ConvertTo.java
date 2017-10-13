/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonctions;

import ArbreBinaire.Morse.CodageMorse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Damien
 */
public class ConvertTo {

	public static void convertToMorse(File fichierEntreeClair, File fichierSortieMorse) {
		// --------------------------------------//
		//			VERSION CLAIR->MORSE
		// Lecture du fichier en clair et conversion
		// en vers le fichier Morse
		// --------------------------------------//
		// Variable temporaire
		String texteMorse = "";



		try (Scanner sc = new Scanner(fichierEntreeClair); BufferedWriter bw = new BufferedWriter(new FileWriter(fichierSortieMorse))) {

			while (sc.hasNext()) {
				String next = sc.nextLine();

				// Code le texte en morse...
				texteMorse = CodageMorse.codage(next);
				// et l'enregistre dans un fichier
				bw.write(texteMorse);

				// Affichage (pour contrôle)
//				System.out.println(CodageMorse.codage(next));
//				System.out.println(CodageMorse.decodage(texteMorse));
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	public static void convertToTexte(File fichierEntreeMorse, File fichierSortieClair) {
		// --------------------------------------//
		//			VERSION MORSE->CLAIR
		// Lecture du fichier en Morse et conversion
		// en vers le fichier TexteClair
		// --------------------------------------//
		// Variable temporaire
		String texteClair = "";

		try (Scanner sc = new Scanner(fichierEntreeMorse); BufferedWriter bw = new BufferedWriter(new FileWriter(fichierSortieClair))) {

			while (sc.hasNext()) {
				String next = sc.nextLine();

				// Code le texte en morse...
				texteClair = CodageMorse.decodage(next);
				// et l'enregistre dans un fichier
				bw.write(texteClair);

			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
