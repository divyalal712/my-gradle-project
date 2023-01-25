package no.training.project.resource.health;

import java.io.*;


    public class FileRead {
        public static void main(String[] args) throws IOException {
            try {
                FileReader reader = new FileReader("txt.file");// read characters from a file
                BufferedReader br = new BufferedReader(reader); // passing FileReader to BufferedReader, read text from a character input stream
                String st = null;
                while ((st = br.readLine()) != null) {
                    System.out.println(st);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }



