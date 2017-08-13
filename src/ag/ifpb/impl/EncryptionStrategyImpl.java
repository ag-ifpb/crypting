package ag.ifpb.impl;

import ag.ifpb.EncryptionStrategy;

public abstract class EncryptionStrategyImpl extends EncryptionStrategy{
	
	private int typeByPosition(int index){
		String t = type().toString();
		System.out.println("      tipo#" + index + ": " + t.charAt(index));
		 if (t.charAt(index) == 'C'){
			 return 0;//Cesar
		 } else {
			 return 1;//DES
		 }
	}
	
	private String encByPosition(int index, int key, String text){
		if (typeByPosition(index) == 0){
			System.out.println("      chave#" + index + ": " + key);
			return cesarCipher.encript(key, text);
		} else {
			System.out.println("      chave#" + index + ": " + Integer.toHexString(key));
			return desCipher.encript(key, text);
		}
	}

	@Override
	protected String encrOne(int key, String text) {
		return encByPosition(0, key, text);
	}

	@Override
	protected String encrTwo(int key, String text) {
		return encByPosition(1, key, text);
	}

	@Override
	protected String encrThree(int key, String text) {
		return encByPosition(2, key, text);
	}
	
	public EncryptionStrategyImpl(CesarCipher cesarCipher, DESCipher desCipher) {
		super(cesarCipher, desCipher);
	}	

}
