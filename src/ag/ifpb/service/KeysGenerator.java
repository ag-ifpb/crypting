package ag.ifpb.service;

import java.util.Random;

public class KeysGenerator {
	private final int iter;
	private final int size;
	private final int kmax;
	private final int[][] keys;
	
	private void fill(){
		Random random = new Random();
		for (int i = 0; i < iter; i++){
			for (int j = 0; j < size; j++){
				int k = 0;
				while (k <= 1){
					k = random.nextInt(kmax);
				}
				keys[i][j] = k;
			}
		}
	}
	
	public KeysGenerator(int iter, int size, int keymax) {
		this.iter = iter;
		this.size = size;
		this.kmax = keymax;
		this.keys = new int[iter][size];
		fill();
	}
	
	public int[][] keys(){
		return keys;
	}

}
