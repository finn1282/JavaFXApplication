package javafxapplication.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafxapplication.EmailManager;
import javafxapplication.view.FontSize;
import javafxapplication.view.Theme;
import javafxapplication.view.ViewFactory;

public class OptionsController extends BaseController implements Initializable {
    
    public OptionsController(EmailManager emailmanager, ViewFactory viewfactory, String fxml) {
        super(emailmanager, viewfactory, fxml);
    }

    @FXML
    private Slider FontSizeSlider;

    @FXML
    private ChoiceBox<Theme> ThemeBox;

    @FXML
    void ApplyButton() {
        viewfactory.setTheme(ThemeBox.getValue());
        viewfactory.setFontsize(FontSize.values()[(int)(FontSizeSlider.getValue())]);
        viewfactory.updateStyle();
    }

    @FXML
    void CancelButton() {
        Stage stage = (Stage) FontSizeSlider.getScene().getWindow();
        viewfactory.close(stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTheme();
        setupFontSize();
    }

    private void setupTheme() {
        ThemeBox.setItems(FXCollections.observableArrayList(Theme.values()));
        ThemeBox.setValue(viewfactory.getTheme());
    }

    private void setupFontSize() {
        FontSizeSlider.setMin(0);
        FontSizeSlider.setMax(FontSize.values().length - 1);
        FontSizeSlider.setValue(viewfactory.getFontsize().ordinal());
        FontSizeSlider.setMajorTickUnit(1);
        FontSizeSlider.setMinorTickCount(0);
        FontSizeSlider.setBlockIncrement(1);
        FontSizeSlider.setSnapToTicks(true);
        FontSizeSlider.setShowTickMarks(true);
        FontSizeSlider.setShowTickLabels(true);
        FontSizeSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSize.values()[i].toString();
            } 

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
        FontSizeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            FontSizeSlider.setValue(newVal.intValue());
        });
    }

}