package ag.ifpb.service;

/**
 * Fábrica de Decriptadores que se baseiam em um tipo 
 * de estratégia de criptografia
 * 
 * @author arigarcia
 *
 */
public interface DecrypterFactory {
	
	/**
	 * Recupera um objeto de decriptografia baseado
	 * na estratégia type
	 * 
	 * @param type
	 * @return
	 */
	Strategy strategy(EncriptionType type);
	
}
