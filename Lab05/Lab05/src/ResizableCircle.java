
public class ResizableCircle extends Circle implements Resizable {
	public ResizableCircle(double radius) {
		super(radius);
	}

	public String toString() {
		return "ResizableCircle[Circle[raduis=" + this.radius + "]]";
	}

	// Implement method defined in the interface Resizable
	@Override
	public void resize(int percent) { // resize radius
		this.radius *= percent / 100.0;
	}
}