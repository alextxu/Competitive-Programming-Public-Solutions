import java.util.*;
import java.io.*;

public class Test_Java {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        int w,i,j;
        String[] message = {"WELCOME","TO","CCC","GOOD","LUCK","TODAY"};
        String s;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        w = Integer.parseInt(br.readLine());
        
        i = 0;
        while (i < message.length) {
            j = 0;
            s = "";
            while (i < message.length && j + message[i].length() <= w) {
                j += message[i].length();
                j++;
                s += message[i];
                s += '.';
                i++;
            }
            s = s.substring(0,s.length() - 1);
            j = 0;
            if (s.contains(".")) {
                while (s.length() < w) {
                    while (s.charAt(j) != '.') {
                        j++;
                        j %= s.length();
                    }
                    s = s.substring(0,j) + '.' + s.substring(j);
                    while (s.charAt(j) == '.') {
                        j++;
                        j %= s.length();
                    }
                }
            }
            else {
                while (s.length() < w)
                    s += '.';
            }
            System.out.println(s);
        }
    }
}
