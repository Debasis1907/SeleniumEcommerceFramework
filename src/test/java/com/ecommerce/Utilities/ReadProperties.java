package com.ecommerce.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    Properties properties;
    FileInputStream fileInputStream;
    public ReadProperties()  {
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Configuration/config.properties");
            properties.load(fileInputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getBaseURL(){
        String baseURL = properties.getProperty("URL");
        return baseURL;
    }

    public String getBrowserName(){
        String browserName = properties.getProperty("browser");
        return browserName;
    }

    public String getEmail(){
        return properties.getProperty("Email");
    }

    public String getPassword(){
        return properties.getProperty("Password");
    }
}
