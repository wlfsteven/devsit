import ddf.minim.Minim;
import ddf.minim.AudioPlayer;
import java.util.*;

import processing.core.*;

public class BatchAudio {
	public static void main(String[] args) {
		Object obj = new Object();
		Minim minim = new Minim(obj);
		AudioPlayer[] sounds = {
				minim.loadFile("evillaugh.mp3");
		};
		Random r = new Random();
		for (;;) {
			try {
				Thread.sleep(5000); // sleep 5 seconds
			} catch (InterruptedException e) {
			}
			int which = r.nextInt(sounds.length);
			sounds[which].rewind();
			sounds[which].play();
		}
	}
}