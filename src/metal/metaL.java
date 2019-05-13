package metal;

import java.util.Scanner;

import frame.Strinq;
import frame.VM;

/**
 * FORTH-like language vm
 * */
public class metaL extends VM {

	public metaL(String V) { super("metal", V); }

	Scanner scanner = new Scanner(System.in);
	
	String cmdline = new String();
	
	Lexer lexer = new Lexer();
	
	boolean WORD() {
		lexer.token();
		return lexer.flag;
	}
	
	void INTERPRET() {
		lexer.input(this,pop().val);
		while (true) {
			if (!WORD()) break;
//			System.out.println(this);
		}
	}

	void REPL() {
		while (true) {
			System.out.println(this);
			System.out.print("\nok> "); cmdline = scanner.nextLine();
			this.push(new Strinq(cmdline));
			INTERPRET();
		}
	}

}
