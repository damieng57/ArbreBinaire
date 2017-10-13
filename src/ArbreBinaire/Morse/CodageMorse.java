package ArbreBinaire.Morse;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
import ArbreBinaire.Noeud;
import ArbreBinaire.Arbre;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Damien
 */
public class CodageMorse {

	private static Noeud arbre_codage = null;
	private static Noeud arbre_decodage = null;

	static {
		// Chargement du fichier de codage Morse.txt
		File fichier = new File("/Users/Damien/Documents/workspace/Java/ArbreBinaire/src/Ressources/Morse.txt");

		try (Scanner sc = new Scanner(fichier);) {
			
			String[] element = sc.nextLine().split("#");
			arbre_codage = Arbre.creer(String.valueOf(element[0].charAt(0)), element[1], null, null);
			arbre_decodage = Arbre.creer(element[1], element[0], null, null);

			while (sc.hasNextLine()) {
				element = sc.nextLine().split("#");
				arbre_codage = Arbre.ajoutNoeudRecursif(String.valueOf(element[0].charAt(0)), element[1], arbre_codage);
				arbre_decodage = Arbre.ajoutNoeudRecursif(element[1], element[0], arbre_decodage);
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
				// (ex: pour 'G' correspond à --.).


				// On ajoute un espace avant de passer au code suivant
				resultat += (Arbre.chercherRecursif(String.valueOf(texte.charAt(i)), arbre_codage).getValeur() + " ");

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
				resultat += Arbre.chercherRecursif(string, arbre_decodage).getValeur();
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
}
