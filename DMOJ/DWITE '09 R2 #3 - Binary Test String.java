import java.util.*;
import java.io.*;

public class Test_Java {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String line,s;
        char a,b,c,d;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 0;tc < 5;tc++) {
            line = br.readLine();
            for (a = '0';a <= '1';a++) {
                for (b = '0';b <= '1';b++) {
                    for (c = '0';c <= '1';c++) {
                        for (d = '0';d <= '1';d++) {
                            s = Character.toString(a);
                            s += b;
                            s += c;
                            s += d;
                            if (!s.contains(line))
                                System.out.println(s);
                        }
                    }
                }
            }
        }
    }
}
