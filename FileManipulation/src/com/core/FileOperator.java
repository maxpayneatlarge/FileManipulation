package com.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileOperator {
    
    File file;
    
    public FileOperator(File passedInFile){
        this.file = passedInFile;
    }
    
    public int countLines() {
        int numberOfLines = 0;
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(file);
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
