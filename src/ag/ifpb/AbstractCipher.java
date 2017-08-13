package ag.ifpb;


/**
 * Criptograma 
 * 
 * @author arigarcia
 *
 */
public interface AbstractCipher {
	
	/**
	 * Criptografa um texto 'text' de acordo com uma chave 'key'. 
	 * 
	 * @param key - chave na base 10
	 * @param text - texto a ser criptografado
	 * @return texto criptografado
	 */
	String encript(int key, String text);
	
	/**
	 * Descriptografa um texto 'text' de acordo com uma chave 'key'. 
	 * 
	 * @param key - chave na base 10
	 * @param encriptedText - texto a ser descriptografado
	 * @return texto descriptografado
	 */
	String decript(int key, String encriptedText);

}
