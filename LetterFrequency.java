import java.util.Scanner;
import java.io.*;
import java.awt.Color;

public class LetterFrequency {
    
    public static void main(String[] args) {
        if (args.length != 0){
            try (Scanner in = new Scanner(new File(args[0]))) {
                StdDraw.setCanvasSize(800, 400);
                StdDraw.setXscale(0, 26);

                //create an array of all letters and an empty array of floats with 26 spots
                //corresponding with the alphabet
                char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                float[] numbers = new float[26];

                //fill the float array with zeroes to prepare for count
                for (int i = 0; i < numbers.length; i++){
                    numbers[i] = 0;
                }
                
                float maxvalue = 0;
        
                while (in.hasNext()){
                    
                    String word = in.next();
                    char[] brokenupword = word.toCharArray();
                    
                    //loop through every letter of the word we are on
                    for (int i = 0; i < word.length(); i++){
                        char charinquestion = Character.toLowerCase(brokenupword[i]);
                        
                        //compare every letter in the alphabet to the letter mentioned above
                        for (int j = 0; j < alphabet.length; j++){
                            if (alphabet[j] == charinquestion){
                                numbers[j] += 1;
                                
                                //keep tracking for maximum for scaling
                                if (numbers[j] > maxvalue){
                                    maxvalue = numbers[j];
                                }

                            }
                        }
                
                    }
                }

                //scale everything with the max value being 1.0
                for (int i = 0; i < alphabet.length; i++) {
                    numbers[i] = numbers[i]/maxvalue;
                }   
                
                //draw!
                for (int i = 0; i < alphabet.length; i++){
                    if (i%2 == 0){
                        StdDraw.setPenColor(StdDraw.GREEN);
                    }
                    else{
                        StdDraw.setPenColor(StdDraw.ORANGE);
                    }
                    StdDraw.filledRectangle(i+.5, numbers[i]/2, .5, .5*numbers[i]);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(i+.5, .043, String.valueOf(alphabet[i]));
                }
                StdDraw.show();
            }
            
            catch (FileNotFoundException e){
                System.out.println("Error reading file");
            }
        }
        else {
            System.out.println("No input file");
        }

    }  
} 
