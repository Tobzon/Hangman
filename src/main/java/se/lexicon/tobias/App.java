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

            if (Arrays.equals(word, secretWord) && word.length == secretWord.length){
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
    static void incorrect(){
        int maxCount = 8;
         count++;
         int left = maxCount - count;
        System.out.println("You have: " + left + " guesses left\n");
    }

    static void correct(char c, int l, char[] array){

            int charType = Character.getType(c);

        for (int i = 0; i < l ; i++) {
            if (charType == Character.LOWERCASE_LETTER && c == array[i] ){
                word[i] = c;
            } else if (charType == Character.UPPERCASE_LETTER){
                char C = Character.toLowerCase(c);
                if (C == array[i]){
                    word[i] = C;
                }
            }

        }

    }

    static void check(String s, char[] sw, int l){

        int diff = 1;

        for (int i = 0; i < l ; i++) {
            if (s.length() == diff){
                char c = s.charAt(0);
                int charType = Character.getType(c);
                if (charType == Character.UPPERCASE_LETTER || charType == Character.LOWERCASE_LETTER && c == sw[i]){
                    correct(c, l, sw);
                    break;
                } else if (c != sw[i] && i == l - 1){
                        incorrect();
                }

            } else if (s.length() > diff && s.length() == l){
                for (int j = 0; j < l ; j++) {
                    char c = s.charAt(j);
                    int charType = Character.getType(c);
                    if (charType == Character.UPPERCASE_LETTER || charType == Character.LOWERCASE_LETTER && c == sw[j]){
                        correct(c, l, sw);
                    } else if (c != sw[j] && j == l - 1){
                        incorrect();
                    }

                }

            }

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

