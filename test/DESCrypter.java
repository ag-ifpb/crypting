import ag.ifpb.service.impl.DESCipher;
import ag.ifpb.service.impl.DecryptionException;
import ag.ifpb.service.impl.EncryptionException;


public class DESCrypter {
	
	

	public static void main(String[] args) throws EncryptionException, DecryptionException  {
		//
		DESCipher cipher = new DESCipher();
		String encrypted = cipher.encript(123456, "E ai galerinha! Vamos tentar decriptografar?");
		String decrypted = cipher.decript(123456, encrypted);
		//
		System.out.println("Texto criptografado: " + encrypted);
		System.out.println("Texto descriptografado: " + decrypted);
	}
}
