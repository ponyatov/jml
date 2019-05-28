package frame;

/**
 * binary string
 * */
public class Bin extends Int {
	
	String str() { return Long.toBinaryString(val); }
	
	public Bin(String V) { super("bin",Long.parseLong(V,0x02)); } 

}
