package tetris;

import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Tetris extends Application {
	// Declare Game board size Variables
    public static int MOVE = 25;
    public static int SIZE = MOVE;
    public static int XMAX = SIZE * 16;
    public static int YMAX = SIZE * 20;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];

    // Declare layout variables
    public Pane p1 = new Pane();
    public Pane p2 = new Pane();
    Pane p3 = new Pane();
    HBox pp = new HBox(10);
    VBox mainScreenLayout = new VBox(10);
    Scene scene = new Scene(mainScreenLayout, XMAX + 40, YMAX + 124);
    Tetromino object, nextObj = Controller.makeRect();

    int top = 0;
    int linesNo = 0;
    boolean game = true;
    public static int score = 0;
    public static int dur = 300;
    public static Text scoretext = new Text("Score: ");
    public static Text leveltext = new Text("Lines: ");

    // Game Play Variables
    Label start = new Label("▐▐");
    Label pause = new Label("▶");
    
    // Time for Tetromino to come down
    Timeline timeline;

    public static String color = "#222738";
    public static Color textColor = Color.web("#FFF");

    @Override
    public void start(Stage tetrisStage) throws IOException {
    	// Initialize game board
        for (int i = 0; i < MESH.length; i++)
            for (int j = 0; j < MESH[i].length; j++)
            	MESH[i][j] = 0;

        // Set score text style
        scoretext.setStyle("-fx-font: 20 'Comic Sans MS';");
        scoretext.setFill(textColor);
        scoretext.setX(180);
        scoretext.setY(40);

        // Set level text style
        leveltext.setStyle("-fx-font: 20 'Comic Sans MS';");
        leveltext.setFill(textColor);
        leveltext.setX(50);
        leveltext.setY(40);

        // Set start label placement and style
        start.setTranslateX(30);
        start.setTranslateY(20);
        start.setStyle("-fx-font: 20 arial;");
        start.setVisible(false);

        // Set pause label placement and style
        pause.setTranslateX(30);
        pause.setStyle("-fx-font: 60 arial;");

        // Set game board style
        p1.setPrefSize(XMAX + 50, YMAX);
        p1.setStyle("-fx-background-color: "+ color +"; -fx-background-radius: 5px;");

        // Set game info style
        p2.setPrefHeight(70);
        p2.setPrefWidth(300);
        p2.setStyle("-fx-background-color: "+ color +"; -fx-background-radius: 5px;");
        p2.getChildren().addAll(scoretext, leveltext);

        // horizontal arrangement
        p3.getChildren().addAll(pause,start);
        pp.getChildren().addAll(p2,p3);

        // Set screen placement
        mainScreenLayout.setPadding(new Insets(20));
        mainScreenLayout.getChildren().addAll(p1,pp);

        // Variables for the following locations
        Tetromino a = nextObj;
        p1.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        object = a;
        nextObj = Controller.makeRect();
        
        // Additional screen settings
        tetrisStage.setScene(scene);
        tetrisStage.getIcons().add(new Image (getClass().getResourceAsStream("./Images/Icon.png")));
        tetrisStage.setResizable(false);
        tetrisStage.setTitle("Tetris");
        tetrisStage.show();

        // Create an animation that runs repeatedly during a particular duration
        timeline = new Timeline(new KeyFrame(Duration.millis(dur), event -> {
        	// Verify that each block in the Tetromino has reached its top level
            if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0 || object.d.getY() == 0) top++;
            else top = 0;

            // The game ends when the value of the top reaches 2
            if (top == 2) game = false;

            // The game ends when the value of the top reaches 10
            if (top == 10) {
                GameOver gameOver = new GameOver();
                try {
                    gameOver.start(new Stage());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                tetrisStage.close();
            }

            // Update score and line count
            if (game) {
                MoveDown(object);
                scoretext.setText("Score: " + Integer.toString(score));
                leveltext.setText("Lines: " + Integer.toString(linesNo));
            }
        }));

        // Execute timeline's Methods
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Pause button click event
        pause.setOnMouseClicked(e -> {
            timeline.pause();
            pause.setVisible(false);
            start.setVisible(true);
        });

        // Start button click event
        start.setOnMouseClicked(e -> {
            timeline.play();
            start.setVisible(false);
            pause.setVisible(true);
        });
    }

    // Keyboard Event Method
    private void moveOnKeyPress(Tetromino tetromino) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    Controller.MoveRight(tetromino);
                    break;
                case DOWN:
                    MoveDown(tetromino);
                    score++;
                    break;
                case LEFT:
                    Controller.MoveLeft(tetromino);
                    break;
                case UP:
                    MoveTurn(tetromino);
                    break;
                case SPACE:
                    if (timeline.getStatus() == Timeline.Status.RUNNING) {
                        timeline.stop();
                        pause.setVisible(false);
                        start.setVisible(true);
                    } else {
                        timeline.play();
                        pause.setVisible(true);
                        start.setVisible(false);
                    }
                    break;
                default: break;
            }
        });
    }

    /* Determine how the current Tetromino form 
     * and name of the Tetromino will change the location of each block */
    private void MoveTurn(Tetromino tetromino) {
        int t = tetromino.tetromino;
        Rectangle a = tetromino.a;
        Rectangle b = tetromino.b;
        Rectangle c = tetromino.c;
        Rectangle d = tetromino.d;
        switch (tetromino.getName()) {
            case "j":
            /*
                1(a)
                1(b)1(c)1(d)
            */
                if (t == 1 && Rotation(a, 1, -1) && Rotation(c, -1, -1) && Rotation(d, -2, -2)) {
                    MoveRight(tetromino.a);
                    MoveDown(tetromino.a);
                    MoveDown(tetromino.c);
                    MoveLeft(tetromino.c);
                    MoveDown(tetromino.d);
                    MoveDown(tetromino.d);
                    MoveLeft(tetromino.d);
                    MoveLeft(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(b)1(a)
                        1(c)
                        1(d)
                     */
                }
                if (t == 2 && Rotation(a, -1, -1) && Rotation(c, -1, 1) && Rotation(d, -2, 2)) {
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveLeft(tetromino.c);
                    MoveUp(tetromino.c);
                    MoveLeft(tetromino.d);
                    MoveLeft(tetromino.d);
                    MoveUp(tetromino.d);
                    MoveUp(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(d)1(c)1(b)
                        1(a)
                    */
                }
                if (t == 3 && Rotation(a, -1, 1) && Rotation(c, 1, 1) && Rotation(d, 2, 2)) {
                    MoveLeft(tetromino.a);
                    MoveUp(tetromino.a);
                    MoveUp(tetromino.c);
                    MoveRight(tetromino.c);
                    MoveUp(tetromino.d);
                    MoveUp(tetromino.d);
                    MoveRight(tetromino.d);
                    MoveRight(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                            1(d)
                            1(c)
                        1(a)1(b)
                    */
                }
                if (t == 4 && Rotation(a, 1, 1) && Rotation(c, 1, -1) && Rotation(d, 2, -2)) {
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveRight(tetromino.c);
                    MoveDown(tetromino.c);
                    MoveRight(tetromino.d);
                    MoveRight(tetromino.d);
                    MoveDown(tetromino.d);
                    MoveDown(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(a)
                        1(b)1(c)1(d)
                     */
                }
                break;
            case "l":
            /*
                        1(a)
                1(b)1(c)1(d)
            */
                if (t == 1 && Rotation(a, 1, -1) && Rotation(c, 1, 1) && Rotation(b, 2, 2)) {
                    MoveRight(tetromino.a);
                    MoveDown(tetromino.a);
                    MoveUp(tetromino.c);
                    MoveRight(tetromino.c);
                    MoveUp(tetromino.b);
                    MoveUp(tetromino.b);
                    MoveRight(tetromino.b);
                    MoveRight(tetromino.b);
                    tetromino.changeTetromino();
                    break;
					/*
                        1(b)
                        1(c)
                        1(d)1(a)
                    */
                }
                if (t == 2 && Rotation(a, -1, -1) && Rotation(b, 2, -2) && Rotation(c, 1, -1)) {
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveRight(tetromino.b);
                    MoveRight(tetromino.b);
                    MoveDown(tetromino.b);
                    MoveDown(tetromino.b);
                    MoveRight(tetromino.c);
                    MoveDown(tetromino.c);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(d)1(c)1(b)
                        1(a)
                    */
                }
                if (t == 3 && Rotation(a, -1, 1) && Rotation(c, -1, -1) && Rotation(b, -2, -2)) {
                    MoveLeft(tetromino.a);
                    MoveUp(tetromino.a);
                    MoveDown(tetromino.c);
                    MoveLeft(tetromino.c);
                    MoveDown(tetromino.b);
                    MoveDown(tetromino.b);
                    MoveLeft(tetromino.b);
                    MoveLeft(tetromino.b);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(a)1(d)
                            1(c)
                            1(b)
                    */
                }
                if (t == 4 && Rotation(a, 1, 1) && Rotation(b, -2, 2) && Rotation(c, -1, 1)) {
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveLeft(tetromino.b);
                    MoveLeft(tetromino.b);
                    MoveUp(tetromino.b);
                    MoveUp(tetromino.b);
                    MoveLeft(tetromino.c);
                    MoveUp(tetromino.c);
                    tetromino.changeTetromino();
                    break;
                    /*
                                1(a)
                        1(b)1(c)1(d)
                    */
                }
                break;
            case "o":
            /*
                1(a)1(b)
                1(c)1(d)
            */
                break;
            case "s":
            /*
                    1(b)1(a)
                1(d)1(c)
            */
                if (t == 1 && Rotation(a, -1, -1) && Rotation(c, -1, 1) && Rotation(d, 0, 2)) {
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveLeft(tetromino.c);
                    MoveUp(tetromino.c);
                    MoveUp(tetromino.d);
                    MoveUp(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(d)
                        1(c)1(b)
                            1(a)
                     */
                }
                if (t == 2 && Rotation(a, 1, 1) && Rotation(c, 1, -1) && Rotation(d, 0, -2)) {
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveRight(tetromino.c);
                    MoveDown(tetromino.c);
                    MoveDown(tetromino.d);
                    MoveDown(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                            1(b)1(a)
                        1(d)1(c)
                    */
                }
                if (t == 3 && Rotation(a, -1, -1) && Rotation(c, -1, 1) && Rotation(d, 0, 2)) {
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveLeft(tetromino.c);
                    MoveUp(tetromino.c);
                    MoveUp(tetromino.d);
                    MoveUp(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(d)
                        1(c)1(b)
                            1(a)
                    */
                }
                if (t == 4 && Rotation(a, 1, 1) && Rotation(c, 1, -1) && Rotation(d, 0, -2)) {
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveRight(tetromino.c);
                    MoveDown(tetromino.c);
                    MoveDown(tetromino.d);
                    MoveDown(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                            1(b)1(a)
                        1(d)1(c)
                    */
                }
                break;
            case "t":
            /*
                1(a)1(b)1(d)
                    1(c)
            */
                if (t == 1 && Rotation(a, 1, 1) && Rotation(d, -1, -1) && Rotation(c, -1, 1)) {
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveDown(tetromino.d);
                    MoveLeft(tetromino.d);
                    MoveLeft(tetromino.c);
                    MoveUp(tetromino.c);
                    tetromino.changeTetromino();
                    break;
                    /*
                            1(a)
                        1(c)1(b)
                            1(d)
                    */
                }
                if (t == 2 && Rotation(a, 1, -1) && Rotation(d, -1, 1) && Rotation(c, 1, 1)) {
                    MoveRight(tetromino.a);
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.d);
                    MoveUp(tetromino.d);
                    MoveUp(tetromino.c);
                    MoveRight(tetromino.c);
                    tetromino.changeTetromino();
                    break;
                    /*
                            1(c)
                        1(a)1(b)1(d)
                    */
                }
                if (t == 3 && Rotation(a, -1, -1) && Rotation(d, 1, 1) && Rotation(c, 1, -1)) {
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveUp(tetromino.d);
                    MoveRight(tetromino.d);
                    MoveRight(tetromino.c);
                    MoveDown(tetromino.c);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(a)
                        1(b)1(c)
                        1(d)
                    */
                }
                if (t == 4 && Rotation(a, -1, 1) && Rotation(d, 1, -1) && Rotation(c, -1, -1)) {
                    MoveLeft(tetromino.a);
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.d);
                    MoveDown(tetromino.d);
                    MoveDown(tetromino.c);
                    MoveLeft(tetromino.c);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(a)1(b)1(d)
                            1(c)
                    */
                }
                break;
            case "z":
            /*
                1(b)1(a)
                    1(c)1(d)
            */
                if (t == 1 && Rotation(b, 1, 1) && Rotation(c, -1, 1) && Rotation(d, -2, 0)) {
                    MoveUp(tetromino.b);
                    MoveRight(tetromino.b);
                    MoveLeft(tetromino.c);
                    MoveUp(tetromino.c);
                    MoveLeft(tetromino.d);
                    MoveLeft(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                            1(b)
                        1(c)1(a)
                        1(d)
                     */
                }
                if (t == 2 && Rotation(b, -1, -1) && Rotation(c, 1, -1) && Rotation(d, 2, 0)) {
                    MoveDown(tetromino.b);
                    MoveLeft(tetromino.b);
                    MoveRight(tetromino.c);
                    MoveDown(tetromino.c);
                    MoveRight(tetromino.d);
                    MoveRight(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(b)1(a)
                            1(c)1(d)
                    */
                }
                if (t == 3 && Rotation(b, 1, 1) && Rotation(c, -1, 1) && Rotation(d, -2, 0)) {
                    MoveUp(tetromino.b);
                    MoveRight(tetromino.b);
                    MoveLeft(tetromino.c);
                    MoveUp(tetromino.c);
                    MoveLeft(tetromino.d);
                    MoveLeft(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                            1(b)
                        1(c)1(a)
                        1(d)
                    */
                }
                if (t == 4 && Rotation(b, -1, -1) && Rotation(c, 1, -1) && Rotation(d, 2, 0)) {
                    MoveDown(tetromino.b);
                    MoveLeft(tetromino.b);
                    MoveRight(tetromino.c);
                    MoveDown(tetromino.c);
                    MoveRight(tetromino.d);
                    MoveRight(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(b)1(a)
                            1(c)1(d)
                    */
                }
                break;
            case "i":
            /*
                1(a)1(b)1(c)1(d)
            */
                if (t == 1 && Rotation(a, 2, 2) && Rotation(b, 1, 1) && Rotation(d, -1, -1)) {
                    MoveUp(tetromino.a);
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveUp(tetromino.b);
                    MoveRight(tetromino.b);
                    MoveDown(tetromino.d);
                    MoveLeft(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(a)
                        1(b)
                        1(c)
                        1(d)
                    */
                }
                if (t == 2 && Rotation(a, -2, -2) && Rotation(b, -1, -1) && Rotation(d, 1, 1)) {
                    MoveDown(tetromino.a);
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveDown(tetromino.b);
                    MoveLeft(tetromino.b);
                    MoveUp(tetromino.d);
                    MoveRight(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(a)1(b)1(c)1(d)
                    */
                }
                if (t == 3 && Rotation(a, 2, 2) && Rotation(b, 1, 1) && Rotation(d, -1, -1)) {
                    MoveUp(tetromino.a);
                    MoveUp(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveRight(tetromino.a);
                    MoveUp(tetromino.b);
                    MoveRight(tetromino.b);
                    MoveDown(tetromino.d);
                    MoveLeft(tetromino.d);
                    tetromino.changeTetromino();
                    break;
                    /*
                        1(a)
                        1(b)
                        1(c)
                        1(d)
                    */
                }
                if (t == 4 && Rotation(a, -2, -2) && Rotation(b, -1, -1) && Rotation(d, 1, 1)) {
                    MoveDown(tetromino.a);
                    MoveDown(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveLeft(tetromino.a);
                    MoveDown(tetromino.b);
                    MoveLeft(tetromino.b);
                    MoveUp(tetromino.d);
                    MoveRight(tetromino.d);
                    tetromino.changeTetromino();
                    /*
                        1(a)1(b)1(c)1(d)
                    */
                    break;
                }
                break;
        }
    }

    // Remove completed rows
    private void RemoveRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;

        // Verify each row to see if it is full of blocks
        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1) full++;
            }
            if (full == MESH.length) lines.add(i);
            full = 0;
        }

        if (lines.size() > 0)
            do {
            	/* If there is an element in the line list, 
            	 * i.e. if there is a row to remove, 
            	 * increase the score by 50 points, 
            	 * and increase the number of rows removed */
                for (Node node : pane.getChildren())
                	if (node instanceof Rectangle) rects.add(node);
                score += 50;
                linesNo++;

                // Reset Position Value
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);
                    } else newrects.add(node);
                }

                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }
                }
                
                // Remove the line
                lines.remove(0);
                rects.clear();
                newrects.clear();
                
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                
                // Reset Position Value
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
                
                rects.clear();
                
            } while (lines.size() > 0);
    }

    // Methods of moving up, down, left, and right
    private void MoveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX)
            rect.setY(rect.getY() + MOVE);
    }

    private void MoveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE)
            rect.setX(rect.getX() + MOVE);
    }

    private void MoveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0)
            rect.setX(rect.getX() - MOVE);
    }

    private void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0)
            rect.setY(rect.getY() - MOVE);
    }

    private void MoveDown(Tetromino tetromino) {
    	// See if you can move it down
        if (tetromino.a.getY() == YMAX - SIZE || tetromino.b.getY() == YMAX - SIZE || tetromino.c.getY() == YMAX - SIZE
                || tetromino.d.getY() == YMAX - SIZE || BlankSpaceA(tetromino) || BlankSpaceB(tetromino) || BlankSpaceC(tetromino) || BlankSpaceD(tetromino)) {
            MESH[(int) tetromino.a.getX() / SIZE][(int) tetromino.a.getY() / SIZE] = 1;
            MESH[(int) tetromino.b.getX() / SIZE][(int) tetromino.b.getY() / SIZE] = 1;
            MESH[(int) tetromino.c.getX() / SIZE][(int) tetromino.c.getY() / SIZE] = 1;
            MESH[(int) tetromino.d.getX() / SIZE][(int) tetromino.d.getY() / SIZE] = 1;
            RemoveRows(p1);

            Tetromino a = nextObj;
            nextObj = Controller.makeRect();
            object = a;
            p1.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
        }

        if (tetromino.a.getY() + MOVE < YMAX && tetromino.b.getY() + MOVE < YMAX && tetromino.c.getY() + MOVE < YMAX
                && tetromino.d.getY() + MOVE < YMAX) {
            int movea = MESH[(int) tetromino.a.getX() / SIZE][((int) tetromino.a.getY() / SIZE) + 1];
            int moveb = MESH[(int) tetromino.b.getX() / SIZE][((int) tetromino.b.getY() / SIZE) + 1];
            int movec = MESH[(int) tetromino.c.getX() / SIZE][((int) tetromino.c.getY() / SIZE) + 1];
            int moved = MESH[(int) tetromino.d.getX() / SIZE][((int) tetromino.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                tetromino.a.setY(tetromino.a.getY() + MOVE);
                tetromino.b.setY(tetromino.b.getY() + MOVE);
                tetromino.c.setY(tetromino.c.getY() + MOVE);
                tetromino.d.setY(tetromino.d.getY() + MOVE);
            }
        }
    }

    // Verify that a, b, c, d block has free space underneath
    private boolean BlankSpaceA(Tetromino tetromino) {
        return (MESH[(int) tetromino.a.getX() / SIZE][((int) tetromino.a.getY() / SIZE) + 1] == 1);
    }

    private boolean BlankSpaceB(Tetromino tetromino) {
        return (MESH[(int) tetromino.b.getX() / SIZE][((int) tetromino.b.getY() / SIZE) + 1] == 1);
    }

    private boolean BlankSpaceC(Tetromino tetromino) {
        return (MESH[(int) tetromino.c.getX() / SIZE][((int) tetromino.c.getY() / SIZE) + 1] == 1);
    }

    private boolean BlankSpaceD(Tetromino tetromino) {
        return (MESH[(int) tetromino.d.getX() / SIZE][((int) tetromino.d.getY() / SIZE) + 1] == 1);
    }

    // Verify if the Tetromino blocks can move to the position it is trying to rotate
    private boolean Rotation(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        if (x < 0)
            xb = rect.getX() + x * MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * MOVE < YMAX;
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }

    public static void main(String[] args) {
        launch(args);
    }

}