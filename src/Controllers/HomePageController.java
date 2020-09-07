package Controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomePageController implements Initializable {

	@FXML
	 AnchorPane holderpane;
	@FXML
	private Text welcome;
	@FXML
	private JFXButton contact;
	@FXML
	private VBox menu;

	@FXML
	private JFXButton logout;
	@FXML
	private JFXButton annonces;

	@FXML
	private JFXButton exit;
	@FXML
	private JFXButton email;

	@FXML
	private AnchorPane annonce;

	AnchorPane home;
	
	AnchorPane main;
	@FXML
	private JFXButton details;
	@Override
	public void initialize(URL arg0, ResourceBundle args1) {
		
		openMenu();
	}

	private void openMenu() {
		JFXPopup pop = new JFXPopup();
		pop.setPopupContent(logout);
	}
		
	
	@FXML
	public void Logout(ActionEvent e1) throws IOException {
		holderpane.getScene().getWindow().hide();

		Stage logout = new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		logout.setScene(scene);
		logout.show();
		logout.setResizable(false);
	} 
	@FXML
	public void Contact(ActionEvent e1) throws IOException {
		holderpane.getScene().getWindow().hide();

		Stage contact = new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource("/FXML/ContactUs.fxml"));
		Scene scene = new Scene(root);
		contact.setScene(scene);
		contact.show();
		contact.setResizable(false);
	} 
	@FXML
	public void Annonces(ActionEvent e1) throws IOException {
		holderpane.getScene().getWindow().hide();

		Stage annonces = new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource("/FXML/HomePage.fxml"));
		Scene scene = new Scene(root);
		annonces.setScene(scene);
		annonces.show();
		annonces.setResizable(false);
	} 

	@FXML
	public void Details(ActionEvent e1) throws IOException {
		holderpane.getScene().getWindow().hide();

		Stage details = new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource("/FXML/AnnonceDetails.fxml"));
		Scene scene = new Scene(root);
		details.setScene(scene);
		details.show();
		details.setResizable(false);
	}  
	@FXML
	public void Email(ActionEvent e1) throws IOException {
		holderpane.getScene().getWindow().hide();

		Stage email = new Stage();
		if(Desktop.isDesktopSupported()) //ou alors tu cast un exception
		{
		  try {
			Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/#inbox?compose=CllgCKCBBJCQHwWqDlkNvnQFkKnqFfjgFgBQKmcWCSXztbkPfSzhcQFTpbxttmTjrFctdJRBfcg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}  
	 }

