package DynamicConnectivity;

public class QuickUnion implements UF {
    private int[] ids;
    private int N;
    public QuickUnion(int N) {
        ids = new int[N];
        this.N = N;

        for (int i = 0; i < N; i++) ids[i] = i;
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        
        if (proot == qroot) return;

        N--;
        ids[proot] = qroot;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }

        return i;
    }

    public int count() {
        return N;
    }
}