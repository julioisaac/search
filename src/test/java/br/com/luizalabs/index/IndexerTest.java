package br.com.luizalabs.index;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {

    @Test
    @DisabledIfEnvironmentVariable(named = "ORIGIN_DATA_PATH", matches = ".*")
    void shouldThrowNullPointerException() {
        var exception = assertThrows(NullPointerException.class, () -> Indexer.main(new String[] {}));
        assertEquals("Missing environment variable ORIGIN_DATA_PATH", exception.getMessage());
    }

}
