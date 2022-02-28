package com.petstore.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Configuration config;
    private static final Properties prop = new Properties();

    public Configuration() throws IOException {
        InputStream input = Configuration.class.getResourceAsStream("../resources/application.properties");
        prop.load(input);
    }

    public static Configuration getInstance() {
        if (config == null) {
            synchronized (Configuration.class) {
                try {
                    config = new Configuration();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return config;
    }

    public String getString(String key) {
        return System.getProperty(key, prop.getProperty(key));
    }
}