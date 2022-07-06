package finite_transducer;

import java.util.HashMap;
import java.util.Map;

public class Transducer {
	/**
	 * Estados do Transdutor Finito (Maquina de Mealy)
	 */
	private Map<Integer, State> states;
	private Converter c0;
	private Converter c1;
	private Converter c2;
	private Converter c3;
	private Converter c4;
	
	/**
	 * Constructor
	 */
	public Transducer() {
		states = new HashMap<>();
		
		State q0 = new State(true);
		c0 = new Converter();
		q0.addTransition('a', 1);		
		q0.addTransition('b', 2);		
		q0.addTransition('c', 4);		
		q0.addTransition('$', 0);
		states.put(0, q0);
		c0.addValues('a', 0);
		c0.addValues('b', 0);
		c0.addValues('c', 1);
		
		State q1 = new State(true);
		c1 = new Converter();
		q1.addTransition('c', 1);
		q1.addTransition('a', 2);
		q1.addTransition('b', 3);
		q1.addTransition('$', 1);
		states.put(1, q1);
		c1.addValues('c', 1);
		c1.addValues('a', 0);
		c1.addValues('b', 0);
		
		State q2 = new State(true);
		c2 = new Converter();
		q2.addTransition('c', 2);
		q2.addTransition('a', 3);
		q2.addTransition('b', 4);
		q2.addTransition('$', 2);
		states.put(2, q2);
		c2.addValues('c', 1);
		c2.addValues('a', 0);
		c2.addValues('b', 1);
		
		State q3 = new State(true);
		c3 = new Converter();
		q3.addTransition('c', 3);
		q3.addTransition('b', 1);
		q3.addTransition('a', 4);
		q3.addTransition('$', 3);
		states.put(3, q3);
		c3.addValues('c', 1);
		c3.addValues('b', 1);
		c3.addValues('a', 1);
		
		
		State q4 = new State(true);
		c4 = new Converter();
		q4.addTransition('c', 4);
		q4.addTransition('a', 1);
		q4.addTransition('b', 2);
		q4.addTransition('$', 4);
		states.put(4, q4);
		c4.addValues('c', 1);
		c4.addValues('a', 0);
		c4.addValues('b', 0);

	}

	/**
	 * Formatar o estado para impressao
	 *
	 * @param state estado
	 * @return estado formatado para impressao
	 */
	// VERSÃO PARA O USUÁRIO DIGITAR A ENTRADA
	private String formatState(Integer state) {
	
		if((states.size() < 100) && (state < 10)) {
			return "\nq" + state + "  - ";
		}
		
		return "\nq" + state + " - ";
	}
	
	/**
	 * Reconhecer a sentenca de entrada
	 *
	 * @param sentence sentenca de entrada
	 * @return true caso a sentenca de entrada pertenca a linguagem,
	 *   false em caso contrario
	 */
	public boolean recognize(String sentence) {
	
		// VERSÃO PARA O USUÁRIO DIGITAR A ENTRADA
		String input = sentence + "$";
		
		System.out.print("Observação: \"$\" representa o fim da sentença");
		
		Integer state = 0;
		String output = "";
		
		for(int symbol = 0; symbol < input.length(); symbol++) {
			System.out.print(formatState(state));
	
			for(int i = 0; i < input.length(); i++)	{
				if(i != symbol)	{
					System.out.print(" " + input.charAt(i) + " ");
				} else {
				System.out.print("[" + input.charAt(i) + "]");
				}
			}
			if (state == 0) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c0.getValue(input.charAt(symbol));
				}
			} else if (state == 1) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c1.getValue(input.charAt(symbol));
				}
			} else if (state == 2) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c2.getValue(input.charAt(symbol));
				}
			} else if (state == 3) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c3.getValue(input.charAt(symbol));
				}
			} else if (state == 4) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c4.getValue(input.charAt(symbol));
				}
			}
	
			if(state == null) {
				if(sentence.isEmpty()) {
					sentence = "{ }";
				}
				System.out.println(" - REJEITA");
				return false;
			}
		}
		
	
		if(states.get(state).isAccept()) {
			System.out.println("Resultado: " + output);
		} else {
			System.out.println(" - REJEITA");
		}
		
		return states.get(state).isAccept();
	
		// VERSÃO PARA ENTRADAS PREVIAMENTE INSERIDAS
		/*String input = sentence + "$";
		Integer state = 0;
		String output = "";
	
		for(int symbol = 0; symbol < input.length(); symbol++) {

			if (state == 0) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c0.getValue(input.charAt(symbol));
				}
			} else if (state == 1) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c1.getValue(input.charAt(symbol));
				}
			} else if (state == 2) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c2.getValue(input.charAt(symbol));
				}
			} else if (state == 3) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c3.getValue(input.charAt(symbol));
				}
			} else if (state == 4) {
				state = states.get(state).getTransition(input.charAt(symbol));
				if (input.charAt(symbol) != '$') {
					output = output + c4.getValue(input.charAt(symbol));
				}
			}
			
		}
	
		System.out.print(sentence);
	
		if(states.get(state).isAccept()) {
			System.out.println(" - " + output);
		} else {
			System.out.println(" - REJEITA");
		}
	
		return states.get(state).isAccept();*/
	}
}
