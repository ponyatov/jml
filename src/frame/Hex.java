package frame;

/**
 * hexadecimal machine number
 * */
public class Hex extends Int {
	
	@Override
	String str() { return Long.toHexString(val); }
	
	public Hex(String V) { super("hex",Long.parseLong(V,0x10)); } 

}
