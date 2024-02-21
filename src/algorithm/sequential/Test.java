package algorithm.sequential;

public class Test {
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1, 7, 4, 3, 8, 9};

        MergeSort mergeSort = new MergeSort(array);
        mergeSort.sort(0, array.length - 1);
    }
}
