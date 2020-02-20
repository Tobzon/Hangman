package se.lexicon.tobias;

import java.util.Arrays;
import java.util.Scanner;

public class App
{

    private static char[] word;
    private static int count;


    public static void main( String[] args )
    {

        HangMan hm = new HangMan();
        int length = hm.getLength();
         word = new char[length];
        char[] secretWord = hm.getWord();
        boolean run = false;
        count = 0;

       wordLength(length);
        while (!run) {

            if (validate(word, secretWord)){
                run = true;
                System.out.println("\nCongratulation you guessed the correct word");
                continue;
            }
            if (count >= 8){
                run = true;
                System.out.println("you lost to many tries");
                continue;
            }
            String guess = guessing();
            check(guess, secretWord, length);
            System.out.println(Arrays.toString(word));

        }

    }

    static boolean validate(char[] c1, char[] c2){

        String str1 = String.valueOf(c1);
        String str2 = String.valueOf(c2);

        return str1.equalsIgnoreCase(str2);
    }

    static void incorrect(){
        int maxCount = 8;
         count++;
         int left = maxCount - count;
        System.out.println("You have: " + left + " guesses left\n");
    }

    static void correct(char c, int l, char[] array){

            int charType = Character.getType(c);

        for (int i = 0; i < l ; i++) {
            if (charType == Character.UPPERCASE_LETTER && c == array[i]){
                if (i == 0){
                    word[i] = c;
                } else {
                    char C = Character.toLowerCase(c);
                    word[i] = C;
                }

            } else if (charType == Character.UPPERCASE_LETTER && i >0){
                char C = Character.toLowerCase(c);

                if (c == array[i]){
                    word[i] = C;

                }
            }
        }
    }


     static void scharactersEqualIgnoringCase(String s, char[] c1, int l){
         for (int i = 0; i <l ; i++) {
             char c = s.charAt(i);
             char u1 = Character.toUpperCase(c);
             char u2 = Character.toUpperCase(c1[i]);
             if (u1  == u2){
                 c1[i] = u2;
                 correct(u1, l, c1);

             } else {
                 incorrect();
                 break;

             }
         }
     }

    static void charactersEqualIgnoringCase(char c1, char [] c2, int l) {
            char u1 = Character.toUpperCase(c1);
        for (int i = 0, x=0; i < l ; i++) {
           char u2 = Character.toUpperCase(c2[i]);
           if (u1 == u2){
               c2[i] = u2 ;
               correct(u1, l, c2);
               x++;

           }
           else if (x == 0 && i == l -1){
               incorrect();

           }
        }
    }

    static void check(String s, char[] sw, int l){

        int diff = 1;
            if (s.length() == diff){
                char c = s.charAt(0);
                    charactersEqualIgnoringCase(c, sw, l);



            } else if (s.length() ==  l){

                        scharactersEqualIgnoringCase(s, sw, l);

                } else {
                 incorrect();

                }
    }

    static String getStringFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    static String guessing(){
        String c;
        System.out.println("\nMake an guess");
         c = getStringFromUser();
         return c;
    }

     static void  wordLength(int sw){
         System.out.println("Your word is " + sw + " characters long");
            System.out.print(Arrays.toString(word));
    }
}

