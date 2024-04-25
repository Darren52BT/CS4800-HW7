package Flyweight.Tests;
import Flyweight.FontFactory.FontFactory;
import Flyweight.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class FontFactoryTest {

    Document doc1;
    @BeforeEach
    void setUp() {
        doc1 = new Document();

        //Three fonts, three colors, three sizes
        doc1.addCharAtEnd('H', "Arial", "Red", 12);
        doc1.addCharAtEnd('E', "Arial", "Red", 14);
        doc1.addCharAtEnd('L', "Calibri", "Black", 14);
        doc1.addCharAtEnd('L', "Verdana", "Red", 16);
        doc1.addCharAtEnd('O', "Calibri", "Blue", 16);
    }

    @Test
    void testFlyweight(){
        assertEquals(3, FontFactory.getFontFactory().getFontMap().values().size());
    }
}