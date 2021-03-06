
public class TypeMatch {

	public static void main(String[] args) {
		String[] texts = new String[]{
				"ccd",
				"cdc",
				"dcc",
				"ddc",
				"dcd",
				"cdd",
				"ccc",
				"ddd",
				"cdcd",
				"cda"
		};
		for (String t : texts) {
			System.out.println(t.matches("^(?!ccc)(?!ddd)[cd]{3}$"));
		}
	}
}
