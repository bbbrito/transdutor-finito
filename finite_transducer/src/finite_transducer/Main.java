package finite_transducer;

import java.util.Scanner;

public class Main {
	/**
	 * Constructor
	 */
	private Main() {

	}

	public static void main(String[] args) {
		// VERSÃO PARA O USUÁRIO DIGITAR A ENTRADA
		Scanner scanner = new Scanner(System.in);

		System.out.print("Analise a sentença: ");
		String sentence = scanner.nextLine().trim();

		scanner.close();
		
		if(sentence.indexOf("$") >= 0) {
			System.out.println("A sentença \"" + sentence + "\" é inválida");
			return;
	    }
		
		Transducer tdc = new Transducer();
		tdc.recognize(sentence);
		
		// VERSÃO PARA ENTRADAS PREVIAMENTE INSERIDAS
		/*Transducer tdc = new Transducer();
		
		String sentences[] = {"c", "cc", "aaa", "aaaa", "ccc", "aaaaaaaaa", "baa", "bbb", "bbbab",
						"aabbab", "bcb", "bca", "bccaa", "bcbbaaab", "bcbbaaaba", "aaacbb", "aaacbbb", "aaacbba",
						"aaacbbaaaaa", "babab", "baaabbb", "baaabbbb", "baaabbba", "baaabbbbb", "baaabbbbbb",
						"baaabbbbba", "babcabc"};
		
		for (String sentence : sentences) {
			if(sentence.indexOf("$") >= 0) {
				System.out.println("A sentença \"" + sentence + "\" é inválida");
				return;
			}
			tdc.recognize(sentence);
		}*/
	}

}
