package ArbreBinaire.Morse;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
import ArbreBinaire.ArbreIteratif;
import ArbreBinaire.Noeud;
import Fonctions.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CodageMorseIteratif {

	// --------------------------------------//
	//		 FONCTIONS DE CODAGE/DECODAGE
	//		   POUR LE MODE ITERATIF
	//
	// --------------------------------------//
	private static ArbreIteratif arbre_codage_iteratif = new ArbreIteratif();
	private static ArbreIteratif arbre_decodage_iteratif = new ArbreIteratif();

	static {

		Timer.start();

		// Chargement du fichier de codage Morse.txt
		File fichier = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/Morse.txt");

		try (Scanner sc = new Scanner(fichier);) {

			while (sc.hasNextLine()) {
				String[] element = sc.nextLine().split("#");

				arbre_codage_iteratif.ajoutNoeud(element[0], element[1]);
				arbre_decodage_iteratif.ajoutNoeud(element[1], element[0]);

			}
		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		}

		System.out.println("Durée de création de l'arbre itératif : ");
		Timer.stopAndDisplay();
	}

	public static String codage(String texteClair) {
		// Le code morse ne faisant pas la différence entre
		// majuscule et miniscule, on passe tout le texte fourni
		// en majuscule


		// NOTA : La fonction toUpperCase augmente le temps
		// de traitement de manière significative
		// Jusqu'à +30% en itératif et +60% en récursif
		// Tout comme compareToIgnoreCase et equalsIgnoreCase
		String texte = texteClair.toUpperCase();
		String resultat = "";


		// On code chacune des lettres du texte
		for (int i = 0; i < texte.length(); i++) {
			try {
				// On essaie de voir si le caractère est dans l'arbre et
				// on récupère la valeur (code morse) dans temp
				// (ex: pour 'G' correspond à --.).

				// On ajoute un espace avant de passer au code suivant
				resultat += (arbre_codage_iteratif.chercher(String.valueOf(texte.charAt(i))).getValeur() + " ");

			} catch (NullPointerException e) {
				// Si le caractère n'a pas été trouvé (ex: un espace, une lettre
				// accentuée,...) on ajoute simplement un espace
				resultat += " ";
			}
		}
		// Retourne le code Morse
		return resultat;
	}

	public static String decodage(String texteMorse) {
		// Récuperation du code Morse
		// On coupe la chaine de caractère au niveau
		// des espaces pour récupérer un tableau.
		// Chaque tableau[postion] correspond
		// à un caractère
		String[] code = texteMorse.split(" ");

		String resultat = "";

		// On itère sur le tableau
		for (String string : code) {

			try {
				// On essaie d'ajouter un caractère au resultat en effectuant une
				// recherche dans l'arbre de décodage
				resultat += arbre_decodage_iteratif.chercher(string).getValeur();
			} catch (NullPointerException e) {
				// Si la recherche échoue, c'est qu'il s'agit d'un espace utilisé
				// pour la séparation des mots ou le caractère ne
				// pouvait pas être converti en morse.
				// On ajoute donc simplement un espace
				resultat += " ";
			}

		}
		// Affichage de la chaine décodée depuis le code morse
		return resultat;
	}

	public static void TestCodage() {

		// ------------ //
		// Vérification //
		// ------------ //
		Noeud result;
		result = arbre_decodage_iteratif.chercher(".-.-.-");
		System.out.println(result);

		result = arbre_codage_iteratif.chercher("E");
		System.out.println(result);

		System.out.println(codage("Encore un autre test permettant de verifier que tout va bien 1234567890."));
		System.out.println(decodage(". -. -.-. --- .-. .  ..- -.  .- ..- - .-. .  - . ... -  .--. . .-. -- . - - .- -. -  -.. .  ...- . .-. .. ..-. .. . .-.  --.- ..- .  - --- ..- -  ...- .-  -... .. . -. .-.-.-"));

		System.out.println("\n*************\n");
		arbre_codage_iteratif.Prefixe(arbre_codage_iteratif.getRacine());
	}
}
