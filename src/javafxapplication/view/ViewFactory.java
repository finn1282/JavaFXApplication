package javafxapplication.view;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxapplication.EmailManager;
import javafxapplication.controller.BaseController;
import javafxapplication.controller.LoginController;
import javafxapplication.controller.MainController;
import javafxapplication.controller.OptionsController;

public class ViewFactory {
    private EmailManager emailmanager;
    private ArrayList<Stage> activestage;
    
    public ViewFactory(EmailManager emailmanager) {
        this.emailmanager = emailmanager;
        activestage = new ArrayList<Stage>();
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public FontSize getFontsize() {
        return fontsize;
    }

    public void setFontsize(FontSize fontsize) {
        this.fontsize = fontsize;
    }
    
    private Theme theme = Theme.DEFAULT;
    private FontSize fontsize = FontSize.MEDIUM;
    
    public void showLoginWindow(){
        BaseController controller = new LoginController(emailmanager, this, "login.fxml");
        Initialize(controller);
    }
    
    public void showMainWindow() {
        BaseController controller = new MainController(emailmanager, this, "main.fxml");
        Initialize(controller);
        
    }
    
    public void showOptionsWindow() {
        BaseController controller = new OptionsController(emailmanager, this, "options.fxml");
        Initialize(controller);
    }
    
    private void Initialize(BaseController controller) {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(controller.getFxml()));
        fxmlloader.setController(controller);
        Parent parent;
        try {
            parent = fxmlloader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activestage.add(stage);
    }
    
    public void close(Stage stage) {
        stage.close();
        activestage.remove(stage);
    }

    public void updateStyle() {
        for (Stage stage: activestage) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(Theme.getCSS(theme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCSS(fontsize)).toExternalForm());
        }
    }
}
