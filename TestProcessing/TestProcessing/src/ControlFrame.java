import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import processing.core.PApplet;

public class ControlFrame extends JFrame {
	private ControlApplet papplet;
	public ControlFrame(String title, int w, int h, ControlApplet papplet) {
	  this.papplet = papplet;
	  papplet.setSize(w,h);
	   // Set the papplet size preferences
	  papplet.resize(w, h);
	  papplet.setPreferredSize(new Dimension(w, h));
	  papplet.setMinimumSize(new Dimension(w, h));
	  add(papplet, BorderLayout.CENTER);
	  papplet.init();
	  Container c = getContentPane();
	  c.addComponentListener(new ComponentAdapter() {
		 public void componentResized(ComponentEvent e) {
//			//papplet.setSize(w,h)
		 }
	  });
	}
}
