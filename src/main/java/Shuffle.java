import java.util.Random;

public class Shuffle {

    /*
     * Complete the 'shuffle' function below.
     */
    public static Integer[] shuffle(Integer[] input) {
        Integer[] output = input.clone();
        for (int i = 0; i < output.length; i++) {
            int randomIndex = random(0, output.length - 1);
            Integer oldValue = output[i];
            output[i] = output[randomIndex];
            output[randomIndex] = oldValue;
        }
        return output;
    }

    private static int random(int min, int max) {
        Random ran = new Random();
        return min + ran.nextInt(max - min + 1);
    }

 }
