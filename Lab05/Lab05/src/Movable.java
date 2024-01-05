
public interface Movable {  // use keyword "interface" (instead of "class") to define an interface
   // An interface defines a list of public abstract methods to be implemented by the subclasses
   public void moveUp();    // "public" and "abstract" optional
   public void moveDown();
   public void moveLeft();
   public void moveRight();
}