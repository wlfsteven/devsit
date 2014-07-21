
import java.util.ArrayList;
import processing.core.*;

public class NavDisplay extends ControlApplet {
	private ArrayList<Point> course; // actual track of object
	private ArrayList<Beacon> beacons; // nav beacons
	
	private PImage map;
    public void setup() {
      super.setup();
      background(0,255,0);
      noStroke();
      course = new ArrayList<Point>();
      map = loadImage("earth.jpg");
	}

    public void draw() {
    	
    }

}