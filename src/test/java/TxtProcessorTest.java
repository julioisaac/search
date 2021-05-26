import br.com.luizalabs.index.indexer.common.IndexBuilder;
import org.junit.jupiter.api.BeforeAll;

class TxtProcessorTest {

    private static IndexBuilder indexBuilder;

    @BeforeAll
    static void setUpBeforeClass() {
        indexBuilder = new IndexBuilder();
    }

//    @Test
//    void testChargeFiles() {
//        int count = files.get().length;
//        assertEquals(0,count);
//    }
//
//    @Test
//    void testWords() {
//        String[] words = ProcessorUtil.splitBySpace("the four musicians of bremen 1922 swalt disney");
//        assertEquals(8, words.length);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"the", "de", "la"})
//    void testStopWords(String stopWords) {
//        assertTrue(processor.stopWord((stopWords)));
//    }

}
