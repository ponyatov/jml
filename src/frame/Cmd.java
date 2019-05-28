package frame;

//import java.util.concurrent.Callable;
//import java.util.function.BiFunction;

/**
 * virtual machine command wraps VM Java method
 * */
public class Cmd extends Active {
	
	Runnable fn;

	public Cmd(String V, Runnable F) { super("cmd",V); fn=F; }
	public Cmd(String V) { super("cmd",V); }
	
	public void eval(Frame context) {
		fn.run();
	}

}
