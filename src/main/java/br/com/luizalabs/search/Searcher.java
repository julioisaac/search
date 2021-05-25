package br.com.luizalabs.search;

import br.com.luizalabs.utils.Index;

import java.util.List;

public class Searcher {

    private IdxSearcher idxSearcher;
    private static Index index;

    public Searcher(final Index index) {
        idxSearcher = new IdxSearcher();
        this.index = index;
    }

    public List<String> findByTerms(String sentence) {
        String[] words = sentence.split(" ");

        return idxSearcher.search(index, words);
    }
}
