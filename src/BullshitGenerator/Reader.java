package BullshitGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    ArrayList<String> text;

    public Reader() throws FileNotFoundException {

        text = reader();
    }

    public ArrayList<String> reader() throws FileNotFoundException {
        ArrayList<String> text = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/BullshitGenerator/Txt files/ipartörténet.txt"));
        while (sc.hasNextLine()) {
            String word = sc.next();
            text.add(word);
            System.out.println(text);
        }
        return text;
    }

}