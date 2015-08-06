package com.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileOperator {
    
    public int countLines(File passedInFile) {
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
}
