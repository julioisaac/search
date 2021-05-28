package br.com.luizalabs.io.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Config {

    ORIGIN_DATA_PATH, SEARCH_INDEX_PATH;

    private static final Logger logger = Logger.getLogger(Config.class.getName());

    private String value;

    public String get() {
        if (value == null) {
            value = System.getenv(name());
            if (value == null  || value.isEmpty()) {
                logger.log(Level.SEVERE, "Missing environment variable {0}", name());
                throw new NullPointerException(String.format("Missing environment variable %s", name()));
            }
        }
        return value;
    }
}
