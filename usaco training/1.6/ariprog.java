import java.io.*;
import java.util.*;

public class swap {
  static boolean debug = true;

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("swap.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(f.readLine());
    int a = Integer.parseInt(st.nextToken()) - 1;
    int b = Integer.parseInt(st.nextToken()) - 1;

    st = new StringTokenizer(f.readLine());
    int c = Integer.parseInt(st.nextToken()) - 1;
    int d = Integer.parseInt(st.nextToken()) - 1;

    int[] ar = new int[N];
    for (int i = 0; i < ar.length; i++) {
      ar[i] = i + 1;
    }

    // simulate
    for (int i = 0; i < K; i++) {

      // reverse a ~ b
      for (int j = 0; j <= (b - a) / 2; j++) {
        int temp = ar[a + j];
        ar[a + j] = ar[b - j];
        ar[b - j] = temp;
      }

      // reverse c ~ d
      for (int j = 0; j <= (d - c) / 2; j++) {
        int temp = ar[c + j];
        ar[c + j] = ar[d - j];
        ar[d - j] = temp;
      }

      if (debug) 
        System.out.println(i + " : " + Arrays.toString(ar));

      // check if the original state has been restored
      boolean backToOriginal = true;
      for (int j = 0; j < ar.length; j++) {
        if (ar[j] != j + 1) {
          backToOriginal = false;
          break;
        }
      }

      if (backToOriginal) {
        // repeats every (i+1) days
        K %= (i + 1);
        // so that it runs K more times.
        i = -1;
      }
    }

    for (int v : ar) {
      System.out.println(v);
      out.println(v);
    }
    out.close();

  }
}
