package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField password_field;

    @FXML
    private Button sosatButton;

    @FXML
    private TextField login_field;

    @FXML
    private Label golosowanie_text;

    @FXML
    private Button enterButton;

    @FXML
    private Label eblia_text;

  

    @FXML
    void initialize() {
    	enterButton.setOnAction(event -> {
    		String logintext = login_field.getText().trim();
    		String loginpassword = password_field.getText().trim();
    		
    		if (!logintext.equals("") && !loginpassword.equals("")) {
    			loginUser(logintext,loginpassword);
    		}
    		else System.out.println("Error!!!");
    	});
    	
    	
    	sosatButton.setOnAction(event -> {
    		sosatButton.getScene().getWindow().hide();
    		
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/view/autorise.fxml"));
    		try {
				loader.load();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
    		
    		Parent root = loader.getRoot();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
    		stage.showAndWait();
    		
    	});

    }



	private void loginUser(String logintext, String loginpassword) {
		DatabaseHandler dbHandler = new DatabaseHandler();
		User user = new User();
		user.setLogin(logintext);
		user.setPassword(loginpassword);
		
		ResultSet result = dbHandler.getUser(user);
		
	
		
		try {
			if(result.next()) {
				System.out.println("Success!");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	

			
		}
	}

