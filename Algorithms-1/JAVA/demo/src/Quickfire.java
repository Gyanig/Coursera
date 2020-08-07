import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Quickfire {
    private int[] id;

    //initialize
    public Quickfire(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    //connected or not
    public boolean connected(int p, int q) {
        return (id[p] == id[q]);
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    //join the nodes
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (pid == id[i]) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] arg) {
        int n = StdIn.readInt();
        Quickfire obj1 = new Quickfire(n);
        int k = n;
        while (k != 0) {
            k--;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (obj1.find(p) == obj1.find(q)) continue;
            obj1.union(p, q);
            StdOut.print(p + " " + q + "\n");
            for (int i = 0; i < n; i++) {
                System.out.print(obj1.id[i] + " ");
            }
        }
        k--;
    }
}

