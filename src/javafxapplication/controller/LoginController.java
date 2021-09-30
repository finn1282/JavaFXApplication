package javafxapplication.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxapplication.EmailManager;
import javafxapplication.view.ViewFactory;

public class LoginController extends BaseController{
    
    public LoginController(EmailManager emailmanager, ViewFactory viewfactory, String fxml) {
        super(emailmanager, viewfactory, fxml);
    }

    @FXML
    private TextField EmailAdressField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Label ErrorLabel;

    @FXML
    void LoginButtonAction() {
        System.out.println("logged in");
        viewfactory.showMainWindow();
        Stage stage = (Stage) EmailAdressField.getScene().getWindow();
        viewfactory.close(stage);
    }

}
