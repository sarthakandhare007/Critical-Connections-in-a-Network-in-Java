import java.util.*;

public class CriticalConnections {
    private List<List<Integer>> graph;
    private List<List<Integer>> result;
    private int[] disc, low;
    private int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (List<Integer> conn : connections) {
            int u = conn.get(0), v = conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        result = new ArrayList<>();
        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc, -1);

        time = 0;
        dfs(0, -1);

        return result;
    }

    private void dfs(int u, int parent) {
        disc[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (v == parent) continue; // skip edge to parent
            if (disc[v] == -1) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v)); // critical edge
                }
            } else {
                low[u] = Math.min(low[u], disc[v]); // back edge
            }
        }
    }

    // Quick test
    public static void main(String[] args) {
        CriticalConnections sol = new CriticalConnections();
        List<List<Integer>> connections = Arrays.asList(
            Arrays.asList(0,1),
            Arrays.asList(1,2),
            Arrays.asList(2,0),
            Arrays.asList(1,3)
        );
        System.out.println(sol.criticalConnections(4, connections)); // [[1,3]]
    }
}
