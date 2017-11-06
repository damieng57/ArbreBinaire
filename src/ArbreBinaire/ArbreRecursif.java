package ArbreBinaire;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class ArbreRecursif {


//	public static Noeud creer(String cle, String valeur, Noeud filsGauche, Noeud filsDroit) {
//		return Noeud.creer(cle, valeur, filsGauche, filsDroit);
//	}

	//---------------------------
	// Ajout noeud à la fin en version recursive
	//---------------------------
	public static Noeud ajoutNoeudRecursif(String cle, String valeur, Noeud parent) {

		if (Noeud.estVide(parent)) {
			return Noeud.creer(cle, valeur, null, null);
		} else {
			if (cle.compareTo(parent.getCle()) < 0) {
				return Noeud.creer(parent.getCle(), parent.getValeur(), ajoutNoeudRecursif(cle, valeur, parent.getFilsGauche()), parent.getFilsDroit());
			} else {
				return Noeud.creer(parent.getCle(), parent.getValeur(), parent.getFilsGauche(), ajoutNoeudRecursif(cle, valeur, parent.getFilsDroit()));
			}
		}
	}

	//---------------------------
	// Chercher version recursive
	//---------------------------
	public static Noeud chercherRecursif(String cle, Noeud courant) {

		// Au premier appel de la fonction
		// noeud courant sera égal à la racine de l'arbre
		// Si courant est null, cela voudra dire
		// que l'on a atteint la fn d'une branche
		// sans trouver de clé correspondante
		if (Noeud.estVide(courant)) {
			return null;

		} else {
			// Si la clé correspond à la clé du nooeud
			// on renvoie ce noeud
			if (cle.equals(courant.getCle())) {
				return courant;
				// Si la clé recherchée est inférieure à la clé du noeud
				// On fourni le filsGauche
			} else if (cle.compareTo(courant.getCle()) < 0) {
				return chercherRecursif(cle, courant.getFilsGauche());

				// Sinon c'est que la clé recherchée est supérieure
				// à la clé du noeud, on fourni le filsDroit
			} else {
				return chercherRecursif(cle, courant.getFilsDroit());
			}
		}
	}

	//---------------------------
	// Minimum version recursive
	//---------------------------
	public static Noeud minRecursif(Noeud courant) {

		// On constate la propriété suivante
		// Si le noeud filsGauche à forcement une
		// clé inférieure à son parent, il suffit d'itérer
		// dans l'arbre toujours vers la gauche jusqu'à 
		// arriver au dernier noeud qui sera celui avec 
		// la plus petite valeur
		if (Noeud.estVide(courant.getFilsGauche())) {
			return courant;
		} else {
			return minRecursif(courant.getFilsGauche());
		}
	}

	//---------------------------
	// Maximum version recursive
	//---------------------------
	public static Noeud maxRecursif(Noeud courant) {

		// On constate la propriété suivante
		// Si le noeud filsDroit à forcement une
		// clé supérieure à son parent, il suffit d'itérer
		// dans l'arbre toujours vers la droite jusqu'à 
		// arriver au dernier noeud qui sera celui avec 
		// la plus grande valeur
		if (Noeud.estVide(courant.getFilsDroit())) {
			return courant;
		} else {
			return maxRecursif(courant.getFilsDroit());
		}
	}

	//---------------------------
	// Parcours de l'arbre version recursive
	//---------------------------
	// Utilisation de la récursivité
	// pour parcourir l'ensemble des noeuds
	// Ordre préfixe
	public static void Prefixe(Noeud courant) {

		if (!Noeud.estVide(courant)) {
			// On affiche le nom du noeud et sa clé lorsqu'on
			// le rencontre la première fois
			System.out.println(courant);

			Prefixe(courant.getFilsGauche());
			Prefixe(courant.getFilsDroit());
		}

	}

}
