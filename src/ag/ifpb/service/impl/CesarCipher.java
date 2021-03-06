package ag.ifpb.service.impl;

import ag.ifpb.service.AbstractCipher;

public class CesarCipher implements AbstractCipher {
	char[] chrs = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',	
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	private char[] moved(int k){
		char[] c3 = new char[26];
		//popular c3-1
		int p = 0; 
		for (int i = k; i < 26; i++){
			p = i - k; 
			c3[p] = chrs[i];
		}
		//popular c3-2
		for (int i = 0; i < k; i++){
			p++;
			c3[p] = chrs[i];
		}
		return c3;
	}
	
	private int getIndex(char[] cs, char c){
		int index = -1;
		for (int i = 0; i < 26; i++){
			if (String.valueOf(c).equals(String.valueOf(cs[i]))){
				index = i;
				break;
			}
		}
		return index;
	}
	
	private String enc(int key, String text){
		// Variavel que ira guardar o texto crifrado
		StringBuilder sb = new StringBuilder();
		// Variavel com tamanho do texto a ser encriptado
		int size = text.length();	       
		//mover caracteres
		char[] newChars = moved(key);
		// Criptografa cada caracter por vez
		for(int c=0; c < size; c++){
			//
			char v = text.charAt(c);
			boolean isUpperCase = Character.isUpperCase(v);
			// Transforma o caracter em codigo ASCII e faz a criptografia
			int index = getIndex(chrs,  Character.toLowerCase(v));
			// Transforma codigo ASCII criptografado em caracter ao novo texto
			if (index != -1){
				sb.append(isUpperCase ? Character.toUpperCase(newChars[index]) : newChars[index]);
			} else {
				sb.append(v);
			}
		}
		// Por fim retorna a mensagem criptografada por completo
		return sb.toString();
	}
	
	private String dec(int key, String text){
		// Variavel que ira guardar o texto crifrado
		StringBuilder sb = new StringBuilder();
		// Variavel com tamanho do texto a ser encriptado
		int size = text.length();	       
		//mover caracteres
		char[] newChars = moved(key);
		// Criptografa cada caracter por vez
		for(int c=0; c < size; c++){
			//
			char v = text.charAt(c);
			boolean isUpperCase = Character.isUpperCase(v);
			// Transforma o caracter em codigo ASCII e faz a criptografia
			int index = getIndex(newChars, Character.toLowerCase(v));
			// Transforma codigo ASCII criptografado em caracter ao novo texto
			if (index != -1){
				sb.append(isUpperCase ? Character.toUpperCase(chrs[index]):chrs[index]);
			} else {
				sb.append(v);
			}
		}
		// Por fim retorna a mensagem criptografada por completo
		return sb.toString();
	}

	@Override
	public String encript(int key, String text) {
		return enc(key, text);
	}

	@Override
	public String decript(int key, String encriptedText) {
		return dec(key, encriptedText);
	}

}

