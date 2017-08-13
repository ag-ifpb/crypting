import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import ag.ifpb.impl.DESCipher;


public class DESCrypter {
	
	

	public static void main(String[] args) throws NoSuchAlgorithmException, 
			InvalidKeySpecException, NoSuchPaddingException, 
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
		//
		DESCipher cipher = new DESCipher();
		String encrypted = cipher.encript(123456, "E ai galerinha! Vamos tentar decriptografar?");
		String decrypted = cipher.decript(123456, encrypted);
		//
		System.out.println("Texto criptografado: " + encrypted);
		System.out.println("Texto descriptografado: " + decrypted);
	}
}