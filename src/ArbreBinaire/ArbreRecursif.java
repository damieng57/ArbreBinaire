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
	public static void prefixe(Noeud courant) {

		if (!Noeud.estVide(courant)) {
			// On affiche le nom du noeud et sa clé lorsqu'on
			// le rencontre la première fois
			System.out.println(courant);

			prefixe(courant.getFilsGauche());
			prefixe(courant.getFilsDroit());
		}

	}
	
	// A FINALISER
	
	//---------------------------
	// Supprimer version recursif
	//---------------------------
	public void supprimerRecursif(String cle, Noeud courant) {

		// On demarre de la racine (défini lors
		// de la construction de l'arbre)
		if (courant == null) {
			// Arbre vide ou valeur non trouvée
			System.out.println("L'arbre est vide ou la clé n'existe pas");

		} else {
			if (cle.equals(courant.getCle())) {

				// Si pas de fils droit ou gauche, on supprime le noeud
				if (courant.getFilsDroit() == null && courant.getFilsGauche() == null) {
					courant = null;
					// Si le fils droit n'est pas null mais le fils gauche n'existe pas
				} else if (courant.getFilsDroit() != null && courant.getFilsGauche() == null) {
					// Le fils droit devient le noeud courant
					courant = courant.getFilsDroit();
					// Si le fils gauche n'est pas null mais le fils droit n'existe pas
				} else if (courant.getFilsDroit() == null && courant.getFilsGauche() != null) {
					// Le fils droit devient le noeud courant
					courant = courant.getFilsGauche();
					// Si aucune des conditions précédentes n'est vérifiée, c'est qu'il y deux fils
				} else {
					// On prend le max du fils gauche
					Noeud maxFilsGauche = maxRecursif(courant.getFilsGauche());
					// On lui ajout le sous-arbre droit comme fils
					maxFilsGauche.setFilsDroit(courant.getFilsDroit());
					// Puis le sous-arbre gauche
					maxFilsGauche.setFilsGauche(courant.getFilsGauche());
					// Et on remplace le noeud à supprimer par le maxFilsGauche
					courant = maxFilsGauche;
					maxFilsGauche = null;

					// NOTA : On aurait pu faire avec la meêm en cherchant le
					// mini de l'arbre droit
				}
			} else {

				// Si la clé fournie est inférieure
				// à la clé du noeud courant...
				if (cle.compareTo(courant.getCle()) < 0) {
					// ...c'est le filsGauche qui devient
					// le noeud courant à tester...
					supprimerRecursif(cle, courant.getFilsGauche());
				} else {
					// ...sinon, c'est le filsDroit qui devient
					// le noeud courant à tester
					supprimerRecursif(cle, courant.getFilsDroit());
				}

			}
		}
	}

}
