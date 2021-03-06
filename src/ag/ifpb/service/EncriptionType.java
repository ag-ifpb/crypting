package ag.ifpb.service;

/**
 * Tipos de estratégias de criptografia
 * possíveis. 
 * 
 * @author arigarcia
 *
 */
public enum EncriptionType {
	CCD, //Cesar-Cesar-DES
	CDC, //Cesar-DES-Cesar 
	DCC, //DES-Cesar-Cesar
	DDC, //DES-DES-Cesar
	DCD, //DES-Cesar-DES 
	CDD  //Cesar-DES-DES
;

	public static EncriptionType convert(String type) {
		return EncriptionType.valueOf(type.toUpperCase());
	}
}