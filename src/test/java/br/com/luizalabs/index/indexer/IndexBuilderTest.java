package br.com.luizalabs.index.indexer;

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

class IndexBuilderTest {

    static Loader fileLoader;
    static IndexService indexService;
    static Map<String, Set<String>> idx;

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
    }

    @AfterAll
    static void cleanUp() throws IOException {
        indexService.remove();
    }

    @Test
    void shouldSummarized() {
        assertEquals(24, idx.size());
    }

    @Test
    void shouldSaveIdx() {
        assertDoesNotThrow(() -> indexService.save(idx));
    }

    @Test
    void shouldNotSaveIdx() throws IOException {
        Mockito.doCallRealMethod().when(indexService).save(null);
        var exception = assertThrows(NullPointerException.class, () -> indexService.save(null));
        assertEquals("Index file should not be null", exception.getMessage());
    }


}
