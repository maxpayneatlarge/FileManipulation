package com.conf;

import java.io.InputStream;
import java.util.Properties;

public class FileManipulationProperties {

    private Properties prop;
    private String propFile = "filemanipulation.properties";

    public FileManipulationProperties() {
        try {   
            InputStream inputStream;
            this.prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(propFile);
            if (inputStream != null) {
                this.prop.load(inputStream);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Properties getProp() {
        return prop;
    }

}
