
import java.util.*;

public class PrimaryClass {

    public static void quickSort(List<Integer> data, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(data, begin, end);

            quickSort(data, begin, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, end);
        }
    }

    private static int partition(List<Integer> data, int begin, int end) {
        int pivot = data.get(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (data.get(j) <= pivot) {
                i++;

                int swapTemp = data.get(i);
                Collections.swap(data, i, j);
                Collections.swap(data, j, swapTemp);
            }
        }

        int swapTemp = data.get(i + 1);
        Collections.swap(data, i + 1, end);
        Collections.swap(data, end, swapTemp);
        return i + 1;
    }

    public static void mergeSort(List<Integer> data, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        List<Integer> Left = new ArrayList<>(mid);
        List<Integer> Right = new ArrayList<>(n - mid);

     
        for (int i = 0; i < mid; i++) {
            Left.add(data.get(i));
        }
        for (int i = mid; i < n; i++) {
            Right.add(data.get(i));
        }

        
        mergeSort(Left, mid);
        mergeSort(Right, n - mid);

    
        merge(data, Left, Right, mid, n - mid);
    }   

    public static void merge(List<Integer> data, List<Integer> L, List<Integer> R, int left, int right) {
        int i = 0, j = 0, k = 0;

        
        while (i < left && j < right) {
            if (L.get(i) <= R.get(j)) {
                data.set(k++, L.get(i++));
            } else {
                data.set(k++, R.get(j++));
            }
        }

        
        while (i < left) {
            data.set(k++, L.get(i++));
        }

        
        while (j < right) {
            data.set(k++, R.get(j++));
        }
    }

    public static void main(String[] args) {

        final int hectares = 20000;
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < hectares; i++) {
            data.add(i);
        }

        // shuffle List
        Collections.shuffle(data);
        System.out.println("Embaralhado: ");
        // System.out.println(data);

        long timeStartBubbleSort = System.currentTimeMillis();
        // BobbleSort
        int aux;
        for (int i=0; i < data.size(); ++i){
            for (int j=i; j < data.size(); ++j){
                if (data.get(i)>data.get(j)){
                    aux = data.get(i);
                    Collections.swap(data, (i), (j));
                    Collections.swap(data, (j), aux);
                }
            }
        }
        // System.out.println(data);
        long timeEndBubbleSort = System.currentTimeMillis();
        System.out.println("Tempo total: " + (timeEndBubbleSort - timeStartBubbleSort));
        
        
        
        
        // shuffle List
        Collections.shuffle(data);
        System.out.println("Embaralhado: ");
        // System.out.println(data);

        // QuickSort
        long timeStartQuickSort = System.currentTimeMillis();
        quickSort(data,0,data.size()-1);
        // System.out.println(data);
        long timeEndQuickSort = System.currentTimeMillis();
        System.out.println("Tempo total: " + (timeEndQuickSort - timeStartQuickSort));



        // Suffle List
        Collections.shuffle(data);
        System.out.println("Embaralhado: ");
        // System.out.println(data);
        // MergeSort
        long timeStartMergeSort = System.currentTimeMillis();
        mergeSort(data, data.size());
        // System.out.println(data);
        long timeEndMergeSort = System.currentTimeMillis();
        System.out.println("Tempo total: " + (timeEndMergeSort - timeStartMergeSort));
    }

}
