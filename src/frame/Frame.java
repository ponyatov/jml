package frame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Marvin Minsky frame model base class
 * extended with nest[]ed elements for attribute grammar and AST processing
 */
public class Frame {

	
	/**
	 * class/type tag
	 */
	String type;

	/**
	 * scalar value /implementation language type/
	 * */
	String val;

	/**
	 * 
	 * */
	Map<String, Frame> slot;

	List<Frame> nest;

	public Frame(String T, String V) {
		type = T;
		val  = V;
		slot = new HashMap<String, Frame>();
		nest = new ArrayList<Frame>();
	}

	public String toString() {
		return dump(0, "");
	}

	String dump(int depth, String prefix) {
		String tree = pad(depth) + head(prefix);
		for (Entry<String, Frame> i : slot.entrySet())
			tree += i.getValue().dump(depth+1, i.getKey() + " = ");
		for (Frame j:nest)
			tree += j.dump(depth+1, "");
		return tree;
	}

	private String pad(int N) {
		return "\n" + String.join("", Collections.nCopies(N, "\t"));
	}

	String head(String prefix) {
		return prefix + "<" + type + ":" + val + ">";
	}

	public void push(Frame that) {
		nest.add(that);
	}

}
