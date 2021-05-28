package br.com.luizalabs.search.service;

import java.util.*;

public class FindService {

    private final Map<String, Set<String>> index;

    public FindService(final Map<String, Set<String>> index) {
        this.index = index;
    }

    public List<String> findByTerms(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        List<String> occurrence = new ArrayList<>();
        for (String word : words) {
            Set<String> resultsByWord = index.get(word);
            if (resultsByWord != null) {
                if (occurrence.isEmpty()) {
                    occurrence.addAll(resultsByWord);
                } else {
                    occurrence.retainAll(resultsByWord);
                }
            }
        }
        return occurrence;
    }
}
