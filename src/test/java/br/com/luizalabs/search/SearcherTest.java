package br.com.luizalabs.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTest {

    @Test
    void justCheckEnv() {
        var exception = assertThrows(NullPointerException.class, () -> Searcher.main(new String[] {}));
        assertEquals("Missing environment variable SEARCH_INDEX_PATH", exception.getMessage());
    }
}
