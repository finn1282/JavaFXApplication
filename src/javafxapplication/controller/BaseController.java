package javafxapplication.controller;

import javafxapplication.EmailManager;
import javafxapplication.view.ViewFactory;

public abstract class BaseController {
    protected EmailManager emailmanager;
    protected ViewFactory viewfactory;
    private String fxml;

    public BaseController(EmailManager emailmanager, ViewFactory viewfactory, String fxml) {
        this.emailmanager = emailmanager;
        this.viewfactory = viewfactory;
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }
    
    
}
