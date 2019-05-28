package frame;

/**
 * number
 * */
public class Num extends Prim {
	
	public Num(String T,String V) { super(T,V); }

	double val;

	String str() { return ""+val; }

	public Num(double D) { super("num",null); val = D; 					   }
	public Num(String V) { super("num",V   ); val = Double.parseDouble(V); }
	
}
