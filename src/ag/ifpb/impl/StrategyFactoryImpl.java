package ag.ifpb.impl;

import ag.ifpb.EncriptionType;
import ag.ifpb.StrategyFactory;
import ag.ifpb.Strategy;

public class StrategyFactoryImpl implements StrategyFactory {

	@Override
	public Strategy strategy(final EncriptionType type) {
		//
		System.out.println("Estratégia selecionada: " + type);
		//
		CesarCipher cesarCipher = new CesarCipher();
		DESCipher desCipher = new DESCipher();
		Strategy strategy = new StrategyImpl(cesarCipher, desCipher) {
			@Override
			protected EncriptionType type() {
				return type;
			}
		};
		return strategy;
	}

}