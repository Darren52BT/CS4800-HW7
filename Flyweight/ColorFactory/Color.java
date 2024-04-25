package Flyweight.ColorFactory;

import java.io.Serializable;

public class Color implements Serializable {

    private String color;
    public Color(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Color: " + this.color;
    }
}
