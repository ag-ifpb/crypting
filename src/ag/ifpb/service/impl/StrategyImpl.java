package ag.ifpb.service.impl;

import ag.ifpb.service.Strategy;

public abstract class StrategyImpl extends Strategy{
	
	private int typeByPosition(int index){
		String t = type().toString();
		System.out.println("      tipo#" + index + ": " + t.charAt(index));
		 if (t.charAt(index) == 'C'){
			 return 0;//Cesar
		 } else {
			 return 1;//DES
		 }
	}
	
	private String encByPosition(int index, int key, String text) throws EncryptionException{
		if (typeByPosition(index) == 0){
			System.out.println("      chave#" + index + ": " + key);
			return cesarCipher.encript(key, text);
		} else {
			System.out.println("      chave#" + index + ": " + Integer.toHexString(key));
			return desCipher.encript(key, text);
		}
	}
	
	private String decByPosition(int index, int key, String text) throws DecryptionException{
		if (typeByPosition(index) == 0){
			System.out.println("      chave#" + index + ": " + key);
			return cesarCipher.decript(key, text);
		} else {
			System.out.println("      chave#" + index + ": " + Integer.toHexString(key));
			return desCipher.decript(key, text);
		}
	}

	@Override
	protected String encrOne(int key, String text) throws EncryptionException {
		return encByPosition(0, key, text);
	}

	@Override
	protected String encrTwo(int key, String text) throws EncryptionException {
		return encByPosition(1, key, text);
	}

	@Override
	protected String encrThree(int key, String text) throws EncryptionException {
		return encByPosition(2, key, text);
	}
	
	@Override
	protected String decrOne(int key, String text) throws DecryptionException {
		return decByPosition(0, key, text);
	}
	
	@Override
	protected String decrTwo(int key, String text) throws DecryptionException {
		return decByPosition(1, key, text);
	}
	
	@Override
	protected String decrThree(int key, String text) throws DecryptionException {
		return decByPosition(2, key, text);
	}

	public StrategyImpl(CesarCipher cesarCipher, DESCipher desCipher) {
		super(cesarCipher, desCipher);
	}	

}
