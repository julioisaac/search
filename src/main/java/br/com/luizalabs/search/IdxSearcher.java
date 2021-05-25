package br.com.luizalabs.search;

import br.com.luizalabs.utils.Index;

import java.util.ArrayList;
import java.util.List;

public class IdxSearcher {

    public List<String> search(final Index index, String word) {
        String wordMin = word.toLowerCase();
        List<String> resultsByWord = index.getIndex().get(wordMin) != null ? index.getIndex().get(wordMin) : new ArrayList<>();
        return resultsByWord;
    }

    public List<String> search(final Index index, String[] words) {
        List<String> ocorrences = new ArrayList<>();
        for (String word : words) {
            String wordMin = word.toLowerCase();
            List<String> resultsByWord = index.getIndex().get(wordMin);
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
