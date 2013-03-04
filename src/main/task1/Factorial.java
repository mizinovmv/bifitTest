package task1;

import java.util.HashMap;
import java.util.Map;
/**
 * Расчет факториала.
 *
 */
public class Factorial {

	static Map<Integer, Integer> numCache = new HashMap<Integer, Integer>();

	/**
	 * Расчет факториала. На вход программе подается число, на выходе факториал
	 * этого числа.
	 * 
	 * @param num
	 *            число
	 * @return факториал числа
	 */
	public static int calculate(int num) {
		if (num == 0) {
			return 1;
		}
		Integer result = null;
		if ((result = numCache.get(num)) != null) {
			return result;
		}
		result = num * calculate(num - 1);
		return result;
	}
}
