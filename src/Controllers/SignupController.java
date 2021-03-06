package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignupController implements Initializable{
	 @FXML
	    private JFXTextField name;

	    @FXML
	    private JFXPasswordField password;

	    @FXML
	    private JFXTextField location;

	    @FXML
	    private JFXButton signup;

	    @FXML
	    private JFXButton login;

	    @FXML
	    private JFXRadioButton male;

	    @FXML
	    private JFXRadioButton female;
	    
	    @FXML
	    private Label genders;

		private Connection connection ;
	    private DBHandler handler;
	    private PreparedStatement pst;
	    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    
    	name.setStyle("-fx-text-inner-color: #a0a2ab;");
		password.setStyle("-fx-text-inner-color: #a0a2ab;");
    	location.setStyle("-fx-text-inner-color: #a0a2ab;");

    	handler = new DBHandler();
    }
    public String getGenders() {
		String gen = "";
		if(male.isSelected()) {
			gen = "Male";
		}
		else if(female.isSelected()) {
			gen = "Female";
		}
		return gen;
	}
	
    @FXML
	public void SignUP(ActionEvent e1) {
    	PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(ev ->{
			System.out.println("SignUP succesfully");
		});
		pt.play();
		
		//save
		
		
		String insert = "INSERT INTO immo (name,pass,gender,loc)"
                        + "VALUES (?,?,?,?)";	
		
		connection = handler.getConnection();
		try {
			pst = connection.prepareStatement(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			pst.setString(1, name.getText());
			pst.setString(2, password.getText());
			pst.setString(3, getGenders());
			pst.setString(4, location.getText());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
	@FXML
	public void LoginAction(ActionEvent e) throws IOException {
		signup.getScene().getWindow().hide();
		
		Stage login =new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		login.setScene(scene);
		login.show();
		login.setResizable(false);
	}

	
}
