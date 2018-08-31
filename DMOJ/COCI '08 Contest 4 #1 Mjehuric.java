import java.util.*;
import java.io.*;

public class Test_Java {
    static int[] array = new int[5];

    static boolean check() {
        for (int i = 0;i < array.length;i++)
            if (array[i] != i + 1)
                return false;
        return true;
    }
    
    static void printArray() {
        for (int i = 0;i < array.length;i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String[] in;
        int i;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine().split(" ");
        
        for (i = 0;i < 5;i++)
            array[i] = Integer.parseInt(in[i]);
        
        while (!check()) {
            for (i = 0;i < array.length - 1;i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    printArray();
                }
            }
        }
    }
}
