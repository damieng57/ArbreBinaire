/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbreBinaire;

import java.util.Comparator;

/**
 *
 * @author Damien
 */
public class Compare implements Comparator<Noeud>{

	@Override
	public int compare(Noeud o1, Noeud o2) {
		return 0;//o1.getCle().compareTo(o2.getCle());
	}
}