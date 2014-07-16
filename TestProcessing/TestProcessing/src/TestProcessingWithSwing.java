import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import processing.core.*;

public class TestProcessingWithSwing extends JFrame {
	public TestProcessingWithSwing() {
		super("ProcessingWithSwing");
		setSize(600,400);
		Container c = getContentPane();
		JButton b = new JButton("save");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Pressed!");
				Test1 t = new Test1();
				t.setVisible(true);
			}
		});
		c.add(b, BorderLayout.EAST);
		//c.add(new Test1(), BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestProcessingWithSwing();
	}
}