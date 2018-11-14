import java.util.*;
import java.io.*;

public class ZeroThatOut_Java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K,i,num,ans;
        ArrayList<Integer> arr;
        
        K = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        
        for (i = 0;i < K;i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0)
                arr.remove(arr.size() - 1);
            else
                arr.add(num);
        }
        
        ans = 0;
        for (int a : arr)
            ans += a;
        
        System.out.println(ans);
        
        br.close();
    }
}
