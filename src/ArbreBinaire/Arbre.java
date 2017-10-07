package ArbreBinaire;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class Arbre {

	private Noeud racine;

	public Noeud getRacine() {
		return racine;
	}

	//---------------------------
	// Nouveau noeud version recursive
	//---------------------------
	public Noeud ajoutNoeudRecursif(int cle, String valeur, Noeud parent) {
		if (parent == null) {
			if (racine==null) {
				racine = Noeud.creer(cle, valeur, null, null);
				return racine;
			} else {
				return Noeud.creer(cle, valeur, null, null);
			}
		} else {
			if (cle < parent.getCle()) {
				return Noeud.creer(cle, valeur, ajoutNoeudRecursif(cle, valeur, parent.getFilsGauche()), parent.getFilsDroit());
			} else {
				return Noeud.creer(cle, valeur, parent.getFilsGauche(), ajoutNoeudRecursif(cle, valeur, parent.getFilsDroit()));
				}
		}
	}
	
		//---------------------------
		// Nouveau noeud version itérative
		//---------------------------
	
	public boolean ajoutNoeud(int cle, String valeur) {

		// On initialise le noeud à ajouter
		Noeud nouveauNoeud = new Noeud(cle, valeur);

		// Si la racine est vide, le nouveau noeud est la racine
		// elle sera réutilisé lors de la recherche. On n'y touche plus!
		if (racine == null) {
			racine = nouveauNoeud;

			// Dans le cas contraire
		} else {

			// On demarre à la racine...
			Noeud parent = racine;

			while (true) {

				// Si la clé du nouveauNoeud est inférieure
				// à la clé du parent, on regarde à gauche
				// L'arbre n'accepte pas de doublon
				if (nouveauNoeud.getCle() < parent.getCle()) {

					// Si le parent n'a aucun filsGauche
					// alors, le nouveauNoeud devient le filsGauche
					if (parent.getFilsGauche() == null) {
						parent.setFilsGauche(nouveauNoeud);
						// Fin de l'ajout, on sort de la fonction
						return true;

						// Si parent a un filsGauche, on défini ce filsGauche 
						// comme nouveau parent éventuel pour le nouveauNoeud.
					} else {
						parent = parent.getFilsGauche();
						// Puis on reboucle pour tester avec ce nouveau parent
					}
				} else {
					// Si le parent n'a aucun filsDroit
					// alors, le nouveauNoeud devient le filsDroit
					if (parent.getFilsDroit() == null) {
						parent.setFilsDroit(nouveauNoeud);
						return true;
						// Si parent a un filsGauche, on défini ce filsGauche 
						// comme nouveau parent éventuel pour le nouveauNoeud.
					} else {
						parent = parent.getFilsDroit();
						// Puis on reboucle pour tester avec ce nouveau parent
					}

				}

			}

		}
		return true;

	}

	//---------------------------
	// Chercher version recursive
	//---------------------------
	public Noeud chercherRecursif(int cle, Noeud courant) {

		// Au premier appel de la fonction
		// noeud courant sera égal à la racine de l'arbre
		// Si courant est null, cela voudra dire
		// que l'on a atteint la fn d'une branche
		// sans trouver de clé correspondante
		if (courant == null) {
			return null;

		} else {
			// Si la clé correspond à la clé du nooeud
			// on renvoie ce noeud
			if (cle == courant.getCle()) {
				return courant;
				// Si la clé recherchée est inférieure à la clé du noeud
				// On fourni le filsGauche
			} else if (cle < courant.getCle()) {
				return chercherRecursif(cle, courant.getFilsGauche());

				// Sinon c'est que la clé recherchée est supérieure
				// à la clé du noeud, on fourni le filsDroit
			} else {
				return chercherRecursif(cle, courant.getFilsDroit());
			}
		}
	}

	//---------------------------
	// Chercher version itérative
	//---------------------------
	public Noeud chercher(int cle) {

		// On demarre de la racine (défini lors
		// de la construction de l'arbre)
		Noeud courant = racine;

		// Tant que la clé fournie ne correspond
		// pas à la clé du noeud courant, on
		// continue de boucler
		while (cle != courant.getCle()) {

			// Si la clé fournie est inférieure
			// à la clé du noeud courant...
			if (cle < courant.getCle()) {
				// ...c'est le filsGauche qui devient
				// le noeud courant à tester...
				courant = courant.getFilsGauche();
			} else {
				// ...sinon, c'est le filsDroit qui devient
				// le noeud courant à tester
				courant = courant.getFilsDroit();
			}
			// Si le noeud courant est null (car un filsGauche
			// ou un filsDroit n'a pas été défini), le dernier noeud
			// était une feuille, impossible d'aller plus loin.
			// La clé demandée n'existe pas
			if (courant == null) {
				return null;
			}
		}

		// On est sorti de la boucle, on retourne le noeud courant
		return courant;

	}

	//---------------------------
	// Minimum version recursive
	//---------------------------
	public Noeud minRecursif(Noeud courant) {

		// On constate la propriété suivante
		// Si le noeud filsGauche à forcement une
		// clé inférieure à son parent, il suffit d'itérer
		// dans l'arbre toujours vers la gauche jusqu'à 
		// arriver au dernier noeud qui sera celui avec 
		// la plus petite valeur
		if (courant.getFilsGauche() == null) {
			return courant;
		} else {
			return minRecursif(courant.getFilsGauche());
		}
	}

	//---------------------------
	// Minimum version itérative
	//---------------------------
	public Noeud min() {

		// On constate la propriété suivante
		// Si le noeud filsGauche à forcement une
		// clé inférieure à son parent, il suffit d'itérer
		// dans l'arbre toujours vers la gauche jusqu'à 
		// arriver au dernier noeud qui sera celui avec 
		// la plus petite valeur
		Noeud courant = racine;
		Noeud temp = null;

		while (courant != null) {
			temp = courant;
			courant = courant.getFilsGauche();
		}

		return temp;
	}

	//---------------------------
	// Maximum version recursive
	//---------------------------
	public Noeud maxRecursif(Noeud courant) {

		// On constate la propriété suivante
		// Si le noeud filsDroit à forcement une
		// clé supérieure à son parent, il suffit d'itérer
		// dans l'arbre toujours vers la droite jusqu'à 
		// arriver au dernier noeud qui sera celui avec 
		// la plus grande valeur
		if (courant.getFilsDroit() == null) {
			return courant;
		} else {
			return maxRecursif(courant.getFilsDroit());
		}
	}

	//---------------------------
	// Maximum version itérative
	//---------------------------
	public Noeud max() {

		// On constate la propriété suivante
		// Si le noeud filsDroit à forcement une
		// clé supérieure à son parent, il suffit d'itérer
		// dans l'arbre toujours vers la droite jusqu'à 
		// arriver au dernier noeud qui sera celui avec 
		// la plus grande valeur
		Noeud courant = racine;
		Noeud temp = null;

		while (courant != null) {
			temp = courant;
			courant = courant.getFilsDroit();
		}

		return temp;
	}

	//---------------------------
	// Parcours de l'arbre version recursive
	//---------------------------
	// Utilisation de la récursivité
	// pour parcourir l'ensemble des noeuds
	// Ordre préfixe
	public void Prefixe(Noeud courant) {

		if (courant != null) {

			// On affiche le nom du noeud et sa clé lorsqu'on
			// le rencontre la première fois
			System.out.println(courant);

			Prefixe(courant.getFilsGauche());
			Prefixe(courant.getFilsDroit());

		}

	}

}
