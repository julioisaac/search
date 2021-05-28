package br.com.luizalabs.search.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindService {

    private final Map<String, Set<String>> index;

    public FindService(final Map<String, Set<String>> index) {
        this.index = index;
    }

    public Set<String> findByTerms(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        Set<String> occurrence = new HashSet<>();
        for (String word : words) {
            Set<String> resultsByWord = index.get(word);
            if (resultsByWord != null) {
                if (occurrence.isEmpty()) {
                    occurrence = resultsByWord;
                } else {
                    occurrence.retainAll(resultsByWord);
                }
            }
        }
        return occurrence;
    }
}
