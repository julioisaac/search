package br.com.luizalabs.index.domain;

public class IndexData {

    private final String key;
    private final String values;

    public IndexData(String key, String values) {
        this.key = key;
        this.values = values;
    }

    public String getKey() {
        return key;
    }

    public String getValues() {
        return values;
    }

    public String[] tokens() {
        return values.split(" ");
    }
}
