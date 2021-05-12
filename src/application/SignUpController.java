package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox checkboxEblan;

    @FXML
    private CheckBox checkboxNeeblan;

    @FXML
    private TextField password_field;

    @FXML
    private TextField login_field;

    @FXML
    private Button enterButton;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField name_field;

   

    @FXML
    void initialize() {
    
    	enterButton.setOnAction(event -> {
    		DatabaseHandler dbHandler = new DatabaseHandler();
    		
    		String firstname = name_field.getText();
    		String surname = surname_field.getText();
    		String login = login_field.getText();
    		String password = password_field.getText();
    		String eblan = "";
    		
    		if (checkboxEblan.isSelected()) {
    			eblan = "Da";
    		}
    		else {
    			eblan = "Net";
    		}
    		
    		User user = new User(firstname, surname, login, password, eblan);
    		
    		try {
    			
				dbHandler.createUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	});
    }
}
