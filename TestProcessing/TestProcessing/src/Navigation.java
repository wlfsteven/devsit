import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import processing.core.*;

public class Navigation extends ControlFrame {
	private JPanel createControlPanel() {
		JPanel p = new JPanel();
		p.setBackground(Color.blue);
		//p.setLayout(2,4,5,5);
		JSlider s = new JSlider(JSlider.VERTICAL, 0, 255, 0);
		s.setBackground(Color.green);
		p.add(s);
		return p;
	}
	public Navigation() {
		
		super("Navigation", 1300, 900, new NavDisplay());
		Container c = getContentPane();
		JPanel p = createControlPanel();
		c.add(p, BorderLayout.EAST);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Navigation();
	}
}