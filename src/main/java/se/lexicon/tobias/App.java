package se.lexicon.tobias;



import java.util.Arrays;
import java.util.Scanner;

public class App
{

    static char[] word;
    static int count;


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
         count++;

    }

    static void correct(char c, int sw, char[] array){


        for (int i = 0; i < sw ; i++) {
            if (array[i] == c){
                word[i] = c;
            }
        }


    }

    static void check(String s, char[] sw, int l){

        int diff = 1;

        for (int i = 0; i < l ; i++) {
            if (s.length() == diff){
                char c = s.charAt(0);
                if (c ==  sw[i]){
                    correct(c, l, sw);
                    break;
                } else if (c != sw[i] && i == l - 1){
                        incorrect();

                }

            } else if (s.length() > diff && s.length() == l){
                for (int j = 0; j < l ; j++) {
                    char c = s.charAt(j);
                    if (c == sw[j]){
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
         System.out.println("your word is " + sw + " characters long");
            System.out.print(Arrays.toString(word));


    }
}
