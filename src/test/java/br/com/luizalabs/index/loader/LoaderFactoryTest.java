package br.com.luizalabs.index.loader;

import br.com.luizalabs.index.domain.IndexData;
import br.com.luizalabs.index.loader.file.FileLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LoaderFactoryTest {

    protected Loader fileLoader;

    @BeforeEach
    void setUp() {
        fileLoader = Mockito.mock(FileLoader.class);
        String path = Objects.requireNonNull(getClass().getClassLoader().getResource("data")).getPath();
        List<String> resourceDataPath = Collections.singletonList(path);

        Mockito.when(fileLoader.getPaths()).thenReturn(resourceDataPath);
        Mockito.when(fileLoader.load(fileLoader.getPaths())).thenCallRealMethod();
        Mockito.when(fileLoader.load()).thenCallRealMethod();
    }

    @Test
    void shouldLoadFiles() {
        List<IndexData> files = new LoaderFactory()
                .add(fileLoader)
                .load();
        assertEquals(3, files.size());
    }

}
