import java.util.Random;


public abstract class AbstractBeacon {
	private static Random r;
	static {
		r = new Random(0);
	}
	private double x,y; // location of beacon in tangent plane.
	private double z; 	// the height;
	private double sigma;	// for normally distributed error
	private double failureRate; // for low probability big errors
	private double sigma2;	// the error for low-probability events
	public AbstractBeacon(double x, double y, double z,
				double sigma, double failure, double sigma2) {
		this.x = x; this.y = y;
		this.z = z;
		this.sigma = sigma; // variance under normal operation
		this.failureRate = failureRate; // if below this, error jumps a lot
		this.sigma2 = sigma2;		//
	}
	// Beacons can move (like GPS)
	public abstract void updatePosition(double t);
	/*
	 * Return the beacon's estimated distance given beacon and object position
	 * This includes simulated error
	 */
	double ping(double x, double y, double z) {
		double dx = x - this.x, dy = y - this.y, dz = z - this.z;
		double distsq = dx + dy + dz;
		double err = r.nextGaussian() * sigma;
		if (err < failureRate) {
			err = r.nextGaussian() * sigma2;
		}
		return Math.sqrt(distsq) + err;
	}
	public double getX() { return x; }
	public double getY() { return y; }
	public double getZ() { return z; }
	public double getSigma() { return sigma; }
}
