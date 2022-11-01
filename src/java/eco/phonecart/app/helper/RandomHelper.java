package eco.phonecart.app.helper;

import java.util.Random;

public class RandomHelper {

	public static String getIntCode(int len) {

		String result = "";

		int max = (int) Math.pow(10, len) - 1;

		int code = new Random().nextInt(max);

		result = String.valueOf(code);

		for (int i = 0; i < len && len - result.length() != 0; i++) {
			result = "0" + result;
		}

		return result;
	}

	public static String getStringCode(int len, boolean uppper) {
		String result = "";
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			char c = (char) (r.nextInt(26) + 97);

			result += r.nextBoolean() || uppper ? String.valueOf(c).toUpperCase() : String.valueOf(c);

		}

		return result;
	}

	public static String getCode(int len, boolean upper) {
		String result = "";

		Random r = new Random();

		for (int i = 0; i < len; i++) {
			result += r.nextBoolean() ? getIntCode(1) : getStringCode(1, upper);
		}

		return result;

	}


}
