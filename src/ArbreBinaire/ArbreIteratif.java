package ArbreBinaire;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class ArbreIteratif {

	private Noeud racine;

	public Noeud getRacine() {
		return racine;
	}

	//---------------------------
	// Ajout noeud à la fin en version itérative
	//---------------------------
	public boolean ajoutNoeud(String cle, String valeur) {

		// On initialise le noeud à ajouter
		Noeud nouveauNoeud = Noeud.creer(cle, valeur, null, null);

		// Si la racine est vide, le nouveau noeud est la racine
		// elle sera réutilisé lors de la recherche. On n'y touche plus!
		if (Noeud.estVide(racine)) {
			racine = nouveauNoeud;

			// Dans le cas contraire
		} else {

			// On demarre à la racine...
			Noeud parent = racine;

			while (true) {

				// Si la clé du nouveauNoeud est inférieure
				// à la clé du parent, on regarde à gauche
				// L'arbre n'accepte pas de doublon
				if (nouveauNoeud.getCle().compareTo(parent.getCle()) < 0) {

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
	// Chercher version itérative
	//---------------------------
	public Noeud chercher(String cle) {

		// On demarre de la racine (défini lors
		// de la construction de l'arbre)
		Noeud courant = racine;

		// Tant que la clé fournie ne correspond
		// pas à la clé du noeud courant, on
		// continue de boucler
		while (!cle.equals(courant.getCle())) {

			// Si la clé fournie est inférieure
			// à la clé du noeud courant...
			if (cle.compareTo(courant.getCle()) < 0) {
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
			if (Noeud.estVide(courant)) {
				return null;
			}
		}

		// On est sorti de la boucle, on retourne le noeud courant
		return courant;

	}

	//---------------------------
	// Minimum version iterative
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

		while (!Noeud.estVide(courant)) {
			temp = courant;
			courant = courant.getFilsGauche();
		}

		return temp;
	}

	//---------------------------
	// Maximum version iterative
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

		while (!Noeud.estVide(courant)) {
			temp = courant;
			courant = courant.getFilsDroit();
		}

		return temp;
	}

	//---------------------------
	// Maximum version iterative
	//---------------------------
	// Version surchargée pour la suppression
	public Noeud max(Noeud sousArbre) {

		// On constate la propriété suivante
		// Si le noeud filsDroit à forcement une
		// clé supérieure à son parent, il suffit d'itérer
		// dans l'arbre toujours vers la droite jusqu'à 
		// arriver au dernier noeud qui sera celui avec 
		// la plus grande valeur
		Noeud courant = sousArbre;
		Noeud temp = null;

		while (!Noeud.estVide(courant)) {
			temp = courant;
			courant = courant.getFilsDroit();
		}

		return temp;
	}

	//---------------------------
	// Parcours de l'arbre version RECURSIVE
	//---------------------------
	// Permet de parcourir l'ensemble des noeuds
	// Ordre préfixe
	public void prefixe(Noeud courant) {

		if (!Noeud.estVide(courant)) {

			// On affiche le nom du noeud et sa clé lorsqu'on
			// le rencontre la première fois
			System.out.println(courant);

			prefixe(courant.getFilsGauche());
			prefixe(courant.getFilsDroit());

		}

	}

	//---------------------------
	// Supprimer version iterative
	//---------------------------
	public Noeud supprimer(String cle, Noeud courant) {

		// On défini le noeud de départ comme étant la racine
		courant = this.racine;
		Noeud parent = null;
		boolean flag = false;

		// On teste, si la clé du noeud courant n'est pas la clé recherchée
		while (!cle.equals(courant.getCle())) {

			// Si la clé est inférieure, on sélectionne le fils gauche
			if (cle.compareTo(courant.getCle()) < 0) {
				// Le noeud courant devient le noeud parent
				parent = courant;
				// On défini le fils gauche comme le nouveau noeud
				// à tester et on reboucle.
				courant = courant.getFilsGauche();
				// On met un flag pour se rappeler que le parent est dans le noeud
				// de droite (fils droit)
				flag = false;

				// Si la clé est supérieure, on sélectionne le fils droit
			} else if (cle.compareTo(courant.getCle()) > 0) {
				// Le noeud courant devient le noeud parent
				parent = courant;
				// On défini le fils droit comme le nouveau noeud
				// à tester et on reboucle.
				courant = courant.getFilsDroit();
				// On met un flag pour se rappeler que le parent est dans le noeud
				// de droite (fils droit)
				flag = true;
			} else {
				// Si aucune condition n'est rempli,
				// alors la clé n'existe pas
				return null;
			}
		}

		// On a localisé le noeud à supprimer
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
			Noeud temp = max(courant.getFilsGauche());
			
			// Avant d'ajouter les fils du noeud à supprimer
			// On supprime le noeud de remplacement dans les fils
			// Sinon, il sera présent deux fois dans l'arbre !!!
			supprimer(temp.getCle(), courant);
			
			// On ajoute le sous-arbre droit du noeud à supprimer
			// au noeud de remplacement
			temp.setFilsDroit(courant.getFilsDroit());
			// On ajoute le sous-arbre gauche du noeud à supprimer
			// au noeud de remplacement
			temp.setFilsGauche(courant.getFilsGauche());
			// Et on remplace le noeud à supprimer par le noeud
			// qui le remplace
			courant = temp;
		}

		// On "raccroche" les éléments au parent du noeud supprimé
		// Soit au fils Gauche, soit au fils Droit
		if (flag) {
			parent.setFilsDroit(courant);
		} else {
			parent.setFilsGauche(courant);
		}

		return parent;
	}
}
