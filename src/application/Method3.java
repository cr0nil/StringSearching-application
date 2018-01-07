package application;

import java.util.ArrayList;

public class Method3 {
	public Method3() {
		
	}

	public static void szukaj(String wzor,String tekst) {
		ArrayList<Integer> literka = new ArrayList<Integer>();
		ArrayList<Integer> literka2 = new ArrayList<Integer>();
		
		
//		String wzor = "ala";
//		String tekst = "ala ma kota magicala";
		int k =0;
		int x=0;
		for(int i =0;i<wzor.length();i++) {
			for(k=0;k<tekst.length();k++)
			if(wzor.charAt(i)==tekst.charAt(k)) {
				//System.out.println("jest"+k);
				if(i==0) {
				literka.add(k);
				literka2.add(k);
				System.out.println(k+"  ");}
				else {
					//System.out.println(literka);
					for(int j = 0;j<literka.size();j++) {
					
						if (literka.get(j)-k==-1) {
							//System.out.println(tekst.charAt(k));
							//System.out.println("tu jest ma"+literka.get(j)+" "+tekst.charAt(literka.get(j)));
							//literka2.add
							
							literka.set(j, literka.get(j)+1);
//							literka.clear();
							
							//add to array
						}
						x++;
					}
				
						
				}
//				else {
//					
//				}
				//k=tekst.indexOf(tekst.charAt(k));
				
			}
			
		}
		for(int p=0;p<literka2.size();p++) {
			int y = literka.get(p)-literka2.get(p);
		if(literka.get(p)-literka2.get(p)==wzor.length()-1)
		System.out.println("szukany wyzraz zaczyna się tutaj "+literka2.get(p));
		}
	}
}
