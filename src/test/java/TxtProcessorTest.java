import br.com.luizalabs.index.preprocess.TxtProcessor;
import br.com.luizalabs.index.preprocess.Text;
import br.com.luizalabs.index.preprocess.Processor;
import br.com.luizalabs.index.utils.ProcessorUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TxtProcessorTest {

    static Processor processor;
    static Text files;

    @BeforeAll
    public static void setUpBeforeClass() {
        files = new Text(new String[]{""});
        processor = new TxtProcessor(files);
    }

    @Test
    public void testChargeFiles() {
        int count = files.get().length;
        assertEquals(0,count);
    }

    @Test
    public void testWords() {
        String[] words = ProcessorUtil.splitBySpace("the four musicians of bremen 1922 swalt disney");
        assertEquals(8, words.length);
    }

    @ParameterizedTest
    @ValueSource(strings = {"the", "de", "la"})
    public void testStopWords(String stopWords) {
        assertTrue(processor.stopWord((stopWords)));
    }

}
