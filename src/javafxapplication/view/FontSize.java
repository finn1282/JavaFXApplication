package javafxapplication.view;

public enum FontSize {
    SMALL,
    MEDIUM,
    BIG;
    
    public static String getCSS(FontSize fontsize) {
        switch (fontsize) {
            case SMALL:
                return "css/fontSmall.css";
            case MEDIUM:
                return "css/fontMedium.css";
            case BIG:
                return "css/fontBig";
            default:
                return null;
        }
    }
}
