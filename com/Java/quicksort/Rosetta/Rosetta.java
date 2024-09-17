import java.util.LinkedList;
import java.util.List;

public class Rosetta {
    public static <E extends Comparable<? super E>> List<E> quickSort(List<E> arr) {
        if (arr.isEmpty())
            return arr;
        else {
            E pivot = arr.get(0);

            List<E> less = new LinkedList<E>();
            List<E> pivotList = new LinkedList<E>();
            List<E> more = new LinkedList<E>();

            // Particionamento
            for (E i: arr) {
                if (i.compareTo(pivot) < 0)
                    less.add(i);
                else if (i.compareTo(pivot) > 0)
                    more.add(i);
                else
                    pivotList.add(i);
            }

            // Recursivamente ordena as sublistas
            less = quickSort(less);
            more = quickSort(more);

            // Concatena os resultados
            less.addAll(pivotList);
            less.addAll(more);
            return less;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new LinkedList<>();
        
        // Generate 1000 random values
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(1000)); // Random value between 0 and 999
        }

        // Sort the list
        list = quickSort(list);
    }
}
