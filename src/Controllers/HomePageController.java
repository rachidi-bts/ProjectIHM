package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HomePageController implements Initializable {

	@FXML
	 AnchorPane holderpane;
	@FXML
	private Text welcome;

	@FXML
	private VBox menu;

	@FXML
	private JFXButton logout;

	@FXML
	private JFXButton exit;

	@FXML
	private AnchorPane annonce;

	AnchorPane home;

	@Override
	public void initialize(URL arg0, ResourceBundle args1) {
		
		createPage();
		openMenu();
	}

	private void openMenu() {
		JFXPopup pop = new JFXPopup();
		pop.setPopupContent(logout);
		
		
		
		
		
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
