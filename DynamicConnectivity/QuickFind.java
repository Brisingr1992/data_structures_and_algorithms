package DynamicConnectivity;

public class QuickFind implements UF {
    private int[] ids;
    private int N;
    public QuickFind(int N) {
        ids = new int[N];
        this.N = N;

        for (int i = 0; i < N; i++) ids[i] = i;
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        
        if (proot == qroot) return;

        N--;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == proot) { ids[i] = qroot; }
        }
    }

    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    public int find(int p) {
        return ids[p];
    }

    public int count() {
        return N;
    }
}