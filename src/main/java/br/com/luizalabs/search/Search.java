package br.com.luizalabs.search;

import br.com.luizalabs.utils.IOIndexUtil;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search {

    private static final Logger logger = Logger.getLogger(Search.class.getName());

    private static final String MSG_OCORRENCES = "Foram encontradas {0} ocorrências pelo termo \"{1}\" \nOs arquivos que possuem \"{2}\" são: \n\n{3}\n";
    private static final Map<String, List<String>> remissiveIndex = IOIndexUtil.readBinary();

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        if (args.length != 1) {
            logger.log(Level.WARNING, "Buscar uma sentença");
            System.exit(1);
        }

        String sentence = args[0];
        String[] words = sentence.split(" ");
        List<String> results = new ArrayList<>();
        for (String word : words) {
            String wordMin = word.toLowerCase();
            List<String> resultsByWord = remissiveIndex.get(wordMin);
            if (resultsByWord != null) {
                if (results.isEmpty()) {
                    results.addAll(resultsByWord);
                }
                else {
                    results.retainAll(resultsByWord);
                }
            }
        }

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        logger.log(Level.INFO, MSG_OCORRENCES, new Object[]{results.size(), sentence, sentence, String.join("\n", results)});

        logger.log(Level.INFO, "{0} nanoseconds", elapsedTime);
    }
}
