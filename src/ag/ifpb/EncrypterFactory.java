package ag.ifpb;

/**
 * Fábrica de Encriptadores que se baseiam em um tipo 
 * de estratégia de criptografia
 * 
 * @author arigarcia
 *
 */
public interface EncrypterFactory {
	
	/**
	 * Recupera um objeto de criptografia baseado
	 * na estratégia type
	 * 
	 * @param type
	 * @return
	 */
	EncryptionStrategy strategy(EncriptionType type);
	
}
