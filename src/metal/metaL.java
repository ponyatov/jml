package metal;

import java.util.Scanner;

import frame.Frame;
import frame.Num;
import frame.Str;
import frame.Sym;
import frame.Stack;
import frame.Dict;
//import frame.Symbol;
import frame.VM;
//import frame.Cmd;
import metal.Lexer;

/**
 * FORTH-like language vm
 * */
public class metaL extends VM {

    public metaL(String V) { super("metal", V);
		set("2.3",new Num(2.3));
		set(".", () -> {});//dropall() );
	}

	Scanner scanner = new Scanner(System.in);
	
	String cmdline = new String();
	
	Lexer lexer = new Lexer();
	
	boolean WORD() {
		Frame token = lexer.token();
		if (token==null) return false;
		push(token); return true;
	}
	
	public boolean FIND() {
		Frame token = pop();
		Frame found = get(token.val);
		if (found != null) { push(found); return  true; }
		else			   { push(token); return false; }
	}
	
	/** `EVAL ( xt -- )` execute top element as executable data */
	private void EVAL() {
		pop().eval(this);
	}

	public void INTERPRET() {
		lexer.input(pop().val);
		while (true) {
			if (!WORD()) break;
			if (top() instanceof Sym)
				if (FIND())
					System.out.println(top());
				EVAL();
		}
	}

	void REPL() {
		while (true) {
			System.out.println(this);
			System.out.print("\nok> "); cmdline = scanner.nextLine();
			push(new Str(cmdline));
			INTERPRET();
		}
	}

}
