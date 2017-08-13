package ag.ifpb.impl;

import ag.ifpb.EncriptionType;
import ag.ifpb.EncrypterFactory;
import ag.ifpb.EncryptionStrategy;

public class EncrypterFactoryImpl implements EncrypterFactory {

	@Override
	public EncryptionStrategy strategy(final EncriptionType type) {
		//
		System.out.println("Estratégia selecionada: " + type);
		//
		CesarCipher cesarCipher = new CesarCipher();
		DESCipher desCipher = new DESCipher();
		EncryptionStrategy strategy = new EncryptionStrategyImpl(cesarCipher, desCipher) {
			@Override
			protected EncriptionType type() {
				return type;
			}
		};
		return strategy;
	}

}