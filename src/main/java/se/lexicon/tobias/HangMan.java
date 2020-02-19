package se.lexicon.tobias;


import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

 private char[] word;

 public HangMan(){

    String txt = "";
    int lineNumber = (int) (Math.random()*25);
    try {
        FileReader readFile = new FileReader("words.txt");
        BufferedReader readBuffer = new BufferedReader(readFile);
        for (int x = 0; x <= lineNumber; x++){
            if (x == lineNumber){
                txt = readBuffer.readLine();
            } else {
                readBuffer.readLine();
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }


    word = new char[txt.length()];

     makeToAnArray(txt);

 }

   public void makeToAnArray(String str){
       for (int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            word[i] = c;
       }

   }

        public char[] getWord(){
            return word;
         }
         public int getLength(){
            return word.length;
         }


}