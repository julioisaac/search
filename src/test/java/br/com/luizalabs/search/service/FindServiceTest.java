package br.com.luizalabs.search.service;

import br.com.luizalabs.index.indexer.IndexBuilder;
import br.com.luizalabs.index.indexer.transformers.sanitize.SanitizeWordTransformer;
import br.com.luizalabs.index.indexer.transformers.stopwords.StopWordTransformer;
import br.com.luizalabs.index.loader.Loader;
import br.com.luizalabs.index.loader.file.FileLoader;
import br.com.luizalabs.io.IndexService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindServiceTest {

    static Loader fileLoader;
    static Map<String, Set<String>> idx;
    static FindService service;
    static IndexService indexService;

    @BeforeAll
    static void setUp() throws IOException, ClassNotFoundException {
        String path = Paths.get("src/test/resources/data").toAbsolutePath().toString();

        fileLoader = Mockito.mock(FileLoader.class);
        Mockito.when(fileLoader.getPaths()).thenReturn(Collections.singletonList(path));
        Mockito.when(fileLoader.load(fileLoader.getPaths())).thenCallRealMethod();
        Mockito.when(fileLoader.load()).thenCallRealMethod();

        indexService = Mockito.mock(IndexService.class);
        Mockito.when(indexService.getPath()).thenReturn(path);
        Mockito.when(indexService.index()).thenCallRealMethod();
        Mockito.doCallRealMethod().when(indexService).save(Mockito.anyMap());
        Mockito.doCallRealMethod().when(indexService).remove();

        idx = new IndexBuilder.Builder()
                .addTransformer(new SanitizeWordTransformer())
                .addTransformer(new StopWordTransformer())
                .summarize(fileLoader.load())
                .build();

        service = new FindService(idx);
    }

    @AfterAll
    static void cleanUp() throws IOException {
        indexService.remove();
    }

    @Test
    void shouldFoundTwoOccurrences() {
        String[] terms = new String[]{"robin"};
        List<String> expected = Arrays.asList("don-de-dios.txt", "the-real-robin-hood.txt");
        List<String> results = service.findByTerms(terms);
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldFoundOneOccurrence() {
        String[] terms = new String[]{"dios"};
        List<String> expected = Arrays.asList("don-de-dios.txt");
        List<String> results = service.findByTerms(terms);
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotFoundOccurences() {
        String[] terms = new String[]{"walt"};
        List<String> expected = new ArrayList<>();
        List<String> results = service.findByTerms(terms);
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldFoundOneOccurenceByTwoTerms() {
        String[] terms = new String[]{"robin", "hood"};
        List<String> expected = Arrays.asList("the-real-robin-hood.txt");
        List<String> results = service.findByTerms(terms);
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotFoundStopWord() {
        String[] terms = new String[]{"the"};
        List<String> expected = new ArrayList<>();
        List<String> results = service.findByTerms(terms);
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotFoundSpecialCharacters() {
        String[] terms = new String[]{"!?@"};
        List<String> expected = new ArrayList<>();
        List<String> results = service.findByTerms(terms);
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotSorted() {
        String[] terms = new String[]{"robin"};
        List<String> expected = Arrays.asList("the-real-robin-hood.txt", "don-de-dios.txt");
        List<String> results = service.findByTerms(terms);
        boolean notSorted = expected.equals(results);
        assertFalse(notSorted);
    }

    @Test
    void shouldSorted() {
        String[] terms = new String[]{"robin"};
        List<String> expected = Arrays.asList("don-de-dios.txt", "the-real-robin-hood.txt");
        List<String> results = service.findByTerms(terms);
        boolean sorted = expected.equals(results);
        assertTrue(sorted);
    }

}
