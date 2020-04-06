package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main2;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class HomePageController implements Initializable {

@FXML AnchorPane holderpane;
  
 AnchorPane home;

@Override
public void initialize(URL arg0, ResourceBundle args1) {
createPage();	
}

private void setNode(Node node) {
	holderpane.getChildren().clear();
	holderpane.getChildren().add((Node) node);
	
	FadeTransition ft = new FadeTransition(Duration.millis(1550));
	ft.setNode(node);
	ft.setFromValue(0.1);
	ft.setToValue(1);
	ft.setCycleCount(1);
	ft.setAutoReverse(false);
	ft.play();
	
}

private void createPage() {
	try {
		home = FXMLLoader.load(getClass().getResource("/FXML/Annonce.fxml"));
	setNode(home);
	
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
 
 
}
