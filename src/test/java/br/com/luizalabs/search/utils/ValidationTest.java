package br.com.luizalabs.search.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void shouldSentencePass() {
        assertDoesNotThrow(() -> Validation.sentence(new String[]{"walt disney"}));
    }

    @Test
    void shouldSentenceNotPass() {
        assertThrows(NullPointerException.class, () -> Validation.sentence(new String[]{"walt disney", "pictures"}));
    }

    @Test
    void shouldEmptyIndexNotPass() {
        assertThrows(NullPointerException.class, () -> Validation.index(new HashMap<>()));
    }

    @Test
    void shouldNullIndexNotPass() {
        assertThrows(NullPointerException.class, () -> Validation.index(null));
    }

    @Test
    void shouldIndexPass() {
        Set<String> ocurrences = new HashSet<>();
        ocurrences.add("ocurrence1");
        ocurrences.add("ocurrence2");
        Map<String, Set<String>> index = new HashMap<String, Set<String>>();
        index.put("palavra", ocurrences);
        assertDoesNotThrow(() -> Validation.index(index));
    }

}
