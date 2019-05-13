package metal;

import java.util.Scanner;

//import frame.Strinq;
import frame.VM;

/**
 * FORTH-like language vm
 * */
public class metaL extends VM {

	public metaL(String V) { super("metal", V); }

	Scanner scanner = new Scanner(System.in);
	
	String cmdline = new String();

	public void REPL() {
		while (true) {
			System.out.println(this);
			System.out.print("\nok> ");
			cmdline = scanner.nextLine();
			Lexer.parse(this,cmdline);
		}
	}
	
	

}
