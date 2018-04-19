import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JaydenStudiesTrees_Java {
    static ArrayList<Integer>[] adj;
    static int longest,endPoint;
    
    public static void dfs(int cur,int par,int d) {
        if (d > longest) {
            endPoint = cur;
            longest = d;
        }
        for (int nxt : adj[cur])
            if (nxt != par)
                dfs(nxt,cur,d + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String[] in;
        int N,i,x,y;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N + 1];
        for (i = 1;i <= N;i++)
            adj[i] = new ArrayList<>();
        
        for (i = 1;i < N;i++) {
            in = br.readLine().split(" ");
            x = Integer.parseInt(in[0]);
            y = Integer.parseInt(in[1]);
            adj[x].add(y);
            adj[y].add(x);
        }
        
        longest = -1; endPoint = 0;
        dfs(1,0,0);
        longest = -1;
        dfs(endPoint,0,0);
        
        System.out.println(longest);
    }
}
