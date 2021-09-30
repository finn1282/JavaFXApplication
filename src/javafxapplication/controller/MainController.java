package javafxapplication.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;
import javafxapplication.EmailManager;
import javafxapplication.view.ViewFactory;

public class MainController extends BaseController{
    
    public MainController(EmailManager emailmanager, ViewFactory viewfactory, String fxml) {
        super(emailmanager, viewfactory, fxml);
    }

    @FXML
    private TreeView<?> TreeView;

    @FXML
    private TableView<?> TableView;

    @FXML
    private WebView WebView;

    @FXML
    void OptionsMenu() {
        viewfactory.showOptionsWindow();
    }

}
