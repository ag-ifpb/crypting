package ag.ifpb.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Searcher{
	private final StrategyFactory strategyFactory;
	
	private EncriptionType nextType(){
		int typeOrd = (int) (Math.random() * 6);
		return EncriptionType.values()[typeOrd];
	}
	
	private int[] nextKeys(EncriptionType type){
		//
		int[] result = new int[3];
		//
		switch (type) {
			case CCD:
				result[0] = genCesarKey();
				result[1] = genCesarKey();
				result[2] = genDESKey();
				break;
			case CDC:
				result[0] = genCesarKey();
				result[2] = genCesarKey();
				result[1] = genDESKey();
				break;
			case DCC:
				result[1] = genCesarKey();
				result[2] = genCesarKey();
				result[0] = genDESKey();
				break;
			case DDC:
				result[0] = genDESKey();
				result[1] = genDESKey();
				result[2] = genCesarKey();
				break;
			case DCD:
				result[0] = genDESKey();
				result[2] = genDESKey();
				result[1] = genCesarKey();
				break;
			case CDD:
				result[1] = genDESKey();
				result[2] = genDESKey();
				result[0] = genCesarKey();
				break;
		}
		//
		return result;
	}
	
	protected abstract int genCesarKey();
	
	protected abstract int genDESKey();
	
	public Searcher(StrategyFactory strategyFactory) {
		this.strategyFactory = strategyFactory;
	}
	
	public void start(String text){
		//setup - pode ser configurável
		int iterMax = 10000000;
		int threMax = 100;
		//criando um pool de threads fixo 
		ExecutorService service = Executors.newFixedThreadPool(threMax);
		//iniciado as tarefas
		for (int cnt = 0; cnt < iterMax; cnt++) {
			//
			EncriptionType type = nextType();
			int[] ks = nextKeys(type);
			//
			Strategy strategy = strategyFactory.strategy(type);
			//
			Worker worker = new Worker(strategy, ks, text);
			service.execute(worker);
		}
		//
		service.shutdown();
	}
	
}
