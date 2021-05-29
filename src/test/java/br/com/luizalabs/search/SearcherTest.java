package br.com.luizalabs.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTest {

    @Test
    @DisabledIfEnvironmentVariable(named = "SEARCH_INDEX_PATH", matches = ".*")
    void justCheckEnv() {
        var exception = assertThrows(NullPointerException.class, () -> Searcher.main(new String[] {}));
        assertEquals("Missing environment variable SEARCH_INDEX_PATH", exception.getMessage());
    }
}
