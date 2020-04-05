package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Duration;

public class LoginController implements Initializable {
	@FXML
	private JFXButton signup;

	@FXML
	private JFXButton login;

	@FXML
	private JFXButton forgotpassword;

	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXTextField username;

	@FXML
	private JFXCheckBox remember;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		username.setStyle("-fx-text-inner-color: #a0a2ab;");
		password.setStyle("-fx-text-inner-color: #a0a2ab;");

	}
	@FXML
	public void LoginAction(ActionEvent e) {
		
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(ev ->{
			System.out.println("Login succesfully");
		});
		pt.play();
	}
	

}
