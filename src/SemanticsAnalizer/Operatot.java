package SemanticsAnalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Operatot {

    Database database;

    public Operatot(Database database) {
        this.database = database;
    }

    public void reader(String textPath) throws FileNotFoundException {
        Scanner sc2 = new Scanner(new File("files/exceptions.txt"));
        List<String> wordsToIgnore = new ArrayList<>();
        while (sc2.hasNextLine()) {
            wordsToIgnore.add(sc2.nextLine());
        }

        Scanner sc = new Scanner(new File(textPath));

        List<String> texList = new ArrayList<>();

        HashMap<String, Integer> wordsMap = new HashMap<>();
        while (sc.hasNextLine()) {
            String[] textParts = sc.nextLine().split(" ");
            for (String s : textParts) {
                String a = s;
                texList.add(a.trim().toLowerCase().replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}]", ""));
                boolean contains = false;
                for (int i = 0; i < wordsToIgnore.size(); i++) {
                    if (wordsToIgnore.get(i).equals(a)) {
                        contains = true;
                    }
                }
                if(!contains){
                    wordsMap.putIfAbsent(a, 1);
                    wordsMap.put(a, wordsMap.get(a) + 1);
                }
            }
        }

        database.wordAppearance = wordsMap;
        database.wordsFromText = texList;

    }


    public void isRealWords() {
        boolean contains = false;
        for (int i = 0; i < wordsToIgnore.size(); i++) {
            if (wordsToIgnore.get(i).equals(a)) {
                contains = true;
            }
        }
        if(!contains){
            wordsMap.putIfAbsent(a, 1);
            wordsMap.put(a, wordsMap.get(a) + 1);
        }

    }

}
