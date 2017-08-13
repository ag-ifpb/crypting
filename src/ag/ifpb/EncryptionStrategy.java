package ag.ifpb;

import ag.ifpb.impl.CesarCipher;
import ag.ifpb.impl.DESCipher;

/**
 * Funciona como um encriptador de acordo com uma 
 * estratégia de criptografia específica
 * 
 * @author arigarcia
 *
 */
public abstract class EncryptionStrategy {
	protected final CesarCipher cesarCipher;
	protected final DESCipher desCipher;
	
	protected abstract String encrOne(int key, String text);
	protected abstract String encrTwo(int key, String text);
	protected abstract String encrThree(int key, String text);
	protected abstract EncriptionType type();
	
	public EncryptionStrategy(CesarCipher cesarCipher, DESCipher desCipher) {
		this.cesarCipher = cesarCipher;
		this.desCipher = desCipher;
	}
	
	public String encrypt(int[] key, String text){
		//
		if (key.length != 3) {
			throw new IllegalArgumentException("Devem haver 3 chaves de acordo com sua estratégia");
		}
		//
		System.out.println("      --------------------------");
		String encrpted0 = encrOne(key[0], text);
		System.out.println("      result#0: " + encrpted0);
		System.out.println("      -------------------------");
		String encrpted1 = encrTwo(key[1], encrpted0);
		System.out.println("      result#1: " + encrpted1);
		System.out.println("      -------------------------");
		String encrpted2 = encrThree(key[2], encrpted1);
		System.out.println("      result#2: " + encrpted2);
		System.out.println("      -------------------------");
		return encrpted2;
	}
}
