package ag.ifpb.service.impl;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import ag.ifpb.service.AbstractCipher;

public class DESCipher implements AbstractCipher {
	
	private SecretKey key(byte[] plaintext) throws NoSuchAlgorithmException, 
			InvalidKeySpecException, InvalidKeyException{
		//key
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.put(plaintext);
		buffer.put((byte)0);
		buffer.put((byte)0);
		//
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		DESKeySpec keySpec = new DESKeySpec(buffer.array());
		SecretKey secretKey = factory.generateSecret(keySpec);
		//
		return secretKey;
	}

	private String enc(SecretKey key, String text) throws NoSuchAlgorithmException, 
			NoSuchPaddingException, IllegalBlockSizeException, 
			BadPaddingException, InvalidKeyException{
		//
		Cipher cipher = Cipher.getInstance(key.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, key);
		//
		byte[] ciphered = cipher.doFinal(text.getBytes());
		//
		Encoder encoder = Base64.getEncoder();
		byte[] encoded = encoder.encode(ciphered);
		//
		return new String(encoded);
	}

	private static String dec(SecretKey key, String encriptedText) throws NoSuchAlgorithmException, 
		NoSuchPaddingException, IllegalBlockSizeException, IllegalArgumentException,
		BadPaddingException, InvalidKeyException{
		//
		Cipher cipher = Cipher.getInstance(key.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, key);
		//
		Decoder decoder = Base64.getDecoder();
		byte[] decoded = decoder.decode(encriptedText);
		//
		byte[] unciphered = cipher.doFinal(decoded);
		//
		return new String(unciphered);
	}

	@Override
	public String encript(int key, String text) throws EncryptionException {
		//
		SecretKey secretKey;
		try {
			String kb = Integer.toHexString(key);
			secretKey = key(kb.getBytes());
			String encrypted = enc(secretKey, text);
			return encrypted;
		} catch (InvalidKeyException | NoSuchAlgorithmException | 
				InvalidKeySpecException | NoSuchPaddingException | 
				IllegalBlockSizeException | BadPaddingException e) {
			throw new EncryptionException("Falha na criptografia. Causa: " + e.getMessage());
		}
	}

	@Override
	public String decript(int key, String encriptedText) throws DecryptionException {
		//
		SecretKey secretKey;
		try {
			//
			String kb = Integer.toHexString(key);
			secretKey = key(kb.getBytes());
			String encrypted = dec(secretKey, encriptedText);
			return encrypted;
		} catch (InvalidKeyException | NoSuchAlgorithmException | 
				InvalidKeySpecException | NoSuchPaddingException | 
				IllegalBlockSizeException | BadPaddingException | IllegalArgumentException e) {
			throw new DecryptionException("Falha na descriptografia. Causa: " + e.getMessage());
		}
	}

}
