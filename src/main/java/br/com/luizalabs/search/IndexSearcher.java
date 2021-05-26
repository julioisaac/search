package br.com.luizalabs.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IndexSearcher {

    public static final List<String> search(Map<String, List<String>> index,String word) {
        String wordMin = word.toLowerCase();
        List<String> resultsByWord = index.get(wordMin) != null ? index.get(wordMin) : new ArrayList<>();
        return resultsByWord;
    }

    public static final List<String> search(Map<String, List<String>> index, String[] words) {
        List<String> ocorrences = new ArrayList<>();
        for (String word : words) {
            String wordMin = word.toLowerCase();
            List<String> resultsByWord = index.get(wordMin);
            if (resultsByWord != null) {
                if (ocorrences.isEmpty()) {
                    ocorrences.addAll(resultsByWord);
                }
                else {
                    ocorrences.retainAll(resultsByWord);
                }
            }
        }
        return ocorrences;
    }

}
