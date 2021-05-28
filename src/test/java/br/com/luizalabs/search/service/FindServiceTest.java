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
        List<String> expected = Arrays.asList("don-de-dios.txt", "the-real-robin-hood.txt");
        List<String> results = service.findByTerms(new String[]{"robin"});
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldFoundOneOccurrence() {
        List<String> expected = Arrays.asList("don-de-dios.txt");
        List<String> results = service.findByTerms(new String[]{"dios"});
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotFoundOccurences() {
        List<String> expected = new ArrayList<>();
        List<String> results = service.findByTerms(new String[]{"walt"});
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldFoundOneOccurenceByTwoTerms() {
        List<String> expected = Arrays.asList("the-real-robin-hood.txt");
        List<String> results = service.findByTerms(new String[]{"robin", "hood"});
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotFoundStopWord() {
        List<String> expected = new ArrayList<>();
        List<String> results = service.findByTerms(new String[]{"the"});
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotFoundSpecialCharacters() {
        List<String> expected = new ArrayList<>();
        List<String> results = service.findByTerms(new String[]{"!?@"});
        assertLinesMatch(expected, new ArrayList<>(results));
    }

    @Test
    void shouldNotSorted() {
        List<String> expected = Arrays.asList("the-real-robin-hood.txt", "don-de-dios.txt");
        List<String> results = service.findByTerms(new String[]{"robin"});
        assertFalse(expected.equals(results));
    }

    @Test
    void shouldSorted() {
        List<String> expected = Arrays.asList("don-de-dios.txt", "the-real-robin-hood.txt");
        List<String> results = service.findByTerms(new String[]{"robin"});
        assertTrue(expected.equals(results));
    }

}
