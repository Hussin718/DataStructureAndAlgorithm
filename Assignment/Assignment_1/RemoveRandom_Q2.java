import java.util.*;

public class RemoveRandom_Q2  {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Random rand = new Random();
        int indexToRemove = rand.nextInt(arr.length);
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == indexToRemove) continue;
            newArr[k++] = arr[i];
        }
        System.out.println("Removed element at index " + indexToRemove);
        System.out.println(Arrays.toString(newArr));
    }
}
