package javafxapplication.view;

public enum Theme {
    DEFAULT,
    DARK,
    LIGHT;
    
    public static String getCSS(Theme theme) {
        switch (theme) {
            case DEFAULT:
                return "css/themeDefault.css";
            case DARK:
                return "css/themeDark.css";
            case LIGHT:
                return "css/themeLight.css";
            default:
                return null;
        }
    }
    
}
