package task3;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Реализация простейшего калькулятора.
 * 
 */
public class Calculator {
	static final String VALUE_REG = "(\\d+\\.?\\d*)";
	static final String PLUS_REG = "\\+";
	static final String MINUS_REG = "\\-";
	static final String MULTI_REG = "\\*";
	static final String DIV_REG = "\\/";
	static final DecimalFormat DFORMAT = new DecimalFormat("####.#");
	static Pattern pattern;
	static {

		StringBuilder builder = new StringBuilder();
		builder.append("^" + VALUE_REG);
		builder.append("(" + PLUS_REG + "|");
		builder.append(MINUS_REG + "|");
		builder.append(MULTI_REG + "|");
		builder.append(DIV_REG + "|" + ")");
		builder.append(VALUE_REG);
		pattern = Pattern.compile(builder.toString());
	}

	enum Operations {
		PLUS(PLUS_REG), MINUS(MINUS_REG), MULTI(MULTI_REG), DIV(DIV_REG);
		Operations(String str) {
			this.regExp = str;
		}

		String regExp;

		public String getRegExp() {
			return regExp;
		}

		static public Operations getOpration(String type) {
			for (Operations operation : Operations.values()) {
				if (operation.getRegExp().contains(type)) {
					return operation;
				}
			}
			throw new RuntimeException("unknown operation");
		}
	}

	/**
	 * Доступны четыре арифметических действия: сложение (+), умножение (*),
	 * деление (/) и вычитание (-).
	 * 
	 * @param string
	 *            строка вида [число][ариф. знак][число]
	 * @return результат операции
	 */
	public static String calculate(String string) {
		Matcher m = pattern.matcher(string);
		if (m.matches()) {
			double a = Double.valueOf(m.group(1));
			double b = Double.valueOf(m.group(3));
			Operations operation = Operations.getOpration(m.group(2));
			switch (operation) {
			case PLUS:
				return format(plus(a, b));
			case MINUS:
				return format(minus(a, b));
			case MULTI:
				return format(multi(a, b));
			case DIV:
				return format(div(a, b));
			default:
				break;
			}
		}
		return null;
	}

	private static String format(Double d) {
		return DFORMAT.format(d);
	}

	private static double plus(double a, double b) {
		return a + b;
	}

	private static double minus(double a, double b) {
		return a - b;
	}

	private static double multi(double a, double b) {
		return a * b;
	}

	private static double div(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Divide by zero.");
		}
		return a / b;
	}
}
