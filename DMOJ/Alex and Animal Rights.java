import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlexAndAnimalRights_Java {
    static int R,C;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public static void dfs(int r,int c) {
        int nr,nc;
        for (int i = 0;i < 4;i++) {
            nr = r + directions[i][0];
            nc = c + directions[i][1];
            if (grid[nr][nc] != '#' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr,nc);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String[] in;
        String line;
        int i,j;
        int ans;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine().split(" ");
        R = Integer.parseInt(in[0]);
        C = Integer.parseInt(in[1]);
        
        grid = new char[R + 2][C + 2];
        for (i = 0;i <= R + 1;i++)
            for (j = 0;j <= C + 1;j++)
                grid[i][j] = '#';
        for (i = 1;i <= R;i++) {
            line = br.readLine();
            for (j = 1;j <= C;j++) {
                grid[i][j] = line.charAt(j - 1);
            }
        }
        
        visited = new boolean[R + 2][C + 2];
        ans = 0;
        for (i = 1;i <= R;i++) {
            for (j = 1;j <= C;j++) {
                if (grid[i][j] == 'M' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i,j);
                    ans++;
                }
            }
        }
        
        System.out.println(ans);
    }
    
}
