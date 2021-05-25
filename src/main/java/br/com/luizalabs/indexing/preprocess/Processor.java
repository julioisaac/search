package br.com.luizalabs.indexing.preprocess;

import java.util.List;
import java.util.Map;

public interface Processor {

    Map<String, List<String>> sumarize();

    boolean stopWord(String word);

}
