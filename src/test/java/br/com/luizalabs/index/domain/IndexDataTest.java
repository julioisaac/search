package br.com.luizalabs.index.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexDataTest {

    @Test
    void shouldGetWords() {
        IndexData indexData = new IndexData("the-real-robin-hood.txt", "the real robin hood 2010 ridley scott");
        assertEquals(7, indexData.tokens().length);
    }

}
