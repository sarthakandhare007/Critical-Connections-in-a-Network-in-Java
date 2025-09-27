Problem

You are given a network of n servers (numbered 0 to n-1) connected by connections (undirected edges).

A connection is critical if removing it disconnects the graph.

Return all critical connections.


---

Example

Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]


---

🔹 Intuition

This is a bridge-finding problem in a graph.

Use Tarjan’s Algorithm (DFS):

Maintain disc[u] = discovery time of node u.

Maintain low[u] = lowest discovery time reachable from u (via back-edges).

If for an edge (u, v), we find low[v] > disc[u], then (u, v) is a bridge (critical).



# Critical-Connections-in-a-Network-in-Java
