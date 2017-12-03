package ArbreBinaire;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class Noeud {

	// --------------------------------------//
	//		   DEFINITION D'UN NOEUD ET 
	//		   DE SES FONCTIONS DE BASE
	//  (Commun au algo itératif et récursif)
	// --------------------------------------//
	// Un noeud est caractérisé par sa clé et sa valeur
	private String cle;
	private String valeur;

	// et deux fils qui sont également des noeuds
	private Noeud filsGauche;
	private Noeud filsDroit;

	// En soi, un noeud est un arbre à deux niveaux (racine + 2 fils)
	public Noeud() {
	}

	// Constructeur du noeud
	public Noeud(String cle, String valeur, Noeud filsGauche, Noeud filsDroit) {
		this.cle = cle;
		this.valeur = valeur;
		this.filsGauche = filsGauche;
		this.filsDroit = filsDroit;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public static Noeud creer(String cle, String valeur, Noeud filsGauche, Noeud filsDroit) {
		return new Noeud(cle, valeur, filsGauche, filsDroit);
	}

	public static boolean estVide(Noeud noeud) {
		return (noeud == null);
	}

	// Affichage de la clé et de la valeur
	@Override
	public String toString() {
		return ("La clé : " + getCle() + " a pour valeur associée : " + getValeur());
	}

	/**
	 * @return cle
	 */
	public String getCle() {
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
	 * @return the filsDroit
	 */
	public Noeud getFilsDroit() {
		return filsDroit;
	}

	// Les setters ne sont utiles que pour la version ArbreIteratif
	/**
	 * @param filsGauche the filsGauche to set
	 */
	public void setFilsGauche(Noeud filsGauche) {
		this.filsGauche = filsGauche;
	}

	/**
	 * @param filsDroit the filsDroit to set
	 */
	public void setFilsDroit(Noeud filsDroit) {
		this.filsDroit = filsDroit;
	}

}
