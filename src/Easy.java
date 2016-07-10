import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Easy {

	public static void main(String[] args) throws IOException {
		genEvol("Hello, world!");
	}
	
	public static void easy274() throws IOException {
		File indDec = new File("indec.txt");
		Scanner kb = new Scanner(indDec);
		ArrayList<String> dec = new ArrayList<String>();
		while(kb.hasNext())
			dec.add(kb.next());
		File beale = new File("beale.txt");
		kb.close();
		kb = new Scanner(beale);
		ArrayList<String> dhold = new ArrayList<String>();
		while(kb.hasNext())
			dhold.add(kb.next());
		ArrayList<String> holder = new ArrayList<String>();
		for(String k : dhold) {
			k = k.substring(0, k.length() -1);
			int i = Integer.parseInt(k);
			holder.add(dec.get((i - 1) % 1322));
		}
		kb.close();
		String fin = "";
		for(int i = 0; i < holder.size(); i++)
			fin = fin + holder.get(i).substring(0,1);
		System.out.println(fin);
	}

	
	public static void genEvol(String str) {
		String org = "";
		for(int i = 0; i < str.length(); i++) 
			org = org + (char)(Math.random() * 95 + 32);
		int cnt = 1;
		int fitness = 0;
		int prevfit = 1;
		int pos = -1;
		while(org.length() == str.length() && !org.equals(str)) {
			while(org.length() == str.length() && fitness < prevfit) {
				fitness = 0;
				pos = (int)(Math.random() * (org.length()));
				org = org.substring(0, pos) + (char)(Math.random() * 95 + 32) + org.substring(pos + 1);
				char[] orgarr = org.toCharArray();
				char[] strarr = str.toCharArray();
				for(int i = 0; i < orgarr.length; i++) {
					if(orgarr[i] != strarr[i])
						fitness++;
				}
			}
			prevfit = fitness + 1;
			System.out.println("Generation: " + cnt + " | Fitness: " + fitness + " | Phrase: " + org);
		}
	}
}
