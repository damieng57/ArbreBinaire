/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonctions;

/**
 *
 * @author Damien
 */
public class ModeSelector {
	
	// --------------------------------------//
	//	ENUMERATION PERMETTANT DE DEFINIR
	//		   L'ALOGRITHME ACTIF
	//
	// --------------------------------------//

	private static Mode mode = Mode.ITERATIF;

	public enum Mode {
		ITERATIF, RECURSIF;

		public static Mode getMode() {
			return mode;
		}

		public static void setMode(Mode mode) {
			ModeSelector.mode = mode;
		}
	}

}
