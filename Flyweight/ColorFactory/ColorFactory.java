package Flyweight.ColorFactory;

import java.util.HashMap;

public class ColorFactory {

    private static ColorFactory colorFactory;
    private HashMap<String, Color> colorMap;

    private ColorFactory(){
        this.colorMap = new HashMap<>();
    }

    public static ColorFactory getColorFactory(){
        if(colorFactory == null){
            colorFactory = new ColorFactory();
        }
        return colorFactory;
    }

    public Color getColor(String color){
        if (!this.colorMap.containsKey(color)){
            this.colorMap.put(color, new Color(color));
        }
        return this.colorMap.get(color);
    }

    public HashMap<String, Color> getColorMap() {
        return colorMap;
    }
}
