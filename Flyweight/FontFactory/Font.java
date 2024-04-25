package Flyweight.FontFactory;

import java.io.Serializable;

public class Font implements Serializable {
    private static final long serialVersionUID = 2L;

    private String font;

    public Font(String font){
        this.font = font;
    }

    public String getFont() {
        return font;
    }

    @Override
    public String toString() {
        return "Font: " + this.font;
    }
}
