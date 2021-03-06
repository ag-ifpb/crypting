import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import ag.ifpb.service.impl.CesarCipher;


public class CesarCrypter {

	public static void main(String[] args) throws NoSuchAlgorithmException, 
			InvalidKeySpecException, NoSuchPaddingException, 
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
		//
		CesarCipher cipher = new CesarCipher();
		String encrypted = cipher.encript(18, "Testando cesar".toLowerCase());
		String decrypted = cipher.decript(18, encrypted);
		//
		System.out.println("Texto criptografado: " + encrypted);
		System.out.println("Texto descriptografado: " + decrypted);
	}
	
}
