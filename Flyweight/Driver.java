package Flyweight;

public class Driver {
    public static void main(String[] args) {
        Document doc1 = new Document();

        //three different fonts, three different colors, three different sizes
        doc1.addCharAtEnd('H', "Arial", "Red", 12);
        doc1.addCharAtEnd('E', "Arial", "Red", 14);
        doc1.addCharAtEnd('L', "Calibri", "Red", 14);
        doc1.addCharAtEnd('L', "Arial", "Red", 16);
        doc1.addCharAtEnd('O', "Calibri", "Blue", 16);
        doc1.addCharAtEnd('W', "Arial", "Green", 14);
        doc1.addCharAtEnd('O', "Verdana", "Blue", 12);
        doc1.addCharAtEnd('R', "Calibri", "Green", 14);
        doc1.addCharAtEnd('L', "Calibri", "Green", 12);
        doc1.addCharAtEnd('D', "Verdana", "Red", 16);
        doc1.addCharAtEnd('C', "Calibri", "Blue", 16);
        doc1.addCharAtEnd('S', "Verdana", "Green", 14);
        doc1.addCharAtEnd('5', "Calibri", "Red", 14);
        doc1.addCharAtEnd('8', "Arial", "Blue", 12);
        doc1.addCharAtEnd('0', "Verdana", "Green", 16);
        doc1.addCharAtEnd('0', "Calibri", "Red", 14);

        doc1.save("example1.ser");

        Document doc2 = new Document();
        doc2.load("example1.ser");
        doc2.print();
        doc2.save("example2.ser");

    }
}
