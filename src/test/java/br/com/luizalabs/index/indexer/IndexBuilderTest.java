package br.com.luizalabs.index.indexer;

import br.com.luizalabs.index.indexer.transformers.sanitize.SanitizeWordTransformer;
import br.com.luizalabs.index.indexer.transformers.stopwords.StopWordTransformer;
import br.com.luizalabs.index.loader.Loader;
import br.com.luizalabs.index.loader.file.FileLoader;
import br.com.luizalabs.io.IndexService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class IndexBuilderTest {

    Loader fileLoader;
    IndexService indexService;
    Map<String, Set<String>> idx;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        String path = Objects.requireNonNull(getClass().getClassLoader().getResource("data")).getPath();
        List<String> resourceDataPath = Collections.singletonList(path);

        fileLoader = Mockito.mock(FileLoader.class);
        Mockito.when(fileLoader.getPaths()).thenReturn(resourceDataPath);
        Mockito.when(fileLoader.load(fileLoader.getPaths())).thenCallRealMethod();
        Mockito.when(fileLoader.load()).thenCallRealMethod();

        indexService = Mockito.mock(IndexService.class);
        Mockito.when(indexService.getPath()).thenReturn(path);
        Mockito.when(indexService.index()).thenCallRealMethod();
        Mockito.doCallRealMethod().when(indexService).save(Mockito.anyMap());

        idx = new IndexBuilder.Builder()
                .addTransformer(new SanitizeWordTransformer())
                .addTransformer(new StopWordTransformer())
                .summarize(fileLoader.load())
                .build();
    }


    @Test
    void shouldSummarize() {
        assertEquals(24, idx.size());
    }

    @Test
    void shouldSaveIdx() {
        assertDoesNotThrow(() -> indexService.save(idx));
    }

    @Test
    void shouldNotSaveIdx() throws IOException {
        Mockito.doCallRealMethod().when(indexService).save(null);
        assertThrows(NullPointerException.class, () -> indexService.save(null));
    }


}
