package Fonctions;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
import ArbreBinaire.Morse.CodageMorseIteratif;
import ArbreBinaire.Morse.CodageMorseRecursif;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConvertTo {

	// --------------------------------------//
	//			TEXTE CLAIR->MORSE
	// Converti une chaine de caractère en
	// en code Morse
	// --------------------------------------//
	public static String textToMorse(String string) {
		if (ModeSelector.Mode.getMode() == ModeSelector.Mode.ITERATIF) {
//			System.out.println("Mode itératif Texte->Morse");
			return CodageMorseIteratif.codage(string);
		} else {
//			System.out.println("Mode récursif Texte->Morse");
			return CodageMorseRecursif.codage(string);
		}
	}

	// --------------------------------------//
	//			TEXTE MORSE->CLAIR
	// Converti une chaine de caractère Morse
	// en texte clair
	// --------------------------------------//
	public static String morseToText(String string) {
		if (ModeSelector.Mode.getMode() == ModeSelector.Mode.ITERATIF) {
//			System.out.println("Mode itératif Morse->Texte");
			return CodageMorseIteratif.decodage(string);
		} else {
//			System.out.println("Mode récursif Morse->Texte");
			return CodageMorseRecursif.decodage(string);
		}
	}

	// --------------------------------------//
	//			FICHIER CLAIR->MORSE
	// Lecture du fichier en clair et conversion
	// vers le fichier Morse
	// --------------------------------------//
	public static String fileToMorse(File fichierEntreeClair, File fichierSortieMorse) {
		// Variable temporaire
		String texteMorse = "";
		String texteMorseComplet = "";

		try (Scanner sc = new Scanner(fichierEntreeClair); BufferedWriter bw = new BufferedWriter(new FileWriter(fichierSortieMorse))) {

			while (sc.hasNext()) {
				String next = sc.nextLine();

				// Code le texte en morse...
				texteMorse = textToMorse(next);
				// et l'enregistre dans un fichier
				bw.write(texteMorse);

				texteMorseComplet += texteMorseComplet + texteMorse;

				// Affichage (pour contrôle)
//				System.out.println(CodageMorse.codage(next));
//				System.out.println(CodageMorse.decodage(texteMorse));
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return texteMorseComplet;
	}

	// --------------------------------------//
	//			FICHIER MORSE->CLAIR
	// Lecture du fichier en Morse et conversion
	// vers le fichier TexteClair
	// --------------------------------------//
	public static String fileToText(File fichierEntreeMorse, File fichierSortieClair) {
		// Variable temporaire
		String texteClair = "";
		String texteClairComplet = "";

		try (Scanner sc = new Scanner(fichierEntreeMorse); BufferedWriter bw = new BufferedWriter(new FileWriter(fichierSortieClair))) {

			while (sc.hasNext()) {
				String next = sc.nextLine();

				// Code le texte en morse...
				texteClair = morseToText(next);
				// et l'enregistre dans un fichier
				bw.write(texteClair);

				texteClairComplet += texteClairComplet + texteClair;

				// Affichage (pour contrôle)
//				System.out.println(CodageMorse.codage(next));
//				System.out.println(CodageMorse.decodage(texteMorse));
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return texteClairComplet;
	}

}
