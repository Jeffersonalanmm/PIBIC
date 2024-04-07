import java.util.Arrays;

import com.heapsort.BlackBox.BlackBox;
import com.heapsort.amazonQ.amazonQ;
import com.heapsort.chatGPT.chatGPT;
import com.heapsort.codeium.codeium;
import com.heapsort.gemini.gemini;
import com.heapsort.rosetta.rosetta;
import com.heapsort.theAlgorithms.theAlgorithms;

class Main{
    public static void main(String[] args){
        amazonQ amazonQ = new amazonQ();
        chatGPT chatGPT = new chatGPT();
        gemini gemini = new gemini();
        theAlgorithms theAlgorithms = new theAlgorithms();
      

        int array[] = {12, 11, 13, 5, 6, 7};
        Integer[] array2 = {12, 11, 13, 5, 6, 7};
        int n = array.length;

        amazonQ.sort(array);
        System.out.println("Array ordenado por AmazonQ:");
        printArray(array);

        BlackBox.heapify(array, n, 0);
        System.out.println("Array ordenado por BlackBox:");
        printArray(array);

        chatGPT.sort(array);
        System.out.println("Array ordenado por ChatGPT:");
        printArray(array);

        codeium.heapSort(array);
        System.out.println("Array ordenado por Codeium:");
        printArray(array);
        
        gemini.sort(array);
        System.out.println("Array ordenado por Gemini:");
        printArray(array);
        
        rosetta.heapSort(array);       
        System.out.println("Array ordenado por Rosetta:");
        printArray(array);
        
        int[] sortedArray = theAlgorithms.sort(array);
        System.out.println("Lista ordenada por The Algorithms: " + Arrays.toString(sortedArray));
    }
        // Método para imprimir um array
        static void printArray(int arr[]) {
            int n = arr.length;
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
}