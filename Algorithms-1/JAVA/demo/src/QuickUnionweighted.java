import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionweighted {
    private int[] id;

    //initialize
    public QuickUnionweighted(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    //connected or not
    public boolean connected(int p, int q) {
        return (root(p) == root(q));
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
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String[] arg) {
        int n = StdIn.readInt();
        QuickUnionweighted obj1 = new QuickUnionweighted(n);
        int k = n;
        while (k != 0) {
            k--;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (obj1.find(p) == obj1.find(q)) continue;
            obj1.union(p, q);
            StdOut.print(p + " " + q + "\n");
            for (int i = 0; i < n; i++) {
                System.out.print(obj1.id[i]);
            }
        }


    }
}
