package Fonctions;

/**
 *
 * @author Damien GAIGA Licence Professionnelle Web et Commerce Electronique IUT
 * de METZ - 2017/2018
 *
 */
public class Timer {

	private static long startTime;
	private static long endTime;
	private static long elapsedime;

	public static void start() {
		startTime = System.currentTimeMillis();
	}

	public static void stop() {
		endTime = System.currentTimeMillis();
	}

	public static long elapsed() {
		elapsedime = (endTime - startTime);
		return elapsedime;
	}

	public static void stopAndDisplay() {
		stop();
		System.out.println(elapsed()+"ms");
	}


}
