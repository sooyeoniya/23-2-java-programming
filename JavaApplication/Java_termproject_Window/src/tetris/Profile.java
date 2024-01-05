package tetris;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Profile extends Application {
	// Declare My Information Labels
	Label myName = new Label("CHOI SOO YEON");
	Label myClassNum = new Label("2020136129");
    Label myMajor = new Label("Department of Computer Engineering");
    Label thisClass = new Label("Java Programming Class");
    Label thisTopic = new Label("Java TermProject: Tetris");

    // Declare Profile Image Variables
    Image profile = new Image(getClass().getResourceAsStream("\\images\\Profile.jpg"),132,176,false,false);
    ImageView profileView = new ImageView(profile);
    
    // Declare Koreatech Image Variables
    Image koreatechLogo = new Image(getClass().getResourceAsStream("\\images\\Koreatech.png"));
    ImageView koreatechLogoView = new ImageView(koreatechLogo);
    
    // Declare layout variables
    VBox profileImage = new VBox(10);
    Pane profileText = new Pane();
    VBox mainScreenLayout = new VBox(20);
    Scene scene = new Scene(mainScreenLayout, 450, 675);

    @Override
    public void start(Stage Profile) {
    	// Set each text style and positioning
    	myName.setTextFill(Color.WHITE);
    	myName.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        
    	myClassNum.setTextFill(Color.web("#C4E8CB"));
    	myClassNum.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
    	myClassNum.setTranslateY(50);
    	
    	myMajor.setTextFill(Color.web("#C4E8CB"));
    	myMajor.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
    	myMajor.setTranslateY(90);

    	thisClass.setTextFill(Color.web("#C9C6EC"));
    	thisClass.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
    	thisClass.setTranslateY(130);
    	
    	thisTopic.setTextFill(Color.web("#C9C6EC"));
    	thisTopic.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
    	thisTopic.setTranslateY(170);
    	
    	koreatechLogoView.setTranslateY(220);

    	// ProfileImage center alignment
        profileImage.setAlignment(Pos.CENTER);
        profileImage.getChildren().addAll(profileView);

        // Set child elements in profileText
        profileText.setTranslateX(-30);
        profileText.getChildren().addAll(myName, myClassNum, myMajor, thisClass, thisTopic, koreatechLogoView);
        
        mainScreenLayout.getChildren().addAll(profileImage, profileText); // Set screen placement
        mainScreenLayout.setPadding(new Insets(70)); // Add padding
        mainScreenLayout.setStyle("-fx-background-color: #000000;"); // Full screen color settings

        // Additional screen settings
        Profile.getIcons().add(new Image(getClass().getResourceAsStream("\\images\\Icon.png")));
        Profile.setTitle("Profile");
        Profile.setScene(scene);
        Profile.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}