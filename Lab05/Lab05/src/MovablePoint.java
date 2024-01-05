/**
 * The subclass MovablePoint needs to implement all the abstract methods defined
 * in the interface Movable
 */
public class MovablePoint implements Movable {
	// Private member variables
	private int x, y, xSpeed, ySpeed; // x, y, xSpeed, ySpeed

	/** Constructs a MovablePoint instance at the given x and y */
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	/** Returns a self-descriptive string */
	@Override
	public String toString() {
		return "point=(" + x + "," + y + "), speed=(" + this.xSpeed + "," + this.ySpeed + ")";
	}

	// Need to implement all the abstract methods defined in the interface Movable
	@Override
	public void moveUp() {
		y += ySpeed; // y-axis pointing up for 2D graphics
		System.out.println("up y-axis!");
	}

	@Override
	public void moveDown() {
		y -= ySpeed; // y-axis pointing down for 2D graphics
		System.out.println("down y-axis!");
	}

	@Override
	public void moveLeft() {
		x -= xSpeed; // x-axis pointing left for 2D graphics
		System.out.println("left x-axis!");
	}

	@Override
	public void moveRight() {
		x += xSpeed; // x-axis pointing right for 2D graphics
		System.out.println("right x-axis!");
	}
}