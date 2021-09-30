package javafxapplication;

import javafx.application.Application;
import javafx.stage.Stage;
import javafxapplication.view.ViewFactory;

public class JavaFXApplication extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewFactory viewfactory = new ViewFactory(new EmailManager());
        viewfactory.showLoginWindow();
    }
}
