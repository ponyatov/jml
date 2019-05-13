package metal;

public class Console {

	static metaL vm;

	public static void main(String args[]) {

		vm = new metaL("vm"); System.out.println(vm);
		
		vm.REPL();

	}
}
