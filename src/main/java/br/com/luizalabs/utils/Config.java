package br.com.luizalabs.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Config {

    ORIGIN_DATA_PATH, SEARCH_INDEX_PATH;

    private static final Logger logger = Logger.getLogger(Config.class.getName());

    private String value;

    public String get(){
        if (value == null) {
            value = System.getenv(name());
            if (value.isEmpty()) {
                logger.log(Level.SEVERE, "Missing environment variable {0}", value);
                System.exit(1);
            }
        }
        return value;
    }
}
