package br.com.luizalabs.search;

import java.util.List;
import java.util.Map;

public class Searcher {

    private final Map<String, List<String>> index;

    public Searcher(final Map<String, List<String>> index) {
        this.index = index;
    }

    public List<String> findByTerms(String sentence) {
        String[] words = sentence.split(" ");

        return IndexSearcher.search(index, words);
    }
}
