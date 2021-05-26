package br.com.luizalabs.index.indexer;

import br.com.luizalabs.index.indexer.common.WordTransformer;

public class SanitizeWordTransformer implements WordTransformer {

    @Override
    public String process(String word) {
        return word.replaceAll("[^a-zA-Z0-9]", "");
    }

    @Override
    public boolean enable(String word) {
        return true;
    }
}
