package SemanticsAnalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operatot {

    Database database;

    public Operatot(Database database) {
        this.database = database;
    }

    public void reader(String textPath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(textPath));

        List<String> texList = new ArrayList<>();

        while(sc.hasNextLine()) {
            String[] textParts = sc.nextLine().split(" ");
            for(String s : textParts){
                texList.add(s.replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}]",""));
            }
        }
        database.wordsFromText = texList;

    }

    public void getRealWords() {
        String[] conjuctives = {"a","az","és","de",
    }

}
