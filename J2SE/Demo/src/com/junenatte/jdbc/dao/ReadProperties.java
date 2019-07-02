package com.junenatte.jdbc.dao;

import java.io.IOException;
import java.util.Properties;

class ReadProperties {
    private static ReadProperties readProperties;
    String url;
    String username;
    String password;
    String type;
    String driver;

    private ReadProperties() {
        readFile();
    }

    static ReadProperties getInstance() {
        if (readProperties == null)
            readProperties = new ReadProperties();
        return readProperties;
    }

    private void readFile() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("../db.properties"));
            url=properties.getProperty("jdbc.url");
            username=properties.getProperty("jdbc.username");
            password=properties.getProperty("jdbc.password");
            type=properties.getProperty("jdbc.type");
            driver=properties.getProperty("jdbc.driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
