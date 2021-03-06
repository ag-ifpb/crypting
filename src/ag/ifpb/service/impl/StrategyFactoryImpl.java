package ag.ifpb.service.impl;

import ag.ifpb.service.EncriptionType;
import ag.ifpb.service.Strategy;
import ag.ifpb.service.StrategyFactory;

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
