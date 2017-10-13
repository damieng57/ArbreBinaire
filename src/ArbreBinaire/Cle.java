/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbreBinaire;

/**
 *
 * @author Damien
 */
public class Cle<K extends Comparable<K>> {

	// Variable d'instance
	private K key;

	// Constructeur de clé avec paramètre inconnu (générique)
	public Cle(K key) {
		this.key = key;
	}
	
	// Getter pour la clé
	public K getKey() {
		return key;
	}
	
	// Setter pour la clé
	public void setKey(K key) {
		this.key = key;
	}

	public int Compare(K autreCle) {
		int cmp = key.compareTo(autreCle);
		if (cmp == 0) {
			System.out.println("equal");
		} else if (cmp < 0) {
			System.out.println("less");
		} else if (cmp > 0) {
			System.out.println("greater");
		}
		return cmp;
	}

	@Override
	public String toString() {
		return (String) (getKey());
	}

}
