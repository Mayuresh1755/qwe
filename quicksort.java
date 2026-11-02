
import java.util.Scanner;

public class QuickSort {

    public static void quickSort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }

        int pivot = pivot_index(nums, s, e);

        quickSort(nums, s, pivot - 1);
        quickSort(nums, pivot + 1, e);
    }

    public static int pivot_index(int[] nums, int s, int e) {

        int pivot = nums[s];
        int count = 0;

        // Count elements smaller than or equal to pivot
        for (int k = s + 1; k <= e; k++) {
            if (nums[k] <= pivot) {
                count++;
            }
        }

        // Place pivot at its correct position
        int correct_position = s + count;

        int temp = nums[s];
        nums[s] = nums[correct_position];
        nums[correct_position] = temp;

        // Partition the array
        int i = s;
        int j = e;

        while (i < correct_position && j > correct_position) {

            while (i < correct_position && nums[i] <= pivot) {
                i++;
            }

            while (j > correct_position && nums[j] > pivot) {
                j--;
            }

            if (i < correct_position && j > correct_position) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j--;
            }
        }

        return correct_position;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        quickSort(nums, 0, n - 1);

        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}
