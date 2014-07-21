
import java.util.ArrayList;
import processing.core.*;

class Point {
	public int x,y;
//	public Point(int x, int y) {
	public Point(int x_in, int y_in) {
		x = x_in;  y = y_in;
	}
}


public class DrawList extends PApplet {
	private ArrayList<Point> points;
    public void setup() {   
    	size(800,800);
    	background(0);
    	stroke(255);
    	points = new ArrayList<Point>();
    }
  
    public void draw() {
    	if (mousePressed) {
        	points.add(new Point(mouseX,mouseY));
        	//println(points.size());
    	}
    	for (int i = 0; i < points.size()-1; i++) {
    		Point p = points.get(i);
    		Point p2 = points.get(i+1);
    		line(p.x, p.y, p2.x, p2.y);
    	}
    		
    }
}








