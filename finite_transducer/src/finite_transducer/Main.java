package finite_transducer;

import java.util.Scanner;

public class Main {
	/**
	 * Constructor
	 */
	private Main() {

	}

	public static void main(String[] args) {
		// VERS�O PARA O USU�RIO DIGITAR A ENTRADA
		Scanner scanner = new Scanner(System.in);

		System.out.print("Analise a senten�a: ");
		String sentence = scanner.nextLine().trim();

		scanner.close();
		
		if(sentence.indexOf("$") >= 0) {
			System.out.println("A senten�a \"" + sentence + "\" � inv�lida");
			return;
	    }
		
		Transducer tdc = new Transducer();
		tdc.recognize(sentence);
		
		// VERS�O PARA ENTRADAS PREVIAMENTE INSERIDAS
		/*Transducer tdc = new Transducer();
		
		String sentences[] = {"c", "cc", "aaa", "aaaa", "ccc", "aaaaaaaaa", "baa", "bbb", "bbbab",
						"aabbab", "bcb", "bca", "bccaa", "bcbbaaab", "bcbbaaaba", "aaacbb", "aaacbbb", "aaacbba",
						"aaacbbaaaaa", "babab", "baaabbb", "baaabbbb", "baaabbba", "baaabbbbb", "baaabbbbbb",
						"baaabbbbba", "babcabc"};
		
		for (String sentence : sentences) {
			if(sentence.indexOf("$") >= 0) {
				System.out.println("A senten�a \"" + sentence + "\" � inv�lida");
				return;
			}
			tdc.recognize(sentence);
		}*/
	}

}
