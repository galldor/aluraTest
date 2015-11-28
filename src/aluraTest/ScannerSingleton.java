package aluraTest;

import java.util.Scanner;

public class ScannerSingleton {
	private static Scanner instance = null;
	   
	public static Scanner getInstance() {
		if(instance == null) {
			instance = new Scanner(System.in);
		}
		return instance;
	}

	public static void close() {
		if(instance != null){
			instance.close();
		}
	}
}
