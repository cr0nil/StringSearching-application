package application;

import java.util.ArrayList;
import java.util.Scanner;

public class KnuthMorrisPrattAalgorithm {
	public static int ind;
	public static ArrayList<Integer> poczatki = new ArrayList<Integer>();

	public KnuthMorrisPrattAalgorithm() {

	}

	public static void search(String wzorzec, String tekst) {

		int m, n, i, j, t;
		int P[] = new int[100];// maksymalna dlugosc wzorca to 100 symboli
		System.out.println("KNP");
		System.out.println("Podaj tekst1");

		System.out.println("Podaj wzorzec11");

		n = tekst.length();
		m = wzorzec.length();
		System.out.println("Indeksy poczatku wzorca w tekscie");

		// obliczenie tablicy P
		P[0] = 0;
		P[1] = 0;
		t = 0;
		for (j = 2; j <= m; j++) {
			while ((t > 0) && (wzorzec.charAt(t) != wzorzec.charAt(j - 1))) {
				t = P[t];
			}
			if (wzorzec.charAt(t) == wzorzec.charAt(j - 1)) {
				t++;
			}
			P[j] = t;
		}

		// algorytm KMP
		i = 1;
		j = 0;
		while (i <= n - m + 1) {
			j = P[j];
			while ((j < m) && (wzorzec.charAt(j) == tekst.charAt(i + j - 1))) {
				j++;
			}
			if (j == m) {
				System.out.println(i);
				ind = i;
				poczatki.add(ind);
			}
			i = i + Math.max(1, j - P[j]);
		}

	}

	public int getInd() {
		return ind;
	}

	public static ArrayList getPocz() {
		return poczatki;
	}
}
