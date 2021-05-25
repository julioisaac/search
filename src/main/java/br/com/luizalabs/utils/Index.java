package br.com.luizalabs.utils;

import java.util.List;
import java.util.Map;

public class Index {

    private static Map<String, List<String>> index;

    public Index(final Map<String, List<String>> index) {
        this.index = index;
    }

    public static Map<String, List<String>> getIndex() {
        return index;
    }

}
