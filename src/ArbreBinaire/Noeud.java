package ArbreBinaire;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */

public class Noeud {

	// Un noeud est caractérisé par sa clé et sa valeur
	private int cle;
	private String valeur;

	// et deux fils qui sont également des noeuds
	private Noeud filsGauche;
	private Noeud filsDroit;
	
	// En soi, un noeud est un arbre à deux niveaux (racine + 2 fils)

	// Constructeur du noeud pour la version recursive
	public Noeud(int cle, String valeur, Noeud filsGauche, Noeud filsDroit) {
		this.cle = cle;
		this.valeur = valeur;
		this.filsGauche = filsGauche;
		this.filsDroit = filsDroit;
	}
	
	// Constructeur du noeud pour la version iterative
	public Noeud(int cle, String valeur) {
		this.cle = cle;
		this.valeur = valeur;
	}
	
	public static Noeud creer(int cle, String valeur, Noeud filsGauche, Noeud filsDroit) {
		return new Noeud(cle, valeur, filsGauche, filsDroit);
	}

	// Affichage de la clé et de la valeur
	@Override
	public String toString() {
		return ("La clé : " + getCle() + " a pour valeur associée : " + getValeur());
	}

	/**
	 * @return cle
	 */
	public int getCle() {
		return cle;
	}

	/**
	 * @return valeur
	 */
	public String getValeur() {
		return valeur;
	}
	
		/**
	 * @return the filsGauche
	 */
	public Noeud getFilsGauche() {
		return filsGauche;
	}

	/**
	 * @param filsGauche the filsGauche to set
	 */
	public void setFilsGauche(Noeud filsGauche) {
		this.filsGauche = filsGauche;
	}

	/**
	 * @return the filsDroit
	 */
	public Noeud getFilsDroit() {
		return filsDroit;
	}

	/**
	 * @param filsDroit the filsDroit to set
	 */
	public void setFilsDroit(Noeud filsDroit) {
		this.filsDroit = filsDroit;
	}
	
}

	
