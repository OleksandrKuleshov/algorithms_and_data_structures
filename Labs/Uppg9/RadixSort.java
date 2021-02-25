package Labs.Uppg9;

import java.util.Arrays;

public class RadixSort {
  public static void main(String args[]) {

    int arr[] = new int[1000000];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 1000 + 1);
    }

    System.out.println("before sort");
    radixSort(arr);
    // Arrays.stream(arr).forEach(System.out::println);
    System.out.println("after sort");
    for (int i = 0; i < arr.length - 1; i++) {
      if (!(arr[i] <= arr[i + 1])) {
        System.out.println("Error");
        break;
      }
    }
    System.out.println("OK");

  }

  static void radixSort(int[] arr) {
    int max = findMax(arr);

    for (int i = 1; max / i > 0; i = 10)
      countingSortInt(arr, i);

  }

  public static void countingSortInt(int[] arr, int exp) {
    int[] output = new int[arr.length];
    int[] count = new int[10];

    for (int a : arr) {
      count[((a / exp) % 10)]++;
    }

    for (int i = 0; i < count.length - 1; i++) {
      count[i + 1] = count[i] + count[i + 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = output[i];
    }

  }

  private static int findMax(int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i])
        max = arr[i];
    }
    return max;
  }
}