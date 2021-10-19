package sort;

public class Shell_Sort {

    private final static int[] gap =
            { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                    2048, 4096, 8192, 16384, 32768, 65536,
                    131072, 262144, 524288, 1048576};

    public static void shell_sort(int[] a) {
        shell_sort(a, a.length);
    }

    private static void shell_sort(int[] a, int size) {
        int index = getGap(size); // 첫 gap을 사용할 index

        for (int i = index; i >= 0; i--) {
            for (int j = 0; j < gap[i]; j++) {
                insertion_sort(a, i, size, gap[i]);
            }
        }
    }

    private static void insertion_sort(int[] a, int start, int size, int gap) {
        // 부분 배열의 두 번째 원소부터 size까지 반복한다.
        for (int i = start + gap; i < size; i += gap) {

            int target = a[i];
            int j = i - gap;

            while (j >= start && target < a[j]) {
                a[j + gap] = a[j];
                j -= gap;
            }

            a[j + gap] = target;
        }
    }

    private static int getGap(int length) {
        int index = 0;

        int len = (int) (length / 2);
        while (gap[index] <= len) {
            index++;
        }
        return index;
    }


}
