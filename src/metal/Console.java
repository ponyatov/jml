package metal;

public class Console {

	static metaL vm = new metaL("vm");

	public static void main(String args[]) {
		
		vm.push(new frame.Str("# put your commands here"));
		vm.INTERPRET();
		vm.push(new frame.Str(" +01 -02.30 4e-5 . 0xDeadBeef 0b1101"));
		vm.INTERPRET();

		vm.REPL();

	}
}
