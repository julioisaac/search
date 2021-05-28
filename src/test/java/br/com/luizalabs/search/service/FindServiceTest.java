package br.com.luizalabs.search.service;

import br.com.luizalabs.io.IndexService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindServiceTest {

    FindService service;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        service = new FindService(IndexService.getInstance().index());
    }

    @Test
    void shouldFoundTwoOccurrences() {
        List<String> expected = Arrays.asList("the-real-robin-hood.txt", "don-de-dios.txt");
        List<String> results = service.findByTerms("robin");
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldFoundOneOccurrence() {
        List<String> expected = Arrays.asList("don-de-dios.txt");
        List<String> results = service.findByTerms("dios");
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotFoundOccurences() {
        List<String> expected = new ArrayList<>();
        List<String> results = service.findByTerms("walt");
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldFoundOneOccurenceByTwoTerms() {
        List<String> expected = Arrays.asList("the-real-robin-hood.txt");
        List<String> results = service.findByTerms("robin hood");
        assertLinesMatch(expected, new ArrayList<>(results));
    }

}
