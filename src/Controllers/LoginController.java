package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
		
	}

	

}
