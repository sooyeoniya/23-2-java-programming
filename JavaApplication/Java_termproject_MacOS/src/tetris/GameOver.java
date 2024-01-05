package tetris;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameOver extends Application {
	// Declare Game board size and score Variables
    public static int XMAX = Tetris.XMAX;
    public static int YMAX = Tetris.YMAX;
    public static int score = Tetris.score;
    
    // Declare Game Over Image and score text Variables
    Image image = new Image(getClass().getResourceAsStream("./Images/GameOver.png"));
    ImageView imageView = new ImageView();
    Label scoretext = new Label("Score: " + score);

    // Declare button elements
    Button newGame = new Button("New Game");
    Button exit = new Button("EXIT");
    
    // Declare layout variables
    VBox gameOverImage = new VBox(10);
    StackPane txtscore = new StackPane(scoretext);
    HBox buttons = new HBox(10);
    BorderPane mainScreenLayout = new BorderPane();
    Scene scene = new Scene(mainScreenLayout, XMAX, YMAX + 124);

    @Override
    public void start(Stage gameOverStage) {
    	// Set the Game Over image size
        imageView.setImage(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        
        // Center alignment
        gameOverImage.setAlignment(Pos.CENTER);
        gameOverImage.getChildren().addAll(imageView);

        scoretext.setTextFill(Color.WHITE);
        scoretext.setFont(Font. font("Comic Sans MS", FontWeight.BOLD, 45));

        // Set newGame text style
        newGame.setTextFill(Color.WHITE);
        newGame.setMinWidth(150);
        newGame.setMinHeight(30);
        newGame.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        newGame.setStyle("-fx-background-color: #ae00ba;" + "-fx-background-radius: 5px;");
        
        // The button style that you can see when you mouse over a button
        newGame.setOnMouseEntered(e -> {
            newGame.setStyle("-fx-background-color: #fbc2ff; -fx-text-fill: white; -fx-background-radius: 5px;");
        });

        // The button style that you can see when you put your mouse down a button
        newGame.setOnMouseExited(e -> {
            newGame.setStyle("-fx-background-color: #ae00ba;" + "-fx-background-radius: 5px;");
        });
        
        // Switch the screen to the game window when you click the button
        newGame.setOnAction(e -> {
            Tetris tetris = new Tetris();
            try {
            	tetris.start(new Stage());
                gameOverStage.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            Tetris.score = 0;
        });

        // Set Exit text style
        exit.setTextFill(Color.WHITE);
        exit.setMinWidth(150);
        exit.setMinHeight(30);
        exit.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        exit.setStyle("-fx-background-color: #ae00ba;" + "-fx-background-radius: 5px;");
        
        // The button style that you can see when you mouse over a button
        exit.setOnMouseEntered(e -> {
            exit.setStyle("-fx-background-color: #fbc2ff; -fx-text-fill: white; -fx-background-radius: 5px;");
        });
        
        // The button style that you can see when you put your mouse down a button
        exit.setOnMouseExited(e -> {
            exit.setStyle("-fx-background-color: #ae00ba;" + "-fx-background-radius: 5px;");
        });
        
        // Exit screen view
        exit.setOnAction(e -> {
            System.exit(0);
        });

        // Set child elements in buttons
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(newGame, exit);

        // Set screen placement
        mainScreenLayout.setPadding(new Insets(50));
        mainScreenLayout.setStyle("-fx-background-color: #000;");
        mainScreenLayout.setTop(gameOverImage);
        mainScreenLayout.setCenter(txtscore);
        mainScreenLayout.setBottom(buttons);

        // Additional screen settings
        gameOverStage.getIcons().add(new Image (getClass().getResourceAsStream("./Images/Icon.png")));
        gameOverStage.setTitle("GameOver");
        gameOverStage.setScene(scene);
        gameOverStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}