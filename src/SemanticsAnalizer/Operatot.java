package SemanticsAnalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        List<String> texList = new ArrayList<>();
        textDecoder(texList, wordsToIgnore, textPath);
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

    public void textDecoder(List<String> texList, List<String> wordsToIgnore, String textPath) throws
            FileNotFoundException {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        Scanner sc = new Scanner(new File(textPath));
        while (sc.hasNextLine()) {
            String[] textParts = sc.nextLine().split(" ");
            for (String s : textParts) {
                String a = s.trim().toLowerCase().replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}]", "");
                texList.add(a);
                mapBuilder(wordsMap, wordsToIgnore, a);
            }
        }

        database.wordAppearance = wordsMap;
        database.wordsFromText = texList;

    }

    public void mapBuilder(HashMap<String, Integer> wordsMap, List<String> wordsToIgnore, String a) {
        boolean contains = false;
        for (String s : wordsToIgnore) {
            if (s.equals(a)) {
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


