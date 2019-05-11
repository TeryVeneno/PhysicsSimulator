public class Sorting_thingy {
  static int[] array_nums = new int[20];
  static {
    array_nums[0] = 5;
    array_nums[1] = 100;
    array_nums[2] = 6;
    array_nums[3] = 90;
    array_nums[4] = 124;
    array_nums[5] = 16;
    array_nums[6] = 75;
    array_nums[7] = 76;
    array_nums[8] = 89;
    array_nums[9] = 120;
    array_nums[10] = 65;
    array_nums[11] = 43;
    array_nums[12] = 31;
    array_nums[13] = 98;
    array_nums[14] = 545;
    array_nums[15] = 456;
    array_nums[16] = 657;
    array_nums[17] = 321;
    array_nums[18] = 455;
    array_nums[19] = 104;
  }

  public static void sortArray (int[] arr, int len) {
    int[] holder = new int[len];
    int index = 0; int current = arr[0];
    for (int i = 0; i < len; i++) {
      for (int j = 1; j < len-1; j++) {
        if (current > arr[j]) {
          current = arr[j]; index = j;
        }
      }
      holder[i] = current; current = arr[0]; arr[index] = 1000;
    }
    for (int s = 0; s < len; s++) {
      arr[s] = holder[s];
    }
  }

  public static void sort_array (int arr[], int len) {
    int index = 0; int current = arr[0]; int h = 0;
    for (int i = 0; i < len-1; i++) {
      for (int j = i+1; j < len; j++) {
        current = arr[i];
        if (current > arr[j]) {
          current = arr[j]; index = j;
        }
      }
      if (index != i) {
        arr[current] = arr[i];
      }
      h = arr[i]; arr[i] = current; arr[index] = h;
    }
  }

    public static void printArray (int[] arr, int len) {
      for (int s = 0; s < len; s++) {
        System.out.print(" "+arr[s]);
      }
    }

    public static void main(String[] args) {
      sort_array(array_nums, 20);
      printArray(array_nums, 20);
    }
}
