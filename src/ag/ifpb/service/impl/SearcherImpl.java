package ag.ifpb.service.impl;

import java.math.BigInteger;

import ag.ifpb.service.Searcher;
import ag.ifpb.service.StrategyFactory;

public class SearcherImpl extends Searcher {

	@Override
	protected int genCesarKey() {
		int sum = (int) (Math.random()*8);
		return 18 + sum;//sum in [0, 7]
	}

	@Override
	protected int genDESKey() {
		//
		int value0 = (int) (Math.random() * 16);
		int value1 = (int) (Math.random() * 16);
		int value2 = (int) (Math.random() * 16);
		int value3 = (int) (Math.random() * 16);
		int value4 = (int) (Math.random() * 16);
		int value5 = (int) (Math.random() * 16);
		//
		StringBuffer buffer = new StringBuffer();
		buffer.append(Integer.toHexString(value0));
		buffer.append(Integer.toHexString(value1));
		buffer.append(Integer.toHexString(value2));
		buffer.append(Integer.toHexString(value3));
		buffer.append(Integer.toHexString(value4));
		buffer.append(Integer.toHexString(value5));
		//
		BigInteger bigInteger = new BigInteger(buffer.toString(), 16);
		return bigInteger.intValue();
	}
	
	public SearcherImpl(StrategyFactory strategyFactory) {
		super(strategyFactory);
	}

}
