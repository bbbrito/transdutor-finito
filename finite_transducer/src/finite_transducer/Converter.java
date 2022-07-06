package finite_transducer;

import java.util.HashMap;
import java.util.Map;

public class Converter {
	private Map<Character, Integer> values;
	
	/**
	 * Constructor
	 *
	 * @param accept estado eh de aceitacao
	 */
	public Converter() {
		values = new HashMap<>();
	}

	/**
	 * Adicionar um valor para conversao
	 *
	 * @param symbol simbolo corrente
	 * @param value valor do novo estado
	 */
	public void addValues(Character symbol, Integer value) {
		values.put(symbol, value);
	}

	/**
	 * Retornar o valor novo estado
	 *
	 * @param symbol simbolo corrente
	 * @return novo estado
	 */
	public Integer getValue(Character symbol) {
		return values.get(symbol);
	}
}
