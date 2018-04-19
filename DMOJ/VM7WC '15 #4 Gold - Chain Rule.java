import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ChainRule_Java {
    
    public static class Pair implements Comparable<Pair> {
        int first,second;
        public Pair(int f,int s) {  // constructor
            this.first = f;
            this.second = s;
        }

        public int compareTo(Pair p) {  // comparison function for pq
            // Compare first then second
            if (p.first == this.first)
                return this.second - p.second;
            return this.first - p.first;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // Variables
        BufferedReader br;
        String[] in;    // stores splitted string input
        int N,M,i,A,B,t,cur,d,maxTime;
        ArrayList<Pair>[] adj;
        PriorityQueue<Pair> pq;
        int[] dist1,dist2;
        
        // Read the number of cities and roads
        br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        
        // Read the roads and store in adjacency list
        adj = new ArrayList[N];
        for (i = 0;i < N;i++)
            adj[i] = new ArrayList<>();
        for (i = 0;i < M;i++) {
            in = br.readLine().split(" ");
            A = Integer.parseInt(in[0]);
            B = Integer.parseInt(in[1]);
            t = Integer.parseInt(in[2]);
            adj[A].add(new Pair(B,t));
            adj[B].add(new Pair(A,t));
        }
        
        // Run Dijkstra's algorithm from node 0
        pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        dist1 = new int[N];
        for (i = 0;i < N;i++)
            dist1[i] = Integer.MAX_VALUE;
        dist1[0] = 0;
        while (!pq.isEmpty()) {
            cur = pq.peek().second; d = pq.peek().first; pq.remove();
            if (dist1[cur] < d) continue;
            for (Pair p : adj[cur]) {
                if (dist1[cur] + p.second < dist1[p.first]) {
                    dist1[p.first] = dist1[cur] + p.second;
                    pq.add(new Pair(dist1[p.first],p.first));
                }
            }
        }
        
        // Run Dijkstra's from N - 1
        pq.add(new Pair(0,N - 1));
        dist2 = new int[N];
        for (i = 0;i < N;i++)
            dist2[i] = Integer.MAX_VALUE;
        dist2[N - 1] = 0;
        while (!pq.isEmpty()) {
            cur = pq.peek().second; d = pq.peek().first; pq.remove();
            if (dist2[cur] < d) continue;
            for (Pair p : adj[cur]) {
                if (dist2[cur] + p.second < dist2[p.first]) {
                    dist2[p.first] = dist2[cur] + p.second;
                    pq.add(new Pair(dist2[p.first],p.first));
                }
            }
        }
        
        // Get maximum total time
        maxTime = 0;
        for (i = 0;i < N;i++)
            maxTime = Math.max(maxTime,dist1[i] + dist2[i]);
        
        // Output
        System.out.println(maxTime);
    }
    
}
