Given a set of N objects:
    - Union: connect two objects
    - Find / isConnected: is there a path connecting two objects.

Goal: Design a efficient data structure for union find where
    - Number of objects N can be huge
    - Number of operations/queries M can be huge
    - These queries can be mixed

API:
```
public class UF {
    UF(int N) {} // Constructor
    void union(int p, int q) // connect two objects p and q
    boolean isConnected(int p, int q) // Is there a path from p to q
    int find(int p) // Component Identifier for p
    int count() // Number of components
}
```

Variants:
1) Quick-find (Two objects are connected if they have same id)

Data Structures
    - Key[] ids of N objects

Problems
    - Init O(N), Union O(N), find O(1)
    - If M is too large this is of O(M*N) which is not scalable at all.

Reason - Union is too expensive

Why dont quadratic algorithms scale well?
    1) Rough standard
        - 10^9 ops per second
        - 10^9 words in main memory
        - So can touch all words in a second
    
    2) As computers become faster the problem size increases and with quadratic algo
        it takes that much longer.

2) Quick-Union (Two objects connected if their roots are same)

Data Structures
    - Key[] ids of N objects
    - id[i] is parent of i
    - root of i is id[id[id[...id[i]...]]]

Problems:
    - Now worst case of everything is O(N)
    - Comparision:
        - Quick Find (Union, Trees flat but expensive to do so.)
        - Quick Union (Tall trees, Find is too expensive.)

Improvements:
    1) Weighting (Always add the smaller tree to larger tree)
        - Keeps the trees balanced.
        - Depth of any Node x is at most lgN. Init O(N), Union O(lgN), Find O(lgN).

    2) Path Compression (Set id of each examined node to root to speed up further queries)
        - Turns it into O(N + Mlg*N). In practice can say linear like.
        - No linear time algorithm for Union-Find (Proven).