/**
 * The subclass MovableCircle needs to implement all the abstract methods
 * defined in the interface Movable
 */
public class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center; // Use the instance of the existing class

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		// Create a new object of type 'MovablePoint'
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	/** Returns a self-descriptive string */
	@Override
	public String toString() {
		return center + ", radius=" + this.radius;
	}

	// Need to implement all the abstract methods defined in the interface Movable
	@Override
	public void moveUp() {
		center.moveUp();
	}

	@Override
	public void moveDown() {
		center.moveDown();
	}

	@Override
	public void moveLeft() {
		center.moveLeft();
	}

	@Override
	public void moveRight() {
		center.moveRight();
	}
}
