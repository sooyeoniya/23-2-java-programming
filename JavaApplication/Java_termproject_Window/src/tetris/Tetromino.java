package tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tetromino {
	// Declare Variables for Tetromino
    Rectangle a, b, c, d;
    Color color; // The color of each Tetromino
    Color colormain = Color.BLACK; // The border color of the Tetromino
    private String name; // The shape of each Tetromino
    public int tetromino = 1; // The current rotational state of the Tetromino

    // Initialize the constructor
    public Tetromino(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Tetromino(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this(a,b,c,d);
        this.name = name;

        // Set border of Tetromino
        a.setStroke(colormain);
        b.setStroke(colormain);
        c.setStroke(colormain);
        d.setStroke(colormain);

        a.setStrokeWidth(2);
        b.setStrokeWidth(2);
        c.setStrokeWidth(2);
        d.setStrokeWidth(2);

        // Set colors for each shape
        Color j = Color.web("#27005D");
        Color l = Color.web("#E90064");
        Color o = Color.web("#19A7CE");
        Color s = Color.web("#FF6969");
        Color t = Color.web("#FCFFE7");
        Color z = Color.web("#8df7d0");
        Color i = Color.web("#ab4aff");
        
        switch (name) {
            case "j":
                color = j;
                break;
            case "l":
                color = l;
                break;
            case "o":
                color = o;
                break;
            case "s":
                color = s;
                break;
            case "t":
                color = t;
                break;
            case "z":
                color = z;
                break;
            case "i":
                color = i;
                break;
        }
        
        // Fill color in 4 Rectangle
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }

    public String getName() {
        return name;
    }

    // Change the direction of rotation
    public void changeTetromino() {
        if (tetromino != 4) tetromino++;
        else tetromino = 1;
    }

}