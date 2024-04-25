package Flyweight.FontFactory;

import java.util.HashMap;

public class FontFactory {
    private static FontFactory fontFactory;
    private HashMap<String, Font> fontMap;

    private FontFactory() {
        this.fontMap = new HashMap<>();
    }

    public static FontFactory getFontFactory() {
        if (fontFactory == null) {
            fontFactory = new FontFactory();
        }
        return fontFactory;
    }

    public Font getFont(String font) {
        if (!this.fontMap.containsKey(font)) {
            this.fontMap.put(font, new Font(font));
        }
        return this.fontMap.get(font);
    }

    public HashMap<String, Font> getFontMap() {
        return fontMap;
    }
}
