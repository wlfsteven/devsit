import processing.core.PApplet;

public class ControlApplet extends PApplet {
  private int width, height;
  public void setSize(int w, int h) { width = w; height = h; }
  public void setup() {
    size(width, height);
    noLoop();
  }

  public void draw() {
    background(200,255,200);
    fill(255, 100, 100);
    stroke(64,0,0);
    strokeWeight(2);
    for (int i = 0; i < 5; i++) {
      float x = (float) (Math.random() * width);
      float y = (float) (Math.random() * height);
      float r = (float) (Math.random() * 30 + 20);
      ellipse(x,y,r,r);
    }
  }
}

