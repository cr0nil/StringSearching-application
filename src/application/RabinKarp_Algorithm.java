package application;

import java.util.ArrayList;

public class RabinKarp_Algorithm {
	public static ArrayList<Integer> poczatki = new ArrayList<Integer>();
	private static final int r = 512; // liczba symboli alfabetu (char 0-255)
	private static final int q = 9551; // możliwie duża liczba pierwsza

	public RabinKarp_Algorithm() {
		final int r = 512;
		final int q = 9551;
		// RK_algo(null, null);
	}

	public static int power_modulo_fast(int a, int b, int m) {
		int i;
		int result = 1;
		long x = a % m;

		for (i = 1; i <= b; i <<= 1) {
			x %= m;
			if ((b & i) != 0) {
				result *= x;
				result %= m;
			}
			x *= x;
		}

		return result % m;
	}

	/**
	 * @param args
	 */
	public static int ind;

	public static void RK_algo(String tekst, String wzor) {
		int m, n, i, j, h1, h2, rm;

		String wzorzec;

		System.out.println("Podaj tekst");
		// tekst = "kaczka";
		System.out.println("Podaj wzorzec");
		// wzor = "kacz";

		n = tekst.length();
		m = wzor.length();
		h2 = 0;
		h1 = 0;
		System.out.println("Indeksy poczatkow wzorca w tekscie");

		// algorytm Hornera do obliczenia funkcji haszujacej h(tekst[1..m])
		for (i = 0; i < m; i++) {
			h2 = ((h2 * r) + tekst.charAt(i));
			h2 %= q;
		}
		// algorytm Hornera do obliczenia funkcji haszujacej h(wzorzec)
		for (i = 0; i < m; i++) {
			h1 = ((h1 * r) + wzor.charAt(i));
			h1 %= q;
		}

		// Algorytm KR (Karpa-Rabina)
		rm = power_modulo_fast(r, m - 1, q);
		i = 0;
		while (i < n - m) {
			j = 0;
			if (h1 == h2)
				while ((j < m) && (wzor.charAt(j) == tekst.charAt(i + j)))
					j++;
			if (j == m) {
				System.out.println(i + 1);
				ind = i;
				poczatki.add(ind);
			}
			h2 = ((h2 - tekst.charAt(i) * rm) * r + tekst.charAt(i + m));
			h2 %= q;
			if (h2 < 0)
				h2 += q;
			i++;
		}
		j = 0;
		if (h1 == h2)
			while ((j < m) && (wzor.charAt(j) == tekst.charAt(i + j)))
				j++;
		if (j == m) {
			System.out.println(i + 1);
			ind = i;
			poczatki.add(ind);
		}
	}

	public static int getI() {
		return ind+1;
	}
	public static ArrayList getPocz() {
		return poczatki;
	}

}
