package br.com.luizalabs.search.service;

import java.util.*;

public class FindService {

    private final Map<String, Set<String>> index;

    public FindService(final Map<String, Set<String>> index) {
        this.index = index;
    }

    public List<String> findByTerms(String[] words) {
        List<String> occurrences = new ArrayList<>();
        for (String word : words) {
            Set<String> resultsByWord = index.get(word);
            if (resultsByWord == null) { continue; }
            if (occurrences.isEmpty()) {
                occurrences.addAll(resultsByWord);
            } else {
                occurrences.retainAll(resultsByWord);
            }
        }
        Collections.sort(occurrences);
        return occurrences;
    }
}
