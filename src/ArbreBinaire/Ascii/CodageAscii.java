package ArbreBinaire.Ascii;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 * 
 * -----------------------------
 * Pour le fun, la même en Ascii
 * -----------------------------
 * 
 */

import ArbreBinaire.Arbre;
import ArbreBinaire.Noeud;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Damien
 */
public class CodageAscii {

	private static final Arbre ARBRE_CODAGE = new Arbre();
	private static final Arbre ARBRE_DECODAGE = new Arbre();

	static {
		// Chargement du fichier de codage Ascii.txt
		File fichier = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/ArbreBinaire/Ascii/Ascii.txt");

		try (Scanner sc = new Scanner(fichier)) {

			while (sc.hasNextLine()) {
				String[] element = sc.nextLine().split("#");
				
				ARBRE_CODAGE.ajoutNoeud(element[0].charAt(0), element[1]);

				ARBRE_DECODAGE.ajoutNoeud(Integer.parseInt(element[1]), element[0]);

			}

		} catch (FileNotFoundException ex) {
			System.err.println("ex");
		}

	}

	public static String codage(String texteClair) {
		// Le code morse ne faisant pas la différence entre
		// majuscule et miniscule, on passe tout le texte fourni
		// en majuscule
		String texte = texteClair.toUpperCase();
		String resultat = "";

		// On code chacune des lettres du texte
		for (int i = 0; i < texte.length(); i++) {
			try {
				// On essaie de voir si le caractère est dans l'arbre et
				// on récupère la valeur (code morse) dans temp
				// (ex: pour 'G' on obtiendra "221" correspondant à --.).
				String temp = ARBRE_CODAGE.chercher(texte.charAt(i)).getValeur();

				// On stocke le code Ascii du caractère en cours avec un petit espace
				resultat += temp+" ";

			} catch (NullPointerException e) {
				// Si le caractère n'a pas été trouvé (ex: un espace, une lettre
				// accentuée,...) on ajoute simplement un espace
				resultat += " ";
			}
		}
		// Retourne le code Ascii
		return resultat;
	}

	public static String decodage(String texteAscii) {
		// Récuperation du code Morse
		// On coupe la chaine de caractère au niveau
		// des espaces pour récupérer un tableau.
		// Chaque tableau[postion] correspond
		// à un caractère
		String[] code = texteAscii.split(" ");

		String resultat = "";

		// On itère sur le tableau
		for (String string : code) {
			String temp = "";
			// On décortique le code Ascii pour récupérer
			// les différents caractères.
			
			
			temp += string;

			try {
				// On essaie d'ajouter un caractère au resultat en effectuant une
				// recherche dans l'arbre de décodage (on fourni une clé sous la
				// forme d'un entier)
				resultat += ARBRE_DECODAGE.chercher(Integer.parseInt(temp)).getValeur();
			} catch (NumberFormatException e) {
				// Si la recherche échoue, c'est qu'il s'agit d'un espace utilisé
				// pour la séparation des mots ou en substitue si le caractère ne
				// pouvait pas être converti en Ascii.
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
		Noeud resultat;
		resultat = ARBRE_DECODAGE.chercher(53);
		System.out.println("Résultat pour la version itérative : "+resultat);
		resultat = ARBRE_DECODAGE.chercherRecursif(53, ARBRE_DECODAGE.getRacine());
		System.out.println("Résultat pour la version récursive : "+resultat);

		resultat = ARBRE_CODAGE.chercher('F');
		System.out.println(resultat);
		codage("Encore un autre test permettant de verifier que tout va bien.");

		//decodage("");
		System.out.println(ARBRE_DECODAGE.min());
		System.out.println(ARBRE_DECODAGE.minRecursif(ARBRE_DECODAGE.getRacine()));
		System.out.println(ARBRE_DECODAGE.max());
		System.out.println(ARBRE_DECODAGE.maxRecursif(ARBRE_DECODAGE.getRacine()));
		System.out.println(ARBRE_CODAGE.min());
		System.out.println(ARBRE_CODAGE.max());
		System.out.println("\n*************\n");
		ARBRE_DECODAGE.Prefixe(ARBRE_DECODAGE.getRacine());
	}

}
