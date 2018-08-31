import java.util.*;
import java.io.*;

public class Test_Java {

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String line;
        int R = 10,C = 19;
        int i,j,k;
        char[][] map;
        int[] poiR,poiC;
        int[][][] distance;
        int curR,curC;
        int ans;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Integer> qr = new LinkedList<>(),qc = new LinkedList<>();
        
        br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[R + 2][C + 2];
        for (i = 0;i <= R + 1;i++)
            for (j = 0;j <= C + 1;j++)
                map[i][j] = '#';
        
        poiR = new int[12];
        poiC = new int[12];
        for (i = 1;i <= R;i++) {
            line = br.readLine();
            for (j = 1;j <= C;j++) {
                map[i][j] = line.charAt(j - 1);
                if (map[i][j] >= 'A' && map[i][j] <= 'L') {
                    poiR[map[i][j] - 'A'] = i;
                    poiC[map[i][j] - 'A'] = j;
                }
            }
        }
        
        distance = new int[12][R + 1][C + 1];
        for (i = 0;i < 12;i++) {
            curR = poiR[i];
            curC = poiC[i];
            for (j = 1;j <= R;j++)
                for (k = 1;k <= C;k++)
                    distance[i][j][k] = Integer.MAX_VALUE;
            distance[i][curR][curC] = 0;
            qr.add(curR);
            qc.add(curC);
            while (!qr.isEmpty()) {
                curR = qr.poll();
                curC = qc.poll();
                for (j = 0;j < 4;j++) {
                    int nxtR = curR + dir[j][0];
                    int nxtC = curC + dir[j][1];
                    if (map[nxtR][nxtC] != '#' && distance[i][curR][curC] + 1 < distance[i][nxtR][nxtC]) {
                        distance[i][nxtR][nxtC] = distance[i][curR][curC] + 1;
                        qr.add(nxtR);
                        qc.add(nxtC);
                    }
                }
            }
        }
        for (i = 0;i < 5;i++) {
            line = br.readLine();
            ans = 0;
            for (j = 1;j < line.length();j++)
                ans += distance[line.charAt(j - 1) - 'A'][poiR[line.charAt(j) - 'A']][poiC[line.charAt(j) - 'A']];
            System.out.println(ans);
        }
    }
}
