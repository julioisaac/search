package br.com.luizalabs;

import br.com.luizalabs.index.loader.Loader;
import br.com.luizalabs.index.loader.file.FileLoader;
import br.com.luizalabs.io.IndexService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class BaseTest {

    protected Loader fileLoader;
    protected IndexService indexHandler;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        fileLoader = Mockito.mock(FileLoader.class);
        indexHandler = Mockito.mock(IndexService.class);
        String path = getClass().getClassLoader().getResource("data").getPath();
        List<String> resourceDataPath = Collections.singletonList(path);

        Mockito.when(fileLoader.getPaths()).thenReturn(resourceDataPath);
        Mockito.when(fileLoader.load(fileLoader.getPaths())).thenCallRealMethod();
        Mockito.when(fileLoader.load()).thenCallRealMethod();

        Mockito.when(indexHandler.getPath()).thenReturn(path);
        Mockito.doCallRealMethod().when(indexHandler).save(Mockito.anyMap());
        Mockito.when(indexHandler.index()).thenCallRealMethod();
    }

}
