package br.com.luizalabs.index.loader;

import br.com.luizalabs.index.domain.IndexData;
import br.com.luizalabs.index.loader.file.FileLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoaderFactoryTest {

    static Loader fileLoader;

    @BeforeEach
    void setUp() {
        String path = Paths.get("src/test/resources/data").toAbsolutePath().toString();

        fileLoader = Mockito.mock(FileLoader.class);
        Mockito.when(fileLoader.getPaths()).thenReturn(Collections.singletonList(path));
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
