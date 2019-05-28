package frame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.concurrent.Callable;

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
	 * dump frame 
	 * @param depth current tree depth /for recursive process/
	 * @param prefix text prefix before top string
	 * @return full tree form
	 * */
	public String dump(int depth, String prefix) {
		String tree = pad(depth) + head(prefix);
		for (Entry<String, Frame> i : slot.entrySet())
			tree += i.getValue().dump(depth+1, i.getKey() + " = ");
		for (Frame j:nest)
			tree += j.dump(depth+1, "");
		return tree;
	}

	/**
	 * header-only dump 
	 * @param prefix text prefix before `<T:V>`
	 * @return shortest header-only form
	 * */
	public String head(String prefix) {
		return prefix + "<" + type + ":" + str() + ">";
	}
	
	String str() { return ""+val; }

	/**
	 * left-pad tree with cr+tabs
	 * @param n number of tabs (tree depth)
	 * @return CR + TABs
	 * */
	private String pad(int N) {
		String s = "\n";
		for (int i=0;i<N;i++) s += "    ";
		return s;
	}

	public Frame push(Frame that) { nest.add(that); return this; }
	
	public Frame pop() { return nest.remove(nest.size()-1); }

	public Frame top() { return nest.get(nest.size()-1); }

//	public Frame dup() { return push(top()); }
	public Frame dropall() { nest.clear(); return this; }

	public Frame get(String key) { return slot.get(key); }
	public Frame set(String key, Frame that) { slot.put(key,that); return this; }
	public Frame set(String key, Runnable fn) { return set(key,new Cmd(fn.toString(),fn)); }
	
	
	public void eval(Frame context) {
		context.push(this);
	}

}
