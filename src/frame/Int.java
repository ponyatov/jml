package frame;

/**
 * integer
 * */
public class Int extends Num {
	
	public Int(String T,String V) { super(T,V); } 
	
	long val;
	
	String str() { return Long.toString(val); }

	public Int(long N)   { super("int",null); val = N; 					 }
	public Int(String V) { super("int",V   ); val = Integer.parseInt(V); }
	
	/**
	 * transient constuctor used by Hex/Bin
	 * */
	public Int(String T,long N) { super(T,null); val = N; }

}
