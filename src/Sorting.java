import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        List<T> workArr = new ArrayList<T>(list.size());
        mergeSortHelper(list, workArr, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void mergeSortHelper(List<T> list, List<T> workArr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortHelper(list, workArr, start, mid);
            mergeSortHelper(list, workArr, mid + 1, end);
            merge(list, workArr, start, mid, end);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> workArr, int start, int mid, int end) {
        int i = start;
        int j = start;
        int k = mid + 1;
        while (j <= mid && k <= end) {
            if (list.get(j).compareTo(list.get(k)) < 0) {
                workArr.set(i, list.get(j));
                j++;
            } else {
                workArr.set(i, list.get(k));
                k++;
            }
            i++;
        }

        while (j <= mid) {
            workArr.set(i, list.get(j));
            j++;
            i++;
        }

        while (k <= end) {
            workArr.set(i, list.get(k));
            k++;
            i++;
        }

        for (i = start; i <= end; i++) {
            list.set(i, workArr.get(i));
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
