package gui;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * GUI Window
 * */
public class Win extends GUI {
	
	private JFrame jframe;
	private LayoutManager jlayout;
	
	private JButton go;
	private JTextArea log;
	private JTextField pad;

	Win(String V) {
		super("win",V);
		jframe = new JFrame(this.head(""));
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(true);
		jframe.setLocationRelativeTo(null);
		jlayout = new FlowLayout(); jframe.setLayout(jlayout);
		log = new JTextArea("dsdsdsd");
		pad = new JTextField("bebebbee");
		go = new JButton("GO");
		jframe.add(log);
		jframe.add(pad);
		jframe.add(go);
		jframe.pack();
		jframe.setVisible(true);
	}
}
