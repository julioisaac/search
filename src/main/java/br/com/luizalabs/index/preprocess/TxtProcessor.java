package br.com.luizalabs.index.preprocess;

import br.com.luizalabs.index.helper.StopWords;
import br.com.luizalabs.index.utils.ProcessorUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TxtProcessor implements Processor {

    private static final Logger logger = Logger.getLogger(TxtProcessor.class.getName());

    private static final StopWords stopWords = StopWords.getInstance();
    private final Text texts;
    private final Map<String, List<String>> indexData = new HashMap<>();

    public TxtProcessor(Text texts) {
        this.texts = texts;
    }

    @Override
    public Map<String, List<String>> sumarize() {
        texts.read();
        for (File txt : texts.get()) {
            try (FileReader fileStream = new FileReader(txt);
                BufferedReader bufferedReader = new BufferedReader(fileStream)) {
                String line;
                while((line = bufferedReader.readLine()) != null ) {
                    String[] words = ProcessorUtil.splitBySpace(line);
                    handleTxt(txt, words);
                }
            } catch (IOException ioException) {
                logger.log(Level.SEVERE, "Erro ao tentar criar arquivo", ioException.getCause());
            }
        }
        return indexData;
    }

    public void handleTxt(File txt, String[] words) {
        for (String word : words) {
            word = ProcessorUtil.sanitize(word);
            if (stopWord(word)) continue;
            List ocorrences = new ArrayList();
            if (indexData.get(word) != null) {
                ocorrences = indexData.get(word);
                if (!ocorrences.contains(txt.getName())) {
                    ocorrences.add(txt.getName());
                }
            }
            else {
                ocorrences = new ArrayList<>();
                ocorrences.add(txt.getName());
            }
            indexData.put(word.toLowerCase(), ocorrences);
        }
    }

    @Override
    public boolean stopWord(String word) {
        return ("".equals(word) || stopWords.isStopWord(word));
    }

}
