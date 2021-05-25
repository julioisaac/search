import br.com.luizalabs.index.preprocess.TxtProcessor;
import br.com.luizalabs.index.preprocess.Text;
import br.com.luizalabs.index.preprocess.Processor;
import br.com.luizalabs.index.utils.ProcessorUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        assertEquals(count,0);
    }

    @Test
    public void testWords() {
        String[] words = ProcessorUtil.splitBySpace("the four musicians of bremen 1922 swalt disney");
        assertEquals(words.length,8);
    }

    @Test
    public void testStopWordEn() {
        boolean stopWord = processor.stopWord("the");
        assertTrue(stopWord);
    }

    @Test
    public void testStopWordPt() {
        boolean stopWord = processor.stopWord("de");
        assertTrue(stopWord);
    }

    @Test
    public void testStopWordEs() {
        boolean stopWord = processor.stopWord("la");
        assertTrue(stopWord);
    }
}
