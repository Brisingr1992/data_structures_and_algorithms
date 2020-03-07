package DynamicConnectivity;

public interface UF {
    public void union(int p, int q);
    public boolean isConnected(int p, int q);
    public int find(int p);
    public int count();
}