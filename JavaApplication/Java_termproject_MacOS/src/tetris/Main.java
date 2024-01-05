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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
	// Declare a container to configure the screen
    VBox mainView = new VBox(20);
    VBox buttons = new VBox(10);
    
    // Set the title
    Label title = new Label("TETRIS");
    
    // Declare button elements
    Button playBtn = new Button("PLAY");
    Button settingsBtn = new Button("SETTINGS");
    Button profileBtn = new Button("PROFILE");

    // Declare Main Image Variables
    Image mainImg = new Image(getClass().getResourceAsStream("./Images/Main.png"),180,180,false,false);
    ImageView imgView = new ImageView(mainImg);

    // Declare Full Screen Size Variables
    public static int XMAX = Tetris.XMAX;
    public static int YMAX = Tetris.YMAX;
    
    // Declare Full Screen Variables
    BorderPane mainScreenLayout = new BorderPane();
    Scene scene = new Scene(mainScreenLayout, XMAX, YMAX + 75);

    @Override
    public void start(Stage mainStage) throws IOException {
    	
    	// Determine the font and style of title
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 40));
        title.setStyle("-fx-text-fill: #060521;");

        mainView.setAlignment(Pos.CENTER); // center alignment
        mainView.getChildren().addAll(imgView, title); // Add child elements such as imgView and title

        // Play button setting
        playBtn.setMinWidth(180);
        playBtn.setMinHeight(30);
        playBtn.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        playBtn.setStyle( "-fx-background-color: #060521;" + "-fx-background-radius: 10px;" );
        playBtn.setTextFill(Color.WHITE);

        // The button style that you can see when you mouse over a button
        playBtn.setOnMouseEntered(e -> {
        	playBtn.setStyle("-fx-background-color: #AAA3D5; -fx-text-fill: white; -fx-background-radius: 10px;");
        });
        
        // The button style that you can see when you put your mouse down a button
        playBtn.setOnMouseExited(e -> {
        	playBtn.setStyle("-fx-background-color: #060521; -fx-background-radius: 10px;");
        });

        // Switch the screen to the game window when you click the button
        playBtn.setOnAction(e -> {
            try {
                Tetris tetris = new Tetris();
                tetris.start(new Stage());
                mainStage.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Profile button setting
        profileBtn.setMinWidth(180);
        profileBtn.setMinHeight(30);
        profileBtn.setFont(Font.font(20));
        profileBtn.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        profileBtn.setStyle("-fx-background-color: #060521;" + "-fx-background-radius: 10px;");
        profileBtn.setTextFill(Color.WHITE);

        // The button style that you can see when you mouse over a button
        profileBtn.setOnMouseEntered(e -> {
        	profileBtn.setStyle("-fx-background-color: #AAA3D5; -fx-text-fill: white; -fx-background-radius: 10px;");
        });
        
        // The button style that you can see when you put your mouse down a button
        profileBtn.setOnMouseExited(e -> {
        	profileBtn.setStyle("-fx-background-color: #060521;" + "-fx-background-radius: 10px;");
        });
        
        // Open a profile window when you click a button
        profileBtn.setOnAction(e -> {
            try {
                Profile profile = new Profile();
                profile.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Settings button setting
        settingsBtn.setMinWidth(180);
        settingsBtn.setMinHeight(30);
        settingsBtn.setFont(Font.font(20));
        settingsBtn.setFont(Font.font("Comic Sans MS", FontWeight. BOLD, 20));
        settingsBtn.setStyle("-fx-background-color: #060521;" + "-fx-background-radius: 10px;");
        settingsBtn.setTextFill(Color.WHITE);

        // The button style that you can see when you mouse over a button
        settingsBtn.setOnMouseEntered(e -> {
        	settingsBtn.setStyle("-fx-background-color: #AAA3D5;" + " -fx-text-fill: white;" + "-fx-background-radius: 10px;");
        });
        
        // The button style that you can see when you put your mouse down a button
        settingsBtn.setOnMouseExited(e -> {
        	settingsBtn.setStyle("-fx-background-color: #060521;" +  "-fx-background-radius: 10px;" );
        });
        
        // Open a settings window when you click a button
        settingsBtn.setOnAction(e -> {
            try {
                Settings settings = new Settings();
                settings.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        buttons.setAlignment(Pos.CENTER); // Buttons center alignment
        buttons.getChildren().addAll(playBtn, profileBtn, settingsBtn); // Add 3 type of button elements
        
        // Set screen placement
        mainScreenLayout.setTop(mainView);
        mainScreenLayout.setBottom(buttons);
        mainScreenLayout.setPadding(new Insets(70)); // Add padding
        mainScreenLayout.setStyle("-fx-background-color: #FDFEEF;"); // Full screen color settings
        
        // Additional screen settings
        mainStage.setTitle("Tetris");
        mainStage.getIcons().add(new Image(getClass().getResourceAsStream("./Images/Icon.png")));
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}