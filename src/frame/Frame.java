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
 * @author Dmitry Ponyatov <a href="mailto:dponyatov@gmail.com">dponyatov@gmail.com</a> CC BY-NC-ND
 */
public class Frame {

	
	/**
	 * class/type tag
	 */
	public String type;

	/**
	 * scalar value /implementation language type/
	 * */
	public String val;

	/**
	 * slots = attributes = associative array /string-keyed/
	 * */
	public Map<String, Frame> slot;

	/**
	 * nested elements = vector = stack
	 * */
	public List<Frame> nest;

	/**
	 * @param T define type/class tag on subclass objects creation
	 * @param V scalar value /implementation language type/
	 * */
	public Frame(String T, String V) {
		type = T;
		val  = V;
		slot = new HashMap<String, Frame>();
		nest = new ArrayList<Frame>();
	}

	public String toString() {
		return dump(0, "");
	}

	/**
	 * dump frame in full tree form
	 * */
	String dump(int depth, String prefix) {
		String tree = pad(depth) + head(prefix);
		for (Entry<String, Frame> i : slot.entrySet())
			tree += i.getValue().dump(depth+1, i.getKey() + " = ");
		for (Frame j:nest)
			tree += j.dump(depth+1, "");
		return tree;
	}

	/**
	 * dump in shortest header-only form
	 * */
	String head(String prefix) {
		return prefix + "<" + type + ":" + val + ">";
	}

	/**
	 * left-pad tree with cr+tabs
	 * */
	private String pad(int N) {
		return "\n" + String.join("", Collections.nCopies(N, "\t"));
	}

	public void push(Frame that) {
		nest.add(that);
	}

}
