
import java.util.ArrayList;
import processing.core.*;

public class Test1 extends PApplet {
	
	
	
	
	
	
	private ArrayList<Point> points;
    public void setup() {   
    size(800,800);
    background(0,255,0);
    noStroke();
    points = new ArrayList<Point>();
  }

  public void draw() {
    if (mousePressed) {
      fill(0);
      ellipse(mouseX, mouseY, 10, 10);
//      line(mouseX,mouseY,pmouseX,pmouseY);
    }
  }

}