package ag.ifpb.service;

import ag.ifpb.service.impl.CesarCipher;
import ag.ifpb.service.impl.DESCipher;
import ag.ifpb.service.impl.DecryptionException;
import ag.ifpb.service.impl.EncryptionException;

/**
 * Funciona como um encriptador de acordo com uma 
 * estratégia de criptografia específica
 * 
 * @author arigarcia
 *
 */
public abstract class Strategy {
	protected final CesarCipher cesarCipher;
	protected final DESCipher desCipher;
	
	protected abstract String encrOne(int key, String text) throws EncryptionException;
	protected abstract String encrTwo(int key, String text) throws EncryptionException;
	protected abstract String encrThree(int key, String text) throws EncryptionException;
	protected abstract String decrOne(int key, String text) throws DecryptionException;
	protected abstract String decrTwo(int key, String text) throws DecryptionException;
	protected abstract String decrThree(int key, String text) throws DecryptionException;
	protected abstract EncriptionType type();
	
	public Strategy(CesarCipher cesarCipher, DESCipher desCipher) {
		this.cesarCipher = cesarCipher;
		this.desCipher = desCipher;
	}
	
	public String encrypt(int[] key, String text) throws EncryptionException{
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
	
	public String decrypt(int[] key, String text) throws DecryptionException{
		//
		if (key.length != 3) {
			throw new IllegalArgumentException("Devem haver 3 chaves de acordo com sua estratégia");
		}
		//
		System.out.println("      --------------------------");
		String decrpted2 = decrThree(key[2], text);
		System.out.println("      result#2: " + decrpted2);
		System.out.println("      -------------------------");
		String decrpted1 = decrTwo(key[1], decrpted2);
		System.out.println("      result#1: " + decrpted1);
		System.out.println("      -------------------------");
		String decrpted0 = decrOne(key[0], decrpted1);
		System.out.println("      result#0: " + decrpted0);
		System.out.println("      -------------------------");
		return decrpted0;
	}
}
