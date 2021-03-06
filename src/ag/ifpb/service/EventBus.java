package ag.ifpb.service;

public class EventBus{
	private static final Object LOCK = new Object();

	public static void notifyResult(int[] keys, String result) {
		//
		String k0 = (keys[0] > 26 ? Integer.toHexString(keys[0]) : String.valueOf(keys[0]));
		String k1 = (keys[1] > 26 ? Integer.toHexString(keys[1]) : String.valueOf(keys[1]));
		String k2 = (keys[2] > 26 ? Integer.toHexString(keys[2]) : String.valueOf(keys[2]));
		//
		synchronized (LOCK) {
			System.out.println("============================================================");
			System.out.println(String.format("[%s,%s,%s] Resultado: %s", k0, k1, k2, result));
			System.out.println("============================================================");
		}
	}

	public static void notifyError(int[] keys) {
		//
//		String k0 = (keys[0] > 26 ? Integer.toHexString(keys[0]) : String.valueOf(keys[0]));
//		String k1 = (keys[1] > 26 ? Integer.toHexString(keys[1]) : String.valueOf(keys[1]));
//		String k2 = (keys[2] > 26 ? Integer.toHexString(keys[2]) : String.valueOf(keys[2]));
//		//
//		synchronized (LOCK) {
//			System.err.println(String.format("[%s,%s,%s] Resultado: ERROR", k0, k1, k2));
//		}
	}
}
