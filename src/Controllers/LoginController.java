package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import DBConnection.DBHandler;
import application.Main;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
	
	private Connection connection ;
    private DBHandler handler;
    private PreparedStatement pst;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		username.setStyle("-fx-text-inner-color: #a0a2ab;");
		password.setStyle("-fx-text-inner-color: #a0a2ab;");

    	handler = new DBHandler();

	}
	@FXML
	public void LoginAction(ActionEvent e) {
		
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(ev ->{
			System.out.println("Login succesfully");
		});
		pt.play();
		
		//Retrive data from DB
		
		connection = handler.getConnection();
	  String sql = "SELECT * from immo where name=? and pass=? ";
				
				try {
					pst = connection.prepareStatement(sql);
					pst.setString(1, username.getText());
					pst.setString(2, password.getText());
				ResultSet rs = pst.executeQuery();
				
				int count=0;
				
				while (rs.next()) {
					count=count+1;
				}
				if (count==1) {
					System.out.println("Login succesfull");
				} else {
					System.out.println("username or password incorrect");

				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
	}
	
	@FXML
	public void SignUP(ActionEvent e1) throws IOException {
		login.getScene().getWindow().hide();
		
		Stage signup =new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource("/FXML/SignUP.fxml"));
		Scene scene = new Scene(root);
		signup.setScene(scene);
		signup.show();
		signup.setResizable(false);
	}
}
