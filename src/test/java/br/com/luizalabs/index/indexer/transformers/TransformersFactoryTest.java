package br.com.luizalabs.index.indexer.transformers;

import br.com.luizalabs.index.indexer.transformers.sanitize.SanitizeWordTransformer;
import br.com.luizalabs.index.indexer.transformers.stopwords.StopWordTransformer;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransformersFactoryTest {

    static class ReplaceAWordTransformer implements WordTransformer {
        @Override
        public String process(String word) {
            return word.replaceAll("a", "");
        }
        @Override
        public boolean enable(String word) {
            return true;
        }
    }
    static class CamelCaseWordTransformer implements WordTransformer {
        @Override
        public String process(String word) {
            return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }
        @Override
        public boolean enable(String word) {
            return true;
        }
    }

    static class StemmingWordTransformer implements WordTransformer {
        @Override
        public String process(String word) {
            int length = word.length();
            if (length > 7)
                return word.substring(0, length - 3) ;
            return word;
        }
        @Override
        public boolean enable(String word) {
            return true;
        }
    }

    @Test
    void shouldRemoveA() {
        List<WordTransformer> wordTransformerList = new ArrayList<>();
        wordTransformerList.add(new ReplaceAWordTransformer());
        String result = TransformersFactory.reword(wordTransformerList, "atestou");
        assertEquals("testou", result);
    }

    @Test
    void shouldTransformCamelCase() {
        List<WordTransformer> wordTransformerList = new ArrayList<>();
        wordTransformerList.add(new CamelCaseWordTransformer());
        String result = TransformersFactory.reword(wordTransformerList, "analisar");
        assertEquals("Analisar", result);
    }

    @Test
    void shouldSanitize() {
        List<WordTransformer> wordTransformerList = new ArrayList<>();
        wordTransformerList.add(new SanitizeWordTransformer());
        String result = TransformersFactory.reword(wordTransformerList, "}[?caracteres!]");
        assertEquals("caracteres", result);
    }

    @Test
    void shouldStop() {
        List<WordTransformer> wordTransformerList = new ArrayList<>();
        wordTransformerList.add(new StopWordTransformer());
        String result = TransformersFactory.reword(wordTransformerList, "de");
        assertNull(result);
    }

    @Test
    void shouldStemming() {
        List<WordTransformer> wordTransformerList = new ArrayList<>();
        wordTransformerList.add(new StemmingWordTransformer());
        String result = TransformersFactory.reword(wordTransformerList, "stemming");
        assertEquals("stemm", result);
    }

    @Test
    void shouldApplyManyTransformers() {
        List<WordTransformer> wordTransformerList = new ArrayList<>();
        wordTransformerList.add(new SanitizeWordTransformer());
        wordTransformerList.add(new StemmingWordTransformer());
        wordTransformerList.add(new ReplaceAWordTransformer());
        wordTransformerList.add(new CamelCaseWordTransformer());
        String result = TransformersFactory.reword(wordTransformerList, "consociação!");
        assertEquals("Consoc", result);
    }
}
