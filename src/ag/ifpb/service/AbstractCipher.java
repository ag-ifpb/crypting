package ag.ifpb.service;

import ag.ifpb.service.impl.DecryptionException;
import ag.ifpb.service.impl.EncryptionException;

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
	 * @throws EncryptionException 
	 */
	String encript(int key, String text) throws EncryptionException;
	
	/**
	 * Descriptografa um texto 'text' de acordo com uma chave 'key'. 
	 * 
	 * @param key - chave na base 10
	 * @param encriptedText - texto a ser descriptografado
	 * @return texto descriptografado
	 * @throws DecryptionException 
	 */
	String decript(int key, String encriptedText) throws DecryptionException;

}
