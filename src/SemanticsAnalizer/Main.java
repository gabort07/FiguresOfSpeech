package SemanticsAnalizer;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Database database = new Database();
        Operatot operatot = new Operatot(database);

        operatot.reader("files/szoveg.txt");
//        System.out.println(database.wordsFromText.toString());
//        System.out.println(database.wordAppearance);
        operatot.getCommonWords(database.wordAppearance, 10);
    }
}
