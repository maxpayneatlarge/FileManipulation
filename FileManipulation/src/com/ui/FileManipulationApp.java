package com.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.conf.FileManipulationProperties;

public class FileManipulationApp {
    

    public static int countLines(File passedInFile) {
        int numberOfLines = 0;
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(passedInFile);
            br = new BufferedReader(fr);
            String aLine = null;
            while ((aLine = br.readLine()) != null) {
                numberOfLines++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println("Error closing BufferedReader: " + e.getMessage());
                }
            }
        }
        return numberOfLines;
    }


    public static void main(String[] args) {
        FileManipulationProperties fmp = new FileManipulationProperties();
        File newFile = new File(fmp.getProp().getProperty("filelocation"));
        BufferedReader textReader = null;
        try {
            
            FileReader reader = new FileReader(newFile);
            textReader = new BufferedReader(reader);
            int numberOfLines = countLines(newFile);

            String[] textData = new String[numberOfLines];
            for (int i = 0; i < numberOfLines; i++) {
                textData[i] = textReader.readLine();
                System.out.println(textData[i]);
                if (i == 0) {
                    StringTokenizer tokens = new StringTokenizer(textData[i]);
                    while (tokens.hasMoreTokens()) {
                        System.out.println(tokens.nextToken());
                    }
                }
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        } finally {
            if (textReader != null)
                try {
                    textReader.close();
                } catch (IOException e) {
                    System.out.println("Error closing textReader");
                    e.printStackTrace();
                }
        }

    }

}
