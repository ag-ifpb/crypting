import java.math.BigInteger;
import java.nio.ByteBuffer;

public class HexRandom {

	public static void main(String[] args) {
		int value0 = (int) (Math.random() * 16);
		int value1 = (int) (Math.random() * 16);
		//
		System.out.println("value0: " + value0);
		System.out.println("value1: " + value1);
		//
		System.out.println(Integer.toHexString(value0));
		System.out.println(Integer.toHexString(value1));
		//
		StringBuffer buffer = new StringBuffer();
		buffer.append(Integer.toHexString(value0));
		buffer.append(Integer.toHexString(value1));
		//
		BigInteger bigInteger = new BigInteger(buffer.toString(), 16);
		System.out.println(bigInteger.toString(16));
	}
}
