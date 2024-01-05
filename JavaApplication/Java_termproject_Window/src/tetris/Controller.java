package tetris;

import javafx.scene.shape.Rectangle;

public class Controller {
	// Declare variables related to the game board
    public static final int MOVE = Tetris.MOVE;
    public static final int SIZE = Tetris.SIZE;
    public static int XMAX = Tetris.XMAX;
    public static int YMAX = Tetris.YMAX;
    public static int[][] MESH = Tetris.MESH;

    // Method of moving to the right
    public static void MoveRight(Tetromino tetromino) {
    	// Move to the right only if there are no other blocks in the position you want to move
        if (tetromino.a.getX() + MOVE <= XMAX - SIZE && tetromino.b.getX() + MOVE <= XMAX - SIZE
                && tetromino.c.getX() + MOVE <= XMAX - SIZE && tetromino.d.getX() + MOVE <= XMAX - SIZE) {
            int movea = MESH[((int) tetromino.a.getX() / SIZE) + 1][((int) tetromino.a.getY() / SIZE)];
            int moveb = MESH[((int) tetromino.b.getX() / SIZE) + 1][((int) tetromino.b.getY() / SIZE)];
            int movec = MESH[((int) tetromino.c.getX() / SIZE) + 1][((int) tetromino.c.getY() / SIZE)];
            int moved = MESH[((int) tetromino.d.getX() / SIZE) + 1][((int) tetromino.d.getY() / SIZE)];
            if (movea == 0 && moveb == 0 && movec == 0 && moved == 0) {
                tetromino.a.setX(tetromino.a.getX() + MOVE);
                tetromino.b.setX(tetromino.b.getX() + MOVE);
                tetromino.c.setX(tetromino.c.getX() + MOVE);
                tetromino.d.setX(tetromino.d.getX() + MOVE);
            }
        }
    }
    // Method of moving to the left
    public static void MoveLeft(Tetromino tetromino) {
    	// Move to the left only if there are no other blocks in the position you want to move
        if (tetromino.a.getX() - MOVE >= 0 && tetromino.b.getX() - MOVE >= 0 && tetromino.c.getX() - MOVE >= 0
                && tetromino.d.getX() - MOVE >= 0) {
            int movea = MESH[((int) tetromino.a.getX() / SIZE) - 1][((int) tetromino.a.getY() / SIZE)];
            int moveb = MESH[((int) tetromino.b.getX() / SIZE) - 1][((int) tetromino.b.getY() / SIZE)];
            int movec = MESH[((int) tetromino.c.getX() / SIZE) - 1][((int) tetromino.c.getY() / SIZE)];
            int moved = MESH[((int) tetromino.d.getX() / SIZE) - 1][((int) tetromino.d.getY() / SIZE)];
            if (movea == 0 && moveb == 0 && movec == 0 && moved == 0) {
                tetromino.a.setX(tetromino.a.getX() - MOVE);
                tetromino.b.setX(tetromino.b.getX() - MOVE);
                tetromino.c.setX(tetromino.c.getX() - MOVE);
                tetromino.d.setX(tetromino.d.getX() - MOVE);
            }
        }
    }

    public static Tetromino makeRect() {
    	// Randomly determine the type of the Tetromino
        int block = (int) (Math.random() * 100);
        String name;
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1), b = new Rectangle(SIZE - 1, SIZE - 1),
                  c = new Rectangle(SIZE - 1, SIZE - 1), d = new Rectangle(SIZE - 1, SIZE - 1);
        
        // Returns the Tetromino created after setting the location of each block
        if (block < 15) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
            /*
                1(a)
                1(b)1(c)1(d)
            */
        }
        else if (block < 30) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
            /*
                        1(a)
                1(b)1(c)1(d)
            */
        }
        else if (block < 45) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
            /*
                1(a)1(b)
                1(c)1(d)
            */
        }
        else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
            /*
                    1(b)1(a)
                1(d)1(c)
            */
        }
        else if (block < 75) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
            /*
                1(a)1(b)1(d)
                    1(c)
            */
        }
        else if (block < 90) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
            /*
                1(b)1(a)
                    1(c)1(d)
            */
        }
        else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
            /*
                1(a)1(b)1(c)1(d)
            */
        }
        return new Tetromino(a, b, c, d, name);
    }
}