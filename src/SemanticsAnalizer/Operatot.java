package SemanticsAnalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Operatot {

    Database database;

    public Operatot(Database database) {
        this.database = database;
    }

    public void userInputReade(String userInput){
        String[] textParts = userInput.split(" ");
        stringDecoder(textParts);
    }

    public void reader(String textPath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(textPath));
        while (sc.hasNextLine()) {
            String[] textParts = sc.nextLine().split(" ");
            stringDecoder(textParts);
        }
    }

    public void stringDecoder(String[] stringArray) {
        for (String s : stringArray) {
            String a = s.trim().toLowerCase().replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}]", "");
            if (!a.equals("")) {
                database.wordsFromText.add(a);
                mapBuilder(database.wordAppearance, database.wordsToIgnore, a);
            }
        }
    }

    public void makeExceptionList(List<String> wordsToIgnore) throws FileNotFoundException {
        Scanner sc2 = new Scanner(new File("files/exceptions.txt"));
        while (sc2.hasNextLine()) {
            wordsToIgnore.add(sc2.nextLine());
        }
    }

    public void getCommonWords(Map<String, Integer> wordsMap, int size) {
        TreeMap<Integer, ArrayList<String>> mapByAppearance = new TreeMap<>();

        for (String word : wordsMap.keySet()) {
            mapByAppearance.putIfAbsent(wordsMap.get(word), new ArrayList<>());
            mapByAppearance.get(wordsMap.get(word)).add(word);
        }

        ArrayList<String> words = new ArrayList<>();
        while (words.size() < size) {
            for (String s : mapByAppearance.get(mapByAppearance.lastKey())) {
                words.add(s);
            }
            mapByAppearance.remove(mapByAppearance.lastKey());
        }

        System.out.println(words.toString());
    }

    public void mapBuilder(HashMap<String, Integer> wordsMap, List<String> wordsToIgnore, String a) {
        boolean contains = false;
        for (String s : wordsToIgnore) {
            if (a.equals("") || s.equals(a)) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            wordsMap.putIfAbsent(a, 1);
            wordsMap.put(a, wordsMap.get(a) + 1);
        }
    }
}


