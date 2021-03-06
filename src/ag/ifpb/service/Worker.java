package ag.ifpb.service;

import ag.ifpb.service.impl.DecryptionException;

public class Worker implements Runnable {
	private final Strategy strategy;
	private final int[] keys;
	private final String text;
	
	public Worker(Strategy strategy, int[] ks, String text) {
		this.strategy = strategy;
		this.keys = ks;
		this.text = text;
	}

	@Override
	public void run() {
		try {
			String result = strategy.decrypt(keys, text);
			EventBus.notifyResult(keys, result);
		} catch (DecryptionException e) {
			EventBus.notifyError(keys);
		}
	}

}
