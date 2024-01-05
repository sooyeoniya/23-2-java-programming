package tetris;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Settings extends Application {
	// Declare Settings' Labels
    Label gameMode = new Label("Game Mode: ");
    Label theme = new Label("Theme: ");
    
    // Declare Settings' ComboBoxes
    ComboBox<String> CBGameMode = new ComboBox<>();
    ComboBox<String> CBTheme = new ComboBox<>();

    // Declare layout variables
    HBox hGameMode = new HBox(20);
    HBox hColorMode = new HBox(20);
    BorderPane mainScreenLayout = new BorderPane();
    Scene scene = new Scene(mainScreenLayout, 350, 150);
    
    @Override
    public void start(Stage settingsStage) {
    	// Set each text style
    	gameMode.setTextFill(Color.WHITE);
    	gameMode.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
    	
    	theme.setTextFill(Color.WHITE);
        theme.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        
        // Set CBGameMode
        CBGameMode.getItems().addAll("Easy", "Normal", "Hard"); // Set Sub menus in the ComboBox
        CBGameMode.getSelectionModel().select(1); // Set Default Value: Normal
        CBGameMode.setStyle("-fx-background-color: #E6E6E6;" + "-fx-text-fill: #333333;" + "-fx-pref-height: 30px;"
        + "-fx-pref-width: 110px;" + "-fx-background-radius: 5px;" + "-fx-font-family: Verdana;" + "-fx-font-size: 15px;");

        CBGameMode.setOnAction(e -> { // Change to selected mode
            String selected = CBGameMode.getValue();
            switch (selected) {
                case "Easy":
                	Tetris.dur = 900;
                    break;
                case "Normal":
                    Tetris.dur = 300;
                    break;
                case "Hard":
                    Tetris.dur = 100;
                    break;
            }
        });

        // Set CBGameMode
        CBTheme.getItems().addAll("Dark", "White", "Black"); // Set Sub menus in the ComboBox
        CBTheme.getSelectionModel().select(0); // Set Default Value: Dark
        CBTheme.setStyle("-fx-background-color: #E6E6E6;" + "-fx-text-fill: #333333;" + "-fx-pref-height: 30px;"
        + "-fx-pref-width: 110px;" + "-fx-background-radius: 5px;" + "-fx-font-family: Verdana;" + "-fx-font-size: 15px;");

        CBTheme.setOnAction(e -> { // Change to selected theme color
            String getvalue = CBTheme.getValue();
            if (getvalue == "Dark") {
            	// Change the font color of the Tetris screen
                Tetris.color = "#222738";
                Tetris.textColor = Color.web("#FFF");
                // Change the font color of the Settings screen
                mainScreenLayout.setStyle("-fx-background-color: #222738;");
                gameMode.setTextFill(Color.WHITE);
                theme.setTextFill(Color.WHITE);
            }
            else if (getvalue == "White") {
            	// Change the font color of the Tetris screen
                Tetris.color = "#FFF";
                Tetris.textColor = Color.web("#000");
                // Change the font color of the Settings screen
                mainScreenLayout.setStyle("-fx-background-color: #FFF;");
                gameMode.setTextFill(Color.BLACK);
                theme.setTextFill(Color.BLACK);
            }
            else if (getvalue == "Black") {
            	// Change the font color of the Tetris screen
                Tetris.color = "#000000";
                Tetris.textColor = Color.web("#FFF");
                // Change the font color of the Settings screen
                mainScreenLayout.setStyle("-fx-background-color: black;");
                gameMode.setTextFill(Color.WHITE);
                theme.setTextFill(Color.WHITE);
            }
        });
        
        // hGameMode center alignment
        hGameMode.setAlignment(Pos.CENTER);
        hGameMode.getChildren().addAll(gameMode, CBGameMode);

        // hColorMode center alignment
        hColorMode.setAlignment(Pos.CENTER);
        hColorMode.getChildren().addAll(theme, CBTheme);

        // Set screen placement
        mainScreenLayout.setTop(hGameMode);
        mainScreenLayout.setBottom(hColorMode);
        mainScreenLayout.setPadding(new Insets(30)); // Add padding
        mainScreenLayout.setStyle("-fx-background-color: #252B39;"); // Full screen color settings

        // Additional screen settings
        settingsStage.getIcons().add(new Image(getClass().getResourceAsStream("\\images\\Icon.png")));
        settingsStage.setTitle("Settings");
        settingsStage.setScene(scene);
        settingsStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}