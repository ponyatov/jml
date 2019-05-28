package gui;

import frame.Frame;

/**
 * GUI element
 * */
public class GUI extends Frame {
	GUI(String T, String V) { super(T,V); }
	GUI(String V) {
		super("gui",V);
		push(new Win(V));
	}
}
