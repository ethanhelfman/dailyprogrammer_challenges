import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Intermediate {

	public static void main(String[] args) throws IOException {
		
	}
	
	public static void two76() throws IOException {
		File fl = new File("elements.txt");
		Scanner kb = new Scanner(fl);
		ArrayList<String> elenames = new ArrayList<String>();
		ArrayList<String> elesym = new ArrayList<String>();
		while(kb.hasNext())
			elenames.add(kb.next());
		elesym.add("");
		for(String name : elenames) {
			String sym = "";
			int pos1 = 0;
			int pos2 = 1;
			while(elesym.contains(sym)) {
				if(pos2 >= name.length()) {
					pos1++;
					pos2 = pos1 + 1;
				}
				sym = name.charAt(pos1) + "" + name.charAt(pos2);
				pos2++;
			}
			elesym.add(sym);
		}
		elesym.remove("");
		System.out.println("All element names up to the un-nameable one: " + elesym);
		kb.close();
	}

}
