package sort;

public class Merge_Sort {

    private static int[] sorted;  // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void merge_sort(int[] a) {
        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    // Top-Down 방식 구현
    private static void merge_sort(int[] a, int left, int right) {

        /**
         * left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우
         * 더이상 쪼갤 수 없으므로 return 한다.
         */
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        //분할작업
        merge_sort(a, left, mid);
        merge_sort(a, mid + 1, right);

        //합병과정
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int i = left;  // 왼쪽 부분리스트 시작점
        int j = mid + 1;  // 오른쪽 부분리스트의 시작점
        int idx = left;  // 채워넣을 배열의 인덱스

        while (i <= mid && j <= right) {

            if (a[i] <= a[j]) {
                sorted[idx] = a[i];
                i++;
                idx++;
            }
            else {
                sorted[idx] = a[j];
                j++;
                idx++;
            }
        }

        if (i > mid) {
            while (j <= right) {
                sorted[idx] = a[j];
                j++;
                idx++;
            }
        }
        else {
            while (i <= mid) {
                sorted[idx] = a[i];
                i++;
                idx++;
            }
        }

        // 정렬된 새 배열을 기존의 배열 복사하여 옮겨준다.
        for (int k = left; k <= right ; k++) {
            a[k] = sorted[k];
        }

    }


}
