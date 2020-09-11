/**
 * @author Linda Nguyen
 */

import java.util.Random;

public class Face {
    // instance variables for color and style of face
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face(){
        randomize();
    }

    public void randomize(){

        /**
         * Date: September 7, 2020
         * reference for choosing random ints found here: https://stackoverflow.com/questions/20560899/generate-a-random-color-java
         * */
        Random rand = new Random();

        skinColor = rand.nextInt(255);
        eyeColor = rand.nextInt(255);
        hairColor = rand.nextInt(255);
        hairStyle = rand.nextInt(255);
    }
}
