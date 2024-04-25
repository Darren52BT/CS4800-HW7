package Flyweight;

import Flyweight.ColorFactory.Color;
import Flyweight.ColorFactory.ColorFactory;
import Flyweight.FontFactory.Font;
import Flyweight.FontFactory.FontFactory;
import Flyweight.SizeFactory.Size;
import Flyweight.SizeFactory.SizeFactory;

import java.io.Serializable;

public class Character implements Serializable {

    private static final long serialVersionUID = 4L;

    private char character;

    private Color color;
    private Font font;

    private Size size;

    public Character(char character, String color, String font,  Integer size){
        this.character = character;
        this.color = ColorFactory.getColorFactory().getColor(color);
        this.font = FontFactory.getFontFactory().getFont(font);
        this.size = SizeFactory.getSizeFactory().getFont(size);
    }


    public char getCharacter() {
        return character;
    }

    public Color getColor() {
        return color;
    }

    public Font getFont() {
        return font;
    }

    public Size getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = ColorFactory.getColorFactory().getColor(color);
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setFont(String font){
        this.font = FontFactory.getFontFactory().getFont(font);
    }

    public void setSize (Integer size){
        this.size = SizeFactory.getSizeFactory().getFont(size);

    }

    @Override
    public String toString() {
        return "Character: " + character + ", " + this.font.toString() + ", " + this.color.toString() + ", " + this.size.toString();
    }
}
