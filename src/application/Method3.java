package application;

import java.util.ArrayList;

public class Method3 {
	public static ArrayList<Integer> literka = new ArrayList<Integer>();
	public static ArrayList<Integer> literka2 = new ArrayList<Integer>();
	public static ArrayList<Integer> literka3 = new ArrayList<Integer>();
	public Method3() {
		
	}

	public static void szukaj(String wzor,String tekst) {
	literka.clear();
	literka2.clear();
	literka3.clear();
		
	
		int k =0;
		int x=0;
		for(int i =0;i<wzor.length();i++) {
			for(k=0;k<tekst.length();k++)
			if(wzor.charAt(i)==tekst.charAt(k)) {
				
				if(i==0) {
				literka.add(k);
				literka2.add(k);}
			
				else {
					
					for(int j = 0;j<literka.size();j++) {
					
						if (literka.get(j)-k==-1) {
													
							literka.set(j, literka.get(j)+1);

						}
						x++;
					}
				
						
				}

				
			}
			
		}
		for(int p=0;p<literka2.size();p++) {
			int y = literka.get(p)-literka2.get(p);
		if(literka.get(p)-literka2.get(p)==wzor.length()-1) {
		System.out.println("szukany wyzraz zaczyna się tutaj "+literka2.get(p));
		literka3.add(literka2.get(p));
		}
		}
	}
	public static ArrayList getPocz() {
		return literka3;
	
	}
}
