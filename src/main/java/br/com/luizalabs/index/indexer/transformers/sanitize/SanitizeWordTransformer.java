package br.com.luizalabs.index.indexer.transformers.sanitize;

import br.com.luizalabs.index.indexer.transformers.WordTransformer;

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
