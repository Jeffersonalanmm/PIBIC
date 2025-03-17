import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Deepseek_r1_distill_llama_70b {

    public static int[] beadSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();

        // Handle case where all elements are 0
        if (max == 0) {
            return array.clone();
        }

        // Check for negative numbers
        if (min < 0) {
            //throw new IllegalArgumentException("BeadSort only works with non-negative integers");
        }

        int[] diff = new int[max + 2]; // +2 to handle x+1 up to max+1

        for (int x : array) {
            if (x == 0) {
                diff[0]++;
            } else {
                diff[1]++;
                if (x + 1 <= max) {
                    diff[x + 1]--;
                }
            }
        }

        // Compute prefix sum to get the rods array
        int[] rods = new int[diff.length];
        rods[0] = diff[0];
        for (int i = 1; i < rods.length; i++) {
            rods[i] = rods[i - 1] + diff[i];
        }

        // Build the sorted array
        List<Integer> sorted = new ArrayList<>();

        // Add zeros if present
        if (min == 0) {
            int zeroCount = rods[0];
            for (int i = 0; i < zeroCount; i++) {
                sorted.add(0);
            }
        }

        // Add numbers from 1 to max
        for (int i = 1; i <= max; i++) {
            int count = rods[i] - rods[i + 1];
            for (int j = 0; j < count; j++) {
                sorted.add(i);
            }
        }

        // Convert the list to an array
        int[] result = new int[sorted.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sorted.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000];

        // Preenchendo o array com valores aleatórios
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Números entre 0 e 999
        }
        int[] sortedArray = Deepseek_r1_distill_llama_70b.beadSort(array);
    }
}