package Flyweight;

import java.io.*;
import java.util.ArrayList;

public class Document {

    private ArrayList<Character> characters;

    public Document() {
        this.characters = new ArrayList<>();
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void deleteCharAtIndex(int index) {
        if (index < 0 || index >= this.characters.size()) {
            return;
        }
        this.characters.remove(index);
    }

    public void removeLastChar() {
        this.characters.removeLast();
    }

    public void addCharAtIndex(int index, char character, String font, String color, Integer size) {

        if (index < 0 || index >= this.characters.size()) {
            return;
        }

        this.characters.add(index, new Character(character, color, font, size));
    }
    public void addCharAtEnd(char character, String font, String color, Integer size) {
        this.characters.addLast(new Character(character, color, font, size));
    }

    public void save(String filename) {
        try  {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(characters);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String otherFilename) {
        try  {
            FileInputStream fileIn = new FileInputStream(otherFilename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.characters = (ArrayList<Character>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for (Character character : this.characters){
            System.out.println(character);
        }
    }

}
