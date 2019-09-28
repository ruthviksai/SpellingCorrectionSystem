import java.util.*;
import java.io.*;

public class SpellCorrection {

    public static Map<String, List<String>> dict = new Hashtable();

    public static void main (String[] args) {
        try  {
            createDict("/Users/ruthvik/IdeaProjects/SpellCorrector/src/dict.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String word = "shawrty";

        List<String> similarWords = dict.get(Soundex.getSoundexCode(word));
        Map<Integer, List<String>> phons = new TreeMap<>();

        for (String phon: similarWords) {
            int distance = LevenshteinDistance.findMinDistance(word, phon);
            if (distance < 4) {
                if (phons.get(distance) == null) {
                    phons.put(distance, new ArrayList<>());
                }
                phons.get(distance).add(phon);
            }
        }

        for (Map.Entry<Integer, List<String>> entry: phons.entrySet()) {
            int distance = entry.getKey();
            for (String phon: entry.getValue()) {
                System.out.println(phon + " - " + distance);
            }
        }
    }

    public static void createDict(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();

            while (line != null) {
                String soundexCode = Soundex.getSoundexCode(line);
                if (dict.get(soundexCode) == null) {
                    dict.put(soundexCode, new ArrayList<>());
                }
                dict.get(soundexCode).add(line);
                line = br.readLine();
            }
        }
    }
}
