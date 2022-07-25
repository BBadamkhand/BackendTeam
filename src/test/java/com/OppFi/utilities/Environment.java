package com.OppFi.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    public static final String TARGET_URL;

    public static final String API_KEY;

    static {
        Properties properties = null;
        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigurationReader.get("environment");

        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/Environments/" + environment + ".properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TARGET_URL = properties.getProperty("target_url");
        API_KEY = properties.getProperty("api_key");
    }
}
