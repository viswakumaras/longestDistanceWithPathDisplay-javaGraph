import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    int V; // No. of vertices'
   static ArrayList<Integer> pathList = new ArrayList<>();


    // Pointer to an array containing adjacency lists
    ArrayList<ArrayList<AdjListNode>> adj;

    Graph(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int weight)
    {
        AdjListNode node = new AdjListNode(v, weight);
        adj.get(u).add(node); // Add v to u's list
    }

    // A recursive function used by longestPath. See below

    void topologicalSortUtil(Integer v, boolean[] visited,
                             Stack<Integer> stack)
    {

        // Mark the current node as visited
        visited[v] = true;


        // Recur for all the vertices adjacent to this vertex
        for (int i = 0; i<adj.get(v).size(); i++) {
            AdjListNode node = adj.get(v).get(i);
            if (!visited[node.getV()]) {
                topologicalSortUtil(node.getV(), visited, stack);
            }
        }

        // Push current vertex to stack which stores topological
        // sort
        stack.push(v);
    }

    // The function to find longest distances from a given vertex.

    void longestPath(Integer s,Integer des)
    {

        Map<Integer, String> cityNames = Main.map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        Stack<Integer> stack = new Stack<Integer>();
        int[] dist = new int[V];

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }



        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {

                topologicalSortUtil(i, visited, stack);


            }
        }
        // Initialize distances to all vertices as infinite and
        // distance to source as 0
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MIN_VALUE;

        dist[s] = 0;


        // Process vertices in topological order
        while (!stack.isEmpty())
        {
            // Get the next vertex from topological order
            int u = stack.peek();
            stack.pop();
            // Update distances of all adjacent vertices ;
            if (dist[u] != Integer.MIN_VALUE)
            {
                for (int i = 0; i<adj.get(u).size(); i++)
                {
                    AdjListNode node = adj.get(u).get(i);
                    if (dist[node.getV()] < dist[u] + node.getWeight()) {
                        dist[node.getV()] = dist[u] + node.getWeight();
                        if(node.getV()>s && node.getV()<=des){
                            pathList.add(u);
                        }
                    }

                }

            }


        }
        pathList.add(des);
   //     Arrays.copyOf(route, route.length-1);
        // Print the calculated longest distances
        for (int i = 0; i < V; i++) {


            if (i == des) {
                System.out.print("Longest distance --- "+dist[i]+" Source -");
            }

        }
       for(Integer x:pathList){
           System.out.println("  "+cityNames.get(x)+"   ");
       }
    }



}
