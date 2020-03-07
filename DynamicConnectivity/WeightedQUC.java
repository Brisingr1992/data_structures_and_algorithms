package DynamicConnectivity;

public class WeightedQUC implements UF {
    private int[] ids, sz;
    private int N;
    public WeightedQUC(int N) {
        ids = new int[N];
        sz = new int[N];
        this.N = N;

        for (int i = 0; i < N; i++) { ids[i] = i; sz[i] = 1; }
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        
        if (proot == qroot) return;

        N--;
        if (sz[proot] > sz[qroot]) {
            ids[qroot] = proot;
            sz[proot] += sz[qroot];
        } else {
            ids[proot] = qroot;
            sz[qroot] += sz[proot];
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }

        return i;
    }

    public int count() {
        return N;
    }
}