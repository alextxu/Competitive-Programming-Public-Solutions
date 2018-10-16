import java.io.*;
import java.util.*;
// DMOPC '16 Contest 4 P2 - Systests

public class Systests_Java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        int B,F,i,ans,startFail,endFail;
        int[] batchStart,batchEnd,batchPoints;
        int[] failedCases;
        ArrayList<Integer> noDuplicates;
        
        B = Integer.parseInt(br.readLine());
        batchStart = new int[B];
        batchEnd = new int[B];
        batchPoints = new int[B];
        
        for (i = 0;i < B;i++) {
            line = br.readLine().split(" ");
            batchStart[i] = Integer.parseInt(line[0]);
            batchEnd[i] = Integer.parseInt(line[1]);
            batchPoints[i] = Integer.parseInt(line[2]);
        }
        
        F = Integer.parseInt(br.readLine());
        failedCases = new int[F];
        for (i = 0;i < F;i++)
            failedCases[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(failedCases);
        
        noDuplicates = new ArrayList<>();
        for (i = 0;i < F;i++)
            if ((noDuplicates.isEmpty()) || (noDuplicates.get(noDuplicates.size() - 1) != failedCases[i]))
                noDuplicates.add(failedCases[i]);
                
        ans = 0;
        for (i = 0;i < B;i++) {
            startFail = Collections.binarySearch(noDuplicates,batchStart[i]);
            endFail = Collections.binarySearch(noDuplicates,batchEnd[i] + 1);
            if (startFail < 0)
                startFail = -startFail - 1;
            if (endFail < 0)
                endFail = -endFail - 1;
            
            if (startFail == endFail)
                ans += batchPoints[i];
        }
        
        System.out.println(ans);
        
        br.close();
    }
}
