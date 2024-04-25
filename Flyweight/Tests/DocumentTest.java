package Flyweight.Tests;

import Flyweight.Character;
import Flyweight.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

    class DocumentTest {

    private Document doc1;

    @BeforeEach
    void init(){
        doc1 = new Document();

        //Three fonts, three colors, three sizes
        doc1.addCharAtEnd('H', "Arial", "Red", 12);
        doc1.addCharAtEnd('E', "Arial", "Red", 14);
        doc1.addCharAtEnd('L', "Calibri", "Black", 14);
        doc1.addCharAtEnd('L', "Verdana", "Red", 16);
        doc1.addCharAtEnd('O', "Calibri", "Blue", 16);

    }
    @Test
    void deleteCharAtIndex() {
        doc1.deleteCharAtIndex(1);
        assertEquals('L', doc1.getCharacters().get(1).getCharacter());
    }

    @Test
    void removeLastChar() {
        doc1.removeLastChar();
        assertEquals('L', doc1.getCharacters().getLast().getCharacter());
    }

    @Test
    void addCharAtIndex() {
        doc1.addCharAtIndex(1, 'P', "Calibri", "Purple", 10);
        assertEquals('P', doc1.getCharacters().get(1).getCharacter());
    }

    @Test
    void addCharAtEnd() {
        doc1.addCharAtEnd( 'P', "Calibri", "Purple", 10);
        assertEquals('P', doc1.getCharacters().getLast().getCharacter());
    }

    @Test
    void saveAndLoad() {
        doc1.save("testfile.ser");
        File file = new File("testfile.ser");
        assertEquals(true, file.exists());

        Document doc2 = new Document();
        doc2.load("testfile.ser");

        for (int i = 0; i < doc1.getCharacters().size(); i++){

            Character doc1Char = doc1.getCharacters().get(i);
            Character doc2Char = doc2.getCharacters().get(i);

            assertEquals(doc1Char.getCharacter(), doc2Char.getCharacter());
            assertEquals(doc1Char.getFont().getFont(), doc2Char.getFont().getFont());
            assertEquals(doc1Char.getColor().getColor(), doc2Char.getColor().getColor());
            assertEquals(doc1Char.getSize().getSize(), doc2Char.getSize().getSize());

        }
    }


}